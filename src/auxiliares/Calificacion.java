package auxiliares;
import java.io.File;

import aplicacion.Usuario;

public class Calificacion {
	//Atributos
	private int calificacion;
	private Usuario usuario;
	private String demandado;
	private File evidencia;
	private String comentario;
	
	
	public int getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getDemandado() {
		return demandado;
	}
	public void setDemandado(String demandado) {
		this.demandado = demandado;
	}
	public File getEvidencia() {
		return evidencia;
	}
	public void setEvidencia(File evidencia) {
		this.evidencia = evidencia;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
	public Calificacion() {
		// TODO Auto-generated constructor stub
	}

}
