package grafico;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JTabbedPane;

import java.awt.BorderLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextArea;

import entidades.Empresa;
import entidades.RegistroPersona;
import aplicacion.Funciones;
import aplicacion.Usuario;
import auxiliares.Calificacion;

import javax.swing.ImageIcon;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Informacion implements Funciones {

	public JFrame frame;
	private Object tabbedPane;
	private Container buttonGroup_3;
	public JTextField txtnombrejuri;
	private JTextField txtcedulajuri;
	private JTextField txtpais;
	private JTextField txtcanton;
	private JTextField txtdistrito;
	private JTextField txtbarrio;
	private JTabbedPane paneles;
	private JPanel Fisica;
	private JTextField txtmás;
	private JTextField txtnombre;
	private JTextField txtprimero;
	private JTextField txtSApellido;
	public JTextField txtcedula;
	private JRadioButton rdbtnFemenino;
	private Container buttonGroup_1;
	private JRadioButton rdbtnMasculino;
	private JTextField txtdia;
	private JTextField txtaño;
	private JTextField txtinstitucion;
	private JTextField txtcargo;
	private JTextField txtcategoria;
	private JTextField txtprovincia;
	private  JTextArea txtedad;
	private  JTextArea txtmes;
	private Controlador controlador;
	private JLabel estrella1;
	private JLabel estrella2;
	private JLabel estrella4;
	private JLabel estrella5;
	private JLabel estrella6;
	private JLabel estrella7;
	private JLabel estrella8;
	private JLabel estrella9;
	private JLabel estrella10;
	private JLabel estrella3;
	private JLabel festrella1;
	private JLabel festrella2;
	private JLabel festrella4;
	private JLabel festrella5;
	private JLabel festrella6;
	private JLabel festrella7;
	private JLabel festrella8;
	private JLabel festrella9;
	private JLabel festrella10;
	private JLabel festrella3;
	private ImageIcon mediomarcado = createImageIcon("../Imagenes/marcmedio.png"); //buscar esta ruta
	private ImageIcon marcado = createImageIcon("../Imagenes/marc.png"); //buscar esta ruta
	private ImageIcon nomarcado =createImageIcon("../Imagenes/nomarc.png"); 
	private ArrayList <JLabel> festrella=new ArrayList <JLabel>();
	private ArrayList <JLabel> jestrella=new ArrayList <JLabel>();
	private JTextField txtcalificacionf;
	private JTextField txtcalificacionj;
	public JButton btnVerEstadisticasJ;
	private JLabel lblCalificacin;
	private JPanel Juridica;
	public JButton F;
	public JTextField txtcategoriaf;
	private JButton btnGuardarJ;
	private JPanel ocultar;
	
	
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Informacion(Controlador usar) {
		usar.C_Informacion(this);
		controlador = usar;
		initialize();
		addEvents();
		
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		this.btnVerEstadisticasJ.addActionListener(controlador);
		this.F.addActionListener(controlador);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 230, 140));
		frame.setBounds(100, 100, 701, 468);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		paneles = new JTabbedPane(JTabbedPane.TOP);
		paneles.setBackground(new Color(240, 230, 140));
		paneles.setBounds(22, 0, 642, 418);
		frame.getContentPane().add(paneles);
		 
		
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  		////Acá comienza el panel que muestra la info de la persona juridíca	
		   Juridica = new JPanel();
		   paneles.addTab("Persona Juridíca",null, Juridica, null);
		   
		  
		   Juridica.setBackground(new Color(135, 206, 250));
		   
		   //tabbedPane.setEnabledAt(8, false);
		   Juridica.setLayout(null);
		   
		   JLabel lblSeleccionesUnaCatego = new JLabel("Categor\u00EDa a la que esta registrada");
		   lblSeleccionesUnaCatego.setBounds(10, 11, 237, 14);
		   Juridica.add(lblSeleccionesUnaCatego);
		   
		   JLabel lblNombreDeLa = new JLabel("Nombre de la Persona Jur\u00EDdica: ");
		   lblNombreDeLa.setBounds(47, 93, 200, 14);
		   Juridica.add(lblNombreDeLa);
		   
		   txtnombrejuri = new JTextField();
		   txtnombrejuri.setEditable(false);
		   txtnombrejuri.setBounds(245, 90, 219, 20);
		   Juridica.add(txtnombrejuri);
		   txtnombrejuri.setColumns(10);
		   
		   JLabel lblCdulaJurdica = new JLabel("C\u00E9dula Jur\u00EDdica:");
		   lblCdulaJurdica.setBounds(109, 124, 127, 14);
		   Juridica.add(lblCdulaJurdica);
		   
		   txtcedulajuri = new JTextField();
		   txtcedulajuri.setEditable(false);
		   txtcedulajuri.setBounds(245, 121, 219, 20);
		   Juridica.add(txtcedulajuri);
		   txtcedulajuri.setColumns(10);
		   
		   JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		   lblDireccin.setFont(new Font("Traditional Arabic", Font.PLAIN, 17));
		   
		   	lblDireccin.setBounds(282, 152, 91, 23);
		   	Juridica.add(lblDireccin);
		   	
		JLabel lblPas = new JLabel("Pa\u00EDs");
		lblPas.setBounds(10, 199, 46, 14);
		Juridica.add(lblPas);
		
		JLabel lblProvincia = new JLabel("Provincia");
		lblProvincia.setBounds(10, 237, 60, 14);
		Juridica.add(lblProvincia);
		
		JLabel lblCantn = new JLabel("Cant\u00F3n");
		lblCantn.setBounds(284, 199, 46, 14);
		Juridica.add(lblCantn);
		
		JLabel lblDistrito = new JLabel("Distrito");
		lblDistrito.setBounds(284, 237, 46, 14);
		Juridica.add(lblDistrito);
		
		txtpais = new JTextField();
		txtpais.setEditable(false);
		txtpais.setBounds(66, 196, 188, 20);
		Juridica.add(txtpais);
		txtpais.setColumns(10);
		
		txtcanton = new JTextField();
		txtcanton.setEditable(false);
		txtcanton.setColumns(10);
		txtcanton.setBounds(355, 196, 188, 20);
		Juridica.add(txtcanton);
		
		txtdistrito = new JTextField();
		txtdistrito.setEditable(false);
		txtdistrito.setColumns(10);
		txtdistrito.setBounds(355, 234, 188, 20);
		Juridica.add(txtdistrito);
		
		JLabel lblBarrio = new JLabel("Barrio");
		lblBarrio.setBounds(284, 272, 46, 14);
		Juridica.add(lblBarrio);
		
		txtbarrio = new JTextField();
		txtbarrio.setEditable(false);
		txtbarrio.setColumns(10);
		txtbarrio.setBounds(355, 269, 188, 20);
		Juridica.add(txtbarrio);
		
		txtcategoria = new JTextField();
		txtcategoria.setEditable(false);
		txtcategoria.setBounds(83, 36, 205, 20);
		Juridica.add(txtcategoria);
		txtcategoria.setColumns(10);
		
		txtprovincia = new JTextField();
		txtprovincia.setEditable(false);
		txtprovincia.setBounds(64, 234, 190, 20);
		Juridica.add(txtprovincia);
		txtprovincia.setColumns(10);
	    	
	    	lblCalificacin = new JLabel("Calificaci\u00F3n");
	    	lblCalificacin.setBounds(239, 325, 106, 14);
	    	Juridica.add(lblCalificacin);
	    	
	    	ocultar = new JPanel();
	    	ocultar.setBackground(new Color(135, 206, 250));
	    	ocultar.setBounds(10, 350, 515, 40);
	    	Juridica.add(ocultar);
	    	ocultar.setLayout(null);
	    	
	    	btnVerEstadisticasJ = new JButton("Ver Estad\u00EDsticas");
	    	btnVerEstadisticasJ.setBounds(0, 0, 172, 23);
	    	ocultar.add(btnVerEstadisticasJ);
	    	
	    	JPanel panel = new JPanel();
	    	panel.setBounds(182, 0, 265, 30);
	    	ocultar.add(panel);
	    	panel.setLayout(null);
	    	panel.setBackground(new Color(135, 206, 250));
	    	
	    	estrella1 = new JLabel("");
	    	estrella1.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    	estrella1.setBounds(10, 0, 27, 28);
	    	panel.add(estrella1);
	    	
	    	estrella2 = new JLabel("");
	    	estrella2.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    	estrella2.setBounds(36, 4, 27, 21);
	    	panel.add(estrella2);
	    	
	    estrella4 = new JLabel("");
	    estrella4.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    estrella4.setAutoscrolls(true);
	    estrella4.setBounds(83, 0, 27, 28);
	    panel.add(estrella4);
	    
	    estrella5 = new JLabel("");
	    estrella5.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    estrella5.setBounds(106, 0, 35, 28);
	    panel.add(estrella5);
	    
	    estrella6 = new JLabel("");
	    estrella6.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    estrella6.setBounds(131, 0, 27, 28);
	    panel.add(estrella6);
	    
	    estrella7 = new JLabel("");
	    estrella7.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    estrella7.setBounds(157, 0, 27, 28);
	    panel.add(estrella7);
	    
	    estrella8 = new JLabel("");
	    estrella8.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    estrella8.setBounds(182, 0, 27, 28);
	    panel.add(estrella8);
	    
	    estrella9 = new JLabel("");
	    estrella9.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    estrella9.setBounds(209, 0, 27, 28);
	    panel.add(estrella9);
	    
	    estrella10 = new JLabel("");
	    estrella10.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    estrella10.setBounds(236, 0, 27, 28);
	    panel.add(estrella10);
	    
	    estrella3 = new JLabel("");
	    estrella3.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    estrella3.setBounds(59, 0, 27, 28);
	    panel.add(estrella3);
	    
	    txtcalificacionj = new JTextField();
	    txtcalificacionj.setBounds(445, -3, 70, 33);
	    ocultar.add(txtcalificacionj);
	    txtcalificacionj.setFont(new Font("Monospaced", Font.PLAIN, 17));
	    txtcalificacionj.setColumns(10);
	    
	    btnGuardarJ = new JButton("Guardar");
	    btnGuardarJ.setBounds(515, 7, 89, 23);
	    Juridica.add(btnGuardarJ);
	    this.btnGuardarJ.setVisible(false);
	    	
	
	    	
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  		////Acá comienza el panel que muestra la info de la persona física
	    	Fisica = new JPanel();
	    	Fisica.setBackground(new Color(135, 206, 250));
	    	paneles.addTab("Persona Física", null, Fisica, null);
	    	Fisica.setLayout(null);
	    	
	    	JLabel lblNombre = new JLabel("*Nombre");
	    	lblNombre.setBounds(54, 71, 84, 14);
	    	Fisica.add(lblNombre);
	    	
	    	JLabel lblCdula = new JLabel("*C\u00E9dula");
	    	lblCdula.setBounds(24, 8, 128, 14);
	    	Fisica.add(lblCdula);
	    	
	    	txtnombre = new JTextField();
	    	txtnombre.setEditable(false);
	    	txtnombre.setBounds(10, 40, 157, 20);
	    	Fisica.add(txtnombre);
	    	txtnombre.setColumns(10);
	    	
	    	JLabel lblApellido = new JLabel("*Primer Apellido");
	    	lblApellido.setBounds(253, 71, 126, 14);
	    	Fisica.add(lblApellido);
	    	
	    	txtprimero = new JTextField();
	    	txtprimero.setEditable(false);
	    	txtprimero.setBounds(219, 40, 169, 20);
	    	Fisica.add(txtprimero);
	    	txtprimero.setColumns(10);
	    	
	    	JLabel lblSegundoApellido = new JLabel("*Segundo Apellido");
	    	lblSegundoApellido.setBounds(466, 71, 140, 14);
	    	Fisica.add(lblSegundoApellido);
	    	
	    	txtSApellido = new JTextField();
	    	txtSApellido.setEditable(false);
	    	txtSApellido.setColumns(10);
	    	txtSApellido.setBounds(435, 40, 178, 20);
	    	Fisica.add(txtSApellido);
	    	
	    	txtcedula = new JTextField();
	    	txtcedula.setEditable(false);
	    	txtcedula.setColumns(10);
	    	txtcedula.setBounds(114, 5, 226, 20);
	    	Fisica.add(txtcedula);
	    	
	    	JLabel lblGenero = new JLabel("G\u00E9nero");
	    	lblGenero.setBounds(24, 163, 84, 14);
	    	Fisica.add(lblGenero);
	    	
	    	 rdbtnFemenino = new JRadioButton("Femenino");
	    	 rdbtnFemenino.setEnabled(false);
	    	 rdbtnFemenino.setBackground(new Color(135, 206, 250));
	    	 
	    	 		 rdbtnFemenino.setBounds(114, 159, 101, 23);
	    	 		 Fisica.add(rdbtnFemenino);
	    	 		 
	    	 		 rdbtnMasculino = new JRadioButton("Masculino");
	    	 		 rdbtnMasculino.setEnabled(false);
	    	 		 rdbtnMasculino.setBackground(new Color(135, 206, 250));
	    	 		 
	    	 		  rdbtnMasculino.setBounds(257, 159, 122, 23);
	    	 		  Fisica.add(rdbtnMasculino);
	    	 		  
	    	 		  JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
	    	 		  lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    	 		  lblFechaDeNacimiento.setBounds(238, 89, 136, 19);
	    	 		  Fisica.add(lblFechaDeNacimiento);
	    	 		  
	    	 		  JLabel lblDa = new JLabel("*D\u00EDa");
	    	 		  lblDa.setBounds(24, 131, 43, 14);
	    	 		  Fisica.add(lblDa);
	    	 		  
	    	 		  JLabel lblMes = new JLabel("*Mes");
	    	 		  lblMes.setBounds(142, 131, 43, 14);
	    	 		  Fisica.add(lblMes);
	    	 		  
	    	 		  txtdia = new JTextField();
	    	 		  txtdia.setEditable(false);
	    	 		  txtdia.setBounds(68, 128, 43, 20);
	    	 		  Fisica.add(txtdia);
	    	 		  txtdia.setColumns(10);
	    	 		  
	    	 		  JLabel lblAo = new JLabel("*A\u00F1o");
	    	 		  lblAo.setBounds(314, 131, 37, 14);
	    	 		  Fisica.add(lblAo);
	    	 		  
	    	 		  txtaño = new JTextField();
	    	 		  txtaño.setEditable(false);
	    	 		  txtaño.setColumns(10);
	    	 		  txtaño.setBounds(361, 128, 86, 20);
	    	 		  Fisica.add(txtaño);
	    	 		  
	    	 		  JLabel lblInstitucinDondeLabora = new JLabel("*Instituci\u00F3n donde labora:");
	    	 		  lblInstitucinDondeLabora.setBounds(41, 240, 200, 14);
	    	 		  Fisica.add(lblInstitucinDondeLabora);
	    	 		  
	    	 		  JLabel lblEmpleo = new JLabel("Empleo");
	    	 		  lblEmpleo.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    	 		  lblEmpleo.setBounds(241, 201, 47, 19);
	    	 		  Fisica.add(lblEmpleo);
	    	 		  
	    	 		  JLabel lblCargoQueOcupa = new JLabel("*Cargo que ocupa");
	    	 		  lblCargoQueOcupa.setBounds(41, 276, 205, 14);
	    	 		  Fisica.add(lblCargoQueOcupa);
	    	 		  
	    	 		  txtinstitucion = new JTextField();
	    	 		  txtinstitucion.setEditable(false);
	    	 		  txtinstitucion.setColumns(10);
	    	 		  txtinstitucion.setBounds(251, 237, 295, 20);
	    	 		  Fisica.add(txtinstitucion);
	    	 		  
	    	 		  txtcargo = new JTextField();
	    	 		  txtcargo.setEditable(false);
	    	 		  txtcargo.setColumns(10);
	    	 		  txtcargo.setBounds(253, 273, 285, 20);
	    	 		  Fisica.add(txtcargo);
	    	 		  
	    	 		  txtmes = new JTextArea();
	    	 		  txtmes.setEditable(false);
	    	 		  txtmes.setBounds(189, 126, 99, 22);
	    	 		  Fisica.add(txtmes);
	    	 		  
	    	 		  JLabel lblEdad = new JLabel("Edad");
	    	 		  lblEdad.setBounds(467, 131, 46, 14);
	    	 		  Fisica.add(lblEdad);
	    	 		  
	    	 		  txtedad = new JTextArea();
	    	 		  txtedad.setEditable(false);
	    	 		  txtedad.setBounds(507, 126, 99, 22);
	    	 		  Fisica.add(txtedad);
	    	 		  
	    	 		  JPanel panel_1 = new JPanel();
	    	 		  panel_1.setLayout(null);
	    	 		  panel_1.setBackground(new Color(135, 206, 250));
	    	 		  panel_1.setBounds(247, 352, 265, 30);
	    	 		  Fisica.add(panel_1);
	    	 		  
	    	 		  festrella1 = new JLabel("");
	    	 		  festrella1.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    	 		  festrella1.setBounds(10, 0, 27, 28);
	    	 		  panel_1.add(festrella1);
	    	 		  
	    	 		  festrella2 = new JLabel("");
	    	 		  festrella2.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    	 		  festrella2.setBounds(36, 4, 27, 21);
	    	 		  panel_1.add(festrella2);
	    	 		  
	    	 		  festrella3 = new JLabel("");
	    	 		  festrella3.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    	 		  festrella3.setBounds(59, 0, 27, 28);
	    	 		  panel_1.add(festrella3);
	    	 		  
	    	 		  festrella4 = new JLabel("");
	    	 		  festrella4.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    	 		  festrella4.setAutoscrolls(true);
	    	 		  festrella4.setBounds(83, 0, 27, 28);
	    	 		  panel_1.add(festrella4);
	    	 		  
	    	 		  festrella5 = new JLabel("");
	    	 		  festrella5.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    	 		  festrella5.setBounds(106, 0, 35, 28);
	    	 		  panel_1.add(festrella5);
	    	 		  
	    	 		  festrella6 = new JLabel("");
	    	 		  festrella6.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    	 		  festrella6.setBounds(131, 0, 27, 28);
	    	 		  panel_1.add(festrella6);
	    	 		  
	    	 		  festrella7 = new JLabel("");
	    	 		  festrella7.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    	 		  festrella7.setBounds(157, 0, 27, 28);
	    	 		  panel_1.add(festrella7);
	    	 		  
	    	 		  festrella8 = new JLabel("");
	    	 		  festrella8.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    	 		  festrella8.setBounds(182, 0, 27, 28);
	    	 		  panel_1.add(festrella8);
	    	 		  
	    	 		  festrella9 = new JLabel("");
	    	 		  festrella9.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    	 		  festrella9.setBounds(209, 0, 27, 28);
	    	 		  panel_1.add(festrella9);
	    	 		  
	    	 		  festrella10 = new JLabel("");
	    	 		  festrella10.setIcon(new ImageIcon(Informacion.class.getResource("/Imagenes/nomarc.png")));
	    	 		  festrella10.setBounds(236, 0, 27, 28);
	    	 		  panel_1.add(festrella10);
	    	 		  
	    	 		  JLabel lblCalificacion_1 = new JLabel("Calificacion");
	    	 		  lblCalificacion_1.setBounds(200, 324, 101, 14);
	    	 		  Fisica.add(lblCalificacion_1);
	    	 		  
	    	 		  txtcalificacionf = new JTextField();
	    	 		  txtcalificacionf.setFont(new Font("Monospaced", Font.PLAIN, 17));
	    	 		  txtcalificacionf.setBounds(522, 349, 84, 33);
	    	 		  Fisica.add(txtcalificacionf);
	    	 		  txtcalificacionf.setColumns(10);
	    	 		  
	    	 		  F = new JButton("Ver Estad\u00EDsticas");
	    	 		  F.setBounds(22, 359, 193, 23);
	    	 		  Fisica.add(F);
	    	 		  
	    	 		  JLabel lblCategora = new JLabel("Categor\u00EDa");
	    	 		  lblCategora.setBounds(360, 8, 87, 14);
	    	 		  Fisica.add(lblCategora);
	    	 		  
	    	 		  txtcategoriaf = new JTextField();
	    	 		  txtcategoriaf.setBounds(422, 5, 205, 20);
	    	 		  Fisica.add(txtcategoriaf);
	    	 		  txtcategoriaf.setColumns(10);
		
	}

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	////Métodos que implementan la vista

	public void IniciarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub		
	}

	public void showEmpresa(DefaultComboBoxModel tipo) {
		// TODO Auto-generated method stub		
	}

	public void showPersona(DefaultListModel model, DefaultComboBoxModel tipo) {
		// TODO Auto-generated method stub		
	}

	public void showRegistro() {
		// TODO Auto-generated method stub		
	}

	public void IniciarEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
	}

	public void IniciarPersona(RegistroPersona persona) {
		// TODO Auto-generated method stub		
	}

	public void llenarPersona(DefaultComboBoxModel tipo) {
		// TODO Auto-generated method stub		
	}

	public void llenarJuridica(DefaultComboBoxModel tipo) {
		// TODO Auto-generated method stub	
	}
	
	public void agregarlista(DefaultListModel nuevo) {
		// TODO Auto-generated method stub		
	}

	public void llenarDatosRegistro(DefaultListModel datos) {
		// TODO Auto-generated method stub
	}
	
	public void llenarcmbCalificar(DefaultComboBoxModel model) {
		// TODO Auto-generated method stub		
	}

	public void mostrarVentanaEvidencia(String nombre, String pathArchivo) {
		// TODO Auto-generated method stub
	}
	
	public void datosencontrados(String genero, String nombre, String primero,
			String segundo) {
		// TODO Auto-generated method stub		
	}

	public void actualizarestrella(int estrella, boolean estado) {
		// TODO Auto-generated method stub
	}

	public void mostrarresultados(DefaultListModel x) {
		// TODO Auto-generated method stub		
	}

	public void actualizarInformacionEmpresa(Empresa mostrar) {
		paneles.add(Juridica,this.Juridica);
		this.jestrella.add(estrella1);
		this.jestrella.add(estrella2);
		this.jestrella.add(estrella3);
		this.jestrella.add(estrella4);
		this.jestrella.add(estrella5);
		this.jestrella.add(estrella6);
		this.jestrella.add(estrella7);
		this.jestrella.add(estrella8);
		this.jestrella.add(estrella9);
		this.jestrella.add(estrella10);
		this.txtbarrio.setText(mostrar.getDireccion().getBarrio());
		this.txtcanton.setText(mostrar.getDireccion().getCanton());
		this.txtcedulajuri.setText(mostrar.getCedulaJuridica());
		this.txtdistrito.setText(mostrar.getDireccion().getDistrito());
		this.txtnombrejuri.setText(mostrar.getNombre());
		this.txtpais.setText(mostrar.getDireccion().getPais());
		this.txtcategoria.setText(mostrar.getCategoria());
		this.txtprovincia.setText(mostrar.getDireccion().getProvincia());
		
		this.paneles.remove(Fisica);
		this.paneles.add(Juridica);
		this.ocultar.setVisible(true);
		this.btnGuardarJ.setVisible(false);
		
		for (JLabel estrella : jestrella){
			estrella.setIcon(nomarcado);
		}
	
		int entero = (int) mostrar.getPromedio();
		double decimal = mostrar.getPromedio() - entero;
		int contador =0;
		for (JLabel estrella : this.jestrella){
			if (contador < entero){
				estrella.setIcon(marcado);
				contador ++;}
		}
		if (decimal != 0.0){
			this.festrella.get(entero).setIcon(mediomarcado);
		}
DecimalFormat redondeo = new DecimalFormat("########.##");	
		
		
		this.txtcalificacionj.setText(redondeo.format(mostrar.getPromedio()));
		frame.setVisible(true);
	}
	
	public void actualizarInformacionPersona(RegistroPersona mostrar) {
		this.paneles.remove(Juridica);
		this.paneles.add(Fisica);
		
		this.festrella.add(festrella1);
		this.festrella.add(festrella2);
		this.festrella.add(festrella3);
		this.festrella.add(festrella4);
		this.festrella.add(festrella5);
		this.festrella.add(festrella6);
		this.festrella.add(festrella7);
		this.festrella.add(festrella8);
		this.festrella.add(festrella9);
		this.festrella.add(festrella10);
		for (JLabel estrella : festrella){
			estrella.setIcon(nomarcado);
		}
		
		this.txtcategoriaf.setText(mostrar.getCategorias());
		this.txtcedula.setText(mostrar.getPersona().getCedula());
		this.txtnombre.setText(mostrar.getPersona().getNombre());
		this.txtprimero.setText(mostrar.getPersona().getPrimerApellido());
		this.txtSApellido.setText(mostrar.getPersona().getSegundoApellido());
		this.txtdia.setText(Integer.toString(mostrar.getPersona().getFechaNacimiento().getDia()));
		this.txtaño.setText(Integer.toString(mostrar.getPersona().getFechaNacimiento().getAño()));
		this.txtmes.setText(Integer.toString(mostrar.getPersona().getFechaNacimiento().getMes()));
		this.txtedad.setText(Integer.toString(mostrar.getPersona().getEdad()));
		if(mostrar.getPersona().getGenero().equalsIgnoreCase("Femenino")){
			this.rdbtnFemenino.setSelected(true);
		}
		else{
			this.rdbtnMasculino.setSelected(true);
		}
		this.txtinstitucion.setText(mostrar.getPersona().getInstitucion());
		this.txtcargo.setText(mostrar.getPersona().getCargo());
		frame.setVisible(true);	
		
		int entero = (int) mostrar.getPersona().getPromedio();
		double decimal = mostrar.getPersona().getPromedio() - entero;
		int contador =0;
		for (JLabel estrella : this.festrella){
		
			if (contador < entero){
			
				estrella.setIcon(marcado);
				contador ++;
			}
		}
		if (decimal != 0.0){
			
			this.festrella.get(entero).setIcon(mediomarcado);
		}
DecimalFormat redondeo = new DecimalFormat("########.##");	
		
		
		this.txtcalificacionf.setText(redondeo.format(mostrar.getPersona().getPromedio()));
		
	}

	public void Icomentarios(Calificacion n, Usuario usuario) {
		// TODO Auto-generated method stub
	}

	@Override
	public void CuentaEliminada() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void llenardatos(Usuario u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void IniciarUsuario(Usuario usuario, DefaultListModel abusos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarabusos(Date fechaDenuncia, String motivo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showusercalification(DefaultListModel propias) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarsuscomentarios(Calificacion mandar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void asignarcalificar(String nombre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nuevacalificacion(String selectedValue, int tipo, boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reemplazarcalificacion(String selectedValue, int tipo,
			Calificacion cal, boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void llenarPersona(DefaultComboBoxModel tipo, DefaultListModel todo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void llenarJuridica(DefaultComboBoxModel tipo, DefaultListModel todo) {
		// TODO Auto-generated method stub
		
	}
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Usuario.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }



	@Override
	public void modificarempresa(Empresa empresa) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void iniciaradministrador(DefaultListModel normal,
			DefaultListModel bloqueados, DefaultListModel empresas,
			DefaultListModel personas) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actualizarlista(DefaultListModel actualizada,
			DefaultListModel actualizar, int tipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarpersona(RegistroPersona persona,
			DefaultComboBoxModel mes, DefaultListModel categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarDatosUsuario(Usuario u) {
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
