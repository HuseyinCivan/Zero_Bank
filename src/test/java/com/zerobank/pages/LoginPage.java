package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    @FindBy(id = "signin_button")
    private WebElement signin_btn_homePage;

    @FindBy(id = "user_login")
    private WebElement login_text_input;

    @FindBy(id = "user_password")
    private WebElement password_text_input;

    @FindBy(css = "[type=\"submit\"]")
    private WebElement sign_in_btn;

    @FindBy(id = "user_remember_me")
    private WebElement keep_me_sign_in_btn;

    @FindBy(partialLinkText = "Forgot your password ?")
    private WebElement forgot_yuor_password;

    @FindBy(id = "user_email")
    private WebElement email_forgot_password;

    @FindBy(name = "submit")
    private WebElement send_passwor_btn;

    @FindBy(css = "[class=\"alert alert-error\"]")
    private WebElement error_message;


    public void click_signin() {
        BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.elementToBeClickable(signin_btn_homePage)).click();

    }

    /**
     * login default user
     * credentials will be retrived from configuration.properties file
     */
    public void login() {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(2);
        login_text_input.sendKeys(ConfigurationReader.getProperty("username"));

        BrowserUtils.wait(2);

        password_text_input.sendKeys(ConfigurationReader.getProperty("password"));

        BrowserUtils.wait(2);

        wait.until(ExpectedConditions.elementToBeClickable(keep_me_sign_in_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(sign_in_btn)).click();

    }

    /**
     * method to login with parameters
     *
     * @param username
     * @param password
     */
    public void login(String username, String password) {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(3);

        login_text_input.sendKeys(username);

        BrowserUtils.wait(3);

        password_text_input.sendKeys(password);

        BrowserUtils.wait(3);

        wait.until(ExpectedConditions.elementToBeClickable(keep_me_sign_in_btn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(sign_in_btn)).click();

    }

    public String get_error_msg() {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(2);
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[class=\"alert alert-error\"]")))
                .getText().trim();

    }




}
