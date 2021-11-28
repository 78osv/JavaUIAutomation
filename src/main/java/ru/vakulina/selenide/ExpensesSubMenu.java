package ru.vakulina.selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;

public class ExpensesSubMenu {

    private SelenideElement expensesSubMenuItem = $(By.xpath("//span[.='Заявки на расходы']"));

    public void expensesSubMenuItemClick() {
        expensesSubMenuItem.click();
    }
}

