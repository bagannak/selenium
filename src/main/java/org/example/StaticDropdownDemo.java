package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class StaticDropdownDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu");
        WebElement selectElement = driver.findElement(By.cssSelector("#post-2646 > div.twelve.columns > div > div > div > p > select"));
        Select dropDown = new Select(selectElement);

        dropDown.selectByValue("IND");
        sleep(1000);
        dropDown.selectByIndex(3);
        try{
            sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        dropDown.selectByVisibleText("Pakistan");
        // Get all options
        List<WebElement> options = dropDown.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        driver.close();
    }
}
