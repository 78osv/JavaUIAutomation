package ru.vakulina.homework8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CreateExpensePage {

    private SelenideElement inputDescription = $(By.name("crm_expense_request[description]"));

    public CreateExpensePage fillDescription(String description) {
        inputDescription.sendKeys(description);
        return this;
    }


    private SelenideElement selectBusinessUnit = $(By.name("crm_expense_request[businessUnit]"));
    public CreateExpensePage selectBusinessUnit(String option) {
        selectBusinessUnit.selectOptionContainingText(option);
        return this;
    }


    private SelenideElement selectExpenditure = $(By.name("crm_expense_request[expenditure]"));

    public CreateExpensePage selectExpenditure(String option) {
        selectExpenditure.selectOptionContainingText(option);
        return this;
    }

    private SelenideElement plannedDate = $(By.xpath("//input[contains(@id, 'datePlan') and @placeholder='Укажите дату']"));


    private ElementsCollection calendarDates = $$(By.xpath("//a[contains(@class,'ui-state-default')]"));

    public CreateExpensePage selectPlannedDate(String date) {
        plannedDate.click();
        calendarDates.findBy(Condition.text(date)).click();
        return this;
    }

    private SelenideElement inputSumPlan = $(By.xpath("//input[contains(@id, 'crm_expense_request_sumPlan-uid')]"));

    public CreateExpensePage fillInputSumPlan(String sum) {
        inputSumPlan.sendKeys(sum);
        return this;
    }


    private SelenideElement saveAndCloseButton = $(By.xpath("//button[contains(., 'Сохранить и закрыть')]"));

    public CreateExpensePage clickSaveAndCloseButton() {
        saveAndCloseButton.click();
        return this;
    }
    public SelenideElement successMessage = $(By.xpath("//div[.='Заявка на расход сохранена'}"));
}

