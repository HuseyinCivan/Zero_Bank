package com.zerobank.stepdefinitions;

import com.zerobank.pages.Account_Activity_Page;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class Account_Activity_steps {

    Account_Activity_Page accountActivityPage = new Account_Activity_Page();

    @Then("user should verify that {string} is default account")
    public void user_should_verify_that_is_default_account(String account) {
        System.out.println("Default account is :"+account);
        Assert.assertEquals(account,accountActivityPage.get_default_account());
    }

    @Then("user should verify that Account drop down should have the following options")
    public void user_should_verify_that_Account_drop_down_should_have_the_following_options(List<String> dataTable) {
        System.out.println("Account types are "+dataTable);
        Assert.assertEquals(dataTable,accountActivityPage.get_account_names());
    }

    @Then("transaction table have following column names")
    public void transaction_table_have_following_column_names(List<String > dataTable) {
        System.out.println("Transaction table column names are "+dataTable);
        Assert.assertEquals(dataTable,accountActivityPage.get_transaction_table_column_names());

    }

}
