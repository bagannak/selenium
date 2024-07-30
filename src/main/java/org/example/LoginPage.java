package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class LoginPage {
    WebDriver driver = null;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void login(){

        driver.navigate().to("https://web-playground.ultralesson.com/account/login");

        driver.findElement(By.id("CustomerEmail")).sendKeys("alfareed@testvagrant.com");
        driver.findElement(By.id("CustomerPassword")).sendKeys("alfa@TV781");

        driver.findElement(By.cssSelector("#customer_login > button")).click();

    }
    public Set<Cookie> getCookies() {

        return driver.manage().getCookies();

    }

    public void setCookies(Set<Cookie> cookies) throws InterruptedException {
        cookies.forEach( cookie -> {
            driver.manage().addCookie(cookie);
        });
        Thread.sleep(3000);
        driver.navigate().to("https://web-playground.ultralesson.com");
    }
}