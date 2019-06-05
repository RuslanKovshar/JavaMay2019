import com.kovshar.controller.Controller;
import com.kovshar.model.Model;
import com.kovshar.view.View;

public class Main {
    public static void main(String[] args){
        Controller controller = new Controller(new Model(), new View());
        controller.process();
    }
}