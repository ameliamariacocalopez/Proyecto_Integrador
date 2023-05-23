package vista;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.*;
import control.CloseWindowBtnListener;

public class OpenConsulProy extends JFrame {
	ImageIcon pacImg = new ImageIcon("img/pacTrans.png");
	JLabel imgLbl = new JLabel(pacImg);
	private JLabel idLbl;
	private JLabel nombreProyLbl;
	private JLabel urlLbl;
	private JLabel notaLbl;
	private JLabel fechaLbl;
	private JLabel cursoLbl;
	private JLabel grupoLbl;
	
    private JLabel idTxtF;
    private JLabel nombreProyTxtF;
    private JLabel urlTxtF;
    private JLabel notaTxtF;
    private JLabel fechaTxtF;
    private JLabel cursoTxtF;
    private JLabel grupoTxtF;
    private JButton closeButton;
    String nombreProyecto;
    
    public OpenConsulProy() {
    	super("Consultar Proyecto");
		getContentPane().setBackground(new Color(195, 219, 255));
    	inicializarComponentes();
    }
    
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
		
//		idTxtF = new JLabel();
//		idTxtF.setBounds(221, 350, 107, 20);
//	    getContentPane().add(idTxtF);
//
//		nombreProyTxtF = new JLabel();
//		nombreProyTxtF.setBounds(221, 110, 107, 20);
//	    getContentPane().add(nombreProyTxtF);
//
//		urlTxtF = new JLabel();
//		urlTxtF.setBounds(221, 170, 107, 20);
//	    getContentPane().add(urlTxtF);
//
//		notaTxtF = new JLabel();
//		notaTxtF.setBounds(221, 290, 107, 20);
//	    getContentPane().add(notaTxtF);
//
//		fechaTxtF = new JLabel();
//		fechaTxtF.setBounds(221, 230, 107, 20);
//	    getContentPane().add(fechaTxtF);
//
//		cursoTxtF = new JLabel();
//		cursoTxtF.setBounds(221, 400, 107, 20);
//	    getContentPane().add(cursoTxtF);
//
//		grupoTxtF = new JLabel();
//		grupoTxtF.setBounds(221, 460, 107, 20);
//	    getContentPane().add(grupoTxtF);
		
		closeButton = new JButton("Cerrar");
		closeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		closeButton.setSize(107, 29);
		closeButton.setLocation(221, 570);
		CloseWindowBtnListener escuchador = new CloseWindowBtnListener(this, null, null);
		closeButton.addActionListener(escuchador);
	    getContentPane().add(closeButton);

	    setVisible(true);
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	setSize(550, 670);
    }
    
	/**
	 * Hace toda la página visible
	 */
	public void hacerVisible() {
		setVisible(true);
	}

	/**
	 * GETTERS Y SETTERS
	 */
	public JLabel getIdLbl() {
		return idLbl;
	}

	public void setIdLbl(JLabel idLbl) {
		this.idLbl = idLbl;
	}

	public JLabel getNombreProyLbl() {
		return nombreProyLbl;
	}

	public void setNombreProyLbl(JLabel nombreProyLbl) {
		this.nombreProyLbl = nombreProyLbl;
	}

	public JLabel getUrlLbl() {
		return urlLbl;
	}

	public void setUrlLbl(JLabel urlLbl) {
		this.urlLbl = urlLbl;
	}

	public JLabel getNotaLbl() {
		return notaLbl;
	}

	public void setNotaLbl(JLabel notaLbl) {
		this.notaLbl = notaLbl;
	}

	public JLabel getFechaLbl() {
		return fechaLbl;
	}

	public void setFechaLbl(JLabel fechaLbl) {
		this.fechaLbl = fechaLbl;
	}

	public JLabel getCursoLbl() {
		return cursoLbl;
	}

	public void setCursoLbl(JLabel cursoLbl) {
		this.cursoLbl = cursoLbl;
	}

	public JLabel getGrupoLbl() {
		return grupoLbl;
	}

	public void setGrupoLbl(JLabel grupoLbl) {
		this.grupoLbl = grupoLbl;
	}

//	public JTextField getIdTxtF() {
//		return idTxtF;
//	}
//
//	public void setIdTxtF(JTextField idTxtF) {
//		this.idTxtF = idTxtF;
//	}
//
//	public JTextField getNombreProyTxtF() {
//		return nombreProyTxtF;
//	}
//
//	public void setNombreProyTxtF(JTextField nombreProyTxtF) {
//		this.nombreProyTxtF = nombreProyTxtF;
//	}
//
//	public JTextField getUrlTxtF() {
//		return urlTxtF;
//	}
//
//	public void setUrlTxtF(JTextField urlTxtF) {
//		this.urlTxtF = urlTxtF;
//	}
//
//	public JTextField getNotaTxtF() {
//		return notaTxtF;
//	}
//
//	public void setNotaTxtF(JTextField notaTxtF) {
//		this.notaTxtF = notaTxtF;
//	}
//
//	public JTextField getFechaTxtF() {
//		return fechaTxtF;
//	}
//
//	public void setFechaTxtF(JTextField fechaTxtF) {
//		this.fechaTxtF = fechaTxtF;
//	}
//
//	public JTextField getCursoTxtF() {
//		return cursoTxtF;
//	}
//
//	public void setCursoTxtF(JTextField cursoTxtF) {
//		this.cursoTxtF = cursoTxtF;
//	}
//
//	public JTextField getGrupoTxtF() {
//		return grupoTxtF;
//	}
//
//	public void setGrupoTxtF(JTextField grupoTxtF) {
//		this.grupoTxtF = grupoTxtF;
//	}

	public JButton getSaveButton() {
		return closeButton;
	}

	public void setSaveButton(JButton saveButton) {
		this.closeButton = saveButton;
	}
	
}
