package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Pay_Bills_Page extends BasePage {

    @FindBy(id = "sp_payee")
    private WebElement payee_select;

    @FindBy(id = "sp_account")
    private WebElement account_select;

    @FindBy(id = "sp_amount")
    private WebElement amount;

    @FindBy(id = "sp_date")
    private WebElement date_select;

    @FindBy(id = "sp_description")
    private WebElement description;

    @FindBy(id = "pay_saved_payees")
    private WebElement payBtn;

    @FindBy(xpath = "//*[text()=\"The payment was successfully submitted.\"]")
    private WebElement payment_successfully_message;


    public void select_payee_randomly() {
        BrowserUtils.waitForPageToLoad(15);

        Random random = new Random();
        Select select = new Select(payee_select);
        int index = random.nextInt(select.getOptions().size());

        select.selectByIndex(index);

    }

    public void select_account_randomly() {
        BrowserUtils.waitForPageToLoad(15);

        Random random = new Random();
        Select select = new Select(account_select);
        int index = random.nextInt(select.getOptions().size());

        select.selectByIndex(index);

    }

    public void enter_amount(String amount_value) {
        BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.elementToBeClickable(amount)).sendKeys(amount_value);
    }

    public void enter_todays_date() {
        BrowserUtils.waitForPageToLoad(15);

        date_select.sendKeys(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

    }

    public void enter_date(String date_value) {
        BrowserUtils.waitForPageToLoad(15);
        date_select.sendKeys(date_value);
    }

    public void enter_description(String description_value) {
        BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.elementToBeClickable(description)).sendKeys(description_value);
    }


    public void click_pay_btn() {
        BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.elementToBeClickable(payBtn)).click();

    }

    public String get_paymet_succesfully_result() {
        BrowserUtils.waitForPageToLoad(15);
        return wait.until(ExpectedConditions.presenceOfElementLocated
                (By.xpath("//*[text()=\"The payment was successfully submitted.\"]"))).getText();
    }
    public WebElement get_date_field(){
        return date_select;
    }


}
