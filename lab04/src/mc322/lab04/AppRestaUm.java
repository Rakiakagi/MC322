package mc322.lab04;

public class AppRestaUm{
	public static String[] executaJogo(String caminho) {
		CSVReader csv = new CSVReader();
		csv.setDataSource(caminho);
		String commands[] = csv.requestCommands();
		
		Tabuleiro tab = new Tabuleiro();
		tab.setTabuleiro();
		
		String estados[] = new String[commands.length];
		
		System.out.println("Tabuleiro inicial:\n" + tab.printTab());
		
		for (int i = 0; i < commands.length; i++) {
			tab.movePeca(commands[i]);
			estados[i] = tab.printTab();
			System.out.println("Source: " + commands[i].substring(0, 2));
			System.out.println("Target: " + commands[i].substring(3, 5));
			System.out.println(tab.printTab());
		}
		return estados;
	}
	
	public static void main(String[] args) {
		executaJogo("C:\\Users\\henri\\eclipse-workspace\\MC322\\src\\mc322\\lab04\\teste08.csv");
	}
}