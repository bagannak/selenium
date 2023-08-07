package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertBoxDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("Your Webpage URL");

        // Scenario 1: Alert with just OK
        driver.findElement(By.cssSelector("Your Locator Here to Trigger Alert with OK")).click();
        Alert alertWithOK = driver.switchTo().alert();
        alertWithOK.accept();

        // Scenario 2: Alert with OK and Cancel
        driver.findElement(By.cssSelector("Your Locator Here to Trigger Alert with OK and Cancel")).click();
        Alert alertWithOKAndCancel = driver.switchTo().alert();
        alertWithOKAndCancel.accept();

        // After checking the accept, comment the accept and check the dismiss functionality
        // driver.findElement(By.cssSelector("Your Locator Here to Trigger Alert with OK and Cancel")).click();
        // alertWithOKAndCancel.dismiss();

        // Scenario 3: Alert with Text Input Prompt
        driver.findElement(By.cssSelector("Your Locator Here to Trigger Alert with Text Input")).click();
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys("James");
        promptAlert.accept();

        Thread.sleep(2000); // Used only to observe the change, but in real projects should not be used

        driver.close();
    }
}