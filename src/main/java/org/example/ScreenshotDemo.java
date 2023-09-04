package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ScreenshotDemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to the URL
        driver.get("https://web-playground.ultralesson.com/");

        // Take screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            // Save the screenshot to a file
            FileUtils.copyFile(screenshot, new File("/Users/testvagrant/Baganna/screenShot.png"));
            System.out.println("Screenshot saved successfully!");
        } catch (IOException e) {
            System.out.println("Failed to save the screenshot: " + e.getMessage());
        }

        // Close the browser
        driver.close();
    }
}