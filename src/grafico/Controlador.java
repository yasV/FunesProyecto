package grafico;

import aplicacion.Sistema;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {
	private Sistema modelo;
	private Usuario view_Usuario;

	
	
	public Controlador(Sistema p){
		modelo = p;
	}
	public void C_Usuario(Usuario u){
		view_Usuario = u;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		 Object source = evt.getSource();
		
//----------------------Acciones de  Usuario------------------------------------------------ 
		//++++++++++++++++++++++ Consultar +++++++++++++++++++++++++++++++++++++++++
		 if (source==view_Usuario.rdbtnPersonaFsica_1){
			    modelo.busquedaPersona();
		}
		 
		 if (source==view_Usuario.rdbtnPersonasJurdicas_1){
			    modelo.busquedaJuridica();
		}
		 
		 if(source == view_Usuario.getCmbTipoBusqueda()){
			 modelo.mostrarInfo();
		 }
	}
}
