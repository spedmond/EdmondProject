import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("| GUESS THE NUMBER |");
        System.out.println("--------------------");
        System.out.print("Please enter your name: ");
        String name = input.nextLine();
        int highestScore;
        int pointAdd;
        int pointMulti;

        System.out.println("Hello, " + name + "!");
        System.out.print("Would you like to play on HARD mode? Type \"Yes\" if so, otherwise press enter: ");
        String diff = input.nextLine();
        if (diff.toLowerCase().equals("yes")) {
            System.out.print("Choose number of guesses (Max. 9; the lower the number of guesses, the more points you'll gain per number guessed correctly): ");
            int guess = input.nextInt();
            while (guess<=0||guess>9) {
                System.out.print("Error: Number of guesses must be between 1 and 9. Please reenter guesses: ");
                guess = input.nextInt();
            }
            pointAdd = 10-guess;

            System.out.print("Choose the length of the random number (Min. 2, Max. 7; any length over 3 will increase your score multiplier): ");
            int length = input.nextInt();
            while (length<2||length>7) {
                System.out.print("Error: Length must be between 2 and 7. Please reenter length: ");
                length = input.nextInt();
            }
            pointMulti = 1 + Math.abs(1-length);
            Guess guesser = new Guess(length,pointAdd,pointMulti);
            System.out.println("----------------------");
            System.out.println("| HARD MODE SETTINGS |");
            System.out.println("----------------------");
            System.out.println("Number length: " + length);
            System.out.println("Guess amount: " + guess);
            System.out.println("Point modifier: +" + pointAdd);
            System.out.println("Point multiplier: x" + pointMulti);
        }
        else {
            Guess guesser = new Guess();
            System.out.println("----------------------");
            System.out.println("| EASY MODE SETTINGS |");
            System.out.println("----------------------");
            System.out.println("Number length: 1");
            System.out.println("Guess amount: 10");
            System.out.println("Point modifier: +0");
            System.out.println("Point multiplier: x1");
        }
    }
}
