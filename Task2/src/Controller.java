import java.util.Scanner;

public class Controller {

    public Model model;
    public View view;

    Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }


    public void gameProcess(){
        model.setSecretNumber();
        view.printMessage(View.GAME_START);
        boolean isTrue = true;
        while (isTrue){
            view.printMessage(View.TRY_TO_GUESS + View.OPEN_BRACKET + model.getRangeStart() + View.DASH +
                                model.getRangeEnd() + View.CLOSE_BRACKET);
            isTrue = model.checkNumber(getNumber());
        }
        view.printMessage(View.CONGRATULATIONS);
        view.printMessage(View.GUESSES + model.getGuesses());
    }

    public int getNumber(){
        Scanner sc = new Scanner(System.in);
        boolean isTrue = true;
        int number = 0;
        while (isTrue){
            number = inputIntNumber(sc);
            if (number <= model.getRangeStart() || number >= model.getRangeEnd()){
                view.printMessage(View.OUT_OF_RANGE);
            }
            else {
                isTrue = false;
            }
        }
        return number;
    }

    public int inputIntNumber(Scanner sc){
        view.printMessage(View.INPUT_NUMBER);
        while (!sc.hasNextInt()){
            view.printMessage(View.INCORRECT_INPUT + View.INPUT_NUMBER);
            sc.next();
        }
        return sc.nextInt();
    }
}
