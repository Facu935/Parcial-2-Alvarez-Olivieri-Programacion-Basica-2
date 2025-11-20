package ar.edu.unlam.pb2.criaturas;

public class CriaturaAncestral extends Criatura {

	public CriaturaAncestral(String nombre, Integer nivelDeEnergia, Afinidades afinidad,
			ComportamientoEmocional comportamiento) {
		super(nombre, nivelDeEnergia, afinidad, comportamiento);
	}
	//Que su energia no baje de 100

	
	//Cambiar a estado Inestable si se aumenta mucho la energia por ser un entrenamiento extremo??
	@Override
	public void aumentarEnergia(Integer energia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void sePacifica() throws CriaturaYaPacificadaException {
		if (this.comportamiento == ComportamientoEmocional.INESTABLE) {
			this.comportamiento = ComportamientoEmocional.TRANQUILA;
		} else {
			throw new CriaturaYaPacificadaException("La Criatura ya se encuentra pacificada");
		}
		
	}



}
