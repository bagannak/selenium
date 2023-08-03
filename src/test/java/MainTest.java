import org.example.AdvancedKeyboardMouseActionsDemo;
import org.example.Main;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTest {
    @Test
    public void testKeyMouseAction(){
        AdvancedKeyboardMouseActionsDemo advancedKeyboardMouseActionsDemo = new AdvancedKeyboardMouseActionsDemo();
        advancedKeyboardMouseActionsDemo.keyMouseActions();
    }
}
