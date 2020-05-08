package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import java.util.List;

public class Account_Activity_Page extends BasePage {

    @FindBy(css = "[name=\"accountId\"]")
    private WebElement account_types;

    @FindBy(xpath = "//tr/th")
    private List<WebElement> transactions_column_names;


    @FindBy(id = "aa_fromDate")
    private WebElement from_date;

    @FindBy(id = "aa_toDate")
    private WebElement to_date;

    @FindBy(css = "[type=\"submit\"]")
    private WebElement find_btn;

    @FindBy(xpath = "//div[@id=\"filtered_transactions_for_account\"]//tbody/tr/td[1]")
    private List<WebElement> transaction_dates;

    @FindBy(id = "aa_description")
    private WebElement description_input;

    @FindBy(xpath = "//div[@id=\"filtered_transactions_for_account\"]//tbody/tr/td[2]")
    private List<WebElement> description_result;

    @FindBy(xpath = "//div[@id=\"filtered_transactions_for_account\"]//tbody/tr/td[3]")
    private List<WebElement> result_deposits;

    @FindBy(xpath = "//div[@id=\"filtered_transactions_for_account\"]//tbody/tr/td[4]")
    private List<WebElement> result_withdrawal;

    @FindBy(id = "aa_type")
    private WebElement type_select;


    public String get_default_account() {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(3);
        return new Select(account_types).getFirstSelectedOption().getText();
    }

    public List<String> get_account_names() {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(3);
        return BrowserUtils.getTextFromWebElements(new Select(account_types).getOptions());
    }

    public List<String> get_transaction_table_column_names() {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(3);
        return BrowserUtils.getTextFromWebElements(transactions_column_names);
    }

    public void click_account(String account_value) {
        BrowserUtils.waitForPageToLoad(15);
        String xpath = "(//a[text()='" + account_value + "'])[1]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();

    }

    public String get_selected_account_name() {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(3);
        return new Select(account_types).getFirstSelectedOption().getText();
    }

    /**
     * click on Show Transactions or Find Transactions
     *
     * @param transaction_value
     */
    public void click_transaction_tab(String transaction_value) {
        BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//a[text()='" + transaction_value + "']"))).click();
    }

    public void enter_date(String from_date_value, String to_date_value) {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(3);
        from_date.clear();
        BrowserUtils.wait(2);
        from_date.sendKeys(from_date_value);
        BrowserUtils.wait(3);
        to_date.clear();
        BrowserUtils.wait(2);
        to_date.sendKeys(to_date_value, Keys.ENTER);
        BrowserUtils.wait(3);
    }

    public void click_find_btn() {
        BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.elementToBeClickable(find_btn)).click();

    }

    public boolean is_date_between_from_to_dates
            (String check_date_value, String from_date_value, String to_date_value) {
        boolean is_between = false;
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date from_date = date.parse(from_date_value);
            Date to_date = date.parse(to_date_value);
            Date check_date = date.parse(check_date_value);
            is_between = check_date.compareTo(from_date) >= 0 && check_date.compareTo(to_date) <= 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return is_between;

    }

    public List<String> get_transaction_dates() {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(2);
        return BrowserUtils.getTextFromWebElements(transaction_dates);
    }

    public List<WebElement> get_transaction_dates_we() {
        return transaction_dates;
    }

    public List<WebElement> sort_result_dates_desc() {
        Collections.reverse(transaction_dates);
        return transaction_dates;


    }

    public void enter_description(String description_value) {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(2);
        description_input.clear();
        BrowserUtils.wait(1);
        description_input.sendKeys(description_value);
        BrowserUtils.wait(2);
    }

    public List<String> get_text_description_results() {
        BrowserUtils.wait(3);
        return BrowserUtils.getTextFromWebElements(description_result);

    }

    public List<String> get_result_deposits() {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(2);
        return BrowserUtils.getTextFromWebElements(result_deposits);
    }

    public List<String> get_result_withdrawal() {
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(2);
        return BrowserUtils.getTextFromWebElements(result_withdrawal);
    }

        public void select_transaction_type(String type){
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(4);
        Select select = new Select(type_select);
        select.selectByVisibleText(type);
    }



}
