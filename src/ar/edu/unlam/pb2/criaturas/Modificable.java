package ar.edu.unlam.pb2.criaturas;

public interface Modificable {

	void entrenar(Integer energia) throws MaximoDeEnergiaAlcanzadoException, EnergiaAcabadaException;
	void sePacifica() throws CriaturaYaPacificadaException;
	
}
