package aplicacion;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import entidades.Empresa;
import entidades.RegistroPersona;

//Aquí va el nombre de todas las funciones
public interface Funciones {
	
	public void showEmpresa(DefaultComboBoxModel tipo);
	public void showPersona(DefaultListModel model,DefaultComboBoxModel tipo);
	public void IniciarEmpresa(Empresa empresa);
	public void IniciarPersona(RegistroPersona persona);
	public void llenarPersona(DefaultComboBoxModel tipo);
	public void llenarJuridica(DefaultComboBoxModel tipo);
	public void agregarlista(DefaultListModel nuevo);
}
