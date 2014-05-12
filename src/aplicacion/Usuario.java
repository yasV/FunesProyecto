package aplicacion;
import java.util.ArrayList;
import auxiliares.Abuso;

public class Usuario extends Administrador {
	//Atributos
	private int reportes;
	private ArrayList<Abuso> listaReportes;
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
	public void setListaReportes(ArrayList<Abuso> listaReportes) {
		this.listaReportes = listaReportes;
	}
	public boolean isPrivado() {
		return privado;
	}
	public void setPrivado(boolean privado) {
		this.privado = privado;
	}


	public Usuario() {
		// TODO Auto-generated constructor stub
	}

}
