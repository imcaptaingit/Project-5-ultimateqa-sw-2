package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    //set up base url
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void setUpBrowser(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();
        //Verify the text ‘Welcome Back!’
        WebElement welcomeBackText = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String text = welcomeBackText.getText();
        System.out.println(text);
        Assert.assertEquals("Welcome Back!",text);
    }
    @Test
    public void verifyTheErrorMessage(){
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//a[@href='/users/sign_in']")).click();
        //Enter invalid username
        driver.findElement(By.xpath("//input[@name='user[email]']")).sendKeys("abcd@gmail.com");
        //Enter invalid password
        driver.findElement(By.xpath("//input[@name='user[password]']")).sendKeys("ab123");
        //Click on the Login button
        driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']")).click();
        //Verify the error message ‘Invalid email or password'
        WebElement invalidEmailOrPassword =  driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String text = invalidEmailOrPassword.getText();
        System.out.println(text);
        Assert.assertEquals("Invalid email or password.",text);
    }

    @After
    public void close(){
        closeBrowser();
    }
}