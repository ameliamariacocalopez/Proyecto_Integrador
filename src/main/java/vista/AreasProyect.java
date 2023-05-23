package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;

import control.MenuListener;

public class AreasProyect extends JFrame {
	ImageIcon pacImg = new ImageIcon("img/pacTrans.png");
	JLabel imgLbl = new JLabel(pacImg);
//    AreasProyect areasProy = new AreasProyect();
	private JMenuBar menu;
	JMenuItem consulItem;
	JMenuItem addItem;
	JMenuItem delItem;
	JMenuItem modItem;
	JMenuItem areasM;
	JMenuItem alumnosM;
	
    private JLabel dawLbl;
    private JLabel dawText;
    private JLabel damLbl;
    private JLabel damText;
    private JLabel asirLbl;
    private JLabel asirText;
	
	public AreasProyect() {
		super("Áreas");
		getContentPane().setBackground(new Color(195, 219, 255));
		inicializarComponentes();
	}
	
	/**
	 * Inicializa los componentes y los añade al content pane
	 */
	public void inicializarComponentes() {
		getContentPane().setLayout(null);
		
		//objetos
        imgLbl.setSize(304, 118);
     	imgLbl.setLocation(156, 14);
     	getContentPane().add(imgLbl);
     	
     	dawLbl = new JLabel("DAW:");
     	dawLbl.setBounds(70, 148, 63, 20);
	    getContentPane().add(dawLbl);
	    
	    //he usado html para poder ajustar el texto al tamaño del JLabel
	    dawText = new JLabel("<html><body style='width: 118px;'>El grado de DAW (Diseño y Desarrollo de Aplicaciones Web) se centra en el estudio del diseño y desarrollo de aplicaciones web. Los estudiantes adquieren habilidades en lenguajes de programación web, bases de datos y diseño de interfaces. Aprenden a construir aplicaciones web interactivas utilizando tecnologías como HTML, CSS, JavaScript y frameworks populares. Además, se enfoca en la experiencia del usuario y la creación de interfaces intuitivas y atractivas.</body></html>");
	    dawText.setVerticalAlignment(SwingConstants.TOP);
	    dawText.setBounds(70, 190, 147, 200);
	    getContentPane().add(dawText);
	    
	    damLbl = new JLabel("DAM");
	    damLbl.setBounds(262, 148, 63, 20);
	    getContentPane().add(damLbl);
	    
	    damText = new JLabel("<html><body style='width: 118px;'>El grado de DAM (Desarrollo de Aplicaciones Multiplataforma) se enfoca en el estudio y desarrollo de aplicaciones para diferentes plataformas y dispositivos. Durante el grado, los estudiantes adquieren conocimientos en lenguajes de programación como Java, C#, Swift y frameworks populares como Xamarin y Flutter. Aprenden a desarrollar aplicaciones tanto nativas como multiplataforma. Además, se exploran conceptos de diseño de interfaces, interacción de usuario y adaptación a diferentes tamaños de pantalla.</body></html>");
	    damText.setVerticalAlignment(SwingConstants.TOP);
	    damText.setPreferredSize(new Dimension(147, 200));
	    damText.setBounds(262, 190, 147, 200);
	    getContentPane().add(damText);
	    
	    asirLbl = new JLabel("ASIR:");
	    asirLbl.setBounds(450, 148, 63, 20);
	    getContentPane().add(asirLbl);
	    
	    asirText = new JLabel("<html><body style='width: 118px;'>El grado de ASIR (Administración de Sistemas Informáticos en Red) se centra en la administración y gestión de sistemas informáticos en entornos de red. Durante el grado, los estudiantes adquieren conocimientos en áreas como sistemas operativos, redes de computadoras, seguridad informática y servicios de infraestructura. Aprenden a configurar y mantener sistemas operativos, administrar redes locales y remotas, implementar medidas de seguridad y gestionar servicios.</body></html>");
	    asirText.setVerticalAlignment(SwingConstants.TOP);
	    asirText.setPreferredSize(new Dimension(147, 200));
	    asirText.setBounds(450, 190, 147, 200);
	    getContentPane().add(asirText);
	    
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
        
	    //listener
        MenuListener menuList = new MenuListener(this);
        setListener(menuList);
		
		setSize(650, 470);
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
