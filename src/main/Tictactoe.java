package main;

import java.util.Scanner;

public class Tictactoe {
    private final Board board;
    private final Player X;
    private final Player O;

    public Tictactoe(Board b, Player x, Player o) {
        this.board = b;
        this.X = x;
        this.O = o;
    }

    public static void main(String[] args) {
        boolean playAgain = false;
        Scanner in = new Scanner(System.in);
        do {
            new Tictactoe(new Board(), new Player('X'), new Player('O')).startGame();
            System.out.print("\n\n\tPlay Again? [y = yes]: ");
            char choice = in.next().charAt(0);
            if (Character.toUpperCase(choice) == 'Y')
                playAgain = true;
            else
                playAgain = false;
        } while (playAgain);

        in.close();
    }

    private void startGame() {
        this.board.displayBoard();
        boolean tieGame = true;

        for (int turns = 9; turns > 0; turns--) {
            if (turns % 2 != 0) {
                setCell(this.X);
                if (this.board.isWinner(this.X.as())) {
                    this.board.displayBoard();
                    System.out.printf("\n\tPlayer %c won! Congratulations!!\n\n", this.X.as());
                    tieGame = false;
                    break;
                }
            } else {
                setCell(this.O);
                if (this.board.isWinner(this.O.as())) {
                    this.board.displayBoard();
                    System.out.printf("\n\tPlayer %c won! Congratulations!!\n\n", this.O.as());
                    tieGame = false;
                    break;
                }
            }
            this.board.displayBoard();
        }

        if (tieGame) {
            System.out.println("\nTie Game\n");
        }

    }

    private void setCell(Player p) {
        while (true) {
            System.out.printf("\n\tPlayer %c turn\n\tEnter cell: ", p.as());
            int cell = p.move();

            if (cell < 0) {
                System.out.println("\tInvalid: Enter number only");
                continue;
            }
            
            if (cell == 0 || cell > 9) {
                System.out.println("\tInvalid: Enter cell from 1-9 only");
                continue;
            }

            if (!this.board.cellIsAvailable(cell)) {
                System.out.println("\tCell is already taken");
            } else {
                this.board.occupy(cell, p.as());
                return;
            }
            
        }
    }
}