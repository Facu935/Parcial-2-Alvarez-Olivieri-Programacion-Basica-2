package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CriaturaSalvajeTest {

	private Maestro maestro;
	private CriaturaElemental criaturaSalvaje;

	@Before
	public void setUp() throws Exception {
		maestro = new Maestro("Baltazar", 40, Afinidades.TIERRA);
		criaturaSalvaje = new CriaturaSalvaje("Marcelo", 100, Afinidades.FUEGO, ComportamientoEmocional.INESTABLE);
		maestro.añadirCriaturaAColeccion(criaturaSalvaje);
	}

	@Test
	public void queExistaUnaCriaturaSalvaje() {

		String nombreEsperado = "Marcelo";
		Integer nivelEsperado = 100;
		Afinidades afinidadEsperada = Afinidades.FUEGO;
		ComportamientoEmocional comportamientoEsperado = ComportamientoEmocional.INESTABLE;

		assertNotNull(criaturaSalvaje);
		assertEquals(nombreEsperado, criaturaSalvaje.getNombre());
		assertEquals(nivelEsperado, criaturaSalvaje.getNivel());
		assertEquals(afinidadEsperada, criaturaSalvaje.getAfinidad());
		assertEquals(comportamientoEsperado, criaturaSalvaje.getComportamiento());

	}

	// PENSAR BIEN ESTO y lo de aumentarEnergia(); Tal vez dejar aumentarEnergia
	// para despues

	/*
	 * 
	 * @Test public void
	 * queUnaCriaturaSalvajeAumenteSuEnergiaDeManeraImpredecibleYqueMuestreExceptionSiSeDesborda
	 * () throws MaximoDeEnergiaAlcanzadoException, EnergiaDesbordadaException {
	 * maestro.entrenarCriatura(criaturaSalvaje, 20);
	 * 
	 * assertNotEquals(Integer.valueOf(120), criaturaSalvaje.getNivel()); //Este
	 * Test va generando el valor Aleatorio entre 1 y 130, por lo tanto nunca es
	 * igual. Si se desborda, falla y tira la excepcion }
	 * 
	 * 
	 * 
	 * 
	 * //En los siguientes 2 Test descomponemos la generacion aleatoria de Energia,
	 * hacemos que de un valor fijo, para que de verde tanto si no hay //
	 * desbordamiento como si tambien lo haya, todo esto es para probar los 2 casos
	 * si es que suceden
	 * 
	 * @Test //Sin desbordamiento public void
	 * salvajeAumentaConValorFijoParaProbarSinQueSePaseDelMaximoDeEnergia() throws
	 * MaximoDeEnergiaAlcanzadoException {
	 * 
	 * 
	 * class TestSalvaje extends CriaturaSalvaje { private final int fijo; public
	 * TestSalvaje(String nombre, Integer nivel, Afinidades afinidad,
	 * ComportamientoEmocional comportamiento, int fijo) { super(nombre, nivel,
	 * afinidad, comportamiento); this.fijo = fijo; }
	 * 
	 * @Override protected int generarAumentoAleatorio() { return fijo; } }
	 * 
	 * // 100 + 10 = 110 (sin desbordamiento) CriaturaSalvaje salvaje = new
	 * TestSalvaje("Feroz", 100, Afinidades.FUEGO,
	 * ComportamientoEmocional.INESTABLE, 10);
	 * maestro.añadirCriaturaAColeccion(salvaje);
	 * 
	 * maestro.entrenarCriatura(salvaje, 20); assertEquals(Integer.valueOf(110),
	 * salvaje.getNivel()); /*Aca creamos subclase para realizar el test si es que
	 * el valor aletorio del nivel aumentado NO hace overflow, es una pequeña prueba
	 * donde fijamos el valor a uno que NO de el desbordamiento si es que el metodo
	 * generarNumeroAletorio(), lo genera
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @Test(expected = EnergiaDesbordadaException.class) public void
	 * salvajeLanzaExcepcionSiDesborda() throws MaximoDeEnergiaAlcanzadoException {
	 * 
	 * 
	 * class TestSalvaje extends CriaturaSalvaje { public TestSalvaje(String nombre,
	 * Integer nivel, Afinidades afinidad, ComportamientoEmocional comportamiento) {
	 * super(nombre, nivel, afinidad, comportamiento); }
	 * 
	 * @Override protected int generarAumentoAleatorio() { return 80; } }
	 * 
	 * CriaturaSalvaje salvaje = new TestSalvaje("Feroz", 130, Afinidades.FUEGO,
	 * ComportamientoEmocional.INESTABLE);
	 * maestro.añadirCriaturaAColeccion(salvaje);
	 * 
	 * 
	 * maestro.entrenarCriatura(salvaje, 20);
	 * 
	 * /*Aca creamos subclase para realizar el test si es que el valor aletorio del
	 * nivel aumentado hace overflow, es una pequeña prueba donde fijamos el valor a
	 * uno que de desbordamiento para probar la Excepcion
	 * 
	 * }
	 * 
	 */

}
