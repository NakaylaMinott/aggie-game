import java.util.Scanner;


public class Nami9267_AggieGame {
	
	
	public static void main(String [] args) {
		
		String player= "player1";
		
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("\n"
				+ "\n"
				+ " _    _      _                            _          _   _             ___              _        _____                      _ _ \n"
				+ "| |  | |    | |                          | |        | | | |           / _ \\            (_)      |  __ \\                    | | |\n"
				+ "| |  | | ___| | ___ ___  _ __ ___   ___  | |_ ___   | |_| |__   ___  / /_\\ \\ __ _  __ _ _  ___  | |  \\/ __ _ _ __ ___   ___| | |\n"
				+ "| |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  | __| '_ \\ / _ \\ |  _  |/ _` |/ _` | |/ _ \\ | | __ / _` | '_ ` _ \\ / _ \\ | |\n"
				+ "\\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) | | |_| | | |  __/ | | | | (_| | (_| | |  __/ | |_\\ \\ (_| | | | | | |  __/_|_|\n"
				+ " \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/   \\__|_| |_|\\___| \\_| |_/\\__, |\\__, |_|\\___|  \\____/\\__,_|_| |_| |_|\\___(_|_)\n"
				+ "                                                                             __/ | __/ |                                        \n"
				+ "                                                                            |___/ |___/                                         \n"
				+ "\n"
				+ ""); // prompt
		
		System.out.println("Input your gamemode: \n");// prompt
		
		System.out.println("1) SinglePlayer\n"  + "2) MultiPlayer\n"  + "3) Quit");// menu options
		
		
		
		int menuInput = scnr.nextInt();// get gameMenu input
		while(menuInput > 0 && menuInput < 4) {
			if (menuInput == 1) {
				game.singleplayer(player);
				break;
			}// if menu 1 end
			else if (menuInput == 2) {
				game.multiplayer(player);
				break;
			}//else if menu = 2 end
			else if (menuInput == 3) {
				System.out.print("Have a nice day!!");
				break;
				
			}//else if 3 end
			
		}//menu while loop end
		
		
		
		
	}//main end
	
}//class
