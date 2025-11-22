package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ConsejoDeElandriaTest {
	private ConsejoDeElandria consejo;
	private Maestro maestro1;
	private Maestro maestro2;
	private ICriatura criaturaDomesticada1;
	private ICriatura criaturaDomesticada2;
	private ICriatura criaturaBase1;
	private ICriatura criatura1;
	private ICriatura criatura2;

	@Before
	public void setUp() throws Exception {
		maestro1 = new Maestro("Baltazar", 40, Afinidades.TIERRA);
		maestro2 = new Maestro("Marcos", 50, Afinidades.AIRE);
		consejo = new ConsejoDeElandria();
		criaturaDomesticada1 = new CriaturaDomesticada("Pablo", 80, Afinidades.TIERRA,
				ComportamientoEmocional.INESTABLE);
		criaturaDomesticada2 = new CriaturaDomesticada("Pablo", 80, Afinidades.TIERRA,
				ComportamientoEmocional.INESTABLE);
		criaturaBase1 = new CriaturaSalvaje("Pez", 100, Afinidades.AGUA, ComportamientoEmocional.TRANQUILA);
		criatura1 = new CriaturaDomesticada("Fenix", 150, Afinidades.FUEGO, ComportamientoEmocional.TRANQUILA);
		criatura2 = new CriaturaAncestral("Golem", 120, Afinidades.TIERRA, ComportamientoEmocional.TRANQUILA);
	}

	@Test
	public void validarQueSePuedaRegistrarUnMaestro() {
		consejo.registrarMaestro(maestro1);
		Integer maestrosRegistrados = consejo.getCantidadDeMaestrosRegistrados();
		Integer maestrosEsperados = 1;

		assertNotNull(maestrosRegistrados);
		assertEquals(maestrosEsperados, maestrosRegistrados);
	}

	@Test
	public void validarQueSeListenTodasLasCriaturasRegristradasPorLosMaestros() {
		maestro1.añadirCriaturaAColeccion(criaturaDomesticada1);
		maestro2.añadirCriaturaAColeccion(criaturaDomesticada2);

		consejo.registrarMaestro(maestro1);
		consejo.registrarMaestro(maestro2);

		List<ICriatura> listaDeTodasLasCriaturas = consejo.obtenerTodasLasCriaturas();

		assertNotNull(listaDeTodasLasCriaturas);
		assertEquals(2, listaDeTodasLasCriaturas.size());
	}

	@Test
	public void validarQueSeObtengaLaCriaturaMasPoderosa() throws NoHayCriaturasException {
		maestro1.añadirCriaturaAColeccion(criaturaDomesticada1);
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
		maestro1.añadirCriaturaAColeccion(criaturaBase1);

		criatura1 = new LlamaInterna(criatura1);
		criatura2 = new VinculoTerrestre(criatura2);

		maestro2.añadirCriaturaAColeccion(criatura1);
		maestro2.añadirCriaturaAColeccion(criatura2);

		consejo.registrarMaestro(maestro1);
		consejo.registrarMaestro(maestro2);

		Maestro ganador = consejo.getMaestroConMasTransformaciones();

		assertNotNull(ganador);
		assertEquals(maestro2, ganador);
	}
	
	@Test
	public void validarQueSeGenereReporteDeCantidadDeCriaturasPorAfinidad() throws NoHayCriaturasException {
	    
	    maestro1.añadirCriaturaAColeccion(criaturaDomesticada1);
	    maestro1.añadirCriaturaAColeccion(criatura2);       

	    maestro2.añadirCriaturaAColeccion(criaturaBase1);

	    consejo.registrarMaestro(maestro1);
	    consejo.registrarMaestro(maestro2);

	    Map<Afinidades, Integer> reporte = consejo.obtenerReporteDeAfinidades();

	    assertNotNull(reporte);
	    assertEquals((Integer) 2, reporte.get(Afinidades.TIERRA));
	    assertEquals((Integer) 1, reporte.get(Afinidades.AGUA));
	    assertNull(reporte.get(Afinidades.FUEGO)); 
	}
	
	@Test(expected = NoHayCriaturasException.class)
	public void validarQueAlPedirReporteDeAfinidadesSinDatosSeLanceExcepcion() throws NoHayCriaturasException {
	    consejo.obtenerReporteDeAfinidades();
	}

}
