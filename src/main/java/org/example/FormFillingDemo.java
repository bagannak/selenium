package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class FormFillingDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get("https://web-playground.ultralesson.com/account/register");
        driver.findElement(By.id("RegisterForm-FirstName")).sendKeys("Baganna");
        driver.findElement(By.id("RegisterForm-LastName")).sendKeys("Kumbar");
        driver.findElement(By.id("RegisterForm-email")).sendKeys("bk@gmail.com");
        driver.findElement(By.id("RegisterForm-password")).sendKeys("12345");
        driver.findElement(By.xpath("/html/body/main/div/form/button")).submit();
        try{
            sleep(9000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.close();

    }
}
