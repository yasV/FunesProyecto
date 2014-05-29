package aplicacion;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;



public class Sistema {
	//Todas las variables
	private String tipoBusqueda=null;
	private ArrayList<Usuario> listaUsuarios;
	private ArrayList vistas;
	
	
    public Sistema() {
		this(null);
		if(tipoBusqueda.equals("Persona Física")){
			busquedaPersona();
		}
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
	
//____________________________________________________________________________________________________________
	  //----------------------------------------------Funciones página de Consultar------------------------------------- 
	  //Rellena el comboBox con las maneras en las que se puede Buscar
	    public void busquedaPersona(){
	    	DefaultComboBoxModel tipo= modelo("Física");
	    	Iterator notifyViews = vistas.iterator();
	        while (notifyViews.hasNext()) {
	                ((Funciones) notifyViews.next()).llenarPersona(tipo);
	        }
	    	
	    }
	    
	    public void busquedaJuridica(){
	    	DefaultComboBoxModel tipo= modelo("Juridica");
	    	Iterator notifyViews = vistas.iterator();
	        while (notifyViews.hasNext()) {
	                ((Funciones) notifyViews.next()).llenarJuridica(tipo);
	        }
	    	
	    }
	    
	    //Este método se encargara de llenar el comboBox dependiendo del tipo de Busqueda a realizar
	    private DefaultComboBoxModel modelo(String tipo){
	    	DefaultComboBoxModel tipoBusq= new DefaultComboBoxModel();
	    	tipoBusq.addElement("-");
	    	if (tipo.equals("Física")){
	    		tipoBusq.addElement("Nombre");
	    		tipoBusq.addElement("Cédula");
	    		tipoBusq.addElement("Primer Apellido");
	    		tipoBusq.addElement("Segundo Apellido");
	    	}
	    	else{
	    		tipoBusq.addElement("Nombre");
	        	tipoBusq.addElement("Cédula Jurídica");
	    		
	    	}
	    	return tipoBusq;
	    }
	    
	    ///+++++++++++++++++++Busqueda de Personas++++++++++++++++
	    public void mostrarInfo(){
	    	
	    }

}
