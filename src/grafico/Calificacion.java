package grafico;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JProgressBar;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.JTextField;

public class Calificacion  {
	private ArrayList <Integer> prueba = new ArrayList <Integer>();
	public JFrame frame;
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
	private JTextField txttotal;

	/**
	 * Launch the application.
	 */


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
	
		frame = new JFrame();
		frame.setBounds(100, 100, 465, 331);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		barra1 = new JProgressBar();
		barra1.setBounds(60, 236, 199, 14);
		frame.getContentPane().add(barra1);
		
		barra2 = new JProgressBar();
		barra2.setBounds(60, 211, 199, 14);
		frame.getContentPane().add(barra2);
		


		barra3 = new JProgressBar();
		barra3.setBounds(60, 186, 199, 14);
		frame.getContentPane().add(barra3);
		
		 barra4 = new JProgressBar();
		barra4.setBounds(60, 161, 199, 14);
		frame.getContentPane().add(barra4);
		
		barra5 = new JProgressBar();
		barra5.setBounds(60, 136, 199, 14);
		frame.getContentPane().add(barra5);
		
		JLabel lblNewLabel = new JLabel("5");
		lblNewLabel.setBounds(28, 136, 22, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("4");
		lblNewLabel_1.setBounds(28, 161, 22, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("3");
		lblNewLabel_2.setBounds(28, 186, 22, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("2");
		lblNewLabel_3.setBounds(28, 211, 22, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("1");
		lblNewLabel_4.setBounds(28, 236, 22, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		lbl1 = new JLabel("");
		lbl1.setBounds(294, 236, 46, 14);
		frame.getContentPane().add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setBounds(294, 211, 46, 14);
		frame.getContentPane().add(lbl2);
		
		lbl3 = new JLabel("");
		lbl3.setBounds(294, 186, 46, 14);
		frame.getContentPane().add(lbl3);
		
		lbl4 = new JLabel("");
		lbl4.setBounds(294, 161, 46, 14);
		frame.getContentPane().add(lbl4);
		
		lbl5 = new JLabel("");
		lbl5.setBounds(294, 136, 46, 14);
		frame.getContentPane().add(lbl5);
		
	
		
		barra6 = new JProgressBar();
		barra6.setBounds(60, 111, 199, 14);
		frame.getContentPane().add(barra6);
		
		barra7 = new JProgressBar();
		barra7.setBounds(60, 86, 199, 14);
		frame.getContentPane().add(barra7);
		
		barra8 = new JProgressBar();
		barra8.setBounds(60, 61, 199, 14);
		frame.getContentPane().add(barra8);
		
		barra9 = new JProgressBar();
		barra9.setBounds(60, 36, 199, 14);
		frame.getContentPane().add(barra9);
		
		barra10 = new JProgressBar();
		barra10.setBounds(60, 11, 199, 14);
		frame.getContentPane().add(barra10);
		
		JLabel lblNewLabel_5 = new JLabel("6");
		lblNewLabel_5.setBounds(28, 111, 22, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("7");
		lblNewLabel_6.setBounds(28, 86, 22, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("8");
		lblNewLabel_7.setBounds(28, 61, 22, 14);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("9");
		lblNewLabel_8.setBounds(28, 36, 22, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("10");
		lblNewLabel_9.setBounds(28, 11, 22, 14);
		frame.getContentPane().add(lblNewLabel_9);
		
		lbl6 = new JLabel("");
		lbl6.setBounds(294, 111, 46, 14);
		frame.getContentPane().add(lbl6);
		
		lbl7 = new JLabel("");
		lbl7.setBounds(294, 86, 46, 14);
		frame.getContentPane().add(lbl7);
		
		lbl8 = new JLabel("");
		lbl8.setBounds(294, 61, 46, 14);
		frame.getContentPane().add(lbl8);
		
		lbl9 = new JLabel("");
		lbl9.setBounds(294, 36, 46, 14);
		frame.getContentPane().add(lbl9);
		
		lbl10 = new JLabel("");
		lbl10.setBounds(294, 11, 46, 14);
		frame.getContentPane().add(lbl10);
		
		JLabel lblTotalDePersonas = new JLabel("Total de Personas: ");
		lblTotalDePersonas.setBounds(90, 267, 122, 14);
		frame.getContentPane().add(lblTotalDePersonas);
		
		txttotal = new JTextField();
		txttotal.setEditable(false);
		txttotal.setBounds(202, 261, 86, 20);
		frame.getContentPane().add(txttotal);
		txttotal.setColumns(10);
		
			}
	public void barras (ArrayList <auxiliares.Calificacion> cal){
		barra1.removeAll();
		barra2.removeAll();
		barra3.removeAll();
		barra4.removeAll();
		barra5.removeAll();
		barra6.removeAll();
		barra7.removeAll();
		barra8.removeAll();
		barra9.removeAll();
		barra10.removeAll();
		txttotal.setText(Integer.toString(cal.size()));
		for (auxiliares.Calificacion x : cal){
			if (x.getCalificacion()==1){
				 barra1.setValue( (barra1.getValue()+1)*100/cal.size());
				 lbl1.setText(lbl1.getText()+1);
			}
			if (x.getCalificacion()==2){
				 barra2.setValue( (barra2.getValue()+1)*100/cal.size());
				 lbl2.setText(lbl2.getText()+1);
			}
			if (x.getCalificacion()==3){
				 barra3.setValue( (barra3.getValue()+1)*100/cal.size());
				 lbl3.setText(lbl3.getText()+1);
			}
			if (x.getCalificacion()==4){
				 barra4.setValue( (barra4.getValue()+1)*100/cal.size());
				 lbl4.setText(lbl4.getText()+1);
			}
			if (x.getCalificacion()==5){
				 barra5.setValue( (barra5.getValue()+1)*100/cal.size());
				 lbl5.setText(lbl5.getText()+1);
			}
			if (x.getCalificacion()==6){
				 barra6.setValue( (barra6.getValue()+1)*100/cal.size());
				 lbl6.setText(lbl6.getText()+1);
			}
			if (x.getCalificacion()==7){
				 barra7.setValue( (barra7.getValue()+1)*100/cal.size());
				 lbl7.setText(lbl7.getText()+1);
			}
			if (x.getCalificacion()==8){
				 barra8.setValue( (barra8.getValue()+1)*100/cal.size());
				 lbl8.setText(lbl8.getText()+1);
			}
			if (x.getCalificacion()==9){
				 barra9.setValue( (barra9.getValue()+1)*100/cal.size());
				 lbl9.setText(lbl9.getText()+1);
			}
			if (x.getCalificacion()==10){
				 barra10.setValue( (barra10.getValue()+1)*100/cal.size());
				 lbl10.setText(lbl10.getText()+1);
			}
			
			}
	
	}
			}	
		
	

