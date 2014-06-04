package grafico;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextPane;

import entidades.Empresa;
import entidades.RegistroPersona;
import aplicacion.Funciones;
import aplicacion.Sistema;
import aplicacion.Usuario;
import auxiliares.Calificacion;

import java.awt.CardLayout;


import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JList;

import java.io.File;


public class Administrador implements Funciones {

	public JFrame frame;
	private Controlador controlador;
	
	
	public Administrador(Sistema model,Controlador usar) {
		controlador = usar;
		controlador.C_Administrador(this);
		initialize();
	}

	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 230, 140));
		frame.setBackground(new Color(240, 230, 140));
		frame.setBounds(100, 100, 828, 591);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(135, 206, 250));
		tabbedPane.setBounds(10, 11, 792, 530);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(135, 206, 250));
		tabbedPane.addTab("Control de Usuarios", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblUsuariosActivos = new JLabel("Usuarios Activos");
		lblUsuariosActivos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuariosActivos.setBounds(68, 32, 151, 14);
		panel.add(lblUsuariosActivos);
		
		JLabel lblUsuariosBloqueados = new JLabel("Usuarios Bloqueados");
		lblUsuariosBloqueados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuariosBloqueados.setBounds(555, 34, 178, 14);
		panel.add(lblUsuariosBloqueados);
		
		JPanel panelactivos = new JPanel();
		panelactivos.setBounds(59, 57, 160, 356);
		panel.add(panelactivos);
		
		JPanel panelbloqueados = new JPanel();
		panelbloqueados.setBounds(555, 59, 160, 356);
		panel.add(panelbloqueados);
		
		JButton btnBloquear = new JButton("Bloquear");
		btnBloquear.setBounds(96, 418, 89, 23);
		panel.add(btnBloquear);
		
		JButton btnDesbloquear = new JButton("Desbloquear");
		btnDesbloquear.setBounds(582, 418, 114, 23);
		panel.add(btnDesbloquear);
		
		JLabel lblMsInformacin = new JLabel("M\u00E1s informaci\u00F3n");
		lblMsInformacin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMsInformacin.setBounds(337, 85, 100, 14);
		panel.add(lblMsInformacin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(243, 117, 281, 270);
		panel.add(panel_1);
		panel_1.setLayout(new CardLayout(0, 0));
		
		JTextPane textPane = new JTextPane();
		panel_1.add(textPane, "name_267961256601016");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 250));
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
	}

	
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	////Métodos que implementan la vista

	public void IniciarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
	}

	public void showEmpresa(DefaultComboBoxModel model) {
		// TODO Auto-generated method stub	
	}

	public void showRegistro() {
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
	public void Icomentarios(Calificacion n, Usuario usuario) {
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





	public void CuentaEliminada() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void EliminarNotas() {

		
	}
}
