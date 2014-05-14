package entidades;
import  auxiliares.Calificacion;
import java.util.*;
public abstract class Registro {
    protected ArrayList<Calificacion> Calificaciones=new ArrayList<Calificacion>();

	public ArrayList<Calificacion> getCalificacion() {
		return Calificaciones;
	}

	public void setCalificacion(ArrayList<Calificacion> calificacion) {
		Calificaciones = calificacion;
	}

	@Override
	public String toString() {
		return "Registro [Calificacion=" + Calificaciones + "]";
	}

	public Registro() {
		
	}
    
    
}

	