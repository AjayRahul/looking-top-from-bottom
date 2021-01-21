/**
 * 
 */
package TicTakToe;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Lenovo
 *
 */
public class GamePlay {
	
	static ArrayList<Integer> playerPosition1 = new ArrayList<Integer>();
	static ArrayList<Integer> playerPosition2 = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		System.out.println("To Start the game enter any numbers from 1 to 9 in order to place the symbol");
		System.out.println();
		
		char[][] board = {{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '},
				{'-','+','-','+','-'},
				{' ','|',' ','|',' '}};
		
		gameBoard(board);
		System.out.println();
	
		while(true) {
			Scanner scanner = new Scanner(System.in);
			int num = scanner.nextInt();
			while(playerPosition1.contains(num) || playerPosition2.contains(playerPosition1)) {
			System.out.println("Please choose other number to continue playing");
			num = scanner.nextInt();}
			
			piecePlace(board, num, "Player1");
			gameBoard(board);
		
			String r = results();
			if(r.length() > 0) {
				System.out.print(r);
				break;}
				
			int num1 = scanner.nextInt();
			while(playerPosition2.contains(num1) || playerPosition2.contains(playerPosition1)) {
			System.out.println("Please choose other number to continue playing");
			num1 = scanner.nextInt();}
			
			piecePlace(board, num1, "Player2");			
			gameBoard(board);
			
			r = results();
			if(r.length() > 0) {
				System.out.print(r);
				break;
			}
		}
	}
	//gameBoard() method to display the Board	
	
	public static void gameBoard(char[][] board) {
		for(char[] x : board) {
			for(char x1 : x) {
			System.out.print(x1);
		}
            System.out.println();
	}
	
	}
	
	public static void piecePlace(char[][] board, int pos, String user) {
		
		char symbol = ' ';
		if(user.equals("Player1")) {
			symbol = 'X';
			playerPosition1.add(pos);
		}else if(user.equals("Player2")) {
			symbol = '0';
			playerPosition2.add(pos);
		}
		
		switch(pos) {
		
		case 1:
			board[0][0] = symbol;
			break;
			
		case 2:
			board[0][2] = symbol;
			break;
			
		case 3:
			board[0][4] = symbol;
			break;
			
		case 4:
			board[2][0] = symbol;
			break;
			
		case 5:
			board[2][2] = symbol;
			break;
			
		case 6:
			board[2][4] = symbol;
			break;
			
		case 7:
			board[4][0] = symbol;
			break;
			
		case 8:
			board[4][2] = symbol;
			break;
			
		case 9:
			board[4][4] = symbol;
			break;
			
		default:
			break;
			
		}
	}
	
	public static String results() {
		
		List topRow = Arrays.asList(1,2,3);
		List midRow = Arrays.asList(4,5,6);
		List botRow = Arrays.asList(7,8,9);
		List topCol = Arrays.asList(1,4,7);
		List midCol = Arrays.asList(2,5,8);
		List botCol = Arrays.asList(3,6,9);
		List cro1 = Arrays.asList(1,5,9);
		List cros2 = Arrays.asList(7,5,3);
		
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(topRow);
		winning.add(topCol);
		winning.add(midCol);
		winning.add(botCol);
		winning.add(cro1);
		winning.add(cros2);
		
		for(List l : winning) {
		if(playerPosition1.containsAll(l)) {
			return "Player 1 has won! Congratulations!";
		}
		else if(playerPosition2.containsAll(l)) {
			return "Player 2 has won! Well Done!";
		}
		else if(playerPosition1.size() + playerPosition2.size() == 9) {
			return "CAT";
		}}
		
		return "" ;
	}

}
