package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TransformacionesElementalesTest {

	@Test
	public void validarQueAlAplicarBendicionDelRioLaEnergiaSeDuplique() {
		ICriatura miCriatura = new CriaturaSalvaje("Marcos", 50, Afinidades.FUEGO, ComportamientoEmocional.TRANQUILA);

		Integer energiaInicial = miCriatura.getNivel();
		Integer energiaInicialEsperada = 50;
		assertEquals(energiaInicialEsperada, energiaInicial);

		miCriatura = new BendicionDelRio(miCriatura);
		
		Integer energiaActual = miCriatura.getNivel();
		Integer energiaEsperada = 100;
		assertEquals(energiaEsperada, energiaActual);
	}
	
	// TEST PARA HACER
	// - Validar que al duplicarse no supere el limite de energia

	@Test
	public void validarQueAlAplicarLlamaInternaAUnaCriaturaDeFuegoTengaMasTreintaDeEnergia() {
		ICriatura miCriatura = new CriaturaSalvaje("Polo", 50, Afinidades.FUEGO, ComportamientoEmocional.TRANQUILA);

		Integer energiaInicial = miCriatura.getNivel();
		Integer energiaInicialEsperada = 50;
		assertEquals(energiaInicialEsperada, energiaInicial);

		miCriatura = new LlamaInterna(miCriatura);
		
		Integer energiaActual = miCriatura.getNivel();
		Integer energiaEsperada = 80;
		assertEquals(energiaEsperada, energiaActual);
	}
	
	@Test
	public void validarQueAlAplicarLlamaInternaAUnaCriaturaDistintaDeFuegoSeVuelvaInestable() {
		ICriatura miCriatura = new CriaturaSalvaje("Polo", 50, Afinidades.AGUA, ComportamientoEmocional.TRANQUILA);

		ComportamientoEmocional comportamientoInicial = miCriatura.getComportamiento();
		ComportamientoEmocional comportamientoInicialEsperada = ComportamientoEmocional.TRANQUILA;
		assertEquals(comportamientoInicialEsperada, comportamientoInicial);

		miCriatura = new LlamaInterna(miCriatura);
		
		ComportamientoEmocional comportamientoActual = miCriatura.getComportamiento();
		ComportamientoEmocional comportamientoEsperado = ComportamientoEmocional.INESTABLE;
		assertEquals(comportamientoEsperado, comportamientoActual);
	}
	
	// Puede haber un test de: Si la criatura no es fuego pero su ComportamientoEmocional ya es INESTABLE, puede haber una EXCEPCION??
	
	@Test
	public void validarQueAlAplicarVinculoTerrestreAUnaCriaturaSuEnergiaNoQuedeMenorACincuenta() {
		ICriatura miCriatura = new CriaturaSalvaje("Polo", 10, Afinidades.AGUA, ComportamientoEmocional.TRANQUILA);

		Integer energiaInicial = miCriatura.getNivel();
		Integer energiaInicialEsperada = 10;
		assertEquals(energiaInicialEsperada, energiaInicial);

		miCriatura = new VinculoTerrestre(miCriatura);
		
		Integer energiaActual = miCriatura.getNivel();
		Integer energiaEsperada = 50;
		assertEquals(energiaEsperada, energiaActual);
	}
	
	
	// Validar que al aplicar Vinculo Terrestre a una criatura con +50 energia retorne su energia original
	// Oportunidad de mejora: Test GENERAL que valide la parte de energiaInicial/energiaEsperada?
	
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
}
