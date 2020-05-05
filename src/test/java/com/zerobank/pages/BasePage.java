package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    protected WebDriver driver= Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,15);




    public BasePage(){
        PageFactory.initElements(driver,this);

    }

    public String  get_page_title(){
        BrowserUtils.waitForPageToLoad(15);
        return driver.getTitle();
    }

    /**
     * method for zero bank navigation
     * provide tab name to navigate
     * @param tabName ( Account Summary , Account Activity, Transfer Funds , Pay Bills , My Money Map , Online Statements )
     */
    public void navigateTo(String tabName) {
        String xpath = "//ul/li/a[text()=\"" + tabName + "\"]";
        WebElement tab = driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.elementToBeClickable(tab)).click();
    }






}
