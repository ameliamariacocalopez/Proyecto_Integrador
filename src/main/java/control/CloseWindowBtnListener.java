package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.AddAlumn;
import vista.OpenConsulProy;
import vista.V_ModProyect;

/**
 * Clase que implementa la interfaz ActionListener para el botón de Cerrar Ventana.
 * Cierra la ventana correspondiente al hacer clic en el botón.
 */
public class CloseWindowBtnListener implements ActionListener {
    private OpenConsulProy closeWindow; // Ventana OpenConsulProy a cerrar
    private V_ModProyect closeWindow2; // Ventana V_ModProyect a cerrar
    private AddAlumn closeWindow3; // Ventana AddAlumn a cerrar
    
    /**
     * Constructor de la clase CloseWindowBtnListener.
     * @param closeWindow Ventana OpenConsulProy a cerrar
     * @param closeWindow2 Ventana V_ModProyect a cerrar
     * @param closeWindow3 Ventana AddAlumn a cerrar
     */
    public CloseWindowBtnListener(OpenConsulProy closeWindow, V_ModProyect closeWindow2, AddAlumn closeWindow3) {
        this.closeWindow = closeWindow;
        this.closeWindow2 = closeWindow2;
        this.closeWindow3 = closeWindow3;
    }

    /**
     * Método que se ejecuta al hacer clic en el botón de Cerrar Ventana.
     * Cierra la ventana correspondiente.
     * @param e El evento de acción generado por el botón de Cerrar Ventana.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (closeWindow != null) {
            closeWindow.dispose(); // Cierra la ventana OpenConsulProy
        }
        if (closeWindow2 != null) {
            closeWindow2.dispose(); // Cierra la ventana V_ModProyect
        }
        if (closeWindow3 != null) {
            closeWindow3.dispose(); // Cierra la ventana AddAlumn
        }
    }
}
