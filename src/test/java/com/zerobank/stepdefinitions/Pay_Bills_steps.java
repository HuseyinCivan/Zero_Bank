package com.zerobank.stepdefinitions;

import com.zerobank.pages.Pay_Bills_Page;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;

import java.util.List;
import java.util.Map;

public class Pay_Bills_steps {
    Pay_Bills_Page pay_bills_page = new Pay_Bills_Page();

    @Then("user select a random payee")
    public void user_select_a_random_payee() {
        pay_bills_page.select_payee_randomly();
    }

    @Then("user select a random account")
    public void user_select_a_random_account() {
        pay_bills_page.select_account_randomly();
    }

    @Then("user enters {string} as amount")
    public void user_enters_as_amount(String amount_value) {
        pay_bills_page.enter_amount(amount_value);
    }

    @Then("user select today's date")
    public void user_select_today_s_date() {
        pay_bills_page.enter_todays_date();
    }

    @Then("user enter {string} to description")
    public void user_enter_to_description(String description_value) {
        pay_bills_page.enter_description(description_value);
    }

    @Then("user click the pay button")
    public void user_click_the_pay_button() {
        pay_bills_page.click_pay_btn();
    }

    @Then("user should verify {string} message is displayed")
    public void user_should_verify_message_is_displayed(String expected) {
        String actual = pay_bills_page.get_paymet_succesfully_result();
        Assert.assertEquals(expected, actual);

    }

    @Given("user select {string} as date")
    public void user_select_as_date(String string) {
        pay_bills_page.enter_date(string);

    }

    @Then("user should verify {string} pop up message is displayed where amount is {string} date is {string}")
    public void user_should_verify_pop_up_message_is_displayed_where_amount_is_date_is(String expected, String amount_value, String date_value) {
        String actual;
        if (amount_value.equals("")) {
            actual = pay_bills_page.get_validation_message("amount");
        } else {
            actual = pay_bills_page.get_validation_message("date");
        }
        Assert.assertEquals(expected, actual);
    }


    @Then("user should verify date field is empty")
    public void user_should_verify_date_field_is_empty() {
        Assert.assertTrue(pay_bills_page.get_date_field().getText().isEmpty());

    }

    @Given("user clicks on the {string} tab")
    public void user_clicks_on_the_tab(String tab_value) {
        pay_bills_page.select_tab(tab_value);
    }

    @Given("creates new payee using following information payee Name")
    public void creates_new_payee_using_following_information_payee_Name(Map<String, String> dataTable) {
        //  System.out.println(dataTable);

        /*
        List<Map<String ,String >> dataTable
        [{Payee Name=Payee Address, The Law Offices of Hyde, Price & Scharks=100 Same st, Anytown, USA, 10001}, {Payee Name=Account, The Law Offices of Hyde, Price & Scharks=Checking}, {Payee Name=Payee details, The Law Offices of Hyde, Price & Scharks=XYZ account}]
         */

        /*
        Map<String,String> dataTable
        {Payee Name=The Law Offices of Hyde, Price & Scharks, Payee Address=100 Same st, Anytown, USA, 10001, Account=Checking, Payee details=XYZ account}
         */

        pay_bills_page.set_payee_name(dataTable.get("Payee Name"));
        pay_bills_page.set_payee_adress(dataTable.get("Payee Address"));
        pay_bills_page.set_account(dataTable.get("Account"));
        pay_bills_page.set_payee_details(dataTable.get("Payee details"));

    }


    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String alert_msg_value) {

        String actual = pay_bills_page.get_alert_msg();
        Assert.assertEquals(alert_msg_value, actual);
    }

    @Then("following currencies should be available under Currency dropdown")
    public void following_currencies_should_be_available_under_Currenct_dropdown(List<String> dataTable) {
        System.out.println("All currencies under currency drop down menu ::: ");
        for (String currency : dataTable) {
            System.out.println(currency);
            Assert.assertTrue(pay_bills_page.get_currency_options().contains(currency));
        }
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        pay_bills_page.enter_amount("99.99");
        pay_bills_page.random_select_radio_btn();
        pay_bills_page.click_calculate_cost();

    }


    @Then("error message {string} should be displayed")
    public void error_message_should_be_displayed(String alert_msg_value) {
        String actual = pay_bills_page.get_alert_error_msg();
        Assert.assertEquals(alert_msg_value, actual);
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        pay_bills_page.random_select_currency();
        pay_bills_page.random_select_radio_btn();
        pay_bills_page.click_calculate_cost();
    }


}


