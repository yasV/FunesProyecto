package entidades;

public class Factory {
	protected String tipoCategoria;
	public Factory(String tipo) {
		tipoCategoria=tipo;
	}

	public Registro crearRegistro(){
		if (tipoCategoria.equalsIgnoreCase("Persona")){
			return new RegistroPersona();
		}
		else{
			return new Empresa();
		}
	}
}
