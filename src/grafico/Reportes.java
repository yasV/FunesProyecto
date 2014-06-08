package grafico;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JEditorPane;

import auxiliares.Abuso;

public class Reportes {

	private JFrame frame;
	private JEditorPane editorPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Reportes() {
		initialize();
		this.frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.getContentPane().setLayout(null);
		
		JLabel lblReportes = new JLabel("Reportes");
		lblReportes.setBounds(10, 11, 84, 14);
		frame.getContentPane().add(lblReportes);
		
		editorPane = new JEditorPane();
		editorPane.setBackground(new Color(240, 230, 140));
		editorPane.setBounds(10, 28, 414, 222);
		frame.getContentPane().add(editorPane);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void mostrarreportes(ArrayList <auxiliares.Abuso> abuso){
		for (Abuso a : abuso){
			this.editorPane.setText(editorPane.getText()+ "\n" + "Motivo: " +a.getMotivo() + "Usuario que lo realiza: "+a.getUsuario().getNick()+ 
					"Fecha en la que se realiza el reporte:"+ a.getFechaDenuncia());
		}
	}
}
