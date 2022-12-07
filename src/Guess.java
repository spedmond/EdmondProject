import java.util.Scanner;

public class Guess {
    private int timesPlayed = 0;
    private int randomNum;
    private int score = 0;
    private int length;
    private int guess;
    private int guessesUsed = 0;
    private int pointAdd;
    private int pointMulti;
    private boolean isHardMode;

    Scanner input = new Scanner(System.in);

    public Guess() {
        randomNum = (int)(Math.random()*10);
        length = 1;
        guess = 10;
        pointAdd = 0;
        pointMulti = 1;
        isHardMode = false;
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
        isHardMode = true;
    }

    public int getScore() {
        return score;
    }

    public int getModifiedScore() {
        return (score*(1+pointAdd))*pointMulti;
    }

    public int getTimesPlayed() {
        return timesPlayed;
    }

    public void setRandomNum() {
        if (isHardMode) {
            String tempFull = "";
            for (int i=1;i<=length;i++) {
                int tempDigit = (int) (Math.random() * 10);
                tempFull += tempDigit;
            }
        }
        else {
            randomNum = (int)(Math.random()*10);
        }
    }

    public String toString() {
        return "Number length: " + length + "\nGuess amount: " + guess + "\nPoint modifier: +" + pointAdd + "\nPoint multiplier: x" + pointMulti;
    }

    public void printSettings(boolean hardMode) {
        if (hardMode) {
            System.out.println("----------------------");
            System.out.println("| HARD MODE SETTINGS |");
            System.out.println("----------------------");
            System.out.println(toString());
        }
        else {
            System.out.println("----------------------");
            System.out.println("| EASY MODE SETTINGS |");
            System.out.println("----------------------");
            System.out.println(toString());
        }
    }
    public void playGame() {
        boolean guessed = false;
        guessesUsed = 0;
        String maxNum = "";
        for (int i = 1; i <= length; i++) {
            maxNum += 9;
        }
        while (guessesUsed<guess && !guessed) {
            System.out.print("Pick a number between 0 and " + maxNum + ": ");
            int userGuess = input.nextInt();
            if (userGuess<randomNum) {
                guessesUsed++;
                System.out.println("Too low! You have " + (guess-guessesUsed) + " attempt(s) left.");
            }
            if (userGuess>randomNum) {
                guessesUsed++;
                System.out.println("Too high! You have " + (guess-guessesUsed) + " attempt(s) left.");
            }
            else if (userGuess==randomNum) {
                guessesUsed++;
                guessed = true;
                score++;
                System.out.println("Good job! You guessed the number in " + guessesUsed + " attempt(s)!");
            }
        }
        if (!guessed) {
            System.out.println("You lost!");
            System.out.println("The correct number was: " + randomNum);
            System.out.println("Score: " + getModifiedScore());
        }
    }

    public void finish() {
        System.out.println("Congratulations! You beat NUMBER GUESSER " + getScore() + " time(s)!");
        System.out.println("Score: " + getModifiedScore());
    }
}
