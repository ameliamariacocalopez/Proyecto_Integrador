package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import control.CloseWindowBtnListener;
import control.ConsulBtnListener;
import control.EditStdntBtnListener;
import modelo.Alumno;
import modelo.ProyectoIntegrador;
import java.awt.Font;

/**
 * Clase que representa la ventana de aÃ±adir alumnos.
 */
public class AddAlumn extends JFrame {
	private JLabel numExpLbl;
	private JLabel idLbl;
	private JLabel nombreLbl;
	private JLabel apellidosLbl;
	private JLabel showNumExp;
	private JLabel showId;
	private JLabel showNombre;
	private JLabel showApellidos;

	private JList<String> projectList;
	private DefaultListModel<String> listaProyectos;
	Alumno alumno;

	 
	
	private JButton saveButton;
	private JLabel tituloLbl;

	/**
	 * Constructor de la clase AddAlumn. Inicializa los componentes de la ventana.
	 */
	public AddAlumn(Alumno a) {
		super("Editar Alumnos");
		alumno = a;
		getContentPane().setBackground(new Color(195, 219, 255));
		inicializarComponentes();
	}

	/**
	 * Inicializa los componentes de la ventana.
	 */
	public void inicializarComponentes() {
		listaProyectos = new DefaultListModel<>();

		getContentPane().setLayout(null);
		projectList = new JList<String>(listaProyectos);

		numExpLbl = new JLabel("Nº expediente: ");
		numExpLbl.setBounds(72, 170, 99, 20);
		getContentPane().add(numExpLbl);

		idLbl = new JLabel("ID Proyecto: ");
		idLbl.setBounds(72, 200, 99, 20);
		getContentPane().add(idLbl);

		nombreLbl = new JLabel("Nombre: ");
		nombreLbl.setBounds(72, 110, 99, 20);
		getContentPane().add(nombreLbl);

		apellidosLbl = new JLabel("Apellidos: ");
		apellidosLbl.setBounds(72, 140, 99, 20);
		getContentPane().add(apellidosLbl);

		showNumExp = new JLabel();
		showNumExp.setBounds(221, 171, 107, 20);
		getContentPane().add(showNumExp);

		showId = new JLabel();
		showId.setBounds(221, 201, 107, 20);
		getContentPane().add(showId);

		showNombre = new JLabel();
		showNombre.setBounds(221, 110, 107, 20);
		getContentPane().add(showNombre);

		showApellidos = new JLabel();
		showApellidos.setBounds(221, 141, 107, 20);
		getContentPane().add(showApellidos);

		// lista
		projectList = new JList<>(listaProyectos);
		projectList.setLocation(43, 205);
		projectList.setSize(203, 200);
		Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK);

		JScrollPane scrollPane = new JScrollPane(projectList);
		scrollPane.setBounds(40, 250, 470, 170);
		getContentPane().add(scrollPane);

		saveButton = new JButton("Guardar Cambios");
		saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		saveButton.setSize(135, 29);
		saveButton.setLocation(193, 448);
		EditStdntBtnListener escuchador = new EditStdntBtnListener(this);
		saveButton.addActionListener(escuchador);
		getContentPane().add(saveButton);

		tituloLbl = new JLabel("CONSULTA Y MODIFICACION DEL ALUMNO ");
		tituloLbl.setFont(new Font("Impact", Font.PLAIN, 31));
		tituloLbl.setBounds(20, 30, 516, 67);
		getContentPane().add(tituloLbl);

		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(550, 524);
	}

	/**
	 * Muestra los alumnos en la lista.
	 * 
	 * @param lista La lista de alumnos a mostrar.
	 */
	public void showAlumn(ArrayList<ProyectoIntegrador> lista) {
		for (ProyectoIntegrador a : lista) {
			listaProyectos.addElement(a.toString());
		}
	}

	/**
	 * Muestra los alumnos en la lista.
	 * 
	 * @param lista La lista de alumnos a mostrar.
	 */
	public void showProjects(ArrayList<ProyectoIntegrador> lista) {
		for (ProyectoIntegrador a : lista) {
			if (Integer.parseInt(a.getIdProyecto()) > 0)
				listaProyectos.addElement(a.toString());
		}
	}

	/**
	 * Hace visible la ventana de aÃ±adir alumnos.
	 */
	public void hacerVisible() {
		setVisible(true);
	}

	/**
	 * GETTERS Y SETTERS
	 */
	public JLabel getNumExpLbl() {
		return numExpLbl;
	}

	public void setNumExpLbl(JLabel numExpLbl) {
		this.numExpLbl = numExpLbl;
	}

	public JLabel getidLbl() {
		return idLbl;
	}

	public void setCodigoLbl(JLabel idLbl) {
		this.idLbl = idLbl;
	}

	public JLabel getNombreLbl() {
		return nombreLbl;
	}

	public void setNombreLbl(JLabel nombreLbl) {
		this.nombreLbl = nombreLbl;
	}

	public JLabel getApellidosLbl() {
		return apellidosLbl;
	}

	public void setApellidosLbl(JLabel apellidosLbl) {
		this.apellidosLbl = apellidosLbl;
	}

	public JLabel getNumExpTxtF() {
		return showNumExp;
	}

	public void setNumExpTxtF(JLabel numExpTxtF) {
		this.showNumExp = numExpTxtF;
	}

	public JLabel getidTxtF() {
		return showId;
	}

	public void setCodigoTxtF(JLabel idTxtF) {
		this.showId = idTxtF;
	}

	public JLabel getNombreTxtF() {
		return showNombre;
	}

	public void setNombreTxtF(JLabel nombreTxtF) {
		this.showNombre = nombreTxtF;
	}

	public JLabel getApellidosTxtF() {
		return showApellidos;
	}

	public void setApellidosTxtF(JLabel apellidosTxtF) {
		this.showApellidos = apellidosTxtF;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}
	
	public Alumno getAlumno() {
		return alumno;
	}
	
	public String getIdProyectoSeleccionado() {
		String idProyecto=projectList.getSelectedValue();
		if(idProyecto.length()>0) {
			return idProyecto.substring(0, idProyecto.indexOf("-")).trim();
		}
		else return "";
	}
}

//package vista;
//
//import java.awt.Color;
//import java.awt.Cursor;
//import java.util.ArrayList;
//
//import javax.swing.*;
//
//import control.CloseWindowBtnListener;
//import control.ConsulBtnListener;
//import control.EditStdntBtnListener;
//import modelo.ProyectoIntegrador;
//import java.awt.Font;
//
///**
// * Clase que representa la ventana de aÃ±adir alumnos.
// */
//public class AddAlumn extends JFrame {
//	private JLabel numExpLbl;
//	private JLabel idLbl;
//	private JLabel nombreLbl;
//	private JLabel apellidosLbl;
//    private JTextField numExpTxtF;
//    private JTextField idTxtF;
//	private JTextField nombreTxtF;
//    private JTextField apellidosTxtF;
//    
//    private JList<String> alumnList;
//    private ArrayList<ProyectoIntegrador> listaAlumnos;
//    private DefaultListModel<String> listaAlumn;
//    
//    private JButton saveButton;
//    private JLabel tituloLbl;
//
//    /**
//     * Constructor de la clase AddAlumn.
//     * Inicializa los componentes de la ventana.
//     */
//    public AddAlumn() {
//    	super("Editar Alumnos");
//    	listaAlumnos = new ArrayList<ProyectoIntegrador>();
//		getContentPane().setBackground(new Color(195, 219, 255));
//		inicializarComponentes();
//    }
//    
//    /**
//     * Inicializa los componentes de la ventana.
//     */
//    public void inicializarComponentes() {
//		getContentPane().setLayout(null);
//		listaAlumn = new DefaultListModel<String>();
//	    alumnList = new JList<String>(listaAlumn);
//
//		numExpLbl = new JLabel("NÂº expediente: ");
//		numExpLbl.setBounds(86, 110, 73, 20);
//	    getContentPane().add(numExpLbl);
//
//	    idLbl = new JLabel("CÃ³digo Proyecto: ");
//	    idLbl.setBounds(86, 140, 99, 20);
//	    getContentPane().add(idLbl);
//
//	    nombreLbl = new JLabel("Nombre: ");
//	    nombreLbl.setBounds(86, 170, 73, 20);
//	    getContentPane().add(nombreLbl);
//
//	    apellidosLbl = new JLabel("Apellidos: ");
//	    apellidosLbl.setBounds(86, 200, 73, 20);
//	    getContentPane().add(apellidosLbl);
//		
//		numExpTxtF = new JTextField();
//		numExpTxtF.setBounds(221, 110, 107, 20);
//	    getContentPane().add(numExpTxtF);
//	    
//	    idTxtF = new JTextField();
//	    idTxtF.setBounds(221, 201, 107, 20);
//	    getContentPane().add(idTxtF);
//
//		nombreTxtF = new JTextField();
//		nombreTxtF.setBounds(221, 171, 107, 20);
//	    getContentPane().add(nombreTxtF);
//
//		apellidosTxtF = new JTextField();
//		apellidosTxtF.setBounds(221, 141, 107, 20);
//	    getContentPane().add(apellidosTxtF);
//		
//	    CloseWindowBtnListener escuchador = new CloseWindowBtnListener(null, null, this);
//	    saveButton.addActionListener(escuchador);
//	    getContentPane().add(saveButton);
//	    
//	    saveButton = new JButton("Editar");
//	    saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
//	    saveButton.setSize(85, 29);
//	    saveButton.setLocation(86, 230);
//	    getContentPane().add(saveButton);
//	    
//	    tituloLbl = new JLabel("CONSULTA Y MODIFICACION DEL ALUMNO ");
//	    tituloLbl.setFont(new Font("Impact", Font.PLAIN, 31));
//	    tituloLbl.setBounds(20, 30, 516, 67);
//	    getContentPane().add(tituloLbl);
//	    
//	    JButton closeButton = new JButton("Cerrar");
//	    closeButton.setBounds(221, 231, 107, 29);
//	    getContentPane().add(closeButton);
//	    
//    	setVisible(true);
//    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//    	setSize(550, 344);
//    }
//    
//    /**
//     * Muestra los alumnos en la lista.
//     * @param lista La lista de alumnos a mostrar.
//     */
//    public void showAlumn(ArrayList<ProyectoIntegrador> lista) {
//		for(ProyectoIntegrador a : lista) {
//			listaAlumn.addElement(a.toString());
//	    }
//	}	
//
//    /**
//     * Muestra los alumnos en la lista.
//     * @param lista La lista de alumnos a mostrar.
//     */
//    public void showProjects(ArrayList<ProyectoIntegrador> lista) {
//		for(ProyectoIntegrador a : lista) {
//			listaAlumn.addElement(a.toString());
//	    }
//	}
//    
//	/**
//     * Hace visible la ventana de aÃ±adir alumnos.
//	 */
//	public void hacerVisible() {
//		setVisible(true);
//	}
//	
//	/**
//	 * GETTERS Y SETTERS
//	 */
//	public JLabel getNumExpLbl() {
//		return numExpLbl;
//	}
//
//	public void setNumExpLbl(JLabel numExpLbl) {
//		this.numExpLbl = numExpLbl;
//	}
//
//	public JLabel getidLbl() {
//		return idLbl;
//	}
//
//	public void setCodigoLbl(JLabel idLbl) {
//		this.idLbl = idLbl;
//	}
//
//	public JLabel getNombreLbl() {
//		return nombreLbl;
//	}
//
//	public void setNombreLbl(JLabel nombreLbl) {
//		this.nombreLbl = nombreLbl;
//	}
//
//	public JLabel getApellidosLbl() {
//		return apellidosLbl;
//	}
//
//	public void setApellidosLbl(JLabel apellidosLbl) {
//		this.apellidosLbl = apellidosLbl;
//	}
//
//	public JTextField getNumExpTxtF() {
//		return numExpTxtF;
//	}
//
//	public void setNumExpTxtF(JTextField numExpTxtF) {
//		this.numExpTxtF = numExpTxtF;
//	}
//
//	public JTextField getidTxtF() {
//		return idTxtF;
//	}
//
//	public void setCodigoTxtF(JTextField idTxtF) {
//		this.idTxtF = idTxtF;
//	}
//
//	public JTextField getNombreTxtF() {
//		return nombreTxtF;
//	}
//
//	public void setNombreTxtF(JTextField nombreTxtF) {
//		this.nombreTxtF = nombreTxtF;
//	}
//
//	public JTextField getApellidosTxtF() {
//		return apellidosTxtF;
//	}
//
//	public void setApellidosTxtF(JTextField apellidosTxtF) {
//		this.apellidosTxtF = apellidosTxtF;
//	}
//
//	public JButton getSaveButton() {
//		return saveButton;
//	}
//
//	public void setSaveButton(JButton saveButton) {
//		this.saveButton = saveButton;
//	}	
//}
