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
	private Criatura criaturaDomesticada;
	private Criatura criaturaAncestral;
	
	@Before
	
	public void setUp() throws Exception {
		maestro = new Maestro("Baltazar", 40, Afinidades.TIERRA);
		criaturaDomesticada = new CriaturaDomesticada("Pablo", 150, Afinidades.TIERRA, ComportamientoEmocional.TRANQUILA);
		criaturaAncestral = new CriaturaAncestral("Jorge", 180, Afinidades.AIRE, ComportamientoEmocional.TRANQUILA);
	}
	
	
	@Test (expected = MaximoDeEnergiaAlcanzadoException.class)
	public void queLaCriaturaDomesticadaNoPuedaSubirDeMásDe200DeEnergia() throws MaximoDeEnergiaAlcanzadoException{

		maestro.añadirCriaturaAColeccion(criaturaDomesticada);
		Criatura criaturaAEntrenar = maestro.obtenerCriatura(criaturaDomesticada);
		
		maestro.entrenarCriatura(criaturaAEntrenar, 200);

		

	}

}
