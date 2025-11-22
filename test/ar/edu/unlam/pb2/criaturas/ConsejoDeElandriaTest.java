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
	
	@Test
	public void validarQueSeObtengaLaCriaturaMasPoderosa() throws NoHayCriaturasException {
		ConsejoDeElandria consejo = new ConsejoDeElandria();
				
		Maestro maestro1 = new Maestro("Baltazar", 40, Afinidades.AGUA);
		CriaturaDomesticada criaturaDomesticada1 = new CriaturaDomesticada("Pablo", 60, Afinidades.TIERRA, ComportamientoEmocional.INESTABLE);
		maestro1.añadirCriaturaAColeccion(criaturaDomesticada1);
		
		
		Maestro maestro2 = new Maestro("Marcos", 50, Afinidades.AIRE);
		CriaturaDomesticada criaturaDomesticada2 = new CriaturaDomesticada("Pablo", 80, Afinidades.TIERRA, ComportamientoEmocional.INESTABLE);
		maestro2.añadirCriaturaAColeccion(criaturaDomesticada2);
		
		consejo.registrarMaestro(maestro1);
		consejo.registrarMaestro(maestro2);
		
		List<ICriatura> listaDeTodasLasCriaturas = consejo.obtenerTodasLasCriaturas();
		ICriatura criaturaConMasNivel = consejo.getCriaturaConMasNivel();
		
		Integer nivelEsperado = 80;
		Integer nivelObtenido = criaturaConMasNivel.getNivel();
		
		assertNotNull(listaDeTodasLasCriaturas);
		assertEquals(nivelEsperado, nivelObtenido);
	}

	@Test(expected = NoHayCriaturasException.class)
	public void alPedirLaCriaturaMasPoderosaSinDatosDebeLanzarExcepcion() throws NoHayCriaturasException {
	    ConsejoDeElandria consejo = new ConsejoDeElandria();

	    consejo.getCriaturaConMasNivel();
	}
	 
	@Test
	public void obtenerMaestroConMasCriaturasTransformadas() {
	    ConsejoDeElandria consejo = new ConsejoDeElandria();

	    Maestro maestro1 = new Maestro("Novato", 10, Afinidades.AGUA);
	    ICriatura criaturaBase1 = new CriaturaSalvaje("Pez", 100, Afinidades.AGUA, ComportamientoEmocional.TRANQUILA);
	    maestro1.añadirCriaturaAColeccion(criaturaBase1); 


	    Maestro maestro2= new Maestro("Experto", 50, Afinidades.FUEGO);
	    
	    ICriatura criatura1 = new CriaturaDomesticada("Fenix", 150, Afinidades.FUEGO, ComportamientoEmocional.TRANQUILA);
	    ICriatura criatura2 = new CriaturaAncestral("Golem", 120, Afinidades.TIERRA, ComportamientoEmocional.TRANQUILA);
	   
	    criatura1 =  new LlamaInterna(criatura1);        
	    criatura2 = new VinculoTerrestre(criatura2); 
	    
	    maestro2.añadirCriaturaAColeccion(criatura1);
	    maestro2.añadirCriaturaAColeccion(criatura2);


	    consejo.registrarMaestro(maestro1);
	    consejo.registrarMaestro(maestro2);

	    Maestro ganador = consejo.getMaestroConMasTransformaciones();

	    assertNotNull(ganador);
	    assertEquals(maestro2, ganador);
	}
	
}
