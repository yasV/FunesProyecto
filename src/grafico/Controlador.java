package grafico;

import aplicacion.Sistema;
import auxiliares.Direccion;
import auxiliares.Fecha;
import auxiliares.Persona;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import entidades.Empresa;
import entidades.RegistroPersona;

public class Controlador implements ActionListener {
	private Sistema modelo;
	private Usuario view_Usuario;
	private Administrador view_Administrador;
		
	public Controlador(Sistema p){
		modelo = p;
	}
	public void C_Usuario(Usuario u){
		view_Usuario = u;
	}

	public void C_Administrador( Administrador Ad ){
		view_Administrador = Ad;
	}

	
	@Override
	public void actionPerformed(ActionEvent evt) {
		 Object source = evt.getSource();
		
//----------------------Acciones de  Usuario------------------------------------------------ 
		//++++++++++++++++++++++ Consultar +++++++++++++++++++++++++++++++++++++++++
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
			 
			 if (source==view_Usuario.rdbtnFsicaConsultar){
				    modelo.busquedaPersona();
			}
			 

			 if (source==view_Usuario.rdbtnJurdicasConsultar){
	                   modelo.busquedaJuridica();
			}
			 
			 if(source == view_Usuario.getCmbTipoBusqueda()){
				 modelo.mostrarInfo();
			 }

	}
	
	public void actionPerformed1(ActionEvent evt) {
		 Object source = evt.getSource();
		
//----------------------Acciones de  Administrador------------------------------------------------ 
		//++++++++++++++++++++++ ver usuario, bloquer,desbloquear +++++++++++++++++++++++++++++++++++++++++
		 
		 		 
		 if (source == view_Administrador.getBtnVerUsuarios()){
			 modelo.showPersona();
			 }
		 if (source == view_Administrador.getBtnBloquear()){
			 
			 }
		 if (source == view_Administrador.getBtnDesbloquear()){
			
			 }
		 
		 	}
}
