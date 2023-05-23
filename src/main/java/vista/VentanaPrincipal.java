package vista;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.*;

import control.AyudaBtnListener;
import control.LoginBtnListener;
import modelo.AccesoBBDD;

import java.awt.*;

/**
 * @author Paula Moure
 * Ventana de inicio de sesión para administradores y estudiantes
 */
public class VentanaPrincipal extends JFrame implements IVentana {

	//Creo todos los objetos que voy a utilizar
	ImageIcon pacImg = new ImageIcon("img/aa.png");
	JLabel imgLbl = new JLabel(pacImg);
	
	JMenuBar menu;
	JLabel studentLbl;
	JLabel adminLbl;
	JLabel studOpt;
	JTextField studResp;
	
	JLabel adminOpt1;
	JLabel adminOpt2;
	JTextField adminRes1;
	JPasswordField adminRes3;
	
	JButton loginBtn;
	JButton ayudaBtn;
	
	/**
	 * CONSTRUCTOR
	 */
	public VentanaPrincipal() {
		super("Login");
		getContentPane().setForeground(new Color(0, 0, 0));
		getContentPane().setBackground(new Color(195, 219, 255));
		inicializarComponentes();
	}
	
	/**
	 * Inicializa los componentes y los añade al content pane
	 */
	@Override
	public void inicializarComponentes() {
		getContentPane().setLayout(null);
		
        //componentes
		imgLbl.setSize(304, 118);
		imgLbl.setLocation(156, 14);
		getContentPane().add(imgLbl);
		
		studentLbl = new JLabel ("ESTUDIANTE");
		studentLbl.setForeground(new Color(70, 149, 216));
		studentLbl.setBounds (98, 166, 100, 20);
		getContentPane().add(studentLbl);
		
		adminLbl = new JLabel ("ADMINISTRADOR");
		adminLbl.setForeground(new Color(91, 148, 226));
		adminLbl.setBounds (366, 166, 110, 20);
		getContentPane().add(adminLbl);

		//student login
        studOpt = new JLabel("Núm de expediente");
        studOpt.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
        studOpt.setBounds(119, 225, 132, 20);
        getContentPane().add(studOpt);

        studResp = new JTextField();
        studResp.setBounds(119, 257, 100, 20);
        getContentPane().add(studResp);

        //admin log in
        adminOpt1 = new JLabel("Username");
        adminOpt1.setHorizontalAlignment(SwingConstants.RIGHT);
        adminOpt1.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
        adminOpt1.setBounds(376, 210, 81, 20);
        getContentPane().add(adminOpt1);

        adminRes1 = new JTextField();
        adminRes1.setBounds(401, 235, 100, 20);
        getContentPane().add(adminRes1);
        
        adminOpt2 = new JLabel("Contraseña");
        adminOpt2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
        adminOpt2.setHorizontalAlignment(SwingConstants.RIGHT);
        adminOpt2.setBounds(376, 270, 91, 20);
        getContentPane().add(adminOpt2);
        
        adminRes3 = new JPasswordField();
        adminRes3.setBounds(401, 293, 100, 20);
        getContentPane().add(adminRes3);

        //login button
        loginBtn = new JButton("Log In");
        loginBtn.setForeground(new Color(100, 100, 100));
        loginBtn.setBackground(new Color(242, 255, 248));
        loginBtn.setBounds(283, 374, 72, 20);
        loginBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        LoginBtnListener escuchador = new LoginBtnListener(this);
        loginBtn.addActionListener(escuchador);
        getContentPane().add(loginBtn);
		
		//help button
		ayudaBtn = new JButton("Ayuda");
		ayudaBtn.setBounds(563, 407, 81, 29);
		ayudaBtn.setForeground(new Color(100, 100, 100));
        Border buttonBorder2 = BorderFactory.createLineBorder(Color.BLACK);
        loginBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		ayudaBtn.setContentAreaFilled(false);
		ayudaBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        getContentPane().add(ayudaBtn);  
        ayudaBtn.addActionListener(new AyudaBtnListener());
        
        setSize(650, 470);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * Hace todo visible
	 */
	@Override
	public void hacerVisible() {
		setVisible(true);
	}
	
	/**
	 * GETTERS Y SETTERS
	 */
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

	public JLabel getStudentLbl() {
		return studentLbl;
	}

	public void setStudentLbl(JLabel studentLbl) {
		this.studentLbl = studentLbl;
	}

	public JLabel getAdminLbl() {
		return adminLbl;
	}

	public void setAdminLbl(JLabel adminLbl) {
		this.adminLbl = adminLbl;
	}

	public JLabel getStudOpt() {
		return studOpt;
	}

	public void setStudOpt(JLabel studOpt) {
		this.studOpt = studOpt;
	}

	public JTextField getStudResp() {
		return studResp;
	}

	public void setStudResp(JTextField studResp) {
		this.studResp = studResp;
	}

	public JLabel getAdminOpt1() {
		return adminOpt1;
	}

	public void setAdminOpt1(JLabel adminOpt1) {
		this.adminOpt1 = adminOpt1;
	}

	public JLabel getAdminOpt2() {
		return adminOpt2;
	}

	public void setAdminOpt2(JLabel adminOpt2) {
		this.adminOpt2 = adminOpt2;
	}

	public JTextField getAdminRes1() {
		return adminRes1;
	}

	public void setAdminRes1(JTextField adminRes1) {
		this.adminRes1 = adminRes1;
	}

	public JPasswordField getAdminRes3() {
		return adminRes3;
	}

	public void setAdminRes3(JPasswordField adminRes3) {
		this.adminRes3 = adminRes3;
	}

	public JButton getLoginBtn() {
		return loginBtn;
	}

	public void setLoginBtn(JButton loginBtn) {
		this.loginBtn = loginBtn;
	}

	public JButton getAyudaBtn() {
		return ayudaBtn;
	}

	public void setAyudaBtn(JButton ayudaBtn) {
		this.ayudaBtn = ayudaBtn;
	}
	
	
	
}