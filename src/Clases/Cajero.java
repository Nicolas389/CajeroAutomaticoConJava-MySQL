/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Conexion.Conexion;
import Metodos.Metodos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class Cajero {

    String usuario;
    int monto;

    // para manejo de base de datos
    Connection con = null;
    PreparedStatement ps;
    Conexion conectar = new Conexion();
    ResultSet rs;

    public Cajero(String usuario, int monto) {
        this.usuario = usuario;
        this.monto = monto;

    }

    public Cajero() {
    }

    public void sumarMontoCajero(int deposito) {

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement("update cajero set montoCajero = (montoCajero + ?) where idCajero = 1");
            ps.setInt(1, deposito);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void restarMontoCajero(int retiro) {

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement("update cajero set montoCajero = (montoCajero - ?) where idCajero = 1");
            ps.setInt(1, retiro);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public int mostrarSaldo() {

        int saldo = 0;

        try {
            con = conectar.getConexion();
            ps = con.prepareStatement("select montoCajero from cajero;");
            rs = ps.executeQuery();
            while (rs.next()) {
                saldo = rs.getInt("montoCajero");

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return saldo;
    }

    public DefaultTableModel mostrarMovimientos() {

        DefaultTableModel modelo = new DefaultTableModel();
        String[] columnas = new String[5];
        String[] registros = new String[5];
        
        columnas[0] = "Usuario";
        columnas[1] = "Tipo Mov.";
        columnas[2] = "Fecha";
        columnas[3] = "Movimiento";
        columnas[4] = "Saldo Cajero";
        
        modelo.addColumn(columnas[0]);
        modelo.addColumn(columnas[1]);
        modelo.addColumn(columnas[2]);
        modelo.addColumn(columnas[3]);
        modelo.addColumn(columnas[4]);        
        
        try {
            con = conectar.getConexion();
            ps = con.prepareStatement("select Usuario,tipoMovimiento,fecha,saldoMovimiento,saldoCajero from movimientos");
            rs = ps.executeQuery();
            while (rs.next()) {
             registros[0] = rs.getString("Usuario");
             registros[1] = rs.getString("tipoMovimiento");
             registros[2] = rs.getString("fecha");
             registros[3] = Integer.toString(rs.getInt("saldoMovimiento"));
             registros[4] = Integer.toString(rs.getInt("saldoCajero"));
             
             modelo.addRow(registros);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return modelo;
    }

}
