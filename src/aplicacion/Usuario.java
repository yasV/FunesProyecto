package aplicacion;
import java.util.ArrayList;

import auxiliares.Abuso;

public class Usuario extends Administrador {
	//Atributos
	private int reportes;
	private ArrayList<Abuso> listaReportes= new ArrayList<Abuso>();
	private boolean privado;
	private int tiempobloqueo = 3;
	private int vecesbloqueado=0;
	
	
	
	public int getTiempobloqueo() {
		return tiempobloqueo;
	}
	public void setTiempobloqueo(int tiempobloqueo) {
		this.tiempobloqueo = tiempobloqueo;
	}
	public int getVecesbloqueado() {
		return vecesbloqueado;
	}
	public void setVecesbloqueado(int vecesbloqueado) {
		this.vecesbloqueado = vecesbloqueado;
	}


	

	
	public int getReportes() {
		return reportes;
	}
	public void setReportes(int reportes) {
		this.reportes = reportes;
	}
	public ArrayList<Abuso> getListaReportes() {
		return listaReportes;
	}
	public void setListaReportes(Abuso abuso) {
		listaReportes.add(abuso);
	}
	
	public boolean isPrivado() {
		return privado;
	}
	public void setPrivado(boolean privado) {
		this.privado = privado;
	}


	public Usuario(String nick,String contraseña,String nombre,boolean estado) {
		super (nick,contraseña,nombre);
		setPrivado(estado);
		
	}

}
