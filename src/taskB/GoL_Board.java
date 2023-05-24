package taskB;

import java.io.*;
import java.util.*;

public class GoL_Board extends CA {
	private String[] cell_state = {" ", "*"};
	private int rows;
	private int cols;
	private int[][] board;
	private final FileWriter board_buff = new FileWriter("board.txt");

	public GoL_Board(int rows, int cols) throws IOException {
		board = new int[rows][cols];
		SetBoard(board);

	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public void SetBoard(int[][] board) {
		Random random = new Random();
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				int rand_state = random.nextInt(2);
				board[i][j] = rand_state;
			}
		}
	}

	public void toFile(int[][] board) throws IOException {
		try (BufferedWriter wr = new BufferedWriter(board_buff)) {
			wr.write(board.length + " " + board[0].length);
			wr.newLine();
			for (int i = 0; i < board[i].length; i++) {
				for (int j = 0; j < this.cols; j++) {
					wr.write(board[i][j]);
				}
				wr.newLine();
			}
		}
	}

	public String CurrentBoardOutput() {
		// TODO Auto-generated method stub
		return null;
	}

	public void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}

}
