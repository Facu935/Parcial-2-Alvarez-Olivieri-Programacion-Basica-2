package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CriaturaElementalTest {
	private Maestro maestro;
	private CriaturaElemental criaturaDomesticada;
	private CriaturaElemental criaturaSalvaje;
	private CriaturaElemental criaturaAncestral;
	
	@Before
	public void setUp() throws Exception {
		maestro = new Maestro("Baltazar", 40, Afinidades.TIERRA);
		criaturaDomesticada = new CriaturaDomesticada("Pablo", 60, Afinidades.TIERRA, ComportamientoEmocional.TRANQUILA);
		criaturaSalvaje = new CriaturaSalvaje("Marcelo", 100, Afinidades.FUEGO, ComportamientoEmocional.INESTABLE);
		criaturaAncestral = new CriaturaAncestral("Jorge", 120, Afinidades.AIRE, ComportamientoEmocional.TRANQUILA);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
							///////////////////////	Test Bendicion del Agua ///////////////////////
	@Test
	public void queUnaCriaturaRecibaLaBendicionDelAguaYSeDupliqueSuEnergia() {
		criaturaDomesticada.bendicionDelRio();

		Integer valorEsperadoDomesticado = 120;
		
		assertEquals(valorEsperadoDomesticado, criaturaDomesticada.getNivel());
		
	}
	
	@Test
	public void queUnaCriaturaRecibaLaBendicionDelAguaYNoSePaseDelLimiteDe180() {
		CriaturaElemental criaturaDomesticadaConTope = new CriaturaDomesticada("Pablo", 95, Afinidades.TIERRA, ComportamientoEmocional.TRANQUILA);
		criaturaDomesticadaConTope.bendicionDelRio();
		
		Integer valorEsperado = 180;
		
		assertEquals(valorEsperado, criaturaDomesticadaConTope.getNivel());
	}
	
	@Test
	public void queUnaCriaturaAncestralRecibaLaBendicionDelAguaYNoSePaseDelLimiteDe180() {
		CriaturaElemental criaturaDomesticadaConTope = new CriaturaAncestral("Jorge", 105, Afinidades.TIERRA, ComportamientoEmocional.TRANQUILA);
		criaturaDomesticadaConTope.bendicionDelRio();
		
		Integer valorEsperado = 180;
		
		assertEquals(valorEsperado, criaturaDomesticadaConTope.getNivel());
	}

	
							/////////////////////// Test LLAMA INTERNA	///////////////////////
	
	
	@Test
	public void queUnaCriaturaConAfinidadDeFuegoRecibaBendicionDeFuegoYAumenteEn30SuEnergia() {
		CriaturaElemental ancestralDeFuego = new CriaturaAncestral("Jorge", 120, Afinidades.FUEGO, ComportamientoEmocional.TRANQUILA);
		ancestralDeFuego.llamaInterna();
		
		Integer valorEsperadoDomesticado = 150;
		
		assertEquals(valorEsperadoDomesticado, ancestralDeFuego.getNivel());
		
	}
	
	@Test
	public void queUnaCriaturaConCualquierOtraAfinidadSeVuelvaInestableConLlamaInterna() {
		CriaturaElemental ancestralDeTierra = new CriaturaAncestral("Facu", 120, Afinidades.TIERRA, ComportamientoEmocional.TRANQUILA);
		ancestralDeTierra.llamaInterna();
		
		ComportamientoEmocional esperado = ComportamientoEmocional.INESTABLE;
		
		assertEquals(esperado, ancestralDeTierra.getComportamiento());
		
	}
	
	@Test
	public void queUnaCriaturaDomesticadaSinAfinidadDeFuegoPermanezcaTranquilaConLlamaInterna() {
		CriaturaElemental domesticadoDeAire = new CriaturaDomesticada("Feli", 80, Afinidades.AIRE, ComportamientoEmocional.TRANQUILA);
		domesticadoDeAire.llamaInterna();
		
		ComportamientoEmocional esperado = ComportamientoEmocional.TRANQUILA;
		
		assertEquals(esperado, domesticadoDeAire.getComportamiento());
		
	}
	
	
							/////////////////////// Test VINCULO TERRESTE	///////////////////////
	@Test
	public void queElVinculoTerrestreNoDejeQueBajeDe50DeEnergiaALaCriatura() throws MaximoDeEnergiaAlcanzadoException, FaltaDeMaestriaException {
		
		criaturaDomesticada.vinculoTerrestre();
		maestro.entrenarCriatura(criaturaDomesticada, -20);
		
		
		Integer valorEsperado = 50;
		
		assertEquals(valorEsperado, criaturaDomesticada.getNivel());
		
	}
	
	/*
	 * Hacer Test de:
	 * Bendicion de Agua para Salvajes
	 * 
	 * */
	
}
