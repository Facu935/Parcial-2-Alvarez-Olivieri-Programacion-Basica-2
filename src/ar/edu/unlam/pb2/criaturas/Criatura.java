package ar.edu.unlam.pb2.criaturas;

public abstract class Criatura {

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
	
	protected abstract void aumentarEnergia(Integer energia) throws MaximoDeEnergiaAlcanzadoException;
	protected abstract void sePacifica() throws CriaturaYaPacificadaException;

	protected void setNivelEnergiaMaximo() {
		this.nivelDeEnergia = ENERGIA_MAX;
	}

	
	
	
}
