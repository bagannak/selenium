
import io.netty.handler.codec.http.multipart.FileUpload;
import org.example.AdvancedKeyboardMouseActionsDemo;
import org.example.FileUploadDemo;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.example.CookieHandlingExample;

import java.time.Duration;
import java.util.Set;

public class MainTest {
    public Set<Cookie> allCookies;
    @BeforeClass
    public void setUp(){
        CookieHandlingExample cookieHandlingExample = new CookieHandlingExample();
        allCookies = cookieHandlingExample.getCookies();
    }
    @Test
    public void testKeyMouseAction(){
        AdvancedKeyboardMouseActionsDemo advancedKeyboardMouseActionsDemo = new AdvancedKeyboardMouseActionsDemo();
        advancedKeyboardMouseActionsDemo.keyMouseActions();
    }

    @Test
    public void shouldTestSomething() throws InterruptedException {
        //Arrange
        ChromeDriver chromeDriver = new ChromeDriver();
        //Act
        chromeDriver.get("https://web-playground.ultralesson.com");
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        chromeDriver.navigate().refresh();
        Thread.sleep(4);
        //Assert
        chromeDriver.quit();
    }
}
