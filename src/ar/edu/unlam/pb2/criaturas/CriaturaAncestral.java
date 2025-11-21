package ar.edu.unlam.pb2.criaturas;

public class CriaturaAncestral extends CriaturaElemental{
	
	private final Integer ENTRENAMIENTO_EXTREMO = 70;

	public CriaturaAncestral(String nombre, Integer nivelDeEnergia, Afinidades afinidad,
			ComportamientoEmocional comportamiento) {
		super(nombre, nivelDeEnergia, afinidad, comportamiento);
		validarNivel();
	}


	

	private void validarNivel() {
		if (this.nivelDeEnergia < 100) {
			this.nivelDeEnergia = 100;
		}
	}
	@Override
	public void entrenar(Integer energiaAumentada) throws MaximoDeEnergiaAlcanzadoException {
		this.nivelDeEnergia += energiaAumentada;

		if (this.nivelDeEnergia < 100) {
			this.nivelDeEnergia = 100;
		}
		
		limiteDe200deEnergiaAlcanzado();

		
		if (energiaAumentada >= ENTRENAMIENTO_EXTREMO) {
			this.comportamiento = ComportamientoEmocional.INESTABLE;
		}
		
	}
	
	@Override
	public void sePacifica() throws CriaturaYaPacificadaException{
		if (this.comportamiento == ComportamientoEmocional.INESTABLE) {
			this.comportamiento = ComportamientoEmocional.TRANQUILA;
		} else {
			throw new CriaturaYaPacificadaException("La Criatura ya se encuentra tranquila");
		}
		
	}












}
