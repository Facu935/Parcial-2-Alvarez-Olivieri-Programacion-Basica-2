package ar.edu.unlam.pb2.criaturas;

public class Domesticada extends Criatura {

	public Domesticada(String nombre, Integer nivelDeEnergia, Afinidades afinidad,
			ComportamientoEmocional comportamiento) {
		super(nombre, nivelDeEnergia, afinidad, comportamiento);
	}

	@Override
	public void aumentarEnergia(Integer energia) throws MaximoDeEnergiaAlcanzadoException {
		if (this.nivelDeEnergia + energia > 200){
			throw new MaximoDeEnergiaAlcanzadoException("Se Alcanzó el Máximo de Energía");
		} 
		
		this.nivelDeEnergia += energia;
		
		
	}


}
