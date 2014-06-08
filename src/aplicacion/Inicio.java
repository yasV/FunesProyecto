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
		
		
		
		
		grafico.Informacion infor = new grafico.Informacion(control);
		Model.addContactView(infor);
		
		//*
		grafico.VUsuario verusuario = new grafico.VUsuario(control);
		Model.addContactView(verusuario);
		
		
	
		
		
		
	}
}
