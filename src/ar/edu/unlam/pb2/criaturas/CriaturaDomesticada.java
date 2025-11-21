package ar.edu.unlam.pb2.criaturas;

public class CriaturaDomesticada extends CriaturaElemental implements Interaccionable{
	 

	public CriaturaDomesticada(String nombre, Integer nivelDeEnergia, Afinidades afinidad,
			ComportamientoEmocional comportamiento) {
		
		super(nombre, nivelDeEnergia, afinidad, comportamiento);
		this.comportamiento = ComportamientoEmocional.TRANQUILA;
		this.esDomesticado = true;
		
	}



	@Override
	public void sePacifica() throws CriaturaYaPacificadaException {
		throw new CriaturaYaPacificadaException("La Criatura ya se encuentra tranquila");
	}

	@Override
	public void entrenar(Integer energiaAAumentar) throws MaximoDeEnergiaAlcanzadoException, EnergiaAcabadaException {
		this.nivelDeEnergia += energiaAAumentar;
			limiteDe0deEnergia();
			limiteDe200deEnergiaAlcanzado();
	}




	@Override
	public void pelearConAncestral(Criatura otraCriatura) throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException {
		if (otraCriatura.esAncestral())  {
			perderEnergia(ENERGIA_PERDIDA_INTERACTUAR_CON_ANCESTRAL);
			otraCriatura.ganarEnergia(20);
		}
		
	}


	/*
	@Override
	public void compararAfinidadAgua(Criatura otraCriatura) throws MaximoDeEnergiaAlcanzadoException, EnergiaAcabadaException {
			switch(otraCriatura.getAfinidad()) {
			case AGUA:
					gananciaDeEnergiaPorMismaAfinidad(otraCriatura);
				break;
			case FUEGO:
					if (!otraCriatura.esDomesticado) {
						otraCriatura.setComportamiento(ComportamientoEmocional.INESTABLE);
					}
				break;
			default:
				break;
			}
	}



	@Override
	public void compararAfinidadFuego(Criatura otraCriatura) throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException {
			switch(otraCriatura.getAfinidad()) {
			case AGUA:
					if (!otraCriatura.esDomesticado) {
					otraCriatura.setComportamiento(ComportamientoEmocional.INESTABLE);
					}
				break;
			case FUEGO:
					gananciaDeEnergiaPorMismaAfinidad(otraCriatura);
				break;
			default:
				break;
		}
	}



	@Override
	public void compararAfinidadTierra(Criatura otraCriatura) throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException {
			switch(otraCriatura.getAfinidad()) {
			case AIRE:
					if (!otraCriatura.esDomesticado) {
					otraCriatura.setComportamiento(ComportamientoEmocional.INESTABLE);
					}
				break;
			case TIERRA:
					gananciaDeEnergiaPorMismaAfinidad(otraCriatura);
				break;
			default:
				break;
			}
	}



	@Override
	public void compararAfinidadAire(Criatura otraCriatura) throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException {
			switch(otraCriatura.getAfinidad()) {
			case TIERRA:
					if (!otraCriatura.esDomesticado) {
					otraCriatura.setComportamiento(ComportamientoEmocional.INESTABLE);
					}
				break;
			case AIRE:
					gananciaDeEnergiaPorMismaAfinidad(otraCriatura);
				break;
			default:
				break;
			}
	}

 		*/

}
