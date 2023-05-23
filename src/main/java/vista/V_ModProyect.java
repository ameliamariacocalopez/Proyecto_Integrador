package vista;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.*;
import control.CloseWindowBtnListener;
import control.saveProyBtnListener;

public class V_ModProyect extends JFrame {
	ImageIcon pacImg = new ImageIcon("img/pacTrans.png");
	JLabel imgLbl = new JLabel(pacImg);
	
	private JLabel idLbl, nombreProyLbl, urlLbl, notaLbl, fechaLbl, cursoLbl, grupoLbl;
	
	private JTextField idTxtF, nombreProyTxtF, urlTxtF, notaTxtF, fechaTxtF, cursoTxtF, grupoTxtF;
	JButton saveButton;
	
	public V_ModProyect() {
		super("Modificar Proyecto - Edit");
		getContentPane().setBackground(new Color(195, 219, 255));
		inicializarComponentes();
	}
	
	/**
	 * Inicializa los componentes y los añade al content pane
	 */
	public void inicializarComponentes() {
		getContentPane().setLayout(null);

		idLbl = new JLabel("ID: ");
		idLbl.setBounds(86, 111, 73, 20);
	    getContentPane().add(idLbl);

		nombreProyLbl = new JLabel("Nombre: ");
		nombreProyLbl.setBounds(86, 170, 63, 20);
	    getContentPane().add(nombreProyLbl);

		urlLbl = new JLabel("URL: ");
		urlLbl.setBounds(86, 230, 73, 20);
	    getContentPane().add(urlLbl);

		notaLbl = new JLabel("Nota: ");
		notaLbl.setBounds(86, 290, 73, 20);
	    getContentPane().add(notaLbl);

		fechaLbl = new JLabel("Fecha: ");
		fechaLbl.setBounds(86, 350, 73, 20);
	    getContentPane().add(fechaLbl);

		cursoLbl = new JLabel("Curso: ");
		cursoLbl.setBounds(86, 400, 73, 20);
	    getContentPane().add(cursoLbl);

		grupoLbl = new JLabel("Grupo: ");
		grupoLbl.setBounds(86, 460, 73, 20);
	    getContentPane().add(grupoLbl);
		
		idTxtF = new JTextField();
		idTxtF.setBounds(221, 350, 107, 20);
	    getContentPane().add(idTxtF);

		nombreProyTxtF = new JTextField();
		nombreProyTxtF.setBounds(221, 110, 107, 20);
	    getContentPane().add(nombreProyTxtF);

		urlTxtF = new JTextField();
		urlTxtF.setBounds(221, 170, 107, 20);
	    getContentPane().add(urlTxtF);

		notaTxtF = new JTextField();
		notaTxtF.setBounds(221, 290, 107, 20);
	    getContentPane().add(notaTxtF);

		fechaTxtF = new JTextField();
		fechaTxtF.setBounds(221, 230, 107, 20);
	    getContentPane().add(fechaTxtF);

		cursoTxtF = new JTextField();
		cursoTxtF.setBounds(221, 400, 107, 20);
	    getContentPane().add(cursoTxtF);

		grupoTxtF = new JTextField();
		grupoTxtF.setBounds(221, 460, 107, 20);
	    getContentPane().add(grupoTxtF);
		
		saveButton = new JButton("Guardar cambios");
		saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		saveButton.setBounds(221, 570, 117, 20);
		saveButton.setLocation(221, 570);
		//listeners
		saveProyBtnListener escuchador1 = new saveProyBtnListener();
		saveButton.addActionListener(escuchador1);	    
		CloseWindowBtnListener escuchador = new CloseWindowBtnListener(null, this, null);
		saveButton.addActionListener(escuchador);	    
		getContentPane().add(saveButton);
	    
	    setVisible(true);
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	setSize(550, 670);
	}
}
