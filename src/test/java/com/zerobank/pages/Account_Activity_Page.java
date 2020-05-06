package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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

    public List<String > get_transaction_table_column_names(){
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(3);
        return BrowserUtils.getTextFromWebElements(transactions_column_names);
    }

    public void click_account(String account_value){
        BrowserUtils.waitForPageToLoad(15);
        String xpath ="(//a[text()='"+account_value+"'])[1]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();

    }

    public String get_selected_account_name(){
        BrowserUtils.waitForPageToLoad(15);
        BrowserUtils.wait(3);
        return new Select(account_types).getFirstSelectedOption().getText();
    }


    /**
     * click on Show Transactions or Find Transactions
     * @param transaction_value
     */
    public void click_transaction_tab(String transaction_value){
    BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.elementToBeClickable
                (By.xpath("//a[text()='"+transaction_value+"']"))).click();
    }

    public void enter_date(String from_date_value, String to_date_value){
        BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.elementToBeClickable(from_date)).sendKeys(from_date_value);
        wait.until(ExpectedConditions.elementToBeClickable(to_date)).sendKeys(to_date_value);
    }

    public void click_find_btn(){
        BrowserUtils.waitForPageToLoad(15);
        wait.until(ExpectedConditions.elementToBeClickable(find_btn)).click();

    }

}
