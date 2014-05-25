package aplicacion;



public class Inicio {
	public static void main(String [] args){
		Sistema Model = new Sistema();
		
		grafico.Usuario pusuario = new grafico.Usuario (Model);
		Model.addContactView(pusuario);
		
	}
}
