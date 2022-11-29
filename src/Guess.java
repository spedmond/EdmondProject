import java.util.Scanner;

public class Guess {
    private int randomNum;
    private int highScore;
    private int pointAdd;
    private int pointMulti;

    Scanner input = new Scanner(System.in);

    public Guess() {
        randomNum = (int)(Math.random()*10);
    }

    public Guess(int length,int pointAdd,int pointMulti) {
        String tempFull = "";
        for (int i=1;i<=length;i++) {
            int tempDigit = (int)(Math.random()*10);
            tempFull += tempDigit;
        }
        randomNum = Integer.parseInt(tempFull);
        this.pointAdd = pointAdd;
        this.pointMulti = pointMulti;
    }

    public String toString() {
        return "" + randomNum;
    }
}
