package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CriaturaTest {

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
		criaturaDomesticada = new CriaturaDomesticada("Pablo", 150, Afinidades.TIERRA, ComportamientoEmocional.TRANQUILA);
		criaturaSalvaje = new CriaturaSalvaje("Marcelo", 100, Afinidades.FUEGO, ComportamientoEmocional.INESTABLE);
		criaturaAncestral = new CriaturaAncestral("Jorge", 180, Afinidades.AIRE, ComportamientoEmocional.TRANQUILA);
	}
	
	


	
	@Test
	public void queExistaUnaCriaturaDomesticada() {
		Criatura criaturaDomesticada = new CriaturaDomesticada("Pablo", 150, Afinidades.TIERRA, ComportamientoEmocional.TRANQUILA);
		
		String nombreEsperado= "Pablo";
		Integer nivelEsperado = 150;
		Afinidades afinidadEsperada = Afinidades.TIERRA;
		ComportamientoEmocional comportamientoEsperado = ComportamientoEmocional.TRANQUILA;
	
		assertNotNull(criaturaDomesticada);
		assertEquals(nombreEsperado, criaturaDomesticada.getNombre());
		assertEquals(nivelEsperado, criaturaDomesticada.getNivel());
		assertEquals(afinidadEsperada, criaturaDomesticada.getAfinidad());
		assertEquals(comportamientoEsperado, criaturaDomesticada.getComportamiento());
		
	}
	
	@Test
	public void queExistaUnaCriaturaAncestral() {
		Criatura criaturaAncestral = new CriaturaAncestral("Jorge", 180, Afinidades.AIRE, ComportamientoEmocional.TRANQUILA);
		
		String nombreEsperado= "Jorge";
		Integer nivelEsperado = 180;
		Afinidades afinidadEsperada = Afinidades.AIRE;
		ComportamientoEmocional comportamientoEsperado = ComportamientoEmocional.TRANQUILA;
	
		assertNotNull(criaturaAncestral);
		assertEquals(nombreEsperado, criaturaAncestral.getNombre());
		assertEquals(nivelEsperado, criaturaAncestral.getNivel());
		assertEquals(afinidadEsperada, criaturaAncestral.getAfinidad());
		assertEquals(comportamientoEsperado, criaturaAncestral.getComportamiento());
		
	}

	
	@Test
	public void queElMaestroPuedaEntrenarAUnaCriaturaDomesticada() throws MaximoDeEnergiaAlcanzadoException {

		maestro.añadirCriaturaAColeccion(criaturaDomesticada);
		Criatura criaturaAEntrenar = maestro.obtenerCriatura(criaturaDomesticada);
		
		maestro.entrenarCriatura(criaturaAEntrenar, 20);

		Integer nivelEsperado = 170;
		
		assertEquals(nivelEsperado, criaturaDomesticada.getNivel());

	}
	
	
	
	
	
	
	
	
}
