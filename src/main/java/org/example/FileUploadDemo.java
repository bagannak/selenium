package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class FileUploadDemo {
    public static void main(String[] args) throws InterruptedException {
        File file = new File("src/main/resources/demo.txt");
        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().fullscreen();
        chromeDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        chromeDriver.get("http://127.0.0.1:5500/index.html");
        WebElement inputElement = chromeDriver.findElement(By.xpath("//input[@type='file']"));
        WebElement submitBtn = chromeDriver.findElement(By.xpath("//input[@type='submit']"));

        inputElement.sendKeys(file.getAbsolutePath());
        sleep(6000);
        submitBtn.click();
        sleep(4000);
        chromeDriver.quit();
    }
}
