package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CriaturaElementalTest {

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
	
	
	private CriaturaElemental criaturaDomesticada;
	private CriaturaElemental criaturaSalvaje;
	private CriaturaElemental criaturaAncestral;
	
	@Before
	
	public void setUp() throws Exception {
		criaturaDomesticada = new CriaturaDomesticada("Pablo", 60, Afinidades.TIERRA, ComportamientoEmocional.TRANQUILA);
		criaturaSalvaje = new CriaturaSalvaje("Marcelo", 100, Afinidades.FUEGO, ComportamientoEmocional.INESTABLE);
		criaturaAncestral = new CriaturaAncestral("Jorge", 120, Afinidades.AIRE, ComportamientoEmocional.TRANQUILA);
	}
	
	@Test
	public void queUnaCriaturaRecibaLaBendicionDelAguaYSeDupliqueSuEnergia() {
		criaturaDomesticada.bendicionDelRio();

		
		Integer valorEsperadoDomesticado = 120;
		
		assertEquals(valorEsperadoDomesticado, criaturaDomesticada.getNivel());
		
	}

}
