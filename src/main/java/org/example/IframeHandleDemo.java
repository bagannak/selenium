package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class IframeHandleDemo {
    public static void main(String[] args) {
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("https://demo.automationtesting.in/Frames.html");
        chromeDriver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);

//        WebElement iframeElement = chromeDriver.findElement(By.cssSelector("#singleframe"));
        chromeDriver.switchTo().frame(1);
        chromeDriver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Hello World");
        chromeDriver.switchTo().frame(0);

        chromeDriver.close();
    }
}
