package ar.edu.unlam.pb2.criaturas;


public abstract class Criatura implements Modificable, Interaccionable, ICriatura{


	protected String nombre;
	protected Integer nivelDeEnergia;
	protected Afinidades afinidad;
	protected ComportamientoEmocional comportamiento;
	protected static final Integer ENERGIA_MAX = 200;
	protected static final Integer ENERGIA_PERDIDA_INTERACTUAR_CON_ANCESTRAL= 15;
	protected boolean esDomesticado = false;
	protected boolean esAncestral = false;


	
	public Criatura(String nombre, Integer nivelDeEnergia, Afinidades afinidad, ComportamientoEmocional comportamiento) {

		this.nombre = nombre;
		this.nivelDeEnergia = nivelDeEnergia;
		this.afinidad = afinidad;
		this.comportamiento = comportamiento;
	}

	@Override
	public Afinidades getAfinidad() {
		return this.afinidad;
	}
	
	@Override
	public String getNombre() {
		return this.nombre;
	}

	public Integer getNivel() {
		return this.nivelDeEnergia;
	}
	public boolean esDomesticado() {
		return esDomesticado;
	}
	public boolean esAncestral() {
		return esAncestral;
	}
	protected void setNivel(Integer nivel) throws MaximoDeEnergiaAlcanzadoException, EnergiaAcabadaException {
		nivelDeEnergia = nivel;
		limiteDe0deEnergia();
		limiteDe200deEnergiaAlcanzado();
	}
	
	protected Integer ganarEnergia(Integer energiaGanada) throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException {
		this.nivelDeEnergia += energiaGanada;
		limiteDe0deEnergia();
		limiteDe200deEnergiaAlcanzado();
		return nivelDeEnergia;
	}
	
	protected Integer perderEnergia(Integer energiaPerdida) throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException {
		this.nivelDeEnergia -= energiaPerdida;
		limiteDe0deEnergia();
		limiteDe200deEnergiaAlcanzado();
		return nivelDeEnergia;
	}

	protected void gananciaDeEnergiaPorMismaAfinidad(Criatura otraCriatura) throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException {
		ganarEnergia(10);
		otraCriatura.ganarEnergia(10);
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


	
	protected void limiteDe0deEnergia() throws EnergiaAcabadaException {
		if (nivelDeEnergia < 0) {
			this.nivelDeEnergia = 0;
			throw new EnergiaAcabadaException("La Criatura se quedó sin Energia");
		}
	}




	

	protected void setComportamiento(ComportamientoEmocional comportamiento) {
		this.comportamiento = comportamiento;
	}

	
	protected void interactuar(Criatura otraCriatura) throws MaximoDeEnergiaAlcanzadoException, EnergiaAcabadaException{
		this.pelearConAncestral(otraCriatura);
		this.getAfinidad().interactuarCon(this, otraCriatura);
	}
	
	

	
	
	
}
	
	

	
	

	
	
	


