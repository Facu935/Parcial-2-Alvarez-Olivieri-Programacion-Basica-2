package ar.edu.unlam.pb2.criaturas;

public abstract class Criatura implements Modificable{

	protected String nombre;
	protected Integer nivelDeEnergia;
	protected Afinidades afinidad;
	protected ComportamientoEmocional comportamiento;
	protected static final Integer ENERGIA_MAX = 200;
	
	
	public Criatura(String nombre, Integer nivelDeEnergia, Afinidades afinidad, ComportamientoEmocional comportamiento) {
		this.nombre = nombre;
		this.nivelDeEnergia = nivelDeEnergia;
		this.afinidad = afinidad;
		this.comportamiento = comportamiento;
	}

	public String getNombre() {
		return this.nombre; 
	}

	public Integer getNivel() {
		return this.nivelDeEnergia;
	}

	public Afinidades getAfinidad() {
		return this.afinidad;
	}

	public ComportamientoEmocional getComportamiento() {
		return this.comportamiento;
	}
	
	
	protected void limiteDe200deEnergiaAlcanzado() throws MaximoDeEnergiaAlcanzadoException {
		if (nivelDeEnergia > 200) {
			nivelDeEnergia = 200;
			throw new MaximoDeEnergiaAlcanzadoException("Ya se encuentra en el máximo de Energía, se limitó a 200");
		}
	}

	protected void setNivelEnergiaMaximo() {
		this.nivelDeEnergia = ENERGIA_MAX; 
	}

	public abstract void sePacifica() throws CriaturaYaPacificadaException;


	
	
	
}
