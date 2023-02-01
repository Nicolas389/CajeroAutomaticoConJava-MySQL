package Metodos;

import Clases.Cajero;
import Clases.Cliente;
import java.awt.event.KeyEvent;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Clase que creo para crear metodos para acciones que repito varias veces
 * durante el desarrollo del programa
 */
public class Metodos {

    Cliente cli = new Cliente();
    Cajero admin = new Cajero();

    public Metodos() {
    }

    /**
     * Metodo para limpiar cajas de texto
     */
    public void LimpiarCajas(JTextField uno, JTextField dos) {

        uno.setText(null);
        dos.setText(null);
    }

    /**
     * Metodo para activar el boton para ingresar informacion. Depende de que se
     * llenen las cajas de texto para que se active el boton
     */
    public void ActivarIngresar(JTextField uno, JTextField dos, JButton nombreBoton) {

        if (!uno.getText().isEmpty() && !dos.getText().isEmpty()) {
            nombreBoton.setEnabled(true);
        }

    }

    /**
     * metodo para informar de un error
     */
    public void MensajeError(String texto) {

        JOptionPane.showMessageDialog(null, texto,
                "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * metodo para informar de una operacion se realizo con exito
     *
     */
    public void OperacionCompletada() {

        JOptionPane.showMessageDialog(null, "Operacion realizada con exito.", "OPERACION COMPLETADA",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * metodo que retorna un valor, para usar en ocasiones en donde el usuario
     * tenga que elegir entre si o no
     */
    public int Confirmacion(String Mensaje, String titulo) {

        int valor = JOptionPane.showConfirmDialog(null, Mensaje, titulo,
                JOptionPane.YES_NO_OPTION);

        return valor;
    }

    /**
     * metodo para bloquear caracteres en una caja de texto
     */
    public void BloquearCaracteres(KeyEvent evt, int RangoMinimo, int RangoMaximo) {

        int key = evt.getKeyChar();

        boolean numeros = key >= RangoMinimo & key <= RangoMaximo;

        if (!numeros) {
            evt.consume();
        }
    }

    /**
     * metodo para tomar la fecha y hora del momento en que se ejecuta una
     * accion y lo retorna
     */
    public String TomarFecha() {

        String a = ZonedDateTime.now(ZoneId.of("America/Argentina/Catamarca"))
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));      
        
        String fecha = a;
        
        return fecha;
    }

    

}
