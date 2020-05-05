package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Account_Activity_Page extends BasePage {

    @FindBy(css = "[name=\"accountId\"]")
    private WebElement account_types;

    @FindBy(xpath = "//tr/th")
    private List<WebElement> transactions_column_names;



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


}
