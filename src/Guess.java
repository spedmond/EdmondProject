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
}
