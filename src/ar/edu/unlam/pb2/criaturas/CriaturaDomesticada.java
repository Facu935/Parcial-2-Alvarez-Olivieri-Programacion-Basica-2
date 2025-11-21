package ar.edu.unlam.pb2.criaturas;

public class CriaturaDomesticada extends CriaturaElemental{
	 

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
		
		if (this.nivelDeEnergia < 0) {
			this.nivelDeEnergia = 0;
		}
		
		if (this.nivelDeEnergia > 200) {
			limiteDe200deEnergiaAlcanzado(); 
		}
		
		/*
		if (vinculoTerrestreActivado() == true && this.nivelDeEnergia < 50) {
			this.nivelDeEnergia = 50;
		}
		*/
	}

	
	/*
	@Override
	public void llamaInterna() {
		if (this.afinidad == Afinidades.FUEGO) {
			this.nivelDeEnergia += 30;
		}
		
	}
	*/


	











}
