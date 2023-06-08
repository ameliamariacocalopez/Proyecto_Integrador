package vista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import control.*;
import modelo.*;
import javax.swing.JComboBox;
import modelo.Alumno;


/**
 * Ventana para aÃ±adir proyectos. Esta clase representa una ventana Swing que
 * permite al usuario agregar proyectos. Los componentes de la ventana incluyen
 * etiquetas, campos de texto, un botÃ³n y un menÃº. TambiÃ©n se proporcionan
 * mÃ©todos para obtener y establecer los valores de los componentes.
 * 
 * @author Paula Moure
 */
public class AddProyect extends JFrame {
	ImageIcon pacImg = new ImageIcon("img/pacTrans.png");
	JLabel imgLbl = new JLabel(pacImg);
	JMenuBar menu;
	JMenuItem consulItem;
	JMenuItem addItem;
	JMenuItem delItem;
	JMenuItem modItem;
	JMenuItem areasM;
	JMenuItem alumnosM;
	JLabel opt1;
	JLabel opt2;
	JLabel opt3;
	JLabel opt32;
	JLabel opt33;
	JLabel opt4;
	JLabel opt5;
	JLabel opt6;
	JLabel opt7;
	JLabel opt8;
	JLabel opt9;
	JTextField res1;
	JTextField res2;
	JTextField res4;
	JTextField res5;
	JTextField res6;
	JTextField res7;
	JTextField res8;
	JComboBox<String> res9 = new JComboBox<>();
	private DefaultComboBoxModel<String> listaAlumns;
	private DefaultComboBoxModel<String> listaAlumns2;
	private DefaultComboBoxModel<String> listaAlumns3;
	JComboBox<String> comboBoxEstudiantes;
	JComboBox<String> comboBoxEstudiantes2;
	JComboBox<String> comboBoxEstudiantes3;

	JButton addBtn;
	

	/**
	 * Constructor de la clase AddProyect. Crea una nueva instancia de la ventana
	 * "AÃ±adir Proyecto" y configura sus propiedades.
	 */
	public AddProyect() {
		super("Anadir Proyecto");
		getContentPane().setBackground(new Color(195, 219, 255));
		comboBoxEstudiantes = new JComboBox<>();
		
		inicializarComponentes();
	}

	/**
	 * Inicializa los componentes y los aÃ±ade al content pane
	 */
	public void inicializarComponentes() {
		getContentPane().setLayout(null);

		// menu
		menu = new JMenuBar();
		JMenu proyectoM = new JMenu("Proyecto Integrador");
		consulItem = new JMenuItem("Consultas");
		addItem = new JMenuItem("Anadir Proyecto");
		delItem = new JMenuItem("Borrar Proyecto");
		modItem = new JMenuItem("Modificar Proyecto");
		areasM = new JMenuItem("Areas");
		alumnosM = new JMenuItem("Alumnos");
		proyectoM.add(consulItem);
		proyectoM.add(addItem);
		proyectoM.add(delItem);
		proyectoM.add(modItem);
		menu.add(proyectoM);
		menu.add(areasM);
		menu.add(alumnosM);
		setJMenuBar(menu);
		Border border = BorderFactory.createLineBorder(Color.BLACK);

		// objetos
		imgLbl.setSize(304, 118);
		imgLbl.setLocation(165, 14);
		getContentPane().add(imgLbl);

		opt1 = new JLabel("ID");
		opt1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		opt1.setHorizontalAlignment(SwingConstants.RIGHT);
		opt1.setBounds(85, 155, 81, 20);
		getContentPane().add(opt1);

		// automÃ¡tico
		res1 = new JTextField("");
		res1.setBounds(210, 155, 100, 20);
		getContentPane().add(res1);

		opt2 = new JLabel("Nombre");
		opt2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		opt2.setBounds(119, 195, 72, 20);
		getContentPane().add(opt2);

		res2 = new JTextField("");
		res2.setBounds(210, 195, 100, 20);
		getContentPane().add(res2);
		
//		ArrayList<Alumno> nombresAlumnos = accesoBBDD.obtenerAlumnosList();
//		
//		JComboBox<String> comboBoxAlumnos = new JComboBox<>();
//		for (Alumno alumno: nombresAlumnos) {
//		    comboBoxAlumnos.addItem(alumno.getNombre());
//		}

		
		opt3 = new JLabel("Componente 1");
		opt3.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		opt3.setBounds(80, 235, 91, 20);
		
		getContentPane().add(opt3);

		opt32 = new JLabel("Componente 2");
		opt32.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		opt32.setBounds(80, 275, 91, 20);
		getContentPane().add(opt32);

		opt33 = new JLabel("Componente 3");
		opt33.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		opt33.setBounds(80, 315, 91, 20);
		getContentPane().add(opt33);

		listaAlumns = new DefaultComboBoxModel<String>();
		listaAlumns2 = new DefaultComboBoxModel<String>();
		listaAlumns3 = new DefaultComboBoxModel<String>();

		
		
		comboBoxEstudiantes = new JComboBox<String>(listaAlumns);
		comboBoxEstudiantes.setBounds(187, 235, 150, 25);
		getContentPane().add(comboBoxEstudiantes);

		comboBoxEstudiantes2 = new JComboBox<String>(listaAlumns2);
		comboBoxEstudiantes2.setBounds(187, 275, 150, 25);
		getContentPane().add(comboBoxEstudiantes2);

		comboBoxEstudiantes3 = new JComboBox<String>(listaAlumns3);
		comboBoxEstudiantes3.setBounds(187, 315, 150, 25);
		getContentPane().add(comboBoxEstudiantes3);

		opt4 = new JLabel("URL");
		opt4.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		opt4.setBounds(142, 355, 33, 20);
		getContentPane().add(opt4);

		res4 = new JTextField("");
		res4.setBounds(210, 355, 100, 20);
		getContentPane().add(res4);

		opt5 = new JLabel("Nota");
		opt5.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		opt5.setBounds(140, 395, 33, 20);
		getContentPane().add(opt5);

		res5 = new JTextField();
		res5.setBounds(210, 395, 100, 20);
		getContentPane().add(res5);

		opt6 = new JLabel("Año");
		opt6.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		opt6.setBounds(393, 185, 33, 20);
		getContentPane().add(opt6);

		res6 = new JTextField("YYYY");
		res6.setBounds(452, 185, 100, 20);
		getContentPane().add(res6);

		opt7 = new JLabel("Curso");
		opt7.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		opt7.setBounds(382, 225, 60, 20);
		getContentPane().add(opt7);

		res7 = new JTextField("");
		res7.setBounds(452, 225, 100, 20);
		getContentPane().add(res7);

		opt8 = new JLabel("Grupo");
		opt8.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		opt8.setBounds(378, 264, 91, 20);
		getContentPane().add(opt8);

		res8 = new JTextField("");
		res8.setBounds(452, 265, 100, 20);
		getContentPane().add(res8);

		opt9 = new JLabel("Área/Ciclo");
		opt9.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		opt9.setBounds(354, 305, 91, 20);
		getContentPane().add(opt9);

		res9 = new JComboBox();
		res9.setBounds(452, 305, 100, 20);
		res9.addItem("DAW");
		res9.addItem("DAM");
		res9.addItem("ASIR");
		getContentPane().add(res9);

		// add-proyect button
		addBtn = new JButton("Anadir proyecto");
		addBtn.setBackground(new Color(242, 255, 248));
		addBtn.setBounds(270, 470, 117, 20);
		addBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
		Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK);
		addBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		AddProjBtnListener escuchadorAdd = new AddProjBtnListener(this);
		addBtn.addActionListener(escuchadorAdd);
		getContentPane().add(addBtn);

		setSize(677, 585);
		setLocationRelativeTo(null);
	}

	/**
	 * Configura un objeto MenuListener para manejar los eventos del menÃº
	 * 
	 * @param listener el objeto MenuListener que manejarÃ¡ los eventos del menÃº
	 */
	public void setListener(MenuListener listener) {
		consulItem.addActionListener(listener);
		addItem.addActionListener(listener);
		delItem.addActionListener(listener);
		modItem.addActionListener(listener);
		areasM.addActionListener(listener);
		alumnosM.addActionListener(listener);
	}

	/**
	 * Recoge todos los alumnos de la lista
	 * 
	 * @param lista
	 */
	public void showAlumnos(ArrayList<Alumno> lista) {
		listaAlumns.addElement("--");
		listaAlumns2.addElement("--");
		listaAlumns3.addElement("--");
		for (Alumno p : lista) {
			listaAlumns.addElement(p.toString());
			listaAlumns2.addElement(p.toString());
			listaAlumns3.addElement(p.toString());
			System.out.println(p.getNombre());
		}
	}
	
//	private String obtenerNombreAlumno(Alumno alumno) {
//        // Llamar al método getNombre() en la clase Alumno para obtener el nombre
//        return alumno.getNombre();
//    }
//	
//	private void cargarNombresAlumnos() {
//        AccesoBBDD accesoBBDD = new AccesoBBDD();
//        ArrayList<Alumno> nombresAlumnos = accesoBBDD.obtenerAlumnosList();
//
//        for (Alumno nombreAlumno : nombresAlumnos) {
//            comboBoxEstudiantes.addItem(obtenerNombreAlumno(nombreAlumno));
//        }
//    }
//	
//
//    public JComboBox<String> getComboBoxAlumnos() {
//        return comboBoxEstudiantes;
//    }
	/**
	 * Hace toda la pÃ¡gina visible
	 */
	
	// falta un mÃ©todo rellenarComboBox(ArrayList<Alumno> a)
	// en este mÃ©todo le pasamos un arraylist de alumnos que hemos obtenido donde
	// sea (nos da igual)
	// y nosotros lo guardamos en el combobox.
	// a este mÃ©todo lo llamamos desde el listener que ABRE ESTA VENTANA
	// (el listener que tenga la llamada "new AddProyect()"

	/**
	 * GETTERS Y SETTERS
	 */public void hacerVisible() {
		setVisible(true);
	}
	public ImageIcon getPacImg() {
		return pacImg;
	}

	public void setPacImg(ImageIcon pacImg) {
		this.pacImg = pacImg;
	}

	public JLabel getImgLbl() {
		return imgLbl;
	}

	public void setImgLbl(JLabel imgLbl) {
		this.imgLbl = imgLbl;
	}

	public JMenuBar getMenu() {
		return menu;
	}

	public void setMenu(JMenuBar menu) {
		this.menu = menu;
	}

	public JMenuItem getConsulItem() {
		return consulItem;
	}

	public void setConsulItem(JMenuItem consulItem) {
		this.consulItem = consulItem;
	}

	public JMenuItem getAddItem() {
		return addItem;
	}

	public void setAddItem(JMenuItem addItem) {
		this.addItem = addItem;
	}

	public JMenuItem getDelItem() {
		return delItem;
	}

	public void setDelItem(JMenuItem delItem) {
		this.delItem = delItem;
	}

	public JMenuItem getModItem() {
		return modItem;
	}

	public void setModItem(JMenuItem modItem) {
		this.modItem = modItem;
	}

	public JMenuItem getAreasM() {
		return areasM;
	}

	public void setAreasM(JMenuItem areasM) {
		this.areasM = areasM;
	}

	public JMenuItem getAlumnosM() {
		return alumnosM;
	}

	public void setAlumnosM(JMenuItem alumnosM) {
		this.alumnosM = alumnosM;
	}

	public JLabel getOpt1() {
		return opt1;
	}

	public void setOpt1(JLabel opt1) {
		this.opt1 = opt1;
	}

	public JLabel getOpt2() {
		return opt2;
	}

	public void setOpt2(JLabel opt2) {
		this.opt2 = opt2;
	}

	public JLabel getOpt3() {
		return opt3;
	}

	public void setOpt3(JLabel opt3) {
		this.opt3 = opt3;
	}

	public JLabel getOpt4() {
		return opt4;
	}

	public void setOpt4(JLabel opt4) {
		this.opt4 = opt4;
	}

	public JLabel getOpt5() {
		return opt5;
	}

	public void setOpt5(JLabel opt5) {
		this.opt5 = opt5;
	}

	public JLabel getOpt6() {
		return opt6;
	}

	public void setOpt6(JLabel opt6) {
		this.opt6 = opt6;
	}

	public JLabel getOpt7() {
		return opt7;
	}

	public void setOpt7(JLabel opt7) {
		this.opt7 = opt7;
	}

	public JLabel getOpt8() {
		return opt8;
	}

	public void setOpt8(JLabel opt8) {
		this.opt8 = opt8;
	}

	public JLabel getOpt9() {
		return opt9;
	}

	public void setOpt9(JLabel opt9) {
		this.opt9 = opt9;
	}

	public JTextField getRes1() {
		return res1;
	}

	public void setRes1(JTextField res1) {
		this.res1 = res1;
	}

	public JTextField getRes2() {
		return res2;
	}

	public void setRes2(JTextField res2) {
		this.res2 = res2;
	}

	public JTextField getRes4() {
		return res4;
	}

	public void setRes4(JTextField res4) {
		this.res4 = res4;
	}

	public JTextField getRes5() {
		return res5;
	}

	public void setRes5(JTextField res5) {
		this.res5 = res5;
	}

	public JTextField getRes6() {
		return res6;
	}

	public void setRes6(JTextField res6) {
		this.res6 = res6;
	}

	public JTextField getRes7() {
		return res7;
	}

	public void setRes7(JTextField res7) {
		this.res7 = res7;
	}

	public JTextField getRes8() {
		return res8;
	}

	public void setRes8(JTextField res8) {
		this.res8 = res8;
	}

	public JComboBox<String> getRes9() {
		return res9;
	}

	public void setRes9(JComboBox<String> res9) {
		this.res9 = res9;
	}

	public DefaultComboBoxModel<String> getListaAlumns() {
		return listaAlumns;
	}

	public void setListaAlumns(DefaultComboBoxModel<String> listaAlumns) {
		this.listaAlumns = listaAlumns;
	}

	public DefaultComboBoxModel<String> getListaAlumns2() {
		return listaAlumns2;
	}

	public void setListaAlumns2(DefaultComboBoxModel<String> listaAlumns2) {
		this.listaAlumns2 = listaAlumns2;
	}

	public DefaultComboBoxModel<String> getListaAlumns3() {
		return listaAlumns3;
	}

	public void setListaAlumns3(DefaultComboBoxModel<String> listaAlumns3) {
		this.listaAlumns3 = listaAlumns3;
	}

	public JButton getAddBtn() {
		return addBtn;
	}

	public void setAddBtn(JButton addBtn) {
		this.addBtn = addBtn;
	}

	public String getEstudiante1() {
		return (String) comboBoxEstudiantes.getSelectedItem();
	}
	
	public String getEstudiante2() {
		return (String) comboBoxEstudiantes2.getSelectedItem();
	}
	
	public String getEstudiante3() {
		return (String) comboBoxEstudiantes3.getSelectedItem();
	}

}
