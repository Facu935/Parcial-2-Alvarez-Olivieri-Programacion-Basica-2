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
	private CriaturaElemental criaturaDomesticada;
	private CriaturaElemental criaturaSalvaje;
	private CriaturaElemental criaturaAncestral;
	
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
	public void queElMaestroPuedaEntrenarAUnaCriaturaDomesticada() throws MaximoDeEnergiaAlcanzadoException, FaltaDeMaestriaException, EnergiaAcabadaException {

		maestro.añadirCriaturaAColeccion(criaturaDomesticada);
		Criatura criaturaAEntrenar = maestro.obtenerCriatura(criaturaDomesticada);
		
		maestro.entrenarCriatura(criaturaAEntrenar, 20);

		Integer nivelEsperado = 170;
		
		assertEquals(nivelEsperado, criaturaDomesticada.getNivel());

	}
	
												////////////   Parte 3	////////////
	
	@Test
	public void queLasCriaturasAumentenEn10SuEnergiaSiCompartenAfinidad() throws MaximoDeEnergiaAlcanzadoException, EnergiaAcabadaException {
		Criatura criaturaTierra1 = new CriaturaDomesticada("Juan", 80, Afinidades.TIERRA, ComportamientoEmocional.TRANQUILA);
		Criatura criaturaTierra2 = new CriaturaSalvaje("Pedro", 70, Afinidades.TIERRA, ComportamientoEmocional.TRANQUILA);
		
		criaturaTierra1.interactuar(criaturaTierra2);
		
		Integer valorEsperadoCriaturaTierra1 = 90;
		Integer valorEsperadoCriaturaTierra2 = 80;

		assertEquals(valorEsperadoCriaturaTierra1, criaturaTierra1.getNivel());
		assertEquals(valorEsperadoCriaturaTierra2, criaturaTierra2.getNivel());

	}
	
	@Test
	public void queLasCriaturasSeVuelvanInestablesSiTienenAfinidadOpuesta() throws MaximoDeEnergiaAlcanzadoException, EnergiaAcabadaException {
		Criatura criaturaAgua = new CriaturaAncestral("Juan", 100, Afinidades.AGUA, ComportamientoEmocional.TRANQUILA);
		Criatura criaturaFuego = new CriaturaAncestral("Pedro", 100, Afinidades.FUEGO, ComportamientoEmocional.TRANQUILA);
		Criatura criaturaTierra = new CriaturaAncestral("Facu", 100, Afinidades.TIERRA, ComportamientoEmocional.TRANQUILA);
		Criatura criaturaAire = new CriaturaAncestral("Fede", 100, Afinidades.AIRE, ComportamientoEmocional.TRANQUILA);
		
		criaturaAgua.interactuar(criaturaFuego);
		criaturaTierra.interactuar(criaturaAire);
		
		criaturaFuego.interactuar(criaturaAgua);
		criaturaAire.interactuar(criaturaTierra);
		
		ComportamientoEmocional valorEsperadoCriaturaFuego = ComportamientoEmocional.INESTABLE;
		ComportamientoEmocional valorEsperadoCriaturaAgua = ComportamientoEmocional.INESTABLE;
		
		ComportamientoEmocional valorEsperadoCriaturaTierra = ComportamientoEmocional.INESTABLE;
		ComportamientoEmocional valorEsperadoCriaturaAire = ComportamientoEmocional.INESTABLE;

		assertEquals(valorEsperadoCriaturaFuego, criaturaFuego.getComportamiento());
		assertEquals(valorEsperadoCriaturaAgua, criaturaAire.getComportamiento());
		assertEquals(valorEsperadoCriaturaAire, criaturaAire.getComportamiento());
		assertEquals(valorEsperadoCriaturaTierra, criaturaTierra.getComportamiento());

	}
	
	@Test
	public void queSiSonDomesticadasNoCambienSuComportamientoAunqueTenganAfinidadesOpuestas() throws MaximoDeEnergiaAlcanzadoException, EnergiaAcabadaException {
		Criatura criatura1 = new CriaturaDomesticada("Juan", 100, Afinidades.AGUA, ComportamientoEmocional.TRANQUILA);
		Criatura criatura2 = new CriaturaAncestral("Pedro", 100, Afinidades.FUEGO, ComportamientoEmocional.TRANQUILA);
		
		criatura1.interactuar(criatura2);
		
		ComportamientoEmocional valorEsperadoCriatura1 = ComportamientoEmocional.TRANQUILA;
		ComportamientoEmocional valorEsperadoCriatura2 = ComportamientoEmocional.INESTABLE;

		assertEquals(valorEsperadoCriatura1, criatura1.getComportamiento());
		assertEquals(valorEsperadoCriatura2, criatura2.getComportamiento());

	}
	
	
	
	@Test
	public void queUnaCriaturaAncestralGane20deEnergiaSiInteractuaConOtraCriaturaDiferente() throws MaximoDeEnergiaAlcanzadoException, EnergiaAcabadaException {
		Criatura primeraCriaturaAncestral = new CriaturaAncestral("Pedro", 100, Afinidades.FUEGO, ComportamientoEmocional.TRANQUILA);
		Criatura primeraCriaturaDiferente = new CriaturaDomesticada("Juan", 50, Afinidades.AGUA, ComportamientoEmocional.TRANQUILA);
		
		Criatura segundaCriaturaAncestral = new CriaturaAncestral("Pepe", 120, Afinidades.FUEGO, ComportamientoEmocional.TRANQUILA);
		Criatura segundaCriaturaDiferente = new CriaturaDomesticada("Luis", 30, Afinidades.AGUA, ComportamientoEmocional.TRANQUILA);
		
		
		
		primeraCriaturaAncestral .interactuar(primeraCriaturaDiferente);
		segundaCriaturaDiferente.interactuar(segundaCriaturaAncestral);
		
		Integer valorEsperadoAncestral1 = 120;
		Integer valorEsperadoOtraCriatura1 = 35;
		
		Integer valorEsperadoAncestral2 = 140;
		Integer valorEsperadoOtraCriatura2 = 15;
		

		assertEquals(valorEsperadoAncestral1, primeraCriaturaAncestral.getNivel());
		assertEquals(valorEsperadoOtraCriatura1, primeraCriaturaDiferente.getNivel());
		
		assertEquals(valorEsperadoAncestral2, segundaCriaturaAncestral.getNivel());
		assertEquals(valorEsperadoOtraCriatura2, segundaCriaturaDiferente.getNivel());
		

	}
	
	@Test (expected = EnergiaAcabadaException.class)
	public void queLaOtraCriaturaNoBajeDe0AlInteraccionarConUnaAncestral() throws MaximoDeEnergiaAlcanzadoException, EnergiaAcabadaException {
		Criatura primeraCriaturaAncestral = new CriaturaAncestral("Pedro", 100, Afinidades.FUEGO, ComportamientoEmocional.TRANQUILA);
		Criatura primeraCriaturaDiferente = new CriaturaDomesticada("Juan", 5, Afinidades.AGUA, ComportamientoEmocional.TRANQUILA);
		
		Criatura segundaCriaturaAncestral = new CriaturaAncestral("Pepe", 120, Afinidades.FUEGO, ComportamientoEmocional.TRANQUILA);
		Criatura segundaCriaturaDiferente = new CriaturaDomesticada("Luis", 10, Afinidades.AGUA, ComportamientoEmocional.TRANQUILA);
		
		
		
		primeraCriaturaAncestral.interactuar(primeraCriaturaDiferente);
		segundaCriaturaDiferente.interactuar(segundaCriaturaAncestral);

	}
	

	
	
	
	
	
	
	
	
	
	
	
}
