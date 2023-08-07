package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitWaitTypesDemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        // Wait for text to change
        WebDriverWait waitForTextToChange = new WebDriverWait(driver, Duration.ofSeconds(12));
        WebElement changeTextButton = driver.findElement(By.cssSelector("#populate-text"));
        changeTextButton.click();
        waitForTextToChange.until(ExpectedConditions.textToBe(By.id("h2"), "Selenium Webdriver"));

        // Wait for element to display
        WebDriverWait waitForElementToDisplay = new WebDriverWait(driver, Duration.ofSeconds(13));
        WebElement displayButton = driver.findElement(By.cssSelector("#display-other-button"));
        displayButton.click();
        waitForElementToDisplay.until(ExpectedConditions.visibilityOfElementLocated(By.id("hidden")));

        // Wait for element to enable
        WebDriverWait waitForElementEnabled = new WebDriverWait(driver, Duration.ofSeconds(13));
        WebElement enableButton = driver.findElement(By.id("enable-button"));
        enableButton.click();
        waitForElementEnabled.until(ExpectedConditions.elementToBeClickable(By.id("disable")));

        // Wait for checkbox to be selected
        WebDriverWait waitForElementToBeChecked = new WebDriverWait(driver, Duration.ofSeconds(12));
        WebElement checkboxButton = driver.findElement(By.id("checkbox"));
        checkboxButton.click();
        waitForElementToBeChecked.until(ExpectedConditions.elementSelectionStateToBe(By.id("ch"), true));

        driver.close();
    }
}