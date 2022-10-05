/* Nakayla Minott
 * 09/28/2022
 * COMP167001.202310
 * 
 * This is a program for a game
 * this game has a 10 by 10 board using a two-dimensional array
 * it has a single mode using a random number generator for the computer player
 * and multi player mode
 * when a 4 x's have been placed in a row the game ends and the winner is printed
 * 
 */


import java.util.Scanner;//import java scanner
import java.util.Random;// import java random  


public class game { 

	String player = "player1";
	static String lastturn;

	//method to print board
	public static void printBoard(char [][] gameBoard) {
		System.out.println(" 0  1  2  3  4  5  6  7  8  9 ");
		//print gameBoard
		for(int i = 0; i < gameBoard.length; ++i ){

			for(int j = 0; j < gameBoard[i].length; ++j ){
				System.out.print("|" + gameBoard[i][j] + "|"); 
			}//nested for loop
		
			System.out.println();	
		}//for loop	
		System.out.println(" 0  1  2  3  4  5  6  7  8  9 ");
	}//printBoard method
	

	// method to get player inputs
	public static void playerInput(char[][] gameBoard) { 
		Scanner scnr = new Scanner(System.in);
		boolean valid = true ;
		int x = 0;
		int y = 0;
		while(valid){
			System.out.println("\n");
			System.out.println("Enter row number: ");// prompt for row input
			x = scnr.nextInt();
			System.out.println("Enter column number: ");// prompt for column input
			y = scnr.nextInt();
			if( x > 10 || y > 10 || x < 0 || y < 0|| gameBoard[x][y] == 'x') {
				System.out.println("try again");

			}//if statement checks if x and y are valid
			
			else {
				gameBoard [x][y] = 'x';// inserts an x at y'x coord
				valid = false;
			}//else end
		}//while loop to enter x's and check if x is already at that coord
		printBoard(gameBoard);
		System.out.println();

	}//playerInput method end


	// method to get aiInputs
	public static void aiInput(char[][] gameBoard) {
		Random rndm = new Random();//random number generator
		int x = 0;
		int y = 0;
		boolean valid = true;
		while(valid) {
			x = rndm.nextInt(0,10);
			y = rndm.nextInt(0,10);
			if(gameBoard[x][y]=='x' ) {
				continue;
			}//if end
			else {
				gameBoard[x][y]='x';
				valid = false;// ends the while loop
			}//else end
		}//while loop to enter x's and check if x is already at coord
		printBoard(gameBoard);
		System.out.println();
	}//ai method for single player	
	
	//method for checking the array index and finding the winner
	public static boolean findWinner( char [][] gameBoard) {
		// checks for 4 horizontal  left -> right
		for (int row = 0; row < gameBoard.length; row++) {
			for (int column = 0; column < gameBoard[row].length; column++) {
				if(column  + 1 < 10 && column  + 2 < 10 && column  + 3 < 10 && gameBoard[row][column]== 'x' && gameBoard[row][column + 1]== 'x' &&
						gameBoard[row][column + 2]== 'x' && gameBoard[row][column + 3]== 'x') {
					return true;
				}//nested if end
			}//nested for loop column end
		}//for loop  row end
		
		// checks for 4 horizontal x placed on right ->left
		for (int row = 0; row < gameBoard.length; row++) {
			for (int column = 0; column < gameBoard[row].length; column++) {
				if(column - 1 > -1 && column-2 > -1 && column-3 > -1 && gameBoard[row][column]== 'x' && gameBoard[row][column - 1]== 'x' &&
						gameBoard[row][column - 2]== 'x' && gameBoard[row][column - 3]== 'x') {
					return true;
				}//nested if end
			}//nested for loop column end
		}//for loop  row end
		
		//checks for 4 top and bottom going down
		for (int row = 0; row < gameBoard.length; row++) {
			for (int column = 0; column < gameBoard[row].length; column++) {
				if(row + 1 < 10 && row +2 < 10 && row+3  < 10 && gameBoard[row][column]== 'x' && gameBoard[row + 1][column]== 'x' &&
						gameBoard[row + 2][column ]== 'x' && gameBoard[row + 3][column]== 'x') {
					return true;
				}//nested if end
			}//nested for loop column end
		}//for loop  row end
		
		//checks for 4 top and bottom going up
		for (int row = 0; row < gameBoard.length; row++) {
			for (int column = 0; column < gameBoard[row].length; column++) {
				if(row - 1 > -1 && row-2 > -1 && row-3 > -1 && gameBoard[row][column]== 'x' && gameBoard[row - 1][column]== 'x' &&
						gameBoard[row - 2][column ]== 'x' && gameBoard[row - 3][column]== 'x') {
					return true;
				}//nested if end
			}//nested for loop column end
		}//for loop  row end
		
		//check for diagonal upward
		for (int row = 0; row < gameBoard.length; row++) {
			for (int column = 0; column < gameBoard[row].length; column++) {
				if(row - 1 > -1 && row-2 > -1 && row-3 > -1 &&   column+ 1 < 10 && column+ 2 < 10 && column+ 3  < 10 && gameBoard[row][column]== 'x' && gameBoard[row - 1][column + 1]== 'x' &&
						gameBoard[row - 2][column + 2 ]== 'x' && gameBoard[row - 3][column + 3]== 'x') {
					return true;
				}//nested if end
			}//nested for loop column end
		}//for loop  row end
		
		//checks diagonal downward
		for (int row = 0; row < gameBoard.length; row++) {
			for (int column = 0; column < gameBoard[row].length; column++) {
				if(row + 1 < 10 && row +2 < 10 && row+3  < 10 && column+ 1 < 10 && column+ 2 < 10 && column+ 3  < 10 && gameBoard[row][column]== 'x' && gameBoard[row + 1][column + 1]== 'x' &&
						gameBoard[row + 2][column  + 2]== 'x' && gameBoard[row + 3][column + 3]== 'x') {
					return true;
				}//nested if end
			}//nested for loop column end
		}//for loop  row end
		
		return false;
	}// find winner method end
	


	// method for singleplayer game
	public static void singleplayer(String player) {
		Scanner scnr = new Scanner(System.in);//scanner

		// intro for single player//
		System.out.println("\n"
				+ "\n"
				+ " _    _      _                            _          _____ _             _            _                        ___  ___          _      _ _ \n"
				+ "| |  | |    | |                          | |        /  ___(_)           | |          | |                       |  \\/  |         | |    | | |\n"
				+ "| |  | | ___| | ___ ___  _ __ ___   ___  | |_ ___   \\ `--. _ _ __   __ _| | ___ _ __ | | __ _ _   _  ___ _ __  | .  . | ___   __| | ___| | |\n"
				+ "| |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\   `--. \\ | '_ \\ / _` | |/ _ \\ '_ \\| |/ _` | | | |/ _ \\ '__| | |\\/| |/ _ \\ / _` |/ _ \\ | |\n"
				+ "\\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) | /\\__/ / | | | | (_| | |  __/ |_) | | (_| | |_| |  __/ |    | |  | | (_) | (_| |  __/_|_|\n"
				+ " \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/  \\____/|_|_| |_|\\__, |_|\\___| .__/|_|\\__,_|\\__, |\\___|_|    \\_|  |_/\\___/ \\__,_|\\___(_|_)\n"
				+ "                                                                    __/ |      | |             __/ |                                        \n"
				+ "                                                                   |___/       |_|            |___/                                         \n"
				+ "\n"
				+ "");

		System.out.println("You will be playing against an AI\n");
		System.out.print("In this game you will be placing X's on the board.");
		System.out.println(" The goal is to get 4 X's in a row/colum.");
		System.out.println("Whoever places the last X in the row/column wins the game.");
		System.out.println("\n\n");

		char[][] gameBoard = new char[10][10];//10 by 10 array for printBoard
		
		
		for(int i = 0; i < gameBoard.length; ++i ) {
			for(int j = 0; j < gameBoard[i].length; ++j ){
				gameBoard[i][j] = ' ';
			}
		}
		
		printBoard(gameBoard); // reference printBoard method	
		
		boolean winner = false;
		// change players and run game
		while(winner == false) {
			if (player.equals("player1")) {
				System.out.println("Your turn player 1");
				playerInput(gameBoard);// reference player input to run its code for player turn
				player = "player2";
				lastturn = "player1";
			}// nested if end
			else {
				aiInput(gameBoard);// reference ai input to run its code for next turn
				player = "player1";
				lastturn = "player2";
			}//else end
			winner = findWinner(gameBoard);// references findWinner to end while loop when winner is found
		}// while loop end
	
		
		if(winner == true){
			if(lastturn.equals("player1")) {
				System.out.println("player 1 has won the game!!");
			}//nested if end	
			else {
			System.out.println("YOU LOSE\n");	
			System.out.println(" _______  _______  _______  _______    _______           _______  _______ \n"
					+ "(  ____ \\(  ___  )(       )(  ____ \\  (  ___  )|\\     /|(  ____ \\(  ____ )\n"
					+ "| (    \\/| (   ) || () () || (    \\/  | (   ) || )   ( || (    \\/| (    )|\n"
					+ "| |      | (___) || || || || (__      | |   | || |   | || (__    | (____)|\n"
					+ "| | ____ |  ___  || |(_)| ||  __)     | |   | |( (   ) )|  __)   |     __)\n"
					+ "| | \\_  )| (   ) || |   | || (        | |   | | \\ \\_/ / | (      | (\\ (   \n"
					+ "| (___) || )   ( || )   ( || (____/\\  | (___) |  \\   /  | (____/\\| ) \\ \\__\n"
					+ "(_______)|/     \\||/     \\|(_______/  (_______)   \\_/   (_______/|/   \\__/\n"
					+ "                                                                          \n"
					+ "\n"
					 );
			}//else end
		}//if end
		

	}//single player method end


	public static void multiplayer(String player) {
		Scanner scnr = new Scanner(System.in);
		// intro for multiplayer//
		System.out.println("\n"
				+ "\n"
				+ " _    _      _                            _                          _ _   _       _                                             _      _ _ \n"
				+ "| |  | |    | |                          | |                        | | | (_)     | |                                           | |    | | |\n"
				+ "| |  | | ___| | ___ ___  _ __ ___   ___  | |_ ___    _ __ ___  _   _| | |_ _ _ __ | | __ _ _   _  ___ _ __   _ __ ___   ___   __| | ___| | |\n"
				+ "| |/\\| |/ _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  | '_ ` _ \\| | | | | __| | '_ \\| |/ _` | | | |/ _ \\ '__| | '_ ` _ \\ / _ \\ / _` |/ _ \\ | |\n"
				+ "\\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) | | | | | | | |_| | | |_| | |_) | | (_| | |_| |  __/ |    | | | | | | (_) | (_| |  __/_|_|\n"
				+ " \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\__\\___/  |_| |_| |_|\\__,_|_|\\__|_| .__/|_|\\__,_|\\__, |\\___|_|    |_| |_| |_|\\___/ \\__,_|\\___(_|_)\n"
				+ "                                                                            | |             __/ |                                           \n"
				+ "                                                                            |_|            |___/                                            \n"
				+ "\n"
				+ "");

		System.out.print("In this game you will be placing X's on the board.");
		System.out.println(" The goal is to get 4 X's in a row/colum.");
		System.out.println("Whoever places the last X in the row/column wins the game.");
		System.out.println("\n\n");


		char [][] gameBoard = new char[10][10];// array for 10 by 10 gameboard
		
		
		for(int i = 0; i < gameBoard.length; ++i ) {
			for(int j = 0; j < gameBoard[i].length; ++j ){
				gameBoard[i][j] = ' ';
			}
		}
		
		printBoard(gameBoard); // reference printBoard method

		System.out.println("\n");	
		
		boolean winner = false;	
		// change players and run game
		while(winner == false) {
			if (player.equals("player1")) {
				System.out.println("Your turn player 1");// prompt player 1
				playerInput(gameBoard);// reference player input to run its code for player turn
				player = "player2";
				lastturn = "player1";
			}// nested if end
			else {
				System.out.println("Your turn player 2");//prompt player 2
				playerInput(gameBoard);// reference ai input to run its code for next turn
				player = "player1";
				lastturn = "player2";
			}//else end
			winner = findWinner(gameBoard);// references findWinner to end while loop when winner is found
		}// while loop end
		
		if(winner == true){
			if(lastturn.equals("player1")) {
				System.out.println("player 1 has won the game!!");
			}//nested if end	
			else {
			System.out.println("player 2 has won the game!!");	
			}//else end
		}//if end
		
		
	}//multi player method end



}//public class end
