package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import control.ConsulBtnListener;
import control.MenuListener;
import modelo.ProyectoIntegrador;
import control.EditStdntBtnListener;

public class AlumnProyect extends JFrame {
	ImageIcon pacImg = new ImageIcon("img/pacTrans.png");
	JLabel imgLbl = new JLabel(pacImg);	
	JMenuBar menu;
	JMenuItem consulItem;
	JMenuItem addItem;
	JMenuItem delItem;
	JMenuItem modItem;
	JMenuItem areasM;
	JMenuItem alumnosM;
	JButton addAlumn;
	JButton editAlumn;
    private JList<String> alumnList;
    private ArrayList<ProyectoIntegrador> listaAlumnos;
    private DefaultListModel<String> listaAlumn;
    
	public AlumnProyect() {
		super("Alumnos");
		getContentPane().setBackground(new Color(195, 219, 255));
		inicializarComponentes();
	}
	
	public void inicializarComponentes() {
		getContentPane().setLayout(null);
		//Diseño: Añadir una cajita con el total de estudiantes, otra con los estudiantes asignados a un proyecto y otra los que no tienen ninguno asignado
		
		//objetos
        imgLbl.setSize(304, 118);
     	imgLbl.setLocation(150, 30);
     	getContentPane().add(imgLbl);
     	
     	addAlumn = new JButton("Añadir alumno");
     	addAlumn.setCursor(new Cursor(Cursor.HAND_CURSOR));
     	addAlumn.setBackground(new Color(58, 142, 247));
     	addAlumn.setBounds(198, 389, 113, 20);
	    addAlumn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	    addAlumn.addActionListener(new EditStdntBtnListener());
	    EditStdntBtnListener escuchador = new EditStdntBtnListener();
	    addAlumn.addActionListener(escuchador);
	    getContentPane().add(addAlumn);
	    
	    editAlumn = new JButton("Editar");
	    editAlumn.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    addAlumn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	    editAlumn.setSize(107, 29);
     	editAlumn.setBounds(323, 389, 87, 20);
	    editAlumn.addActionListener(new EditStdntBtnListener());
	    EditStdntBtnListener escuchador2 = new EditStdntBtnListener();
	    editAlumn.addActionListener(escuchador2);
	    getContentPane().add(editAlumn);

	    //menu
  		menu = new JMenuBar();
        areasM = new JMenuItem("Áreas");
        alumnosM = new JMenuItem("Alumnos");
        JMenu proyectoM = new JMenu("Proyecto Integrador");

        consulItem = new JMenuItem("Consultas");
        addItem = new JMenuItem("Añadir Proyecto");
        delItem = new JMenuItem("Borrar Proyecto");
        modItem = new JMenuItem("Modificar Proyecto");
          
        proyectoM.add(consulItem);
        proyectoM.add(addItem);
        proyectoM.add(delItem);
        proyectoM.add(modItem);
        menu.add(proyectoM);
        menu.add(areasM);
        menu.add(alumnosM);
        setJMenuBar(menu);
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        
	    
	    //lista
	    DefaultListModel<String> listaAlumn = new DefaultListModel<>();
	    alumnList = new JList<>(listaAlumn);
	    getContentPane().add(addAlumn);
	    alumnList.setLocation(43, 205);
	    alumnList.setSize(563, 260);
	    Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK);
        listaAlumn = new DefaultListModel();

	    
	    JScrollPane scrollPane = new JScrollPane(alumnList);
	    scrollPane.setBounds(40, 144, 563, 232);
	    getContentPane().add(scrollPane);
	    
	    setSize(650, 484);
		setLocationRelativeTo(null);
	}
	
	public void setListener(MenuListener listener) {
		consulItem.addActionListener(listener);
		addItem.addActionListener(listener);
		delItem.addActionListener(listener);
		modItem.addActionListener(listener);
		areasM.addActionListener(listener);
		alumnosM.addActionListener(listener);
	}

	/**
	 * Hace toda la página visible
	 */
	public void hacerVisible() {
		setVisible(true);
	}
}
