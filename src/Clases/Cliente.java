package Clases;

import Metodos.Metodos;
import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Cliente extends Persona {

    // para manejo de base de datos
    Connection con = null;
    PreparedStatement ps;
    Conexion conectar = new Conexion();
    ResultSet rs;

    public Cliente(String usuario, int contra, int saldo, String cbu, String alias) {

        this.usuario = usuario;
        this.contra = contra;
        this.cbu = cbu;

    }

    public Cliente() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContra(int contra) {
        this.contra = contra;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getContra() {
        return contra;
    }

    public String getCbu() {
        return cbu;
    }

    public int getId() {
        return id;
    }

    public int getSaldo() {
        return saldo;
    }

    public int iniciarSesion(String txtUsuario, int txtcontra) {

        Metodos met = new Metodos();
        int iu = 0;

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement("select idUsuario,usuario,contraseña,saldo"
                    + " from clientes where usuario=? and contraseña= ?");
            ps.setString(1, txtUsuario);
            ps.setInt(2, txtcontra);
            rs = ps.executeQuery();

            while (rs.next()) {

                iu = rs.getInt("idUsuario");
                String us = rs.getString("usuario");
                int con = rs.getInt("contraseña");
                int sal = rs.getInt("saldo");

                setId(iu);
                setUsuario(us);
                setContra(con);
                setSaldo(sal);

            }
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
        conectar.Desconectar();
        return iu;
    }

    /**
     * Metodo para cambiar clave. Con intercepcion de que no sea igual a la
     * contraseña anterior
     */
    public void CambiarContra(int Nueva, int Repeticion) {
        Metodos met = new Metodos();

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement("UPDATE clientes SET contraseña = ? WHERE idUsuario = ?;");

            if (Nueva != Repeticion) {
                met.MensajeError("Las contraseñas ingresadas no son iguales.");
            } else if (Nueva == contra) {
                met.MensajeError("La nueva contraseña no puede ser igual a la anterior.");
            } else {
                ps.setInt(1, Nueva);
                ps.setInt(2, id);
                ps.executeUpdate();
                met.OperacionCompletada();

            }
        } catch (Exception e) {
            met.MensajeError("error: " + e.getMessage());
        }

        conectar.Desconectar();

    }

    /**
     * Metodo que modifica el saldo cuando el cliente retira efectivo y en el
     * total disponible en el cajero
     */
    public void Retirar(int retiro) {

        Metodos met = new Metodos();
        Cajero caj = new Cajero();
        int saldoCajero = caj.mostrarSaldo();

        try {

            con = conectar.getConexion();
            ps = con.prepareStatement("UPDATE clientes SET saldo = (saldo-?) WHERE idUsuario = ?;");

            if (saldo < retiro) {
                met.MensajeError("No tiene el saldo suficiente para realizar la operacion.");
            } else if (saldoCajero < retiro) {
                met.MensajeError("El cajero no cuenta con el efectivo para realizar la operacion.\n Intente con otro");
            } else {
                ps.setInt(1, retiro);
                ps.setInt(2, id);
                ps.executeUpdate();
                saldo = saldo - retiro;
                met.OperacionCompletada();
            }
        } catch (Exception e) {
            met.MensajeError("error: " + e.getMessage());
        }

        conectar.Desconectar();

    }

    /**
     * Metodo que registra en el saldo cuando el cliente deposita efectivo y en
     * el total disponible en el cajero
     */
    public void Depositar(int deposito) {
        Metodos met = new Metodos();
        Cajero caj = new Cajero();

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement("UPDATE clientes SET saldo = (saldo+?) where idUsuario= ?");
            ps.setInt(1, deposito);
            ps.setInt(2, id);
            ps.executeUpdate();
            saldo = saldo + deposito;

        } catch (Exception e) {
            met.MensajeError("Error al conectar con la base de datos.");
        }

        conectar.Desconectar();
    }

    public int chequerCbu(String numeroCbu) {

        Metodos met = new Metodos();
        int idUsuario = 0;

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement("select idUsuario from clientes where cbu = ?");
            ps.setString(1, numeroCbu);
            rs = ps.executeQuery();

            while (rs.next()) {
                idUsuario = rs.getInt("idUsuario");
            }

        } catch (Exception e) {
            met.MensajeError("Error al conectar con la base de datos.");
        }

        conectar.Desconectar();

        return idUsuario;
    }

    public void procesarTransferencia(int monto, String cbu) {

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement("UPDATE clientes SET saldo = (saldo+?) WHERE cbu = ?;");
            ps.setInt(1, monto);
            ps.setString(2, cbu);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        conectar.Desconectar();
    }

    public String tomarUsuario(String cbu) {

        String Usuario = "";

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement("select usuario from clientes where cbu = ?");
            ps.setString(1, cbu);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario = rs.getString("usuario");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        conectar.Desconectar();

        return Usuario;
    }

    /**
     * Metodo que registra en el saldo cuando el cliente realiza una
     * transferencia
     */
    public void Transferencia(int transf, String cbu) {
        Metodos met = new Metodos();
        String User = tomarUsuario(cbu);

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement("UPDATE clientes SET saldo = (saldo-?) WHERE idUsuario = ?;");
            if (saldo < transf) {
                met.MensajeError("No tiene el saldo suficiente para realizar la operacion.");
            } else {
                ps.setInt(1, transf);
                ps.setInt(2, id);
                ps.executeUpdate();
                saldo = saldo - transf;
                procesarTransferencia(transf, cbu);
                registrarMovimiento("Transf", transf * -1);
                registrarMovimiento("Transf", transf, User);

                met.OperacionCompletada();
            }
        } catch (Exception e) {
            met.MensajeError("error: " + e.getMessage());
        }
        conectar.Desconectar();

    }

    public int mostrarSaldo() {
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement("select saldo from clientes where idUsuario =?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                saldo = rs.getInt("saldo");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        conectar.Desconectar();
        return saldo;
    }

    public void registrarMovimiento(String movimiento, int monto) {

        Metodos met = new Metodos();
        Cajero caj = new Cajero();

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement("insert into movimientos(Usuario,tipoMovimiento,fecha,saldoMovimiento,saldoCajero) values (?,?,?,?,?)");
            ps.setString(1, usuario);
            ps.setString(2, movimiento);
            ps.setString(3, met.TomarFecha());
            ps.setInt(4, monto);
            ps.setInt(5, caj.mostrarSaldo());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        conectar.Desconectar();

    }

    public void registrarMovimiento(String movimiento, int monto, String Usuario) {

        Metodos met = new Metodos();
        Cajero caj = new Cajero();

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement("insert into movimientos(Usuario,tipoMovimiento,fecha,saldoMovimiento,saldoCajero) values (?,?,?,?,?)");
            ps.setString(1, Usuario);
            ps.setString(2, movimiento);
            ps.setString(3, met.TomarFecha());
            ps.setInt(4, monto);
            ps.setInt(5, caj.mostrarSaldo());
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        conectar.Desconectar();

    }

    public DefaultTableModel mostrarMovimientos() {

        DefaultTableModel modelo = new DefaultTableModel();
        String[] registros = new String[4];
        String[] columnas = new String[4];

        columnas[0] = "Usuario";
        columnas[1] = "Operacion";
        columnas[2] = "Fecha";
        columnas[3] = "Saldo";

        modelo.addColumn(columnas[0]);
        modelo.addColumn(columnas[1]);
        modelo.addColumn(columnas[2]);
        modelo.addColumn(columnas[3]);

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement("select Usuario,tipoMovimiento,fecha,saldoMovimiento from movimientos where Usuario = ? ");
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("Usuario");
                registros[1] = rs.getString("tipoMovimiento");
                registros[2] = rs.getString("fecha");
                registros[3] = Integer.toString(rs.getInt("saldoMovimiento"));
                modelo.addRow(registros);

            }
        } catch (Exception e) {
        }
        conectar.Desconectar();
        return modelo;
    }

    public DefaultTableModel mostrarUsuarios() {

        DefaultTableModel modelo = new DefaultTableModel();
        String[] registros = new String[3];
        String[] columnas = new String[3];

        columnas[0] = "Usuario";
        columnas[1] = "Contraseña";
        columnas[2] = "CBU";

        modelo.addColumn(columnas[0]);
        modelo.addColumn(columnas[1]);
        modelo.addColumn(columnas[2]);

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement("select Usuario,Contraseña,cbu from clientes");
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("usuario");
                registros[1] = rs.getString("contraseña");
                registros[2] = rs.getString("cbu");

                modelo.addRow(registros);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        conectar.Desconectar();
        return modelo;
    }

    public void CrearUsuario(String User, int contraseña) {

        String cbu = CrearCbu();
        
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement("insert into clientes(usuario,contraseña,saldo,cbu) Values(?,?,?,?)");
            ps.setString(1, User);
            ps.setInt(2, contraseña);
            ps.setInt(3, 0);
            ps.setString(4, cbu);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null,"Sus datos de cuenta son:"+ "\nUsuario: "+ User + "\nContraseña: "
                    + contraseña + "\nCBU: "+ cbu);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        conectar.Desconectar();
    }

    public String CrearCbu() {
        
        String cbu = " ";
        int n1 = (int) (Math.random() * 16+12);
        int n2 = (int) (Math.random() * 999999+100000);
        int n3 = (int) (Math.random() * 9);
        
        cbu = "2-" + n1 + n2 + "-" + n3;

        return cbu;
    }

}
