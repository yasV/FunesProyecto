package aplicacion;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import auxiliares.Calificacion;
import entidades.Empresa;
import entidades.RegistroPersona;


//Aquí va el nombre de todas las funciones
public interface Funciones {
	public void IniciarUsuario(Usuario usuario,DefaultListModel abusos);
	public void showEmpresa(DefaultComboBoxModel tipo);
	public void showPersona(DefaultListModel model,DefaultComboBoxModel tipo);
	public void showRegistro();
	public void IniciarEmpresa(Empresa empresa);
	public void IniciarPersona(RegistroPersona persona);
	public void llenarPersona(DefaultComboBoxModel tipo,DefaultListModel todo);
	public void llenarJuridica(DefaultComboBoxModel tipo,DefaultListModel todo);
	public void agregarlista(DefaultListModel nuevo);
	public void llenarDatosRegistro(DefaultListModel datos);
	public void mostrarVentanaEvidencia(String nombre, String pathArchivo);
	public void datosencontrados (String genero,String nombre,String primero,String segundo);
	public void actualizarestrella(int estrella, boolean estado);
	public void mostrarresultados (DefaultListModel x);
	public void actualizarInformacionEmpresa(Empresa mostrar);
	public void actualizarInformacionPersona(RegistroPersona mostrar);
	public void Icomentarios (Calificacion n,Usuario usuario);
	public void CuentaEliminada ();
	public void iniciaradministrador(DefaultListModel normal,DefaultListModel bloqueados,DefaultListModel empresas, DefaultListModel personas);
	public void actualizarlista(DefaultListModel actualizada,DefaultListModel actualizar ,int tipo);
	public void modificarempresa(Empresa empresa);
	public void modificarpersona(RegistroPersona persona, DefaultComboBoxModel mes , DefaultListModel categoria);
	public void llenardatos(Usuario u) ;
	public void mostrarabusos(Date fechaDenuncia, String motivo);
	public void showusercalification(DefaultListModel propias);
	public void mostrarsuscomentarios(Calificacion mandar);
	public void asignarcalificar(String nombre);
	public void nuevacalificacion(String selectedValue, int tipo, boolean b);
	public void reemplazarcalificacion(String selectedValue, int tipo,
			Calificacion cal, boolean b);
	public void mostrarDatosUsuario(Usuario u);
	public void contrato (String contrato);
	public void rechazar();


	
}
