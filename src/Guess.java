import java.util.Scanner;

public class Guess {
    private int randomNum;
    private int highScore;
    private int length;
    private int guess;
    private int pointAdd;
    private int pointMulti;

    Scanner input = new Scanner(System.in);

    public Guess() {
        randomNum = (int)(Math.random()*10);
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
            System.out.println("Point multiplier: x" + pointMulti);
        }
        else {
            System.out.println("----------------------");
            System.out.println("| EASY MODE SETTINGS |");
            System.out.println("----------------------");
            System.out.println("Number length: 1");
            System.out.println("Guess amount: 10");
            System.out.println("Point modifier: +0");
            System.out.println("Point multiplier: x1");
        }
    }
    public boolean playGame() {
        for (int guessRound=guess;guessRound>0;guessRound--) {
            String maxNum = "";
            for (int i = 1; 1 <= length; i++) {
                maxNum += 9;
            }
            System.out.print("Pick a number between 0 and " + maxNum + "!");
            int userGuess = input.nextInt();
            if (userGuess<randomNum) {
                System.out.println("Too low!");
            }
            if (userGuess>randomNum) {
                System.out.println("Too high!");
            }
            else {
                System.out.print("Good job! You guessed the number in " + Math.abs(guessRound-guess) + " tries!");
                return true;
            }
        }
        return false;
    }
}
