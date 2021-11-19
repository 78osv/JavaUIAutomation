Feature: create expense request

  Background:
    Given I am authorized

    Scenario:
      Given Я I see success messageперехожу с помощью интерфейса на страницу создания заявки на расход
      When Я заполняю имя заявки
      And Выбираю бизнес юнит
      And Select expenditure
      And Select planned date
      And Fill sum plan
      And Click save and close button
      Then I see success message