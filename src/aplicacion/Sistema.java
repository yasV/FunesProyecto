package aplicacion;


import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.csvreader.CsvReader;

import auxiliares.Abuso;
import auxiliares.Calificacion;
import auxiliares.Direccion;
import auxiliares.Fecha;
import auxiliares.Persona;
import entidades.Empresa;
import entidades.Factory;
import entidades.Registro;
import entidades.RegistroPersona;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;

public class Sistema {
	//Atributos
	private static Usuario usuario; //Variable para manejar el usuario con el que se esta trabajando
	private static ArrayList<Usuario> listaUsuarios;
	private static ArrayList<Usuario> bloqueados;
	private static ArrayList<Empresa> empresas;
	private static ArrayList <RegistroPersona> personas;
	private static ArrayList <Integer>estrellas = new ArrayList();
	static int cantidadUsuarios = 0;
	static int cantidadEmpresas=0;
	static int cantidadPersonas=0;
	private static Workbook workbook;
	private static Sheet sheet;
	private static Cell cell;
	private static ArrayList vistas=new ArrayList();
	private static Factory fabrica;
	public static Registro registro;
	public static DefaultComboBoxModel<String> model = new DefaultComboBoxModel();
	private static DefaultListModel lista = new DefaultListModel();
	private static boolean nuevo = false;
	private static ArrayList<Empresa> empresasbuscadas = new ArrayList<Empresa>();
	private static ArrayList <RegistroPersona> personasbuscadas = new ArrayList<RegistroPersona>();
	private ArrayList <Calificacion> calificacion = new ArrayList<Calificacion>();
	int contador = 0;
	
	public static void iniciar_sistema(){
		//Funci�n que inicializa las lista de usuario, personas f�sicas, personas jur�dicas y usuarios bloqueados
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
        	 * el valor 1 para las empresas y el valor 2 para las f�sicas
        	 * En los usuarios se asignan la cantidad de usuarios, se inica en la fila dos y desp�es comienza a aumentar
        	 * Las columnas son fijas.Seg�n un estado se decide si van a lista de los bloqueados o a la de los normales
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
            	String contrase�a = sheet.getCell(2,fila).getContents();
            	Usuario nuevo = new Usuario (nick,contrase�a,nombre,estado);
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
            
            //Datos de las personas f�sicas//
           
            sheet = workbook.getSheet(2);
            cell = sheet.getCell(1,0); //Columna Fila
            if (cell.getType()==CellType.NUMBER){
            	cantidadPersonas = Integer.parseInt(cell.getContents());}
            fila=3;
            for (int i=0; i<cantidadPersonas;i++){
            int Mes = Integer.parseInt(sheet.getCell(6,fila).getContents());
            int Dia = Integer.parseInt(sheet.getCell(7,fila).getContents());		
            int A�o = Integer.parseInt(sheet.getCell(8,fila).getContents());
            
            Fecha fecha = new Fecha(Mes,Dia,A�o);
          
            
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
            String g�nero = sheet.getCell(5,fila).getContents();
            String lugar = sheet.getCell(9,fila).getContents();
            String puesto = sheet.getCell(10,fila).getContents();
            Persona persona = new Persona (cedula,nombre,Papellido,Sapellido,g�nero,fecha,lugar,puesto); 
            RegistroPersona nueva = new RegistroPersona(categoria,persona);
            nueva.setCalificacion(cal_nueva);
            
            fila ++;
            personas.add(nueva);
           }
            workbook.close();
        }

        catch(Exception e){
            System.out.println("readExcel ->"+e); 
        }
	}

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
        System.out.println("ESte es el tama�o de las listas"+vistas.size());
    }
    
    //remueve un nuevo view
    private void removeContactView(Funciones view) {
        vistas.remove(view);
    }
    
 //--------------------------Funciones para actualizar las vistas------------------------------------
    public void showUsuario (){
    	Iterator notifyViews = vistas.iterator();
    	while (notifyViews.hasNext()) {
    		((Funciones) notifyViews.next()).IniciarUsuario(usuario);
    	}	
    }
    
    public void showRegistro(){
    	Iterator notifyViews = vistas.iterator();
	   	 while (notifyViews.hasNext()) {
	   		 ((Funciones) notifyViews.next()).showRegistro();
	    }
	}
    
	public void showEmpresa(){
	 	Iterator notifyViews = vistas.iterator();
	   	//Carga el modelo del combox para mostrar los datos de la provincia
	 	llenarprovincias();
	 	while (notifyViews.hasNext()) {
	   		 ((Funciones) notifyViews.next()).showEmpresa(model);
	   	}
	}
	
	public void showPersona(){
	 	//Carga el modelo del combox y la lista para mostrar en la pantalla de la persona
		listaCategoria();
	 	llenarmes();
		Iterator notifyViews = vistas.iterator();
	   	while (notifyViews.hasNext()) {
	   		 ((Funciones) notifyViews.next()).showPersona(lista,model);
	   	}
	}
	
	public void showCalifiEmpresa(Empresa empresa){
	 	Iterator notifyViews = vistas.iterator();
	   	 while (notifyViews.hasNext()) {
	   		 ((Funciones) notifyViews.next()).IniciarEmpresa(empresa);
	   	}
	}
	
	public void showCalifiPersona(RegistroPersona persona){
	 	Iterator notifyViews = vistas.iterator();
	   	 while (notifyViews.hasNext()) {
	   		 ((Funciones) notifyViews.next()).IniciarPersona(persona);
	   	}
	}
	
	public void Refreshlistregistro(String nueva){

	 	lista.addElement(nueva);
		Iterator notifyViews = vistas.iterator();
	   	 while (notifyViews.hasNext()) {
	   		 ((Funciones) notifyViews.next()).agregarlista(lista);
	   	}
	}
	private void llenarcampos(String genero, String nombre, String primero,
			String segundo) {
    	//Si la el n�mero de c�dula ingresado se encuentra en el sistema. Llama para actualizar los datos
		Iterator notifyViews = vistas.iterator();
	   	 while (notifyViews.hasNext()) {
	   		 ((Funciones) notifyViews.next()).datosencontrados(genero, nombre, primero, segundo);
	   	}
	}

//________________________________________________________________________________________________________   
//----------------------------------------------Funciones para la l�gica-------------------------------------   
   
    //*******************************Login*****************************************
    public void iniciarSesion(String nick,String password){
    	for (int i=0;i<10;i++){
    		estrellas.add(i,0);
    	}
    	
    	///variable para controlar 
    	boolean control=false;
    	for (Usuario u :listaUsuarios ){
    	//Recorre toda la lista comparando que nombre y contrase�a sean exactamente iguales. Si encuentra concidencia. Muestra un mensaje de error
    		if (u.getNick().equals(nick)&&u.getPassword().equals(password)){
    			usuario = u;
    			showUsuario();
    			control=true; //Cambia el valor de control
    			break;//Rompe el ciclo
    		}
    	}
    	if (!control){ //Si control no cambia, quiere decir que hay un error, asi que mostrara el mensaje
    		JOptionPane.showMessageDialog(null, "No se encuentra en el sistema o alg�n dato esta err�neo", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
    	}
     }
    
    public void Registrarse (String nombre,String nick,String contrase�a,String privacidad){
    	if (nombre.isEmpty()||nick.isEmpty()||contrase�a.isEmpty()||privacidad.isEmpty()){
    		JOptionPane.showMessageDialog(null, "Por favor, aseg�rese que no qued� ning�n campo vac�o", "Campos vac�os", JOptionPane.ERROR_MESSAGE);
    	}
    	else{
    		boolean control = false;
    		for (Usuario u:listaUsuarios){
    			if (u.getNick().equals(nick)){
    				JOptionPane.showMessageDialog(null, "El nick no se encuentra disponible", "Campos vac�os", JOptionPane.ERROR_MESSAGE);
    				control = true;
    			}}
    		if (!control){
    			boolean estado = false;
    			if (privacidad.equals("Privado")){
    				estado=true;
    			}
    			usuario =new Usuario(nick,contrase�a,nombre,estado);
    			listaUsuarios.add(usuario);
    			JOptionPane.showMessageDialog(null, "Usuario creado con �xito", "Campos vac�os", JOptionPane.ERROR_MESSAGE);
    			showUsuario();
    		}
    		}
    	}
    
   //********************************Usuario************************************* 
    public void registro (String tipo){
    	fabrica = new Factory (tipo);
    	registro = fabrica.crearRegistro();
    }
    
    //Crear empresa
    public  Registro crearempresa(String nombre,String cedula,String categoria,Direccion dir){
    	registro=null;
    	if (nombre.isEmpty()|categoria.isEmpty()){
    		JOptionPane.showMessageDialog(null, "No puede haber ning�n campo vac�o", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
    		}
    	else {
    		registro = this.comparaRegistro(nombre, 0, categoria);
    		if (registro!=null){
    			JOptionPane.showMessageDialog(null, "Ya existe una persona jurid�ca con ese nombre en esa categor�a", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
    		}
    		else{
    			Empresa nueva = new Empresa(categoria,nombre,dir);
    			if (!cedula.equals(" ")){
    				registro = buscarcedula(cedula, 0,false);
    				if (registro==null){
    					nueva.setCedulaJuridica(cedula);
    					nuevo =true;
    				}
    				else{
    					JOptionPane.showMessageDialog(null, "La c�dula jurid�ca ya existe", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
    				}
    				return nueva;
    			}
    		}
    	}
    	return null;
    }
    
    public Direccion crearDireccion (String pais,String provincia,String canton,String distrito,String barrio){
    	if (pais.isEmpty()||provincia.isEmpty()||canton.isEmpty()||distrito.isEmpty()){
    		JOptionPane.showMessageDialog(null, "No puede haber ning�n campo vac�o", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
    	}
    	else{
    		Direccion nueva = new Direccion(pais,provincia,canton,distrito);
    		if (!barrio.equals(" ")){
    			nueva.setBarrio(barrio);
    		}
    		return nueva;
    	}
    	return null;
    }
    
    //Crear persona
    public Registro registrarpersona(Persona persona,String categoria){
    	registro = this.comparaRegistro(persona.getNombre(), 1, categoria);
    	if (registro.equals(null)){
    		return  new RegistroPersona(persona,categoria);
    	}
    	else{
    		JOptionPane.showMessageDialog(null, "Puede ser que la persona ya exista", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
    	}
    	return null;
    }
    
    public Fecha crearfecha(String dia,String mespalabra,String a�o){
       if (dia.isEmpty()||mespalabra.isEmpty()||a�o.isEmpty()){
    	   JOptionPane.showMessageDialog(null, "No puede haber ning�n campo vac�o", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
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
    		   return new Fecha (mes,Integer.parseInt(dia),Integer.parseInt(a�o));
    	   }
    	   catch (Exception e){
    		   JOptionPane.showMessageDialog(null, "Ingrese un n�mero v�lido", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
    	   }
       }
       return null;
    }
    
    public Persona crearpersona(String nombre,String papellido,String sapellido,String genero,String cedula,String lugar,String cargo, Fecha fecha){
    	
    	return new Persona (cedula,nombre,papellido,sapellido,genero,fecha,lugar,cargo);
    }
    
    public void buscarenregistro (String cedula){
        try {
	        int contador = Integer.parseInt(cedula);
	        CsvReader padron = new CsvReader("Padron.csv");
	        	while (padron.readRecord() ){
	        		if (contador==0){
	        			JOptionPane.showMessageDialog(null, "El n�mero de c�dula no existe", "Datos no encontrados", JOptionPane.ERROR_MESSAGE);
	        			break;
	        		}
	        		else{
	        			if (padron.get(0).equals(cedula)){
	        				String nombre = padron.get(2);
	        				String primero = padron.get(3);
	        				String segundo = padron.get(4);
	        				String genero = padron.get(1);
	        				llenarcampos(genero,nombre,primero,segundo);
	        				break;
	        			}
	        		}
	        		contador --;
	        	}
	        } 
        catch (FileNotFoundException e) {
        	e.printStackTrace();
        } 
        catch (IOException e) {
        	e.printStackTrace();
	    }
    }
    

	public void llenarmes(){
    	//Elimina todos los elementos del combo box y introduce los datos correctos
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
    	//Elimina todos los elementos del combo box y introduce los datos correctos
    	model.removeAllElements();
    	model.addElement("-Seleccione una provincia");
    	model.addElement("Alajuela");
    	model.addElement("Cartago");
    	model.addElement("Guanacaste");
    	model.addElement("Heredia");
    	model.addElement("Lim�n");
    	model.addElement("Puntarenas");
    	model.addElement("San Jos�");
    }
    
    public void listaCategoria(){
    	for (RegistroPersona u : personas){
    		lista.addElement(u.getCategorias());
    	}
    }
    
    public Registro comparaRegistro(String nombre,int lista,String categoria){
    	/*Recibe un nombre,una categor�a y un valor para saber en cu�l lista debe de buscar.
    	 * Si el valor ingresado es 0, buscar� en la lista de empresas y si es uno en la personas
    	 * Realiza un recorrido por la lista, obtiene el campo nombre y categor�a de cada objeto. Devuelve la variable si  encuentra concidencia en ambos campos y termina el ciclo
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
    
    public boolean buscarcategoria (String categoria,int lista, boolean multitud){
      /*Recibe un nombre y un valor para saber en cu�l lista debe de buscar.
        * Realiza un recorrido por la lista, obtiene el campo categor�a de cada objeto. Devuelve true si la encuentra y termina el ciclo
       	* Si no esta, devuelve false
         * */
    
    	
    	if (lista==1){
    		personasbuscadas.clear();
    		for (RegistroPersona u : personas){
        		if (u.getCategorias().equalsIgnoreCase(categoria)){
        			if (multitud){
        				personasbuscadas.add(u);
        			}
        			else{
        			return true;
        			}
            	}
            }
    		
    	}
    	if (lista==0){
    		empresasbuscadas.clear();
    		for (Empresa e : empresas){
    			if (e.getCategoria().equals(categoria)){
    				if (multitud){
    					empresasbuscadas.add(e);
    				}
    				else{
    					return true;
    				}
    				
    			}
    		}
    	}
    	
        return false;
    }

    
//____________________________________________________________________________________________________________
  //----------------------------------------------Funciones p�gina de Consultar------------------------------------- 
  //Rellena el comboBox con las maneras en las que se puede Buscar
    public void busquedaPersona(){
    	model.removeAllElements();
    	model.addElement("Fisico");
    	DefaultComboBoxModel tipo= modelo("F�sica");
    	model = modelo ("F�sica");
    	Iterator notifyViews = vistas.iterator();
        while (notifyViews.hasNext()) {
                ((Funciones) notifyViews.next()).llenarPersona(model);
        }
        while (notifyViews.hasNext()) {
            ((Funciones) notifyViews.next()).llenarPersona(model);
        }
    }
    
    
    public void busquedaJuridica(){
    	model.removeAllElements();
    	model.addElement("Jur�dica");
    	DefaultComboBoxModel tipo= modelo("Jur�dica");
    	model = modelo("Jurid�ca");
    	Iterator notifyViews = vistas.iterator();
    	while (notifyViews.hasNext()) {
            ((Funciones) notifyViews.next()).llenarPersona(tipo);
        }
        while (notifyViews.hasNext()) {
                ((Funciones) notifyViews.next()).llenarJuridica(model);
        }
    	
    }
    //Este m�todo se encargara de llenar el comboBox dependiendo del tipo de Busqueda a realizar
    private DefaultComboBoxModel modelo(String tipo){
    	DefaultComboBoxModel tipoBusq= new DefaultComboBoxModel();
    	tipoBusq.addElement("-");
    	if (tipo.equals("F�sica")){
    		tipoBusq.addElement("Nombre");
    		tipoBusq.addElement("C�dula");
    		tipoBusq.addElement("Primer Apellido");
    		tipoBusq.addElement("Segundo Apellido");
    		tipoBusq.addElement("Categor�a");
    	}
    	else{
    		tipoBusq.addElement("Nombre");
        	tipoBusq.addElement("C�dula Jur�dica");
        	tipoBusq.addElement("Categor�a");
    		
    	}
    	return tipoBusq;

    }
    
    ///Llena el comboBox de la pantalla de calificar dependiendo de la opci�n seleccionada
    public void busquedaCalificar(int opcion){
    	model.removeAllElements();
    	model.addElement("--");
    	if(opcion==0){
    		for(Empresa u: empresas){
    			model.addElement(u.getNombre());
    		}
    	}
    	else{
    		for(RegistroPersona u:personas){
    			model.addElement(u.getPersona().getNombre()+u.getPersona().getPrimerApellido()+u.getPersona().getSegundoApellido());
    		}
    	}
    	Iterator notifyViews = vistas.iterator();
        while (notifyViews.hasNext()) {
                ((Funciones) notifyViews.next()).llenarcmbCalificar(model);
        }
    	
    }
    
    //Abre la ventana para elegir un archivo a cargar como evidencia
    public void cargarEvidencia(){
    	String pathArchivo=null; //Obtiene path del archivo
        String nombre=null;
    	JFileChooser elegir = new JFileChooser();
        int opcion = elegir.showOpenDialog(elegir);
        //Si presionamos el boton ABRIR en pathArchivo obtenemos el path del archivo
        if (opcion == JFileChooser.APPROVE_OPTION) {
            pathArchivo = elegir.getSelectedFile().getPath(); //Obtiene path del archivo
            nombre = elegir.getSelectedFile().getName(); //obtiene nombre del archivo
            System.out.println("x");
           
        Iterator notifyViews = vistas.iterator();
        while (notifyViews.hasNext()) {
                ((Funciones) notifyViews.next()).mostrarVentanaEvidencia(nombre,pathArchivo);
        }
    }}
    
    //Guarda la calificaci�n
    public void guardarCalificacion(Registro agregar,int tipo,String demandado,String review,String evidencia,String demandante,String nombre){
    	//Si es una persona f�sica
    	if (agregar==null || demandado.isEmpty()||review.isEmpty()||evidencia.isEmpty()||demandante.isEmpty()||nombre.isEmpty()){
    		JOptionPane.showMessageDialog(null, "No puede haber ning�n campo v�cio y debe de subir alg�n documento para realizar la calificaci�n", "Formulario incompleto", JOptionPane.ERROR_MESSAGE);
    	}
    	else{
    	int calificacion=estrellas.indexOf(1)+1;
    	File evidenc=new File(evidencia);
    	Calificacion cal_nueva = new Calificacion (calificacion,usuario,evidenc,review);
    	
    
    	if(tipo==1){
    				//pasamos la evidencia de String a un File
    		if (nuevo){
    			personas.add((RegistroPersona) agregar);
    			nuevo = false;
    		}
    				for(RegistroPersona u:personas){	//Buscamos el demandado para asignarle la calificaci�n
    	    			if((u.getPersona().getNombre()+u.getPersona().getPrimerApellido()+u.getPersona().getSegundoApellido()).equals(demandado)){
    	    				u.setCalificacion(cal_nueva);
    	    	            u.calcularpromedio();
    	    	            System.out.print(calificacion);
    	    	            Ftp.uploadFileByFTP(evidencia, nombre);
    	    	        
    	    	        }
    	    		}
    			}
    	
    	else{
    			//pasamos la evidencia de String a un File
    		if (nuevo){
    		Empresa n = (Empresa) agregar;
    		System.out.println(n.getNombre());
    		empresas.add((Empresa) agregar);
    		nuevo = false;
    		
    		}
    		for(Empresa u:empresas){	//Buscamos el demandado para asignarle la calificaci�n
    	    	System.out.println(u.getNombre());	
    			if(u.getNombre().equals(demandado)){
    	    				u.setCalificacion(cal_nueva);
    	    	            u.calcularpromedio();
    	    	            System.out.println(u.getNombre());
    	    	            System.out.print(calificacion);
    	    	            Ftp.uploadFileByFTP(evidencia, nombre);
    	    			}
    	    		}
    		
    			}
    	}
    	}
   
    
    	
    public void marcarEstrellas(int indice){
    	//Funci�n que marca las estrellas y las ponen de color
    	Iterator notifyViews = vistas.iterator();
    	int estado = estrellas.get(indice);
    	if (estado==0 ){
    		//Esto es por si aumento la cantidad de estrellas cuando ya he marcado una estrella
    		//para que no me afecte el momento de calificar
    		for(int i=0;i<indice;i++){
    			estrellas.set(i,0);
    		}
    		estrellas.set(indice, 1);
    		 while (notifyViews.hasNext()) {
    	   		 ((Funciones) notifyViews.next()).actualizarestrella(indice, true); 
    	   	}
    	}
    	else{
    		estrellas.set(indice, 0);
    		while (notifyViews.hasNext()) {
    			((Funciones) notifyViews.next()).actualizarestrella(indice, false);
    			}
    	}	
    }
    
    ///+++++++++++++++++++Busqueda de Personas++++++++++++++++
    private  DefaultListModel crearlista(int opc){
    	DefaultListModel Datos= new DefaultListModel();
    	Datos.removeAllElements();
    	
    	if(opc==0){
    		for (Empresa u : empresas){
    			Datos.addElement(u.getNombre());
    		}
    	}
    	if(opc==1){
    		for (RegistroPersona nombre: personas){
    			Datos.addElement(nombre.getPersona().getNombre());
    		}
    	}
    	return Datos;
    }	
    
 	
       
    public Registro buscarNombre(String nombre,int lista,boolean multitud){
    	/*Recibe un nombre y un valor para saber en cu�l lista debe de buscar.
    	 * Si el valor ingresado es 0, buscar� en la lista de empresas y si es uno en la personas
    	 * Realiza un recorrido por la lista, obtiene el campo nombre de cada objeto. Devuelve la variable si la encuentra y termina el ciclo
    	 * Si no esta, devuelve nulo
    	 * */
    	if (lista == 0){
    		
    		empresasbuscadas.clear();
    		for (Empresa u : empresas){
    			if (u.getNombre().equalsIgnoreCase(nombre)){
    			if (multitud){
    				empresasbuscadas.add(u);
    			}
    			else{
    				
        				return u;
        			}
    			}
    			
    		}
    	}
    	
    	if (lista == 1){
    		 personasbuscadas.clear();
    		for (RegistroPersona u : personas){
    			if (u.getPersona().getNombre().equalsIgnoreCase(nombre)){
    			if (multitud){
    				personasbuscadas.add(u);
    			}
    			else{
    				return u;
    			}
    			
    				
    			}
    			
    		}
    	
    		//mostrarInfo(1);
    	}
    	
    	return null;
    }
    
    public Registro buscarcedula (String cedula,int lista,boolean multitud){
     	/*Recibe una variable c�dula y un valor para saber en cu�l lista debe de buscar.
    	 * Si el valor ingresado es 0, buscar� en la lista de empresas y si es uno en la personas
    	 * Realiza un recorrido por la lista, obtiene el campo c�dula de cada objeto. Devuelve la variable si la encuentra y termina el ciclo
    	 * Si no esta, devuelve nulo
    	 * */
    	
    	if (lista == 0){
    		empresasbuscadas.clear();
    		for (Empresa u : empresas){
    			if (u.getCedulaJuridica()!=null){
    			if (u.getCedulaJuridica().equals(cedula)){
    				if (multitud){
    					empresasbuscadas.add(u);
    				}
    				else{
    				return u;}
    			}
    			}
    		}
    	}
    	
    	if (lista == 1){
    		personasbuscadas.clear();
    		for (RegistroPersona u : personas){
    			if (u.getPersona().getCedula().equals(cedula)){
    				if (multitud){
    					personasbuscadas.add(u);
    				}
    				else{
    				return u;
    				}
    			}
    		}
    	
    	}
    	return null;
    }
    
    public Registro buscarApellido (String apellido,int lista,boolean multitud){
     	/*Recibe una variable c�dula y un valor para saber en cu�l lista debe de buscar.
    	 * Si el valor ingresado es 1 buscar� el primer apellido y si es 2 el segundo
    	 * Realiza un recorrido por la lista, obtiene el campo apellido de cada objeto. Devuelve la variable si la encuentra y termina el ciclo
    	 * Si no esta, devuelve nulo
    	 * �*/
    
    	personasbuscadas.clear();
    	if (lista == 1){
    		for (RegistroPersona u : personas){
    			if (u.getPersona().getPrimerApellido().equalsIgnoreCase(apellido)){
    				if (multitud){
    					personasbuscadas.add(u);
    				}
    				else{
    				return u;}
    			}
    		}
    	}
    	
    	if (lista == 2){
    		for (RegistroPersona u : personas){
    			if (u.getPersona().getSegundoApellido().equalsIgnoreCase(apellido)){
    				if(multitud){
    					personasbuscadas.add(u);
    				}
    				else{
    				return u;}
    			}
    		}
    	}
    	return null;
    }
    //Funci�n que llena una lista con los datos de los filtros.
    
    public void llenarresultados(int busqueda){
    
   	 Iterator notifyViews = vistas.iterator();
    	lista.removeAllElements();
    	if (busqueda == 0){
    		if (empresasbuscadas.isEmpty()){
				JOptionPane.showMessageDialog(null, "No se han encontrado los datos","Resultado de b�squeda", JOptionPane.ERROR_MESSAGE);
			}
    		else{
    			
    		for (Empresa u : empresasbuscadas){
    			lista.addElement(u.getNombre());
    			
    		}
    		while (notifyViews.hasNext()) {
                ((Funciones) notifyViews.next()).mostrarresultados(lista);
        }
    	}
    	}
    	else{
    		
    		if (personasbuscadas.isEmpty()){
    			JOptionPane.showMessageDialog(null, "No se han encontrado los datos","Resultado de b�squeda", JOptionPane.ERROR_MESSAGE);
    		}
    		else{
    			for (RegistroPersona u:personasbuscadas){
    				lista.addElement(u.getPersona().getNombre()+" "+u.getPersona().getPrimerApellido()+" "+u.getPersona().getSegundoApellido());
    			
    			}
    		
    		        while (notifyViews.hasNext()) {
    		                ((Funciones) notifyViews.next()).mostrarresultados(lista);
    		        }
    			
    		}
    	}
    }
    
  //Funci�n que corren paralela a consultar 
    public void mostrarinformacion(int tipo,int actual){
    	//Se recibe un registro y un tipo y se asigna a la funcion para actualizar seg�n sea el caso. 
    	//La idea es mostrar una nueva ventana con los datos de los registros
    	try{
    		Iterator notifyViews = vistas.iterator(); 
    		if (tipo==1){
    			while (notifyViews.hasNext()) {
	                ((Funciones) notifyViews.next()).actualizarInformacionEmpresa((Empresa) empresasbuscadas.get(actual));
    			}
    		}
    		else{
    			while (notifyViews.hasNext()) {
	                ((Funciones) notifyViews.next()).actualizarInformacionPersona((RegistroPersona) personasbuscadas.get(actual));
    			}
    		}
    	}
    	catch(Exception e){
    		JOptionPane.showMessageDialog(null, "Selecione un usuario","Error", JOptionPane.ERROR_MESSAGE);
    	}
    }

	public void iniciarcomentarios(int dato,int tipo) {
		Iterator notifyViews = vistas.iterator(); 
		contador =0;
		try{
			if (tipo ==0){
				calificacion = empresasbuscadas.get(dato).getCalificacion();
				while (notifyViews.hasNext()) {
	                ((Funciones) notifyViews.next()).Icomentarios(calificacion.get(0),usuario);
				}
			}
			else{
				calificacion = personasbuscadas.get(dato).getCalificacion();
				while (notifyViews.hasNext()) {
	                ((Funciones) notifyViews.next()).Icomentarios(calificacion.get(0),usuario);
				}
			}	
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Selecione un usuario","Error", JOptionPane.ERROR_MESSAGE);
		}
	}	
		
	public void mostrarcomentarios(int operacion){
		Iterator notifyViews = vistas.iterator(); 
		//Operaci�n sirve para decidir cual comentario se va a mostrar
		if (operacion ==0){
			contador --;
		}
		else{
			contador ++;
		}
		
		if (contador < 0 || contador > calificacion.size()){
			JOptionPane.showMessageDialog(null, "No hay comentarios","L�mite encontrado", JOptionPane.ERROR_MESSAGE);
		}
		else{
			while (notifyViews.hasNext()) {
			}   ((Funciones) notifyViews.next()).Icomentarios(calificacion.get(contador), usuario);
        }
	}
	private Usuario buscarBloqueados (String nick){
		//Funci�n que busca un usuario bloqueado
		for (Usuario bloqueado:bloqueados){
			if (bloqueado.getNick().equals(nick)){
				return bloqueado;
			}
		}
		return null;
	}
	private int abuso(Usuario denunciar){
		//Revisa en la lista de abusos si el usuario ya realizo antes una denuncia en contra de este usuario.
		//Regresa un entero con la posic�n del arraydonde esta la demanda
		int indice = 0;
		for (Abuso buscar : denunciar.getListaReportes()){
			if (buscar.getUsuario()==usuario){
				return indice;
			}
			else{
				indice ++;
			}
		}
		
		return -1;
	}
	public void llenarreporte(String reporte, String nick) {
		
		if (reporte.isEmpty()){
			JOptionPane.showMessageDialog(null, "Debe reportar algo","Campo vac�o", JOptionPane.ERROR_MESSAGE);
		}
		else{
		if (buscarBloqueados(nick)==null){
			
			Usuario bloquear=null ;
			//Obtiene la fecha actual del sistema. Para saber que d�a se realizo el abuso.
			Date fecha = new Date();
			//Recorre la lista de usuarios buscando a quien hacerle el abuso
			for (Usuario u :listaUsuarios){
				//Busca el nick en la lista, 
				if (u.getNick().equals(nick)){
					if (abuso(u)!=-1){
						JOptionPane.showMessageDialog(null, "Usted ya report� este usuario","Error", JOptionPane.ERROR_MESSAGE);
					}
					else{
					//Si lo encuentra crea un nuevo abuso en la lista y aumenta los reportes. 
					//Luego va a otro funci�n para comprobar la cantidad de abusos. Si la cantidad es 10, lo bloquea
					u.setListaReportes(new Abuso(usuario,fecha,reporte));
					u.setReportes(u.getReportes()+1);
					bloquear = u;
				
					
			JOptionPane.showMessageDialog(null, "La operaci�n fue realizada con �xito","�xito", JOptionPane.ERROR_MESSAGE);
			comprobarEstado(bloquear);
		}}
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "El usuario ya esta bloqueado","Usuario bloqueado", JOptionPane.ERROR_MESSAGE);
		}
		}
	}
	private void comprobarEstado(Usuario u) {
		//Con los datos proporcionados mueve al usuario a la lista de bloqueados si son 10 los abusos
		//Tiene una variable siguiente que a a hacer igual a 10 + la cantidad de veces que ha sido bloqueado
		
		int next = 10 * u.getVecesbloqueado();
		//Si reportes es igual a 10 cambia a la lista de bloqueados y aumenta la veces que ha sido bloqueado
		if (u.getReportes()==10){
			listaUsuarios.remove(u);
			bloqueados.add(u);
			u.setVecesbloqueado(u.getVecesbloqueado()+1);
		
		}
		if (u.getReportes()>10){
			//Si los reportes es igual a la variable next
			if (u.getReportes()== next){
				//se cambia el tiempo de bloqueo. obteniendo el valor original que es 3 y se multiplica * 2
				u.setTiempobloqueo(u.getTiempobloqueo()*2);
				//Luego aumenta la veces que ha sido bloqueado
				u.setVecesbloqueado(u.getVecesbloqueado()+1);
			}
		}
		
	}
	
	private static void eliminarBloqueo (Usuario u,int indice){
		//Funci�n para eliminar bloque. En base a la ultima fecha de reporte
		Date comparar = u.getListaReportes().get(u.getListaReportes().size()-1).getFechaDenuncia();
		//toma la fecha del sistema
		Date actual = new Date();
		//El bloqueo va a funcionar por minutos. As� que si es mayor de 60 minutos el tiempo
		//que el usuario debe esperar el sistema va a empezar tomar las horas.
		if (u.getTiempobloqueo()<60){
			//Si el tiempo de bloqueo es menor a 60, compara nada m�s los minutos
			//Si la resta realizada es mayor al tiempo de bloque. El usuario cambia de lista
			if ((actual.getMinutes()-comparar.getMinutes())>=u.getTiempobloqueo()){
				listaUsuarios.add(u);
		
			}
		}
		if (u.getTiempobloqueo()>=60){
			//Si el tiempo de bloqueo es menor a 60, compara nada m�s los minutos
			//Si la resta realizada es mayor al tiempo de bloque. El usuario cambia de lista
			int hora = u.getTiempobloqueo()/60;
			int minuto=u.getTiempobloqueo()%60;
			if ((actual.getMinutes()-comparar.getMinutes())>=minuto && actual.getHours()-comparar.getHours()>=hora){
			listaUsuarios.add(u);
			}
		}
	
}
	
	private void eliminarabusos() {
		//Recorre la lista de usuarios y manda a buscar si a realizado un abuso de ser as� lo elimina
	
		
		for (Usuario u : listaUsuarios){
			int indice = abuso(u);
			if (indice!=-1){
				u.getListaReportes().remove(indice);
			}
		}


	}
	public void mostrarabusos(String reportero) {
		for (Abuso actuales : usuario.getListaReportes()){
			if (actuales.getUsuario().getNick().equals(reportero)){
				Iterator notifyViews = vistas.iterator(); 
	    		while (notifyViews.hasNext()) {
		               ((Funciones) notifyViews.next()).mostrarabusos(actuales.getFechaDenuncia(), actuales.getMotivo());
	    			}
			
		}
		
	}
	
}
}
    		
    	
    	
    

	
    
		
		
		
	
	
	


