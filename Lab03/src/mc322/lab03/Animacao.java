package mc322.lab03;

public class Animacao{
	AquarioLombriga lombriga;
	String setMov = "";
	
	Animacao(String animacao) {
		int x = Integer.parseInt(animacao.substring(0, 2));
		int y = Integer.parseInt(animacao.substring(2, 4));
		int z = Integer.parseInt(animacao.substring(4, 6));
		lombriga = new AquarioLombriga(x, y, z);
		setMov = animacao.substring(6, animacao.length());
	}
	
	public String apresenta(Animacao anime) {
		return anime.lombriga.apresenta(lombriga);
	}
	
	public String passo(AquarioLombriga lombriga, char animacao) {
		if (animacao == 'C')
			return lombriga.crescer(lombriga);
		else if (animacao == 'M')
			return lombriga.mover(lombriga);
		else 
			return lombriga.virar(lombriga);
	}
	
}