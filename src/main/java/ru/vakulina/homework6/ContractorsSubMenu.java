package ru.vakulina.homework6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContractorsSubMenu extends BaseView {

    public ContractorsSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[.='Контактные лица']")
    public WebElement contractorsSubMenuItem;

    public void contractorsSubMenuItemClick() {
        contractorsSubMenuItem.click();
    }
}
