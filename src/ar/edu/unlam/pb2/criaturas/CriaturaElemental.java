package ar.edu.unlam.pb2.criaturas;

public abstract class CriaturaElemental extends Criatura /*implements Transformable*/{

	public CriaturaElemental(String nombre, Integer nivelDeEnergia, Afinidades afinidad,
			ComportamientoEmocional comportamiento) {
		super(nombre, nivelDeEnergia, afinidad, comportamiento);
		//this.vinculoTerrestreActivado = false;

	}



}
