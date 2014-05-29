package grafico;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
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

import aplicacion.Funciones;
import aplicacion.Sistema;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Administrador extends JFrame {
	private Controlador controlador;
	private JTextField txtNick;
	private JPasswordField passwordField;
	

		public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrador frame = new Administrador(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


	public Administrador(Sistema model){
		controlador = new Controlador (model,this);
		initialize();
				}
		
	public void initialize() {
		setTitle("Sistema Funes-Usuario");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 469);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 683, 408);
		contentPane.add(tabbedPane);
		
		JPanel PagAdministrador = new JPanel();
		PagAdministrador.setBackground(new Color(135, 206, 250));
		tabbedPane.addTab("Inicio", null, PagAdministrador, null);
		PagAdministrador.setLayout(null);
		
		txtNick = new JTextField();
		txtNick.setBounds(150, 94, 112, 20);
		PagAdministrador.add(txtNick);
		txtNick.setColumns(10);
		
		JLabel lblBienvenido = new JLabel("Bienvenidos");
		lblBienvenido.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBienvenido.setBounds(234, 11, 201, 31);
		PagAdministrador.add(lblBienvenido);
		
		JLabel lblNickName = new JLabel("Nick name");
		lblNickName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNickName.setBounds(88, 97, 62, 14);
		PagAdministrador.add(lblNickName);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContrasea.setBounds(317, 100, 82, 14);
		PagAdministrador.add(lblContrasea);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(406, 94, 124, 20);
		PagAdministrador.add(passwordField);
		
		JButton btnUsuario = new JButton("Usuario");
		btnUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = txtNick.getText();
				if (txtNick.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Ingrese un dato válido");
					txtNick.setText("");
				}
				else{
								}
				
			}
		});
		btnUsuario.setBounds(207, 130, 89, 23);
		PagAdministrador.add(btnUsuario);
		
		JButton btnAdministrador = new JButton("Administrador");
		btnAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdministrador.setBounds(322, 130, 112, 23);
		PagAdministrador.add(btnAdministrador);
		
		JLabel lblRegistrarse = new JLabel("Registrarse");
		lblRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRegistrarse.setBounds(20, 198, 94, 20);
		PagAdministrador.add(lblRegistrarse);
		
		JButton btnRegistrarseComoUsuario = new JButton("Registrarse como Usuario F\u00EDsico");
		btnRegistrarseComoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrarseComoUsuario.setBounds(152, 236, 239, 23);
		PagAdministrador.add(btnRegistrarseComoUsuario);
		
		JButton btnRegistrarseComoJurdico = new JButton("Registrarse como Usuario Jur\u00EDdico");
		btnRegistrarseComoJurdico.setBounds(152, 281, 239, 23);
		PagAdministrador.add(btnRegistrarseComoJurdico);
		
		JButton btnAyuda = new JButton("Ayuda");
		btnAyuda.setBounds(216, 328, 102, 23);
		PagAdministrador.add(btnAyuda);
		
		JLabel lblEntrar = new JLabel("Entrar");
		lblEntrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEntrar.setBounds(20, 57, 46, 14);
		PagAdministrador.add(lblEntrar);
		
	
		

}
}
