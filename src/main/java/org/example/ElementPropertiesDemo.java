package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementPropertiesDemo {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("Your Webpage URL");

        WebElement button = driver.findElement(By.id("Your Locator Here for Button"));
        WebElement checkbox = driver.findElement(By.id("Your Locator Here for Checkbox"));

        System.out.println("Button is displayed: " + button.isDisplayed());
        System.out.println("Button is enabled: " + button.isEnabled());
        System.out.println("Checkbox is displayed: " + checkbox.isDisplayed());
        System.out.println("Checkbox is enabled: " + checkbox.isEnabled());
        System.out.println("Checkbox is selected: " + checkbox.isSelected());

        driver.close();
    }
}