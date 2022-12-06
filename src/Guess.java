import java.util.Scanner;

public class Guess {
    private int randomNum;
    private int score = 0;
    private int length = 1;
    private int guess;
    private int pointAdd;
    private int pointMulti;
    private int guessRound;

    Scanner input = new Scanner(System.in);

    public Guess() {
        randomNum = (int)(Math.random()*10);
        length = 1;
        guess = 10;
        pointAdd = 0;
        pointMulti = 1;
    }

    public Guess(int length,int guess) {
        String tempFull = "";
        for (int i=1;i<=length;i++) {
            int tempDigit = (int)(Math.random()*10);
            tempFull += tempDigit;
        }
        randomNum = Integer.parseInt(tempFull);
        this.length = length;
        this.guess = guess;
        pointAdd = 10-guess;
        pointMulti = 1 + Math.abs(1-length);
    }

    public String toString() {
        return "" + randomNum;
    }

    public void printSettings(boolean hardMode) {
        if (hardMode) {
            System.out.println("----------------------");
            System.out.println("| HARD MODE SETTINGS |");
            System.out.println("----------------------");
            System.out.println("Number length: " + length);
            System.out.println("Guess amount: " + guess);
            System.out.println("Point modifier: +" + pointAdd);
            System.out.println("Point multiplier: x" + pointMulti + "\n");
        }
        else {
            System.out.println("----------------------");
            System.out.println("| EASY MODE SETTINGS |");
            System.out.println("----------------------");
            System.out.println("Number length: 1");
            System.out.println("Guess amount: 10");
            System.out.println("Point modifier: +0");
            System.out.println("Point multiplier: x1 \n");
        }
    }
    public void playGame() {
        String maxNum = "";
        guessRound = guess;
        for (int i = 1; i <= length; i++) {
            maxNum += 9;
        }
        while (guessRound>0) {
            System.out.print("Pick a number between 0 and " + maxNum + ": ");
            int userGuess = input.nextInt();
            if (userGuess<randomNum) {
                guessRound--;
                System.out.println("Too low! You have " + guessRound + " attempt(s) left.");
            }
            if (userGuess>randomNum) {
                guessRound--;
                System.out.println("Too high! You have " + guessRound + " attempt(s) left.");
            }
            else {
                System.out.println("Good job! You guessed the number in " + Math.abs((guessRound-1)-guess) + " attempt(s)!");
                score+=1+pointAdd;
            }
        }

    }

    public int getScore() {
        return score*pointMulti;
    }

    public int getGuess() {
        return guess;
    }

    public boolean playAgain() {
        System.out.print("Would you like to play again? Type \"Yes\" if so: ");
        String answer = input.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            playGame();
            return true;
        }
        return false;
    }
}
