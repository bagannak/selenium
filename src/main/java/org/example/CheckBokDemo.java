package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class CheckBokDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://htmldog.com/examples/inputcheckboxes/");
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(4));
        WebElement iframe =chromeDriver.findElement(By.cssSelector("#dexOutput > div > samp > iframe"));
        wait.until(ExpectedConditions.visibilityOf(iframe));
        chromeDriver.switchTo().frame(iframe);
        List<WebElement> checkboxs =chromeDriver.findElements(By.cssSelector("[type=checkbox]"));
//        checkboxs.addAll(chromeDriver.findElements(By.cssSelector("[type=checkbox]")));
        for (WebElement checkbox : checkboxs) {
            if(!checkbox.isSelected()){
                checkbox.click();
//                sleep(2000);
            }
        }
        for (WebElement checkbox : checkboxs) {
            if(checkbox.isSelected()){
                checkbox.click();
//                sleep(2000);
            }
        }
//        System.out.println(checkboxs);

        chromeDriver.close();
    }
}
