package grafico;

import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
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

import java.awt.CardLayout;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.JList;

public class Administrador implements Funciones {

	public JFrame frame;
	private Controlador controlador;
	//public JListActivar list;
	private JButton btnVerUsuarios;
	private JButton btnDesbloquear;
	private JButton btnBloquear;
	
	
	public Administrador(Sistema model,Controlador usar) {
		controlador = usar;
		controlador.C_Administrador(this);
		
		initialize();
		//addEvents();
	}
	
	 		
		
	public JButton getBtnVerUsuarios(){
		return btnVerUsuarios;
	}
	
	public JButton getBtnDesbloquear(){
		
		
		return btnDesbloquear;
	}
	
	public JButton getBtnBloquear(){
		return btnBloquear;
	}

	private void addEvents() {
	//	this.btnA.addActionListener(controlador);
		this.btnVerUsuarios.addActionListener(controlador);
		this.btnBloquear.addActionListener(controlador);
		this.btnDesbloquear.addActionListener(controlador);
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
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
		lblUsuariosActivos.setBounds(59, 57, 151, 14);
		panel.add(lblUsuariosActivos);
		
		JLabel lblUsuariosBloqueados = new JLabel("Usuarios Bloqueados");
		lblUsuariosBloqueados.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsuariosBloqueados.setBounds(555, 57, 178, 14);
		panel.add(lblUsuariosBloqueados);
		
		JPanel panelactivos = new JPanel();
		panelactivos.setBounds(59, 82, 160, 356);
		panel.add(panelactivos);
		panelactivos.setLayout(new BoxLayout(panelactivos, BoxLayout.X_AXIS));
		
		JList listActivos = new JList();
		panelactivos.add(listActivos);
		
		JPanel panelbloqueados = new JPanel();
		panelbloqueados.setBounds(555, 82, 160, 356);
		panel.add(panelbloqueados);
		panelbloqueados.setLayout(new BoxLayout(panelbloqueados, BoxLayout.X_AXIS));
		
		JList listBloqueados = new JList();
		panelbloqueados.add(listBloqueados);
		
		
		JButton btnBloquear = new JButton("Bloquear");
		btnBloquear.setBounds(94, 449, 89, 23);
		panel.add(btnBloquear);
		
		JButton btnDesbloquear = new JButton("Desbloquear");
		btnDesbloquear.setBounds(581, 449, 114, 23);
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
		
		// Botón ver usuarios 
		
		JButton btnVerUsuarios = new JButton("Ver Usuarios");
		btnVerUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnVerUsuarios.setBackground(new Color(0, 255, 0));
		btnVerUsuarios.setForeground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		btnVerUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnVerUsuarios.setBounds(10, 23, 114, 23);
		panel.add(btnVerUsuarios);
		
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(135, 206, 250));
		tabbedPane.addTab("New tab", null, panel_2, null);
		panel_2.setLayout(null);
		
	
		
	}

	private void setJMenuBar(JMenuBar menuBar) {
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
	public void showEmpresa(DefaultComboBoxModel tipo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showPersona(DefaultListModel model, DefaultComboBoxModel tipo) {
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
	public void agregarlista(DefaultListModel nuevo) {
		// TODO Auto-generated method stub
		
	}
}
