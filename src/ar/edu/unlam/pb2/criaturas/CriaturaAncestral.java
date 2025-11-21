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


	/*
	@Override
	public void compararAfinidadAgua(Criatura otraCriatura)
			throws MaximoDeEnergiaAlcanzadoException, EnergiaAcabadaException {
		switch(otraCriatura.getAfinidad()) {
		case AGUA:
				gananciaDeEnergiaPorMismaAfinidad(otraCriatura);
			break;
		case FUEGO:
				if (!otraCriatura.esDomesticado) {
					otraCriatura.setComportamiento(ComportamientoEmocional.INESTABLE);
				}	
				this.comportamiento = ComportamientoEmocional.INESTABLE;	
			break;
		default:
			break;
		}
	}


	@Override
	public void compararAfinidadFuego(Criatura otraCriatura)
			throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException {
		switch(otraCriatura.getAfinidad()) {
		case AGUA:
				if (!otraCriatura.esDomesticado) {
				otraCriatura.setComportamiento(ComportamientoEmocional.INESTABLE);
				}
				this.comportamiento = ComportamientoEmocional.INESTABLE;
			break;
		case FUEGO:
				gananciaDeEnergiaPorMismaAfinidad(otraCriatura);
			break;
		default:
			break;
		}
		
	}


	@Override
	public void compararAfinidadTierra(Criatura otraCriatura)
			throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException {
		switch(otraCriatura.getAfinidad()) {
		case AIRE:
				if (!otraCriatura.esDomesticado) {
				otraCriatura.setComportamiento(ComportamientoEmocional.INESTABLE);
				}
				this.comportamiento = ComportamientoEmocional.INESTABLE;
			break;
		case TIERRA:
				gananciaDeEnergiaPorMismaAfinidad(otraCriatura);
			break;
		default:
			break;
		}
		
	}


	@Override
	public void compararAfinidadAire(Criatura otraCriatura)
			throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException {
		switch(otraCriatura.getAfinidad()) {
		case TIERRA:
				if (!otraCriatura.esDomesticado) {
				otraCriatura.setComportamiento(ComportamientoEmocional.INESTABLE);
				}
				this.comportamiento = ComportamientoEmocional.INESTABLE;
			break;
		case AIRE:
				gananciaDeEnergiaPorMismaAfinidad(otraCriatura);
			break;
		default:
			break;
		}
		
	}

	*/
	@Override
	public void pelearConAncestral(Criatura otraCriatura)
			throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException {
		if (!otraCriatura.esAncestral())  {
			ganarEnergia(ENERGIA_INTERACCION_DOMINANTE);
			otraCriatura.perderEnergia(ENERGIA_PERDIDA_INTERACTUAR_CON_ANCESTRAL);
		}
		
	}



}
