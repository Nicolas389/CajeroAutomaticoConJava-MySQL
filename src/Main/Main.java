package Main;

import Clases.Cajero;
import Clases.Cliente;
import Metodos.Metodos;
import Vistas.JFInicio;

public class Main {

    public static void main(String[] args) {
        /* JFInicio in = new JFInicio();
        in.setVisible(true); */

        Cliente a = new Cliente();
        Cajero c =  new Cajero();
        Metodos met = new Metodos();
        
       String usuario = a.tomarUsuario("2-15148978-3");
        System.out.println(usuario);
 }
}
