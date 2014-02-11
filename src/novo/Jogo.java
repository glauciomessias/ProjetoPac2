package novo;

public class Jogo {
	
	private char[] mapa;
	private int posicaoBola = 8;
	private int posicaoFantasma = 0;
	private char coisaEmbaixoDoFantasma = ' ';
	private boolean isDireita = true;
	private boolean morreu = false;
	private boolean isFraco = true;
	private boolean matouFantasma = false;
	
	public Jogo() {
		mapa = new char[]{'@', ' ', ' ', ' ', ' ', '-', '-', ' ', '<', ' ', '-', '-', '-', '-', '-', '-', '-', '-', '-', '*'};
		mapa[8] = aparencia();
		mapa[finalDaLinha()] = '*';
	}
	
	public void esperar() {
		if(!morreu) {
			int posicaoAnterior = posicaoBola;
			if (isDireita) {
				if (posicaoBola < finalDaLinha()) posicaoBola++;
			} else
				if (posicaoBola > 0) posicaoBola--;
			
			moverBola(posicaoAnterior);
			moverFantasma();
		}
 	}

	private void moverFantasma() {
		mapa[posicaoFantasma] = coisaEmbaixoDoFantasma;
		if(posicaoFantasma < finalDaLinha())
			posicaoFantasma++;
		if(posicaoFantasma == posicaoBola) {
			if(isFraco) {
				morreu = true;
			} else {
				matouFantasma = true;
			}
		}
		coisaEmbaixoDoFantasma = mapa[posicaoFantasma];
		if(!matouFantasma) {
			mapa[posicaoFantasma] = '@';
		}
	}

	private void moverBola(int posicaoAnterior) {
		mapa[posicaoAnterior] = ' ';
		if(mapa[posicaoBola] == '*') {
			isFraco = false;
		}
		mapa[posicaoBola] = aparencia();
	}

	
	private int finalDaLinha() {
		return mapa.length - 1;
	}

	
	private char aparencia() {
		return isFraco ? (isDireita ? '<' : '>') : 'O';
	}

	
	public String getTela() {
		StringBuilder tela = new StringBuilder();
		return "|" + tela.append(mapa).toString() + "|";
	}

	
	public void esquerda() { isDireita = false;	}
	public void  direita() { isDireita = true;  }
	public boolean isMorto() { return morreu;   }
}
