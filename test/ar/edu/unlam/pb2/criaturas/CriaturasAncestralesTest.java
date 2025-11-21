package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CriaturasAncestralesTest {

	
	
	private Maestro maestro;
	private CriaturaElemental criaturaAncestral;
	
	@Before
	public void setUp() throws Exception {
		maestro = new Maestro("Baltazar", 40, Afinidades.AGUA);
		criaturaAncestral = new CriaturaAncestral("Smaug", 80, Afinidades.TIERRA, ComportamientoEmocional.TRANQUILA);
		maestro.añadirCriaturaAColeccion(criaturaAncestral);
	}
	
	
	
	@Test
	public void queLaCriaturaAncestralComienzeCon100deEnergiaSiempre() {
		Criatura criaturaATestear = maestro.obtenerCriatura(criaturaAncestral);
		
		Integer nivelEsperado = 100;
		
		assertEquals(nivelEsperado, criaturaATestear.getNivel());
	}
	
	
	@Test
	public void queLaCriaturaAncestralSePuedaEntrenarEstablemente() throws MaximoDeEnergiaAlcanzadoException, FaltaDeMaestriaException{
		Criatura criaturaAEntrenar = maestro.obtenerCriatura(criaturaAncestral);
		maestro.entrenarCriatura(criaturaAEntrenar, 20);

		Integer nivelEsperado = 120;
		
		assertEquals(nivelEsperado, criaturaAEntrenar.getNivel());

	}
	@Test
	public void queLaCriaturaAncestralNoPuedaBajarSuEnergiaDe100() throws MaximoDeEnergiaAlcanzadoException, FaltaDeMaestriaException {
		Criatura criaturaAEntrenar = maestro.obtenerCriatura(criaturaAncestral);
		maestro.entrenarCriatura(criaturaAEntrenar, -20);
		Integer nivelEsperado = 100;
		
		assertEquals(nivelEsperado, criaturaAEntrenar.getNivel());
	}
	
	
	@Test
	public void queLaCriaturaAncestralAlEsforzarMuchoSeVuelvaInestable() throws MaximoDeEnergiaAlcanzadoException, FaltaDeMaestriaException {
		Criatura criaturaAEntrenar = maestro.obtenerCriatura(criaturaAncestral);
		maestro.entrenarCriatura(criaturaAEntrenar, 80);
		
		ComportamientoEmocional comportamientoEsperado = ComportamientoEmocional.INESTABLE;
		
		assertEquals(comportamientoEsperado, criaturaAncestral.getComportamiento());
	}
	
	@Test
	public void queLaCriaturaAncestralSePuedePacificarSiEstaInestable() throws CriaturaYaPacificadaException {
		CriaturaElemental criaturaAncestralInestable = new CriaturaAncestral("Felix", 80, Afinidades.TIERRA, ComportamientoEmocional.INESTABLE);
		maestro.añadirCriaturaAColeccion(criaturaAncestralInestable);
		
		Criatura criaturaAPacificar = maestro.obtenerCriatura(criaturaAncestralInestable);
		
		maestro.pacificarCriatura(criaturaAPacificar);
		
		ComportamientoEmocional comportamientoEsperado = ComportamientoEmocional.TRANQUILA;
		
		assertEquals(comportamientoEsperado, criaturaAncestralInestable.getComportamiento());
	}

}
