package aplicacion;

import grafico.Controlador;



public class Inicio {
	public static void main (String []args){
		Sistema Model = new Sistema();
		Sistema.iniciar_sistema();
		Controlador control = new Controlador (Model); //Agrega controlador
		
		
		grafico.Login log = new grafico.Login(Model,control);
		Model.addContactView(log);
		
		
		grafico.Usuario pusuario = new grafico.Usuario (Model,control);
		Model.addContactView(pusuario);
		
		
		grafico.Administrador admi = new grafico.Administrador(Model,control);
		Model.addContactView(admi);
		
		grafico.Informacion infor = new grafico.Informacion(control);
		Model.addContactView(infor);
		
	
		
		
		
	}
}
