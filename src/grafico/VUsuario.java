package grafico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import aplicacion.Usuario;

import java.awt.Color;

public class VUsuario {

	private JFrame frmDatosDelUsuario;
	private JTextPane txtprivacidad;
	private JLabel lblnombre;
	private JLabel lblnick;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VUsuario window = new VUsuario();
					window.frmDatosDelUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmDatosDelUsuario = new JFrame();
		frmDatosDelUsuario.setTitle("Datos del Usuario");
		frmDatosDelUsuario.getContentPane().setBackground(new Color(135, 206, 250));
		frmDatosDelUsuario.setBounds(100, 100, 450, 188);
		frmDatosDelUsuario.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmDatosDelUsuario.getContentPane().setLayout(null);
		frmDatosDelUsuario.setVisible(true);
		
		JLabel lblPrivacidad = new JLabel("Privacidad");
		lblPrivacidad.setBounds(10, 11, 77, 14);
		frmDatosDelUsuario.getContentPane().add(lblPrivacidad);
		
	    txtprivacidad = new JTextPane();
	    txtprivacidad.setEditable(false);
		txtprivacidad.setBounds(86, 11, 338, 20);
		frmDatosDelUsuario.getContentPane().add(txtprivacidad);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 63, 77, 14);
		frmDatosDelUsuario.getContentPane().add(lblNombre);
		
	    lblnombre = new JLabel("New label");
		lblnombre.setBounds(88, 63, 325, 14);
		frmDatosDelUsuario.getContentPane().add(lblnombre);
		
		JLabel lblNick = new JLabel("Nick");
		lblNick.setBounds(10, 110, 46, 14);
		frmDatosDelUsuario.getContentPane().add(lblNick);
		
		lblnick = new JLabel("New label");
		lblnick.setBounds(86, 110, 338, 14);
		frmDatosDelUsuario.getContentPane().add(lblnick);
	}

	public void llenardatos(Usuario u) {
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
}
