package taskB;

// Authors: Yulia Moshan, Omri Vaturi
//This class implements the CA rule for a standard 'Game of Life' simulation

public class GoL_Rule implements CA_Rule {

	@Override
	public int[][] ImplementRule(int[][] board) {
		int[][] temp = new int[board.length][board[0].length];
		// runs on each cell
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				int neighbors = 0;
				neighbors = checkNeighbors(board, i, j);
				// if cell is alive, 2-3 neighbors staying alive
				if (board[i][j] == 1) {
					if (neighbors == 2 || neighbors == 3)
						temp[i][j] = 1;
					else
						temp[i][j] = 0;
				}
				// if cell is alive, 3 neighbors revives the cell
				else if (board[i][j] == 0) {
					if (neighbors == 3)
						temp[i][j] = 1;
					else
						temp[i][j] = 0;
				}
			}
		}
		return temp;
	}

	public int checkNeighbors(int[][] board, int i, int j) {
		int neighbors = 0;
		int rows = board.length - 1;
		int cols = board[i].length - 1;
		// check if corrner
		if ((i == 0 || i == rows) && (j == 0 || j == cols)) {
			// top left
			if (i == 0 && j == 0)
				neighbors += board[0][1] + board[1][0] + board[1][1];
			// top right
			else if (i == 0 && j == cols)
				neighbors += board[0][j - 1] + board[1][j - 1] + board[1][j];
			// bottom left
			else if (i == rows && j == 0)
				neighbors += board[i - 1][0] + board[i - 1][1] + board[i][1];
			// bottom right
			else if (i == rows && j == cols)
				neighbors += board[i - 1][j - 1] + board[i - 1][j] + board[i][j - 1];
		}
		// check if side
		else if (((i == 0 || i == rows) && (j != 0 && j != cols))
				|| ((i != 0 && i != rows) && (j == 0 || j == cols))) {
			// top mid
			if (i == 0 && (j != 0 && j != cols))
				neighbors += board[0][j - 1] + board[0][j + 1] + board[1][j - 1] + board[1][j]
						+ board[1][j + 1];
			// bottom mid
			else if (i == rows && (j != 0 && j != cols))
				neighbors += board[i][j - 1] + board[i][j + 1] + board[i - 1][j - 1]
						+ board[i - 1][j] + board[i - 1][j + 1];
			// left mid
			else if (j == 0 && (i != 0 && i != rows))
				neighbors += board[i - 1][j] + board[i - 1][j + 1] + board[i][j + 1]
						+ board[i + 1][j] + board[i + 1][j + 1];
			// right mid
			else if (j == cols && (i != 0 && i != rows))
				neighbors += board[i - 1][j - 1] + board[i - 1][j] + board[i][j - 1]
						+ board[i + 1][j - 1] + board[i + 1][j];
		}
		// rest of the board
		else {
			neighbors += board[i - 1][j - 1] + board[i - 1][j] + board[i - 1][j + 1]
					+ board[i][j - 1] + board[i][j + 1]
					+ board[i + 1][j - 1] + board[i + 1][j] + board[i + 1][j + 1];
		}
		return neighbors;
	}
}
