package auxiliares;
 
import java.util.*; //Librer�a para poder obtener la hora del sistema
public class Fecha {
	private int a�o;
	private int dia;
	private int mes;
	
	
	public int getA�o() {
		return a�o;
	}
	public void setA�o(int a�o) {
		this.a�o = a�o;
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
		//M�todo que obtiene la hora del sistema y realiza una resta con la fecha de cumplea�os
		Calendar actual = new GregorianCalendar(); //Crea un objeto calendar para poder obtener la hora
		int a�oactual = actual.get(Calendar.YEAR);//Variable que almacena el a�o
		int mesactual=actual.get(Calendar.MONTH);//Variable que almacena el mes
		mesactual=mesactual+1;//Se le suma 1, porque va de 0 a 11
		int diaactual=actual.get(Calendar.DAY_OF_MONTH);//Variable que almacena el d�a actual
		int edad=a�oactual-getA�o();//Variable donde se almance la edad
		
		System.out.println(a�oactual +" " + mesactual +" " +diaactual);
		if (mesactual<getMes()){ //Si todav�a no ha llegado al mes entonces le resta uno a la edad
			edad=edad-1;
		}
		else{
				if (mesactual==getMes()){ //Si no es menor, va a asegurarse si es igual para guiarse por el d�a
					if (diaactual<getDia()){//Si el d�a en el que se encuentra es menor, le resta 1 a la edad
						edad=edad-1;
					}
				}
			
			}
			
	 return edad;
		
	}
	public Fecha(int a�o, int dia, int mes) {
		this.a�o = a�o;
		this.dia = dia;
		this.mes = mes;
	}
	

	
  
	
}
