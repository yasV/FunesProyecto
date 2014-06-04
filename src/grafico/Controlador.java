package grafico;

import aplicacion.Funciones;
import aplicacion.Sistema;
import auxiliares.Calificacion;
import auxiliares.Direccion;
import auxiliares.Fecha;
import auxiliares.Persona;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import java.io.IOException;

import javax.swing.JOptionPane;

import entidades.Empresa;
import entidades.Registro;
import entidades.RegistroPersona;

public class Controlador implements ActionListener {
	private Sistema modelo;
	private Funciones view;
	private Usuario view_Usuario;
	private Administrador view_Administrador;
	private Login view_Login;
	private Informacion view_Informacion;
	private Calificacion view_Calificacion;
	private VUsuario view_VUsuario;
	
	
	public Controlador(Sistema p){
	modelo = p;
	}
	
	public void C_Usuario(Usuario u){
		view_Usuario = u;
	}
	public void C_Login(Login u){
		view_Login = u;
	}
	public void C_Administrador(Administrador u){
		view_Administrador = u;
	}
	public void C_Informacion(Informacion u){
		view_Informacion = u;
	}
	public void C_Calificacion(Calificacion u){
		view_Calificacion = u;
	}
	public void C_VUsuario (VUsuario u){
		view_VUsuario=u;
	}
	@Override
	public void actionPerformed(ActionEvent evt) {
		 Object source = evt.getSource();
		 
//----------------Acciones de Login-----------------------------------------
		
		 //+++++++++++++++++++++++++Principal++++++++++++++++++++++
		 if (source == view_Login.getbtnIniciarSesin()){
			 modelo.iniciarSesion(view_Login.txtusuario.getText(),view_Login.passwordField.getText());

		 }
		 if (source == view_Login.getbtnRegistroUsuario()){
			 modelo.showRegistro();
		 }
		 
		 //+++++++++++++++++++++++++Registro+++++++++++++++++++++++++++
		 if(source== view_Login.getbtnRegistrarse()){
			 String nombre = view_Login.txtnombre.getText() + " "+ view_Login.txtPrimerApellido.getText()+" "+view_Login.txtSegundoApellido.getText();
			 String privacidad = " ";
			 if (view_Login.rdbtnDatosPblicos.isSelected()){
				 privacidad = "Publico";
			 }
			 if (view_Login.rdbtnDatosPrivados.isSelected()){
				 privacidad="Privado";
			 }
			 modelo.Registrarse(nombre, view_Login.txtNick.getText(), view_Login.passwordField_1.getText(), privacidad);
		 }
		
//----------------------Acciones de  Usuario------------------------------------------------
		 //+++++++++++++Principal+++++++++++++++++++++++++++++++++++++++++++++++++++
		 if (source == view_Usuario.btnEliminarCuenta){
			 modelo.EliminarCuenta ();
		 }
		 
		 //+++++++++++++Calificar++++++++++++++++++++++++++++++++++++++++++++++++++
		 if (source == view_Usuario.getBtnA()){
			 modelo.Refreshlistregistro(view_Usuario.txtmás.getText());
		}
		 
		 if (source == view_Usuario.getBtnusuarioNoRegistrado()){
			 if (view_Usuario.rdbtnFisicaCalificar.isSelected()){
				 modelo.registro("Persona");
				 modelo.showPersona();
				 
			 }
			 if (view_Usuario.rdbtnJuridicaCalificar.isSelected()){
				 modelo.registro("Empresa");
				 modelo.showEmpresa();
			 }
		}
			 
		 if (source == view_Usuario.btnRegistrarJuridica){
			 //Selecciona la categoría según lo que el usuario haya escogido
			 boolean seguir=true; //Informar en caso de error 
			 String categoria = " ";
			 if (view_Usuario.rdbtnSenasa.isSelected()){
				 categoria="Senasa";
			 }
				 
			 if (view_Usuario.rdbtnCondominios.isSelected()){
				 categoria="Condominios";
			 }
				 
			 if (view_Usuario.rdbtnEmpresas.isSelected()){
				 categoria="Empresas";
			 }
				 
			 if (view_Usuario.rdbtnPani.isSelected()){
				 categoria="PANI";
			 }
				 
			 if (view_Usuario.rdbtnRestaurante.isSelected()){
				 categoria="Restaurantes";
			 }
				
			//Crea una provincia según la opción seleccionada en el combobox
			 //Crear una variable direccion con todos los datos
			 //utilizando la variable registro creada arriba y que ya contiene los datos según el factory, va agregar los datos de la empresa
			 String provincia = (String) view_Usuario.cboxprovincia.getSelectedItem();
			 Direccion agregar = modelo.crearDireccion(view_Usuario.txtpais.getText(),provincia,view_Usuario.txtcanton.getText(), view_Usuario.txtdistrito.getText(),view_Usuario.txtbarrio.getText());
			 if (agregar!=null){
				 modelo.registro = modelo.crearempresa(view_Usuario.txtnombrejuri.getText(), view_Usuario.txtcedulajuri.getText(), categoria, agregar);
				 if (modelo.registro!=null){
					 modelo.showCalifiEmpresa((Empresa) modelo.registro); //mandar a llamar a calificar con los datos de registro que corresponde a una empresa.
				 }
			 }
		 }
		 
		 //Registra una persona fisica
		 if (source==view_Usuario.btnConsultar){
			modelo.buscarenregistro(view_Usuario.txtcedula.getText());
		 }
		 
		 if (source==view_Usuario.getBtnRegistrar_1()){
			 String mes = (String) view_Usuario.cboxmes.getSelectedItem();
			 Fecha nueva = modelo.crearfecha(view_Usuario.txtdia.getText(),mes, view_Usuario.txtaño.getText());
			 if (nueva!=null){
				 String genero = " ";
				 if (view_Usuario.rdbtnFemenino.isSelected()){
					 genero = "Femenino";
				}
				if (view_Usuario.rdbtnMasculino.isSelected()){
					genero="Masculino";
				}
				Persona p = modelo.crearpersona(view_Usuario.txtnombre.getText(), view_Usuario.txtprimero.getText(),
						view_Usuario.txtSApellido.getText(), genero, view_Usuario.txtcedula.getText(), view_Usuario.txtinstitucion.getText(), 
						view_Usuario.txtcargo.getText(), nueva);
				if (p!=null){
					String categoria = (String)view_Usuario.list.getSelectedValue();
					modelo.registro = modelo.registrarpersona(p, categoria);
					if (modelo.registro!=null){
						modelo.showCalifiPersona((RegistroPersona)modelo.registro);
					}
				}
			 }
		 }
		 

		//+++++++++++++Consultar++++++++++++++++++++++++++++++++++++++++++++++++++
			 if (source==view_Usuario.rdbtnFsicaConsultar){
			       modelo.busquedaPersona();
			  }
			     
			 if (source==view_Usuario.rdbtnJurdicasConsultar){
				 modelo.busquedaJuridica();
			  }
			 
			 //Se agregó la función al boton de eliminar para que elimine las notas
			 if(source==view_Usuario.btnEliminar){
				 int tipo=1;
				 if(view_Usuario.rdbtnJurdicasConsultar.isSelected()){
					 tipo=0;
				 }
				 String persona=(String)view_Usuario.listaconsultar.getSelectedValue();
				 String coment= view_Usuario.txtComment.getText();
				 String usuario=view_Usuario.txtUsuarioComment.getText();
				 modelo.BuscarNotas(persona,tipo,coment);
				// modelo.EliminarNotaElegida(coment,usuario,tipo);
			 }
			 
			 ///Busca el usuario a consultar
			 if (source == view_Usuario.btnVerInformacin){
				 int dato =  view_Usuario.listaconsultar.getSelectedIndex();
				 if (view_Usuario.rdbtnFsicaConsultar.isSelected()){
					modelo.mostrarinformacion(0, dato); 
				 }
				 else{
					 modelo.mostrarinformacion(1, dato); 
				 }
			 }
			 
			 if (source == view_Usuario.btnVerComentarios){
				 int dato = view_Usuario.listaconsultar.getSelectedIndex();
				 int tipo=0 ;
				 if ( view_Usuario.rdbtnFsicaConsultar.isSelected()){
					 tipo =1;
				 }
				 modelo.iniciarcomentarios(dato,tipo);
					 
				 
			 }
			 if (source == view_Usuario.btnAnterior){
				 modelo.mostrarcomentarios(0);
			 }
			 if (source == view_Usuario.btnSiguiente){
				 modelo.mostrarcomentarios(1);
			 }
			 if (source == view_Usuario.btnVerInformacinDel){
				 modelo.verInfo(view_Usuario.txtUsuarioComment.getText());
			 }
			 if(source == view_Usuario.getBtnBuscarConsultar()){
				 String tipo=(String)view_Usuario.getCmbTipoBusqueda().getSelectedItem();
				 String tipAbuscar= view_Usuario.datobuscarConsultar.getText();
				
				 if(view_Usuario.rdbtnFsicaConsultar.isSelected()){
					 int lista=1;
					 if(view_Usuario.getCmbTipoBusqueda().getSelectedItem() != null){
						 if(tipo.equals("Nombre")){
							 modelo.buscarNombre(tipAbuscar, lista,true);
							 modelo.llenarresultados(1);
						 }
						 if(tipo.equals("Cédula")){
							 modelo.buscarcedula(tipAbuscar, lista,true);
							 modelo.llenarresultados(1);
						 }
						 if(tipo.equals("Primer Apellido")){
							 modelo.buscarApellido(tipAbuscar,1,true);
							 modelo.llenarresultados(1);
						 }
						 if(tipo.equals("Segundo Apellido")){
							 modelo.buscarApellido(tipAbuscar,2,true);
							 modelo.llenarresultados(1);
						 }
						 if(tipo.equals("Categoría")){
							 modelo.buscarcategoria(tipAbuscar, lista,true);
							 modelo.llenarresultados(1);
						 }
					 }
				 }
				 
				 if(view_Usuario.rdbtnJurdicasConsultar.isSelected()){
					 int lista=0;
					 if(view_Usuario.getCmbTipoBusqueda().getSelectedItem() != null){
						 if(tipo.equals("Nombre")){
							 modelo.buscarNombre(tipAbuscar, lista, true);
							 modelo.llenarresultados(0);
						 }
						 if(tipo.equals("Cédula")){
							 modelo.buscarcedula(tipAbuscar, lista,true);
							 modelo.llenarresultados(0);
						 }
						 if(tipo.equals("Categoría")){
							 modelo.buscarcategoria(tipAbuscar, lista,true);
							 modelo.llenarresultados(0);
						 }
					 }
				 }
				 
			 }
			 
			//+++++++++++++Calificar ++++++++++++++++++++++++++++++++++++++++++++++++++
			 
			 //Rellena el comboBox 
			 if (source==view_Usuario.rdbtnFisicaCalificar){
			       modelo.busquedaCalificar(1);
			  }
			     
			 if (source==view_Usuario.rdbtnJuridicaCalificar){
				 modelo.busquedaCalificar(0);
			  }
			 
			 //Sobre la calificación
			 if (source == view_Usuario.estrella1){
				 modelo.marcarEstrellas(0);
			 }
			 if (source == view_Usuario.estrella2){
				 modelo.marcarEstrellas(1);
			 }
			 if (source == view_Usuario.estrella3){
				 modelo.marcarEstrellas(2);
			 }
			 if (source == view_Usuario.estrella4){
				 modelo.marcarEstrellas(3);
			 }
			 if (source == view_Usuario.estrella5){
				 modelo.marcarEstrellas(4);
			 }
			 if (source == view_Usuario.estrella6){
				 modelo.marcarEstrellas(5);
				
			 }
			 if (source == view_Usuario.estrella7){
				 modelo.marcarEstrellas(6);
			 }
			 if (source == view_Usuario.estrella8){
				 modelo.marcarEstrellas(7);
			 }
			 if (source == view_Usuario.estrella9){
				 modelo.marcarEstrellas(8);
			 }
			 if (source == view_Usuario.estrella10){
				 modelo.marcarEstrellas(9);
			 }
			 
			 
			 //Sube evidencia
			 if(source==view_Usuario.getBtnSubirEvidencia()){
					modelo.cargarEvidencia();
			 }
			 
			 //Guarda calificación
			 if(source== view_Usuario.getBtnGuardarCalificacion()){
				 Registro mandar;
				 int tipo=0; //si es falso es una persona Juridica
				 boolean tipoPersona=view_Usuario.rdbtnFisicaCalificar.isSelected();
				 if(tipoPersona){
					 tipo=1;
					 mandar = view_Usuario.persona;
				 }
				 else{
					 tipo=0;
					 mandar = view_Usuario.empresa;
				 } 
				 String demandante= view_Login.txtusuario.getText();
				 String demandado=(String)view_Usuario.getCmbPersonaCalificar().getSelectedItem();
				 
				 String review= view_Usuario.txtRegistroReview.getText();
				 String evidencia= view_Usuario.lblNdevidencia.getText();
				 String nombre = view_Usuario.lblnombre.getText();
				 modelo.guardarCalificacion(mandar,tipo,demandado,review,evidencia,demandante,nombre);
			 }
			 //*//----------------------------Acciones sobre ver usuario--------------------------------
			 //Si el boton escogigo es reportar el sistema llamara a la función en modelo llamado reportar.
			 //Donde crea un abuso y se lo asigna al usuario correspondiente
			 if (source == view_VUsuario.btnreportar){
				modelo.llenarreporte(view_VUsuario.editorPane.getText(),view_VUsuario.lblnick.getText()); 
			 }
	}

	public void C_Calificacion(calificar calificar) {
		// TODO Auto-generated method stub
		
	}

}




