package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import modelo.AccesoBBDD;
import vista.OpenConsulProy;

public class ConsulBtnListener implements ActionListener {
    private JList<String> listaProy;
	AccesoBBDD programa = new AccesoBBDD();
    
    public ConsulBtnListener(JList<String> listaProy) {
        this.listaProy = listaProy;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
        //recoge el item seleccionado 
        String selectedProject = listaProy.getSelectedValue();
//      int selectedProject = listaProy.getSelectedIndex();

        if (selectedProject != null) {
            System.out.println("Proyecto seleccionado: " + selectedProject);
    		OpenConsulProy modProyWindow = new OpenConsulProy();
    		modProyWindow.setVisible(true);
        } else {
            System.out.println("No hay ningún proyecto seleccionado.");
        }		
		
		//Aquí no recogemos el TextField, recogemos los datos de la BBDD
//      JTextField idTxtF = modProyWindow.getIdTxtF();
//    	JTextField nombreProyTxtF = modProyWindow.getNombreProyTxtF();
//    	JTextField urlTxtF = modProyWindow.getUrlTxtF();
//    	JTextField notaTxtF = modProyWindow.getNotaTxtF();
//    	JTextField fechaTxtF = modProyWindow.getFechaTxtF();
//    	JTextField cursoTxtF = modProyWindow.getCursoTxtF();
//    	JTextField grupoTxtF = modProyWindow.getGrupoTxtF();

    	
	}
}
