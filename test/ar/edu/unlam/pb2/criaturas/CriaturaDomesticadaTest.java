package ar.edu.unlam.pb2.criaturas;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CriaturaDomesticadaTest {
	private Maestro maestro;
	private ICriatura criaturaDomesticada;

	@Before

	public void setUp() throws Exception {
		maestro = new Maestro("Baltazar", 40, Afinidades.AGUA);
		criaturaDomesticada = new CriaturaDomesticada("Pablo", 80, Afinidades.TIERRA,
				ComportamientoEmocional.INESTABLE);
		maestro.añadirCriaturaAColeccion(criaturaDomesticada);
	}

	@Test
	public void queUnaCriaturaDomesticadaComienzeSiendoTranquila() {

		ICriatura criaturaAEntrenar = maestro.obtenerCriatura(criaturaDomesticada.getNombre());
		ComportamientoEmocional comportamientoEsperado = ComportamientoEmocional.TRANQUILA;

		assertEquals(comportamientoEsperado, criaturaAEntrenar.getComportamiento());
	}

	@Test
	public void queLaCriaturaDomesticadaSePuedaEntrenarEstablemente()
			throws MaximoDeEnergiaAlcanzadoException, FaltaDeMaestriaException, EnergiaAcabadaException {

		ICriatura criaturaAEntrenar = maestro.obtenerCriatura(criaturaDomesticada.getNombre());
		maestro.entrenarCriatura(criaturaAEntrenar, 20);

		Integer nivelEsperado = 100;

		assertEquals(nivelEsperado, criaturaAEntrenar.getNivel());

	}

	@Test(expected = MaximoDeEnergiaAlcanzadoException.class)
	public void queLaCriaturaDomesticadaNoPuedaSubirDeMásDe200DeEnergia()
			throws MaximoDeEnergiaAlcanzadoException, FaltaDeMaestriaException, EnergiaAcabadaException {
		ICriatura criaturaDomesticada = new CriaturaDomesticada("Pablo", 190, Afinidades.TIERRA,
				ComportamientoEmocional.INESTABLE);
		maestro.añadirCriaturaAColeccion(criaturaDomesticada);
		ICriatura criaturaAEntrenar = maestro.obtenerCriatura(criaturaDomesticada.getNombre());

		maestro.entrenarCriatura(criaturaAEntrenar, 20);

	}

	@Test(expected = CriaturaYaPacificadaException.class)
	public void queLaCriaturaDomesticadaNoSePacifiqueYaQueYaLoEsta() throws CriaturaYaPacificadaException {
		ICriatura criaturaAPacificar = maestro.obtenerCriatura(criaturaDomesticada.getNombre());
		maestro.pacificarCriatura(criaturaAPacificar);

	}

}
