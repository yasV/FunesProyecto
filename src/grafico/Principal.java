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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	
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
		
		JLabel label_Direccion = new JLabel("Direcci\u00F3n");
		label_Direccion.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pagUsuarioJuridica.add(label_Direccion);
		
		textFieldCanton = new JTextField();
		textFieldCanton.setColumns(10);
		pagUsuarioJuridica.add(textFieldCanton);
		
		JLabel labelCanton = new JLabel("Cant\u00F3n");
		pagUsuarioJuridica.add(labelCanton);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(173, 216, 230));
		pagUsuarioJuridica.add(panel);
		
		JRadioButton radioButton = new JRadioButton("Senasa");
		radioButton.setBackground(new Color(135, 206, 250));
		radioButton.setBounds(25, 43, 91, 23);
		panel.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("Empresas");
		radioButton_1.setBackground(new Color(135, 206, 250));
		radioButton_1.setBounds(145, 43, 91, 23);
		panel.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("PANI");
		radioButton_2.setBackground(new Color(135, 206, 250));
		radioButton_2.setBounds(261, 43, 91, 23);
		panel.add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("Restaurantes");
		radioButton_3.setBackground(new Color(135, 206, 250));
		radioButton_3.setBounds(373, 43, 91, 23);
		panel.add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("Condominios");
		radioButton_4.setBackground(new Color(135, 206, 250));
		radioButton_4.setBounds(492, 43, 91, 23);
		panel.add(radioButton_4);
		
		JLabel label = new JLabel("*Seleccione una categor\u00EDa");
		label.setBounds(10, 11, 149, 14);
		panel.add(label);
		
		JLabel label_4 = new JLabel("*Nombre de la Persona Jur\u00EDdica: ");
		label_4.setBounds(66, 93, 181, 14);
		panel.add(label_4);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(245, 90, 219, 20);
		panel.add(textField);
		
		JLabel label_5 = new JLabel("C\u00E9dula Jur\u00EDdica:");
		label_5.setBounds(152, 124, 84, 14);
		panel.add(label_5);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(245, 121, 219, 20);
		panel.add(textField_1);
		
		JLabel label_6 = new JLabel("Direcci\u00F3n");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_6.setBounds(222, 152, 91, 23);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("*Pa\u00EDs");
		label_7.setBounds(10, 199, 46, 14);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("*Provincia");
		label_8.setBounds(10, 237, 60, 14);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("*Cant\u00F3n");
		label_9.setBounds(284, 199, 46, 14);
		panel.add(label_9);
		
		JLabel label_10 = new JLabel("*Distrito");
		label_10.setBounds(284, 237, 46, 14);
		panel.add(label_10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(66, 196, 188, 20);
		panel.add(textField_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(66, 234, 181, 20);
		panel.add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(355, 196, 188, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(355, 234, 188, 20);
		panel.add(textField_4);
		
		JLabel label_11 = new JLabel("*Barrio");
		label_11.setBounds(284, 272, 46, 14);
		panel.add(label_11);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(355, 269, 188, 20);
		panel.add(textField_5);
		
		JLabel label_12 = new JLabel("Los campos marcados con * son necesarios");
		label_12.setBounds(21, 350, 226, 14);
		panel.add(label_12);
		
		JButton button = new JButton("Registrar");
		button.setBounds(494, 346, 89, 23);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(173, 216, 230));
		pagUsuarioJuridica.add(panel_1);
		
		JRadioButton radioButton_5 = new JRadioButton("Senasa");
		radioButton_5.setBackground(new Color(135, 206, 250));
		radioButton_5.setBounds(25, 43, 91, 23);
		panel_1.add(radioButton_5);
		
		JRadioButton radioButton_6 = new JRadioButton("Empresas");
		radioButton_6.setBackground(new Color(135, 206, 250));
		radioButton_6.setBounds(145, 43, 91, 23);
		panel_1.add(radioButton_6);
		
		JRadioButton radioButton_7 = new JRadioButton("PANI");
		radioButton_7.setBackground(new Color(135, 206, 250));
		radioButton_7.setBounds(261, 43, 91, 23);
		panel_1.add(radioButton_7);
		
		JRadioButton radioButton_8 = new JRadioButton("Restaurantes");
		radioButton_8.setBackground(new Color(135, 206, 250));
		radioButton_8.setBounds(373, 43, 91, 23);
		panel_1.add(radioButton_8);
		
		JRadioButton radioButton_9 = new JRadioButton("Condominios");
		radioButton_9.setBackground(new Color(135, 206, 250));
		radioButton_9.setBounds(492, 43, 91, 23);
		panel_1.add(radioButton_9);
		
		JLabel label_13 = new JLabel("*Seleccione una categor\u00EDa");
		label_13.setBounds(10, 11, 149, 14);
		panel_1.add(label_13);
		
		JLabel label_14 = new JLabel("*Nombre de la Persona Jur\u00EDdica: ");
		label_14.setBounds(66, 93, 181, 14);
		panel_1.add(label_14);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(245, 90, 219, 20);
		panel_1.add(textField_6);
		
		JLabel label_15 = new JLabel("C\u00E9dula Jur\u00EDdica:");
		label_15.setBounds(152, 124, 84, 14);
		panel_1.add(label_15);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(245, 121, 219, 20);
		panel_1.add(textField_7);
		
		JLabel label_16 = new JLabel("Direcci\u00F3n");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_16.setBounds(222, 152, 91, 23);
		panel_1.add(label_16);
		
		JLabel label_17 = new JLabel("*Pa\u00EDs");
		label_17.setBounds(10, 199, 46, 14);
		panel_1.add(label_17);
		
		JLabel label_18 = new JLabel("*Provincia");
		label_18.setBounds(10, 237, 60, 14);
		panel_1.add(label_18);
		
		JLabel label_19 = new JLabel("*Cant\u00F3n");
		label_19.setBounds(284, 199, 46, 14);
		panel_1.add(label_19);
		
		JLabel label_20 = new JLabel("*Distrito");
		label_20.setBounds(284, 237, 46, 14);
		panel_1.add(label_20);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(66, 196, 188, 20);
		panel_1.add(textField_8);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(66, 234, 181, 20);
		panel_1.add(comboBox_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(355, 196, 188, 20);
		panel_1.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(355, 234, 188, 20);
		panel_1.add(textField_10);
		
		JLabel label_21 = new JLabel("*Barrio");
		label_21.setBounds(284, 272, 46, 14);
		panel_1.add(label_21);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(355, 269, 188, 20);
		panel_1.add(textField_11);
		
		JLabel label_22 = new JLabel("Los campos marcados con * son necesarios");
		label_22.setBounds(21, 350, 226, 14);
		panel_1.add(label_22);
		
		JButton button_1 = new JButton("Registrar");
		button_1.setBounds(494, 346, 89, 23);
		panel_1.add(button_1);
		
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

