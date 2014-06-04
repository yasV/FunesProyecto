package grafico;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import entidades.Empresa;
import entidades.RegistroPersona;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

import aplicacion.Funciones;
import aplicacion.Sistema;
import auxiliares.Calificacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Date;

public class Login implements Funciones  {
	
	private Controlador controlador;

	public JFrame frmBienvenidoAFunes;
	public JTextField txtusuario;
	public JPasswordField passwordField;
	public JPasswordField passwordField_1;
	public JTextField txtNick;
	public JTextField txtnombre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public JTextField txtPrimerApellido;
	public JTextField txtSegundoApellido;
	private JButton btnRegistrarse_1;
	private JButton btnRegistrarse ;
	private JButton btnIniciarSesin;
	private JButton btnRegistroUsuario;
	private JTabbedPane tabbedPane ;
	public JRadioButton rdbtnDatosPblicos;
	public JRadioButton rdbtnDatosPrivados;

	
	public Login(Sistema model,Controlador usar) {
		controlador = usar;
		controlador.C_Login(this);
		initialize();
	    addEvents();
	}
	
	public JButton getbtnRegistrarse(){
		return btnRegistrarse;
	}
	
	public JButton getbtnIniciarSesin(){
		return btnIniciarSesin;
	}
	public JButton getbtnRegistroUsuario(){
		return btnRegistroUsuario;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void addEvents() {
        this.btnIniciarSesin.addActionListener(controlador);
        this.btnRegistroUsuario.addActionListener(controlador);
        this.btnRegistrarse.addActionListener(controlador);
    }
	
	private void initialize() {

		frmBienvenidoAFunes = new JFrame();
		frmBienvenidoAFunes.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/Imagenes/Logo.jpg")));
		frmBienvenidoAFunes.setResizable(false);
		frmBienvenidoAFunes.setTitle("Bienvenido a Funes el Memorioso");
		frmBienvenidoAFunes.getContentPane().setBackground(new Color(240, 230, 140));
		frmBienvenidoAFunes.setBounds(100, 100, 719, 469);
		frmBienvenidoAFunes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBienvenidoAFunes.getContentPane().setLayout(null);
		frmBienvenidoAFunes.setVisible(true);

      	tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 703, 429);
		frmBienvenidoAFunes.getContentPane().add(tabbedPane);
		ImageIcon logo = createImageIcon("../Imagenes/logo.jpg");
		
		final JPanel PanelLogin = new JPanel();
		PanelLogin.setBackground(new Color(135, 206, 250));
		tabbedPane.addTab("Login", null, PanelLogin, null);
		tabbedPane.setEnabledAt(0, true);
		PanelLogin.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBienvenido.setBounds(251, 11, 130, 30);
		
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(24, 166, 90, 14);
		PanelLogin.add(lblUsuario);

		JLabel lblContresea = new JLabel("Contrase\u00F1a:");
		lblContresea.setBounds(24, 207, 90, 17);
		PanelLogin.add(lblContresea);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(111, 163, 173, 20);
		PanelLogin.add(txtusuario);
		txtusuario.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(111, 205, 173, 20);
		PanelLogin.add(passwordField);
		
		btnIniciarSesin = new JButton("Iniciar sesi\u00F3n");
		btnIniciarSesin.setBounds(87, 290, 130, 23);
		PanelLogin.add(btnIniciarSesin);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(309, 76, 379, 250);
		ImageIcon logo1 = createImageIcon("../Imagenes/Logo.jpg");
		Icon imagen= new ImageIcon(logo1.getImage().getScaledInstance(lblLogo.getWidth(),lblLogo.getHeight(), Image.SCALE_DEFAULT)); //la modificamos al tamaño del label
		lblLogo.setIcon(imagen);
		PanelLogin.add(lblLogo);
		
		btnRegistroUsuario = new JButton("Registrarse");
		btnRegistroUsuario.setBounds(87, 324, 130, 23);
		PanelLogin.add(btnRegistroUsuario);

		
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++		
		///++++Acá esta el panel donde esta toda la información para registrarse 
		
		JPanel PanelRegistrarse = new JPanel();
		PanelRegistrarse.setBackground(new Color(135, 206, 250));
		tabbedPane.addTab("Registrarse", null, PanelRegistrarse, null);
		tabbedPane.setEnabledAt(1, false);
		PanelRegistrarse.setLayout(null);;
		
		JLabel lblPorFavorNo = new JLabel("Por favor, no deje campos vac\u00EDos");
		lblPorFavorNo.setBounds(10, 11, 238, 14);
		PanelRegistrarse.add(lblPorFavorNo);
		
		JLabel lblNick = new JLabel("Nick:");
		lblNick.setBounds(118, 179, 46, 14);
		PanelRegistrarse.add(lblNick);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(118, 221, 78, 14);
		PanelRegistrarse.add(lblContrasea);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(118, 57, 88, 14);
		PanelRegistrarse.add(lblNewLabel);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(223, 218, 175, 20);
		PanelRegistrarse.add(passwordField_1);
		
		txtNick = new JTextField();
		txtNick.setBounds(223, 176, 175, 20);
		PanelRegistrarse.add(txtNick);
		txtNick.setColumns(10);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(223, 54, 175, 20);
		PanelRegistrarse.add(txtnombre);
		txtnombre.setColumns(10);
		
		JLabel lblPrivacidad = new JLabel("Privacidad:");
		lblPrivacidad.setBounds(139, 282, 78, 14);
		PanelRegistrarse.add(lblPrivacidad);
		
		rdbtnDatosPblicos = new JRadioButton("Datos P\u00FAblicos");
		buttonGroup.add(rdbtnDatosPblicos);
		rdbtnDatosPblicos.setBackground(new Color(135, 206, 250));
		rdbtnDatosPblicos.setBounds(223, 303, 133, 23);
		PanelRegistrarse.add(rdbtnDatosPblicos);
		
	    rdbtnDatosPrivados = new JRadioButton("Datos Privados");
		buttonGroup.add(rdbtnDatosPrivados);
		rdbtnDatosPrivados.setBackground(new Color(135, 206, 250));
		rdbtnDatosPrivados.setBounds(223, 341, 133, 23);
		PanelRegistrarse.add(rdbtnDatosPrivados);
		
		btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(548, 354, 112, 23);
		PanelRegistrarse.add(btnRegistrarse);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido:");
		lblPrimerApellido.setBounds(118, 96, 99, 14);
		PanelRegistrarse.add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido:");
		lblSegundoApellido.setBounds(105, 140, 112, 14);
		PanelRegistrarse.add(lblSegundoApellido);
		
		txtPrimerApellido = new JTextField();
		txtPrimerApellido.setBounds(223, 93, 175, 20);
		PanelRegistrarse.add(txtPrimerApellido);
		txtPrimerApellido.setColumns(10);
		
		txtSegundoApellido = new JTextField();
		txtSegundoApellido.setBounds(223, 137, 175, 20);
		PanelRegistrarse.add(txtSegundoApellido);
		txtSegundoApellido.setColumns(10);
	}
	

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Usuario.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

	
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	////Métodos que implementan la vista

	public void IniciarUsuario(aplicacion.Usuario usuario) {
		this.frmBienvenidoAFunes.dispose();
	}

	public void showRegistro() {
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.remove(0);
	}
	
	public void showEmpresa(DefaultComboBoxModel tipo) {
		// TODO Auto-generated method stub	
	}

	public void llenarPersona(DefaultComboBoxModel tipo) {
		// TODO Auto-generated method stub	
	}

	public void llenarJuridica(DefaultComboBoxModel tipo) {
		// TODO Auto-generated method stub		
	}

	public void llenarDatosRegistro(DefaultListModel datos) {
		// TODO Auto-generated method stub		
	}

	public void IniciarEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
	}

	public void IniciarPersona(RegistroPersona persona) {
		// TODO Auto-generated method stub
	}

	public void showPersona(DefaultListModel model, DefaultComboBoxModel tipo) {
		// TODO Auto-generated method stub
	}

	public void agregarlista(DefaultListModel nuevo) {
		// TODO Auto-generated method stub	
	}

	public void llenarcmbCalificar(DefaultComboBoxModel model) {
		// TODO Auto-generated method stub		
	}

	public void mostrarVentanaEvidencia(String nombre, String pathArchivo) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void datosencontrados(String genero, String nombre, String primero,
			String segundo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarestrella(int estrella, boolean estado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarresultados(DefaultListModel modelo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarInformacionEmpresa(Empresa mostrar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarInformacionPersona(RegistroPersona mostrar) {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void Icomentarios(Calificacion n, aplicacion.Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void llenardatos(aplicacion.Usuario u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarabusos(Date fechaDenuncia, String motivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void CuentaEliminada() {
		// TODO Auto-generated method stub
		
	}

}
