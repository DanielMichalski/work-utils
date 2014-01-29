package scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Author: Daniel
 */
public class Main {

    public Main() {
        frequency();
    }

    public static void main(String[] args) {
        new Main();
    }

    public void frequency() {
        try {
            System.out.print("Podaj częstotliwość: ");
            Scanner czestotliwosc = new Scanner(System.in);
            int freq = czestotliwosc.nextInt();
            System.out.println("Częstotliwość = " + freq);
        } catch (InputMismatchException e) {
            System.out.println("Wpisałeś błędne dane! Spróbuj ponownie");
            frequency();
        }
    }
}
