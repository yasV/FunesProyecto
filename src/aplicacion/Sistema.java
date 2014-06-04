package aplicacion;


import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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

import auxiliares.Calificacion;
import auxiliares.Direccion;
import auxiliares.Fecha;
import auxiliares.Persona;
import entidades.Empresa;
import entidades.Factory;
import entidades.Registro;
import entidades.RegistroPersona;
import grafico.VUsuario;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Sistema {
	//Atributos
	private static Usuario usuario; //Variable para manejar el usuario con el que se esta trabajando
	private static ArrayList<Usuario> listaUsuarios;
	private static ArrayList<Usuario> bloqueados;
	private static ArrayList<Empresa> empresas;
	private static ArrayList <RegistroPersona> personas;
	private static ArrayList <Integer>estrellas = new ArrayList();
	private static ArrayList <String> ordenado= new ArrayList();		//para ordenar alfabéticamente
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
            System.out.println("readExcel ->"+e); 
        }
	}
	public void finalizar (){
	        String cellData = new String();

	        try{

	            Workbook target_workbook = Workbook.getWorkbook(new File("Datos.xls"));
	            WritableWorkbook workbook = Workbook.createWorkbook(new File("Datos.xls"), target_workbook);
	            target_workbook.close();
	            WritableSheet sheet = workbook.getSheet(0);
	            jxl.write.Number number = new jxl.write.Number(1,0,cantidadUsuarios);
	            sheet.addCell(number);
	            int i=2;
	            for (Usuario u : listaUsuarios){
	            	System.out.println(u.getNick());
	            	jxl.write.Label escribir = new jxl.write.Label(0, i, u.getNick());
	            	sheet.addCell(escribir);
	            	escribir =new jxl.write.Label(1, i, u.getNombre());
	            	sheet.addCell(escribir);
	            	escribir =new jxl.write.Label(2, i, u.getPassword());
	            	sheet.addCell(escribir);
	            	escribir =new jxl.write.Label(4, i, "Normal");
	            	sheet.addCell(escribir);
	            	jxl.write.Boolean privado = new jxl.write.Boolean(3, i, u.isPrivado());
	            	sheet.addCell(privado);
	            	i++;
	            }
	            i=2;
	            for (Usuario u : bloqueados){
	            	System.out.println(u.getNick());
	            	jxl.write.Label escribir = new jxl.write.Label(0, i, u.getNick());
	            	sheet.addCell(escribir);
	            	escribir =new jxl.write.Label(1, i, u.getNombre());
	            	sheet.addCell(escribir);
	            	escribir =new jxl.write.Label(2, i, u.getPassword());
	            	sheet.addCell(escribir);
	            	escribir =new jxl.write.Label(4, i, "Bloqueado");
	            	sheet.addCell(escribir);
	            	jxl.write.Boolean privado = new jxl.write.Boolean(3, i, u.isPrivado());
	            	sheet.addCell(privado);
	            	i++;
	            }
	            workbook.write();
	            workbook.close();

	        }

	        catch(Exception e){
	            System.out.println("writeExcel ->"+e);
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
		/*Cremos un ArrayList cate para que contenga todas las categorías que existen hasta el momento para la persona fisíca
		 * esto con el fin de poder buscar más facilmente si la cateforía que se quiere agregar ya existe*/
		ArrayList<String> cate= new ArrayList();
		for(RegistroPersona cat: personas){
			cate.add(cat.getCategorias());
		}
		if(!cate.contains(nueva)){
			lista.addElement(nueva);
			Iterator notifyViews = vistas.iterator();
		   	 while (notifyViews.hasNext()) {
		   		 ((Funciones) notifyViews.next()).agregarlista(lista);
		   	}
		}
		else{
			JOptionPane.showMessageDialog(null, "La categoría ingresada ya existe", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
		}
	 	
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
    	for (int i=0;i<10;i++){
    		estrellas.add(i,0);
    	}
    	
    	///variable para controlar 
    	boolean control=false;
    	for (Usuario u :listaUsuarios ){
    	//Recorre toda la lista comparando que nombre y contraseña sean exactamente iguales. Si encuentra concidencia. Muestra un mensaje de error
    		if (u.getNick().equals(nick)&&u.getPassword().equals(password)){
    			usuario = u;
    			showUsuario();
    			control=true; //Cambia el valor de control
    			break;//Rompe el ciclo
    		}
    	}
    	if (!control){ //Si control no cambia, quiere decir que hay un error, asi que mostrara el mensaje
    		JOptionPane.showMessageDialog(null, "No se encuentra en el sistema o algún dato esta erróneo", "Problemas de Registro", JOptionPane.ERROR_MESSAGE);
    	}
     }
    
    public void Registrarse (String nombre,String nick,String contraseña,String privacidad){
    	if (nombre.isEmpty()||nick.isEmpty()||contraseña.isEmpty()||privacidad.isEmpty()){
    		JOptionPane.showMessageDialog(null, "Por favor, asegúrese que no quedé ningún campo vacío", "Campos vacíos", JOptionPane.ERROR_MESSAGE);
    	}
    	else{
    		boolean control = false;
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
    	//Este método ordena alfabéticamente la lista de categorías y la ingresa a la lista en el interfaz
    	ordenado.removeAll(ordenado);
    	for (RegistroPersona u : personas){
    		ordenado.add(u.getCategorias());
    	}
    	Collections.sort(ordenado);
    	for(String ord: ordenado){
    		lista.addElement(ord);
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
    	DefaultComboBoxModel tipo= modelo("Jurídica");
    	Iterator notifyViews = vistas.iterator();
    	while (notifyViews.hasNext()) {
            ((Funciones) notifyViews.next()).llenarJuridica(tipo);
        }
    }
    
    //Este método se encargara de llenar el comboBox dependiendo del tipo de Busqueda a realizar
    private DefaultComboBoxModel modelo(String tipo){
    	DefaultComboBoxModel tipoBusq= new DefaultComboBoxModel();
    	tipoBusq.addElement("--");
    	if (tipo.equals("Física")){
    		tipoBusq.addElement("Categoría");
    		tipoBusq.addElement("Cédula");
    		tipoBusq.addElement("Nombre");
    		tipoBusq.addElement("Primer Apellido");
    		tipoBusq.addElement("Segundo Apellido");
    		
    	}
    	else{
    		tipoBusq.addElement("Categoría");
        	tipoBusq.addElement("Cédula Jurídica");
        	tipoBusq.addElement("Nombre");
    	}
    	return tipoBusq;
    }
    
    ///Llena el comboBox de la pantalla de calificar dependiendo de la opción seleccionada
    public void busquedaCalificar(int opcion){
    	/*Se limpia la lista ordenado para así agregarle los valores a ordenar*/
    	ordenado.removeAll(ordenado);
    	model.removeAllElements();
    	model.addElement("--");
    	if(opcion==0){
    		for(Empresa u: empresas){
    			ordenado.add(u.getNombre());
    		}
    		Collections.sort(ordenado);
    		for(String ord: ordenado){
    			model.addElement(ord);
    		}
    	}
    	else{
    		for(RegistroPersona u:personas){
    			ordenado.add(u.getPersona().getNombre()+u.getPersona().getPrimerApellido()+u.getPersona().getSegundoApellido());
    		}
    		Collections.sort(ordenado);
    		for(String ord: ordenado){
    			model.addElement(ord);
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
    
    //Guarda la calificación
    public void guardarCalificacion(Registro agregar,int tipo,String demandado,String review,String evidencia,String demandante,String nombre){
    	//Si es una persona física
    	if ( demandado.isEmpty()||review.isEmpty()||evidencia.isEmpty()||demandante.isEmpty()||nombre.isEmpty()){
    		JOptionPane.showMessageDialog(null, "No puede haber ningún campo vácio y debe de subir algún documento para realizar la calificación", "Formulario incompleto", JOptionPane.ERROR_MESSAGE);
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
    				for(RegistroPersona u:personas){	//Buscamos el demandado para asignarle la calificación
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
    		for(Empresa u:empresas){	//Buscamos el demandado para asignarle la calificación
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
    			if (comparar.equals(apellido)){
    				
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
    	/*La lista encontrada se ordenará antes de ser mostrada*/
    	ordenado.removeAll(ordenado);
   	 	Iterator notifyViews = vistas.iterator();
    	lista.removeAllElements();
    	if (busqueda == 0){
    		if (empresasbuscadas.isEmpty()){
				JOptionPane.showMessageDialog(null, "No se han encontrado los datos","Resultado de búsqueda", JOptionPane.ERROR_MESSAGE);
			}
    		else{
    			for (Empresa u : empresasbuscadas){
    				ordenado.add(u.getNombre());
    			}
    			Collections.sort(ordenado);
    			for(String ord: ordenado){
    				lista.addElement(ord);
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
    				ordenado.add(u.getPersona().getNombre()+" "+u.getPersona().getPrimerApellido()+" "+u.getPersona().getSegundoApellido());
    			}
    			Collections.sort(ordenado);
    			for(String ord: ordenado){
    				lista.addElement(ord);
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
		//Operación sirve para decidir cual comentario se va a mostrar
		System.out.println(contador);
		System.out.println(calificacion.size());
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
	 		// this.finalizar();
	 		 eliminarnotas();
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
				}
			}
		}
		
		for (RegistroPersona p : personas){
			for (Calificacion cal:p.getCalificacion()){
				
				if (cal.getUsuario()==usuario){
					p.getCalificacion().remove(cal);
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
		for (Usuario u :listaUsuarios){
			for (Usuario y : bloqueados){	
				if (u.getNombre().equals(nick ) || y.getNombre().equals(nick )){
					VUsuario vista = new VUsuario();
					vista.llenardatos (u);
				}
			}
		}
	}
	
	public void BuscarNotas(String persona,int tipo,String coment){
		
		if(tipo==1){
		for(RegistroPersona u: personas){
			if((u.getPersona().getNombre()+" "+u.getPersona().getPrimerApellido()+" "+u.getPersona().getSegundoApellido()).equals(persona)){
					for(RegistroPersona y: personasbuscadas){
						if((y.getPersona().getNombre()+" "+y.getPersona().getPrimerApellido()+" "+y.getPersona().getSegundoApellido()).equals(persona)){
							System.out.print(persona+"\n");
							for(Calificacion cal: y.getCalificacion()){
								if(cal.getComentario().equals(coment)&&cal.getUsuario().equals(usuario)){
									u.getCalificacion().indexOf(cal);
									System.out.print(u.getCalificacion().indexOf(cal)+"\n");
							}
							EliminarNotaElegida(u.getCalificacion(),coment);
						}
				}
				
			}//for
		}}}
	}
	
	public void EliminarNotaElegida(ArrayList<Calificacion> calif,String coment){
		for(Calificacion cal: calif){	//obtenemos calificación
			if(cal.getComentario().equals(coment)&&cal.getUsuario().equals(usuario)){
				calif.indexOf(cal);
				System.out.print(calif.indexOf(cal)+"\n");
				System.out.print(cal.getDemandado()+"\n");
				}	
		}
	}
}
    		
    	
    	
    

	
    
		
		
		
	
	
	


