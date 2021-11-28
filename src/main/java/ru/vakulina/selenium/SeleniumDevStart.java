package ru.vakulina.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDevStart {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        WebElement search = driver.findElement(By.xpath("//input[@title='Поиск']"));
        search.sendKeys("купить кофемашину bork c804", Keys.ENTER);
        Thread.sleep(5000);
        driver.quit();
    }
    }
