package aplicacion;

public class Administrador {
	//Atributos
	private String nick;
	private String password;
	private String nombre;
	
	
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
	
	

	public Administrador(String nick,String contraseña,String nombre) {
		setNick(nick);
		setPassword(contraseña);
		setNombre(nombre)	
		}


}
