package grafico;

import java.awt.Color;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import entidades.Empresa;
import entidades.RegistroPersona;
import aplicacion.Funciones;
import aplicacion.Usuario;
import auxiliares.Calificacion;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.util.Date;

import javax.swing.JProgressBar;

public class calificar implements Funciones {

private Controlador controlador;
private JFrame frame;
private Component lblStars8;
private JLabel lblStars9;
private JLabel lblStars7;
private Component lblStars6;
private JLabel lblStars5;
private JLabel lblStars4;
private JLabel lblStars3;
private JLabel lblStars2;

public calificar(Controlador usar) {
	controlador = usar;
	controlador.C_Calificacion(this);
	initialize();
	addEvents();
	initialize();
}


private void addEvents() {
	// TODO Auto-generated method stub
	
}

private void initialize() {
	// TODO Auto-generated method stub
	frame = new JFrame();
	frame.getContentPane().setBackground(new Color(240, 230, 140));
	frame.setBackground(new Color(240, 230, 140));
	frame.setBounds(100, 100, 828, 591);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);
	
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBackground(new Color(135, 206, 250));
	tabbedPane.setBounds(10, 11, 792, 530);
	frame.getContentPane().add(tabbedPane);
	
	JPanel calificacion = new JPanel();
	calificacion.setBackground(new Color(135, 206, 250));
	tabbedPane.addTab("Calificación", null, calificacion, null);
	calificacion.setLayout(null);
	
	JPanel panel = new JPanel();
	panel.setLayout(null);
	panel.setBackground(new Color(135, 206, 250));
	panel.setBounds(282, 72, 439, 346);
	calificacion.add(panel);
	panel.setLayout(null);
		
	JLabel lblStart10 = new JLabel("10 Stars");
	lblStart10.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblStart10.setBounds(10, 38, 68, 16);
	panel.add(lblStart10);
	
	lblStars9 = new JLabel("9 Stars");
	lblStars9.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblStars9.setBounds(10, 65, 68, 14);
	panel.add(lblStars9);
	
	lblStars8 = new JLabel("8 Stars");
	lblStars8.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblStars8.setBounds(10, 89, 68, 14);
	panel.add(lblStars8);
	
	lblStars7 = new JLabel("7 Stars");
	lblStars7.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblStars7.setBounds(10, 114, 68, 14);
	panel.add(lblStars7);
	
	lblStars6 = new JLabel("6 Stars");
	lblStars6.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblStars6.setBounds(10, 139, 68, 14);
	panel.add(lblStars6);
	
	lblStars5 = new JLabel("5 Stars");
	lblStars5.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblStars5.setBounds(10, 164, 68, 14);
	panel.add(lblStars5);
	
	lblStars4 = new JLabel("4 Stars");
	lblStars4.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblStars4.setBounds(10, 189, 68, 14);
	panel.add(lblStars4);
	
	lblStars3 = new JLabel("3 Stars");
	lblStars3.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblStars3.setBounds(10, 214, 68, 14);
	panel.add(lblStars3);
	
	lblStars2 = new JLabel("2 Stars");
	lblStars2.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblStars2.setBounds(10, 239, 68, 14);
	panel.add(lblStars2);
	
	JProgressBar progressBarStar10 = new JProgressBar();
	progressBarStar10.setBounds(88, 40, 270, 14);
	panel.add(progressBarStar10);
	
	JProgressBar progressBarStar9 = new JProgressBar();
	progressBarStar9.setBounds(88, 65, 270, 14);
	panel.add(progressBarStar9);
	
	JProgressBar progressBarStar8 = new JProgressBar();
	progressBarStar8.setBounds(88, 89, 270, 14);
	panel.add(progressBarStar8);
	
	JProgressBar progressBarStar7 = new JProgressBar();
	progressBarStar7.setBounds(88, 114, 270, 14);
	panel.add(progressBarStar7);
	
	JProgressBar progressBar_Stars6 = new JProgressBar();
	progressBar_Stars6.setBounds(88, 139, 270, 14);
	panel.add(progressBar_Stars6);
	
	JLabel lblStars = new JLabel("1 Stars");
	lblStars.setFont(new Font("Tahoma", Font.PLAIN, 14));
	lblStars.setBounds(10, 264, 68, 14);
	panel.add(lblStars);
	
	JProgressBar progressBar_Stars5 = new JProgressBar();
	progressBar_Stars5.setBounds(88, 164, 270, 14);
	panel.add(progressBar_Stars5);
	
	JProgressBar progressBar_Stars4 = new JProgressBar();
	progressBar_Stars4.setBounds(88, 189, 270, 14);
	panel.add(progressBar_Stars4);
	
	JProgressBar progressBar_Stars3 = new JProgressBar();
	progressBar_Stars3.setBounds(88, 214, 270, 14);
	panel.add(progressBar_Stars3);
	
	JProgressBar progressBar_Stars2 = new JProgressBar();
	progressBar_Stars2.setBounds(88, 239, 270, 14);
	panel.add(progressBar_Stars2);
	
	JProgressBar progressBar_Stars1 = new JProgressBar();
	progressBar_Stars1.setBounds(88, 264, 270, 14);
	panel.add(progressBar_Stars1);
	
	JLabel lblNewLabel = new JLabel("porcentaje");
	lblNewLabel.setBounds(10, 170, 245, 158);
	calificacion.add(lblNewLabel);
	
}

@Override
public void IniciarUsuario(Usuario usuario) {
	// TODO Auto-generated method stub
	
}

@Override
public void showEmpresa(DefaultComboBoxModel tipo) {
	// TODO Auto-generated method stub
	
}

@Override
public void showPersona(DefaultListModel model, DefaultComboBoxModel tipo) {
	// TODO Auto-generated method stub
	
}

@Override
public void showRegistro() {
	// TODO Auto-generated method stub
	
}

@Override
public void IniciarEmpresa(Empresa empresa) {
	// TODO Auto-generated method stub
	
}

@Override
public void IniciarPersona(RegistroPersona persona) {
	// TODO Auto-generated method stub
	
}

@Override
public void llenarPersona(DefaultComboBoxModel tipo) {
	// TODO Auto-generated method stub
	
}

@Override
public void llenarJuridica(DefaultComboBoxModel tipo) {
	// TODO Auto-generated method stub
	
}

@Override
public void agregarlista(DefaultListModel nuevo) {
	// TODO Auto-generated method stub
	
}

@Override
public void llenarDatosRegistro(DefaultListModel datos) {
	// TODO Auto-generated method stub
	
}

@Override
public void llenarcmbCalificar(DefaultComboBoxModel model) {
	// TODO Auto-generated method stub
	
}

@Override
public void mostrarVentanaEvidencia(String nombre, String pathArchivo) {
	// TODO Auto-generated method stub
	
}

@Override
public void datosencontrados(String genero, String nombre, String primero,
		String segundo) {
	// TODO Auto-generated method stub
	
}

@Override
public void actualizarestrella(int estrella, boolean estado) {
	// TODO Auto-generated method stub
	
}

@Override
public void mostrarresultados(DefaultListModel x) {
	// TODO Auto-generated method stub
	
}

@Override
public void actualizarInformacionEmpresa(Empresa mostrar) {
	// TODO Auto-generated method stub
	
}

@Override
public void actualizarInformacionPersona(RegistroPersona mostrar) {
	// TODO Auto-generated method stub
	
}

@Override
public void Icomentarios(Calificacion n, Usuario usuario) {
	// TODO Auto-generated method stub
	
}


@Override
public void llenardatos(Usuario u) {
	// TODO Auto-generated method stub
	
}


@Override
public void mostrarabusos(Date fechaDenuncia, String motivo) {
	// TODO Auto-generated method stub
	
}


@Override
public void CuentaEliminada() {
	// TODO Auto-generated method stub
	
}


@Override
public void EliminarNotas() {
	// TODO Auto-generated method stub
	
}
}