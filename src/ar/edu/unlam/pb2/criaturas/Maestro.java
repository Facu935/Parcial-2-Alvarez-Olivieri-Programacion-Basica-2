package ar.edu.unlam.pb2.criaturas;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Maestro {

	private String nombre;
	private Integer maestria;
	private Afinidades afinidad;
	private Map <String, ICriatura> criaturasACargo = new HashMap<>();
	

	public Maestro(String nombre, Integer maestria, Afinidades afinidad) {
		this.nombre = nombre;
		this.maestria = maestria;
		validarMaestria();
		this.afinidad = afinidad;
	}


	public void validarMaestria() {
		if (this.maestria <= 0) {
			this.maestria = 1;
		}
		if (this.maestria > 50) {
			this.maestria = 50;
		}
	}

	
	public void aumentarMaestria() {
		this.maestria += 1;
		
		if (this.maestria >= 50) {
			this.maestria = 50;
		}
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
	
	public Collection<ICriatura> getCriaturas(){
		return this.criaturasACargo.values();
	}

	public void añadirCriaturaAColeccion(ICriatura criaturaDomesticada) {
		criaturasACargo.put(criaturaDomesticada.getNombre(), criaturaDomesticada);
	}


	public Integer cantidadDeCriaturasADisposicion() {
		return criaturasACargo.size();
	}

	public ICriatura obtenerCriatura(String nombreCriatura) {
		return this.criaturasACargo.get(nombreCriatura);
	}

	public void entrenarCriatura(ICriatura criatura, Integer energiaAAumentar) throws MaximoDeEnergiaAlcanzadoException, FaltaDeMaestriaException, EnergiaAcabadaException {
        if (this.maestria >= 25) {
            criatura.entrenar(energiaAAumentar); 
        } else {
            throw new FaltaDeMaestriaException("Al Maestro le falta maestria...");
        }
    }

	public void pacificarCriatura(ICriatura criaturaAPacificar) throws CriaturaYaPacificadaException{
			criaturaAPacificar.sePacifica();
		
	}

	public void transformarCriatura(ICriatura criaturaOriginal, ICriatura criaturaYaTransformada) {
		criaturasACargo.put(criaturaOriginal.getNombre(), criaturaYaTransformada);
	}


}
