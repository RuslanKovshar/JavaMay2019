import org.junit.Assert;
import org.junit.Test;

public class ModelTest {

    @Test
    public void setSecretNumber() {
        Model model = new Model();
        for (int i = 0; i < 1000; i++) {
            model.setSecretNumber();
            if (model.getSecretNumber() <= 0 || model.getSecretNumber()>= 100){
                Assert.fail();
            }
        }

    }
}