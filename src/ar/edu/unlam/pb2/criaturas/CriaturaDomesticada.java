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

}
