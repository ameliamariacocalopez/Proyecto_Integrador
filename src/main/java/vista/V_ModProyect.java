package vista;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.*;
import control.CloseWindowBtnListener;
import control.saveProyBtnListener;
import modelo.AccesoBBDD;
import modelo.Alumno;
import modelo.ProyectoIntegrador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Ventana de inicio de sesiÃ³n para administradores y estudiantes
 */
public class V_ModProyect extends JFrame {
	ImageIcon pacImg = new ImageIcon("img/pacTrans.png");
	JLabel imgLbl = new JLabel(pacImg);
	
	private JLabel tituloLbl, idLbl, urlLbl, notaLbl, fechaLbl, cursoLbl;
	
	JButton saveButton;
	private JLabel nombreProyLbl;
	private JLabel idTxtF;
	private JLabel  nombreProyTxtF;
	private JTextField urlTxtF;
	private JTextField notaTxtF;
	private JLabel  fechaTxtF;
	private JLabel  cursoTxtF;
	private DefaultComboBoxModel<String> listaAlumns;
	private DefaultComboBoxModel<String> listaAlumns2;
	private DefaultComboBoxModel<String> listaAlumns3;
	JComboBox<String> comboBoxEstudiantes;
	JComboBox<String> comboBoxEstudiantes2;
	JComboBox<String> comboBoxEstudiantes3;
	ArrayList<Alumno> listaAlumnosDelProyecto;
	ProyectoIntegrador proyectoSeleccionado;
	
	/**
     * CONSTRUCTOR
     */
	public V_ModProyect() {
		super("Modificar Proyecto - Edit");
		getContentPane().setBackground(new Color(195, 219, 255));
		inicializarComponentes();
	}
	
	/**
	 * Inicializa los componentes y los aÃ±ade al content pane
	 */
	public void inicializarComponentes() {
		getContentPane().setLayout(null);

		tituloLbl = new JLabel("MODIFICA EL PROYECTO ");
		tituloLbl.setFont(new Font("Impact", Font.PLAIN, 31));
		tituloLbl.setBounds(266, 22, 326, 29);
	    getContentPane().add(tituloLbl);
		
		idLbl = new JLabel("ID: ");
		idLbl.setBounds(60, 74, 73, 20);
	    getContentPane().add(idLbl);

		urlLbl = new JLabel("URL: ");
		urlLbl.setBounds(60, 139, 73, 20);
	    getContentPane().add(urlLbl);

		notaLbl = new JLabel("Nota: ");
		notaLbl.setBounds(60, 169, 73, 20);
	    getContentPane().add(notaLbl);

		fechaLbl = new JLabel("Fecha: ");
		fechaLbl.setBounds(60, 199, 73, 20);
	    getContentPane().add(fechaLbl);

		cursoLbl = new JLabel("Curso: ");
		cursoLbl.setBounds(60, 230, 73, 20);
	    getContentPane().add(cursoLbl);
		
		idTxtF = new JLabel();
		idTxtF.setBounds(209, 75, 248, 20);
	    getContentPane().add(idTxtF);

		nombreProyTxtF = new JLabel();
		nombreProyTxtF.setBounds(209, 110, 248, 20);
	    getContentPane().add(nombreProyTxtF);

		urlTxtF = new JTextField();
		urlTxtF.setBounds(209, 140, 248, 20);
	    getContentPane().add(urlTxtF);

		notaTxtF = new JTextField();
		notaTxtF.setBounds(209, 170, 248, 20);
	    getContentPane().add(notaTxtF);

		fechaTxtF = new JLabel();
		fechaTxtF.setBounds(209, 200, 248, 20);
	    getContentPane().add(fechaTxtF);

		cursoTxtF = new JLabel();
		cursoTxtF.setBounds(209, 231, 248, 20);
	    getContentPane().add(cursoTxtF);
	    
		saveButton = new JButton("Guardar cambios");
		saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		saveButton.setBounds(457, 306, 148, 29);
//		saveButton.setLocation(221, 570);
		
		listaAlumns = new DefaultComboBoxModel<String>();
		listaAlumns2 = new DefaultComboBoxModel<String>();
		listaAlumns3 = new DefaultComboBoxModel<String>();
		
		comboBoxEstudiantes = new JComboBox<String>(listaAlumns);
		comboBoxEstudiantes.setBounds(595, 139, 202, 20);
		getContentPane().add(comboBoxEstudiantes);

		comboBoxEstudiantes2 = new JComboBox<String>(listaAlumns2);
		comboBoxEstudiantes2.setBounds(595, 107, 202, 20);
		getContentPane().add(comboBoxEstudiantes2);

		comboBoxEstudiantes3 = new JComboBox<String>(listaAlumns3);
		comboBoxEstudiantes3.setBounds(595, 74, 202, 20);
		getContentPane().add(comboBoxEstudiantes3);
		
		
		
		//listeners
		saveProyBtnListener escuchador1 = new saveProyBtnListener(this);
		saveButton.addActionListener(escuchador1);	    
		CloseWindowBtnListener escuchador = new CloseWindowBtnListener(null, this, null);
		saveButton.addActionListener(escuchador);	    
		getContentPane().add(saveButton);
		
		JButton closeButton = new JButton("Cerrar");
		closeButton.setBounds(282, 306, 107, 29);
		getContentPane().add(closeButton);
		
		closeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				desactivar();
			}
		});

		nombreProyLbl = new JLabel("Nombre del Proyecto: ");
		nombreProyLbl.setBounds(60, 109, 133, 20);
		getContentPane().add(nombreProyLbl);
		
		JLabel AlumnoLbl_1 = new JLabel("Alumnno1");
		AlumnoLbl_1.setBounds(512, 74, 73, 20);
		getContentPane().add(AlumnoLbl_1);
		
		JLabel AlumnoLbl_1_1 = new JLabel("Alumno2");
		AlumnoLbl_1_1.setBounds(512, 110, 73, 20);
		getContentPane().add(AlumnoLbl_1_1);
		
		JLabel AlumnoLbl_1_2 = new JLabel("Alumno3");
		AlumnoLbl_1_2.setBounds(512, 139, 73, 20);
		getContentPane().add(AlumnoLbl_1_2);
	    
	    setVisible(true);
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(834, 381);
	}
	
	

	public void showAlumnos(ArrayList<Alumno> lista) {
		listaAlumns.addElement("--");
		listaAlumns2.addElement("--");
		listaAlumns3.addElement("--");
		for (Alumno p : lista) {
			int m = p.getNumExpediente();
			System.out.println("expediente: "+m);

			listaAlumns.addElement(p.toString());
			if (listaAlumnosDelProyecto.size()>=1 && listaAlumnosDelProyecto.get(0).getNumExpediente()==m) {
				listaAlumns.setSelectedItem(p.toString());
				System.out.println("Alumno 1: "+p.toString());
			}
			listaAlumns2.addElement(p.toString());
			if (listaAlumnosDelProyecto.size()>=2 && listaAlumnosDelProyecto.get(1).getNumExpediente()==m) {
				listaAlumns2.setSelectedItem(p.toString());
				System.out.println("Alumno 2: "+p.toString());
			}
			listaAlumns3.addElement(p.toString());
			if (listaAlumnosDelProyecto.size()>=3 && listaAlumnosDelProyecto.get(2).getNumExpediente()==m) {
				listaAlumns3.setSelectedItem(p.toString());
				System.out.println("Alumno 3: "+p.toString());
			}
			//System.out.println(p.getNombre());
				
			
		}

	}
	
	
	public void setAlumnosDelProyecto(ArrayList<Alumno> lista) {
		listaAlumnosDelProyecto = lista;
	}

	public JLabel getIdTxtF() {
		return idTxtF;
	}

	public JLabel getNombreProyTxtF() {
		return nombreProyTxtF;
	}

	public JTextField getUrlTxtF() {
		return urlTxtF;
	}

	public JTextField getNotaTxtF() {
		return notaTxtF;
	}

	public JLabel getFechaTxtF() {
		return fechaTxtF;
	}

	public JLabel getCursoTxtF() {
		return cursoTxtF;
	}

	

	public JComboBox<String> getComboBoxEstudiantes() {
		return comboBoxEstudiantes;
	}

	public void setComboBoxEstudiantes(JComboBox<String> comboBoxEstudiantes) {
		this.comboBoxEstudiantes = comboBoxEstudiantes;
	}

	public JComboBox<String> getComboBoxEstudiantes2() {
		return comboBoxEstudiantes2;
	}

	public void setComboBoxEstudiantes2(JComboBox<String> comboBoxEstudiantes2) {
		this.comboBoxEstudiantes2 = comboBoxEstudiantes2;
	}

	public JComboBox<String> getComboBoxEstudiantes3() {
		return comboBoxEstudiantes3;
	}

	public void setComboBoxEstudiantes3(JComboBox<String> comboBoxEstudiantes3) {
		this.comboBoxEstudiantes3 = comboBoxEstudiantes3;
	}
	
	/**
	 * Hace toda la pÃ¡gina visible
	 */
	public void hacerVisible() {
		setVisible(true);
	}
	public void desactivar () {
		setVisible(false);
	}
	
	public void setProyectoSeleccionado(ProyectoIntegrador p) {
		proyectoSeleccionado = p;
	}
	
	public ProyectoIntegrador getProyectoSeleccionado() {
		return proyectoSeleccionado;
	}
	
	public ArrayList<Alumno> getListaAlumnos(){
		return listaAlumnosDelProyecto;
	}
	
	/**
	 * Recoge todos los alumnos de la lista
	 * 
	 * @param lista
	 */
	
}
