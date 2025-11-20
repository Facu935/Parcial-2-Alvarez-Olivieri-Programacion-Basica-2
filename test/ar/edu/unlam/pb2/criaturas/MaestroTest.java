package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MaestroTest {


	/*
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	

	@After
	public void tearDown() throws Exception {
	}
	*/
	
	private Maestro maestro;
	private Criatura criaturaDomesticada;
	private Criatura criaturaSalvaje;
	private Criatura criaturaAncestral;
	
	@Before
	
	public void setUp() throws Exception {
		maestro = new Maestro("Baltazar", 40, Afinidades.TIERRA);
		criaturaDomesticada = new Domesticada("Pablo", 150, Afinidades.TIERRA, ComportamientoEmocional.TRANQUILA);
		criaturaSalvaje = new Salvaje("Marcelo", 100, Afinidades.FUEGO, ComportamientoEmocional.INESTABLE);
		criaturaAncestral = new Ancestral("Jorge", 180, Afinidades.AIRE, ComportamientoEmocional.TRANQUILA);
	}
	
	
	
	
	
	
	
	
	@Test
	public void queExistaUnMaestroConTodasSusCaracteristicas() {
		
		
		String nombreEsperado= "Baltazar";
		Integer maestriaEsperado = 40;
		Afinidades afinidadEsperada = Afinidades.TIERRA;
	
		assertNotNull(maestro);
		assertEquals(nombreEsperado, maestro.getNombre());
		assertEquals(maestriaEsperado, maestro.getMaestria());
		assertEquals(afinidadEsperada, maestro.getAfinidad());
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



}
