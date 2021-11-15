package ru.vakulina.homework6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateContractorsPage extends BaseView {
    public CreateContractorsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "crm_contact[lastName]")
    public WebElement inputLastName;

    public CreateContractorsPage fillLastName(String lastName) {
        inputLastName.sendKeys(lastName);
        return this;
    }

    @FindBy(name = "crm_contact[firstName]")
    public WebElement inputFirstName;

    public CreateContractorsPage fillFirstName(String firstName) {
        inputFirstName.sendKeys(firstName);
        return this;
    }

    @FindBy(xpath = "//span[.='Укажите организацию']")
    public WebElement inputOrganization;

    @FindBy(xpath = "//div[contains(@class,'select2-result-label')]")
    public List<WebElement> nameOrganization;

    public CreateContractorsPage selectOrganization(String organization) {
        inputOrganization.click();
        nameOrganization.stream().filter(element -> element.getText().equals(organization)).findFirst().get().click();
        return this;
    }

    @FindBy(name = "crm_contact[jobTitle]")
    public WebElement inputJobTitle;

    public CreateContractorsPage fillJobTitle(String jobTitle) {
        inputJobTitle.sendKeys(jobTitle);
        return this;
    }

    public static final String byXpathSaveAndCloseButtonLocator = "//button[contains(., 'Сохранить и закрыть')]";
    @FindBy(xpath = byXpathSaveAndCloseButtonLocator)
    public WebElement saveAndCloseButton;


    public CreateContractorsPage clickSaveAndCloseButton() {
        saveAndCloseButton.click();
        return this;
    }
}
