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

import javax.swing.JTextArea;

import entidades.Empresa;
import entidades.RegistroPersona;
import aplicacion.Funciones;
import aplicacion.Usuario;
import auxiliares.Calificacion;

public class Informacion implements Funciones {

	public JFrame frame;
	private Object tabbedPane;
	private Container buttonGroup_3;
	private JTextField txtnombrejuri;
	private JTextField txtcedulajuri;
	private JTextField txtpais;
	private JTextField txtcanton;
	private JTextField txtdistrito;
	private JTextField txtbarrio;
	private JTabbedPane tabbedPane_1;
	private JButton btnCalificar;
	private JPanel Fisica;
	
	private JTextField txtmás;
	private JTextField txtnombre;
	private JTextField txtprimero;
	private JTextField txtSApellido;
	private JTextField txtcedula;
	private JRadioButton rdbtnFemenino;
	private Container buttonGroup_1;
	private JRadioButton rdbtnMasculino;
	private JTextField txtdia;
	private JTextField txtaño;
	private JTextField txtinstitucion;
	private JTextField txtcargo;
	private JButton btnCalificar_1;
	private JTextField txtcategoria;
	private JTextField txtprovincia;
	private Controlador controlador;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Informacion(Controlador usar) {
		controlador = usar;
		controlador.C_Informacion(this);
		initialize();
		addEvents();
		initialize();
	}

	private void addEvents() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 230, 140));
		frame.setBounds(100, 100, 701, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBackground(new Color(240, 230, 140));
		tabbedPane_1.setBounds(22, 0, 642, 383);
		frame.getContentPane().add(tabbedPane_1);
		
		JPanel Juridica = new JPanel();
		tabbedPane_1.addTab("Persona Juridíca",null, Juridica, null);
		Juridica.setBackground(new Color(173, 216, 230));
		
		//tabbedPane.setEnabledAt(8, false);
		Juridica.setLayout(null);
		
		JLabel lblSeleccionesUnaCatego = new JLabel("Categor\u00EDa a la que esta registrada");
		lblSeleccionesUnaCatego.setBounds(10, 11, 237, 14);
		Juridica.add(lblSeleccionesUnaCatego);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la Persona Jur\u00EDdica: ");
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
		txtpais.setBounds(66, 196, 188, 20);
		Juridica.add(txtpais);
		txtpais.setColumns(10);
		
		txtcanton = new JTextField();
		txtcanton.setColumns(10);
		txtcanton.setBounds(355, 196, 188, 20);
		Juridica.add(txtcanton);
		
		txtdistrito = new JTextField();
		txtdistrito.setColumns(10);
		txtdistrito.setBounds(355, 234, 188, 20);
		Juridica.add(txtdistrito);
		
		JLabel lblBarrio = new JLabel("Barrio");
		lblBarrio.setBounds(284, 272, 46, 14);
		Juridica.add(lblBarrio);
		
		txtbarrio = new JTextField();
		txtbarrio.setColumns(10);
		txtbarrio.setBounds(355, 269, 188, 20);
		Juridica.add(txtbarrio);
		
		btnCalificar = new JButton("Calificar");
		btnCalificar.setBounds(263, 321, 89, 23);
		Juridica.add(btnCalificar);
		
		txtcategoria = new JTextField();
		txtcategoria.setBounds(83, 36, 205, 20);
		Juridica.add(txtcategoria);
		txtcategoria.setColumns(10);
		
		txtprovincia = new JTextField();
		txtprovincia.setBounds(64, 234, 190, 20);
		Juridica.add(txtprovincia);
		txtprovincia.setColumns(10);
		
		Fisica = new JPanel();
		Fisica.setBackground(new Color(135, 206, 250));
		tabbedPane_1.addTab("Persona Física", null, Fisica, null);
		Fisica.setLayout(null);
		
	   
		
		
	
		
		JLabel lblNombre = new JLabel("*Nombre");
		lblNombre.setBounds(54, 71, 84, 14);
		Fisica.add(lblNombre);
		
		JLabel lblCdula = new JLabel("*C\u00E9dula");
		lblCdula.setBounds(24, 8, 128, 14);
		Fisica.add(lblCdula);
		
		txtnombre = new JTextField();
		txtnombre.setEnabled(false);
		txtnombre.setBounds(10, 40, 157, 20);
		Fisica.add(txtnombre);
		txtnombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("*Primer Apellido");
		lblApellido.setBounds(253, 71, 126, 14);
		Fisica.add(lblApellido);
		
		txtprimero = new JTextField();
		txtprimero.setEnabled(false);
		txtprimero.setBounds(219, 40, 169, 20);
		Fisica.add(txtprimero);
		txtprimero.setColumns(10);
		
		JLabel lblSegundoApellido = new JLabel("*Segundo Apellido");
		lblSegundoApellido.setBounds(466, 71, 140, 14);
		Fisica.add(lblSegundoApellido);
		
		txtSApellido = new JTextField();
		txtSApellido.setEnabled(false);
		txtSApellido.setColumns(10);
		txtSApellido.setBounds(435, 40, 178, 20);
		Fisica.add(txtSApellido);
		
		txtcedula = new JTextField();
		txtcedula.setEnabled(false);
		txtcedula.setColumns(10);
		txtcedula.setBounds(190, 5, 226, 20);
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
		 txtdia.setEnabled(false);
		 txtdia.setBounds(68, 128, 43, 20);
		 Fisica.add(txtdia);
		 txtdia.setColumns(10);
		 
	
		 
		 JLabel lblAo = new JLabel("*A\u00F1o");
		 lblAo.setBounds(314, 131, 37, 14);
		 Fisica.add(lblAo);
		 
		 txtaño = new JTextField();
		 txtaño.setEnabled(false);
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
		 txtinstitucion.setEnabled(false);
		 txtinstitucion.setColumns(10);
		 txtinstitucion.setBounds(251, 237, 295, 20);
		 Fisica.add(txtinstitucion);
		 
		 txtcargo = new JTextField();
		 txtcargo.setEnabled(false);
		 txtcargo.setColumns(10);
		 txtcargo.setBounds(253, 273, 285, 20);
		 Fisica.add(txtcargo);
		 
		 JTextArea txtmes = new JTextArea();
		 txtmes.setEnabled(false);
		 txtmes.setBounds(189, 126, 99, 22);
		 Fisica.add(txtmes);
		 
		 JLabel lblEdad = new JLabel("Edad");
		 lblEdad.setBounds(467, 131, 46, 14);
		 Fisica.add(lblEdad);
		 
		 JTextArea txtarea = new JTextArea();
		 txtarea.setEnabled(false);
		 txtarea.setBounds(507, 126, 99, 22);
		 Fisica.add(txtarea);
		 
		 btnCalificar_1 = new JButton("Calificar");
		 btnCalificar_1.setBounds(274, 321, 89, 23);
		 Fisica.add(btnCalificar_1);
		


		
		

	}

	@Override
	public void IniciarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showEmpresa(DefaultComboBoxModel tipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showPersona(DefaultListModel model, DefaultComboBoxModel tipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showRegistro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void IniciarEmpresa(Empresa empresa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void IniciarPersona(RegistroPersona persona) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void llenarPersona(DefaultComboBoxModel tipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void llenarJuridica(DefaultComboBoxModel tipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void agregarlista(DefaultListModel nuevo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void llenarDatosRegistro(DefaultListModel datos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void llenarcmbCalificar(DefaultComboBoxModel model) {
		// TODO Auto-generated method stub
		
	}

	@Override
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
	public void mostrarresultados(DefaultListModel x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarInformacionEmpresa(Empresa mostrar) {
		this.txtbarrio.setText(mostrar.getDireccion().getBarrio());
		this.txtcanton.setText(mostrar.getDireccion().getCanton());
		this.txtcedulajuri.setText(mostrar.getCedulaJuridica());
		this.txtdistrito.setText(mostrar.getDireccion().getDistrito());
		this.txtnombrejuri.setText(mostrar.getNombre());
		this.txtpais.setText(mostrar.getDireccion().getPais());
		this.txtcategoria.setText(mostrar.getCategoria());
		this.txtprovincia.setText(mostrar.getDireccion().getProvincia());
		frame.setVisible(true);
		
		
	}

	@Override
	public void actualizarInformacionPersona(RegistroPersona mostrar) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void Icomentarios(Calificacion n, Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
}
