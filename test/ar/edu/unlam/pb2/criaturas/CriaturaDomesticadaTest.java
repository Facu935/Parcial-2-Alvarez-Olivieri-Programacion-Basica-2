package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CriaturaDomesticadaTest {
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

	
	@Before
	
	public void setUp() throws Exception {
		maestro = new Maestro("Baltazar", 40, Afinidades.AGUA);
		criaturaDomesticada = new CriaturaDomesticada("Pablo", 80, Afinidades.TIERRA, ComportamientoEmocional.INESTABLE);
		maestro.añadirCriaturaAColeccion(criaturaDomesticada);
	}
	
	
	@Test
	public void queUnaCriaturaDomesticadaComienzeSiendoTranquila(){

		Criatura criaturaAEntrenar = maestro.obtenerCriatura(criaturaDomesticada);
		ComportamientoEmocional comportamientoEsperado = ComportamientoEmocional.TRANQUILA;
		
		assertEquals(comportamientoEsperado, criaturaAEntrenar.getComportamiento());
	}

	
	@Test
	public void queLaCriaturaDomesticadaSePuedaEntrenarEstablemente() throws MaximoDeEnergiaAlcanzadoException, FaltaDeMaestriaException{
		Criatura criaturaAEntrenar = maestro.obtenerCriatura(criaturaDomesticada);
		maestro.entrenarCriatura(criaturaAEntrenar, 20);

		Integer nivelEsperado = 100;
		
		assertEquals(nivelEsperado, criaturaAEntrenar.getNivel());

	}
	
	
	@Test (expected = MaximoDeEnergiaAlcanzadoException.class)
	public void queLaCriaturaDomesticadaNoPuedaSubirDeMásDe200DeEnergia() throws MaximoDeEnergiaAlcanzadoException, FaltaDeMaestriaException{
		CriaturaElemental criaturaDomesticada = new CriaturaDomesticada("Pablo", 190, Afinidades.TIERRA, ComportamientoEmocional.INESTABLE);
		maestro.añadirCriaturaAColeccion(criaturaDomesticada);
		Criatura criaturaAEntrenar = maestro.obtenerCriatura(criaturaDomesticada);
		
		maestro.entrenarCriatura(criaturaAEntrenar, 20);

	}
	
	@Test (expected = CriaturaYaPacificadaException.class)
	public void queLaCriaturaDomesticadaNoSePacifiqueYaQueYaLoEsta() throws CriaturaYaPacificadaException{
		Criatura criaturaAPacificar = maestro.obtenerCriatura(criaturaDomesticada);
		maestro.pacificarCriatura(criaturaAPacificar);

;

	}
	
	

}
