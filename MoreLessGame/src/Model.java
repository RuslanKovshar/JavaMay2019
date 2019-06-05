
public class Model {

    private int rangeStart;
    private int rangeEnd;
    private int secretNumber;
    private int guesses;

    Model(){
        rangeStart = 0;
        rangeEnd = 100;
        guesses = 0;
    }

    public void setSecretNumber(){
        secretNumber = 1 + (int)(Math.random() * 99);
    }

    public int getSecretNumber(){
        return secretNumber;
    }

    public boolean checkNumber(int guessNumber){
        guesses++;
        if (guessNumber == secretNumber){
            return false;
        }else if (guessNumber > secretNumber){
                rangeEnd = guessNumber;
                return true;
        }else {
            rangeStart = guessNumber;
            return true;
        }
    }

    public int getRangeStart(){
        return rangeStart;
    }

    public int getRangeEnd(){
        return rangeEnd;
    }

    public int getGuesses(){
        return guesses;
    }

}
