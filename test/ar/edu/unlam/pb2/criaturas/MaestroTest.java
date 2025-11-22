package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaestroTest {
	private Maestro maestro;
	private ICriatura criaturaDomesticada;
	private ICriatura criaturaSalvaje;
	private ICriatura criaturaAncestral;

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
		ICriatura criaturaAEntrenar = maestro.obtenerCriatura(criaturaDomesticada.getNombre());

		assertEquals(criaturaAEntrenar.getNombre(), criaturaDomesticada.getNombre());
	}

	@Test
	public void queElMaestroPuedaEntrenarAUnaCriatura()
			throws MaximoDeEnergiaAlcanzadoException, FaltaDeMaestriaException, EnergiaAcabadaException {

		maestro.añadirCriaturaAColeccion(criaturaDomesticada);
		ICriatura criaturaAEntrenar = maestro.obtenerCriatura(criaturaDomesticada.getNombre());

		maestro.entrenarCriatura(criaturaAEntrenar, 20);

		Integer nivelEsperado = 100;

		assertEquals(nivelEsperado, criaturaDomesticada.getNivel());
	}

	@Test(expected = FaltaDeMaestriaException.class)
	public void queElMaestroNoPuedaEntrenarAUnaCriaturaSiNoTieneLaSuficienteMaestria()
			throws MaximoDeEnergiaAlcanzadoException, FaltaDeMaestriaException, EnergiaAcabadaException {
		Maestro maestroInexperto = new Maestro("Baltazar", 15, Afinidades.FUEGO);

		maestroInexperto.añadirCriaturaAColeccion(criaturaDomesticada);
		ICriatura criaturaAEntrenar = maestroInexperto.obtenerCriatura(criaturaDomesticada.getNombre());

		maestroInexperto.entrenarCriatura(criaturaAEntrenar, 20);
	}

	@Test
	public void queElMaestroPuedaPacificarAUnaCriatura() throws CriaturaYaPacificadaException {

		maestro.añadirCriaturaAColeccion(criaturaSalvaje);
		ICriatura criaturaAPacificar = maestro.obtenerCriatura(criaturaSalvaje.getNombre());

		maestro.pacificarCriatura(criaturaAPacificar);
		ComportamientoEmocional comportamientoEsperado = ComportamientoEmocional.TRANQUILA;

		assertEquals(comportamientoEsperado, criaturaAPacificar.getComportamiento());
	}

	@Test(expected = CriaturaYaPacificadaException.class)
	public void queElMaestroNoPuedaPacificarAUnaCriaturaYaPacificada() throws CriaturaYaPacificadaException {

		maestro.añadirCriaturaAColeccion(criaturaDomesticada);
		ICriatura criaturaAPacificar = maestro.obtenerCriatura(criaturaDomesticada.getNombre());

		maestro.pacificarCriatura(criaturaAPacificar);
	}

}
