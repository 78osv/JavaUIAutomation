package ru.vakulina.homework6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContractorsPage extends BaseView {

    public ContractorsPage(WebDriver driver) {
        super(driver);
    }

    private final String byXpathButtonCreateContractorRequestLocator = "//a[.='Создать контактное лицо']";
    @FindBy(xpath = byXpathButtonCreateContractorRequestLocator)
    public WebElement buttonCreateContractorRequest;

    public CreateContractorsPage clickCreateContractorRequest() {
        webDriverWait.until(ExpectedConditions.visibilityOf(loader));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(byXpathButtonCreateContractorRequestLocator)));
        buttonCreateContractorRequest.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CreateContractorsPage.byXpathSaveAndCloseButtonLocator)));
        return new CreateContractorsPage(driver);
    }
}
