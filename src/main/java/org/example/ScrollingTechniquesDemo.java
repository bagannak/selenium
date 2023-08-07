package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class ScrollingTechniquesDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Navigate to the URL
        driver.get("https://web-playground.ultralesson.com/");

        // Create instance of JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll to specific element
        WebElement newsletterSection = driver.findElement(By.cssSelector("#shopify-section-footer > footer > div.footer__content-top.page-width"));
        js.executeScript("arguments[0].scrollIntoView();", newsletterSection);
        System.out.println("Successfully scrolled to the Email Newsletter section");

        // Scroll to end of the page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        System.out.println("Successfully scrolled to the end of the page");
        sleep(2000);
         // Scroll up by a specific number of pixels
        js.executeScript("window.scrollBy(0, -500);");
        System.out.println("Successfully scrolled up by 500 pixels");
        sleep(2000);
        // Close the browser
        driver.close();
    }
}