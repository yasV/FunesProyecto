package grafico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.ButtonGroup;


public class Principal extends JFrame{
	
	private JPanel contentPane;
	private JTable PagUsuarioJuridico;
	private JTextField textFieldNombre;
	private JTabbedPane tabbedPane; 
	private JTextField textFieldPrimerApellido;
	private JTextField textFieldSegundoApellido;
	private JTextField TextFieldCedula;
	private JTextField textFieldNombreJuridico;
	private JTextField textFieldCedulaJuridica;
	private JTextField textFieldCanton;
	private JTextField textFieldDistrito;
	private JTextField textFieldBarrio;
	private JTextField textFieldPais;

	
	public static void main(String[]args){
	}
	
	public Principal(){
		
		setTitle("Sistema Funes-Usuario ");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 469);
		
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 40, 100));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 683, 408);
		contentPane.add(tabbedPane);
		Component lblNombre = null;
		lblNombre.setBounds(271, 74, 46, 14);
		
		JPanel pagUsuarioJuridica = new JPanel();
		pagUsuarioJuridica.setBackground(SystemColor.activeCaption);
		pagUsuarioJuridica.setForeground(Color.BLACK);
		pagUsuarioJuridica.setFont(new Font("Tahoma", Font.BOLD, 13));
		tabbedPane.addTab("Registro Persona Jur\u00EDdica", null, pagUsuarioJuridica, null);
		
		JLabel lblNombreDeLa = new JLabel("Nombre de la Persona Jur\u00EDdica: ");
		pagUsuarioJuridica.add(lblNombreDeLa);
		
		textFieldNombreJuridico = new JTextField();
		textFieldNombreJuridico.setColumns(10);
		pagUsuarioJuridica.add(textFieldNombreJuridico);
		
		JLabel label_3 = new JLabel("C\u00E9dula Jur\u00EDdica:");
		pagUsuarioJuridica.add(label_3);
		
		textFieldCedulaJuridica = new JTextField();
		textFieldCedulaJuridica.setColumns(10);
		pagUsuarioJuridica.add(textFieldCedulaJuridica);
		
		
		textFieldDistrito = new JTextField();
		textFieldDistrito.setColumns(10);
		pagUsuarioJuridica.add(textFieldDistrito);
		
		JLabel lblPais = new JLabel("Pa\u00EDs");
		pagUsuarioJuridica.add(lblPais);
		
		textFieldBarrio = new JTextField();
		textFieldBarrio.setColumns(10);
		pagUsuarioJuridica.add(textFieldBarrio);
		
		JLabel lblDistrito = new JLabel("Distrito");
		pagUsuarioJuridica.add(lblDistrito);
		
		JLabel lblBarrio = new JLabel("Barrio");
		pagUsuarioJuridica.add(lblBarrio);
		
		textFieldPais = new JTextField();
		textFieldPais.setColumns(10);
		pagUsuarioJuridica.add(textFieldPais);
		
		JPanel pagUsuarioFisico = new JPanel();
		pagUsuarioFisico.setBackground(SystemColor.activeCaption);
		pagUsuarioFisico.setForeground(Color.BLACK);
		pagUsuarioFisico.setFont(new Font("Tahoma", Font.BOLD, 13));
		tabbedPane.addTab("Registro Persona F\u00EDsica", null, pagUsuarioFisico, null);
		
		textFieldPrimerApellido = new JTextField();
		pagUsuarioFisico.add(textFieldPrimerApellido);
		textFieldPrimerApellido.setColumns(10);
		
		textFieldSegundoApellido = new JTextField();
		pagUsuarioFisico.add(textFieldSegundoApellido);
		textFieldSegundoApellido.setColumns(10);
		
		textFieldNombre = new JTextField();
		pagUsuarioFisico.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel label_1 = new JLabel("Ingrese sus datos");
		pagUsuarioFisico.add(label_1);
		
		
		
		JLabel label_2 = new JLabel("Bienvenidos ");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		pagUsuarioFisico.add(label_2);
		
		
		JLabel labelNombre = new JLabel("Nombre");
		pagUsuarioFisico.add(labelNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		pagUsuarioFisico.add(lblPrimerApellido);
		
		TextFieldCedula = new JTextField();
		TextFieldCedula.setEditable(false);
		TextFieldCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		pagUsuarioFisico.add(TextFieldCedula);
		TextFieldCedula.setColumns(10);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		pagUsuarioFisico.add(lblSegundoApellido);
		lblNombre.setBounds(271, 74, 46, 14);
		
		JLabel lblCdula = new JLabel("C\u00E9dula");
		pagUsuarioFisico.add(lblCdula);
		
		JLabel lblGnero = new JLabel("G\u00E9nero");
		pagUsuarioFisico.add(lblGnero);
			
		}
}

