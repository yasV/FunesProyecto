package entidades;

import auxiliares.Calificacion;
import auxiliares.Persona;
public class RegistroPersona extends Registro {

	String Categorias;
	Persona Persona;
	
	public RegistroPersona(Persona p,String categoria) {
		this.Categorias=categoria;
		Persona = p;
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



	public  RegistroPersona(String Categorias,Persona Persona){
		setPersona(Persona);
		setCategorias(Categorias);
	}
	
	
	
	public RegistroPersona() {
		// TODO Auto-generated constructor stub
	}

	public void setCalificacion(Calificacion calificacion){
		Calificaciones.add(calificacion);
	}
		
	public void calcularpromedio(){
		double valor=0;
		int cantidad = Calificaciones.size();
		for (Calificacion promedio: Calificaciones){
			valor= valor + promedio.getCalificacion();
		}
		
		double x = (valor/cantidad);
	 Persona.setPromedio(x);
	}


	@Override
	public int compareTo(Object o) {
		RegistroPersona a = (RegistroPersona)o;
		if (this.Persona.getPrimerApellido().compareTo(a.getPersona().getSegundoApellido())==0){
			if (this.Persona.getSegundoApellido().compareTo(a.getPersona().getSegundoApellido())==0){
				if (this.Persona.getNombre().compareTo(a.getPersona().getNombre())==0){
					return this.getPersona().getCedula().compareTo(a.getPersona().getCedula());
				}
				else{
					return this.Persona.getNombre().compareTo(a.getPersona().getNombre());
				}
			}
			else{
				return this.Persona.getSegundoApellido().compareTo(a.getPersona().getSegundoApellido());
				}
			}
		else{
			return this.Persona.getPrimerApellido().compareTo(a.getPersona().getPrimerApellido());
		}
		
	}



}
