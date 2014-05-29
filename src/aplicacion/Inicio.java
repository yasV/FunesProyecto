package aplicacion;

import grafico.Controlador;

public class Inicio {
	
	public static void main(String [] args){
		Sistema Model = new Sistema();
		Sistema.iniciar_sistema();
		Controlador control = new Controlador (Model); //Agrega controlador
		
		grafico.Usuario pusuario = new grafico.Usuario (Model,control);
		Model.addContactView(pusuario);

		grafico.Administrador admi = new grafico.Administrador(Model,control);
		Model.addContactView(admi);
	}
}
