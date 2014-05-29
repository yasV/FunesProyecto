package aplicacion;

import grafico.Controlador;

public class Inicio {
	
	public static void main(String [] args){
		Sistema Model = new Sistema();
		
		Controlador control = new Controlador (Model); //Agrega controlador
		
		grafico.Usuario pusuario = new grafico.Usuario (Model,control);
		Model.addContactView(pusuario);
		
	}
}
