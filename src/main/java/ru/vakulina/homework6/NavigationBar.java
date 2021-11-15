package ru.vakulina.homework6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class NavigationBar extends BaseView {
    ContractorsSubMenu contractorsSubMenu;

    public NavigationBar(WebDriver driver) {
        super(driver);
        contractorsSubMenu = new ContractorsSubMenu(driver);
    }

    @FindBy(xpath = "//ul[@class='nav nav-multilevel main-menu']/li/a")
    public List<WebElement> navBarItems;


    public void openNavBarItem(String itemName) {
        Actions actions = new Actions(driver);
        WebElement item = navBarItems.stream().filter(element -> element.getText().equals(itemName)).findFirst().get();
        actions.moveToElement(item).build().perform();

    }

}
