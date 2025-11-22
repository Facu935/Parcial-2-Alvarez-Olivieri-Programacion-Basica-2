package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TransformacionesElementalesTest {
	private ICriatura miCriatura1;
	private ICriatura miCriatura2;
	private ICriatura miCriaturaAgua;
	private ICriatura criaturaConBajaEnergia;
	
	@Before
	public void setUp() throws Exception {
		miCriatura1 = new CriaturaSalvaje("Marcos", 50, Afinidades.FUEGO, ComportamientoEmocional.TRANQUILA);
		miCriatura2 = new CriaturaSalvaje("Marcos", 100, Afinidades.FUEGO, ComportamientoEmocional.TRANQUILA);
		miCriaturaAgua = new CriaturaSalvaje("Marcos", 100, Afinidades.AGUA, ComportamientoEmocional.TRANQUILA);
		criaturaConBajaEnergia = new CriaturaSalvaje("Felipe", 5, Afinidades.AGUA, ComportamientoEmocional.TRANQUILA);
	}
	
	@Test
	public void validarQueAlAplicarBendicionDelRioLaEnergiaSeDuplique() {
		Integer energiaInicial = miCriatura1.getNivel();
		Integer energiaInicialEsperada = 50;
		assertEquals(energiaInicialEsperada, energiaInicial);

		miCriatura1 = new BendicionDelRio(miCriatura1);
		
		Integer energiaActual = miCriatura1.getNivel();
		Integer energiaEsperada = 100;
		assertEquals(energiaEsperada, energiaActual);
	}
	
	@Test
	public void validarQueAlAplicarBendicionDelRioLaEnergiaNoSupereElLimite() {
		Integer energiaInicial = miCriatura2.getNivel();
		Integer energiaInicialEsperada = 100;
		assertEquals(energiaInicialEsperada, energiaInicial);

		miCriatura2 = new BendicionDelRio(miCriatura2);
		
		Integer energiaActual = miCriatura2.getNivel();
		Integer energiaEsperada = 180;
		assertEquals(energiaEsperada, energiaActual);
	}

	@Test
	public void validarQueAlAplicarLlamaInternaAUnaCriaturaDeFuegoTengaMasTreintaDeEnergia() {
		Integer energiaInicial = miCriatura1.getNivel();
		Integer energiaInicialEsperada = 50;
		assertEquals(energiaInicialEsperada, energiaInicial);

		miCriatura1 = new LlamaInterna(miCriatura1);
		
		Integer energiaActual = miCriatura1.getNivel();
		Integer energiaEsperada = 80;
		assertEquals(energiaEsperada, energiaActual);
	}
	
	@Test
	public void validarQueAlAplicarLlamaInternaAUnaCriaturaDistintaDeFuegoSeVuelvaInestable() {
		ComportamientoEmocional comportamientoInicial = miCriaturaAgua.getComportamiento();
		ComportamientoEmocional comportamientoInicialEsperada = ComportamientoEmocional.TRANQUILA;
		assertEquals(comportamientoInicialEsperada, comportamientoInicial);

		miCriaturaAgua = new LlamaInterna(miCriaturaAgua);
		
		ComportamientoEmocional comportamientoActual = miCriaturaAgua.getComportamiento();
		ComportamientoEmocional comportamientoEsperado = ComportamientoEmocional.INESTABLE;
		assertEquals(comportamientoEsperado, comportamientoActual);
	}
	
	@Test
    public void validarQueAlAplicarLlamaInternaAUnaCriaturaDeAguaLaEnergiaNOCambie() {
        Integer energiaInicial = miCriaturaAgua.getNivel();
        
        miCriaturaAgua = new LlamaInterna(miCriaturaAgua);
     
        Integer energiaActual = miCriaturaAgua.getNivel();
        
        assertEquals(energiaInicial, energiaActual);
    }
	
	@Test
    public void validarQueAlAplicarLlamaInternaAUnaCriaturaDeFuegoMantengaSuComportamiento() {
        assertEquals(Afinidades.FUEGO, miCriatura1.getAfinidad());
        assertEquals(ComportamientoEmocional.TRANQUILA, miCriatura1.getComportamiento());

        miCriatura1 = new LlamaInterna(miCriatura1);

        assertEquals(ComportamientoEmocional.TRANQUILA, miCriatura1.getComportamiento());
    }
	
	@Test
	public void validarQueAlAplicarVinculoTerrestreAUnaCriaturaSuEnergiaNoQuedeMenorACincuenta() {
		Integer energiaInicial = criaturaConBajaEnergia.getNivel();
		Integer energiaInicialEsperada = 5;
		assertEquals(energiaInicialEsperada, energiaInicial);

		criaturaConBajaEnergia = new VinculoTerrestre(miCriatura1);
		
		Integer energiaActual = criaturaConBajaEnergia.getNivel();
		Integer energiaEsperada = 50;
		assertEquals(energiaEsperada, energiaActual);
	}
	
	@Test
    public void validarQueAlAplicarVinculoTerrestreConEnergiaAltaNoSeModifique() {
        Integer energiaInicialEsperada = 100;
        assertEquals(energiaInicialEsperada, miCriatura2.getNivel());

        miCriatura2 = new VinculoTerrestre(miCriatura2);
        
        assertEquals(energiaInicialEsperada, miCriatura2.getNivel());
    }
	
	@Test
	public void validarQueAlAplicarAscensoDelVientoSuAfinidadSeaAire() {
		ICriatura miCriatura = new CriaturaSalvaje("Polo", 10, Afinidades.AGUA, ComportamientoEmocional.TRANQUILA);

		Afinidades afinidadInicial = miCriatura.getAfinidad();
		Afinidades afinidadInicialEsperada = Afinidades.AGUA;
		assertEquals(afinidadInicialEsperada, afinidadInicial);

		miCriatura = new AscensoDelViento(miCriatura);
		
		Afinidades afinidadActual = miCriatura.getAfinidad();
		Afinidades afinidadEsperada = Afinidades.AIRE;
		assertEquals(afinidadEsperada, afinidadActual);
	}
	
	@Test
	public void validarQueSePuedanCombinarDosTransformaciones() {
	    miCriatura1 = new LlamaInterna(miCriatura1);
	    miCriatura1 = new BendicionDelRio(miCriatura1);
	    
	    Integer energiaEsperada = 160; 
	    assertEquals(energiaEsperada, miCriatura1.getNivel());
	}
}
