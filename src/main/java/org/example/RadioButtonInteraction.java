package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static java.lang.Thread.sleep;

public class RadioButtonInteraction {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://htmldog.com/examples/inputcheckboxes/");
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(4));
        WebElement iframe =chromeDriver.findElement(By.cssSelector("#dexOutput > div > samp > iframe"));
        wait.until(ExpectedConditions.visibilityOf(iframe));
        chromeDriver.switchTo().frame(iframe);
        List<WebElement> radioButtons =chromeDriver.findElements(By.cssSelector("[type=radio]"));
        for (WebElement radioButton : radioButtons) {
            if(!radioButton.isSelected()){
                radioButton.click();
                sleep(2000);
            }
        }
        chromeDriver.findElement(By.id("20to39")).click();
        chromeDriver.close();
    }
}
