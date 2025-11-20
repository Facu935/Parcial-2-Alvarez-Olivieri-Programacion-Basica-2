package ar.edu.unlam.pb2.criaturas;


public class CriaturaSalvaje extends Criatura{


	
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
	public void sePacifica() {
		// TODO Auto-generated method stub
	}

	@Override
	public void entrenar(Integer energia) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transformar() {
		// TODO Auto-generated method stub
		
	}
    
    
    
}


	
	

