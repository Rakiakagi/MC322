
package mc322.lab03;

public class AppLab03{
	public static void main(String args[]) {
		String teste = "080403MCMVM";
		Animacao anime = new Animacao(teste);
		String vector = "";
		vector = anime.apresenta(anime);
		System.out.println(vector);
		for (int i = 0; i < teste.length()-6; i++) {
			vector = anime.passo(anime.lombriga, anime.setMov.charAt(i));
			System.out.println(vector);
		}
	}
}