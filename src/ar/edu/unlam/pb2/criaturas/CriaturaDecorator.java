package ar.edu.unlam.pb2.criaturas;

public class CriaturaDecorator extends Criatura {

	protected final Criatura criatura;

    public CriaturaDecorator(Criatura criatura) {
        super(criatura.getNombre(), criatura.getNivel(), criatura.getAfinidad(), criatura.getComportamiento());
        this.criatura = criatura;
    }


    @Override
    public String getNombre() {
        return criatura.getNombre();
    }

    @Override
    public Integer getNivel() {
        return criatura.getNivel();
    }

    @Override
    public Afinidades getAfinidad() {
        return criatura.getAfinidad();
    }

    @Override
    public ComportamientoEmocional getComportamiento() {
        return criatura.getComportamiento();
    }


    @Override
    public void entrenar(Integer energia) throws MaximoDeEnergiaAlcanzadoException, EnergiaAcabadaException {
    	criatura.entrenar(energia);
    }

    @Override
    public void sePacifica() throws CriaturaYaPacificadaException {
    	criatura.sePacifica();
    }





}
