package ru.stqa.trainings.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
    public WebDriver driver;
    public WebDriverWait wait;

    @Before
    public void start() {

        //Command line options
        /*
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        */

        //Capabilities
        /*
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("unexpectedAlertBehaviour", "dismiss");
        driver = new ChromeDriver(caps);
        System.out.println(((HasCapabilities) driver).getCapabilities());
        */

        //Capabilities for PhantomJS
        /*
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\Program Files\\PhantomJS\\bin\\phantomjs.exe");
        driver = new PhantomJSDriver(caps);
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        */

        //Запуск Firefox ESR
        /*
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(FirefoxDriver.MARIONETTE, false);
        driver = new FirefoxDriver(
                new FirefoxBinary(new File("C:\\Program Files\\Nightly\\firefox.exe")),
                new FirefoxProfile(), caps);
        wait = new WebDriverWait(driver, 10);
        */

        //Запуск Firefox Nightly
        /*
        DesiredCapabilities caps = new DesiredCapabilities();
        driver = new FirefoxDriver(
                new FirefoxBinary(new File("C:\\Program Files\\Nightly\\firefox.exe")),
                new FirefoxProfile(), caps);
        wait = new WebDriverWait(driver, 10);
        */
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

    public void adminLogin() {
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='remember_me']")).click();
        driver.findElement(By.xpath("//button[@name='login']")).click();
    }

    public void adminLogout() {
        driver.findElement(By.xpath("//*[@id='sidebar']/div[2]/a[5]/i")).click();
    }

    public void goToHomepage() {
        driver.navigate().to("http://localhost/litecart/en/");
    }
}