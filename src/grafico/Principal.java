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
	private JTextField textFieldCanton;
	private JTextField textFieldDía;
	private JTextField textFieldAño;
	private JTextField textFieldInstitucion;
	private JTextField textFieldCargo;
	private JTextField textFieldNickname;

	
	public static void main(String[]args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					Principal frame = new Principal();
					frame.setVisible(true);
					
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		});
				
	}
	
	
	
	public Principal(){
		
		setTitle("Sistema Funes-Usuario ");
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
		Component lblNombre = null;
		
		
		JPanel pagUsuarioFisico = new JPanel();
		pagUsuarioFisico.setBackground(SystemColor.activeCaption);
		pagUsuarioFisico.setForeground(Color.BLACK);
		pagUsuarioFisico.setFont(new Font("Tahoma", Font.BOLD, 13));
		tabbedPane.addTab("Registro Persona F\u00EDsica", null, pagUsuarioFisico, null);
		pagUsuarioFisico.setLayout(null);
		
		textFieldPrimerApellido = new JTextField();
		textFieldPrimerApellido.setBounds(114, 187, 86, 20);
		pagUsuarioFisico.add(textFieldPrimerApellido);
		textFieldPrimerApellido.setColumns(10);
		
		textFieldSegundoApellido = new JTextField();
		textFieldSegundoApellido.setBounds(114, 218, 86, 20);
		pagUsuarioFisico.add(textFieldSegundoApellido);
		textFieldSegundoApellido.setColumns(10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(114, 147, 86, 20);
		pagUsuarioFisico.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel label_1 = new JLabel("Ingrese sus datos");
		label_1.setBounds(29, 74, 86, 14);
		pagUsuarioFisico.add(label_1);
		
		
		JLabel label_2 = new JLabel("Bienvenidos ");
		label_2.setBounds(261, 21, 114, 22);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		pagUsuarioFisico.add(label_2);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		lblPrimerApellido.setBounds(30, 190, 70, 14);
		pagUsuarioFisico.add(lblPrimerApellido);
		
		TextFieldCedula = new JTextField();
		TextFieldCedula.setBounds(114, 249, 86, 20);
		TextFieldCedula.setEditable(false);
		TextFieldCedula.setHorizontalAlignment(SwingConstants.RIGHT);
		pagUsuarioFisico.add(TextFieldCedula);
		TextFieldCedula.setColumns(10);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		lblSegundoApellido.setBounds(29, 221, 82, 14);
		pagUsuarioFisico.add(lblSegundoApellido);
		
		JLabel lblCdula = new JLabel("C\u00E9dula");
		lblCdula.setBounds(29, 252, 33, 14);
		pagUsuarioFisico.add(lblCdula);
		
		JLabel lblGnero = new JLabel("G\u00E9nero");
		lblGnero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGnero.setBounds(348, 72, 70, 14);
		pagUsuarioFisico.add(lblGnero);
		
		JLabel labelDía = new JLabel("D\u00EDa");
		labelDía.setBounds(246, 203, 31, 14);
		pagUsuarioFisico.add(labelDía);
		
		textFieldDía = new JTextField();
		textFieldDía.setColumns(10);
		textFieldDía.setBounds(274, 200, 46, 20);
		pagUsuarioFisico.add(textFieldDía);
		
		JLabel labelMes = new JLabel("Mes");
		labelMes.setBounds(344, 203, 31, 14);
		pagUsuarioFisico.add(labelMes);
		
		JComboBox comboBoxMes = new JComboBox();
		comboBoxMes.setBounds(372, 200, 138, 20);
		pagUsuarioFisico.add(comboBoxMes);
		
		JLabel label_5 = new JLabel("Fecha de Nacimiento");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_5.setBounds(348, 170, 138, 14);
		pagUsuarioFisico.add(label_5);
		
		JLabel labelAño = new JLabel("*A\u00F1o");
		labelAño.setBounds(530, 203, 31, 14);
		pagUsuarioFisico.add(labelAño);
		
		textFieldAño = new JTextField();
		textFieldAño.setColumns(10);
		textFieldAño.setBounds(563, 200, 55, 20);
		pagUsuarioFisico.add(textFieldAño);
		
		JLabel label_7 = new JLabel("Empleo");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label_7.setBounds(348, 247, 138, 21);
		pagUsuarioFisico.add(label_7);
		
		JLabel labelInstitución = new JLabel("Instituci\u00F3n donde labora:");
		labelInstitución.setBounds(229, 292, 135, 14);
		pagUsuarioFisico.add(labelInstitución);
		
		textFieldInstitucion = new JTextField();
		textFieldInstitucion.setColumns(10);
		textFieldInstitucion.setBounds(374, 289, 189, 20);
		pagUsuarioFisico.add(textFieldInstitucion);
		
		JLabel labelCargo = new JLabel("Cargo que ocupa");
		labelCargo.setBounds(229, 317, 123, 14);
		pagUsuarioFisico.add(labelCargo);
		
		textFieldCargo = new JTextField();
		textFieldCargo.setColumns(10);
		textFieldCargo.setBounds(373, 314, 190, 20);
		pagUsuarioFisico.add(textFieldCargo);
		
		JRadioButton rdbtnFemenino = new JRadioButton("Femenino");
		rdbtnFemenino.setBounds(255, 108, 109, 23);
		pagUsuarioFisico.add(rdbtnFemenino);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBounds(377, 108, 109, 23);
		pagUsuarioFisico.add(rdbtnMasculino);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(29, 119, 46, 14);
		pagUsuarioFisico.add(lblNickname);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setBounds(114, 116, 86, 20);
		pagUsuarioFisico.add(textFieldNickname);
		textFieldNickname.setColumns(10);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(42, 313, 89, 23);
		pagUsuarioFisico.add(btnRegistrar);			
		
		JLabel lblNombre_1 = new JLabel("Nombre");
		lblNombre_1.setBounds(29, 150, 46, 14);
		pagUsuarioFisico.add(lblNombre_1);
		}
}
