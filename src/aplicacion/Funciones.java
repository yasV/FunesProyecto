package aplicacion;

import java.io.File;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import auxiliares.Calificacion;
import entidades.Empresa;
import entidades.RegistroPersona;


//Aquí va el nombre de todas las funciones
public interface Funciones {
	public void IniciarUsuario(Usuario usuario);
	public void showEmpresa(DefaultComboBoxModel tipo);
	public void showPersona(DefaultListModel model,DefaultComboBoxModel tipo);
	public void showRegistro();
	public void IniciarEmpresa(Empresa empresa);
	public void IniciarPersona(RegistroPersona persona);
	public void llenarPersona(DefaultComboBoxModel tipo);
	public void llenarJuridica(DefaultComboBoxModel tipo);
	public void agregarlista(DefaultListModel nuevo);
	public void llenarDatosRegistro(DefaultListModel datos);
	public void llenarcmbCalificar(DefaultComboBoxModel model);
	public void mostrarVentanaEvidencia(String nombre, String pathArchivo);
	public void datosencontrados (String genero,String nombre,String primero,String segundo);
	public void actualizarestrella(int estrella, boolean estado);
	public void mostrarresultados (DefaultListModel x);
	public void actualizarInformacionEmpresa(Empresa mostrar);
	public void actualizarInformacionPersona(RegistroPersona mostrar);
	public void Icomentarios (Calificacion n,Usuario usuario);
	public void CuentaEliminada ();
	public void EliminarNotas();

	
}
