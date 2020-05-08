package com.zerobank.stepdefinitions;

import com.zerobank.pages.Account_Activity_Page;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Account_Activity_steps {

    Account_Activity_Page accountActivityPage = new Account_Activity_Page();

    @Then("user should verify that {string} is default account")
    public void user_should_verify_that_is_default_account(String account) {
        System.out.println("Default account is :" + account);
        Assert.assertEquals(account, accountActivityPage.get_default_account());
    }

    @Then("user should verify that Account drop down should have the following options")
    public void user_should_verify_that_Account_drop_down_should_have_the_following_options(List<String> dataTable) {
        System.out.println("Account types are " + dataTable);
        Assert.assertEquals(dataTable, accountActivityPage.get_account_names());
    }

    @Then("transaction table have following column names")
    public void transaction_table_have_following_column_names(List<String> dataTable) {
        System.out.println("Transaction table column names are " + dataTable);
        Assert.assertEquals(dataTable, accountActivityPage.get_transaction_table_column_names());

    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String account_value) {
        accountActivityPage.click_account(account_value);
    }


    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String account_value) {
        String actual = accountActivityPage.get_selected_account_name();
        System.out.println("Account dropbox is " + account_value);
        Assert.assertEquals(account_value, actual);

    }

    @Given("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String transaction_value) {
        accountActivityPage.click_transaction_tab(transaction_value);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String from_date, String to_date) {
        accountActivityPage.enter_date(from_date, to_date);
    }

    @When("clicks search")
    public void clicks_search() {
        accountActivityPage.click_find_btn();
        BrowserUtils.wait(2);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String from_date_value, String to_date_value) {
        List<String> check_dates = accountActivityPage.get_transaction_dates();

        for (String check_date : check_dates) {
            Assert.assertTrue(accountActivityPage.is_date_between_from_to_dates(check_date, from_date_value, to_date_value));
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

        List<WebElement> expected = accountActivityPage.sort_result_dates_desc();
        List<WebElement> actual = accountActivityPage.get_transaction_dates_we();

        Assert.assertEquals(expected, actual);

    }

    @Then("the results table should not contain transactions dated {string}")
    public void the_results_table_should_not_contain_transactions_dated(String check_date) {
        List<String> result_table_dates = accountActivityPage.get_transaction_dates();

        Assert.assertFalse(result_table_dates.contains(check_date));

    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String description_value) {
        accountActivityPage.enter_description(description_value);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String description_value) {
        List<String> description_results = accountActivityPage.get_text_description_results();
        for (String each : description_results) {
            Assert.assertTrue(each.contains(description_value));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String description_value) {
        List<String> description_results = accountActivityPage.get_text_description_results();
        for (String each : description_results) {
            Assert.assertFalse(each.contains(description_value));
        }
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String transaction_result_type) {
        if (transaction_result_type.equals("Deposit")) {

            Assert.assertTrue(accountActivityPage.get_result_deposits().size() > 0);
        } else if (transaction_result_type.equals("Withdrawal")) {

            Assert.assertTrue(accountActivityPage.get_result_withdrawal().size() > 0);
        }
    }

    @When("user selects type {string}")
    public void user_selects_type(String transaction_type) {
        accountActivityPage.select_transaction_type(transaction_type);
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String transaction_type_) {
        if(transaction_type_.equals("Deposit")){

             Assert.assertEquals(0, accountActivityPage.get_result_deposits().size());
        }
        if(transaction_type_.equals("Withdrawal")){

            Assert.assertEquals(0, accountActivityPage.get_result_withdrawal().size());
        }

    }

}


