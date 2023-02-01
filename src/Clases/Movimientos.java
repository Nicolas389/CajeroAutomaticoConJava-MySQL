package Clases;

import Conexion.Conexion;
import Metodos.Metodos;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Movimientos {

    String usuario;
    String tipoMovimiento;
    String fecha;
    int saldoMovimiento;
    int saldoCajero;

    // para conexion
    Connection con = null;
    PreparedStatement ps;
    Conexion conectar = new Conexion();

    public Movimientos(String usuario, String tipoMovimiento, String fecha, int saldoMovimiento, int saldoCajero) {
        this.usuario = usuario;
        this.tipoMovimiento = tipoMovimiento;
        this.fecha = fecha;
        this.saldoMovimiento = saldoMovimiento;
        this.saldoCajero = saldoCajero;
    }

    public Movimientos() {
    }

    public void MovimientoCliente(String cliente, String tipoMovimiento, int saldoMovimiento) {

        Metodos met = new Metodos();
        Cajero caj = new Cajero();

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement("INSERT INTO movimientos(Usuario,tipoMovimiento,fecha,saldoMovimiento)"
                    + " VALUES(?,?,?,?);");

            ps.setString(1, cliente);
            ps.setString(2, tipoMovimiento);
            ps.setString(3, met.TomarFecha());
            ps.setInt(4, saldoMovimiento);

        } catch (Exception e) {
            met.MensajeError("Error al conectar con la base de datos.");
        }

    }

}
