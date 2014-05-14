package auxiliares;

public class Persona {
	String cedula;
	String nombre;
	String PrimerApellido;
	String SegundoApellido;
	String genero;
	Fecha FechaNacimiento;
	int edad;
	String institucion;
	String cargo;
	float promedio;
	
	

	public String getCedula() {
		return cedula;
	}

    public void setCedula(String cedula) {
		this.cedula = cedula;
	}

    public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getPrimerApellido() {
		return PrimerApellido;
	}



	public void setPrimerApellido(String primerApellido) {
		PrimerApellido = primerApellido;
	}



	public String getSegundoApellido() {
		return SegundoApellido;
	}



	public void setSegundoApellido(String segundoApellido) {
		SegundoApellido = segundoApellido;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public Fecha getFechaNacimiento() {
		return FechaNacimiento;
	}



	public void setFechaNacimiento(Fecha fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}



	public int getEdad() {
		return edad;
	}



	public void setEdad(int edad) {
		this.edad = edad;
	}



	public String getInstitucion() {
		return institucion;
	}



	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}



	public String getCargo() {
		return cargo;
	}



	public void setCargo(String cargo) {
		this.cargo = cargo;
	}



	public float getPromedio() {
		return promedio;
	}



	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}

	public Persona(String cedula, String nombre, String primerApellido,
			String segundoApellido, String genero, Fecha fechaNacimiento,
			int edad, String institucion, String cargo, float promedio) {
	
		this.cedula = cedula;
		this.nombre = nombre;
		PrimerApellido = primerApellido;
		SegundoApellido = segundoApellido;
		this.genero = genero;
		FechaNacimiento = fechaNacimiento;
		setEdad(FechaNacimiento.calcularFecha());
		this.institucion = institucion;
		this.cargo = cargo;
		this.promedio = promedio;
	}



	

}
