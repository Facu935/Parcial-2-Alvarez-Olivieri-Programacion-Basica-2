package ar.edu.unlam.pb2.criaturas;

public class CriaturaAncestral extends CriaturaElemental{
	
	private final Integer ENTRENAMIENTO_EXTREMO = 70;
	private final Integer ENERGIA_INTERACCION_DOMINANTE = 20;


	public CriaturaAncestral(String nombre, Integer nivelDeEnergia, Afinidades afinidad,
			ComportamientoEmocional comportamiento) {
		super(nombre, nivelDeEnergia, afinidad, comportamiento);
		validarNivel();
		this.esAncestral = true;

	}


	

	private void validarNivel() {
		if (this.nivelDeEnergia < 100) {
			this.nivelDeEnergia = 100;
		}
	}
	@Override
	public void entrenar(Integer energiaAumentada) throws MaximoDeEnergiaAlcanzadoException {
		this.nivelDeEnergia += energiaAumentada;

		if (this.nivelDeEnergia < 0) {
			this.nivelDeEnergia = 0;
		}

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


	@Override
	public void pelearConAncestral(Criatura otraCriatura)
			throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException {
		if (!otraCriatura.esAncestral())  {
			ganarEnergia(ENERGIA_INTERACCION_DOMINANTE);
			otraCriatura.perderEnergia(ENERGIA_PERDIDA_INTERACTUAR_CON_ANCESTRAL);
		}
		
	}




}
