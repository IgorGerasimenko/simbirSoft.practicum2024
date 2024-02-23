# Клиентские тесты

Tags: CustomersTest
Meta: key1 = CustomersTest

## Создание

* Создание клиента (Add Customer)
    * Сгенерировать случайный postCode из 10 символов
    * Сгенерировать FirstName на основе postCode использую Генератор
    * Открыть страницу https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/addCust
    * В поле First Name ввести сгенерированный FirstName
    * В поле Last Name ввести "Fisher"
    * Нажать кнопку AddCustomer
    * Закрыть уведомление об успешном добавлении Customer
    * Нажать кнопку Customers
    * Проверить, что в таблице Customers присутствует добавленный пользователь

## Сортироовка

* Сортировка клиентов по имени (First Name)
    * Открыть страницу https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list
    * В таблице Customers нажать кнопку сортировки по First Name
    * Проверить, что все имена First Name отсортированы в порядке убывания

## Удаление

* Удаление клиента
    * Открыть страницу https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list
    * Вычислить среднее арифметическое всех First Name: посчитать кол-во символов всех First Name и разделить на кол-во
      First Name
    * Вычислить First Name длина которого ближе всего к среднему арифметическому длин First Name
    * Нажать кнопку Delete у Customerа First Name которого ближе всего к среднему арифметическому длин First Name
    * Проверить что запись Customera отсутствует в таблице 