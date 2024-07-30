package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class WebTableInteraction {
    public static void main(String[] args) throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://cosmocode.io/automation-practice-webtable/");

        // Locate the table
        WebElement table = driver.findElement(By.id("countries"));

        // Get all the rows in the table
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        // Print the number of rows in the table
        System.out.println("Number of rows in the table: " + rows.size());

        // Print all the headers
        List<WebElement> headers = rows.get(0).findElements(By.tagName("th"));
        for (WebElement header : headers) {
            System.out.println(header.getText());
        }

        // Get data from a specific column (e.g., 3rd column)
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if(cells.size() > 0) {
                System.out.println(cells.get(2).getText());
            }
        }

        // Get data from a specific row (e.g., 2nd row)
        List<WebElement> cells = rows.get(1).findElements(By.tagName("td"));
        for (WebElement cell : cells) {
            System.out.println(cell.getText());
        }

        // Search for a specific cell based on certain conditions and interact with it
        for (WebElement row : rows) {
//            cells = row.findElements(By.tagName("td"));
            List<WebElement> inputtags = driver.findElements(By.tagName("input"));
            for (WebElement inputtag: inputtags) {
                if (inputtag.getAttribute("type").equals("checkbox")) {
                    // Interact with the cell (for example, clicking if it's a link)
                   inputtag.click();
                   sleep(1000);
                }
            }
        }
        sleep(3000);
        driver.close();
    }
}