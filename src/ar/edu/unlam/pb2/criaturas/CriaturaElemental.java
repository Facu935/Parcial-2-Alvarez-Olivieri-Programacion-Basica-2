package ar.edu.unlam.pb2.criaturas;

public abstract class CriaturaElemental extends Criatura /*implements Transformable*/{


	
	public CriaturaElemental(String nombre, Integer nivelDeEnergia, Afinidades afinidad,
			ComportamientoEmocional comportamiento) {
		super(nombre, nivelDeEnergia, afinidad, comportamiento);
		//this.vinculoTerrestreActivado = false;

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@Override
	public void bendicionDelRio() {
		this.nivelDeEnergia *= 2;
		if (nivelDeEnergia > 180) {
			this.nivelDeEnergia = 180;
		}
	}

	@Override
	public void llamaInterna() {
		if (this.afinidad == Afinidades.FUEGO) {
			this.nivelDeEnergia += 30;
		} else {
			this.comportamiento = ComportamientoEmocional.INESTABLE;
		}
		
	}

	@Override
	public void vinculoTerrestre() {
		this.vinculoTerrestreActivado = true;
	}
	
	public Boolean vinculoTerrestreActivado() {
		return this.vinculoTerrestreActivado;
	}

	@Override
	public void ascensoDelViento() {
		// TODO Auto-generated method stub
		
	}
*/


}
