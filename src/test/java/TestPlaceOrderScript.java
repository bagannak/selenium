
import org.example.PlaceOrderScript;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPlaceOrderScript {
    PlaceOrderScript placeOrderScript;
    @BeforeClass
    public  void setUp(){
        placeOrderScript = new PlaceOrderScript();
    }
    @Test
    public void shouldTestSomething(){
        //Arange
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Act
        // Continue the steps from the previous task...
        driver.get("https://web-playground.ultralesson.com/");
        // Click on the login button in the header
        WebElement loginButton = driver.findElement(By.cssSelector("#shopify-section-header > sticky-header > header > div > a.header__icon.header__icon--account.link.focus-inset.small-hide"));
        placeOrderScript.clickAndWaitForElement(driver, loginButton);

        // Click on the create button in the login modal
        WebElement createAccountButton = driver.findElement(By.cssSelector("#customer_login > a:nth-child(7)"));
        placeOrderScript.clickAndWaitForElement(driver, createAccountButton);

        // Enter user details in the signup form
        WebElement firstNameField = driver.findElement(By.id(("RegisterForm-FirstName")));
        WebElement lastNameField = driver.findElement(By.id("RegisterForm-LastName"));
        WebElement emailField = driver.findElement(By.id("RegisterForm-email"));
        WebElement passwordField = driver.findElement(By.id("RegisterForm-password"));
         WebElement createAccountButtonLocator = driver.findElement(By.xpath("/html/body/main/div/form/button"));
        placeOrderScript.enterTextAndWaitForElement(driver, firstNameField, "Julie");
        placeOrderScript.enterTextAndWaitForElement(driver, lastNameField, "Warner2");
        placeOrderScript.enterTextAndWaitForElement(driver, emailField, "juliewarner72@ultralesson.com");
        placeOrderScript.enterTextAndWaitForElement(driver, passwordField, "123456");
        placeOrderScript.clickAndWaitForElement(driver,createAccountButtonLocator);


        // Click on the first product in the search results
        WebElement firstProductLocator = driver.findElement(By.xpath("/html/body/main/section[1]/div/slider-component/ul/li[2]/div/div[1]/div/h3/a"));
        placeOrderScript.clickAndWaitForElement(driver, firstProductLocator);

        // Click on the 'Add to Cart' button
        WebElement addToCartButtonLocator = driver.findElement(By.name("add"));
        addToCartButtonLocator.click();

        // Click on the 'Checkout' button
        WebElement checkoutButtonLocator = driver.findElement(By.name("checkout"));
        placeOrderScript.clickAndWaitForElement(driver, checkoutButtonLocator);

        // Input the delivery address
        WebElement addressInputLocator = driver.findElement(By.cssSelector("#address1"));
        placeOrderScript.enterTextAndWaitForElement(driver, addressInputLocator, "E406 Nikoo homes2 bharatiya city");

        // Rest of the address inputs...
         WebElement cityInputLocator = driver.findElement(By.id("TextField5"));
         placeOrderScript.enterTextAndWaitForElement(driver,cityInputLocator,"Bengaluru");

          WebElement selectStateLocator = driver.findElement(By.id("Select2"));
        Select select = new Select(selectStateLocator);
        select.selectByValue("KA");
         WebElement pincodeInputLocator = driver.findElement(By.id("TextField6"));
        placeOrderScript.enterTextAndWaitForElement(driver,pincodeInputLocator,"560064");
        // Click on the 'Continue to shipping' button
        WebElement continueToShippingButtonLocator = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div/div/div[2]/div/div/div/main/form/div[1]/div/div[2]/div[2]/div/button"));
        placeOrderScript.clickAndWaitForElement(driver, continueToShippingButtonLocator);

        // Click on the 'Continue to payment' button
        WebElement continueToPaymentButtonLocator = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div/div[2]/div/div/div/div[2]/div/div/div/main/form/div[1]/div/div/div[2]/div[1]/button"));
        placeOrderScript.clickAndWaitForElement(driver, continueToPaymentButtonLocator);

         //Select the 'Pay on Delivery' option
        WebElement payOnDeliveryOptionLocator = driver.findElement(By.id("basic-paymentOnDelivery"));
        placeOrderScript.clickAndWaitForElement(driver, payOnDeliveryOptionLocator);

//        // Click on the 'Complete order' button
        WebElement completeOrderButtonLocator = driver.findElement(By.cssSelector("#Form1 > div:nth-child(1) > div > div.oQEAZ.WD4IV > div:nth-child(1) > button"));
        placeOrderScript.clickAndWaitForElement(driver, completeOrderButtonLocator);
        //Assert
        Assert.assertEquals(driver.getTitle(),"Payment - ul-web-playground");
        driver.quit();

    }

}
