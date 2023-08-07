package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class AdvancedKeyboardMouseActionsDemo {
    public static void main(String[] args) {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        WebElement inputTextArea = driver.findElement(By.id("APjFqb"));
//        inputTextArea.click();
       Actions builder = new Actions(driver);
//       builder.sendKeys(inputTextArea,"what is Selenium").perform();
//
//       builder.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
        builder.keyDown(Keys.SHIFT)  // Press SHIFT key
                .sendKeys(inputTextArea, "Sample Text")  // The text will be entered in upper case
                .keyUp(Keys.SHIFT)  // Release SHIFT key
                .perform();

// Send special keys
        builder.sendKeys(Keys.TAB).perform();

        // Press CTRL+C (Copy) - Assume some text is selected
        builder.keyDown(Keys.CONTROL)
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .perform();

// Press CTRL+V (Paste) - Assume the cursor is in the correct position
        builder.keyDown(Keys.CONTROL)
                .sendKeys("v")
                .keyUp(Keys.CONTROL)
                .perform();
        try{
            sleep(7000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.close();
    }

    public void keyMouseActions(){
//        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://web-playground.ultralesson.com");

        WebElement searchIcon = driver.findElement(By.xpath("/html/body/div[2]/sticky-header/header/div/details-modal/details/summary/span"));
        WebElement searchBar = driver.findElement(By.cssSelector("#Search-In-Modal"));
        WebElement searchSubmit = driver.findElement(By.cssSelector("[class^=search__button]"));

        Actions actions = new Actions(driver);

        // Use click() method for mouse interaction
        actions.moveToElement(searchIcon).click().perform();

        // Use the sendKeys() method for keyboard interaction
        actions.sendKeys(searchBar, "shoes").perform();

        // Use click() method to initiate the search
        actions.moveToElement(searchSubmit).click().perform();


        driver.close();
    }
}
