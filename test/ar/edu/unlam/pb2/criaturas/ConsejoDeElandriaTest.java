package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class ConsejoDeElandriaTest {

	@Test
	public void validarQueSePuedaRegistrarUnMaestro() {
		ConsejoDeElandria consejo = new ConsejoDeElandria();
		Maestro maestro = new Maestro("Marcos Bonavena", 50, Afinidades.FUEGO);
		
		consejo.registrarMaestro(maestro);
		Integer maestrosRegistrados = consejo.getCantidadDeMaestrosRegistrados();
		Integer maestrosEsperados = 1;
		
		assertNotNull(maestrosRegistrados);
		assertEquals(maestrosEsperados, maestrosRegistrados);
		
	}
	
	@Test
	public void validarQueSeListenTodasLasCriaturasRegristradasPorLosMaestros() {
		ConsejoDeElandria consejo = new ConsejoDeElandria();
				
		Maestro maestro1 = new Maestro("Baltazar", 40, Afinidades.AGUA);
		CriaturaDomesticada criaturaDomesticada1 = new CriaturaDomesticada("Pablo", 80, Afinidades.TIERRA, ComportamientoEmocional.INESTABLE);
		maestro1.añadirCriaturaAColeccion(criaturaDomesticada1);
		
		
		Maestro maestro2 = new Maestro("Marcos", 50, Afinidades.AIRE);
		CriaturaDomesticada criaturaDomesticada2 = new CriaturaDomesticada("Pablo", 80, Afinidades.TIERRA, ComportamientoEmocional.INESTABLE);
		maestro2.añadirCriaturaAColeccion(criaturaDomesticada2);
		
		consejo.registrarMaestro(maestro1);
		consejo.registrarMaestro(maestro2);
		
		List<ICriatura> listaDeTodasLasCriaturas = consejo.obtenerTodasLasCriaturas();
		assertNotNull(listaDeTodasLasCriaturas);
		assertEquals(2, listaDeTodasLasCriaturas.size());
	}

}
