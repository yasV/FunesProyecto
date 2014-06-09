
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
import java.util.Date;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

import javax.swing.UIManager;
import javax.swing.JEditorPane;

public class Usuario extends JFrame implements Funciones {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<JButton> estrellas = new ArrayList <JButton>();
	private ArrayList<JLabel> estrellasmiscalificaciones = new ArrayList<JLabel>();
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
	public JButton btnVerComentarios;
	public JButton btnVerInformacinDel;
	public JButton btnAnterior;
	public JButton btnSiguiente;
	public JButton btnEliminarCuenta;
	grafico.Calificacion cal = new grafico.Calificacion();
	public JList listaabusos;
	public JButton btnMsInformacin;
	private JFormattedTextField txtmas;
	public JButton btnMiComentario;
	public JList listamis;
	public JRadioButton rdbtnFiscasmis;
	public JRadioButton rdbtnJurdicamis;
	private JEditorPane txtmis;
	private JLabel lestrella1;
	private JLabel lestrella2;
	private JLabel lestrella3;
	private JLabel lestrella4;
	private JLabel lestrella5;
	private JLabel lestrella6;
	private JLabel lestrella7;
	private JLabel lestrella8;
	private JLabel lestrella9;
	private JLabel lestrella10;
	public JButton btnusuarioNoRegistrado;
	public JTextPane txtpersonacalificar;
	public JButton btnEliminarCalificacion;
	public JButton btnCambiarCalificacin;
	public JButton btnIrACalificar;
	private JPanel Fisica;
	private JPanel Juridica;
	public JButton btnVerInformacin;
	private JPanel paneladministrador;
	private JPanel PagUsuario;
	private JPanel Calificar;
	private JPanel Denuncias;
	public JList listactivos;
	public JList listabloqueados;
	public JButton btnBloquear;
	public JButton btnDesbloquear;
	public JButton btnVerBloqueado;
	public JButton btnVerActivo;
	public JButton btnEditar;
	public JButton btnVerUsuarios;
	public JButton btnDescargarEvidencia_1;

	
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
	
	

	private void addEvents() {
		this.btnDescargarEvidencia_1.addActionListener(controlador);
		this.btnVerUsuarios.addActionListener(controlador);
		this.btnEditar.addActionListener(controlador);
		this.btnVerBloqueado.addActionListener(controlador);
		this.btnVerActivo.addActionListener(controlador);
		this.btnBloquear.addActionListener(controlador);
		this.btnDesbloquear.addActionListener(controlador);
		this.btnA.addActionListener(controlador);
		this.btnGuardarCalificacion.addActionListener(controlador);
		this.btnGuardarCambios.addActionListener(controlador);
		this.btnRegistrarJuridica.addActionListener(controlador);
		this.btnRegistrar_1.addActionListener(controlador);
		this.btnSubirEvidencia.addActionListener(controlador);
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
		this.cmbTipoBusqueda.addActionListener(controlador);
		this.btnBuscarConsultar.addActionListener(controlador);
		this.btnVerComentarios.addActionListener(controlador);
		this.btnVerInformacinDel.addActionListener(controlador);
		this.btnAnterior.addActionListener(controlador);
		this.btnSiguiente.addActionListener(controlador);
		this.btnEliminarCuenta.addActionListener(controlador);
		this.btnMsInformacin.addActionListener(controlador);
		this.rdbtnFiscasmis.addActionListener(controlador);
		this.rdbtnJurdicamis.addActionListener(controlador);
		this.btnMiComentario.addActionListener(controlador);
		this.btnusuarioNoRegistrado.addActionListener(controlador);
		this.btnEliminarCalificacion.addActionListener(controlador);
		this.btnCambiarCalificacin.addActionListener(controlador);
		this.btnIrACalificar.addActionListener(controlador);
		this.btnVerInformacin.addActionListener(controlador);
		for (JButton u : estrellas){
			u.addActionListener(controlador);
		}
		
    }
	
	public void initialize(){
		setTitle("Sistema Funes-Usuario");
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 533);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 742, 482);
		contentPane.add(tabbedPane);

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		////Acá comienza el panel de la página principal del usuario, donde ve sus datos 
		
		PagUsuario = new JPanel();
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
		
		listaabusos = new JList();
		panellista.add(listaabusos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(429, 357, 221, -70);
		PagUsuario.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(429, 286, 232, 83);
		PagUsuario.add(panel_3);
		panel_3.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_3.add(scrollPane_1, "name_266248621586904");
		
		 txtmas = new JFormattedTextField();
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
		
		btnEliminarCuenta = new JButton("Eliminar Cuenta");
		btnEliminarCuenta.setBounds(437, 16, 183, 23);
		PagUsuario.add(btnEliminarCuenta);
		
		btnMsInformacin = new JButton("M\u00E1s Informaci\u00F3n");
		btnMsInformacin.setBounds(483, 260, 157, 23);
		PagUsuario.add(btnMsInformacin);
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
					    rdbtnFsicaConsultar.setBounds(215, 5, 112, 23);
					    Busquedas.add(rdbtnFsicaConsultar);
					    
					    		rdbtnJurdicasConsultar = new JRadioButton("Persona Jur\u00EDdica");
					    		rdbtnJurdicasConsultar.setBackground(new Color(135, 206, 250));
					    		rdbtnJurdicasConsultar.setBounds(347, 5, 127, 23);
					    		Busquedas.add(rdbtnJurdicasConsultar);
					    		cmbTipoBusqueda.setBounds(137, 52, 134, 23);
					    		Busquedas.add(cmbTipoBusqueda);
					    		groupTipo.add(rdbtnFsicaConsultar);
					    		groupTipo.add(rdbtnJurdicasConsultar);
					    		
					    		
					    		JLabel lblBuscarPor = new JLabel("Buscar por:");
					    		lblBuscarPor.setBounds(43, 54, 112, 19);
					    		Busquedas.add(lblBuscarPor);
					    		
					    		JLabel lblSeleccione = new JLabel("Ingrese el dato a buscar:");
					    		lblSeleccione.setBounds(281, 54, 146, 19);
					    		Busquedas.add(lblSeleccione);
					    		
					    		JPanel panelComentsConsultar = new JPanel();
					    		panelComentsConsultar.setBackground(new Color(135, 206, 250));
					    		panelComentsConsultar.setBounds(190, 148, 497, 232);
					    		Busquedas.add(panelComentsConsultar);
					    		panelComentsConsultar.setLayout(null);
					    		
					    		txtUsuarioComment = new JTextField();
					    		txtUsuarioComment.setEditable(false);
					    		txtUsuarioComment.setBounds(41, 172, 166, 20);
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
					    		
					    		 btnAnterior = new JButton("");
					    		 btnAnterior.setBackground(new Color(135, 206, 250));
					    		 btnAnterior.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/back.png")));
					    		 btnAnterior.setBounds(170, 209, 57, 23);
					    		 panelComentsConsultar.add(btnAnterior);
					    		
					    		 btnSiguiente = new JButton("");
					    		 btnSiguiente.setBackground(new Color(135, 206, 250));
					    		 btnSiguiente.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/next.png")));
					    		 btnSiguiente.setBounds(237, 209, 57, 23);
					    		 panelComentsConsultar.add(btnSiguiente);
					    		
					    		datobuscarConsultar = new JTextField();
					    		datobuscarConsultar.setBounds(437, 53, 135, 20);
					    		Busquedas.add(datobuscarConsultar);
					    		datobuscarConsultar.setColumns(10);
					    		
					    		btnBuscarConsultar = new JButton("");
					    		btnBuscarConsultar.setBackground(new Color(135, 206, 250));
					    		btnBuscarConsultar.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/buscar.png")));
					    		btnBuscarConsultar.setBounds(579, 52, 57, 23);
					    		Busquedas.add(btnBuscarConsultar);
					    		
					    		JPanel listaConsultar = new JPanel();
					    		listaConsultar.setBounds(10, 148, 170, 204);
					    		Busquedas.add(listaConsultar);
					    		
					    		listaconsultar = new JList();
					    	
					    		listaConsultar.add(listaconsultar);
					    		
					    		
					    	   btnVerComentarios = new JButton("Ver Comentarios");
					    		btnVerComentarios.setBounds(28, 363, 152, 23);
					    		Busquedas.add(btnVerComentarios);
					    		
					    		JLabel lblFiltrarPor = new JLabel("Filtrar por:");
					    		lblFiltrarPor.setBounds(113, 9, 89, 14);
					    		Busquedas.add(lblFiltrarPor);
					    		
					    		btnusuarioNoRegistrado = new JButton("\u00BFNo encuentra a la persona?");
					    		btnusuarioNoRegistrado.setBounds(113, 100, 247, 23);
					    		Busquedas.add(btnusuarioNoRegistrado);
					    		
					    		 btnIrACalificar = new JButton("Ir a Calificar");
					    		btnIrACalificar.setBounds(402, 100, 123, 23);
					    		Busquedas.add(btnIrACalificar);
					    		
					    		btnVerInformacin = new JButton("Sobre la persona");
					    		btnVerInformacin.setBounds(28, 397, 152, 23);
					    		Busquedas.add(btnVerInformacin);
					    		
					    		btnDescargarEvidencia_1 = new JButton("Descargar Evidencia");
					    		btnDescargarEvidencia_1.setBounds(347, 409, 170, 23);
					    		Busquedas.add(btnDescargarEvidencia_1);
					    		
					    		btnEditar = new JButton("Editar");
					    		btnEditar.setBounds(28, 431, 152, 23);
					    		Busquedas.add(btnEditar);
		
				
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				////Acá comienza el panel de calificar a alguna persona
				
				 Calificar = new JPanel();
				Calificar.setBackground(new Color(135, 206, 250));
				tabbedPane.addTab("Calificar", null, Calificar, null);
				tabbedPane.setEnabledAt(2, false);
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
				
				 txtpersonacalificar = new JTextPane();
				 txtpersonacalificar.setEditable(false);
				txtpersonacalificar.setBounds(212, 53, 313, 20);
				Calificar.add(txtpersonacalificar);
		
		 Denuncias = new JPanel();
		Denuncias.setBackground(new Color(135, 206, 250));
		tabbedPane.addTab("Mis Calificaciones", null, Denuncias, null);
		Denuncias.setLayout(null);
		
		JLabel lblPersonasJuridcas = new JLabel("Mis personas calificadas");
		lblPersonasJuridcas.setBounds(35, 37, 145, 14);
		Denuncias.add(lblPersonasJuridcas);
		
		JPanel panelmis = new JPanel();
		panelmis.setBackground(new Color(135, 206, 250));
		panelmis.setBounds(34, 103, 146, 220);
		Denuncias.add(panelmis);
		
		 listamis = new JList();
		panelmis.add(listamis);
		
		 txtmis = new JEditorPane();
		 txtmis.setEditable(false);
		txtmis.setBounds(245, 94, 255, 191);
		Denuncias.add(txtmis);
		
		JLabel lblMiComentario = new JLabel("Mi comentario");
		lblMiComentario.setBounds(250, 66, 136, 14);
		Denuncias.add(lblMiComentario);
		
		JLabel lblMiCalificacin = new JLabel("Mi calificaci\u00F3n");
		lblMiCalificacin.setBounds(245, 341, 127, 14);
		Denuncias.add(lblMiCalificacin);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(135, 206, 250));
		panel_1.setBounds(245, 366, 370, 50);
		Denuncias.add(panel_1);
		
		lestrella1 = new JLabel("New label");
		lestrella1.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/nomarc.png")));
		lestrella1.setBounds(10, 11, 27, 28);
		panel_1.add(lestrella1);
		
		lestrella2 = new JLabel("New label");
		lestrella2.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/nomarc.png")));
		lestrella2.setBounds(43, 15, 27, 21);
		panel_1.add(lestrella2);
		
		lestrella3 = new JLabel("");
		lestrella3.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/nomarc.png")));
		lestrella3.setBounds(73, 15, 35, 21);
		panel_1.add(lestrella3);
		
		lestrella4 = new JLabel("");
		lestrella4.setAutoscrolls(true);
		lestrella4.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/nomarc.png")));
		lestrella4.setBounds(104, 11, 27, 28);
		panel_1.add(lestrella4);
		
		lestrella5 = new JLabel("");
		lestrella5.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/nomarc.png")));
		lestrella5.setBounds(141, 11, 35, 28);
		panel_1.add(lestrella5);
		
		lestrella6 = new JLabel("");
		lestrella6.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/nomarc.png")));
		lestrella6.setBounds(173, 11, 27, 28);
		panel_1.add(lestrella6);
		
		lestrella7 = new JLabel("");
		lestrella7.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/nomarc.png")));
		lestrella7.setBounds(210, 11, 27, 28);
		panel_1.add(lestrella7);
		
		lestrella8 = new JLabel("");
		lestrella8.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/nomarc.png")));
		lestrella8.setBounds(240, 11, 27, 28);
		panel_1.add(lestrella8);
		
		lestrella9 = new JLabel("");
		lestrella9.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/nomarc.png")));
		lestrella9.setBounds(277, 11, 27, 28);
		panel_1.add(lestrella9);
		
		lestrella10 = new JLabel("");
		lestrella10.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/nomarc.png")));
		lestrella10.setBounds(320, 11, 27, 28);
		panel_1.add(lestrella10);
		
		JButton btnDescargarEvidencia = new JButton("Descargar Evidencia");
		btnDescargarEvidencia.setBounds(535, 170, 192, 23);
		Denuncias.add(btnDescargarEvidencia);
		
		btnMiComentario = new JButton("Ver mi comentario");
		btnMiComentario.setBounds(35, 334, 145, 23);
		Denuncias.add(btnMiComentario);
		
		rdbtnFiscasmis = new JRadioButton("Fis\u00EDcas");
		rdbtnFiscasmis.setBackground(new Color(135, 206, 250));
		buttonGroup_1.add(rdbtnFiscasmis);
		rdbtnFiscasmis.setBounds(35, 72, 74, 23);
		Denuncias.add(rdbtnFiscasmis);
		
		 rdbtnJurdicamis = new JRadioButton("Jur\u00EDdica");
		 rdbtnJurdicamis.setBackground(new Color(135, 206, 250));
		 buttonGroup_1.add(rdbtnJurdicamis);
		rdbtnJurdicamis.setBounds(111, 72, 109, 23);
		Denuncias.add(rdbtnJurdicamis);
		
		 btnCambiarCalificacin = new JButton("Cambiar Calificaci\u00F3n");
		btnCambiarCalificacin.setBounds(535, 102, 192, 23);
		Denuncias.add(btnCambiarCalificacin);
		
		btnEliminarCalificacion = new JButton("Eliminar");
		btnEliminarCalificacion.setBounds(535, 136, 192, 23);
		Denuncias.add(btnEliminarCalificacion);
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		////Acá comienza el panel del registro de empresas
		
	    Juridica = new JPanel();
		Juridica.setBackground(new Color(135, 206, 250));
		tabbedPane.addTab("Registro de Persona Jur\u00EDdica", null, Juridica, null);
		tabbedPane.setEnabledAt(4, true);
		//tabbedPane.setEnabledAt(8, false);
		Juridica.setLayout(null);
		
		rdbtnSenasa = new JRadioButton("SENASA");
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
							
		btnRegistrarJuridica = new JButton("");
		btnRegistrarJuridica.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/save.png")));
		btnRegistrarJuridica.setBackground(new Color(135, 206, 250));
		btnRegistrarJuridica.setBounds(288, 384, 53, 33);
		Juridica.add(btnRegistrarJuridica);
		
		this.tabbedPane.remove(Juridica);
	    
	    paneladministrador = new JPanel();
	    paneladministrador.setLayout(null);
	    paneladministrador.setBackground(new Color(135, 206, 250));
	    tabbedPane.addTab("Usuarios", null, paneladministrador, null);
	    
	    JLabel label = new JLabel("Usuarios Activos");
	    label.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    label.setBounds(120, 32, 151, 14);
	    paneladministrador.add(label);
	    
	    JLabel label_1 = new JLabel("Usuarios Bloqueados");
	    label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    label_1.setBounds(373, 32, 178, 14);
	    paneladministrador.add(label_1);
	    
	    JPanel panelactivos = new JPanel();
	    panelactivos.setBounds(97, 57, 160, 356);
	    paneladministrador.add(panelactivos);
	    
	    listactivos = new JList();
	    panelactivos.add(listactivos);
	    
	    JPanel panelbloqueados = new JPanel();
	    panelbloqueados.setBounds(362, 57, 160, 356);
	    paneladministrador.add(panelbloqueados);
	    
	    listabloqueados = new JList();
	    panelbloqueados.add(listabloqueados);
	    
		        btnBloquear = new JButton("Desbloquear");
		        btnBloquear.setBounds(557, 242, 170, 23);
		        paneladministrador.add(btnBloquear);
		        
		        btnDesbloquear = new JButton("Eliminar Usuario");
		        btnDesbloquear.setBounds(557, 208, 170, 23);
		        paneladministrador.add(btnDesbloquear);
		        
		        btnVerBloqueado = new JButton("Ver reportes de usuario bloqueado");
		        btnVerBloqueado.setBounds(325, 424, 246, 23);
		        paneladministrador.add(btnVerBloqueado);
		        
		        btnVerActivo = new JButton("Ver reportes de usuario activo");
		        btnVerActivo.setBounds(68, 424, 214, 23);
		        paneladministrador.add(btnVerActivo);
		        
		        btnVerUsuarios = new JButton("Ver informaci\u00F3n ");
		        btnVerUsuarios.setBounds(557, 276, 170, 23);
		        paneladministrador.add(btnVerUsuarios);
		
		
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		////Acá comienza el panel del registro de personas fisicas					
	    Fisica = new JPanel();
		Fisica.setBackground(new Color(135, 206, 250));
		tabbedPane.addTab("Registro de Persona Física", null, Fisica, null);
	
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
		txtnombre.setEditable(false);
		txtnombre.setBounds(229, 67, 138, 20);
		Fisica.add(txtnombre);
		txtnombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("*Primer Apellido");
		lblApellido.setBounds(424, 98, 104, 14);
		Fisica.add(lblApellido);
		
		txtprimero = new JTextField();
		txtprimero.setEditable(false);
		txtprimero.setBounds(390, 68, 138, 20);
		Fisica.add(txtprimero);
		txtprimero.setColumns(10);
		
		JLabel lblSegundoApellido = new JLabel("*Segundo Apellido");
		lblSegundoApellido.setBounds(564, 98, 104, 14);
		Fisica.add(lblSegundoApellido);
		
		txtSApellido = new JTextField();
		txtSApellido.setEditable(false);
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
		
		btnRegistrar_1 = new JButton("");
		btnRegistrar_1.setBackground(new Color(135, 206, 250));
		btnRegistrar_1.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/save.png")));
		btnRegistrar_1.setBounds(281, 384, 65, 37);
		Fisica.add(btnRegistrar_1);
		
		btnConsultar = new JButton("");
		btnConsultar.setBackground(new Color(135, 206, 250));
		btnConsultar.setIcon(new ImageIcon(Usuario.class.getResource("/Imagenes/buscar.png")));
		btnConsultar.setBounds(463, 32, 46, 23);
		Fisica.add(btnConsultar);
		
		this.tabbedPane.remove(Fisica);
		
		
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

	public void IniciarUsuario(aplicacion.Usuario usuario,DefaultListModel abusos) {
		//Carga los datos del usuario en la pantalla de usuario 
		this.btnIrACalificar.setVisible(true);
		this.btnusuarioNoRegistrado.setVisible(true);
		this.btnEditar.setVisible(false);
		this.tabbedPane.remove(paneladministrador);
		tabbedPane.addTab("Calificar", null, Calificar, null);
		tabbedPane.addTab("Mis Calificaciones", null, Denuncias, null);
		tabbedPane.setEnabledAt(2, false);
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
		if (abusos.isEmpty()){
			abusos.addElement("Felicidades. No hay abusos en su contra");
			listaabusos.setModel(abusos);
			
		}
		else{
			listaabusos.setModel(abusos);
		}
		txtabusos.setText(Integer.toString(usuario.getListaReportes().size()));
		
	}

	public void showPersona(DefaultListModel model,DefaultComboBoxModel tipo) {
		tabbedPane.add(this.Fisica, 4);
		tabbedPane.setSelectedIndex(4);
		list.setModel(model);
		this.cboxmes.setModel(tipo);
	}
	
	public void showEmpresa(DefaultComboBoxModel tipo) {
		tabbedPane.add(this.Juridica,4);
		cboxprovincia.setModel(tipo);
		tabbedPane.setSelectedIndex(4);
	}
	
	//Llena con los datos con los que se puede buscar
	public void llenarPersona(DefaultComboBoxModel tipo,DefaultListModel todo){
		cmbTipoBusqueda.setModel(tipo);
		this.listaconsultar.removeAll();
		this.listaconsultar.setModel(todo);
	}
		
	public void llenarJuridica(DefaultComboBoxModel tipo,DefaultListModel todo){
		cmbTipoBusqueda.setModel(tipo);
		this.listaconsultar.removeAll();
		this.listaconsultar.setModel(todo);
	}
	
	public void IniciarEmpresa(Empresa empresa) {
		tabbedPane.remove(Juridica);
		tabbedPane.setSelectedIndex(2);
		tabbedPane.setEnabledAt(2, true);
		this.empresa=empresa;
		this.txtpersonacalificar.setText(empresa.getNombre());
		this.nuevo=true;
		this.rdbtnJuridicaCalificar.setSelected(true);
		this.rdbtnFisicaCalificar.setEnabled(false);
	}

	public void IniciarPersona(RegistroPersona persona) {
		tabbedPane.remove(Fisica);
		tabbedPane.setSelectedIndex(2);
		tabbedPane.setEnabledAt(2, true);
		this.persona=persona;
		this.txtpersonacalificar.setText(persona.getPersona().getNombre()+" "+persona.getPersona().getPrimerApellido()+" "+persona.getPersona().getSegundoApellido());
		this.nuevo=true;
		this.rdbtnJuridicaCalificar.setEnabled(false);
		this.rdbtnFisicaCalificar.setSelected(true);
	}

	public void agregarlista(DefaultListModel nuevo) {
		list.removeAll();
		list.setModel(nuevo);
		txtmás.setText(" ");
	}

	public void llenarDatosRegistro(DefaultListModel datos) {
		listaconsultar.removeAll();
		listaconsultar.setModel(datos);
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
		this.txtUsuarioComment.setText(n.getUsuario().getNick());
		this.btnVerInformacinDel.setEnabled(true);
	
	}

	@Override
	public void CuentaEliminada() {
		this.dispose();
		
	}

	@Override
	public void llenardatos(aplicacion.Usuario u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarabusos(Date fecha, String motivo) {
		this.txtmas.setText("Fecha de reporte: " +fecha+"\n"+"Motivo: "+ motivo);
		
	}

	@Override
	public void showusercalification(DefaultListModel propias) {
		if (propias.isEmpty()){
			propias.addElement("Sin calificaciones");
			this.listamis.removeAll();
			this.listamis.setModel(propias);
			this.btnMiComentario.setEnabled(false);
			this.btnEliminarCalificacion.setEnabled(false);
			this.btnCambiarCalificacin.setEnabled(false);
		}
		else{
		this.listamis.removeAll();
		this.btnMiComentario.setEnabled(true);
		this.btnEliminarCalificacion.setEnabled(true);
		this.btnCambiarCalificacin.setEnabled(true);
		this.listamis.setModel(propias);
		}
	}

	@Override
	public void mostrarsuscomentarios(Calificacion mandar) {
		this.estrellasmiscalificaciones.add(this.lestrella1);
		this.estrellasmiscalificaciones.add(this.lestrella2);
		this.estrellasmiscalificaciones.add(this.lestrella3);
		this.estrellasmiscalificaciones.add(this.lestrella4);
		this.estrellasmiscalificaciones.add(this.lestrella5);
		this.estrellasmiscalificaciones.add(this.lestrella6);
		this.estrellasmiscalificaciones.add(this.lestrella7);
		this.estrellasmiscalificaciones.add(this.lestrella8);
		this.estrellasmiscalificaciones.add(this.lestrella9);
		this.estrellasmiscalificaciones.add(this.lestrella10);
		this.txtmis.setText(mandar.getComentario());
		for (int i=0;i<mandar.getCalificacion();i++){
			estrellasmiscalificaciones.get(i).setIcon(marcado);
		}
		
		
	}

	@Override
	public void asignarcalificar(String nombre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nuevacalificacion(String selectedValue, int tipo, boolean b) {
		this.txtpersonacalificar.setText(selectedValue);
		if (tipo==0){
			this.rdbtnJuridicaCalificar.setSelected(true);
			this.rdbtnFisicaCalificar.setEnabled(false);
			this.tabbedPane.setSelectedIndex(2);
		}
		else{
			this.rdbtnJuridicaCalificar.setEnabled(false);
			this.rdbtnFisicaCalificar.setSelected(true);
			this.tabbedPane.setSelectedIndex(2);
		}
		
	}

	@Override
	public void reemplazarcalificacion(String selectedValue, int tipo,
			Calificacion cal, boolean b) {
		this.txtpersonacalificar.setText(selectedValue);
		this.txtRegistroReview.setText(cal.getComentario());
		this.lblNdevidencia.setText(cal.getEvidencia().getAbsolutePath());
		for (int i=0;i<cal.getCalificacion();i++){
			estrellas.get(i).setIcon(marcado);
		}
			
		if (tipo==0){
			this.rdbtnJuridicaCalificar.setSelected(true);
			this.rdbtnFisicaCalificar.setEnabled(false);
			this.tabbedPane.setSelectedIndex(2);
		}
		else{
			this.rdbtnJuridicaCalificar.setEnabled(false);
			this.rdbtnFisicaCalificar.setSelected(true);
			this.tabbedPane.setSelectedIndex(2);
			
			
		}
		
	}



	@Override
	public void modificarempresa(Empresa empresa) {
		//Inicializa los campo con los datos de la empresa
		this.txtcedulajuri.setText(empresa.getCedulaJuridica());
		this.txtnombrejuri.setText(empresa.getNombre());
		this.txtpais.setText(empresa.getDireccion().getPais());
		this.txtbarrio.setText(empresa.getDireccion().getBarrio());
		this.txtcanton.setText(empresa.getDireccion().getCanton());
		this.txtdistrito.setText(empresa.getDireccion().getDistrito());
	
		
		if (empresa.getCategoria().equals("SENASA")){
			this.rdbtnSenasa.setSelected(true);
		}
		if (empresa.getCategoria().equals("PANI")){
			this.rdbtnPani.setSelected(true);
		}
		if (empresa.getCategoria().equals("Restaurantes")){
			this.rdbtnRestaurante.setSelected(true);
		}
		if (empresa.getCategoria().equals("Condominios")){
			this.rdbtnCondominios.setSelected(true);
		}
		if (empresa.getCategoria().equals("Empresas")){
			this.rdbtnEmpresas.setSelected(true);
		}
		
		this.cboxprovincia.setVisible(false);
		this.tabbedPane.addTab("Editar Jurídica", this.Juridica);
		this.tabbedPane.remove(Fisica);
		this.tabbedPane.setSelectedComponent(Juridica);
		
	}

	@Override
	public void modificarpersona(RegistroPersona persona , DefaultComboBoxModel mes , DefaultListModel categoria) {
		this.txtcedula.setText(persona.getPersona().getNombre());
		this.btnConsultar.setEnabled(false);
		this.txtnombre.setText(persona.getPersona().getNombre());
		this.txtprimero.setText(persona.getPersona().getPrimerApellido());
		this.txtSApellido.setText(persona.getPersona().getSegundoApellido());
		this.txtaño.setText(Integer.toString(persona.getPersona().getFechaNacimiento().getAño()));
		this.txtdia.setText(Integer.toString(persona.getPersona().getFechaNacimiento().getDia()));
		this.txtcargo.setText(persona.getPersona().getCargo());
		this.txtinstitucion.setText(persona.getPersona().getInstitucion());
		this.cboxmes.setModel(mes);
		this.list.setModel(categoria);
		this.tabbedPane.addTab("Editar Física", this.Fisica);
		this.tabbedPane.remove(Juridica);
		this.tabbedPane.setSelectedComponent(Fisica);
	}

	@Override
	public void iniciaradministrador(DefaultListModel normal,
			DefaultListModel bloqueados, DefaultListModel empresas,
			DefaultListModel personas) {
		tabbedPane.addTab("Usuarios", null, paneladministrador, null);
		tabbedPane.remove(Calificar);
		tabbedPane.remove(Denuncias);
		tabbedPane.remove(PagUsuario);
		this.listabloqueados.setModel(bloqueados);
		this.listactivos.setModel(normal);
		this.setVisible(true);
		this.btnIrACalificar.setVisible(false);
		this.btnusuarioNoRegistrado.setVisible(false);
		this.btnEditar.setVisible(true);
		
		
	}



	@Override
	public void actualizarlista(DefaultListModel actualizada,
			DefaultListModel actualizar, int tipo) {
		this.listactivos.removeAll();
		this.listactivos.setModel(actualizar);
	     this.listabloqueados.removeAll();
		listabloqueados.setModel(actualizada);
		
	}

	@Override
	public void mostrarDatosUsuario(aplicacion.Usuario u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contrato(String contrato) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rechazar() {
		// TODO Auto-generated method stub
		
	}
	}
	


