package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class login_steps {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        System.out.println("Open login page");
        String URL = ConfigurationReader.getProperty("URL");
        System.out.println("URL :: " + URL);
        Driver.getDriver().get(URL);

    }

    @When("user clicks on signin button to access login page")
    public void user_clicks_on_signin_button_to_access_login_page() {
        loginPage.click_signin();
    }

    @When("user enters valid username and password on loginpage")
    public void user_enters_valid_username_and_password_on_loginpage() {
        System.out.println("Login with user name = "+ConfigurationReader.getProperty("username")+" password = "+ConfigurationReader.getProperty("password"));
        loginPage.login();
    }


    @Then("user should verify that {string} is displayed as title")
    public void user_should_verify_that_is_displayed_as_title(String page_title) {
        System.out.println("Verify that page title is " + page_title);
        String actual = loginPage.get_page_title();
        Assert.assertEquals(page_title,actual);

    }

    @When("user enters invalid {string} and {string} on loginpage")
    public void user_enters_invalid_and_on_loginpage(String username, String password) {
        System.out.printf("Login with user name \"%s\" and \"%s\" password\n", username, password);
        loginPage.login(username,password);
    }

    @Then("error message {string} is displayed")
    public void error_message_is_displayed(String error_msg) {

        System.out.printf("Verify that error message \"%s\" is displayed\n",error_msg);
        Assert.assertEquals(loginPage.get_error_msg(),error_msg);
    }


}

