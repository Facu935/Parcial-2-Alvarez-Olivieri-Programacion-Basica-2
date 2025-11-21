package ar.edu.unlam.pb2.criaturas;

import java.util.HashMap;
import java.util.Map;

public class Maestro {

	private String nombre;
	private Integer maestria;
	private Afinidades afinidad;
	private Map<String, CriaturaElemental> criaturasACargo = new HashMap<>();

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

	public void añadirCriaturaAColeccion(CriaturaElemental criaturaDomesticada) {
		criaturasACargo.put(criaturaDomesticada.getNombre(), criaturaDomesticada);

	}

	public Integer cantidadDeCriaturasADisposicion() {
		return criaturasACargo.size();
	}

	public CriaturaElemental obtenerCriatura(CriaturaElemental criatura) {
		return criaturasACargo.get(criatura.getNombre());
	}

	public void entrenarCriatura(Criatura criatura, Integer energiaAAumentar)
			throws MaximoDeEnergiaAlcanzadoException, FaltaDeMaestriaException {
		if (this.maestria >= 25) {
			criatura.entrenar(energiaAAumentar);
		} else {
			throw new FaltaDeMaestriaException(
					"Al Maestro le falta maestria elemental para entrenar a la criatura, que siga estudiando");
		}

	}

	public void pacificarCriatura(Criatura criaturaAPacificar) throws CriaturaYaPacificadaException {
		criaturaAPacificar.sePacifica();
	}

	public void transformarCriatura(CriaturaElemental criaturaATransformar) {

	}

}
