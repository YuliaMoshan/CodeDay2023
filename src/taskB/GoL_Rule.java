package taskB;

/**
 * 
 * @author
 *         This class implements the CA rule for a standard 'Game of Life'
 *         simulation
 *
 */
public class GoL_Rule implements CA_Rule {

	@Override
	public void ImplementRule(int[][] board) {
		int[][] temp = new int[board.length][board[0].length];
		int neighbors = 0;
		// runs on each cell
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
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
		board = temp;
	}

	public int checkNeighbors(int[][] board, int i, int j) {
		int status = 0;
		int rows = board.length - 1;
		int cols = board[i].length - 1;
		// check if corrner
		if ((i == 0 || i == rows) && (j == 0 || j == cols)) {
			// top left
			if (i == 0 && j == 0)
				status += board[0][1] + board[1][0] + board[1][1];
			// top right
			if (i == 0 && j == cols)
				status += board[0][cols - 1] + board[1][cols - 1] + board[1][cols];
			// bottom left
			if (i == rows && j == 0)
				status += board[rows - 1][0] + board[rows - 1][1] + board[rows][1];
			// bottom right
			if (i == rows && j == cols)
				status += board[rows - 1][cols - 1] + board[rows - 1][cols] + board[rows][cols - 1];
		}
		// check if side
		else if (((i == 0 || i == rows) && (j != 0 && j != cols))
				|| ((i != 0 && i != rows) && (j == 0 || j == cols))) {
			// top mid
			if (i == 0 && (j != 0 && j != cols))
				status += board[0][cols - 1] + board[0][cols + 1] + board[1][cols - 1] + board[1][cols]
						+ board[1][cols + 1];
			// bottom mid
			if (i == rows && (j != 0 && j != cols))
				status += board[rows][cols - 1] + board[rows][cols + 1] + board[rows - 1][cols - 1]
						+ board[rows - 1][cols] + board[rows - 1][cols + 1];
			// left mid
			if (j == 0 && (i != 0 && i != rows))
				status += board[rows - 1][cols] + board[rows - 1][cols + 1] + board[rows][cols + 1]
						+ board[rows + 1][cols] + board[rows + 1][cols + 1];
			// right mid
			if (j == cols && (i != 0 && i != rows))
				status += board[rows - 1][cols - 1] + board[rows - 1][cols] + board[rows][cols - 1]
						+ board[rows + 1][cols - 1] + board[rows + 1][cols];
		}
		// rest of the board
		else {
			status += board[rows - 1][cols - 1] + board[rows - 1][cols] + board[rows - 1][cols + 1]
					+ board[rows][cols - 1] + board[rows][cols] + board[rows][cols + 1]
					+ board[rows + 1][cols - 1] + board[rows + 1][cols] + board[rows + 1][cols + 1];
		}
		return status;
	}

}
