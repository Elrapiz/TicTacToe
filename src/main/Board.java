/** 
 * checking of available cell
 * occupying cell
 * checking if player won
 * 
 */

package main;

import java.io.IOException;

public class Board {
    private static final int[][] WINNING_COMBO = {
        // horizontal combo
        { 0, 1, 2 },
        { 3, 4, 5 },
        { 6, 7, 8 },

        // vertical combo
        { 0, 3, 6 },
        { 1, 4, 7 },
        { 2, 5, 8 },

        // diagonal combo
        { 0, 4, 8 },
        { 2, 4, 6 }
    };
    private final char[] cells;

    public Board() {
        this.cells = new char[9];
        this.initCells();
    }

    public boolean cellIsAvailable(int cell) {
        return this.cells[cell - 1] == '*';
    }

    public void occupy(int cell, char player) {
        this.cells[cell - 1] = player;
    }

    public boolean isWinner(char player) {
        for (int[] combos : WINNING_COMBO) {
            int max = 3;
            for (int combo : combos) {
                if (this.cells[combo] == player)
                    max--;
            }

            if (max == 0)
                return true;
            else
                max = 3;
        }

        return false;
    }

    public void displayBoard() {
        cs();
        System.out.println("\n\tTic Tac Toe by: Elrapiz\n");
        int cellIndex = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("\t");
            for (int j = 0; j < 11; j++) {
                if (i == 1 || i == 3) {
                    if (j == 3 || j == 7)
                        System.out.print('+');
                    else 
                        System.out.print('-');
                    continue;
                }

                if (j == 1 || j == 5 || j == 9) {
                    System.out.print(this.cells[cellIndex]);
                    cellIndex++;
                    continue;
                } else if (j == 3 || j == 7) {
                    System.out.print('|');
                    continue;
                }

                System.out.print(' ');
            }
            System.out.println();
        }
    }

    private void initCells() {
        for (int i = 0; i < this.cells.length; i++) {
            this.cells[i] = '*';
        }
    }

    private static final void cs() { // clear screen method
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {
            System.out.println("Failed to clear screen");
        }
    }
}