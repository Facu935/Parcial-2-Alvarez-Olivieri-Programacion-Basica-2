package ar.edu.unlam.pb2.criaturas;

public class CriaturaElemental extends Criatura implements Transformable{

	public CriaturaElemental(String nombre, Integer nivelDeEnergia, Afinidades afinidad,
			ComportamientoEmocional comportamiento) {
		super(nombre, nivelDeEnergia, afinidad, comportamiento);

	}

	@Override
	public void entrenar(Integer energia) throws MaximoDeEnergiaAlcanzadoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transformar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sePacifica() throws CriaturaYaPacificadaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bendicionDelRio() {
		this.nivelDeEnergia *= 2;
		
	}

	@Override
	public void llamaInterna() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vinculoTerrestre() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ascensoDelViento() {
		// TODO Auto-generated method stub
		
	}



}
