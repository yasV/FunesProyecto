package auxiliares;
import java.sql.Date;

import aplicacion.Usuario;

public class Abuso {
	//Atributos
	private Usuario usuario;
	private java.util.Date fechaDenuncia;
	private String motivo;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public java.util.Date getFechaDenuncia() {
		return fechaDenuncia;
	}
	public void setFechaDenuncia(Date fechaDenuncia) {
		this.fechaDenuncia = fechaDenuncia;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Abuso(Usuario usuario, java.util.Date fecha, String motivo) {
		
		this.usuario = usuario;
		this.fechaDenuncia = fecha;
		this.motivo = motivo;
	}

	
	

}
