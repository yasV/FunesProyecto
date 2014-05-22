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
		
		JPanel pagUsuarioFisico = new JPanel();
		pagUsuarioFisico.setBackground(SystemColor.activeCaption);
		pagUsuarioFisico.setForeground(Color.BLACK);
		pagUsuarioFisico.setFont(new Font("Tahoma", Font.BOLD, 13));
		tabbedPane.addTab("Registro Persona F\u00EDsica", null, pagUsuarioFisico, null);
		
		JLabel label_1 = new JLabel("Ingrese sus datos");
		pagUsuarioFisico.add(label_1);
		
		
		
		JLabel label_2 = new JLabel("Bienvenidos ");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		pagUsuarioFisico.add(label_2);
		
		
		JLabel labelNombre = new JLabel("Nombre");
		pagUsuarioFisico.add(labelNombre);
		
		JLabel lblPrimerApellido = new JLabel("Primer Apellido");
		pagUsuarioFisico.add(lblPrimerApellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		pagUsuarioFisico.add(lblSegundoApellido);
		lblNombre.setBounds(271, 74, 46, 14);
		
		JLabel lblCdula = new JLabel("C\u00E9dula");
		pagUsuarioFisico.add(lblCdula);
		
		JLabel lblGnero = new JLabel("G\u00E9nero");
		pagUsuarioFisico.add(lblGnero);
		
		textFieldNombre = new JTextField();
		pagUsuarioFisico.add(textFieldNombre);
		textFieldNombre.setColumns(10);
			
		}
}

