package ru.vakulina.pageObject;

import org.openqa.selenium.WebDriver;


public class MainPage extends BaseView {
    public NavigationBar navigationBar;

    public MainPage(WebDriver driver) {
        super(driver);
        navigationBar = new NavigationBar(driver);
    }
}

