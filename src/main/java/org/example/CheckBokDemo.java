package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class CheckBokDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://htmldog.com/examples/inputcheckboxes/");
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(4));
        WebElement iframe =chromeDriver.findElement(By.cssSelector("#dexOutput > div > samp > iframe"));
        wait.until(ExpectedConditions.visibilityOf(iframe));
        chromeDriver.switchTo().frame(iframe);
        List<WebElement> checkboxes =chromeDriver.findElements(By.cssSelector("[type=checkbox]"));
//        checkboxes.addAll(chromeDriver.findElements(By.cssSelector("[type=checkbox]")));
        for (WebElement checkbox : checkboxes)
            if (!checkbox.isSelected()) {
                checkbox.click();
//                sleep(2000);
            }
        //                sleep(2000);
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                checkbox.click();
            }
        }
//        System.out.println(checkboxes);

        chromeDriver.close();
    }
}
