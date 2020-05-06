package com.zerobank.stepdefinitions;

import com.zerobank.pages.Pay_Bills_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

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

    @Then("user should verify date field is empty")
    public void user_should_verify_date_field_is_empty() {
        Assert.assertTrue(pay_bills_page.get_date_field().getText().isEmpty());

    }

}


