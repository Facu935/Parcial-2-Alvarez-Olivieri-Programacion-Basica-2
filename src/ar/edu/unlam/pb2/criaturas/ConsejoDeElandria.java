package ar.edu.unlam.pb2.criaturas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public List<ICriatura> obtenerTodasLasCriaturas() {
		List<ICriatura> todasLasCriaturas = new ArrayList<>();

		for (Maestro maestro : this.maestros) {
			todasLasCriaturas.addAll(maestro.getCriaturas());
		}

		return todasLasCriaturas;
	}

	public ICriatura getCriaturaConMasNivel() throws NoHayCriaturasException {
		List<ICriatura> todas = obtenerTodasLasCriaturas();

		if (todas.isEmpty()) {
			throw new NoHayCriaturasException("No se puede calcular el más poderoso: No hay criaturas registradas.");
		}

		ICriatura candidata = todas.get(0);

		for (ICriatura criatura : todas) {
			if (criatura.getNivel() > candidata.getNivel()) {
				candidata = criatura;
			}
		}

		return candidata;
	}

	public Maestro getMaestroConMasTransformaciones() {
		Maestro ganador = null;
		int maxTransformadas = -1;

		for (Maestro maestro : this.maestros) {
			int contadorActual = 0;

			for (ICriatura c : maestro.getCriaturas()) {
				if (c instanceof CriaturaDecorador) {
					contadorActual++;
				}
			}

			if (contadorActual > maxTransformadas) {
				maxTransformadas = contadorActual;
				ganador = maestro;
			}
		}

		return ganador;
	}

	public Map<Afinidades, Integer> obtenerReporteDeAfinidades() throws NoHayCriaturasException {
		Map<Afinidades, Integer> reporte = new HashMap<>();

		List<ICriatura> todas = obtenerTodasLasCriaturas();

		if (todas.isEmpty()) {
			throw new NoHayCriaturasException("No se puede generar el reporte: No hay criaturas registradas.");
		}

		for (ICriatura criatura : todas) {
			Afinidades afinidadActual = criatura.getAfinidad();

			if (reporte.containsKey(afinidadActual)) {
				Integer cantidadActual = reporte.get(afinidadActual);
				reporte.put(afinidadActual, cantidadActual + 1);
			} else {
				reporte.put(afinidadActual, 1);
			}
		}

		return reporte;
	}

}
