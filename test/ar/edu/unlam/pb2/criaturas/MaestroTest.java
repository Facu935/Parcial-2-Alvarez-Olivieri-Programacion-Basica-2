package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaestroTest {

	/*
	 * @BeforeClass public static void setUpBeforeClass() throws Exception { }
	 * 
	 * @AfterClass public static void tearDownAfterClass() throws Exception { }
	 * 
	 * 
	 * 
	 * @After public void tearDown() throws Exception { }
	 */

	private Maestro maestro;
	private CriaturaElemental criaturaDomesticada;
	private CriaturaElemental criaturaSalvaje;
	private CriaturaElemental criaturaAncestral;

	@Before

	public void setUp() throws Exception {
		maestro = new Maestro("Baltazar", 40, Afinidades.TIERRA);
		criaturaDomesticada = new CriaturaDomesticada("Pablo", 80, Afinidades.TIERRA,
				ComportamientoEmocional.TRANQUILA);
		criaturaSalvaje = new CriaturaSalvaje("Oliver", 50, Afinidades.FUEGO, ComportamientoEmocional.INESTABLE);
		criaturaAncestral = new CriaturaAncestral("Smaug", 80, Afinidades.TIERRA, ComportamientoEmocional.INESTABLE);

	}

	@Test
	public void queExistaUnMaestroConTodasSusCaracteristicas() {

		String nombreEsperado = "Baltazar";
		Integer maestriaEsperado = 40;
		Afinidades afinidadEsperada = Afinidades.TIERRA;

		assertNotNull(maestro);
		assertEquals(nombreEsperado, maestro.getNombre());
		assertEquals(maestriaEsperado, maestro.getMaestria());
		assertEquals(afinidadEsperada, maestro.getAfinidad());
	}

	@Test
	public void queElMaestroNoComienzeConCeroOMenosDeMaestria() {
		Maestro maestro1 = new Maestro("Baltazar", -5, Afinidades.TIERRA);

		Integer maestriaEsperado = 1;

		assertEquals(maestriaEsperado, maestro1.getMaestria());
	}

	@Test
	public void queElMaestroNoComienzeConMasDeCincuentaDeMaestria() {
		Maestro maestro1 = new Maestro("Baltazar", 100, Afinidades.TIERRA);

		Integer maestriaEsperado = 50;

		assertEquals(maestriaEsperado, maestro1.getMaestria());
	}

	@Test
	public void queElMaestroNoSePaseDelTopeDeMaestria() {
		Maestro maestro1 = new Maestro("Baltazar", 49, Afinidades.TIERRA);

		maestro1.aumentarMaestria();
		maestro1.aumentarMaestria();

		Integer maestriaEsperado = 50;

		assertEquals(maestriaEsperado, maestro1.getMaestria());
	}

	@Test
	public void queUnMaestroTengaUnaCriaturaADisposicion() {

		maestro.añadirCriaturaAColeccion(criaturaDomesticada);
		assertEquals(Integer.valueOf(1), maestro.cantidadDeCriaturasADisposicion());

	}

	@Test
	public void queElMaestroPuedaEntrenarAUnaCriaturaEnConcretoEnSuColeccion() {

		maestro.añadirCriaturaAColeccion(criaturaDomesticada);
		maestro.añadirCriaturaAColeccion(criaturaSalvaje);
		maestro.añadirCriaturaAColeccion(criaturaAncestral);
		Criatura criaturaAEntrenar = maestro.obtenerCriatura(criaturaDomesticada);

		assertEquals(criaturaAEntrenar.getNombre(), criaturaDomesticada.getNombre());

	}

	@Test
	public void queElMaestroPuedaEntrenarAUnaCriatura()
			throws MaximoDeEnergiaAlcanzadoException, FaltaDeMaestriaException {

		maestro.añadirCriaturaAColeccion(criaturaDomesticada);
		Criatura criaturaAEntrenar = maestro.obtenerCriatura(criaturaDomesticada);

		maestro.entrenarCriatura(criaturaAEntrenar, 20);

		Integer nivelEsperado = 100;

		assertEquals(nivelEsperado, criaturaDomesticada.getNivel());

	}

	@Test(expected = FaltaDeMaestriaException.class)
	public void queElMaestroNoPuedaEntrenarAUnaCriaturaSiNoTieneLaSuficienteMaestria()
			throws MaximoDeEnergiaAlcanzadoException, FaltaDeMaestriaException {
		Maestro maestroInexperto = new Maestro("Baltazar", 15, Afinidades.FUEGO);

		maestroInexperto.añadirCriaturaAColeccion(criaturaDomesticada);
		Criatura criaturaAEntrenar = maestroInexperto.obtenerCriatura(criaturaDomesticada);

		maestroInexperto.entrenarCriatura(criaturaAEntrenar, 20);

	}

	@Test
	public void queElMaestroPuedaPacificarAUnaCriatura() throws CriaturaYaPacificadaException {

		maestro.añadirCriaturaAColeccion(criaturaSalvaje);
		Criatura criaturaAPacificar = maestro.obtenerCriatura(criaturaSalvaje);

		maestro.pacificarCriatura(criaturaAPacificar);
		ComportamientoEmocional comportamientoEsperado = ComportamientoEmocional.TRANQUILA;

		assertEquals(comportamientoEsperado, criaturaAPacificar.getComportamiento());

	}

	@Test(expected = CriaturaYaPacificadaException.class)
	public void queElMaestroNoPuedaPacificarAUnaCriaturaYaPacificada() throws CriaturaYaPacificadaException {

		maestro.añadirCriaturaAColeccion(criaturaDomesticada);
		Criatura criaturaAPacificar = maestro.obtenerCriatura(criaturaDomesticada);

		maestro.pacificarCriatura(criaturaAPacificar);

	}

}
