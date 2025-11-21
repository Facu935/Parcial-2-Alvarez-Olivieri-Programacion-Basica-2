package ar.edu.unlam.pb2.criaturas;

public abstract class CriaturaDecorador implements ICriatura {

	protected ICriatura criaturaDecorada;

	public CriaturaDecorador(ICriatura criatura) {
		this.criaturaDecorada = criatura;
	}

	@Override
	public String getNombre() {
		return criaturaDecorada.getNombre();
	}

	@Override
	public Integer getNivel() {
		return criaturaDecorada.getNivel();
	}

	@Override
	public Afinidades getAfinidad() {
		return criaturaDecorada.getAfinidad();
	}

	@Override
	public ComportamientoEmocional getComportamiento() {
		return criaturaDecorada.getComportamiento();
	}
}