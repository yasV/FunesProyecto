package aplicacion;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import auxiliares.Calificacion;
import auxiliares.Direccion;
import auxiliares.Fecha;
import auxiliares.Persona;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import entidades.Empresa;
import entidades.Factory;
import entidades.Registro;
import entidades.RegistroPersona;



public class Sistema {
	//Todas las variables
	private String tipoBusqueda=null;
	private static ArrayList<Usuario> listaUsuarios;
	private static ArrayList<Usuario> bloqueados;
	private static ArrayList<Empresa> empresas;
	private static ArrayList <RegistroPersona> personas;
	static int cantidadUsuarios = 0;
	static int cantidadEmpresas=0;
	static int cantidadPersonas=0;
	private static Workbook workbook;
	private static Sheet sheet;
	private static Cell cell;
	private static ArrayList vistas=new ArrayList();
	private static Factory fabrica;
	public static Registro registro;
	public static DefaultComboBoxModel model = new DefaultComboBoxModel();
	private static DefaultListModel lista = new DefaultListModel();
	
	
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
    
    public static void iniciar_sistema(){
		//Función que inicializa las lista de usuario, personas físicas, personas jurídicas y usuarios bloqueados
			//*Inicializa de variables*//
		vistas.removeAll(vistas);
		listaUsuarios = new ArrayList<Usuario>(); 
		bloqueados = new ArrayList <Usuario>();
		empresas = new ArrayList <Empresa>();
		personas= new ArrayList<RegistroPersona>();
		
		///Lectura de archivo excel
		
	//* Importar datos del usuario*//	
		String cellData = new String();

        try{
        	/*Se crea un nuevo libro, se asigna a la hoja el valor 0 para comenzar con el usuario 
        	 * el valor 1 para las empresas y el valor 2 para las físicas
        	 * En los usuarios se asignan la cantidad de usuarios, se inica en la fila dos y despúes comienza a aumentar
        	 * Las columnas son fijas.Según un estado se decide si van a lista de los bloqueados o a la de los normales
        	 * */
        	
        
            workbook = Workbook.getWorkbook(new File("Datos.xls")); 
            sheet = workbook.getSheet(0);
            cell = sheet.getCell(1,0); //Columna Fila
            if (cell.getType()==CellType.NUMBER){
            
            	cantidadUsuarios = Integer.parseInt(cell.getContents());}
            int fila=2;
            for (int contador=0;contador<cantidadUsuarios;contador++ ){
            	boolean estado=false;
            	cell =sheet.getCell(3,fila); 
            	if (cell.getContents()=="true"){
            		estado = true;
            	}
            	String permitido = sheet.getCell(4,fila).getContents();
            	System.out.println(permitido);
            	String nick = sheet.getCell(0,fila).getContents();
            	String nombre=sheet.getCell(1,fila).getContents();
            	System.out.println("Este es el nombre"+nombre);
            	System.out.println("Este es el nick"+nick);
            	String contraseña = sheet.getCell(2,fila).getContents();
            	Usuario nuevo = new Usuario (nick,contraseña,nombre,estado);
            	if (permitido.equals("Bloqueado")){
            		bloqueados.add(nuevo);
            	}
            	else{
            		listaUsuarios.add(nuevo);
            	}
            	fila ++;
            }
            
            //* Lista de empresas
            sheet = workbook.getSheet(1);
            cell = sheet.getCell(1,0); //Columna Fila
            if (cell.getType()==CellType.NUMBER){
            	cantidadEmpresas = Integer.parseInt(cell.getContents());}
            fila=3;
            for (int i=0; i<cantidadEmpresas;i++){
            String pais = sheet.getCell(3,fila).getContents();
            String provincia = sheet.getCell(4,fila).getContents();		
            String canton = sheet.getCell(5,fila).getContents();
            String distrito = sheet.getCell(6,fila).getContents();
            String barrio = sheet.getCell(7,fila).getContents();
            
            Direccion dir_nueva= new Direccion(pais,provincia,canton,distrito);
            dir_nueva.setBarrio(barrio);
            
            int calificacion = Integer.parseInt(sheet.getCell(8,fila).getContents()); 
            String comentario = sheet.getCell(9,fila).getContents();
            File archivo = new File(sheet.getCell(10,fila).getContents());
            Usuario u = listaUsuarios.get(1);
            
            Calificacion cal_nueva = new Calificacion (calificacion,u,archivo,comentario);
            
            String categoria = sheet.getCell(2,fila).getContents();
            String nombre = sheet.getCell(0,fila).getContents();
            String cedula = sheet.getCell(1,fila).getContents();
            
            Empresa nueva = new Empresa (categoria,nombre,dir_nueva);
            nueva.setCalificacion(cal_nueva);
            empresas.add(nueva);
            fila ++;
            }
            
            //Datos de las personas físicas//
           
            sheet = workbook.getSheet(2);
            cell = sheet.getCell(1,0); //Columna Fila
            if (cell.getType()==CellType.NUMBER){
            	cantidadPersonas = Integer.parseInt(cell.getContents());}
            fila=3;
            for (int i=0; i<cantidadPersonas;i++){
            int Mes = Integer.parseInt(sheet.getCell(6,fila).getContents());
            int Dia = Integer.parseInt(sheet.getCell(7,fila).getContents());		
            int Año = Integer.parseInt(sheet.getCell(8,fila).getContents());
            
            Fecha fecha = new Fecha(Mes,Dia,Año);
          
            
            int calificacion = Integer.parseInt(sheet.getCell(11,fila).getContents()); 
            String comentario = sheet.getCell(12,fila).getContents();
            File archivo = new File(sheet.getCell(14,fila).getContents());
            Usuario u = listaUsuarios.get(0);
            
            Calificacion cal_nueva = new Calificacion (calificacion,u,archivo,comentario);
            
            String categoria = sheet.getCell(0,fila).getContents();
            String nombre = sheet.getCell(2,fila).getContents();
            String cedula = sheet.getCell(1,fila).getContents();
            String Papellido = sheet.getCell(3,fila).getContents();
            String Sapellido = sheet.getCell(4,fila).getContents();
            String género = sheet.getCell(5,fila).getContents();
            String lugar = sheet.getCell(9,fila).getContents();
            String puesto = sheet.getCell(10,fila).getContents();
            Persona persona = new Persona (cedula,nombre,Papellido,Sapellido,género,fecha,lugar,puesto); 
            RegistroPersona nueva = new RegistroPersona(categoria,persona);
            nueva.setCalificacion(cal_nueva);
            
            fila ++;
            personas.add(nueva);
           }
            workbook.close();
        }

        catch(Exception e){

            System.out.println("readExcel ->"+e);  }
  
		
	}
    
   //--------------------------------------------------Actualizar vistas--------------------------------------- 
    
    public void addContactView(Funciones view) {
        if (!vistas.contains(view)) {
            vistas.add(view);
        }
    }
    
    //remueve un nuevo view
    private void removeContactView(Funciones view) {
        vistas.remove(view);
    }
	public void showEmpresa(){
	 	Iterator notifyViews = vistas.iterator();
	   	//Carga el modelo del combox para mostrar los datos de la provincia
	 	llenarprovincias();
	 	while (notifyViews.hasNext()) {
	   		 
	   		 ((Funciones) notifyViews.next()).showEmpresa(model);
	}}
	
	public void showPersona(){
	 	//Carga el modelo del combox y la lista para mostrar en la pantalla de la persona
		listaCategoria();
	 	llenarmes();
		Iterator notifyViews = vistas.iterator();
	   	 while (notifyViews.hasNext()) {
	   		 
	   		 ((Funciones) notifyViews.next()).showPersona(lista,model);
	}}
	
	public void showCalifiEmpresa(Empresa empresa){
	 	Iterator notifyViews = vistas.iterator();
	   	 while (notifyViews.hasNext()) {
	   		 
	   		 ((Funciones) notifyViews.next()).IniciarEmpresa(empresa);
	
	}}
	
	public void showCalifiPersona(RegistroPersona persona){
	 	Iterator notifyViews = vistas.iterator();
	   	 while (notifyViews.hasNext()) {
	   		 
	   		 ((Funciones) notifyViews.next()).IniciarPersona(persona);
	
	}}
	
	public void Refreshlistregistro(String nueva){
	 	lista.addElement(nueva);
		Iterator notifyViews = vistas.iterator();
	   	 while (notifyViews.hasNext()) {
	   		 
	   		 ((Funciones) notifyViews.next()).agregarlista(lista);
	
	}}
   
	
//____________________________________________________________________________________________________________
	
	//---------------------------------------Funciones usuario----------------------------------------------------
	
	public void registro (String tipo){
    	fabrica = new Factory (tipo);
    	registro = fabrica.crearRegistro();
    }
    
    //Crear empresa
    public  Registro crearempresa(String nombre,String cedula,String categoria,Direccion dir){
    	registro=null;
    	if (nombre.isEmpty()|categoria.isEmpty()){
    		JOptionPane.showMessageDialog(null, "No puede haber ningún campo vacío", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
    		}
    	else {
    		registro = this.comparaRegistro(nombre, 0, categoria);
    		if (registro!=null){
    			JOptionPane.showMessageDialog(null, "Ya existe una persona juridíca con ese nombre en esa categoría", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
    		}
    		else{
    			Empresa nueva = new Empresa(categoria,nombre,dir);
    		if (!cedula.equals(" ")){
    		registro = buscarcedula(cedula, 0);
    		if (registro==null){
    			nueva.setCedulaJuridica(cedula);
    		}
    		else{
    			JOptionPane.showMessageDialog(null, "La cédula juridíca ya existe", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
    		}
    		return nueva;
    		}
    	}
    	}
    	return null;
    }
    
    public Direccion crearDireccion (String pais,String provincia,String canton,String distrito,String barrio){
    	if (pais.isEmpty()||provincia.isEmpty()||canton.isEmpty()||distrito.isEmpty()){
    		JOptionPane.showMessageDialog(null, "No puede haber ningún campo vacío", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
    	}
    	else{
    	Direccion nueva = new Direccion(pais,provincia,canton,distrito);
    	if (!barrio.equals(" ")){
    		nueva.setBarrio(barrio);
    	}
    	return nueva;}
    
    	return null;
    }
    //Crear persona
    public Registro registrarpersona(Persona persona,String categoria){
    	registro = this.comparaRegistro(persona.getNombre(), 1, categoria);
    	if (registro.equals(null)){
    	return  new RegistroPersona(categoria,persona);}
    	else{
    		JOptionPane.showMessageDialog(null, "Puede ser que la persona ya exista", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
    	}
    	return null;
    }
    public Fecha crearfecha(String dia,String mespalabra,String año){
       if (dia.isEmpty()||mespalabra.isEmpty()||año.isEmpty()){
    	   JOptionPane.showMessageDialog(null, "No puede haber ningún campo vacío", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
       }
       else{
    	try{   
    		int mes =0;
    		if (mespalabra.equals("Enero")){
    			mes =1;
    		}
    		if (mespalabra.equals("Febrero")){
    			mes=2;
    		}
    		if (mespalabra.equals("Marzo")){
    			mes=3;
    		}
    		if (mespalabra.equals("Abril")){
    			mes=4;
    		}
    		if(mespalabra.equals("Mayo")){
    			mes=5;
    		}
    		if (mespalabra.equals("Junio")){
    			mes=6;
    		}
    		if (mespalabra.equals("Julio")){
    			mes=7;
    		}
    		if (mespalabra.equals("Agosto")){
    			mes=8;
    		}
    		if(mespalabra.equals("Septiembre")){
    			mes=9;
    		}
    		if (mespalabra.equals("Octubre")){
    			mes=10;
    		}
    		if(mespalabra.equals("Noviembre")){
    			mes=11;
    		}
    		if(mespalabra.equals("Diciembre")){
    			mes=12;
    		}
    		
    		return new Fecha (mes,Integer.parseInt(dia),Integer.parseInt(año));}
    	catch (Exception e){
    		JOptionPane.showMessageDialog(null, "Ingrese un número válido", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
    	}
    }
       return null;
    }
    public Persona crearpersona(String nombre,String papellido,String sapellido,String genero,String cedula,String lugar,String cargo, Fecha fecha){
    	
    	return new Persona (cedula,nombre,papellido,sapellido,genero,fecha,lugar,cargo);
    }
    
   public void llenarmes(){
	   model.removeAllElements();
	   model.addElement("-Seleccione un mes");
	   model.addElement("Enero");
	   model.addElement("Febrero");
	   model.addElement("Marzo");
	   model.addElement("Abril");
	   model.addElement("Mayo");
	   model.addElement("Junio");
	   model.addElement("Julio");
	   model.addElement("Agosto");
	   model.addElement("Septiembre");
	   model.addElement("Octubre");
	   model.addElement("Noviembre");
	   model.addElement("Diciembre");
	   
   }
 public void llenarprovincias(){
    	model.removeAllElements();
    	model.addElement("-Seleccione una provincia");
    	model.addElement("Alajuela");
    	model.addElement("Cartago");
    	model.addElement("Guanacaste");
    	model.addElement("Heredia");
    	model.addElement("Limón");
    	model.addElement("Puntarenas");
    	model.addElement("San José");
    	
    }
    
    public void listaCategoria(){
    	for (RegistroPersona u : personas){
    		lista.addElement(u.getCategorias());
    	}
    }
    
    public Registro buscarNombre(String nombre,int lista){
    	/*Recibe un nombre y un valor para saber en cuál lista debe de buscar.
    	 * Si el valor ingresado es 0, buscará en la lista de empresas y si es uno en la personas
    	 * Realiza un recorrido por la lista, obtiene el campo nombre de cada objeto. Devuelve la variable si la encuentra y termina el ciclo
    	 * Si no esta, devuelve nulo
    	 * */
    	if (lista == 0){
    		for (Empresa u : empresas){
    			if (u.getNombre().equals(nombre)){
    				return u;
    			}
    		}
    	}
    	
    	if (lista == 1){
    		for (RegistroPersona u : personas){
    			if (u.getPersona().getNombre().equals(nombre)){
    				return u;
    			}
    		}
    	}
    	return null;
    }
    
    public Registro buscarcedula (String cedula,int lista){
     	/*Recibe una variable cédula y un valor para saber en cuál lista debe de buscar.
    	 * Si el valor ingresado es 0, buscará en la lista de empresas y si es uno en la personas
    	 * Realiza un recorrido por la lista, obtiene el campo cédula de cada objeto. Devuelve la variable si la encuentra y termina el ciclo
    	 * Si no esta, devuelve nulo
    	 * */
    	if (lista == 0){
    		for (Empresa u : empresas){
    			if (u.getCedulaJuridica().equals(cedula)){
    				return u;
    			}
    		}
    	}
    	
    	if (lista == 1){
    		for (RegistroPersona u : personas){
    			if (u.getPersona().getCedula().equals(cedula)){
    				return u;
    			}
    		}
    	}
    	return null;
    }
    
    public Registro comparaRegistro(String nombre,int lista,String categoria){
    	/*Recibe un nombre,una categoría y un valor para saber en cuál lista debe de buscar.
    	 * Si el valor ingresado es 0, buscará en la lista de empresas y si es uno en la personas
    	 * Realiza un recorrido por la lista, obtiene el campo nombre y categoría de cada objeto. Devuelve la variable si  encuentra concidencia en ambos campos y termina el ciclo
    	 * Si no esta, devuelve nulo
    	 * */
    	if (lista == 0){
    		for (Empresa u : empresas){
    			if (u.getNombre().equals(nombre) && u.getCategoria().equals(categoria)){
    				return u;
    			}
    		}
    	}
    	
    	if (lista == 1){
    		for (RegistroPersona u : personas){
    			if (u.getPersona().getNombre().equals(nombre)&& u.getPersona().getCedula().equals(categoria)){
    				return u;
    			}
    		}
    	}
    	return null;
    }
    
    public boolean buscarcategoria (String categoria){
      
  /*Recibe un nombre y un valor para saber en cuál lista debe de buscar.
        * Realiza un recorrido por la lista, obtiene el campo categoría de cada objeto. Devuelve true si la encuentra y termina el ciclo
        	* Si no esta, devuelve false
         * */
     
        	
        	
        		for (RegistroPersona u : personas){
        			if (u.getCategorias().equals(categoria)){
        				return true;
        			}
        		}
        	
        	return false;
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
