package ar.edu.unlam.pb2.criaturas;

public class AscensoDelViento extends CriaturaDecorador {

	public AscensoDelViento(ICriatura criatura) {
		super(criatura);
	}
	
	@Override
	public Afinidades getAfinidad() {
		Afinidades afinidadDeLaCriatura = super.getAfinidad();
		Afinidades afinidadAAplicar = Afinidades.AIRE;
		
		if(afinidadDeLaCriatura != afinidadAAplicar) {
			return afinidadAAplicar;
		}
		
		return afinidadDeLaCriatura;
	}

}
