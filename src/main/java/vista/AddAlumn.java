package vista;

import java.awt.Color;
import java.awt.Cursor;
import java.util.ArrayList;
import javax.swing.*;
import control.CloseWindowBtnListener;
import control.ConsulBtnListener;
import control.EditStdntBtnListener;
import modelo.ProyectoIntegrador;

/**
 * Clase que representa la ventana de añadir alumnos.
 */
public class AddAlumn extends JFrame {
    private JLabel numExpLbl;
    private JLabel codigoLbl;
    private JLabel nombreLbl;
    private JLabel apellidosLbl;
    private JTextField numExpTxtF;
    private JTextField codigoTxtF;
    private JTextField nombreTxtF;
    private JTextField apellidosTxtF;
    private JList<String> alumnList;
    private ArrayList<ProyectoIntegrador> listaAlumnos;
    private DefaultListModel<String> listaAlumn;
    private JButton saveButton;

    /**
     * Constructor de la clase AddAlumn.
     * Inicializa los componentes de la ventana.
     */
    public AddAlumn() {
        super("Añadir Alumnos");
        listaAlumnos = new ArrayList<ProyectoIntegrador>();
        getContentPane().setBackground(new Color(195, 219, 255));
        inicializarComponentes();
    }

    /**
     * Inicializa los componentes de la ventana.
     */
    public void inicializarComponentes() {
        getContentPane().setLayout(null);
        alumnList = new JList<>(listaAlumn);

        numExpLbl = new JLabel("Nº expediente: ");
        numExpLbl.setBounds(86, 110, 73, 20);
        getContentPane().add(numExpLbl);

        codigoLbl = new JLabel("Código: ");
        codigoLbl.setBounds(86, 185, 63, 20);
        getContentPane().add(codigoLbl);

        nombreLbl = new JLabel("Nombre: ");
        nombreLbl.setBounds(86, 260, 73, 20);
        getContentPane().add(nombreLbl);

        apellidosLbl = new JLabel("Apellidos: ");
        apellidosLbl.setBounds(86, 335, 73, 20);
        getContentPane().add(apellidosLbl);

        numExpTxtF = new JTextField();
        numExpTxtF.setBounds(221, 110, 107, 20);
        getContentPane().add(numExpTxtF);

        codigoTxtF = new JTextField();
        codigoTxtF.setBounds(221, 335, 107, 20);
        getContentPane().add(codigoTxtF);

        nombreTxtF = new JTextField();
        nombreTxtF.setBounds(221, 260, 107, 20);
        getContentPane().add(nombreTxtF);

        apellidosTxtF = new JTextField();
        apellidosTxtF.setBounds(221, 185, 107, 20);
        getContentPane().add(apellidosTxtF);

        CloseWindowBtnListener escuchador = new CloseWindowBtnListener(null, null, this);
        saveButton.addActionListener(escuchador);
        getContentPane().add(saveButton);

        saveButton = new JButton("Editar");
        saveButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        saveButton.setSize(85, 29);
        saveButton.setLocation(221, 401);
        getContentPane().add(saveButton);

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(509, 489);
    }

    /**
     * Muestra los alumnos en la lista.
     * @param lista La lista de alumnos a mostrar.
     */
    public void showAlumn(ArrayList<ProyectoIntegrador> lista) {
        for (ProyectoIntegrador a : lista) {
            listaAlumn.addElement(a.toString());
        }
    }

    /**
     * Hace visible la ventana de añadir alumnos.
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

    public JLabel getCodigoLbl() {
        return codigoLbl;
    }

    public void setCodigoLbl(JLabel codigoLbl) {
        this.codigoLbl = codigoLbl;
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

    public JTextField getNumExpTxtF() {
        return numExpTxtF;
    }

    public void setNumExpTxtF(JTextField numExpTxtF) {
        this.numExpTxtF = numExpTxtF;
    }

    public JTextField getCodigoTxtF() {
        return codigoTxtF;
    }

    public void setCodigoTxtF(JTextField codigoTxtF) {
        this.codigoTxtF = codigoTxtF;
    }

    public JTextField getNombreTxtF() {
        return nombreTxtF;
    }

    public void setNombreTxtF(JTextField nombreTxtF) {
        this.nombreTxtF = nombreTxtF;
    }

    public JTextField getApellidosTxtF() {
        return apellidosTxtF;
    }

    public void setApellidosTxtF(JTextField apellidosTxtF) {
        this.apellidosTxtF = apellidosTxtF;
    }

    public JButton getSaveButton() {
        return saveButton;
    }

    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }
}
