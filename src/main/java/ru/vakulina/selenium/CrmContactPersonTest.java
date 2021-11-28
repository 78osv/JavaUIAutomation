package ru.vakulina.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CrmContactPersonTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        driver.get("https://crm.geekbrains.space/user/login");
        login(driver);

        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li/a"));

        WebElement contactMenuItem = menuItems.stream().filter(e -> e.getText().equals("Контрагенты")).findFirst().get();

        Actions actions = new Actions(driver);
        actions.moveToElement(contactMenuItem).build().perform();
        driver.findElement(By.xpath("//span[.='Контактные лица']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Создать контактное лицо']")));
        driver.findElement(By.xpath("//a[.='Создать контактное лицо']")).click();
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Vak");
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Ol");
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='12323142342134']")));
        driver.findElement(By.xpath("//div[text()='12323142342134']")).click();
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("QA");
        driver.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]")).click();
        Thread.sleep(5000);
        driver.quit();
    }

    static void login(WebDriver driver) {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
