
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
    public static final String URL = "jdbc:mysql://localhost:3306/banco";
    public static final String USER = "root";  // id19822454_root
    public static final String CLAVE = ""; // fd$4<A~TeCqGN(z\
    public  Connection con = null;

    
    /**
     * metodo para conectar con la BBD
     * @return 
     */
    public Connection getConexion() {
         

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, CLAVE);
             System.out.println("Conexion establecida");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
      return con;
    }
    
    /**
     * metodo para desconectar con la BBD
     * @return 
     */
    public Connection Desconectar(){
        
       
        try {
            con.close();
             System.out.println("desconectado");
        } catch (SQLException ex) {
            System.out.println("error");
        }
        return con;
    }
}
