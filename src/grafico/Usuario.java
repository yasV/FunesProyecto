
package grafico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.Icon;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ComponentListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ButtonGroup;
import javax.swing.JScrollBar;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import java.awt.CardLayout;

import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

import entidades.Empresa;
import entidades.RegistroPersona;
import aplicacion.Funciones;
import aplicacion.Sistema;
import auxiliares.Calificacion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

import javax.swing.UIManager;

public class Usuario extends JFrame implements Funciones {
	private ArrayList<JButton> estrellas = new ArrayList <JButton>();
	private Controlador controlador;
	public Empresa empresa;
	public RegistroPersona persona;
	private JPanel contentPane;
	private final JComboBox cmbTipoBusqueda = new JComboBox();
	public JTextField txtRegistroReview;
	public  JTextField txtpais;
	public JTextField txtcanton;
	public JTextField txtdistrito;
	public JTextField txtbarrio;
	public JTextField txtnombrejuri;
	public JTextField txtcedulajuri;
	private Container buttonGroup;
	public JTextField txtmás;
	public JTextField txtnombre;
	public JTextField txtprimero;
	public JTextField txtSApellido;
	public JTextField txtcedula;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	public JTextField txtdia;
	public JTextField txtaño;
	public JTextField txtinstitucion;
	public JTextField txtcargo;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	public JTextField txtUsuarioComment;
	public JTextField txtComment;
	public JTextField datobuscarConsultar;
	private ImageIcon noMarcado = createImageIcon("../Imagenes/nomarc.png"); //buscar esta ruta
	private ImageIcon marcado = createImageIcon("../Imagenes/marc.png"); //buscar esta ruta
	public JTextField txtusuario;
	public JTextField txtNick;
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	public JTextField txtabusos;
	private JPasswordField actual;
	private JPasswordField nueva;
	public JRadioButton rdbtnDatosPblicos;
	public JRadioButton rdbtnDatosPrivados;
	public JComboBox cboxprovincia;
	private JButton btnGuardarCambios;
	public JButton btnRegistrarJuridica;
	private JButton btnGuardarCalificacion;
	private JButton btnSubirEvidencia;
	private  JButton btnusuarioNoRegistrado;
	private JButton btnRegistrar_1;
	private JButton btnA;
	public JRadioButton rdbtnFemenino;
	public JRadioButton rdbtnMasculino;
	public JComboBox cboxmes;
	public JRadioButton rdbtnSenasa;
	public JRadioButton rdbtnEmpresas;
	public JRadioButton rdbtnPani;
	public JRadioButton rdbtnRestaurante;
	public JRadioButton rdbtnCondominios;
	private JTabbedPane tabbedPane;
	public JRadioButton rdbtnPersonaFisica;
	public JRadioButton rdbtnPersonaJurdica;
	private JButton btnBuscarConsultar;
	public JRadioButton rdbtnFisicaCalificar;
	public JRadioButton rdbtnJuridicaCalificar;
	private JComboBox cmbPersonaCalificar;
	public JLabel lblNdevidencia;
	public JRadioButton rdbtnFsicaConsultar;
	public JRadioButton rdbtnJurdicasConsultar;
	public JList list;
	public JButton btnConsultar;
	public JButton estrella1;
	public JButton estrella2;
	public JButton estrella3;
	public JButton estrella4;
	public JButton estrella5;
	public JButton estrella6;
	public JButton estrella7;
	public JButton estrella8;
	public JButton estrella9;
	public JButton estrella10;
	public JLabel lblnombre;
	private boolean nuevo = false; //Variable para saber si la empresa ya se encuentra o no se encuentra. 
	public JList listaconsultar;
	public JButton btnVerInformacin;
	public JButton btnVerComentarios;
	public JButton btnVerInformacinDel;
	public JButton btnEliminar;
	public JButton btnAnterior;
	public JButton btnSiguiente;
	

	
	public Usuario(Sistema model,Controlador usar) {
		controlador = usar;
		controlador.C_Usuario(this);
		initialize();
		addEvents();
	}
	
	public JComboBox getCboxprovincia() {
		return cboxprovincia;
	}

	public JButton getBtnGuardarCambios() {
		return btnGuardarCambios;
	}

	public JButton getBtnRegistrar() {
		return btnRegistrarJuridica;
	}

	public JButton getBtnGuardarCalificacion() {
		return btnGuardarCalificacion;
	}

	public JButton getBtnSubirEvidencia() {
		return btnSubirEvidencia;
	}

	public JButton getBtnusuarioNoRegistrado() {
		return btnusuarioNoRegistrado;
	}

	public JButton getBtnRegistrar_1() {
		return btnRegistrar_1;
	}

	public JButton getBtnA() {
		return btnA;
	}

	public JComboBox getComboBox_4() {
		return cboxmes;
	}

	public JComboBox getComboBox() {
		return cmbTipoBusqueda;
	}
	
	public JComboBox getCmbTipoBusqueda(){
		return cmbTipoBusqueda;
	}
	
	public JButton getBtnBuscarConsultar(){
		return btnBuscarConsultar;
	}
	
	public JComboBox getCmbPersonaCalificar(){
		return cmbPersonaCalificar;
	}

	private void addEvents() {
		this.btnA.addActionListener(controlador);
		this.btnGuardarCalificacion.addActionListener(controlador);
		this.btnGuardarCambios.addActionListener(controlador);
		this.btnRegistrarJuridica.addActionListener(controlador);
		this.btnRegistrar_1.addActionListener(controlador);
		this.btnSubirEvidencia.addActionListener(controlador);
		this.btnusuarioNoRegistrado.addActionListener(controlador);
		this.cboxprovincia.addActionListener(controlador);
		this.cmbTipoBusqueda.addActionListener(controlador);
		this.rdbtnFsicaConsultar.addActionListener(controlador);
		this.rdbtnJurdicasConsultar.addActionListener(controlador);
		this.btnConsultar.addActionListener(controlador);
		this.cboxmes.addActionListener(controlador);
		this.rdbtnFisicaCalificar.addActionListener(controlador);
		this.rdbtnFsicaConsultar.addActionListener(controlador);
		this.rdbtnJuridicaCalificar.addActionListener(controlador);
		this.rdbtnJurdicasConsultar.addActionListener(controlador);
		this.btnVerInformacin.addActionListener(controlador);
		this.cmbTipoBusqueda.addActionListener(controlador);
		this.btnBuscarConsultar.addActionListener(controlador);
		this.btnVerComentarios.addActionListener(controlador);
		this.btnVerInformacinDel.addActionListener(controlador);
		this.btnAnterior.addActionListener(controlador);
		this.btnSiguiente.addActionListener(controlador);
		
		for (JButton u : estrellas){
			u.addActionListener(controlador);
		}
    }
	
	public void initialize(){
		setTitle("Sistema Funes-Usuario");
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 493);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 702, 442);
		contentPane.add(tabbedPane);

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		////Acá comienza el panel de la página principal del usuario, donde ve sus datos 
		
		JPanel PagUsuario = new JPanel();
		PagUsuario.setBackground(new Color(135, 206, 250));
		tabbedPane.addTab("Página Principal", null, PagUsuario, null);
		PagUsuario.setLayout(null);
		
		JLabel lblBienvenidoUsuario = new JLabel("Bienvenido Usuario");
		lblBienvenidoUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBienvenidoUsuario.setBounds(10, 11, 206, 29);
		PagUsuario.add(lblBienvenidoUsuario);
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(20, 70, 46, 14);
		PagUsuario.add(lblNombre_1);
		
		txtusuario = new JTextField();
		txtusuario.setEditable(false);
		txtusuario.setBounds(101, 67, 241, 20);
		PagUsuario.add(txtusuario);
		txtusuario.setColumns(10);
		
		JLabel lblNick = new JLabel("Nick:");
		lblNick.setBounds(20, 127, 46, 14);
		PagUsuario.add(lblNick);
		
		txtNick = new JTextField();
		txtNick.setEditable(false);
		txtNick.setColumns(10);
		txtNick.setBounds(101, 124, 241, 20);
		PagUsuario.add(txtNick);
		
		JLabel lblPrivacidad = new JLabel("Privacidad: ");
		lblPrivacidad.setBounds(20, 189, 88, 14);
		PagUsuario.add(lblPrivacidad);
		
		rdbtnDatosPblicos = new JRadioButton("Datos P\u00FAblicos");
		rdbtnDatosPblicos.setBackground(new Color(135, 206, 250));
		rdbtnDatosPblicos.setEnabled(false);
		buttonGroup_4.add(rdbtnDatosPblicos);
		rdbtnDatosPblicos.setBounds(59, 215, 157, 23);
		PagUsuario.add(rdbtnDatosPblicos);
		
		rdbtnDatosPrivados = new JRadioButton("Datos Privados");
		rdbtnDatosPrivados.setBackground(new Color(135, 206, 250));
		rdbtnDatosPrivados.setEnabled(false);
		buttonGroup_4.add(rdbtnDatosPrivados);
		rdbtnDatosPrivados.setBounds(59, 241, 138, 23);
		PagUsuario.add(rdbtnDatosPrivados);
		
		JLabel lblCantidadDeAbusos = new JLabel("Cantidad de abusos reportados");
		lblCantidadDeAbusos.setBounds(405, 70, 215, 14);
		PagUsuario.add(lblCantidadDeAbusos);
		
		txtabusos = new JTextField();
		txtabusos.setEditable(false);
		txtabusos.setBounds(585, 67, 76, 20);
		PagUsuario.add(txtabusos);
		txtabusos.setColumns(10);
		
		JLabel lblUsuariosQueReportan = new JLabel("Usuarios que reportan abusos");
		lblUsuariosQueReportan.setBounds(405, 127, 206, 14);
		PagUsuario.add(lblUsuariosQueReportan);
		
		JPanel panellista = new JPanel();
		panellista.setBackground(new Color(240, 230, 140));
		panellista.setBounds(429, 152, 232, 97);
		PagUsuario.add(panellista);
		panellista.setLayout(new BoxLayout(panellista, BoxLayout.X_AXIS));
		
		JList list_1 = new JList();
		panellista.add(list_1);
		
		JLabel lblMsInformacin = new JLabel("M\u00E1s informaci\u00F3n");
		lblMsInformacin.setBounds(424, 260, 138, 14);
		PagUsuario.add(lblMsInformacin);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(429, 357, 221, -70);
		PagUsuario.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(429, 286, 232, 83);
		PagUsuario.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, "name_266248621586904");
		
		JFormattedTextField txtmas = new JFormattedTextField();
		txtmas.setEditable(false);
		scrollPane_1.setViewportView(txtmas);
		
		final JPanel panelcambiarco = new JPanel();
		panelcambiarco.setVisible(false);
		panelcambiarco.setBackground(new Color(135, 206, 250));
		panelcambiarco.setBounds(45, 271, 332, 98);
		PagUsuario.add(panelcambiarco);
		panelcambiarco.setLayout(null);
		
		JLabel lblContraseaActual = new JLabel("Contrase\u00F1a Actual");
		lblContraseaActual.setBounds(10, 11, 110, 14);
		panelcambiarco.add(lblContraseaActual);
		
		actual = new JPasswordField();
		actual.setBounds(135, 8, 176, 20);
		panelcambiarco.add(actual);
		
		JLabel lblContaseaNueva = new JLabel("Contase\u00F1a Nueva");
		lblContaseaNueva.setBounds(10, 41, 115, 14);
		panelcambiarco.add(lblContaseaNueva);
		
		nueva = new JPasswordField();
		nueva.setBounds(135, 38, 176, 20);
		panelcambiarco.add(nueva);
		
		btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.setBounds(82, 66, 143, 23);
		panelcambiarco.add(btnGuardarCambios);
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelcambiarco.setVisible(false);
				rdbtnDatosPblicos.setEnabled(false);
				rdbtnDatosPrivados.setEnabled(false);
			}
		});
		
		JButton btnCambiarDatos = new JButton("Cambiar Datos");
		btnCambiarDatos.setBounds(122, 339, 143, 23);
		PagUsuario.add(btnCambiarDatos);
		btnCambiarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelcambiarco.setVisible(true);
				rdbtnDatosPblicos.setEnabled(true);
				rdbtnDatosPrivados.setEnabled(true);
			}
		});

	    ButtonGroup groupTipo = new ButtonGroup();;
				
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				////Acá comienza el panel de búsquedas		
				
				JPanel Busquedas = new JPanel();
				Busquedas.setBackground(new Color(135, 206, 250));
				tabbedPane.addTab("Consultar", null, Busquedas, null);
				Busquedas.setLayout(null);
				
					    rdbtnFsicaConsultar = new JRadioButton("Persona F\u00EDsica");
					    rdbtnFsicaConsultar.setBackground(new Color(135, 206, 250));
					    rdbtnFsicaConsultar.setBounds(175, 7, 123, 23);
					    Busquedas.add(rdbtnFsicaConsultar);
					    
					    		rdbtnJurdicasConsultar = new JRadioButton("Persona Jur\u00EDdica");
					    		rdbtnJurdicasConsultar.setBackground(new Color(135, 206, 250));
					    		rdbtnJurdicasConsultar.setBounds(308, 5, 127, 23);
					    		Busquedas.add(rdbtnJurdicasConsultar);
					    		cmbTipoBusqueda.setBounds(301, 54, 134, 23);
					    		Busquedas.add(cmbTipoBusqueda);
					    		groupTipo.add(rdbtnFsicaConsultar);
					    		groupTipo.add(rdbtnJurdicasConsultar);
					    		
					    		
					    		JLabel lblBuscarPor = new JLabel("Buscar por:");
					    		lblBuscarPor.setBounds(175, 56, 112, 19);
					    		Busquedas.add(lblBuscarPor);
					    		
					    		JLabel lblSeleccione = new JLabel("Ingrese el dato a buscar:");
					    		lblSeleccione.setBounds(141, 103, 146, 19);
					    		Busquedas.add(lblSeleccione);
					    		
					    		JPanel panelComentsConsultar = new JPanel();
					    		panelComentsConsultar.setBackground(new Color(135, 206, 250));
					    		panelComentsConsultar.setBounds(190, 148, 497, 232);
					    		Busquedas.add(panelComentsConsultar);
					    		panelComentsConsultar.setLayout(null);
					    		
					    		txtUsuarioComment = new JTextField();
					    		txtUsuarioComment.setEditable(false);
					    		txtUsuarioComment.setBounds(42, 172, 166, 20);
					    		panelComentsConsultar.add(txtUsuarioComment);
					    		txtUsuarioComment.setColumns(10);
					    		
					    		txtComment = new JTextField();
					    		txtComment.setEditable(false);
					    		txtComment.setBounds(10, 0, 477, 161);
					    		panelComentsConsultar.add(txtComment);
					    		txtComment.setColumns(10);
					    		
					    		 btnVerInformacinDel = new JButton("Ver informaci\u00F3n del Usuario");
					    		btnVerInformacinDel.setEnabled(false);
					    		btnVerInformacinDel.setBounds(248, 171, 213, 23);
					    		panelComentsConsultar.add(btnVerInformacinDel);
					    	
					    		btnEliminar = new JButton("Eliminar");
					    		btnEliminar.setEnabled(false);
					    		btnEliminar.setBounds(181, 205, 89, 23);
					    		panelComentsConsultar.add(btnEliminar);
					    		
					    		 btnAnterior = new JButton("Anterior");
					    		btnAnterior.setBounds(308, 391, 89, 23);
					    		Busquedas.add(btnAnterior);
					    		
					    		 btnSiguiente = new JButton("Siguiente");
					    		btnSiguiente.setBounds(438, 391, 89, 23);
					    		Busquedas.add(btnSiguiente);
					    		
					    		datobuscarConsultar = new JTextField();
					    		datobuscarConsultar.setBounds(300, 102, 135, 20);
					    		Busquedas.add(datobuscarConsultar);
					    		datobuscarConsultar.setColumns(10);
					    		
					    		btnBuscarConsultar = new JButton("Buscar");
					    		btnBuscarConsultar.setBounds(490, 74, 117, 23);
					    		Busquedas.add(btnBuscarConsultar);
					    		
					    		JPanel listaConsultar = new JPanel();
					    		listaConsultar.setBounds(10, 148, 170, 204);
					    		Busquedas.add(listaConsultar);
					    		
					    		listaconsultar = new JList();
					    		listaConsultar.add(listaconsultar);
					    		
					    	    btnVerComentarios = new JButton("Ver Comentarios");
					    		btnVerComentarios.setBounds(20, 357, 146, 23);
					    		Busquedas.add(btnVerComentarios);
					    		
					    		btnVerInformacin = new JButton("Ver informaci\u00F3n");
					    		btnVerInformacin.setBounds(30, 391, 134, 23);
					    		Busquedas.add(btnVerInformacin);
		
				
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				////Acá comienza el panel de calificar a alguna persona
				
				JPanel Calificar = new JPanel();
				Calificar.setBackground(new Color(135, 206, 250));
				tabbedPane.addTab("Calificar", null, Calificar, null);
				Calificar.setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setBounds(155, 98, 370, 50);
				panel.setBackground(new Color(135, 206, 250));
				Calificar.add(panel);
				panel.setLayout(null);
				
				estrella1 = new JButton("");
				estrella1.setBounds(10, 5, 36, 35);
				panel.add(estrella1);
				estrella1.setBackground(new Color(51, 204, 255));
				estrella1.setIcon(noMarcado);
				estrella1.setBorderPainted(false);
				
				estrella2 = new JButton("");
				estrella2.setBounds(47, 5, 36, 35);
				estrella2.setBorderPainted(false);
				estrella2.setBackground(new Color(51, 204, 255));
				estrella2.setIcon(noMarcado);
				panel.add(estrella2);
				
				estrella3 = new JButton("");
				estrella3.setBounds(80, 5, 36, 35);
				estrella3.setBorderPainted(false);
				estrella3.setBackground(new Color(51, 204, 255));
				estrella3.setIcon(noMarcado);
				panel.add(estrella3);
				
				estrella4 = new JButton("");
				estrella4.setBounds(114, 5, 36, 35);
				estrella4.setBorderPainted(false);
				estrella4.setBackground(new Color(51, 204, 255));
				estrella4.setIcon(noMarcado);
				panel.add(estrella4);
				
				estrella5 = new JButton("");
				estrella5.setBounds(147, 5, 36, 35);
				estrella5.setBorderPainted(false);
				estrella5.setBackground(new Color(51, 204, 255));
				estrella5.setIcon(noMarcado);
				panel.add(estrella5);
				
				estrella6 = new JButton("");
				estrella6.setBounds(181, 5, 36, 35);
				estrella6.setBorderPainted(false);
				estrella6.setBackground(new Color(51, 204, 255));
				estrella6.setIcon(noMarcado);
				panel.add(estrella6);
				
				estrella7 = new JButton("");
				estrella7.setBounds(217, 5, 36, 35);
				estrella7.setBorderPainted(false);
				estrella7.setBackground(new Color(51, 204, 255));
				estrella7.setIcon(noMarcado);
				panel.add(estrella7);
				
				estrella8 = new JButton("");
				estrella8.setBounds(248, 5, 36, 35);
				estrella8.setBorderPainted(false);
				estrella8.setBackground(new Color(51, 204, 255));
				estrella8.setIcon(noMarcado);
				panel.add(estrella8);
				
				estrella9 = new JButton("");
				estrella9.setBounds(282, 5, 36, 35);
				estrella9.setIcon(noMarcado);
				estrella9.setBorderPainted(false);
				estrella9.setBackground(new Color(51, 204, 255));
				panel.add(estrella9);
				
				estrella10 = new JButton("");
				estrella10.setBounds(313, 5, 36, 35);
				estrella10.setBorderPainted(false);
				estrella10.setIcon(noMarcado);
				estrella10.setBackground(new Color(51, 204, 255));
				panel.add(estrella10);
				
				rdbtnFisicaCalificar = new JRadioButton("Persona F\u00EDsica");
				rdbtnFisicaCalificar.setBounds(152, 7, 124, 23);
				buttonGroup_2.add(rdbtnFisicaCalificar);
				rdbtnFisicaCalificar.setBackground(new Color(135, 206, 250));
				Calificar.add(rdbtnFisicaCalificar);
				
				rdbtnJuridicaCalificar = new JRadioButton("Persona Jur\u00EDdica");
				rdbtnJuridicaCalificar.setBounds(293, 7, 124, 23);
				buttonGroup_2.add(rdbtnJuridicaCalificar);
				rdbtnJuridicaCalificar.setBackground(new Color(135, 206, 250));
				Calificar.add(rdbtnJuridicaCalificar);
				
				JLabel lblCalifiqueSuExperiencia = new JLabel("Califique su experiencia:");
				lblCalifiqueSuExperiencia.setBounds(13, 98, 148, 30);
				Calificar.add(lblCalifiqueSuExperiencia);
				
				cmbPersonaCalificar = new JComboBox();
				cmbPersonaCalificar.setBounds(197, 53, 180, 23);
				Calificar.add(cmbPersonaCalificar);
				
				JLabel lblUsuarioACalificar = new JLabel("Nombre de persona a calificar:");
				lblUsuarioACalificar.setBounds(13, 53, 177, 23);
				Calificar.add(lblUsuarioACalificar);
				
				txtRegistroReview = new JTextField();
				txtRegistroReview.setBounds(34, 172, 505, 134);
				Calificar.add(txtRegistroReview);
				txtRegistroReview.setColumns(10);
				
				JLabel lblRegistreUnReview = new JLabel("Registre un review");
				lblRegistreUnReview.setBounds(13, 149, 124, 23);
				Calificar.add(lblRegistreUnReview);
				
				btnGuardarCalificacion = new JButton("Guardar \r\nCalificaci\u00F3n");
				btnGuardarCalificacion.setBounds(494, 346, 174, 23);
				Calificar.add(btnGuardarCalificacion);
				
				btnSubirEvidencia = new JButton("Subir Evidencia");
				btnSubirEvidencia.setBounds(34, 318, 127, 23);
				Calificar.add(btnSubirEvidencia);
				
				btnusuarioNoRegistrado = new JButton("\u00BFNo encuentra a la persona?");
				btnusuarioNoRegistrado.setBounds(421, 53, 247, 23);
				Calificar.add(btnusuarioNoRegistrado);
				
				lblNdevidencia = new JLabel("");
				lblNdevidencia.setBounds(34, 350, 439, 14);
				Calificar.add(lblNdevidencia);

				estrellas.add(estrella1);
				estrellas.add(estrella2);
				estrellas.add(estrella3);
				estrellas.add(estrella4);
				estrellas.add(estrella5);
				estrellas.add(estrella6);
				estrellas.add(estrella7);
				estrellas.add(estrella8);
				estrellas.add(estrella9);
				estrellas.add(estrella10);
				
				lblnombre = new JLabel("");
				lblnombre.setBounds(34, 376, 452, 14);
				Calificar.add(lblnombre);
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		////Acá comienza el panel del registro de empresas
		
		JPanel Juridica = new JPanel();
		Juridica.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Registro de Persona Jur\u00EDdica", null, Juridica, null);
		tabbedPane.setEnabledAt(3, false);
		//tabbedPane.setEnabledAt(8, false);
		Juridica.setLayout(null);
		
		rdbtnSenasa = new JRadioButton("Senasa");
		buttonGroup_3.add(rdbtnSenasa);
		rdbtnSenasa.setBackground(new Color(135, 206, 250));
		rdbtnSenasa.setBounds(25, 43, 91, 23);
		Juridica.add(rdbtnSenasa);
			
		rdbtnEmpresas = new JRadioButton("Empresas");
		buttonGroup_3.add(rdbtnEmpresas);
		rdbtnEmpresas.setBackground(new Color(135, 206, 250));
		rdbtnEmpresas.setBounds(145, 43, 91, 23);
		Juridica.add(rdbtnEmpresas);
				
		rdbtnPani = new JRadioButton("PANI");
		buttonGroup_3.add(rdbtnPani);
		rdbtnPani.setBackground(new Color(135, 206, 250));
		rdbtnPani.setBounds(261, 43, 91, 23);
		Juridica.add(rdbtnPani);
					
		rdbtnRestaurante = new JRadioButton("Restaurantes");
		buttonGroup_3.add(rdbtnRestaurante);			
		rdbtnRestaurante.setBackground(new Color(135, 206, 250));
		rdbtnRestaurante.setBounds(373, 43, 117, 23);
		Juridica.add(rdbtnRestaurante);
						
		rdbtnCondominios = new JRadioButton("Condominios");
		buttonGroup_3.add(rdbtnCondominios);
		rdbtnCondominios.setBackground(new Color(135, 206, 250));
		rdbtnCondominios.setBounds(507, 43, 127, 23);
		Juridica.add(rdbtnCondominios);
							
		JLabel lblSeleccionesUnaCatego = new JLabel("*Seleccione una categor\u00EDa");
		lblSeleccionesUnaCatego.setBounds(10, 11, 149, 14);
		Juridica.add(lblSeleccionesUnaCatego);
							
		JLabel lblNombreDeLa = new JLabel("*Nombre de la Persona Jur\u00EDdica: ");
		lblNombreDeLa.setBounds(47, 93, 200, 14);
		Juridica.add(lblNombreDeLa);
							
		txtnombrejuri = new JTextField();
		txtnombrejuri.setBounds(245, 90, 219, 20);
		Juridica.add(txtnombrejuri);
		txtnombrejuri.setColumns(10);
							
		JLabel lblCdulaJurdica = new JLabel("C\u00E9dula Jur\u00EDdica:");
		lblCdulaJurdica.setBounds(109, 124, 127, 14);
		Juridica.add(lblCdulaJurdica);
							
		txtcedulajuri = new JTextField();
		txtcedulajuri.setBounds(245, 121, 219, 20);
		Juridica.add(txtcedulajuri);
		txtcedulajuri.setColumns(10);
							
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDireccin.setBounds(222, 152, 91, 23);
		Juridica.add(lblDireccin);
							
		JLabel lblPas = new JLabel("*Pa\u00EDs");
		lblPas.setBounds(10, 199, 46, 14);
		Juridica.add(lblPas);
							
		JLabel lblProvincia = new JLabel("*Provincia");
		lblProvincia.setBounds(10, 237, 60, 14);
		Juridica.add(lblProvincia);
							
		JLabel lblCantn = new JLabel("*Cant\u00F3n");
		lblCantn.setBounds(284, 199, 46, 14);
		Juridica.add(lblCantn);
							
		JLabel lblDistrito = new JLabel("*Distrito");
		lblDistrito.setBounds(284, 237, 46, 14);
		Juridica.add(lblDistrito);
							
		txtpais = new JTextField();
		txtpais.setBounds(66, 196, 188, 20);
		Juridica.add(txtpais);
		txtpais.setColumns(10);
							
		cboxprovincia = new JComboBox();
		cboxprovincia.setBounds(76, 234, 181, 20);
		Juridica.add(cboxprovincia);
							
		txtcanton = new JTextField();
		txtcanton.setColumns(10);
		txtcanton.setBounds(355, 196, 188, 20);
		Juridica.add(txtcanton);
							
		txtdistrito = new JTextField();
		txtdistrito.setColumns(10);
		txtdistrito.setBounds(355, 234, 188, 20);
		Juridica.add(txtdistrito);
							
		JLabel lblBarrio = new JLabel("*Barrio");
		lblBarrio.setBounds(284, 272, 46, 14);
		Juridica.add(lblBarrio);
							
		txtbarrio = new JTextField();
		txtbarrio.setColumns(10);
		txtbarrio.setBounds(355, 269, 188, 20);
		Juridica.add(txtbarrio);
							
		JLabel lblLosCamposMarcados = new JLabel("Los campos marcados con * son necesarios");
		lblLosCamposMarcados.setBounds(21, 350, 320, 14);
		Juridica.add(lblLosCamposMarcados);
							
		btnRegistrarJuridica = new JButton("Registrar");
		btnRegistrarJuridica.setBounds(494, 346, 89, 23);
		Juridica.add(btnRegistrarJuridica);
		
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		////Acá comienza el panel del registro de personas fisicas					
		JPanel Fisica = new JPanel();
		Fisica.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Registro de Persona Física", null, Fisica, null);
		tabbedPane.setEnabledAt(4, false);
		//tabbedPane.setBackgroundAt(4, new Color(173, 216, 230));
		Fisica.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("*Seleccione una categor\u00EDa. Puede agregar m\u00E1s categor\u00EDas en el campo vac\u00EDo de abajo");
		lblNewLabel.setBounds(10, 11, 573, 14);
		Fisica.add(lblNewLabel);
		
		JPanel lista = new JPanel();
		lista.setBounds(20, 36, 160, 204);
		Fisica.add(lista);
		
	    list = new JList();
		lista.add(list);
		
		txtmás = new JTextField();
		txtmás.setBounds(20, 249, 160, 20);
		Fisica.add(txtmás);
		txtmás.setColumns(10);
		
		 btnA = new JButton("Agregar");
		btnA.setBounds(46, 280, 89, 23);
		Fisica.add(btnA);
		
		JLabel lblNombre = new JLabel("*Nombre");
		lblNombre.setBounds(244, 98, 83, 14);
		Fisica.add(lblNombre);
		
		JLabel lblCdula = new JLabel("*C\u00E9dula");
		lblCdula.setBounds(236, 36, 46, 14);
		Fisica.add(lblCdula);
		
		txtnombre = new JTextField();
		txtnombre.setEnabled(false);
		txtnombre.setBounds(229, 67, 138, 20);
		Fisica.add(txtnombre);
		txtnombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("*Primer Apellido");
		lblApellido.setBounds(424, 98, 104, 14);
		Fisica.add(lblApellido);
		
		txtprimero = new JTextField();
		txtprimero.setEnabled(false);
		txtprimero.setBounds(390, 68, 138, 20);
		Fisica.add(txtprimero);
		txtprimero.setColumns(10);
		
		JLabel lblSegundoApellido = new JLabel("*Segundo Apellido");
		lblSegundoApellido.setBounds(564, 98, 104, 14);
		Fisica.add(lblSegundoApellido);
		
		txtSApellido = new JTextField();
		txtSApellido.setEnabled(false);
		txtSApellido.setColumns(10);
		txtSApellido.setBounds(538, 67, 138, 20);
		Fisica.add(txtSApellido);
		
		txtcedula = new JTextField();
		txtcedula.setColumns(10);
		txtcedula.setBounds(292, 36, 138, 20);
		Fisica.add(txtcedula);
		
		JLabel lblGenero = new JLabel("G\u00E9nero");
		lblGenero.setBounds(229, 156, 46, 14);
		Fisica.add(lblGenero);
		
		 rdbtnFemenino = new JRadioButton("Femenino");
		 rdbtnFemenino.setEnabled(false);
		rdbtnFemenino.setBackground(new Color(135, 206, 250));
		buttonGroup_1.add(rdbtnFemenino);
		rdbtnFemenino.setBounds(289, 152, 111, 23);
		Fisica.add(rdbtnFemenino);
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setEnabled(false);
		rdbtnMasculino.setBackground(new Color(135, 206, 250));
		buttonGroup_1.add(rdbtnMasculino);
		rdbtnMasculino.setBounds(291, 180, 109, 23);
		Fisica.add(rdbtnMasculino);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFechaDeNacimiento.setBounds(376, 222, 138, 14);
		Fisica.add(lblFechaDeNacimiento);
		
		JLabel lblDa = new JLabel("*D\u00EDa");
		lblDa.setBounds(244, 252, 31, 14);
		Fisica.add(lblDa);
		
		JLabel lblMes = new JLabel("*Mes");
		lblMes.setBounds(348, 252, 31, 14);
		Fisica.add(lblMes);
		
		txtdia = new JTextField();
		txtdia.setBounds(281, 249, 46, 20);
		Fisica.add(txtdia);
		txtdia.setColumns(10);
		
		cboxmes = new JComboBox();
		cboxmes.setBounds(390, 249, 138, 20);
		Fisica.add(cboxmes);
		
		JLabel lblAo = new JLabel("*A\u00F1o");
		lblAo.setBounds(552, 252, 31, 14);
		Fisica.add(lblAo);
		
		txtaño = new JTextField();
		txtaño.setColumns(10);
		txtaño.setBounds(580, 249, 55, 20);
		Fisica.add(txtaño);
		
		JLabel lblInstitucinDondeLabora = new JLabel("*Instituci\u00F3n donde labora:");
		lblInstitucinDondeLabora.setBounds(244, 312, 192, 14);
		Fisica.add(lblInstitucinDondeLabora);
		
		JLabel lblEmpleo = new JLabel("Empleo");
		lblEmpleo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmpleo.setBounds(390, 279, 138, 21);
		Fisica.add(lblEmpleo);
		
		JLabel lblCargoQueOcupa = new JLabel("*Cargo que ocupa");
		lblCargoQueOcupa.setBounds(244, 337, 189, 14);
		Fisica.add(lblCargoQueOcupa);
		
		txtinstitucion = new JTextField();
		txtinstitucion.setColumns(10);
		txtinstitucion.setBounds(446, 309, 189, 20);
		Fisica.add(txtinstitucion);
		
		txtcargo = new JTextField();
		txtcargo.setColumns(10);
		txtcargo.setBounds(445, 334, 190, 20);
		Fisica.add(txtcargo);
		
		btnRegistrar_1 = new JButton("Registrar");
		btnRegistrar_1.setBounds(46, 346, 89, 23);
		Fisica.add(btnRegistrar_1);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(454, 32, 89, 23);
		Fisica.add(btnConsultar);
	}
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
			
	
	 /** Returns an ImageIcon, or null if the path was invalid. */
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
		//Carga los datos del usuario en la pantalla de usuario 
		
		this.setVisible(true);
		txtusuario.setText(usuario.getNombre()); //Carga el usuario
		txtNick.setText(usuario.getNick());//Carga el nombre
		//Setea los datos
		if (usuario.isPrivado()){
			rdbtnDatosPblicos.setSelected(true);
		}
		else{
			rdbtnDatosPrivados.setSelected(true);
		}
		txtabusos.setText(Integer.toString(usuario.getReportes()));
	}

	public void showPersona(DefaultListModel model,DefaultComboBoxModel tipo) {
		tabbedPane.setEnabledAt(4,true);
		tabbedPane.setSelectedIndex(4);
		list.setModel(model);
		this.cboxmes.setModel(tipo);
	}
	
	public void showEmpresa(DefaultComboBoxModel tipo) {
		tabbedPane.setEnabledAt(3,true);
		cboxprovincia.setModel(tipo);
		tabbedPane.setSelectedIndex(3);
	}
	
	//Llena con los datos con los que se puede buscar
	public void llenarPersona(DefaultComboBoxModel tipo){
		cmbTipoBusqueda.setModel(tipo);
	}
		
	public void llenarJuridica(DefaultComboBoxModel tipo){
		cmbTipoBusqueda.setModel(tipo);
	}
	
	public void IniciarEmpresa(Empresa empresa) {
		tabbedPane.setEnabledAt(3,false);
		tabbedPane.setSelectedIndex(2);
		this.empresa=empresa;
		cmbPersonaCalificar.removeAll();
		DefaultComboBoxModel n = new DefaultComboBoxModel();
		n.addElement("-----------------------");
		n.addElement(empresa.getNombre());
		cmbPersonaCalificar.setModel(n);
		this.nuevo=true;
	}

	public void IniciarPersona(RegistroPersona persona) {
		tabbedPane.setEnabledAt(4,false);
		tabbedPane.setSelectedIndex(2);
		this.persona=persona;
		cmbPersonaCalificar.removeAll();
		DefaultComboBoxModel n = new DefaultComboBoxModel();
		n.addElement("-----------------------");
		n.addElement(empresa.getNombre());
		cmbPersonaCalificar.setModel(n);
		this.nuevo=true;
	}

	public void agregarlista(DefaultListModel nuevo) {
		list.removeAll();
		list.setModel(nuevo);
		txtmás.setText(" ");
	}

	public void llenarDatosRegistro(DefaultListModel datos) {
		listaconsultar.setModel(datos);
	}
	
	public void llenarcmbCalificar(DefaultComboBoxModel model) {
		cmbPersonaCalificar.setModel(model);;
	}
	
	public void showRegistro() {
		// TODO Auto-generated method stub
	}
	
	//Abre la ventana para elegir el archivo a cargar como evidencia
	public void mostrarVentanaEvidencia(String nombre, String pathArchivo) {
		lblNdevidencia.setText(pathArchivo);
		lblnombre.setText(nombre);
		
	}

	@Override
	public void datosencontrados(String genero, String nombre, String primero,
			String segundo) {
		//Carga los datos del registro
		this.txtnombre.setText(nombre);
		this.txtprimero.setText(primero);
		this.txtSApellido.setText(segundo);
		if (genero.equals("1")){
			this.rdbtnMasculino.setSelected(true);
		}
		else{
			this.rdbtnFemenino.setSelected(true);
		}
	}

	@Override
	public void actualizarestrella(int estrella, boolean estado) {
		if (estado){
			//Este while lo que va a hacer es pintar las estrellas hasta la que se selecciono
			for (int i=0;i<=estrella;i++)
				estrellas.get(i).setIcon(marcado);
				
			}
		
		else{
			for (int i=9;i>estrella;i--){
				estrellas.get(i).setIcon(noMarcado);
			}
			}
		}

	@Override
	public void mostrarresultados(DefaultListModel x) {
		listaconsultar.removeAll();
		listaconsultar.setVisible(true);
		listaconsultar.setModel(x);
		
	}

	@Override
	public void actualizarInformacionEmpresa(Empresa mostrar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarInformacionPersona(RegistroPersona mostrar) {
		// TODO Auto-generated method stub
		
	}

	
	public void Icomentarios(Calificacion n, aplicacion.Usuario usuario) {
		this.txtComment.setText(n.getComentario());
		this.txtUsuarioComment.setText(n.getUsuario().getNombre());
		this.btnVerInformacinDel.setEnabled(true);
		if (n.getUsuario()==usuario){
			this.btnEliminar.setEnabled(true);
		}
		else{
			this.btnEliminar.setEnabled(false);
		}
		
	}

	}


