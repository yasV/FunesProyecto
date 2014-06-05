package grafico;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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
import java.util.Date;

import javax.swing.JTextArea;

import entidades.Empresa;
import entidades.RegistroPersona;
import aplicacion.Funciones;
import aplicacion.Usuario;
import auxiliares.Calificacion;

public class Informacion implements Funciones {

	public JFrame frmInformacinDelUsuario;
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
	private  JTextArea txtedad;
	private  JTextArea txtmes;
	private ImageIcon noMarcado = createImageIcon("../Imagenes/nomarc.png"); //buscar esta ruta
	private ImageIcon marcado = createImageIcon("../Imagenes/marc.png"); //buscar esta ruta
	private ImageIcon marcadoMitad = createImageIcon("../Imagenes/marcmedio.png"); //buscar esta ruta
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
		frmInformacinDelUsuario = new JFrame();
		frmInformacinDelUsuario.setTitle("Informaci\u00F3n de la persona");
		frmInformacinDelUsuario.getContentPane().setBackground(new Color(240, 230, 140));
		frmInformacinDelUsuario.setBounds(100, 100, 701, 433);
		frmInformacinDelUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmInformacinDelUsuario.getContentPane().setLayout(null);
		
		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBackground(new Color(240, 230, 140));
		tabbedPane_1.setBounds(22, 0, 642, 383);
		frmInformacinDelUsuario.getContentPane().add(tabbedPane_1);
	
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  		////Acá comienza el panel que muestra la info de la persona juridíca	
		JPanel Juridica = new JPanel();
		tabbedPane_1.addTab("Persona Juridíca",null, Juridica, null);
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
		
			lblDireccin.setBounds(245, 152, 91, 23);
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
		
		btnCalificar = new JButton("Calificar");
		btnCalificar.setBounds(263, 321, 89, 23);
		Juridica.add(btnCalificar);
		
		txtcategoria = new JTextField();
		txtcategoria.setEditable(false);
		txtcategoria.setBounds(10, 36, 205, 20);
		Juridica.add(txtcategoria);
		txtcategoria.setColumns(10);
		
		txtprovincia = new JTextField();
		txtprovincia.setEditable(false);
		txtprovincia.setBounds(64, 234, 190, 20);
		Juridica.add(txtprovincia);
		txtprovincia.setColumns(10);
		
		JPanel panelEstrellas = new JPanel();
		panelEstrellas.setBackground(new Color(135, 206, 235));
		panelEstrellas.setBounds(303, 34, 324, 45);
		Juridica.add(panelEstrellas);
		
		JLabel lblEstrella1 = new JLabel("");
		panelEstrellas.add(lblEstrella1);
		lblEstrella1.setIcon(noMarcado);
		
		JLabel lblEstrella2 = new JLabel("");
		panelEstrellas.add(lblEstrella2);
		lblEstrella2.setIcon(noMarcado);
		
		JLabel lblEstrella3 = new JLabel("");
		panelEstrellas.add(lblEstrella3);
		lblEstrella3.setIcon(noMarcado);
		
		JLabel lblEstrella4 = new JLabel("");
		panelEstrellas.add(lblEstrella4);
		lblEstrella4.setIcon(noMarcado);
		
		JLabel lblEstrella5 = new JLabel("");
		panelEstrellas.add(lblEstrella5);
		lblEstrella5.setIcon(noMarcado);
		
		JLabel lblEstrella6 = new JLabel("");
		panelEstrellas.add(lblEstrella6);
		lblEstrella6.setIcon(noMarcado);
		
		JLabel lblEstrella7 = new JLabel("");
		panelEstrellas.add(lblEstrella7);
		lblEstrella7.setIcon(noMarcado);
		
		JLabel lblEstrella8 = new JLabel("");
		panelEstrellas.add(lblEstrella8);
		lblEstrella8.setIcon(noMarcado);
		
		JLabel lblEstrella9 = new JLabel("");
		panelEstrellas.add(lblEstrella9);
		lblEstrella9.setIcon(noMarcado);
		
		JLabel lblEstrella10 = new JLabel("");
		panelEstrellas.add(lblEstrella10);
		lblEstrella10.setIcon(noMarcado);
		
		JLabel lblPromedio = new JLabel("Promedio:");
		lblPromedio.setBounds(303, 11, 139, 14);
		Juridica.add(lblPromedio);
		
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
  		////Acá comienza el panel que muestra la info de la persona física
		Fisica = new JPanel();
		Fisica.setBackground(new Color(135, 206, 250));
		tabbedPane_1.addTab("Persona Física", null, Fisica, null);
		Fisica.setLayout(null);
		
		JLabel lblNombre = new JLabel("*Nombre");
		lblNombre.setBounds(51, 108, 84, 14);
		Fisica.add(lblNombre);
		
		JLabel lblCdula = new JLabel("*C\u00E9dula");
		lblCdula.setBounds(7, 8, 128, 14);
		Fisica.add(lblCdula);
		
		txtnombre = new JTextField();
		txtnombre.setEditable(false);
		txtnombre.setBounds(10, 77, 157, 20);
		Fisica.add(txtnombre);
		txtnombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("*Primer Apellido");
		lblApellido.setBounds(262, 108, 126, 14);
		Fisica.add(lblApellido);
		
		txtprimero = new JTextField();
		txtprimero.setEditable(false);
		txtprimero.setBounds(219, 77, 169, 20);
		Fisica.add(txtprimero);
		txtprimero.setColumns(10);
		
		JLabel lblSegundoApellido = new JLabel("*Segundo Apellido");
		lblSegundoApellido.setBounds(473, 108, 140, 14);
		Fisica.add(lblSegundoApellido);
		
		txtSApellido = new JTextField();
		txtSApellido.setEditable(false);
		txtSApellido.setColumns(10);
		txtSApellido.setBounds(435, 77, 178, 20);
		Fisica.add(txtSApellido);
		
		txtcedula = new JTextField();
		txtcedula.setEditable(false);
		txtcedula.setColumns(10);
		txtcedula.setBounds(51, 26, 142, 20);
		Fisica.add(txtcedula);
		
		JLabel lblGenero = new JLabel("G\u00E9nero");
		lblGenero.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGenero.setBounds(39, 227, 84, 19);
		Fisica.add(lblGenero);
		
		 rdbtnFemenino = new JRadioButton("Femenino");
		 rdbtnFemenino.setEnabled(false);
		 rdbtnFemenino.setBackground(new Color(135, 206, 250));

		 rdbtnFemenino.setBounds(22, 253, 101, 23);
		 Fisica.add(rdbtnFemenino);
		 
		 rdbtnMasculino = new JRadioButton("Masculino");
		 rdbtnMasculino.setEnabled(false);
		 rdbtnMasculino.setBackground(new Color(135, 206, 250));
		
		 rdbtnMasculino.setBounds(22, 282, 103, 23);
		 Fisica.add(rdbtnMasculino);
		 
		 JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento");
		 lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblFechaDeNacimiento.setBounds(252, 136, 136, 19);
		 Fisica.add(lblFechaDeNacimiento);
		 
		 JLabel lblDa = new JLabel("*D\u00EDa");
		 lblDa.setBounds(26, 183, 43, 14);
		 Fisica.add(lblDa);
		 
		 JLabel lblMes = new JLabel("*Mes");
		 lblMes.setBounds(136, 183, 43, 14);
		 Fisica.add(lblMes);
		 
		 txtdia = new JTextField();
		 txtdia.setEditable(false);
		 txtdia.setBounds(67, 180, 43, 20);
		 Fisica.add(txtdia);
		 txtdia.setColumns(10);
		 
		 JLabel lblAo = new JLabel("*A\u00F1o");
		 lblAo.setBounds(314, 183, 37, 14);
		 Fisica.add(lblAo);
		 
		 txtaño = new JTextField();
		 txtaño.setEditable(false);
		 txtaño.setColumns(10);
		 txtaño.setBounds(361, 180, 86, 20);
		 Fisica.add(txtaño);
		 
		 JLabel lblInstitucinDondeLabora = new JLabel("*Instituci\u00F3n donde labora:");
		 lblInstitucinDondeLabora.setBounds(189, 241, 200, 14);
		 Fisica.add(lblInstitucinDondeLabora);
		 
		 JLabel lblEmpleo = new JLabel("Empleo");
		 lblEmpleo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblEmpleo.setBounds(332, 211, 47, 19);
		 Fisica.add(lblEmpleo);
		 
		 JLabel lblCargoQueOcupa = new JLabel("*Cargo que ocupa");
		 lblCargoQueOcupa.setBounds(222, 272, 122, 14);
		 Fisica.add(lblCargoQueOcupa);
		 
		 txtinstitucion = new JTextField();
		 txtinstitucion.setEditable(false);
		 txtinstitucion.setColumns(10);
		 txtinstitucion.setBounds(342, 238, 285, 20);
		 Fisica.add(txtinstitucion);
		 
		 txtcargo = new JTextField();
		 txtcargo.setEditable(false);
		 txtcargo.setColumns(10);
		 txtcargo.setBounds(342, 269, 285, 20);
		 Fisica.add(txtcargo);
		 
		 txtmes = new JTextArea();
		 txtmes.setEditable(false);
		 txtmes.setBounds(189, 178, 99, 22);
		 Fisica.add(txtmes);
		 
		 JLabel lblEdad = new JLabel("Edad");
		 lblEdad.setBounds(467, 183, 46, 14);
		 Fisica.add(lblEdad);
		 
		 txtedad = new JTextArea();
		 txtedad.setEditable(false);
		 txtedad.setBounds(507, 178, 99, 22);
		 Fisica.add(txtedad);
		 
		 btnCalificar_1 = new JButton("Calificar");
		 btnCalificar_1.setBounds(274, 321, 89, 23);
		 Fisica.add(btnCalificar_1);
		 
		 JPanel panelEstrellasFisica = new JPanel();
		 panelEstrellasFisica.setBackground(new Color(135, 206, 235));
		 panelEstrellasFisica.setBounds(303, 8, 324, 45);
		 Fisica.add(panelEstrellasFisica);
			
			JLabel lblestrella1 = new JLabel("");
			panelEstrellasFisica.add(lblestrella1);
			lblestrella1.setIcon(noMarcado);
			
			JLabel lblestrella2 = new JLabel("");
			panelEstrellasFisica.add(lblestrella2);
			lblestrella2.setIcon(noMarcado);
			
			JLabel lblestrella3 = new JLabel("");
			panelEstrellasFisica.add(lblestrella3);
			lblestrella3.setIcon(noMarcado);
			
			JLabel lblestrella4 = new JLabel("");
			panelEstrellasFisica.add(lblestrella4);
			lblestrella4.setIcon(noMarcado);
			
			JLabel lblestrella5 = new JLabel("");
			panelEstrellasFisica.add(lblestrella5);
			lblestrella5.setIcon(noMarcado);
			
			JLabel lblestrella6 = new JLabel("");
			panelEstrellasFisica.add(lblestrella6);
			lblestrella6.setIcon(noMarcado);
			
			JLabel lblestrella7 = new JLabel("");
			panelEstrellasFisica.add(lblestrella7);
			lblestrella7.setIcon(noMarcado);
			
			JLabel lblestrella8 = new JLabel("");
			panelEstrellasFisica.add(lblestrella8);
			lblestrella8.setIcon(noMarcado);
			
			JLabel lblestrella9 = new JLabel("");
			panelEstrellasFisica.add(lblestrella9);
			lblestrella9.setIcon(noMarcado);
			
			JLabel lblestrella10 = new JLabel("");
			panelEstrellasFisica.add(lblestrella10);
			lblestrella10.setIcon(noMarcado);
			
			JLabel lblpromedio = new JLabel("Promedio:");
			lblpromedio.setBounds(227, 8, 139, 14);
			Fisica.add(lblpromedio);
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
		this.txtbarrio.setText(mostrar.getDireccion().getBarrio());
		this.txtcanton.setText(mostrar.getDireccion().getCanton());
		this.txtcedulajuri.setText(mostrar.getCedulaJuridica());
		this.txtdistrito.setText(mostrar.getDireccion().getDistrito());
		this.txtnombrejuri.setText(mostrar.getNombre());
		this.txtpais.setText(mostrar.getDireccion().getPais());
		this.txtcategoria.setText(mostrar.getCategoria());
		this.txtprovincia.setText(mostrar.getDireccion().getProvincia());
		frmInformacinDelUsuario.setVisible(true);
	}
	
	public void actualizarInformacionPersona(RegistroPersona mostrar) {
		tabbedPane_1.setEnabledAt(0, false);
		tabbedPane_1.setEnabledAt(1, true);
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
		frmInformacinDelUsuario.setVisible(true);	
	}

	public void Icomentarios(Calificacion n, Usuario usuario) {
		// TODO Auto-generated method stub
	}

	@Override
	public void EliminarNotas() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void llenardatos(Usuario u) {
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
