package testsuite;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";

    @Before //will open browser before executing methods/code
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test

    public void userShouldLoginSuccessfullyWithValidCredentials() {
        sendTextToElement(By.name("username"), "Sam");  // Enter valid username
        sendTextToElement(By.name("password"), "!S@m123");//Enter valid password
        clickOnElement(By.xpath("//input[@class ='button' and @value='Log In']"));    //Click on ‘LOGIN’ button
        String expectedText = "Accounts Overview";
        String actualText = getTextFromElement(By.xpath("//a[contains(text(),'Accounts Overview')]"));
        Assert.assertEquals(expectedText, actualText);     //Verify the ‘Accounts Overview’ text is display

    }

    @Test
    public void verifyTheErrorMessage() {
        sendTextToElement(By.name("username"), "San");// Enter invalid username
        sendTextToElement(By.name("password"), "!S@m132");// Enter invalid password
        clickOnElement(By.xpath("//input[@class ='button' and @value='Log In']"));// Click on Login button
        String expectedText = "An internal error has occurred and has been logged.";
        String actualText = getTextFromElement(By.xpath("//p[@class='error']"));
        Assert.assertEquals(expectedText, actualText);// Verify the error message ‘The username and password could not be verified.'

    }

    @Test
    public void userShouldLogOutSuccessfully() {
        sendTextToElement(By.name("username"), "Sam");  // Enter valid username
        sendTextToElement(By.name("password"), "!S@m123");//Enter valid password
        clickOnElement(By.xpath("//input[@class ='button' and @value='Log In']"));    //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));  //Click on logout button
        String expectedMessage = "Customer Login";  // This is from requirement
        String actualMessage = getTextFromElement(By.xpath("//h2[contains(text(),'Customer Login')]"));  // Find the text element and get the text
        Assert.assertEquals(expectedMessage, actualMessage); // Validate actual and expected message
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
