package aplicacion;

import java.util.ArrayList;
import java.util.Iterator;



public class Sistema {
	//Todas las variables
	private ArrayList<Usuario> listaUsuarios;
	private ArrayList vistas;
	
    public Sistema() {
		this(null);
	}

  public Sistema(Funciones vista) {
		 if (vistas != null) {
	            vistas.add(vista);
	        }
	}
	public void addContactView(Funciones view) {
        if (!vistas.contains(view)) {
            vistas.add(view);
        }
    }
    
    //remueve un nuevo view
    private void removeContactView(Funciones view) {
        vistas.remove(view);
    }
	
	

}
