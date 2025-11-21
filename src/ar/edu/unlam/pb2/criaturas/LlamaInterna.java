package ar.edu.unlam.pb2.criaturas;

public class LlamaInterna extends CriaturaDecorador {

	public LlamaInterna(ICriatura criatura) {
		super(criatura);
	}
	
	@Override
	public Integer getNivel() {
        Integer energiaBase = super.getNivel();
        Afinidades afinidadActual = super.getAfinidad();

        if (afinidadActual.equals(Afinidades.FUEGO)) {
            return energiaBase + 30;
        }
        
        return energiaBase;
    }
	
	@Override
    public ComportamientoEmocional getComportamiento() {
        Afinidades afinidadActual = super.getAfinidad();

        if (!afinidadActual.equals(Afinidades.FUEGO)) {
            return ComportamientoEmocional.INESTABLE; 
        }

        return super.getComportamiento();
    }
}
