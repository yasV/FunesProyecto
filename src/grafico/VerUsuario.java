package grafico;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import aplicacion.Sistema;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Image;

public class VerUsuario extends JFrame{
	
	public VerUsuario(Sistema model) {
		Controlador controlador = new Controlador (model,this);
		initialize();
	}

		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerUsuario frame = new VerUsuario(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			}
		});
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
	tabbedPane.addTab("Información del Usuario", null, PagAdministrador, null);
	PagAdministrador.setLayout(null);
	
	
}
}