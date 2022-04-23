import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DriverMethodsTest {
    private static WebDriver driver1;
    private static WebDriver driver2;

    @BeforeClass
    public static void runOnceBeforeClass() {
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
        driver1 = new ChromeDriver();
        driver1.manage().window().maximize();

        System.setProperty("webdriver.gecko.driver", Constants.FIREFOXDRIVER_PATH);
        driver2 = new FirefoxDriver();
        driver2.manage().window().maximize();
    }

    @Test
    public void test01a_openChrome() {
        driver1.get("https://www.walla.com");
    }

    @Test
    public void test01b_openFirefox() {
        driver2.get("https://www.ynet.co.il");
    }

    @Test
    public void test02_navigateToTranslate() {
        driver1.get("https://translate.google.com");
        System.out.println(driver1.findElement(By.className("er8xn")));
        System.out.println(driver1.findElement(By.cssSelector("textarea")));
    }

    @Test
    public void test_03_navigateToYoutube() {
        driver2.get("https://www.youtube.com");
        System.out.println(driver2.findElement(By.id("logo-icon")));
    }

    @Test
    public void test_04_navigateToSelenium() {
        driver2.navigate().to("https://www.seleniumhq.org");
        WebElement searchBox = driver2.findElement(By.className("form-control"));
        System.out.println(searchBox);
        searchBox.sendKeys("selenium");
    }

    @Test
    public void test_05_navigateToAmazon() {
        driver1.get("https://www.amazon.com");
        String title = "Amazon.com. Spend less. Smile more.";
        String siteTitle = driver1.getTitle();
        Assert.assertEquals(siteTitle, title);
        driver1.findElement(By.name("field-keywords")).sendKeys("Leather shoes");
    }

    @Test
    public void test_06_translateHebrew() {
        driver1.get("https://translate.google.com");
        driver1.findElement(By.className("er8xn")).sendKeys("שלווה");
    }

    @Test
    public void test_07_songYoutube() {
        driver1.get("https://www.youtube.com");
        driver1.findElement(By.name("search_query")).sendKeys("George Michael - Careless Whisper");
        driver1.findElement(By.id("search-icon-legacy")).click();
    }

    @Test
    public void test_08_facebookLogin() {
        driver1.get("https://www.facebook.com");
        driver1.findElement(By.id("email")).sendKeys("user@somehost.com");
        driver1.findElement(By.id("pass")).sendKeys("pass");
        driver1.findElement(By.name("login")).click();
    }

    @AfterClass
    public static void quitBrowser() {
        driver1.quit();
        driver2.quit();
    }

}
