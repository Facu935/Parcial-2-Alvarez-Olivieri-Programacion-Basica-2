package ar.edu.unlam.pb2.criaturas;

import java.util.ArrayList;
import java.util.List;

public class ConsejoDeElandria {
	private List<Maestro> maestros;
	
	public ConsejoDeElandria() {
		this.maestros = new ArrayList<>();	
	}
	
	public Integer getCantidadDeMaestrosRegistrados() {
		return this.maestros.size();
	}
	
	public void registrarMaestro(Maestro maestro) {
		this.maestros.add(maestro);
	}
	
	public List<ICriatura> obtenerTodasLasCriaturas(){
		List<ICriatura> todasLasCriaturas = new ArrayList<>();
		
		for(Maestro maestro : this.maestros) {
			todasLasCriaturas.addAll(maestro.getCriaturas());
		}
		
		return todasLasCriaturas;
	}

}
