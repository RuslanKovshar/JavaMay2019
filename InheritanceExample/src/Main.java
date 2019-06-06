import com.company.First;
import com.company.Second;

public class Main {
    public static void main(String[] args) {
        First f = new Second();
        f.addFive();
        System.out.println(f.getValue());
    }
}
