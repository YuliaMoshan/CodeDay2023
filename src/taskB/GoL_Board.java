package taskB;
// Authors: Yulia Moshan, Omri Vaturi

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

public class GoL_Board extends CA {
    protected int rows;
    protected int cols;
    protected int[][] board;
    protected BufferedReader reader;

    public GoL_Board(int rows, int cols, BufferedReader reader) throws IOException {
        this.rows = rows;
        this.cols = cols;
        this.board = new int[this.rows][this.cols];
        this.reader = reader;
        SetBoard(board, reader);
    }

    @Override
    public Iterator iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    public void SetBoard(int[][] board, BufferedReader reader) throws IOException {
        String lines = reader.readLine();
        for (int i = 0; i < rows && lines != null; i++) {
            for (int j = 0; j < cols; j++) {
                if (lines.charAt(j) == '*')
                    board[i][j] = 1;
                else if (lines.charAt(j) == ' ')
                    board[i][j] = 0;
            }
            lines = reader.readLine();
        }
    }

    public void playGoL(int[][] board) {
        GoL_Rule golRule = new GoL_Rule();
        this.board = golRule.ImplementRule(board);
    }

    public void CurrentBoardOutput() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 1)
                    System.out.print("*");
                else if (board[i][j] == 0)
                    System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("= = = = = = = = = = = = = = = = = = = = = = = =");
    }
}
