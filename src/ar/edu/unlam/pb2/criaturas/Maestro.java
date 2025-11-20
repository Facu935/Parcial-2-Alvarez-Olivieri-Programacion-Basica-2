package ar.edu.unlam.pb2.criaturas;

import java.util.HashMap;
import java.util.Map;
 
public class Maestro {

	private String nombre;
	private Integer maestria;
	private Afinidades afinidad;
	private Map <String, Criatura> criaturasACargo = new HashMap<>();
	

	public Maestro(String nombre, Integer maestria, Afinidades afinidad) {
		this.nombre = nombre;
		this.maestria = maestria;
		this.afinidad = afinidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Integer getMaestria() {
		return this.maestria;
	}

	public Afinidades getAfinidad() {
		return this.afinidad;
	}

	public void añadirCriaturaAColeccion(Criatura criaturaDomesticada) {
		criaturasACargo.put(criaturaDomesticada.getNombre(), criaturaDomesticada);
		
	}
	
	public Integer cantidadDeCriaturasADisposicion() {
		return criaturasACargo.size();
	}

	public Criatura obtenerCriatura(Criatura criatura) {
		return criaturasACargo.get(criatura.getNombre());
	}

	public void entrenarCriatura(Criatura criatura, Integer energiaAumentada) throws MaximoDeEnergiaAlcanzadoException {
		//Meter que entrene si es que esta en la coleccion
		criatura.aumentarEnergia(energiaAumentada);
		//O capear Energia en 200 para todos, menos Salvaje
	}




	

}
