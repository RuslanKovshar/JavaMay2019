public class Controller {

    private Model model;
    private View view;

    Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void process(){
        view.printMessage(View.FIRST_TASK);
        model.first();
        view.printMessage(View.SECOND_TASK);
        model.second();
        view.printMessage(View.THIRD_TASK);
        model.third();
    }
}
