package ru.vakulina.homework6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectTest {
    EventFiringWebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void setUpDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUpBrowser() {

        ChromeOptions options = new ChromeOptions();

        driver = new EventFiringWebDriver(new ChromeDriver(options));
        webDriverWait = new WebDriverWait(driver, 5);
        driver.get("https://crm.geekbrains.space/");
    }


    @Test
    void loginTest() throws InterruptedException {
        new LoginPage(driver)
                .fillLogin("Applanatest1")
                .fillPassword("Student2020!")
                .submitLogin();

        new MainPage(driver).navigationBar.openNavBarItem("Контрагенты");
        new ContractorsSubMenu(driver).contractorsSubMenuItemClick();
        new ContractorsPage(driver).clickCreateContractorRequest();
        new CreateContractorsPage(driver)
                .fillLastName("123")
                .fillFirstName("456")
                .selectOrganization("12323142342134")
                .fillJobTitle("QA")
                .clickSaveAndCloseButton();

        webDriverWait.until(ExpectedConditions.invisibilityOf(new BaseView(driver).loader));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[.='Контактное лицо сохранено']")).isDisplayed());

    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
