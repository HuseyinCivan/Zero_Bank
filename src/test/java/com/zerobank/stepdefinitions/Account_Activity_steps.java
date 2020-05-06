package com.zerobank.stepdefinitions;

import com.zerobank.pages.Account_Activity_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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
    }

}
