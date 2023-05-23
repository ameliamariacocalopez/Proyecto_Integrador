package vista;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.*;
import control.MenuListener;
import control.modBtnListener;
import modelo.ProyectoIntegrador;

public class ModProyect extends JFrame {
	ImageIcon pacImg = new ImageIcon("img/pacTrans.png");
	JLabel imgLbl = new JLabel(pacImg);
	private JMenuBar menu;
	JMenuItem consulItem;
	JMenuItem addItem;
	JMenuItem delItem;
	JMenuItem modItem;
	JMenuItem areasM;
	JMenuItem alumnosM;
	JLabel headingTxt;
	
	private JTextField idTxtF;
	private JTextField nombreProyTxtF;
	private JTextField urlTxtF;
	private JTextField notaTxtF;
	private JTextField fechaTxtF;
	private JTextField cursoTxtF;
	private JTextField grupoTxtF;

    private JList<String> projectList;
    private ArrayList<ProyectoIntegrador> listaProyectos;
    private DefaultListModel<String> listaProy;
	
    private JLabel filterTxt;
    private JTextField filterTxtF;
    private JList<String> modProjList;
    private JButton modBtn2;

    
	public ModProyect() {
		super("Modificar Proyecto");
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
     	
     	headingTxt = new JLabel("Selecciona el proyecto que quieras modificar");
     	headingTxt.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
     	headingTxt.setBounds(33, 145, 519, 20);
	    getContentPane().add(headingTxt);

        filterTxt = new JLabel("Filter:");
        filterTxt.setBounds(43, 173, 63, 20);
	    getContentPane().add(filterTxt);
	    
	    filterTxtF = new JTextField();
	    filterTxtF.setBounds(85, 174, 117, 20);
	    getContentPane().add(filterTxtF);
	    
	    modBtn2 = new JButton("Editar");
	    modBtn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    modBtn2.setBackground(new Color(58, 142, 247));
	    modBtn2.setBounds(239, 396, 63, 20);
	    modBtn2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
	    modBtnListener escuchador = new modBtnListener();
	    modBtn2.addActionListener(escuchador);

	    getContentPane().add(modBtn2);
	    
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
		listaProy = new DefaultListModel();
		
		//lista
	    DefaultListModel<String> listaProy = new DefaultListModel<>();
        projectList = new JList<>(listaProy);
        getContentPane().add(modBtn2);
        modProjList.setLocation(43, 205);
        modProjList.setSize(563, 171);
	    Border buttonBorder = BorderFactory.createLineBorder(Color.BLACK);
	    
	    JScrollPane scrollPane = new JScrollPane(modProjList);
	    scrollPane.setBounds(43, 205, 563, 171);
	    getContentPane().add(scrollPane);
		
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
	
	public void showProys(ArrayList<ProyectoIntegrador> lista) {
		for(ProyectoIntegrador p : lista) {
			listaProy.addElement(p.toString());
	    }
	}
	
	/**
	 * Hace toda la página visible
	 */
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void desactivar() {
		setVisible(false);
	}
}
