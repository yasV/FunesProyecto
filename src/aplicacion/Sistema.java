package aplicacion;


import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
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
import grafico.Reportes;
import grafico.VUsuario;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.DateFormats;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Sistema  {
	//Atributos
	private static Usuario usuario; //Variable para manejar el usuario con el que se esta trabajando
	private static ArrayList<Usuario> listaUsuarios;
	private static ArrayList<Usuario> bloqueados;
	private static List<Empresa> empresas;
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
	private int contador = 0;
	String descargar = null;
	private Object jTextArea;
	
	public Usuario getUsuario(){
		return usuario;
	}
	public static void iniciar_sistema(){
	
		for (int i=0;i<10;i++){
    		estrellas.add(i,0);
    	}
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
            	if (cell.getContents().equals("VERDADERO")){
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
            /*
             * Se obtienen los reportes de abusos que se han dado en contra de este usuario
             */
           sheet = workbook.getSheet(3);
            fila = 1;
            cell = sheet.getCell(0, 1); 
            int id = Integer.parseInt(cell.getContents());
            int con = 0; //Valor para manejar el while
            
            while (!cell.getContents().isEmpty()){
            	Usuario x = buscarUsuarioNormal(sheet.getCell(1,fila).getContents());
            	if (x==null){
            		x = buscarUsuarioBloqueado(sheet.getCell(1,fila).getContents());;
            	}
                 if (id==con){
            		listaUsuarios.get(con).setListaReportes((new Abuso(x,new Date(),sheet.getCell(2,fila).getContents())));
            		fila ++; 
            		cell = sheet.getCell(0, fila); 
                    if (!cell.getContents().isEmpty()){ 
            		id = Integer.parseInt(cell.getContents());
                    }
            	}
                 else{
                	 con ++;
                 }
            }
            
            

            //* Lista de empresas
            sheet = workbook.getSheet(1);
            cell = sheet.getCell(1,0); //Columna Fila
            if (cell.getType()==CellType.NUMBER){
            	cantidadEmpresas = Integer.parseInt(cell.getContents());}
            fila=3;
            con = -1;
            cell = sheet.getCell(0, fila); 
            id = Integer.parseInt(cell.getContents());
            while (con<cantidadEmpresas-1){
          
           if (id!=con){
            
            String pais = sheet.getCell(4,fila).getContents();
            String provincia = sheet.getCell(5,fila).getContents();		
            String canton = sheet.getCell(6,fila).getContents();
            String distrito = sheet.getCell(7,fila).getContents();
            String barrio = sheet.getCell(8,fila).getContents();
            Direccion dir_nueva= new Direccion(pais,provincia,canton,distrito);
            dir_nueva.setBarrio(barrio);
            String categoria = sheet.getCell(3,fila).getContents();
            String nombre = sheet.getCell(1,fila).getContents();
            String cedula = sheet.getCell(2,fila).getContents();
            empresas.add(new Empresa (categoria,nombre,dir_nueva));
            
            con ++;
            cell = sheet.getCell(0, fila); 
            id = Integer.parseInt(cell.getContents());
            fila ++;
           
           }
           else{
        	   cell = sheet.getCell(0, fila); 
               id = Integer.parseInt(cell.getContents());
               fila ++;
        	  
        	   
           }
        }
            /*
             * Se obtienen las calificaciones que hay obtenido las empresas
             */
            fila = 3;
            cell = sheet.getCell(0, fila); 
            id = Integer.parseInt(cell.getContents());
            con = 0; //Valor para manejar el while
            
            while (con-1<cantidadEmpresas){
            	
            	Usuario x = buscarUsuarioNormal(sheet.getCell(11,fila).getContents());
            	if (x==null){
            		x = buscarUsuarioBloqueado(sheet.getCell(11,fila).getContents());;
            	}
            	if (id==con){
            		int puntaje = Integer.parseInt(sheet.getCell(9, fila).getContents());
            		File nuevo = new File(sheet.getCell(11,fila).getContents());
            		String comentario = sheet.getCell(10,fila).getContents();
            		empresas.get(con).setCalificacion(new Calificacion(puntaje,x,nuevo,comentario));
            		fila ++;
            	
            			cell = sheet.getCell(0, fila); 
            			if (cell.getContents()!="-1"){
            			id = Integer.parseInt(cell.getContents());
            			}
            			else{
            				con ++;
            			}
            	}
            	
            	else{
            	
            		con ++;
            	}
            }
            
            
         Collections.sort(empresas);
           
           
            sheet = workbook.getSheet(2);
            cell = sheet.getCell(1,0); //Columna Fila
            if (cell.getType()==CellType.NUMBER){
            	cantidadPersonas = Integer.parseInt(cell.getContents());}
            fila = 3;
            cell = sheet.getCell(0, fila); 
            id = Integer.parseInt(cell.getContents());
            con = -1; //Valor para manejar el while
            
            while (con<cantidadPersonas-1){
            if (con!=id){
            int Mes = Integer.parseInt(sheet.getCell(8,fila).getContents());
            int Dia = Integer.parseInt(sheet.getCell(9,fila).getContents());		
            int Año = Integer.parseInt(sheet.getCell(7,fila).getContents());
            Fecha fecha = new Fecha(Año,Dia,Mes);
            String categoria = sheet.getCell(1,fila).getContents();
            String nombre = sheet.getCell(3,fila).getContents();
            String cedula = sheet.getCell(2,fila).getContents();
            String Papellido = sheet.getCell(4,fila).getContents();
            String Sapellido = sheet.getCell(5,fila).getContents();
            String género = sheet.getCell(6,fila).getContents();
            String lugar = sheet.getCell(10,fila).getContents();
            String puesto = sheet.getCell(11,fila).getContents();
            Persona persona = new Persona (cedula,nombre,Papellido,Sapellido,género,fecha,lugar,puesto); 
            RegistroPersona nueva = new RegistroPersona(categoria,persona);
            con ++;
            cell = sheet.getCell(0, fila); 
            id = Integer.parseInt(cell.getContents());
            fila ++;
            personas.add(nueva);
           }
            else{
            	fila ++;
            	cell = sheet.getCell(0, fila); 
                id = Integer.parseInt(cell.getContents());
               
            }
            }
            fila = 3;
            cell = sheet.getCell(0, fila); 
            id = Integer.parseInt(cell.getContents());
            con = 0; //Valor para manejar el while
            
            while (con-1<cantidadUsuarios){
            	
            	Usuario x = buscarUsuarioNormal(sheet.getCell(14,fila).getContents());
            	if (x==null){
            		x = buscarUsuarioBloqueado(sheet.getCell(14,fila).getContents());;
            	}
            	if (id==con){
            		int puntaje = Integer.parseInt(sheet.getCell(12, fila).getContents());
            		File nuevo = new File(sheet.getCell(15,fila).getContents());
            		String comentario = sheet.getCell(13,fila).getContents();
            		personas.get(con).setCalificacion(new Calificacion(puntaje,x,nuevo,comentario));
            		fila ++;
            	
            			cell = sheet.getCell(0, fila); 
            			if (cell.getContents()!="-1"){
            			id = Integer.parseInt(cell.getContents());
            			}
            			else{
            				con ++;
            			}
            	}
            	
            	else{
            	
            		con ++;
            	}
            }

            workbook.close();
        }
        
        

       
        
        catch(Exception e){
           
        	System.out.println("readExcel ->"+e.getMessage()); 
        }
        Collections.sort(personas);
        for (Empresa x:empresas){
        	x.calcularpromedio();
        }
        for (RegistroPersona x : personas){
        	x.calcularpromedio();
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
        System.out.println("ESte es el tamaño de las listas"+vistas.size());
    }
    private void removeContactView(Funciones view) {
    	 //remueve un nuevo view
    	vistas.remove(view);
    }
    
 //--------------------------Funciones para actualizar las vistas------------------------------------
    public void showUsuario (DefaultListModel abusos){
    	Iterator notifyViews = vistas.iterator();
    	while (notifyViews.hasNext()) {
    		((Funciones) notifyViews.next()).IniciarUsuario(usuario,abusos);
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
		
	 	if (this.buscarcategoria(nueva,1,false)){
	 		JOptionPane.showMessageDialog(null, "La categoría ya éxiste","Error", JOptionPane.ERROR_MESSAGE);
	 	}
	 	else{
		lista.addElement(nueva);
		Iterator notifyViews = vistas.iterator();
	   	 while (notifyViews.hasNext()) {
	   		 ((Funciones) notifyViews.next()).agregarlista(lista);
	   	}}
	}
	private void llenarcampos(String genero, String nombre, String primero,
			String segundo) {
    	//Si la el número de cédula ingresado se encuentra en el sistema. Llama para actualizar los datos
		Iterator notifyViews = vistas.iterator();
	   	 while (notifyViews.hasNext()) {
	   		 ((Funciones) notifyViews.next()).datosencontrados(genero, nombre, primero, segundo);
	   	}
	}

//________________________________________________________________________________________________________   
//----------------------------------------------Funciones para la lógica-------------------------------------   
   
    //*******************************Login*****************************************
    
	
	
	public void iniciarSesion(String nick,String password){
		 
    
    	
    	///variable para controlar 
    	if (nick.equals("admin")&& password.equals("admin")){
    		startadmin(); //Inicia el administrador
    	}
    	else{
    		for (Usuario u : bloqueados){
    		if (u.getNick().equals(u.getNick())){
    			this.eliminarBloqueo(u,0);
    			break;
    		}
    	}
    	
    	
    	boolean control=false;
    	for (Usuario u :listaUsuarios ){
    	//Recorre toda la lista comparando que nombre y contraseña sean exactamente iguales. Si encuentra concidencia. Muestra un mensaje de error
    		if (u.getNick().equals(nick)&&u.getPassword().equals(password)){
    			DefaultListModel abuso = new DefaultListModel();
    			usuario = u;
    			for (Abuso a:u.getListaReportes()){
    				abuso.addElement(a.getUsuario().getNick());
    			}
    			showUsuario(abuso);
    			control=true; //Cambia el valor de control
    			break;//Rompe el ciclo
    		}
    	}
    	if (!control){ //Si control no cambia, quiere decir que hay un error, asi que mostrara el mensaje
    		usuario = this.buscarUsuarioBloqueado(nick);
    		
    		if (usuario!=null){
    			
    			JOptionPane.showMessageDialog(null, "Su usuario ha sido bloqueado.Dentro de "+usuario.getTiempobloqueo()+" minutos su cuenta será habilitada", "Bloqueo", JOptionPane.ERROR_MESSAGE);
    		}
    		else{
    			
    		
    		JOptionPane.showMessageDialog(null, "No se encuentra en el sistema o algún dato esta erróneo", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
    	}}}
     }
    
    private void startadmin() {
		DefaultListModel bloqueado= new DefaultListModel();
		DefaultListModel normales = new DefaultListModel();
		DefaultListModel empresasl = new DefaultListModel();
		DefaultListModel personasl = new DefaultListModel();
		
		for (Usuario bloqueados : this.bloqueados){
			bloqueado.addElement(bloqueados.getNick());
		}
		
		for (Usuario normal : this.listaUsuarios){
			normales.addElement(normal.getNick());
		}
		for (Empresa empresa : empresas ){
			empresasl.addElement(empresa.getNombre());
		}
		
		for (RegistroPersona persona : personas){
			personasl.addElement(persona.getPersona().getNombre()+" "+persona.getPersona().getPrimerApellido()+" "+persona.getPersona().getSegundoApellido());
		}
		
		Iterator notifyViews = vistas.iterator();
        while (notifyViews.hasNext()) {
                ((Funciones) notifyViews.next()).iniciaradministrador(normales, bloqueado, empresasl, personasl);
        }
		
	}
	public void Registrarse (String nombre,String nick,String contraseña,String privacidad){
    	if (nombre.isEmpty()||nick.isEmpty()||contraseña.isEmpty()||privacidad.isEmpty()){
    		JOptionPane.showMessageDialog(null, "Por favor, asegúrese que no quedé ningún campo vacío", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
    	}
    	else{
    		boolean control = false;
    		DefaultListModel abuso = new DefaultListModel();
    		for (Usuario u:listaUsuarios){
    			if (u.getNick().equals(nick)){
    				JOptionPane.showMessageDialog(null, "El nick no se encuentra disponible", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
    				control = true;
    			}}
    		if (!control){
    			boolean estado = false;
    			if (privacidad.equals("Privado")){
    				estado=true;
    			}
    			usuario =new Usuario(nick,contraseña,nombre,estado);
    			listaUsuarios.add(usuario);
    			JOptionPane.showMessageDialog(null, "Usuario creado con éxito", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
    			this.incluirusuarionuevo();
    			showUsuario(abuso);
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
    				registro = buscarcedula(cedula, 0,false);
    				if (registro==null){
    					nueva.setCedulaJuridica(cedula);
    					nuevo =true;
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
    		return nueva;
    	}
    	return null;
    }
    
    //Crear persona
    public Registro registrarpersona(Persona persona,String categoria){
    	
    	registro = this.comparaRegistro(persona.getNombre(), 1, categoria);
    	if (registro==null){
    		this.nuevo=true;
    		return  new RegistroPersona(persona,categoria);
    		
    	}
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
    		   return new Fecha (mes,Integer.parseInt(dia),Integer.parseInt(año));
    	   }
    	   catch (Exception e){
    		   JOptionPane.showMessageDialog(null, "Ingrese un número válido", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
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
	        			JOptionPane.showMessageDialog(null, "El número de cédula no existe", "Datos no encontrados", JOptionPane.ERROR_MESSAGE);
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
    	model.addElement("Limón");
    	model.addElement("Puntarenas");
    	model.addElement("San José");
    }
    
    public void listaCategoria(){
    	for (RegistroPersona u : personas){
    		lista.addElement(u.getCategorias());
    	}
    	
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
    
    public boolean buscarcategoria (String categoria,int lista, boolean multitud){
      /*Recibe un nombre y un valor para saber en cuál lista debe de buscar.
        * Realiza un recorrido por la lista, obtiene el campo categoría de cada objeto. Devuelve true si la encuentra y termina el ciclo
       	* Si no esta, devuelve false
         * */
    
    	System.out.println(personas.size());
    	System.out.println(lista);
    	if (lista==1){
    		personasbuscadas.clear();
    		
    		for (int i=0;i<personas.size();i++){
        		RegistroPersona u = personas.get(i);
    			if (u.getCategorias().equalsIgnoreCase(categoria)){
        			if (multitud){
        				personasbuscadas.add(u);
        			}
        			else{
        			System.out.println("Lo encontré");
        				return true;
        			}
            	}
            }
    		
    	}
    	if (lista==0){
    		empresasbuscadas.clear();
    		for (Empresa e : empresas){
    			if (e.getCategoria().equalsIgnoreCase(categoria)){
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
  //----------------------------------------------Funciones página de Consultar------------------------------------- 
  //Rellena el comboBox con las maneras en las que se puede Buscar, y muestra todas las personas
    public void busquedaPersona(int i){
    	//El i sirve como indicador para saber si se debe de llenar con la lista original o con la de buscados
    	//Para esto declaramos una variable llamada lista
    	
    	if (i==1){
    	
    		for (RegistroPersona e : personas){
    			personasbuscadas.add(e);
    		}
    	}

    
    	DefaultListModel todo=new DefaultListModel();
    	
    	    
    	for (RegistroPersona u: personas){
    		todo.addElement(u.getPersona().getNombre()+" "+u.getPersona().getPrimerApellido()+" "+u.getPersona().getSegundoApellido());
    	}
    	DefaultComboBoxModel tipo= modelo("Física");
    	
    	Iterator notifyViews = vistas.iterator();
        while (notifyViews.hasNext()) {
                ((Funciones) notifyViews.next()).llenarPersona(tipo,todo);
        }

        
    }
    
    
    public void busquedaJuridica(int i){
    	//El i sirve como indicador para saber si se debe de llenar con la lista original o con la de buscados
    	//Para esto declaramos una variable llamada lista
  
    	if (i==0){
    		for (Empresa e : empresas){
    			empresasbuscadas.add(e);
    		}
    	}
    	DefaultListModel todo = new DefaultListModel();
    	for (Empresa empresa :empresas){
    		todo.addElement(empresa.getNombre());
    	}
    	DefaultComboBoxModel tipo= modelo("Jurídica");
    	
    	Iterator notifyViews = vistas.iterator();
    	while (notifyViews.hasNext()) {
            ((Funciones) notifyViews.next()).llenarJuridica(tipo,todo);
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
    		tipoBusq.addElement("Categoría");
    	}
    	else{
    		tipoBusq.addElement("Nombre");
        	tipoBusq.addElement("Cédula Jurídica");
        	tipoBusq.addElement("Categoría");
    		
    	}
    	return tipoBusq;

    }
    
    ///Llena el comboBox de la pantalla de calificar dependiendo de la opción seleccionada
    public void busquedaCalificar(int opcion){
    	String nombre= " ";
    	if(opcion==0){
    		for(Empresa u: empresas){
    			nombre= u.getNombre();
    		}
    	}
    	else{
    		for(RegistroPersona u:personas){
    			nombre= (u.getPersona().getNombre()+u.getPersona().getPrimerApellido()+u.getPersona().getSegundoApellido());
    		}
    	}
    	Iterator notifyViews = vistas.iterator();
        while (notifyViews.hasNext()) {
                ((Funciones) notifyViews.next()).asignarcalificar(nombre);
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
    
    //Guarda la calificación
    public void guardarCalificacion(Registro agregar,int tipo,String demandado,String review,String evidencia,String demandante,String nombre){
    	//Si es una persona física
    	 //Contador en caso de que la persona ya haya calificado a esa persona
    	Calificacion prueba = null; //prueba es una calificación para asegurarse de que solo se comenté una vez por persona
   
    	if ( review.isEmpty()||evidencia.isEmpty()){
    		//Si esta vacío va a regresar un mensaje de error
    		JOptionPane.showMessageDialog(null, "No puede haber ningún campo vacío y debe de subir algún documento para realizar la calificación", "Formulario incompleto", JOptionPane.ERROR_MESSAGE);
    	}
    	else{
    		//Obtiene la calificación
    		int calificacion=estrellas.indexOf(1)+1;
    		//Crea el documento de evidencia
    		String almacenar = "/"+nombre;
    		File evidenc=new File(almacenar);
    		//Crea la nueva calificación
    		Calificacion cal_nueva = new Calificacion (calificacion,usuario,evidenc,review);
    	
    
    	if(tipo==1){
    	
    		if (nuevo){
    			//Si es nueva. Le asigna el registro a persona, le asigna la calificación, calcula el promedio, sube el archivo
    			//agrega la persona, mensaje de éxito y por último vuelve a poner el valor de nuevo como false.
    			RegistroPersona nueva = (RegistroPersona) agregar;
    			nueva.setCalificacion(cal_nueva);
    			nueva.calcularpromedio();
    		    Ftp.uploadFileByFTP(evidencia, nombre);
    			personas.add(nueva);
    		    JOptionPane.showMessageDialog(null, "Su comentario ha sido guardado de forma exitosa", "Operación realizada con éxito", JOptionPane.INFORMATION_MESSAGE);
    			nuevo = false;
    		}
    		else{
    			//Busca la persona en la lista, si la encuentra va a buscar en su lista de comentarios si se encuentra el usuario actual
        		RegistroPersona buscar = this.buscarPersona(demandado);
        		prueba = this.buscarcomentario(buscar.getCalificacion());
    			if (prueba != null){ //Si prueba es null, 
    	    		 buscar.getCalificacion().set(contador,cal_nueva); //Reemplaza los valores por los nuevos 
    	    		
    	    		   }
    	    	else{
    	    			buscar.setCalificacion(cal_nueva);//Agrega el valor
    	    			
    	    				}
    			Ftp.uploadFileByFTP(evidencia, nombre);
    			buscar.calcularpromedio();//Calcula el promedio
    			  JOptionPane.showMessageDialog(null, "Su comentario ha sido guardado de forma exitosa", "Operación realizada con éxito", JOptionPane.INFORMATION_MESSAGE);
    	    	        }
    	    		
    			}
    		
    	else{
    			//pasamos la evidencia de String a un File
    	
    		if (nuevo){
    		Empresa n = (Empresa) agregar;
    		n.setCalificacion(cal_nueva);
			n.calcularpromedio();
		    Ftp.uploadFileByFTP(evidencia, nombre);
			empresas.add(n);
		    JOptionPane.showMessageDialog(null, "Su comentario ha sido guardado de forma exitosa", "Operación realizada con éxito", JOptionPane.INFORMATION_MESSAGE);
			nuevo = false;
    		
    		}
    		else{
    			Empresa buscar = this.buscarEmpresa(demandado);
        		prueba = this.buscarcomentario(buscar.getCalificacion());
       			if (prueba!=null){
    	    				buscar.getCalificacion().set(contador, cal_nueva);
    	    				
    	    				
    	    			}
    	    			else{
    					    buscar.setCalificacion(cal_nueva);}
    	    	            buscar.calcularpromedio();
    	    	          
    	    	            Ftp.uploadFileByFTP(evidencia, nombre);
    	    	            JOptionPane.showMessageDialog(null, "Su comentario ha sido guardado de forma exitosa", "Operación realizada con éxito", JOptionPane.INFORMATION_MESSAGE);
    	    		}
    		
    	}
    	}
    	}
    	
   
    
    	
    public void marcarEstrellas(int indice){
    	//Función que marca las estrellas y las ponen de color
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
    	/*Recibe un nombre y un valor para saber en cuál lista debe de buscar.
    	 * Si el valor ingresado es 0, buscará en la lista de empresas y si es uno en la personas
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
     	/*Recibe una variable cédula y un valor para saber en cuál lista debe de buscar.
    	 * Si el valor ingresado es 0, buscará en la lista de empresas y si es uno en la personas
    	 * Realiza un recorrido por la lista, obtiene el campo cédula de cada objeto. Devuelve la variable si la encuentra y termina el ciclo
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
     	/*Recibe una variable cédula y un valor para saber en cuál lista debe de buscar.
    	 * Si el valor ingresado es 1 buscará el primer apellido y si es 2 el segundo
    	 * Realiza un recorrido por la lista, obtiene el campo apellido de cada objeto. Devuelve la variable si la encuentra y termina el ciclo
    	 * Si no esta, devuelve nulo
    	 * ¿*/
    
    	personasbuscadas.clear();
    	if (lista == 1){
    		for (RegistroPersona u : personas){
    			System.out.println(u.getPersona().getPrimerApellido());
    			String comparar = u.getPersona().getPrimerApellido();
    			if (comparar.equalsIgnoreCase(apellido)){
    				
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
    //Función que llena una lista con los datos de los filtros.
    
    public void llenarresultados(int busqueda){
    
   	 Iterator notifyViews = vistas.iterator();
    	lista.removeAllElements();
    	if (busqueda == 0){
    		if (empresasbuscadas.isEmpty()){
				JOptionPane.showMessageDialog(null, "No se han encontrado los datos","Resultado de búsqueda", JOptionPane.ERROR_MESSAGE);
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
    			JOptionPane.showMessageDialog(null, "No se han encontrado los datos","Resultado de búsqueda", JOptionPane.ERROR_MESSAGE);
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
    
  //Función que corren paralela a consultar 
    public void mostrarinformacion(int tipo,int actual){
    	//Se recibe un registro y un tipo y se asigna a la funcion para actualizar según sea el caso. 
    	//La idea es mostrar una nueva ventana con los datos de los registros
    	try{
    		Iterator notifyViews = vistas.iterator(); 
    		if (tipo==1){
    			while (notifyViews.hasNext()) {
    				Empresa x =  empresasbuscadas.get(actual);
    				x.calcularpromedio();
	                ((Funciones) notifyViews.next()).actualizarInformacionEmpresa((x));
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
				descargar = calificacion.get(0).getEvidencia().getName();
				while (notifyViews.hasNext()) {
	                ((Funciones) notifyViews.next()).Icomentarios(calificacion.get(0),usuario);
				}
			}
			else{
				calificacion = personasbuscadas.get(dato).getCalificacion();
				descargar = calificacion.get(0).getEvidencia().getName();
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
		//Operación sirve para decidir cual comentario se va a mostrar

		if (operacion ==0){
			if (contador>0){
				contador --;
				
			}
			
		}
		else{
			if (contador < calificacion.size()){
				contador ++;
			}
			
		}
		
		if (contador < 0 || contador >= calificacion.size()){
			JOptionPane.showMessageDialog(null, "No hay comentarios","Límite encontrado", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		else{
			
			descargar = calificacion.get(contador).getEvidencia().getName();
			while (notifyViews.hasNext()) {
			System.out.println("Aqui");
			((Funciones) notifyViews.next()).Icomentarios(calificacion.get(contador), usuario);
        }}
	}

	public void EliminarCuenta() {
		JDialog.setDefaultLookAndFeelDecorated(true);
	 	 int response = JOptionPane.showConfirmDialog(null, "¿Desea eliminar su cuenta?", "ELIMINAR CUENTA",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	 	 if (response == JOptionPane.NO_OPTION) {
	 	
	 	 } 
	 	 else if (response == JOptionPane.YES_OPTION) {
	 		 listaUsuarios.remove(usuario);
	 		 cantidadUsuarios --;
	 		 this.finalizar();
	 		 eliminarnotas();
	 		 eliminarabusos();//*
	 		 
	 		 CuentaEliminar();
	 		 
	 	 }
	 	
	 	  else if (response == JOptionPane.CLOSED_OPTION) {
	 	
	 	 }
	}
	

	private void eliminarnotas() {
	//Recorrer las listas y se encuentra el usuario en la calificación, lo elimina
		for (Empresa e : empresas){
			for (Calificacion cal : e.getCalificacion()){
				if (cal.getUsuario()==usuario){
					e.getCalificacion().remove(cal);
					e.calcularpromedio();
					break;
				}
			}
		}
		
		for (RegistroPersona p : personas){
			for (Calificacion cal:p.getCalificacion()){
				if (cal.getUsuario()==usuario){
					p.getCalificacion().remove(cal);
					p.calcularpromedio();
					break;
				}
			}
		}
		
	}
	public void CuentaEliminar(){
		Iterator notifyViews = vistas.iterator(); 
		while (notifyViews.hasNext()) {
		
			((Funciones) notifyViews.next()).CuentaEliminada();
        
		
	}
	
	}
	public void verInfo (String nick){
		
		Iterator notifyViews = vistas.iterator(); 
		Usuario u = this.buscarUsuarioNormal(nick);
		
		while (notifyViews.hasNext()) {
						((Funciones) notifyViews.next()).llenardatos(u);;
			        }
				}
			
			
			
		
		
		
	
	
	//___________________*new______________________________

	private int abuso(Usuario denunciar){
		//Revisa en la lista de abusos si el usuario ya realizo antes una denuncia en contra de este usuario.
		//Regresa un entero con la posicón del arraydonde esta la demanda
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
			JOptionPane.showMessageDialog(null, "Debe reportar algo","Campo vacío", JOptionPane.ERROR_MESSAGE);
		}
		else{
		if (this.buscarUsuarioBloqueado(nick)==null){
			
			Usuario bloquear=null ;
			//Obtiene la fecha actual del sistema. Para saber que día se realizo el abuso.
			Date fecha = new Date();
			//Recorre la lista de usuarios buscando a quien hacerle el abuso
			for (Usuario u :listaUsuarios){
				//Busca el nick en la lista, 
				if (u.getNick().equals(nick)){
					if (abuso(u)!=-1){
						JOptionPane.showMessageDialog(null, "Usted ya reportó este usuario","Error", JOptionPane.ERROR_MESSAGE);
					}
					else{
					//Si lo encuentra crea un nuevo abuso en la lista y aumenta los reportes. 
					//Luego va a otro función para comprobar la cantidad de abusos. Si la cantidad es 10, lo bloquea
					u.setListaReportes(new Abuso(usuario,fecha,reporte));
					u.setReportes(u.getReportes()+1);
					bloquear = u;
				
					
			JOptionPane.showMessageDialog(null, "La operación fue realizada con éxito","Éxito", JOptionPane.ERROR_MESSAGE);
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
		//Función para eliminar bloque. En base a la ultima fecha de reporte
		Date comparar = u.getListaReportes().get(u.getListaReportes().size()-1).getFechaDenuncia();
		//toma la fecha del sistema
		Date actual = new Date();
		//El bloqueo va a funcionar por minutos. Así que si es mayor de 60 minutos el tiempo
		//que el usuario debe esperar el sistema va a empezar tomar las horas.
		if (u.getTiempobloqueo()<60){
			//Si el tiempo de bloqueo es menor a 60, compara nada más los minutos
			//Si la resta realizada es mayor al tiempo de bloque. El usuario cambia de lista
			if ((actual.getMinutes()-comparar.getMinutes())>=u.getTiempobloqueo()){
				listaUsuarios.add(u);
		
			}
		}
		if (u.getTiempobloqueo()>=60){
			//Si el tiempo de bloqueo es menor a 60, compara nada más los minutos
			//Si la resta realizada es mayor al tiempo de bloque. El usuario cambia de lista
			int hora = u.getTiempobloqueo()/60;
			int minuto=u.getTiempobloqueo()%60;
			if ((actual.getMinutes()-comparar.getMinutes())>=minuto && actual.getHours()-comparar.getHours()>=hora){
			listaUsuarios.add(u);
			}
		}
	
}
	
	private void eliminarabusos() {
		//Recorre la lista de usuarios y manda a buscar si a realizado un abuso de ser así lo elimina
	
		
		for (Usuario u : listaUsuarios){
			int indice = abuso(u);
			if (indice!=-1){
				u.getListaReportes().remove(indice);
			}
		}


	}
	public void mostrarabusos(String reportero) {
		/*
		 * Recorre la lista de abusos del usuario hasta que encuentra el que selecciono. Hecho esto llamara a mostrar abuso pasandole el valor de la fecha y el
		 * motivo
		 */
		for (Abuso actuales : usuario.getListaReportes()){
			if (actuales.getUsuario().getNick().equals(reportero)){
				Iterator notifyViews = vistas.iterator(); 
	    		while (notifyViews.hasNext()) {
		               ((Funciones) notifyViews.next()).mostrarabusos(actuales.getFechaDenuncia(), actuales.getMotivo());
	    			}
			
		}
		}
	}
		
	
	public void save(){
		//Muestro un dialogo sin pasarle parent con el boton de abrir
		if (this.descargar!=null){
			
		
		JFileChooser explorador = new JFileChooser();
		  explorador.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				//Le cambiamos el titulo
		explorador.setDialogTitle("Guardar Evidencia");

		int seleccion = explorador.showDialog(null, "Guardar");
		  
		//analizamos la respuesta
			switch(seleccion) {
			case JFileChooser.APPROVE_OPTION:
				//Podemos crear un File con lo seleccionado
				File archivo = explorador.getSelectedFile();

				//y guardar una ruta
				String ruta = archivo.getAbsolutePath() + "\\" + descargar;
				Ftp.downloadFileByFTP(ruta, descargar);
				break;

			case JFileChooser.CANCEL_OPTION:
		 //dio click en cancelar o cerro la ventana
				break;

			case JFileChooser.ERROR_OPTION:
		 //llega aqui si sucede un error
				break;
		}
		}
		else{
			
			JOptionPane.showMessageDialog(null, "No hay evidencia","Error", JOptionPane.ERROR_MESSAGE);
		}
			    }

		

	public void mostrarcalificacion(int i) {
		/*Función que busca en la lista de empresas o personas según corresponda al usuario actual.
		 * Cuando lo encuentra lo agrega un modelo de lista para actualizar los datos.
		 * i=0;empresa i=1;persona 
		 */
		DefaultListModel propias = new DefaultListModel ();//Variable para almacenar el nombre de las empresas o personas
		if (i==0){
			for (Empresa u : empresas){
				for (auxiliares.Calificacion cal : u.getCalificacion()){
					if (cal.getUsuario()==usuario){
						propias.addElement(u.getNombre());
					}
				}
			}
		}
		else{
			for (RegistroPersona u:personas){
				for (auxiliares.Calificacion cal:u.getCalificacion()){
					if (cal.getUsuario()==usuario){
						propias.addElement(u.getPersona().getNombre()+" "+u.getPersona().getPrimerApellido()+" "+u.getPersona().getSegundoApellido());
					}
				}
			}
		}
		Iterator notifyViews = vistas.iterator(); 
		while (notifyViews.hasNext()) {
               ((Funciones) notifyViews.next()).showusercalification(propias);
			}
	}
	public void mostrarcomentariosusuario(int i, String nombre) {
		Calificacion mandar=null;
		if (i==-1 || nombre.isEmpty()){
			JOptionPane.showMessageDialog(null, "Debe de seleccionar un tipo de persona y una persona de la lista","Campo en blanco", JOptionPane.ERROR_MESSAGE);
		}
		if (i==0){
			for (Empresa empresa : empresas){
				if (empresa.getNombre().equals(nombre)){
					mandar = buscarcomentario(empresa.getCalificacion());	
				}
			}
		}
		else{
			for (RegistroPersona persona:personas){
				String comparar = persona.getPersona().getNombre() +" "+persona.getPersona().getPrimerApellido()+" "+persona.getPersona().getSegundoApellido();
				if (comparar.equals(nombre)){
					mandar=buscarcomentario(persona.getCalificacion());
				}
			}
		}
		Iterator notifyViews = vistas.iterator(); 
		while (notifyViews.hasNext()) {
               ((Funciones) notifyViews.next()).mostrarsuscomentarios(mandar);
			}
		
	}
	private Calificacion buscarcomentario(ArrayList<Calificacion> calificacion) {
		//Busca una calificación.
		for (Calificacion x : calificacion){
			if (x.getUsuario()==usuario){
				return x;
			}
		}
		return null;
	}
	public void eliminarCalificacion(String selectedValue,int tipo) {
		//ELiminar notas asociadas a un usuario
		if (tipo==0){
			//Si el tipo es 0:Busca en la lista de las empresas. Busca el comentario y el que regresa lo elimina
			for (Empresa empresa : empresas){
				if (empresa.getNombre().equals(selectedValue)){
					Calificacion eliminar = buscarcomentario(empresa.getCalificacion());
					empresa.getCalificacion().remove(calificacion);
					empresa.calcularpromedio();
					JOptionPane.showMessageDialog(null, "Calificación eliminada con éxito","Éxito", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		}
		else{
			//Si el tipo no es 0:Busca en la lista de las empresas.Busca el comentario y el que regresa lo elimina
			for (RegistroPersona persona :personas){
				String comparar = persona.getPersona().getNombre()+" "+persona.getPersona().getPrimerApellido()+" "+persona.getPersona().getSegundoApellido();
				if (comparar.equals(selectedValue)){
					Calificacion eliminar = buscarcomentario(persona.getCalificacion());
					persona.getCalificacion().remove(eliminar);
					persona.calcularpromedio();
					JOptionPane.showMessageDialog(null, "Calificación eliminada con éxito","Éxito", JOptionPane.INFORMATION_MESSAGE);
					break;
				}
			}
		}
	
	
	

}
	public void calificar(String selectedValue, int tipo) {
		//Llama a a función buscar calificación para asegurarse del que el usuario no haya comentado.
		//Si ya lo hizo, mostrara la pantalla de calificación con los datos anteriores.
		//Si no ha calificado la pantalla se mostrara con los datos normales
		Iterator notifyViews = vistas.iterator(); 
		if (tipo==-1 || selectedValue==null){
			JOptionPane.showMessageDialog(null, "Debe de seleccionar un elemento de la lista","Campo vacío", JOptionPane.ERROR_MESSAGE);
			
		}
		else{
			Calificacion cal = null;
			if (tipo==0){
				for (Empresa empresa : empresas){
					if (empresa.getNombre().equals(selectedValue)){
						cal = this.buscarcomentario(empresa.getCalificacion());
					}
				}
				
			}
			if (tipo==1){
				for (RegistroPersona persona:personas){
					String comparar = persona.getPersona().getNombre()+" "+persona.getPersona().getPrimerApellido()+" "+persona.getPersona().getSegundoApellido();
					if (comparar.equals(selectedValue)){
						cal= this.buscarcomentario(persona.getCalificacion());
					}
				}
				
			}
			if (cal==null){
				
				while (notifyViews.hasNext()) {
		               ((Funciones) notifyViews.next()).nuevacalificacion (selectedValue,tipo,false);
					}
		}
			else{
				while (notifyViews.hasNext()) {
		               ((Funciones) notifyViews.next()).reemplazarcalificacion (selectedValue,tipo,cal,true);
					}
			}
			
		}
		
	}
	public void mostrarestadisticas(int i, String valor) {
		// TODO Auto-generated method stub
		grafico.Calificacion cal = new grafico.Calificacion();
		
		if (i==0){
			for (Empresa x : empresas){
				if (x.getNombre().equals(valor)){
					cal.barras(x.getCalificacion());
					cal.frame.setVisible(true);
			}}
		}
		if (i==1){
			for (RegistroPersona x : personas){
				if (x.getPersona().getCedula().equals(valor)){
					
					cal.barras(x.getCalificacion());
					cal.frame.setVisible(true);
				}
			}
		}
		
	}
	public void bloqueo(String selectedValue,int borrar) {
		/*
		 * Busca en la lista de bloqueados el usuario,lo selecciona y lo pasa de lista. Lleva un contador para no tener problemas
		 * al eliminarlo de la lista
		 * Entero borrar para saber en cual lista debe de buscar
		 * 0 de activo a bloqueado
		 * 1 elimina el usuario bloqueado
		 */
		int indice =0;
		int tipo = 0;
		DefaultListModel bloqueado = new DefaultListModel ();
		DefaultListModel activos = new DefaultListModel ();
		
	if (borrar == 0){
		for (Usuario x:bloqueados){
			if (x.getNick().equals(selectedValue)){
				this.listaUsuarios.add(x);
				break;
			}
			indice ++;
		}
		this.bloqueados.remove(indice);
		
		}
	else{
		for (Usuario x:bloqueados){
			if (x.getNick().equals(selectedValue)){
				break;
			}
			indice ++;
		}
		this.bloqueados.remove(indice);
		
	}
		
	for (Usuario usuario : bloqueados){
		bloqueado.addElement(usuario.getNick());
	}
	
	for (Usuario usuario : listaUsuarios){
		activos.addElement(usuario.getNick());
	}
	
		Iterator notifyViews = vistas.iterator();
        while (notifyViews.hasNext()) {
                ((Funciones) notifyViews.next()).actualizarlista (bloqueado,activos,tipo);
        }
		
	}
	public void mostraradministrador(String selectedValue, int i) {
		//Si el entero i es igual a 0 va a mostrar la parte juridíca y si es 1 la parte física
		//Lo que hace es buscar la empresa y despúes de hacerlo la manda a la pantalla de Información para que sean
		//Reemplazados los datos.
		
	}
	public void abusos(String selectedValue, int i) {
		/*
		 *  Si el entero es 0 va a mostrar los abusos del usuario seleccionado en activo
		 *  Si el entero es 1 va a mostrar los abusos del usuario seleccionado en bloqueado
		 *  Si el valor en nulo. Mostrará mensaje de error.
		 * 
		 */
		if (selectedValue==null){
			JOptionPane.showMessageDialog(null, "Seleccione un usuario de la lista", "Error", JOptionPane.ERROR_MESSAGE);
			
		}
		else{
			if (i==0){
				Usuario u = this.buscarUsuarioNormal(selectedValue);
				if (u.getListaReportes()==null){
					  JOptionPane.showMessageDialog(null, "El usuario no tiene reportes en su contra", "Sin valor", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
				Reportes ver = new Reportes();
				ver.mostrarreportes(u.getListaReportes());
				}
			}
			if (i==1){
				Usuario u = this.buscarUsuarioBloqueado(selectedValue);
				if (u.getListaReportes()==null){
					  JOptionPane.showMessageDialog(null, "El usuario no tiene reportes en su contra", "Sin valor", JOptionPane.INFORMATION_MESSAGE);
				}
				else{
				Reportes ver = new Reportes();
				ver.mostrarreportes(u.getListaReportes());
				}
			}
		}
		
	}
	public static Usuario buscarUsuarioNormal(String nombre){
		for (Usuario u: listaUsuarios){
			if (u.getNick().equalsIgnoreCase(nombre)){
				return u;
			}
		}
		return null;
	}
	public static Usuario buscarUsuarioBloqueado(String nombre){
		for (Usuario u: bloqueados){
			if (u.getNick().equalsIgnoreCase(nombre)){
				return u;
			}
		}
		return null;
	}
	
	public Empresa buscarEmpresa(String nombre){
		contador = 0;
		for (Empresa empresa : empresas ){
			if (empresa.getNombre().equalsIgnoreCase(nombre)){
				return empresa;
			}
			contador ++;
				
		}
		return null;
	}
	
	public RegistroPersona buscarPersona(String nombre){
		contador =0;
		for (RegistroPersona persona : personas){
			Persona x= persona.getPersona();
			if (nombre.equalsIgnoreCase(x.getNombre()+" "+x.getPrimerApellido() + " "+x.getSegundoApellido())){
				return persona;
			}
			contador ++;
		}
		return null;
	}
	public void editar(int i,String  nombre) {
		Iterator notifyViews = vistas.iterator();
			
		//Si es 0 llama a modificarempresa. Si es 1 llama a modificar persona.
		if (i==0){
			while (notifyViews.hasNext()) {
				llenarprovincias();
				
				((Funciones) notifyViews.next()).modificarempresa(this.buscarEmpresa(nombre));
	    	}
		}
		if (i==1){
			llenarmes();
			this.listaCategoria();
			
			while (notifyViews.hasNext()) {
	    		((Funciones) notifyViews.next()).modificarpersona(this.buscarPersona(nombre),model,lista);
	    	}
		}
		
	}
	public void modificardatosempresa(String nombre,String categoria,String pais,String barrio,String canton,String distrito,
			String provincia,String cedula ){
		/*
		 * Recibe como entrada todos los valores que posee el registro y si el valor no es vacío los reemplaza
		 */
		if (!nombre.isEmpty()){
		empresas.get(contador).setNombre(nombre);
	}
		if (!categoria.isEmpty()){
			empresas.get(contador).setCategoria(categoria);
		}
		if (!pais.isEmpty()){
			empresas.get(contador).getDireccion().setPais(pais);
		}
		if (!canton.isEmpty()){
			empresas.get(contador).getDireccion().setCanton(canton);
		}
		if (!distrito.isEmpty()){
			empresas.get(contador).getDireccion().setDistrito(distrito);
		}
		if (provincia!=null){
			empresas.get(contador).getDireccion().setProvincia(provincia);
		}
		if (!barrio.isEmpty()){
			empresas.get(contador).getDireccion().setBarrio(barrio);
		}
		  JOptionPane.showMessageDialog(null, "Modificaciones realizadas con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
	public void modificardatospersona(String categoria,String institucion,String cargo,String dia,String mespalabra,String año ){
		if (categoria!=null){
			personas.get(contador).setCategorias(categoria);
		}
		if (!institucion.isEmpty()){	
		personas.get(contador).getPersona().setInstitucion(institucion);
			
		}
		if (!cargo.isEmpty()){
			personas.get(contador).getPersona().setCargo(cargo);
		}
		   try{   
    		   if (mespalabra.isEmpty()){
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
    		   personas.get(contador).getPersona().getFechaNacimiento().setMes(mes);
    		   }
    		   if (!dia.isEmpty()){
    		   personas.get(contador).getPersona().getFechaNacimiento().setDia(Integer.parseInt(dia));}
    		   if (!año.isEmpty()){
    			   personas.get(contador).getPersona().getFechaNacimiento().setAño(Integer.parseInt(año));
    		   }
    		  
    	   }
    	   catch (Exception e){
    		   JOptionPane.showMessageDialog(null, "Ingrese un número válido", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
    	   }
		
		   JOptionPane.showMessageDialog(null, "Modificaciones realizadas con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
	}
	public void mostrarUsuario(String bloqueado, String normal) {
		if (bloqueado==null && normal==null){
			 JOptionPane.showMessageDialog(null, "Seleccione un valor de lista", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else{
			Iterator notifyViews = vistas.iterator();
	    	
			if (bloqueado==null){
				while (notifyViews.hasNext()) {
		    		((Funciones) notifyViews.next()).mostrarDatosUsuario(this.buscarUsuarioNormal(normal));
		    	}
			}
		
			if (normal==null){
				while (notifyViews.hasNext()) {
		    		((Funciones) notifyViews.next()).mostrarDatosUsuario(this.buscarUsuarioBloqueado(bloqueado));
		    	}
			}
		
		
	}
	}
	public static void incluirusuarionuevo(){

		String cellData = new String();

    try{

        Workbook target_workbook = Workbook.getWorkbook(new File("Datos.xls"));

        WritableWorkbook workbook = Workbook.createWorkbook(new File("Datos.xls"), target_workbook);
        target_workbook.close();
        WritableSheet sheet = workbook.getSheet(0);
        jxl.write.Label escribir ;
        jxl.write.Number cantidad;
        
        int fila=2;
        int i=1;
        int usuario = 0;
       
        
        cantidad = new jxl.write.Number(1,0,listaUsuarios.size()+bloqueados.size());
        sheet.addCell(cantidad);
        
        for (Usuario u : listaUsuarios){
        	escribir = new jxl.write.Label(0,fila,u.getNick());
        	sheet.addCell(escribir);
        	escribir = new jxl.write.Label(1,fila,u.getNombre());
        	sheet.addCell(escribir);
        	escribir = new jxl.write.Label(2,fila,u.getPassword());
        	sheet.addCell(escribir);
        	escribir = new jxl.write.Label(4,fila,"Normal");
        	sheet.addCell(escribir);
        	if (u.isPrivado()){
        	escribir = new jxl.write.Label(3,fila,"VERDADERO");}
        	else{
        		escribir = new jxl.write.Label(3,fila,"FALSO");}
        	sheet.addCell(escribir);
        	fila ++;
        }
        for (Usuario u : bloqueados){
        	escribir = new jxl.write.Label(0,fila,u.getNick());
        	sheet.addCell(escribir);
        	escribir = new jxl.write.Label(1,fila,u.getNombre());
        	sheet.addCell(escribir);
        	escribir = new jxl.write.Label(2,fila,u.getPassword());
        	sheet.addCell(escribir);
        	escribir = new jxl.write.Label(4,fila,"Bloqueado");
        	sheet.addCell(escribir);
        	if (u.isPrivado()){
        	escribir = new jxl.write.Label(3,fila,"VERDADERO");}
        	else{
        		escribir = new jxl.write.Label(3,fila,"FALSO");}
        	sheet.addCell(escribir);
        	fila ++;
        }
        
        
        workbook.write();



        workbook.close();
        }

    catch(Exception e)

    {

        System.out.println("writeExcel ->"+e);

    }
    
	}
	public static void finalizar (){
		
	

		String cellData = new String();

    try{

        Workbook target_workbook = Workbook.getWorkbook(new File("Datos.xls"));

        WritableWorkbook workbook = Workbook.createWorkbook(new File("Datos.xls"), target_workbook);
        target_workbook.close();
        WritableSheet sheet = workbook.getSheet(3);
        jxl.write.Label escribir ;
        jxl.write.Number cantidad;
        
    
        int i=1;
        int usuario = 0;
       
        
        cantidad = new jxl.write.Number(1,0,listaUsuarios.size()+bloqueados.size());
        sheet.addCell(cantidad);
        
        for (Usuario u : listaUsuarios){
        	
        	
        	for (Abuso abuso : u.getListaReportes()){
        		escribir = new jxl.write.Label(0, i,Integer.toString(usuario));
        		sheet.addCell(escribir);
        		escribir = new jxl.write.Label(1, i,abuso.getUsuario().getNick());
        		sheet.addCell(escribir);
        		escribir = new jxl.write.Label(2, i, abuso.getMotivo());
        		sheet.addCell(escribir);
        		i++;
        	}
        	usuario ++;
        }
        
       for (Usuario u :bloqueados){
    		for (Abuso abuso : u.getListaReportes()){
        		escribir = new jxl.write.Label(0, i,Integer.toString(usuario));
        		sheet.addCell(escribir);
        		escribir = new jxl.write.Label(1, i,abuso.getUsuario().getNick());
        		sheet.addCell(escribir);
        		escribir = new jxl.write.Label(2, i, abuso.getMotivo());
        		sheet.addCell(escribir);
        		i++;
        	}
        	usuario ++;
        } 
       
        	
        sheet = workbook.getSheet(1);
        i=3;
        int idempresa = 0;
        cantidad = new jxl.write.Number(1,0,empresas.size());
        sheet.addCell(cantidad);
        
        for (Empresa empresa : empresas){
        
        	for (Calificacion cal : empresa.getCalificacion()){
        	escribir = new jxl.write.Label(0, i,Integer.toString(idempresa));
        	sheet.addCell(escribir);
        	escribir = new jxl.write.Label(1, i,empresa.getNombre());
        	sheet.addCell(escribir);
        	escribir = new jxl.write.Label(2, i,empresa.getCedulaJuridica());
        	sheet.addCell(escribir);
        	escribir = new jxl.write.Label(3, i,empresa.getCategoria());
        	sheet.addCell(escribir);
        	escribir = new jxl.write.Label(4, i,empresa.getDireccion().getPais());
        	sheet.addCell(escribir);
        	escribir = new jxl.write.Label(5, i,empresa.getDireccion().getProvincia());
        	sheet.addCell(escribir);
        	escribir = new jxl.write.Label(6, i,empresa.getDireccion().getCanton());
            sheet.addCell(escribir);
            escribir = new jxl.write.Label(7, i,empresa.getDireccion().getDistrito());
            sheet.addCell(escribir);
            escribir = new jxl.write.Label(8, i,empresa.getDireccion().getBarrio());
            sheet.addCell(escribir);
            escribir = new jxl.write.Label(9, i,Double.toString(cal.getCalificacion()));
            sheet.addCell(escribir);
            escribir = new jxl.write.Label(10, i,cal.getComentario());
            sheet.addCell(escribir);
            escribir = new jxl.write.Label(11, i,cal.getUsuario().getNick());
            sheet.addCell(escribir);
            i ++ ;
                	
        }
        	idempresa ++;
        	
        }
        
        sheet = workbook.getSheet(2);
        i=3;
        int idpersona = 0;
        for (RegistroPersona persona : personas){
        	Persona x = persona.getPersona();
        	
        	for (Calificacion cal : persona.getCalificacion()){
        	escribir = new jxl.write.Label(0, i,Integer.toString(idpersona));
        	sheet.addCell(escribir);
        	escribir = new jxl.write.Label(1, i,persona.getCategorias());
        	sheet.addCell(escribir);
        	escribir = new jxl.write.Label(2, i,x.getNombre());
        	sheet.addCell(escribir);
        	escribir = new jxl.write.Label(3, i,x.getPrimerApellido());
        	sheet.addCell(escribir);
        	escribir = new jxl.write.Label(4, i,x.getSegundoApellido());
        	sheet.addCell(escribir);
        	escribir = new jxl.write.Label(5, i,x.getGenero());
        	sheet.addCell(escribir);
        	escribir = new jxl.write.Label(6, i,Integer.toString(x.getFechaNacimiento().getAño()));
            sheet.addCell(escribir);
            escribir = new jxl.write.Label(7, i,Integer.toString(x.getFechaNacimiento().getMes()));
            sheet.addCell(escribir);
            escribir = new jxl.write.Label(8, i,Integer.toString(x.getFechaNacimiento().getDia()));
            sheet.addCell(escribir);
            escribir = new jxl.write.Label(9, i,(x.getInstitucion()));
            sheet.addCell(escribir);
            escribir = new jxl.write.Label(10, i,x.getCargo());
            sheet.addCell(escribir);
            escribir = new jxl.write.Label(11, i,Double.toString(cal.getCalificacion()));
            sheet.addCell(escribir);
            escribir = new jxl.write.Label(12, i,cal.getComentario());
            sheet.addCell(escribir);
            escribir = new jxl.write.Label(13, i,cal.getUsuario().getNick());
            sheet.addCell(escribir);
            i ++ ;
                	
        }
        	idpersona ++;
        	
        }
        


      

    
        workbook.write();



        workbook.close();
        }

    catch(Exception e)

    {

        System.out.println("writeExcel ->"+e);

    }
	
	}

	public void mostrarContrato() {
		   File archivo = null;
		      FileReader fr = null;
		      BufferedReader br = null;
		 String mostrar=" ";
		      try {
		         // Apertura del fichero y creacion de BufferedReader para poder
		         // hacer una lectura comoda (disponer del metodo readLine()).
		         archivo = new File ("Contrato.txt");
		         fr = new FileReader (archivo);
		         br = new BufferedReader(fr);
		 
		         // Lectura del fichero
		         String linea;
		         while((linea=br.readLine())!=null){
		            mostrar = mostrar + linea + "\n";
		      }
		      }
		      catch(Exception e){
		         e.printStackTrace();
		      }finally{
		         // En el finally cerramos el fichero, para asegurarnos
		         // que se cierra tanto si todo va bien como si salta 
		         // una excepcion.
		         try{                    
		            if( null != fr ){   
		               fr.close();     
		            }                  
		         }catch (Exception e2){ 
		            e2.printStackTrace();
		         }
		   Iterator notifyViews = vistas.iterator();
			
				while (notifyViews.hasNext()) {
		    		((Funciones) notifyViews.next()).contrato(mostrar);
		    	
	}
		
	}
	}
	public void rechazar() {
		   Iterator notifyViews = vistas.iterator();
			
					while (notifyViews.hasNext()) {
			    		((Funciones) notifyViews.next()).rechazar();
			    	
		}
		
	}
}
	



    		
    	
    	
    

	
    
		
		
		
	
	
	


