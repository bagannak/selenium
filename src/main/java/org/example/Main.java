package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.lang.Thread.sleep;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
//        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://web-playground.ultralesson.com");
        driver.findElement(By.xpath("/html/body/main/section[1]/div/slider-component/ul/li[1]/div/div[1]/div/h3/a")).click();
        driver.navigate().back();
//       driver.navigate().forward();

        try{
            sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.close();

    }


}