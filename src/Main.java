import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isHardMode = false;
        boolean another = true;

        System.out.println("--------------------");
        System.out.println("| GUESS THE NUMBER |");
        System.out.println("--------------------");

        System.out.print("Would you like to play on HARD mode? Type \"Yes\" if so, otherwise press enter: ");
        String diff = input.nextLine();
        System.out.println();

        if (diff.equalsIgnoreCase("yes")) {
            isHardMode = true;
            System.out.print("Choose number of guesses (Min. 1, Max. 9; the fewer guesses you have, the more points you'll gain per number guessed correctly): ");
            int guess = input.nextInt();
            while (guess <= 0 || guess > 9) {
                System.out.print("Error: Number of guesses must be between 1 and 9. Please reenter guesses: ");
                guess = input.nextInt();
            }

            System.out.print("Choose the length of the random number (Min. 2, Max. 7; every additional number will increase your score multiplier by 1): ");
            int length = input.nextInt();
            while (length < 2 || length > 7) {
                System.out.print("Error: Length must be between 2 and 7. Please reenter length: ");
                length = input.nextInt();
            }

            Guess game = new Guess(length, guess);
            game.printSettings(isHardMode);
            System.out.println();
            game.playGame();
            System.out.println();
            while (another) {
                System.out.print("Would you like to play again? Type \"Yes\" if so: ");
                String playAgain = input.nextLine();
                if (playAgain.equalsIgnoreCase("yes")) {
                    game.setRandomNum();
                    System.out.println();
                    game.playGame();
                    System.out.println();
                }
                else {
                    another = false;
                }
            }
            System.out.println();
            game.finish();
        }
        else {
            Guess game = new Guess();
            game.printSettings(isHardMode);
            System.out.println();
            game.playGame();
            System.out.println();
            while (another) {
                System.out.print("Would you like to play again? Type \"Yes\" if so: ");
                String playAgain = input.nextLine();
                if (playAgain.equalsIgnoreCase("yes")) {
                    game.setRandomNum();
                    System.out.println();
                    game.playGame();
                }
                else {
                    another = false;
                }
            }
            System.out.println();
            game.finish();
        }
    }
}