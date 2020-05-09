package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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

    @FindBy(id = "np_new_payee_name")
    private WebElement payee_name_input;

    @FindBy(id = "np_new_payee_address")
    private WebElement payee_adress_input;

    @FindBy(id = "np_new_payee_account")
    private WebElement account_iput;

    @FindBy(id = "np_new_payee_details")
    private WebElement payee_details_input;

    @FindBy(css = "[value=\"Add\"]")
    private WebElement add_btn;

    @FindBy(id = "alert_content")
    private WebElement alert_msg;

    @FindBy(id = "pc_currency")
    private WebElement currency_select;

    @FindBy(id = "pc_amount")
    private WebElement amount_input;

    @FindBy(css = "[class=\"radio inline\"][style^=\"padding-bottom\"]")
    private List<WebElement> radio_buttons;

    @FindBy(id = "pc_calculate_costs")
    private WebElement calculate_cost_btn;


    @FindBy(id = "purchase_cash")
    private WebElement purchase_btn;


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

    public WebElement get_date_field() {
        return date_select;
    }


    public String get_validation_message(String where_to_get_message) {
        String id_path = "sp_" + where_to_get_message;
        return driver.findElement(By.id(id_path)).getAttribute("validationMessage");
    }

    public void select_tab(String tab_name) {
        BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/a[text()='" + tab_name + "']"))).click();

    }

    public void set_payee_name(String payee_name_value) {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(2);
        payee_name_input.sendKeys(payee_name_value);

    }

    public void set_payee_adress(String payee_address_value) {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(2);
        payee_adress_input.sendKeys(payee_address_value);

    }

    public void set_account(String account_value) {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(2);
        account_iput.sendKeys(account_value);

    }

    public void set_payee_details(String details_value) {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(2);
        payee_details_input.sendKeys(details_value, Keys.ENTER);

    }

    public void click_add_btn() {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(3);
        add_btn.click();

    }

    public String get_alert_msg() {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(3);
        return alert_msg.getText();
    }

    public List<String> get_currency_options() {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(1);
        return BrowserUtils.getTextFromWebElements(new Select(currency_select).getOptions());

    }

    public void set_amount(String amount_value) {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(1);
        amount_input.sendKeys(amount_value);
    }

    public void random_select_currency() {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(1);

        Random random = new Random();
        Select select_currency = new Select(currency_select);
        int index_of_currency = random.nextInt(select_currency.getOptions().size());
        select_currency.selectByIndex(index_of_currency);
    }

    public void random_select_radio_btn() {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(1);

        Random random = new Random();
        int index_radio_btn = random.nextInt(radio_buttons.size());
        wait.until(ExpectedConditions.elementToBeClickable(radio_buttons.get(index_radio_btn))).click();
    }

    public void click_calculate_cost() {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(1);

        wait.until(ExpectedConditions.elementToBeClickable(calculate_cost_btn)).click();
        BrowserUtils.wait(5);
    }

    public void click_purchase_btn() {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(1);

        wait.until(ExpectedConditions.elementToBeClickable(purchase_btn)).click();
        BrowserUtils.wait(5);
    }

    public String get_alert_error_msg() {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(5);

        return driver.switchTo().alert().getText();

    }


}
