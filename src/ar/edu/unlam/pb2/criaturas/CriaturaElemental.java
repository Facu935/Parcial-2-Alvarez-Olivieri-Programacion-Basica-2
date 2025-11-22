package ar.edu.unlam.pb2.criaturas;

public abstract class CriaturaElemental extends Criatura implements ICriatura /* implements Transformable */ {

	public CriaturaElemental(String nombre, Integer nivelDeEnergia, Afinidades afinidad,
			ComportamientoEmocional comportamiento) {
		super(nombre, nivelDeEnergia, afinidad, comportamiento);

	}

}
