public class Guess {
    private int randomNum;

    public Guess() {
        randomNum = (int)(Math.random()*10);
    }

    public Guess(int length) {
        for (int i=1;i<=length;i++) {
            int tempDigit = (int)(Math.random()*10);
            int tempFull = tempDigit.toString();
        }
    }


}
