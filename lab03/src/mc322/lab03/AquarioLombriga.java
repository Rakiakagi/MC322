package mc322.lab03;

public class AquarioLombriga{
	int tamAqua, tamLom, posLom, dirEsq = 0;// variável dirEsq indica a direção que a lombriga está virada.
	
	AquarioLombriga(int tamAqua, int tamLom, int posLom){
		this.tamAqua = tamAqua;
		this.tamLom = tamLom;
		this.posLom = posLom;
		if (tamLom > tamAqua)
			this.tamAqua = tamLom;
		if (posLom + tamLom > tamAqua + 1)
			this.posLom = 1;
	}
	
	public String apresenta(AquarioLombriga lombriga) {
		String apresentacao = "";
		// verifica o lado que a lombriga está virada e constrói a String.
		if (lombriga.dirEsq % 2 == 0) {
			for (int i = 1; i < lombriga.posLom; i++)
				apresentacao = apresentacao + "#";
			for (int j = lombriga.posLom; j < lombriga.posLom + lombriga.tamLom - 1; j++)
				apresentacao = apresentacao + "@";
			apresentacao = apresentacao + "O";
			for (int k = lombriga.posLom + lombriga.tamLom - 1; k < lombriga.tamAqua; k++)
				apresentacao = apresentacao + "#";
		}
		//Constrói a lombriga virada.
		else {
			for (int i = 0; i < lombriga.posLom - lombriga.tamLom; i++)
				apresentacao = apresentacao + "#";
			apresentacao = apresentacao + "O";
			for (int j = lombriga.posLom - lombriga.tamLom + 1; j < lombriga.posLom; j++)
				apresentacao = apresentacao + "@";
			for (int k = lombriga.posLom; k < lombriga.tamAqua; k++)
				apresentacao = apresentacao + "#";
		}
		return apresentacao;
	}
	
	public String crescer(AquarioLombriga lombriga) {
		if (lombriga.tamLom < lombriga.tamAqua) {
			if (lombriga.dirEsq % 2 == 0) {
				if (lombriga.posLom > 1) {
					lombriga.tamLom++;
					lombriga.posLom--;
				}
			}
			else
				if (lombriga.posLom < lombriga.tamAqua) {
					lombriga.tamLom++;
					lombriga.posLom++;
				}
					
			}
		return apresenta(lombriga);
	}
	
	public String virar(AquarioLombriga lombriga) {
		if (lombriga.dirEsq % 2 == 0) 
			lombriga.posLom = lombriga.posLom + lombriga.tamLom - 1;
		else
			lombriga.posLom = lombriga.posLom - lombriga.tamLom + 1;
		lombriga.dirEsq++;
		return apresenta(lombriga);
	}
	
	public String mover(AquarioLombriga lombriga) {
		if (lombriga.dirEsq % 2 == 0) {
			if (lombriga.posLom + lombriga.tamLom <= lombriga.tamAqua) {
				lombriga.posLom++;
				return apresenta(lombriga);
			}
			else
				return virar(lombriga);
		}
		else {
			if (lombriga.posLom - lombriga.tamLom > 0) {
				lombriga.posLom--;
				return apresenta(lombriga);
			}
			else
				return virar(lombriga);
		}
	}
}