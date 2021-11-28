package ru.vakulina.selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ExpensesPage {
    private SelenideElement buttonCreateExpenseRequest = $(By.xpath("//a[.='Создать заявку на расход']"));

    public CreateExpensePage clickCreateExpenseRequest() {
        buttonCreateExpenseRequest.click();
        return page(CreateExpensePage.class);
    }




}

