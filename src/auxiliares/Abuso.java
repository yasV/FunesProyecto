package auxiliares;
import java.sql.Date;

import aplicacion.Usuario;

public class Abuso {
	//Atributos
	private Usuario usuario;
	private Date fechaDenuncia;
	private String motivo;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getFechaDenuncia() {
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
	public Abuso(Usuario usuario, Date fechaDenuncia, String motivo) {
		
		this.usuario = usuario;
		this.fechaDenuncia = fechaDenuncia;
		this.motivo = motivo;
	}

	
	

}
