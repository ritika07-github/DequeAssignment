package org.example.deque2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseClass {

    public static ChromeDriver driver;

    @BeforeTest
    public void startDriver() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://dequeuniversity.com/demo/mars");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @AfterMethod
    public void quitDriver(){

        driver.close();
        driver.quit();
        System.out.println("Quitting the webdriver....");
    }

}
