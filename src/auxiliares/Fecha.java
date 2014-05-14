package auxiliares;
 
import java.util.*; //Librería para poder obtener la hora del sistema
public class Fecha {
	private int año;
	private int dia;
	private int mes;
	
	
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int calcularFecha(){
		//Método que obtiene la hora del sistema y realiza una resta con la fecha de cumpleaños
		Calendar actual = new GregorianCalendar(); //Crea un objeto calendar para poder obtener la hora
		int añoactual = actual.get(Calendar.YEAR);//Variable que almacena el año
		int mesactual=actual.get(Calendar.MONTH);//Variable que almacena el mes
		mesactual=mesactual+1;//Se le suma 1, porque va de 0 a 11
		int diaactual=actual.get(Calendar.DAY_OF_MONTH);//Variable que almacena el día actual
		int edad=añoactual-getAño();//Variable donde se almance la edad
		
		System.out.println(añoactual +" " + mesactual +" " +diaactual);
		if (mesactual<getMes()){ //Si todavía no ha llegado al mes entonces le resta uno a la edad
			edad=edad-1;
		}
		else{
				if (mesactual==getMes()){ //Si no es menor, va a asegurarse si es igual para guiarse por el día
					if (diaactual<getDia()){//Si el día en el que se encuentra es menor, le resta 1 a la edad
						edad=edad-1;
					}
				}
			
			}
			
	 return edad;
		
	}
	public Fecha(int año, int dia, int mes) {
		this.año = año;
		this.dia = dia;
		this.mes = mes;
	}
	

	
  
	
}
