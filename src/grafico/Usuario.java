package grafico;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

public class Usuario extends JFrame {

	private JPanel contentPane;
	private final JComboBox comboBox = new JComboBox();
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_1;
	private JTextField textField_2;
	private Container buttonGroup;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario frame = new Usuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Usuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 578, 408);
		contentPane.add(tabbedPane);
		
		JPanel PagUsuario = new JPanel();
		tabbedPane.addTab("Página Principal", null, PagUsuario, null);
		PagUsuario.setLayout(null);
		
		JLabel lblBienvenidoUsuario = new JLabel("Bienvenido Usuario");
		lblBienvenidoUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBienvenidoUsuario.setBounds(10, 11, 206, 29);
		PagUsuario.add(lblBienvenidoUsuario);
		
		JPanel Busquedas = new JPanel();
		tabbedPane.addTab("Consultar", null, Busquedas, null);
		Busquedas.setLayout(null);
		
		JRadioButton rdbtnPersonaFsica = new JRadioButton("Persona F\u00EDsica");
		rdbtnPersonaFsica.setBounds(85, 5, 123, 23);
		Busquedas.add(rdbtnPersonaFsica);
		
		JRadioButton rdbtnPersonasJurdicas = new JRadioButton("Persona Jur\u00EDdica");
		rdbtnPersonasJurdicas.setBounds(210, 5, 127, 23);
		Busquedas.add(rdbtnPersonasJurdicas);
		
		JRadioButton rdbtnCategora = new JRadioButton("Categor\u00EDa");
		rdbtnCategora.setBounds(350, 5, 102, 23);
		Busquedas.add(rdbtnCategora);
		comboBox.setBounds(224, 54, 134, 23);
		Busquedas.add(comboBox);
		
		JLabel lblBuscarPor = new JLabel("Buscar por:");
		lblBuscarPor.setBounds(116, 56, 112, 19);
		Busquedas.add(lblBuscarPor);
		
		JLabel lblSeleccione = new JLabel("Seleccione:");
		lblSeleccione.setBounds(116, 103, 105, 19);
		Busquedas.add(lblSeleccione);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(231, 101, 127, 23);
		Busquedas.add(comboBox_1);
		
		JPanel Calificar = new JPanel();
		tabbedPane.addTab("Calificar", null, Calificar, null);
		Calificar.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(152, 98, 387, 55);
		Calificar.add(panel);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			}
		});
		label.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\nomarc1.jpg"));
		panel.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\nomarc1.jpg"));
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\nomarc1.jpg"));
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\nomarc1.jpg"));
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\nomarc1.jpg"));
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\nomarc1.jpg"));
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\nomarc1.jpg"));
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\nomarc1.jpg"));
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\nomarc1.jpg"));
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setIcon(new ImageIcon("C:\\Users\\Admin\\Downloads\\nomarc1.jpg"));
		panel.add(label_9);
		
		JRadioButton rdbtnPersonaFisica = new JRadioButton("Persona F\u00EDsica");
		rdbtnPersonaFisica.setBounds(152, 7, 124, 23);
		Calificar.add(rdbtnPersonaFisica);
		
		JRadioButton rdbtnPersonaJurdica = new JRadioButton("Persona Jur\u00EDdica");
		rdbtnPersonaJurdica.setBounds(293, 7, 124, 23);
		Calificar.add(rdbtnPersonaJurdica);
		
		JLabel lblCalifiqueSuExperiencia = new JLabel("Califique su experiencia:");
		lblCalifiqueSuExperiencia.setBounds(13, 98, 148, 30);
		Calificar.add(lblCalifiqueSuExperiencia);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(152, 53, 180, 23);
		Calificar.add(comboBox_2);
		
		JLabel lblUsuarioACalificar = new JLabel("Usuario a calificar:");
		lblUsuarioACalificar.setBounds(13, 53, 151, 23);
		Calificar.add(lblUsuarioACalificar);
		
		textField = new JTextField();
		textField.setBounds(13, 173, 415, 134);
		Calificar.add(textField);
		textField.setColumns(10);
		
		JLabel lblRegistreUnReview = new JLabel("Registre un review");
		lblRegistreUnReview.setBounds(13, 149, 124, 23);
		Calificar.add(lblRegistreUnReview);
		
		JButton btnGuardar = new JButton("Guardar \r\nCalificaci\u00F3n");
		btnGuardar.setBounds(389, 346, 174, 23);
		Calificar.add(btnGuardar);
		
		JButton btnSubirEvidencia = new JButton("Subir Evidencia");
		btnSubirEvidencia.setBounds(34, 318, 127, 23);
		Calificar.add(btnSubirEvidencia);
		
		JButton btnusuarioNoRegistrado = new JButton("\u00BFUsuario no registrado?");
		btnusuarioNoRegistrado.setBounds(377, 53, 174, 23);
		Calificar.add(btnusuarioNoRegistrado);
		
		JPanel Juridica = new JPanel();
		Juridica.setBackground(new Color(173, 216, 230));
		tabbedPane.addTab("Registro de Persona Jur\u00EDdica", null, Juridica, null);
		tabbedPane.setEnabledAt(4, false);
		Juridica.setLayout(null);
		
		JRadioButton rdbtnSenasa = new JRadioButton("Senasa");
		buttonGroup.add(rdbtnSenasa);
		rdbtnSenasa.setBackground(new Color(135, 206, 250));
		rdbtnSenasa.setBounds(25, 43, 91, 23);
		Juridica.add(rdbtnSenasa);
		
		JRadioButton rdbtnEmpresas = new JRadioButton("Empresas");
		buttonGroup.add(rdbtnEmpresas);
		rdbtnEmpresas.setBackground(new Color(135, 206, 250));
		rdbtnEmpresas.setBounds(129, 43, 91, 23);
		Juridica.add(rdbtnEmpresas);
		
		JRadioButton rdbtnPani = new JRadioButton("PANI");
		buttonGroup.add(rdbtnPani);
		rdbtnPani.setBackground(new Color(135, 206, 250));
		rdbtnPani.setBounds(239, 43, 91, 23);
		Juridica.add(rdbtnPani);
		
		JRadioButton rdbtnRestaurante = new JRadioButton("Restaurantes");
		buttonGroup.add(rdbtnRestaurante);
		rdbtnRestaurante.setBackground(new Color(135, 206, 250));
		rdbtnRestaurante.setBounds(343, 43, 91, 23);
		Juridica.add(rdbtnRestaurante);
		
		JRadioButton rdbtnCondominios = new JRadioButton("Condominios");
		buttonGroup.add(rdbtnCondominios);
		rdbtnCondominios.setBackground(new Color(135, 206, 250));
		rdbtnCondominios.setBounds(452, 43, 91, 23);
		Juridica.add(rdbtnCondominios);
		
		JLabel lblSeleccionesUnaCatego = new JLabel("*Seleccione una categor\u00EDa");
		lblSeleccionesUnaCatego.setBounds(10, 11, 149, 14);
		Juridica.add(lblSeleccionesUnaCatego);
		
		JLabel lblNombreDeLa = new JLabel("*Nombre de la Persona Jur\u00EDdica ");
		lblNombreDeLa.setBounds(10, 80, 181, 14);
		Juridica.add(lblNombreDeLa);
		
		textField_1 = new JTextField();
		textField_1.setBounds(201, 73, 219, 20);
		Juridica.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCdulaJurdica = new JLabel("C\u00E9dula Jur\u00EDdica");
		lblCdulaJurdica.setBounds(20, 107, 84, 14);
		Juridica.add(lblCdulaJurdica);
		
		textField_2 = new JTextField();
		textField_2.setBounds(201, 104, 219, 20);
		Juridica.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDireccin.setBounds(222, 152, 91, 23);
		Juridica.add(lblDireccin);
		
		JLabel lblPas = new JLabel("*Pa\u00EDs");
		lblPas.setBounds(10, 233, 46, 14);
		Juridica.add(lblPas);
		
		JLabel lblProvincia = new JLabel("*Provincia");
		lblProvincia.setBounds(292, 182, 60, 14);
		Juridica.add(lblProvincia);
		
		JLabel lblCantn = new JLabel("*Cant\u00F3n");
		lblCantn.setBounds(292, 219, 46, 14);
		Juridica.add(lblCantn);
		
		JLabel lblDistrito = new JLabel("*Distrito");
		lblDistrito.setBounds(292, 255, 46, 14);
		Juridica.add(lblDistrito);
		
		textField_3 = new JTextField();
		textField_3.setBounds(80, 230, 188, 20);
		Juridica.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(362, 179, 181, 20);
		Juridica.add(comboBox_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(355, 216, 188, 20);
		Juridica.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(355, 252, 188, 20);
		Juridica.add(textField_5);
		
		JLabel lblBarrio = new JLabel("*Barrio");
		lblBarrio.setBounds(292, 292, 46, 14);
		Juridica.add(lblBarrio);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(355, 289, 188, 20);
		Juridica.add(textField_6);
		
		JLabel lblLosCamposMarcados = new JLabel("Los campos marcados con * son necesarios");
		lblLosCamposMarcados.setBounds(10, 327, 226, 14);
		Juridica.add(lblLosCamposMarcados);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(284, 323, 89, 23);
		Juridica.add(btnRegistrar);
	}
}
