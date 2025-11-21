package ar.edu.unlam.pb2.criaturas;

public class BendicionDelRio extends CriaturaDecorador {

    public BendicionDelRio(ICriatura criatura) {
        super(criatura);
    }

    @Override
    public Integer getNivel() {
        Integer energiaBase = super.getNivel(); 

        Integer energiaNueva = energiaBase * 2;

        if (energiaNueva > 180) {
            return 180;
        }
        return energiaNueva;
    }

}