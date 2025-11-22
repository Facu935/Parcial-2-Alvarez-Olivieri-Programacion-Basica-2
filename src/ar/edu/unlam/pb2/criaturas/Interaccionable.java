package ar.edu.unlam.pb2.criaturas;

public interface Interaccionable {

	void pelearConAncestral(Criatura otraCriatura) throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException;

}
