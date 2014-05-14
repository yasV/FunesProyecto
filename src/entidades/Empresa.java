package entidades;

import auxiliares.*;
public class  Empresa extends Registro {
	String categoria;
	String nombre;
	String cedulaJuridica;
	Direccion direccion;
	static float promedio;
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCedulaJuridica() {
		return cedulaJuridica;
	}
	public void setCedulaJuridica(String cedulaJuridica) {
		this.cedulaJuridica = cedulaJuridica;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public static float getPromedio() {
		return promedio;
	}
	public void setPromedio(float promedio) {
		this.promedio = promedio;
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
		setPromedio( valor/cantidad);
	}
	
	public Empresa(){
	//Constructor vacio para poder realizar el Factory	
	}
	
	public void ImEmpresa(String categoria, String nombre, String cedulaJuridica,
	//Método que sustituye al constructor original, despúes de crear la clase, debe de redireccionar aqu
			Direccion direccion) {
		this.categoria = categoria;
		this.nombre = nombre;
		this.cedulaJuridica = cedulaJuridica;
		this.direccion = direccion;
	}
	

	
	
}
