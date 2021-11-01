package ru.vakulina.homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CrmProjectTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://crm.geekbrains.space/user/login");
        login(driver);

        List<WebElement> menuItems = driver.findElements(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li/a"));

        WebElement projectMenuItem = menuItems.stream().filter(e -> e.getText().equals("Проекты")).findFirst().get();

        Actions actions = new Actions(driver);
        actions.moveToElement(projectMenuItem).build().perform();
        driver.findElement(By.xpath("//span[.='Все проекты']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[.='Создать проект']")).click();
        driver.findElement(By.name("crm_project[name]")).sendKeys("Homework3");
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[text()='12323142342134']")).click();

        Select selectBusinessUnit = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        selectBusinessUnit.selectByVisibleText("Research & Development");
        Select curatorSelect = new Select(driver.findElement(By.name("crm_project[curator]")));
        curatorSelect.selectByVisibleText("Юзеров Юзер");
        Select rpSelect = new Select(driver.findElement(By.name("crm_project[rp]")));
        rpSelect.selectByVisibleText("Шараф Жанна");
        Select administratorSelect = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administratorSelect.selectByVisibleText("Юзеров Юзер");
        Select managerSelect = new Select(driver.findElement(By.name("crm_project[manager]")));
        managerSelect.selectByVisibleText("Юзеров Юзер");

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

