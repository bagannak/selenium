package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class IframeHandleDemo {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        chromeDriver.get("https://demo.automationtesting.in/Frames.html");
        chromeDriver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);

        WebElement iframeElement = chromeDriver.findElement(By.cssSelector("#singleframe"));
        chromeDriver.switchTo().frame(iframeElement);
        chromeDriver.findElement(By.xpath("//input[@type=text]")).sendKeys("Hello World");
        chromeDriver.switchTo().parentFrame();
        chromeDriver.close();
    }
}
