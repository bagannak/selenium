package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

import static java.lang.Thread.sleep;

public class WindowHandleDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.automationtesting.in/Windows.html");

        driver.findElement(By.cssSelector("#Tabbed > a > button")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);

            // Some condition to break the loop once we are on the respective tab
            // For example: we will check for the title to be Selenium
            if (driver.getTitle().contains("Selenium")) {
//                break;
                continue;
            }
        }

        // Perform some UI actions on the New tab
        driver.findElement(By.cssSelector("#main_navbar > ul > li:nth-child(4) > a")).click();
        // Close the tab
        sleep(2000);
        driver.close();

        // Switch back to the original tab
        driver.switchTo().window(windowHandles.iterator().next());

        // Continue interacting with elements on the original tab

        // Close the browser
        driver.close();
    }
}