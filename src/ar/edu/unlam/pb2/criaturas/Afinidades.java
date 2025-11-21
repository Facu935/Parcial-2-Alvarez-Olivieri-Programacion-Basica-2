package ar.edu.unlam.pb2.criaturas;

public enum Afinidades {

	TIERRA{
		@Override
		public void interactuarCon (Criatura criaturaOriginal, Criatura otraCriatura)
				throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException{
            switch (otraCriatura.getAfinidad()) {
            case AIRE:
                if (!otraCriatura.esDomesticado()) {
                	otraCriatura.setComportamiento(ComportamientoEmocional.INESTABLE);
                }
                break;
            case TIERRA:
            	criaturaOriginal.ganarEnergia(10);
            	otraCriatura.ganarEnergia(10);
                break;
            default:
                break;
            }
		}
	},
	AGUA {
		@Override
		public void interactuarCon (Criatura criaturaOriginal, Criatura otraCriatura)
				throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException {
			 switch (otraCriatura.getAfinidad()) {
             case AGUA:
            	 criaturaOriginal.ganarEnergia(10);
                 otraCriatura.ganarEnergia(10);
                 break;
             case FUEGO:
                 // si la otra no está domesticada, se pone inestable
                 if (!otraCriatura.esDomesticado()) {
                	 otraCriatura.setComportamiento(ComportamientoEmocional.INESTABLE);
                 }
                 break;
             default:
                 // otras combinaciones no hacen nada por defecto
                 break;
			 }
		}
	},
	AIRE {
		@Override
		public void interactuarCon (Criatura criaturaOriginal, Criatura otraCriatura)
				throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException {
			switch (otraCriatura.getAfinidad()) {
            case TIERRA:
                if (!otraCriatura.esDomesticado()) {
                	otraCriatura.setComportamiento(ComportamientoEmocional.INESTABLE);
                }
                break;
            case AIRE:
            	criaturaOriginal.ganarEnergia(10);
                otraCriatura.ganarEnergia(10);
                break;
            default:
                break;
        }
		}
	},
	FUEGO {
		@Override
		public void interactuarCon (Criatura criaturaOriginal, Criatura otraCriatura)
				throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException {
			switch (otraCriatura.getAfinidad()) {
            case AGUA:
                if (!otraCriatura.esDomesticado()) {
                	otraCriatura.setComportamiento(ComportamientoEmocional.INESTABLE);
                }
                break;
            case FUEGO:
            	criaturaOriginal.ganarEnergia(10);
                otraCriatura.ganarEnergia(10);
                break;
            default:
                break;
			}
		}
		
	};
	
	public abstract void interactuarCon(Criatura criaturaOriginal, Criatura otraCriatura) throws EnergiaAcabadaException, MaximoDeEnergiaAlcanzadoException; 

}
