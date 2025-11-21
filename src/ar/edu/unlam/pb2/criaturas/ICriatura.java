package ar.edu.unlam.pb2.criaturas;

public interface ICriatura {
    String getNombre();
    Integer getNivel();
    Afinidades getAfinidad();
    ComportamientoEmocional getComportamiento();
}