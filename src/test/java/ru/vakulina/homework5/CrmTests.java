package ru.vakulina.homework5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.common.HasTextMatcher.hasText;

public class CrmTests {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 10);
        login(driver);
    }

    @Test
    void crmContactPersonTest() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Контрагенты']/parent::a")))
                .build().perform();
        driver.findElement(By.xpath("//span[.='Контактные лица']")).click();
        //Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Создать контактное лицо']")));
        driver.findElement(By.xpath("//a[.='Создать контактное лицо']")).click();
        //Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("crm_contact[lastName]")));
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("123");
        //Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("crm_contact[firstName]")));
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("456");
        //Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Укажите организацию']")));
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
       // Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='12323142342134']")));
        driver.findElement(By.xpath("//div[text()='12323142342134']")).click();
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("QA");
        driver.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]")).click();
        Thread.sleep(5000);
        WebElement creatingContact = driver.findElement(By.xpath("//div[@class='message']"));
        assertThat(creatingContact, hasText("Контактное лицо сохранено"));

    }

    @Test
    void crmProjectTest() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[text()='Проекты']/parent::a")))
                .build().perform();
        driver.findElement(By.xpath("//span[.='Все проекты']")).click();
        //Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Создать проект']")));
        driver.findElement(By.xpath("//a[.='Создать проект']")).click();
        //Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.name("crm_project[name]")));
        driver.findElement(By.name("crm_project[name]")).sendKeys("My Project");
        driver.findElement(By.xpath("//span[.='Укажите организацию']")).click();
        //Thread.sleep(5000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='12323142342134']")));
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
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@id, 'crm_project_planning')]")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_planning')]")));
        driver.findElement(By.xpath("//body")).sendKeys("test");
        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]")).click();
        Thread.sleep(5000);
        WebElement creatingProject = driver.findElement(By.xpath("//span[@class='validation-failed']"));
        assertThat(creatingProject, hasText("Это значение уже используется."));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    static void login(WebDriver driver) {
        driver.get("https://crm.geekbrains.space/user/login");
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
