package com.harsha.demo;

import java.util.Scanner;

/*
https://www.youtube.com/watch?v=DXIQ5dwZGKo
 */

public class TicTocToeGame {

	static class GameBoard {
		char[][] board = new char[3][3];
		boolean isGameInProgress = true;
		int moveCount = 0;

		GameBoard() {
			init();
		}
		
		private void init() {
			moveCount = 0;
			isGameInProgress = true;
			// Initialize the board data - empty => space character
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					board[i][j] = ' ';
				}
			}			
		}
		
		public void displayBoard() {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					System.out.print(board[i][j] + "\t");
					
					if(j < 2) {
						System.out.print("|");
					} 
				}
				
				if(i < 2) {
					System.out.println("\n-------------------------");
				}
			}			
		}
		
		private boolean makeMove(char player, int row, int col) {
			if(row > 2 && col > 2 && board[row][col] != ' ' && !isGameActive()) {
				System.out.println("Invalid input!!!");
				return false;
			}
			board[row][col] = player;

			char ch = checkWinner();
			moveCount++;
			if( ch != ' ' ) {
				System.out.printf("Player(%c) is the WINNER!!!\n",ch);
				init();
			} else if(moveCount == 9) {
				System.out.println("----------------------------------------------");
				System.out.printf("\n \n GAME over!!! No one won the game!!   \n");
				init();
			}
			
			return true;
		}
		
		public char checkWinner() {
			// Row check
			for(int i = 0; i < 3; i++) {
				if(board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] != ' '){
					return board[i][0];
				}
			}
			// Column check
			for(int j = 0; j < 3; j++) {
				if(board[0][j] == board[1][j] && board[0][j] == board[2][j] && board[0][j] != ' '){
					return board[0][j];
				}
			}	
			
			// Diagonal check
			if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != ' ') {
				return board[0][0];
			}
			if(board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[2][2] != ' ') {
				return board[0][0];
			}
			
			return ' ';
		}
		
		public boolean isGameActive() {
			return isGameInProgress && moveCount < 9;
		}
		
		void askPlayer() {
			Scanner kb = new Scanner(System.in);
			int row, col;
			while(isGameActive()) {
				if(moveCount % 2 == 0) {
					System.out.println("\nPlayer(O), enter row ");
					row = kb.nextInt(); 
					System.out.println("\nPlayer(O), enter col ");
					col = kb.nextInt();
					makeMove('O', row-1, col-1);
					displayBoard();
				} else {
					System.out.println("\nPlayer(X), enter row ");
					row = kb.nextInt(); 
					System.out.println("\nPlayer(X), enter col ");
					col = kb.nextInt();
					makeMove('X', row-1, col-1);
					displayBoard();
				}
			}
			
			kb.close();
		}
	}

	public static void main(String[] args) {
		GameBoard gb = new GameBoard();		
		gb.displayBoard();
		
		gb.askPlayer();

	}

}
