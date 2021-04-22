package mc322.lab04;

public class Movimento{
	int i_linha, i_coluna, f_linha, f_coluna;
	
	Movimento(String inicio, String fim){
		i_linha = 7 - Integer.parseInt(inicio.substring(1, 2));
		f_linha = 7 - Integer.parseInt(fim.substring(1, 2));
		switch (inicio.substring(0, 1)) {
		case "a":
			i_coluna = 0;
			break;
		case "b":
			i_coluna = 1;
			break;
		case "c":
			i_coluna = 2;
			break;
		case "d":
			i_coluna = 3;
			break;
		case "e":
			i_coluna = 4;
			break;
		case "f":
			i_coluna = 5;
			break;
		case "g":
			i_coluna = 6;
			break;
		}
		switch (fim.substring(0, 1)) {
		case "a":
			f_coluna = 0;
			break;
		case "b":
			f_coluna = 1;
			break;
		case "c":
			f_coluna = 2;
			break;
		case "d":
			f_coluna = 3;
			break;
		case "e":
			f_coluna = 4;
			break;
		case "f":
			f_coluna = 5;
			break;
		case "g":
			f_coluna = 6;
			break;
		}
	}
}