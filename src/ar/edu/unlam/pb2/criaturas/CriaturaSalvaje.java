package ar.edu.unlam.pb2.criaturas;


public class CriaturaSalvaje extends CriaturaElemental implements Interaccionable{


	
	public CriaturaSalvaje(String nombre, Integer nivelDeEnergia, Afinidades afinidad, ComportamientoEmocional comportamiento) {
		super(nombre, nivelDeEnergia, afinidad, comportamiento);
	}

	/*
	@Override
	public void aumentarEnergia(Integer energia) throws MaximoDeEnergiaAlcanzadoException {
		//Acá pensé en aumentar de manera Aleatoria la energia del Salvaje
		int aumentoAleatorio = generarAumentoAleatorio();
		int nuevoNivelDeEnergia = this.nivelDeEnergia + aumentoAleatorio;
		
		if (nuevoNivelDeEnergia > ENERGIA_MAX){
			throw new EnergiaDesbordadaException("Se desbordó el nivel de Energía de la Criatura");
		} 
		this.nivelDeEnergia = Integer.valueOf(nuevoNivelDeEnergia);
		
	}
	
	
	protected int generarAumentoAleatorio() {
	    final double PROBABILIDAD = 0.10;
	    
	    if (Math.random() > PROBABILIDAD) {
	        return 0;
	    }
	    return 1 + (int) (Math.random() * 130);
	    //Decidimos que que la probabilidad de que ocurra esto sea de un 10%
	}

	 */
	
	
	
	@Override
	public void entrenar(Integer energia) {
		// TODO Auto-generated method stub
		
	}
	
	
	//Agregar alguna dificultad para que lo haga
	@Override
	public void sePacifica() throws CriaturaYaPacificadaException {
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
		if (otraCriatura.esAncestral())  {
			perderEnergia(ENERGIA_PERDIDA_INTERACTUAR_CON_ANCESTRAL);
			otraCriatura.ganarEnergia(20);
		}
		
	}




    
    
    
}


	
	

