package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class CookieHandlingExample {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://web-playground.ultralesson.com");

        driver.findElement(By.xpath("//*[@class='header__icon header__icon--account link focus-inset small-hide']")).click();

        driver.findElement(By.xpath("//*[@id='CustomerEmail']")).sendKeys("kbaganna18@gmail.com");
        driver.findElement(By.xpath("//*[@id='CustomerPassword']")).sendKeys("baganna#18");
        driver.findElement(By.cssSelector("#customer_login > button")).click();

//        Cookie cookie = new Cookie("Key", "Value");
//        driver.manage().addCookie(cookie);
//        Cookie cookie1 = new Cookie("cart","items");
//        driver.manage().addCookie(cookie1);
//        System.out.println(driver.manage().getCookieNamed("Key"));
        Set<Cookie> allCookies = driver.manage().getCookies();

        System.out.println(allCookies);
//        driver.manage().deleteCookieNamed("cart");
//        Cookie deletedCookie = driver.manage().getCookieNamed("cart");
//        System.out.println("Deleted cookie: " + deletedCookie);
        try{
            sleep(4000);
        }catch (InterruptedException e){
           throw new RuntimeException(e);
        }
        driver.close();
    }

    public Set<Cookie> getCookies(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://magento.softwaretestingboard.com/");

        driver.findElement(By.xpath("//*[@class='header__icon header__icon--account link focus-inset small-hide']")).click();

        driver.findElement(By.xpath("//*[@id='CustomerEmail']")).sendKeys("kbaganna18@gmail.com");
        driver.findElement(By.xpath("//*[@id='CustomerPassword']")).sendKeys("baganna#18");
        driver.findElement(By.cssSelector("#customer_login > button")).click();
        Set<Cookie> allCookies = driver.manage().getCookies();
        return allCookies;
    }
}
