package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Account_Summary_Page extends BasePage{

    @FindBy (xpath = "//div/h2")
    List<WebElement>account_Types;

    @FindBy (xpath = "//h2[text()=\"Credit Accounts\"]/following-sibling::div[1]//th")
    List<WebElement> credit_accounts_columns;




    public List<String > get_account_types(){
        BrowserUtils.waitForPageToLoad(15);
        return BrowserUtils.getTextFromWebElements(account_Types);
    }

    public List<String > get_account_columns(){
        BrowserUtils.waitForPageToLoad(15);
        return BrowserUtils.getTextFromWebElements(credit_accounts_columns);
    }


}
