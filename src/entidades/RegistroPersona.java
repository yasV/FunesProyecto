package entidades;

import auxiliares.Calificacion;
import auxiliares.Persona;
public class RegistroPersona extends Registro {

	String Categorias;
	Persona Persona;
	
	public RegistroPersona() {
		// TODO Auto-generated constructor stub
	}
	
	

	public String getCategorias() {
		return Categorias;
	}



	public void setCategorias(String categorias) {
		Categorias = categorias;
	}



	public Persona getPersona() {
		return Persona;
	}



	public void setPersona(Persona persona) {
		Persona = persona;
	}



	public RegistroPersona(String Categorias,Persona Persona){
		setPersona(Persona);
		setCategorias(Categorias);
	}
	
	
	
	public void setCalificacion(Calificacion calificacion){
		Calificaciones.add(calificacion);
	}
		
	public void calcularpromedio(){
		int valor=0;
		int cantidad = Calificaciones.size();
		for (Calificacion promedio: Calificaciones){
			valor= valor + promedio.getCalificacion();
		}
	 Persona.setPromedio( valor/cantidad);
	}
	

}
