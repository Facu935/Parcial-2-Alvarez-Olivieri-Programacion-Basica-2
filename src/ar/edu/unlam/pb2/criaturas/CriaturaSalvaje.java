package ar.edu.unlam.pb2.criaturas;



public class CriaturaSalvaje extends CriaturaElemental implements Interaccionable{

	
	public CriaturaSalvaje(String nombre, Integer nivelDeEnergia, Afinidades afinidad, ComportamientoEmocional comportamiento) {
		super(nombre, nivelDeEnergia, afinidad, comportamiento);
	}

	
	@Override
	public void entrenar(Integer energia) throws MaximoDeEnergiaAlcanzadoException, EnergiaAcabadaException {
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
	    return 1 + (int) (Math.random() * 131);
	    //Decidimos que que la probabilidad de que ocurra esto sea de un 10%
	    //Y que sea en un valor de entre 1 y 130 de energia
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


	@Override
	public void pelearConAncestral(Criatura otraCriatura)
			throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException {
		if (otraCriatura.esAncestral())  {
			perderEnergia(ENERGIA_PERDIDA_INTERACTUAR_CON_ANCESTRAL);
			otraCriatura.ganarEnergia(20);
		}
		
	}




    
    
    

}


	
	

