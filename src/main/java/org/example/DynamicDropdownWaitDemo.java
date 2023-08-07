package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DynamicDropdownWaitDemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://web-playground.ultralesson.com");

        // Find the search bar and search icon using their locators
        WebElement searchIcon = driver.findElement(By.cssSelector("#shopify-section-header > sticky-header > header > div > details-modal > details > summary"));
        WebElement searchBar = driver.findElement(By.cssSelector("#Search-In-Modal"));

        // Perform the search
        searchIcon.click();
        searchBar.sendKeys("jeans");

        // Create a WebDriverWait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the dynamic dropdown options to be loaded
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("#predictive-search-results")));
        // Get the dynamic dropdown options
        List<WebElement> dynamicDropDownOptions = driver.findElements(By.cssSelector("#predictive-search-option-1"));
        System.out.println(dynamicDropDownOptions);
        // Loop through the options and select the desired one
        for (WebElement dynamicOption : dynamicDropDownOptions) {
            if (dynamicOption.getText().contains("Belted Jeans")) {
                dynamicOption.click();
                break;
            }
        }
        System.out.println("successfull");
        driver.quit();
    }
}
