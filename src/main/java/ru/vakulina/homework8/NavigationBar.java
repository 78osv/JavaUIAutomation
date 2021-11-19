package ru.vakulina.homework8;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

public class NavigationBar {
    ExpensesSubMenu expensesSubMenu;

    public NavigationBar() {
        expensesSubMenu = new ExpensesSubMenu();
    }

    private List<SelenideElement> navBarItems = $$(By.xpath("//ul[@class='nav nav-multilevel main-menu']/li/a"));



    public void openNavBarItem(String itemName) {
        SelenideElement item = navBarItems.stream().filter(element -> element.getText().equals(itemName)).findFirst().get();
        item.hover();
    }
}

