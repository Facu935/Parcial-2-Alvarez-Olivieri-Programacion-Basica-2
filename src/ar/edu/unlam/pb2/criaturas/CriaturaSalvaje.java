package ar.edu.unlam.pb2.criaturas;


public class CriaturaSalvaje extends CriaturaElemental{


	
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
	public void entrenar(Integer energia) {
		// TODO Auto-generated method stub
		
	}




    
    
    
}


	
	

