package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import modelo.AccesoBBDD;
import modelo.ProyectoIntegrador;
import vista.DelProyect;

/**
 * Clase que implementa la interfaz ActionListener para el botón de Eliminar Proyecto.
 * Elimina el proyecto seleccionado de la lista de proyectos.
 */
public class DelProyBtnListener implements ActionListener {
	private JList<String> projectList;
	private DelProyect v;
	AccesoBBDD programa = new AccesoBBDD();
	
    /**
     * Constructor de la clase DelProyBtnListener.
     * @param projectList La lista de proyectos
     */
//    public DelProyBtnListener(JList<String> projectList) {
//        this.projectList = projectList;
//    }
    
    public DelProyBtnListener(DelProyect vista) {
    	this.v = vista;
    }
    
    /**
     * Método que se ejecuta al hacer clic en el botón de Eliminar Proyecto.
     * Elimina el proyecto seleccionado de la lista de proyectos.
     * @param e El evento de acción generado por el botón de Eliminar Proyecto.
     */
	@Override
    public void actionPerformed(ActionEvent e) {
		programa.getConexion();
		//para que no de nulo hay que inicializarlo!
		projectList = v.getProjectList();
        String selectedProy = projectList.getSelectedValue();
        //esto te devuelve un string de tipo "nombre - nota"
        //pero querríamos que devolviera un string de tipo "id - nombre - nota"
        //para poder en este momento hacer un substring y quedarnos con el id y trabajar con el id del proyecto
        
        String idProyecto = selectedProy.substring(0, selectedProy.indexOf("-"));
//        int numIdP = Integer.parseInt(idProyecto);
        
        //si selectedProy no es = -1, hay una opción seleccionada
        if (selectedProy != "") {
            int alerta = JOptionPane.showConfirmDialog(null, "¿Quieres borrar este proyecto?", "Alerta", JOptionPane.YES_NO_OPTION);
            if (alerta == JOptionPane.YES_OPTION) {
                delProyecto(idProyecto);
            }
        } else {
        	JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún proyecto,", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
	
	public void delProyecto(String id) {
		boolean resultado = programa.deleteProyecto(id);

		if (resultado) {
			// Muestra mensajes de confirmación o error según el resultado de la inserción del proyecto
			JOptionPane.showMessageDialog(v, "Proyecto eliminado.");
			ArrayList<ProyectoIntegrador> listaActualizada = programa.cargarProyectos("Select * from proyectoIntegrador");
			v.showProys(listaActualizada);
			//v.inicializarComponentes();
		} else {
			JOptionPane.showMessageDialog(v, "Error al eliminar proyecto: tiene alumnos asociados. Para eliminar el proyecto, elimina la asociación de alumnos con él primero.");
		}
	}

}



//package control;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//
//import javax.swing.DefaultListModel;
//import javax.swing.JList;
//import javax.swing.JOptionPane;
//
//import modelo.AccesoBBDD;
//import modelo.ProyectoIntegrador;
//
///**
// * Clase que implementa la interfaz ActionListener para el botÃ³n de Eliminar Proyecto.
// * Elimina el proyecto seleccionado de la lista de proyectos.
// */
//public class DelProyBtnListener implements ActionListener {
//	private JList<String> projectList;
//	AccesoBBDD programa = new AccesoBBDD();
//	
//    /**
//     * Constructor de la clase DelProyBtnListener.
//     * @param projectList La lista de proyectos
//     */
//    public DelProyBtnListener(JList<String> projectList) {
//        this.projectList = projectList;
//    }
//    
//    
//    
//    /**
//     * MÃ©todo que se ejecuta al hacer clic en el botÃ³n de Eliminar Proyecto.
//     * Elimina el proyecto seleccionado de la lista de proyectos.
//     * @param e El evento de acciÃ³n generado por el botÃ³n de Eliminar Proyecto.
//     */
//	@Override
//    public void actionPerformed(ActionEvent e) {
//		programa.getConexion();
//
//        int selectedProy = projectList.getSelectedIndex();
//        //si selectedProy no es = -1, hay una opciÃ³n seleccionada
//        if (selectedProy != -1) {
//            int alerta = JOptionPane.showConfirmDialog(null, "¿Quieres borrar este proyecto?", "Alerta", JOptionPane.YES_NO_OPTION);
//            if (alerta == JOptionPane.YES_OPTION) {
//        	    boolean resultado = programa.deleteProyecto("");//cambiar
//        	    
//                DefaultListModel<String> model = (DefaultListModel<String>) projectList.getModel();
//                model.remove(selectedProy);
//            }
//        } else {
//        	JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún proyecto,", "Error", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//	
//	/**
//     * MÃ©todo que obtiene la lista de proyectos a borrar desde la base de datos.
//     * @return Una lista de objetos ProyectoIntegrador que representa los proyectos cargados desde la base de datos.
//     */
//	public ArrayList<ProyectoIntegrador> borrarProys() {
//        String query = "SELECT * FROM proyectoIntegrador";
////		return programa.obtenerDatosProyectoDesdeBD();
//        return programa.cargarProyectos("SELECT * FROM proyecto");
//	}
//
//}
