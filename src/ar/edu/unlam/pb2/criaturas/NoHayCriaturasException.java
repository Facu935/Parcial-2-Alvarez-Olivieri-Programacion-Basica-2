package ar.edu.unlam.pb2.criaturas;

public class NoHayCriaturasException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public NoHayCriaturasException(String mensaje) {
		super(mensaje);
	}
}
