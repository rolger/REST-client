package blogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BloggerMain {

	public static void main(String[] args) throws IOException {
		BloggerClient bloggerClient = new BloggerClient();

		while (true) {
			showMenue();

			String id = "";
			String input = readInput();
			switch (input.toUpperCase()) {
			case "X":
				System.exit(0);
				break;

			case "1":
				bloggerClient.readAllBlogs();
				break;

			case "2":
				System.out.println("Enter id to read: ");
				id = readInput();
				bloggerClient.readBlogPost(id);
				break;

			case "3":
				bloggerClient.createNewPost("Kaffee for free", "Eduscho.at");
				break;

			case "4":
				System.out.println("Enter id to delete: ");
				id = readInput();
				bloggerClient.deleteRequest(id);

			case "5":
				System.out.println("Enter id to like: ");
				id = readInput();
				bloggerClient.addLikes(id, "unknown guy");
				
			case "6":
				System.out.println("Enter id to change: ");
				id = readInput();
				bloggerClient.updatePost(id, "new title");

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
		System.out.println("5 Einen Blog mögen");
		System.out.println("6 Einen Blog ändern");
		System.out.println("X Exit");
		System.out.println();
	}
}
