//9 - clicking on an element using javascript from within java.

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChallengeTest {
    private static WebDriver driver1;

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
        driver1 = new ChromeDriver();
        driver1.manage().window().maximize();
    }

    @Test
    public void buttonClick() {
        driver1.get("https://www.amazon.com");
        WebElement button = driver1.findElement(By.id("nav-hamburger-menu"));
        String javascript ="arguments[0].click()";
        JavascriptExecutor js = (JavascriptExecutor) driver1;
        js.executeScript(javascript, button);
        //this button has to be clicked to reveal the menu under All.
        //But the menu is only revealed if we go with our mouse to the left side of the browser.
    }

    @AfterClass
    public void quitBrowser() {
        driver1.quit();
    }

    //10 - It is possible to run tests on multiple browsers and machines using Selenium Grid.
}