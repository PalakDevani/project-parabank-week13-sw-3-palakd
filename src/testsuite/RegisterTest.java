package testsuite;

import com.google.common.base.Verify;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.checkerframework.checker.units.qual.A;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.io.Zip;
import utilities.Utility;

public class RegisterTest extends Utility {

    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before //will open browser before executing methods/code
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyThatSigningPageDisplay() {
        clickOnElement(By.linkText("Register")); // click on register link
        String expectedText = "Signing up is easy!"; // text from requirement
        String actualText = getTextFromElement(By.xpath("//h1[text() ='Signing up is easy!']"));
        Assert.assertEquals(expectedText, actualText); // matches/compare exp Vs actu. texts
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        clickOnElement(By.linkText("Register")); // click on register link
        sendTextToElement(By.xpath("//input[@id='customer.firstName']"), "John");// enter first name
        sendTextToElement(By.xpath("//input[@name='customer.lastName']"), "Jony");//  Enter Last name
        sendTextToElement(By.xpath("//input[@id='customer.address.street']"), "4858,Woodrose close");//  Enter Address
        sendTextToElement(By.xpath("//input[@id='customer.address.city']"), "Huston");   //  Enter City
        sendTextToElement(By.xpath("//input[@id='customer.address.state']"), "Texas");  //  Enter State
        sendTextToElement(By.xpath("//input[@id='customer.address.zipCode']"), "77320"); //  Enter Zip Code
        sendTextToElement(By.xpath("//input[@id='customer.phoneNumber']"), "01432567891"); //  Enter Phone
        sendTextToElement(By.xpath("//input[@id='customer.ssn']"), "123-45-7698");  //  Enter SSN
        sendTextToElement(By.xpath("//input[@id='customer.username']"), "JohnJony");  // Enter Username
        sendTextToElement(By.xpath("//input[@id='customer.password']"), "@1425Om22");    //  Enter Password
        sendTextToElement(By.xpath("//input[@id='repeatedPassword']"), "@1425Om22");   //  Enter Confirm
        clickOnElement(By.xpath("//input[@class='button' and @value = 'Register']"));//  Click on REGISTER button
        String expectedText = "Your account was created successfully. You are now logged in.";
        String actualText = getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in.')]"));
        Assert.assertEquals(expectedText, actualText); //  Verify the text expc. Vs actu.
    }

    @After
    public void tearDown() { // Browser close after test execution
        closeBrowser();
    }
}
