package aplicacion;

public class Administrador {
	//Atributos
	private String nick;
	private String password;
	private String nombre;
	
	//This is a test
	
	
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

	public Administrador(String nick,String contraseņa,String nombre) {
		setNick(nick);
		setPassword(contraseņa);
		setNombre(nombre);	
		}


}
