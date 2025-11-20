package ar.edu.unlam.pb2.criaturas;

public class CriaturaDomesticada extends Criatura {

	public CriaturaDomesticada(String nombre, Integer nivelDeEnergia, Afinidades afinidad,
			ComportamientoEmocional comportamiento) {
		super(nombre, nivelDeEnergia, afinidad, comportamiento);
		
		//El comportamiento siempre tiene que comenzar ser TRANQUILO
	}

	@Override
	public void aumentarEnergia(Integer energia) throws MaximoDeEnergiaAlcanzadoException {
		if (this.nivelDeEnergia + energia > ENERGIA_MAX){
			throw new MaximoDeEnergiaAlcanzadoException("Se Alcanzó el Máximo de Energía");
		} 
		
		this.nivelDeEnergia += energia;
		
		
	}

	@Override
	protected void sePacifica() throws CriaturaYaPacificadaException {
		throw new CriaturaYaPacificadaException("Las Criaturas Domesticadas ya son TRANQUILAS");
	
	}



}
