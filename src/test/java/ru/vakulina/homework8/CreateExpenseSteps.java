package ru.vakulina.homework8;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class CreateExpenseSteps {
    @Given("^I am authorized$")
    public void iAmAuthorized() {
        Selenide.open("https://crm.geekbrains.space/");
        new LoginPage().fillLogin("Applanatest1").fillPassword("Student2020!").submitLogin();
    }
    @Given("^Я перехожу с помощью интерфейса на страницу создания заявки на расход$")
    public void goToCreateExpensePageUsingInterface() {
        new MainPage().navigationBar.openNavBarItem("Расходы");
        new ExpensesSubMenu().expensesSubMenuItemClick();
        new ExpensesPage().clickCreateExpenseRequest();
    }
    @When("^Я заполняю имя заявки$")
    public void iFillExpenseName() {
        new CreateExpensePage().fillDescription("test");
    }
    @And("^Выбираю бизнес юнит$")
    public void iSelectBusinessUnit() {
        new CreateExpensePage().selectBusinessUnit("Research & Development");
    }
    @And("^Select expenditure$")
    public void selectExpenditure() {
        new CreateExpensePage().selectExpenditure("01101 - ОС: вычислительная техника инфраструктуры");
    }
    @And("^Select planned date$")
    public void selectPlannedDate() {
        new CreateExpensePage().selectPlannedDate("23");
    }
    @And("^Fill sum plan$")
    public void fillSumPlan() {
        new CreateExpensePage().fillInputSumPlan("100");
    }
    @And("^Click save and close button$")
    public void clickSaveAndCloseButton() {
        new CreateExpensePage().clickSaveAndCloseButton();
    }
    @Then("^I see success message$")
    public void iSeeSuccessMessage() {
        new CreateExpensePage().successMessage.shouldBe(Condition.visible);
    }

}
