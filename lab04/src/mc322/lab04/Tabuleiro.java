package mc322.lab04;

public class Tabuleiro{
	
	Peca matriz[][] = new Peca[7][8];
	
	public void inserePeca(Peca pc, int x, int y, char c) {
        if (y <= 7 && x < 7) {
            matriz[x][y] = pc;
            pc.P = c;
            if (y > 0) {
                pc.pecaEsquerda(matriz[x][y-1]);
                if (matriz[x][y-1] != null)
                    matriz[x][y-1].pecaDireita(pc);
            } else
                pc.pecaEsquerda(null);
            if (y < 6) {
                pc.pecaDireita(matriz[x][y+1]);
                if (matriz[x][y+1] != null)
                    matriz[x][y+1].pecaEsquerda(pc);
            } else
                pc.pecaDireita(null);
            if (x > 0) {
            	pc.pecaCima(matriz[x - 1][y]);
            	if (matriz[x-1][y] != null)
                	matriz[x-1][y].pecaBaixo(pc);
            } else
            	pc.pecaCima(null);
            if (x < 6) {
            	pc.pecaBaixo(matriz[x+1][y]);	
            	if (matriz[x+1][y] != null)
            		matriz[x+1][y].pecaCima(pc);
            }
        }
    }
	
	public void setTabuleiro() {
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				Peca p = new Peca();
				inserePeca(p, i, j, ' ');
			}
			for (int j = 2; j < 5; j++) {
				Peca p = new Peca();
				inserePeca(p, i, j, 'P');
			}
			for (int j = 5; j < 7; j++) {
				Peca p = new Peca();
				inserePeca(p, i, j, ' ');
			}
			Peca p = new Peca();
			inserePeca(p, i, 7, '\n');
		}
		for (int i = 2; i < 5; i++) {
			for (int j = 0; j < 7; j++) {
				Peca p = new Peca();
				inserePeca(p, i, j, 'P');
			}
			Peca p = new Peca();
			inserePeca(p, i, 7, '\n');
		}
		for (int i = 5; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				Peca p = new Peca();
				inserePeca(p, i, j, ' ');
			}
			for (int j = 2; j < 5; j++) {
				Peca p = new Peca();
				inserePeca(p, i, j, 'P');
			}
			for (int j = 5; j < 7; j++) {
				Peca p = new Peca();
				inserePeca(p, i, j, ' ');
			}
			Peca p = new Peca();
			inserePeca(p, i, 7, '\n');
		}	
		matriz[3][3].P = '-';
	}
	
	public String printTab() {
		String tabuleiro = "";
		for (int i = 0; i < 7; i++) {
			tabuleiro = tabuleiro + (7 - i) + " ";
			for (int j = 0; j < 8; j++) {
				if (matriz[i][j] != null)
					tabuleiro = tabuleiro + Character.toString(matriz[i][j].P);
				if (j < 7) 
					tabuleiro = tabuleiro + " ";
			}
		}
		tabuleiro = tabuleiro + "  a b c d e f g\n";
		return tabuleiro;
	}
	
	public void movePeca(String jogada) {
		Movimento mov = new Movimento(jogada.substring(0, 2), jogada.substring(3, 5));
		if (matriz[mov.f_linha][mov.f_coluna].P != 'P') {
			if (mov.i_linha == mov.f_linha) {
				if (mov.i_coluna < mov.f_coluna) {
					matriz[mov.i_linha][mov.i_coluna].P = '-';
					matriz[mov.f_linha][mov.f_coluna].P = 'P';
					matriz[mov.i_linha][mov.i_coluna].direita.P = '-';
				}
				else {
					matriz[mov.i_linha][mov.i_coluna].P = '-';
					matriz[mov.f_linha][mov.f_coluna].P = 'P';
					matriz[mov.i_linha][mov.i_coluna].esquerda.P = '-';
				}
			}
			else if (mov.i_coluna == mov.f_coluna) {
				if (mov.i_linha < mov.f_linha) {
					matriz[mov.i_linha][mov.i_coluna].P = '-';
					matriz[mov.f_linha][mov.f_coluna].P = 'P';
					matriz[mov.i_linha][mov.i_coluna].baixo.P = '-';
				}
				else {
					matriz[mov.i_linha][mov.i_coluna].P = '-';
					matriz[mov.f_linha][mov.f_coluna].P = 'P';
					matriz[mov.i_linha][mov.i_coluna].cima.P = '-';
				}
			}
		}
	}
}