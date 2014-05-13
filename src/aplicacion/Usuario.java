package aplicacion;
import java.util.ArrayList;

import auxiliares.Abuso;

public class Usuario extends Administrador {
	//Atributos
	private int reportes;

	private ArrayList<Abuso> listaReportes= new ArrayList<Abuso>();
	private boolean privado;
	

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


	public Usuario(String nick,String contrase�a,String nombre,boolean estado) {
		super (nick,contrase�a,nombre);
		setPrivado(estado);
		
	}

}
