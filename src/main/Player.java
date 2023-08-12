/**
 * Player move (doesn't include loops for re-Enter)
 * 
 */

package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    private final Scanner in;
    private final char player;

    public Player(char represent) {
        this.player = represent;
        this.in = new Scanner(System.in);
    }

    public int move() {
        try {
            return in.nextInt();
        } catch (InputMismatchException ex) {
            in.nextLine();
            return -1;
        }
    }

    public char as() {
        return this.player;
    }
}