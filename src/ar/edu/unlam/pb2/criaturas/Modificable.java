package ar.edu.unlam.pb2.criaturas;

public interface Modificable {

	void entrenar(Integer energia) throws MaximoDeEnergiaAlcanzadoException;
	void sePacifica() throws CriaturaYaPacificadaException;
	
}
