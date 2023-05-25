package taskB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Runner {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        GoL_Board gol = null;
        int rows = 0;
        int cols = 0;
        try {
            FileReader file = new FileReader("GliderGunSmall.txt");
            BufferedReader reader = new BufferedReader(file);
            String size = reader.readLine();
            String[] integers = size.split(" ");
            rows = Integer.parseInt(integers[0]);
            cols = Integer.parseInt(integers[1]);
            gol = new GoL_Board(rows, cols, reader);
            gol.CurrentBoardOutput();
            reader.close();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // runs 1000 times
        if (gol != null) {
            for (int i = 0; i < 1000; i++) {
                gol.playGoL(gol.board);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gol.CurrentBoardOutput();
                int aliveCells = 0;
                for (int j = 0; j < gol.rows; j++) {
                    for (int k = 0; k < gol.cols; k++) {
                        aliveCells += gol.board[j][k];
                    }
                }
                if (aliveCells == 0)
                    break;
            }
        }
    }
}
