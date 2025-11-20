package ar.edu.unlam.pb2.criaturas;

public class CriaturaDomesticada extends Criatura  implements Modificable{
	 

	public CriaturaDomesticada(String nombre, Integer nivelDeEnergia, Afinidades afinidad,
			ComportamientoEmocional comportamiento) {
		
		super(nombre, nivelDeEnergia, afinidad, comportamiento);
		this.comportamiento = ComportamientoEmocional.TRANQUILA;
		
	}



	@Override
	public void sePacifica() throws CriaturaYaPacificadaException {
		throw new CriaturaYaPacificadaException("La Criatura ya se encuentra tranquila");
	}

	@Override
	public void entrenar(Integer energiaAAumentar) throws MaximoDeEnergiaAlcanzadoException {
		this.nivelDeEnergia += energiaAAumentar;
		if (this.nivelDeEnergia > 200) {
			limiteDe200deEnergiaAlcanzado(); 
		}
	}

	@Override
	public void transformar() {
		
		
	}



}
