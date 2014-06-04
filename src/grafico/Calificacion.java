package grafico;

import java.awt.EventQueue;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JProgressBar;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTree;
import java.awt.Color;
import java.awt.Font;

public class Calificacion extends JApplet {
	private ArrayList <Integer> prueba = new ArrayList <Integer>();
	private JFrame frame;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JProgressBar barra10;
	private JProgressBar barra9;
	private JProgressBar barra8;
	private JProgressBar barra7;
	private JProgressBar barra6;
	private JProgressBar barra1;
	private JProgressBar barra2;
	private JProgressBar barra3;
	private JProgressBar barra4;
	private JProgressBar barra5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel lbl9;
	private JLabel lbl10;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calificacion window = new Calificacion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calificacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		for (int i = 0;i<100;i++){
			prueba.add( (int)(Math.random()*(5+1)+1)); 
		}
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.getContentPane().setForeground(new Color(135, 206, 250));
		frame.setForeground(new Color(135, 206, 250));
		frame.setBounds(100, 100, 423, 290);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		barra1 = new JProgressBar();
		barra1.setBounds(102, 198, 199, 14);
		frame.getContentPane().add(barra1);

		barra2 = new JProgressBar();
		barra2.setBounds(102, 186, 199, 14);
		frame.getContentPane().add(barra2);
		
		barra3 = new JProgressBar();
		barra3.setBounds(102, 173, 199, 14);
		frame.getContentPane().add(barra3);
		
		barra4 = new JProgressBar();
		barra4.setBounds(102, 161, 199, 14);
		frame.getContentPane().add(barra4);
		
		barra5 = new JProgressBar();
		barra5.setBounds(102, 148, 199, 14);
		frame.getContentPane().add(barra5);
		
		JLabel lblNewLabel = new JLabel("5 estrellas");
		lblNewLabel.setBounds(28, 148, 71, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("4 estrellas");
		lblNewLabel_1.setBounds(28, 161, 71, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("3 estrellas");
		lblNewLabel_2.setBounds(28, 173, 71, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("2 estrellas");
		lblNewLabel_3.setBounds(28, 186, 71, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("1 estrella");
		lblNewLabel_4.setBounds(28, 198, 96, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		lbl1 = new JLabel("");
		lbl1.setBounds(311, 198, 46, 14);
		frame.getContentPane().add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setBounds(311, 186, 46, 14);
		frame.getContentPane().add(lbl2);
		
		lbl3 = new JLabel("");
		lbl3.setBounds(311, 173, 46, 14);
		frame.getContentPane().add(lbl3);
		
		lbl4 = new JLabel("");
		lbl4.setBounds(311, 161, 46, 14);
		frame.getContentPane().add(lbl4);
		
		lbl5 = new JLabel("");
		lbl5.setBounds(311, 148, 46, 14);
		frame.getContentPane().add(lbl5);
		
	
		
		barra6 = new JProgressBar();
		barra6.setBounds(102, 136, 199, 14);
		frame.getContentPane().add(barra6);
		
		barra7 = new JProgressBar();
		barra7.setBounds(102, 124, 199, 14);
		frame.getContentPane().add(barra7);
		
		barra8 = new JProgressBar();
		barra8.setBounds(102, 111, 199, 14);
		frame.getContentPane().add(barra8);
		
		barra9 = new JProgressBar();
		barra9.setBounds(102, 99, 199, 14);
		frame.getContentPane().add(barra9);
		
		barra10 = new JProgressBar();
		barra10.setBackground(new Color(240, 230, 140));
		barra10.setBounds(102, 86, 199, 14);
		frame.getContentPane().add(barra10);
		
		JLabel lblNewLabel_5 = new JLabel("6 estrellas");
		lblNewLabel_5.setBounds(28, 136, 71, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("7 estrellas");
		lblNewLabel_6.setBounds(28, 123, 71, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("8 estrellas");
		lblNewLabel_7.setBounds(28, 111, 71, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("9 estrellas");
		lblNewLabel_8.setBounds(28, 99, 71, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("10 estrellas");
		lblNewLabel_9.setBounds(28, 86, 71, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		lbl6 = new JLabel("");
		lbl6.setBounds(311, 136, 46, 14);
		frame.getContentPane().add(lbl6);
		
		lbl7 = new JLabel("");
		lbl7.setBounds(311, 123, 46, 14);
		frame.getContentPane().add(lbl7);
		
		lbl8 = new JLabel("");
		lbl8.setBounds(311, 111, 46, 14);
		frame.getContentPane().add(lbl8);
		
		lbl9 = new JLabel("");
		lbl9.setBounds(311, 99, 46, 14);
		frame.getContentPane().add(lbl9);
		
		lbl10 = new JLabel("");
		lbl10.setBounds(311, 86, 46, 14);
		frame.getContentPane().add(lbl10);
		
		JLabel lblTotalDeEstrellas = new JLabel("Total de Estrellas");
		lblTotalDeEstrellas.setFont(new Font("Stencil", Font.ITALIC, 17));
		lblTotalDeEstrellas.setBounds(115, 11, 199, 52);
		frame.getContentPane().add(lblTotalDeEstrellas);
		
			}
	public void barras (ArrayList <auxiliares.Calificacion> cal){
	
		for (auxiliares.Calificacion x : cal){
			if (x.getCalificacion()==1){
				 barra1.setValue( (barra1.getValue()+1));
			}
			if (x.getCalificacion()==2){
				 barra2.setValue( barra2.getValue()+1);
			}
			if (x.getCalificacion()==3){
				 barra3.setValue( barra3.getValue()+1);
			}
			if (x.getCalificacion()==4){
				 barra4.setValue( barra4.getValue()+1);
			}
			if (x.getCalificacion()==5){
				 barra5.setValue( barra5.getValue()+1);
			}
			if (x.getCalificacion()==6){
				 barra6.setValue( barra6.getValue()+1);
			}
			if (x.getCalificacion()==7){
				 barra7.setValue( barra7.getValue()+1);
			}
			if (x.getCalificacion()==8){
				 barra8.setValue( barra8.getValue()+1);
			}
			if (x.getCalificacion()==9){
				 barra9.setValue( barra9.getValue()+1);
			}
			if (x.getCalificacion()==10){
				 barra10.setValue( barra10.getValue()+1);
			}
			
			}
		lbl1.setText(Integer.toString(barra1.getValue()));
		lbl2.setText(Integer.toString(barra2.getValue()));
		lbl3.setText(Integer.toString(barra3.getValue()));
		lbl4.setText(Integer.toString(barra4.getValue()));
		lbl5.setText(Integer.toString(barra5.getValue()));
		lbl6.setText(Integer.toString(barra6.getValue()));
		lbl7.setText(Integer.toString(barra7.getValue()));
		lbl8.setText(Integer.toString(barra8.getValue()));
		lbl9.setText(Integer.toString(barra9.getValue()));
		lbl10.setText(Integer.toString(barra10.getValue()));
	}

	public void addFocusListener(JList listaconsultar) {
		this.setVisible(true);
		
	}
			}	
		
	

