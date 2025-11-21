package ar.edu.unlam.pb2.criaturas;

public class VinculoTerrestre extends CriaturaDecorador{

	public VinculoTerrestre(ICriatura criatura) {
		super(criatura);
	}
	
	@Override
	public Integer getNivel() {
        Integer energiaCalculada = super.getNivel();

        if (energiaCalculada < 50) {
            return 50;
        }

        return energiaCalculada;
    }
}
