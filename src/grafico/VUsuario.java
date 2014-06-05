package grafico;

import java.awt.EventQueue;


import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import aplicacion.Funciones;
import aplicacion.Usuario;
import auxiliares.Calificacion;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JEditorPane;

import entidades.Empresa;
import entidades.RegistroPersona;

public class VUsuario  implements Funciones{

	private JFrame frame;
	private JTextPane txtprivacidad;
	private JLabel lblnombre;
	protected JLabel lblnick;
	private Controlador controlador;
	public JButton btnreportar;
	protected JEditorPane editorPane;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public VUsuario( Controlador usar) {
		controlador = usar;
		controlador.C_VUsuario(this);
		initialize();
		addEvents();
	}
	private void addEvents() {
       this.btnreportar.addActionListener(controlador);
    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBounds(100, 100, 522, 368);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblPrivacidad = new JLabel("Privacidad");
		lblPrivacidad.setBounds(10, 11, 77, 14);
		frame.getContentPane().add(lblPrivacidad);
		
	    txtprivacidad = new JTextPane();
		txtprivacidad.setBounds(86, 11, 338, 20);
		frame.getContentPane().add(txtprivacidad);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 63, 77, 14);
		frame.getContentPane().add(lblNombre);
		
	    lblnombre = new JLabel("New label");
		lblnombre.setBounds(88, 63, 325, 14);
		frame.getContentPane().add(lblnombre);
		
		JLabel lblNick = new JLabel("Nick");
		lblNick.setBounds(10, 110, 46, 14);
		frame.getContentPane().add(lblNick);
		
		lblnick = new JLabel("New label");
		lblnick.setBounds(86, 110, 338, 14);
		frame.getContentPane().add(lblnick);
		
		JLabel lblNewLabel = new JLabel("\u00BFCree usted que este usuario esta haciendo algo incorrecto?Escriba su reporte aqu\u00ED ");
		lblNewLabel.setBounds(10, 146, 486, 14);
		frame.getContentPane().add(lblNewLabel);
		
		 btnreportar = new JButton("Reportar abuso");
		btnreportar.setBounds(185, 295, 153, 23);
		frame.getContentPane().add(btnreportar);
		
		editorPane = new JEditorPane();
		editorPane.setBounds(33, 171, 451, 110);
		frame.getContentPane().add(editorPane);
	}

	public void llenardatos(Usuario u) {
		frame.setVisible(true);
		System.out.println("LLegue");
		if (!u.isPrivado()){
			txtprivacidad.setText("Los datos de este usuario son privados");
			lblnombre.setText("Datos privados");
			lblnick.setText(u.getNick());
		}
		else{
			txtprivacidad.setText("Los datos de este usuario son públicos");
			lblnick.setText(u.getNick());
			lblnombre.setText(u.getNombre());
		}
		
			
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarInformacionPersona(RegistroPersona mostrar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Icomentarios(Calificacion n, Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrarabusos(Date fechaDenuncia, String motivo) {
		// TODO Auto-generated method stub
		

}
	@Override
	public void IniciarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void CuentaEliminada() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void EliminarNotas() {
		// TODO Auto-generated method stub
		
	}}
