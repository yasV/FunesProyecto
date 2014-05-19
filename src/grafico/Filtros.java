package grafico;

import java.awt.BorderLayout;
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

public class Filtros extends JFrame {

	private JPanel contentPane;
	private final JComboBox comboBox = new JComboBox();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filtros frame = new Filtros();
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
	public Filtros() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 554, 380);
		contentPane.add(tabbedPane);
		
		JPanel PagUsuario = new JPanel();
		tabbedPane.addTab("Página Principal", null, PagUsuario, null);
		PagUsuario.setLayout(null);
		
		JLabel lblBienvenidoUsuario = new JLabel("Bienvenido Usuario");
		lblBienvenidoUsuario.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBienvenidoUsuario.setBounds(10, 11, 206, 29);
		PagUsuario.add(lblBienvenidoUsuario);
		
		JPanel Busquedas = new JPanel();
		tabbedPane.addTab("Busqueda", null, Busquedas, null);
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
		comboBox_2.setBounds(167, 53, 148, 23);
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
		btnGuardar.setBounds(365, 318, 174, 23);
		Calificar.add(btnGuardar);
	}
}
