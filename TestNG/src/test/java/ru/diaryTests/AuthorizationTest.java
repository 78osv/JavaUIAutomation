package ru.diaryTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AuthorizationTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://diary.ru/");
       // Cookie cookie = new Cookie("_identity_", "db57d05b001f9c3b9d68175bbef76f51d0970128c72e29df5498e16aea94cdbca%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3560196%2C%22XRWOvSMLkyEhGzhjm2sZLGwoemRsovfX%22%2C2592000%5D%22%3B%7D");
        //driver.manage().addCookie(cookie);
       // driver.navigate().refresh();
    }

    @Test
    public void authorizationTest() {
        driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(ConfProperties.getProperty("login"));
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(ConfProperties.getProperty("password"));
        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        driver.findElement(By.xpath("//button[@name='login-button']")).click();
        WebElement accountName = driver.findElement(By.xpath("//li[@class='username']/a"));
        String name = accountName.getText();
        Assert.assertEquals(ConfProperties.getProperty("login"), name);

        driver.findElement(By.xpath("//a[@class='drop_menu']")).click();
        driver.findElement(By.xpath("//a[text()='Выход']"));
        driver.quit();
    }

}
