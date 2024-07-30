import org.example.LoginPage;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class ULTest {
    WebDriver driver = null;
    @BeforeClass
    public void setup(){
        driver = new ChromeDriver();
    }

    @Test
    public void shouldLogin() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login();
        Set<Cookie> cookies = loginPage.getCookies();
        loginPage.setCookies(cookies);
    }
}