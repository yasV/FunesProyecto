package grafico;

import aplicacion.Sistema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
	private Sistema modelo;
	private Usuario view_Usuario;

	
	public Controlador(Sistema pmodel, Usuario u){
		modelo = pmodel;
		view_Usuario=u;
	}

	public Controlador(Sistema model, Administrador administrador) {
		// TODO Auto-generated constructor stub
	}

	public Controlador(Sistema model, VerUsuario verUsuario) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Aquí van las llamadas
		
		
	}
}
