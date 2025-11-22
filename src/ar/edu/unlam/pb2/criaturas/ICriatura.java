package ar.edu.unlam.pb2.criaturas;

public interface ICriatura {
    String getNombre();
    Integer getNivel();
    Afinidades getAfinidad();
    ComportamientoEmocional getComportamiento();
	
    void entrenar(Integer energiaAAumentar) throws MaximoDeEnergiaAlcanzadoException, EnergiaAcabadaException;
	void sePacifica() throws CriaturaYaPacificadaException;
}