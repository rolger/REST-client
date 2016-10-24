package blogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BloggerMain {

	public static void main(String[] args) throws IOException {
		while (true) {
			showMenue();

			String input = readInput();
			switch (input.toUpperCase()) {
			case "X":
				System.exit(0);
				break;

			default:
				continue;
			}
		}
	}

	private static String readInput() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			return br.readLine();
		} catch (IOException ioe) {
			System.out.println("IO error trying to read your name!");
			System.exit(1);
		}
		return null;
	}

	private static void showMenue() {
		System.out.println("Wählen sie eine Aktion");
		System.out.println("1 Alle anzeigen");
		System.out.println("2 Einen Blog anzeigen");
		System.out.println("3 Einen Blog erzeugen");
		System.out.println("4 Einen Blog löschen");
		System.out.println("X Exit");
		System.out.println();
	}
}
