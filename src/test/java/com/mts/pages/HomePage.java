package com.mts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.select__header")
    private WebElement tabHeader;

    @FindBy(css = "li.select__item")
    private List<WebElement> tabItems;

    @FindBy(id = "connection-phone")
    private WebElement servicePhoneField;

    @FindBy(id = "connection-sum")
    private WebElement serviceSumField;

    @FindBy(id = "connection-email")
    private WebElement serviceEmailField;

    @FindBy(id = "internet-phone")
    private WebElement internetPhoneField;

    @FindBy(id = "internet-sum")
    private WebElement internetSumField;

    @FindBy(id = "internet-email")
    private WebElement internetEmailField;

    @FindBy(id = "score-instalment")
    private WebElement creditScoreField;

    @FindBy(id = "instalment-sum")
    private WebElement creditSumField;

    @FindBy(id = "instalment-email")
    private WebElement creditEmailField;

    @FindBy(id = "score-arrears")
    private WebElement debtScoreField;

    @FindBy(id = "arrears-sum")
    private WebElement debtSumField;

    @FindBy(id = "arrears-email")
    private WebElement debtEmailField;

    @FindBy(css = ".pay__wrapper h2")
    private WebElement blockTitle;

    @FindBy(xpath = "//img[contains(@src, '/pay/')]")
    private List<WebElement> paymentLogos;

    @FindBy(css = "a[href*='poryadok-oplaty']")
    private WebElement moreDetailsLink;

    @FindBy(xpath = "//button[text()='Продолжить']")
    private WebElement continueButton;

    public void selectTabByText(String tabText) {
        waitForElementToBeClickable(tabHeader);
        tabHeader.click();

        for (WebElement item : tabItems) {
            if (item.getText().equals(tabText)) {
                waitForElementToBeClickable(item);
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
                item.click();
                break;
            }
        }
    }

    public void selectServiceTab() {
        selectTabByText("Услуги связи");
    }

    public void selectInternetTab() {
        selectTabByText("Домашний интернет");
    }

    public void selectCreditTab() {
        selectTabByText("Рассрочка");
    }

    public void selectDebtTab() {
        selectTabByText("Задолженность");
    }

    public String getServicePhonePlaceholder() {
        waitForElementToBeVisible(servicePhoneField);
        return servicePhoneField.getAttribute("placeholder");
    }

    public String getServiceSumPlaceholder() {
        waitForElementToBeVisible(serviceSumField);
        return serviceSumField.getAttribute("placeholder");
    }

    public String getServiceEmailPlaceholder() {
        waitForElementToBeVisible(serviceEmailField);
        return serviceEmailField.getAttribute("placeholder");
    }

    public String getInternetPhonePlaceholder() {
        waitForElementToBeVisible(internetPhoneField);
        return internetPhoneField.getAttribute("placeholder");
    }

    public String getInternetSumPlaceholder() {
        waitForElementToBeVisible(internetSumField);
        return internetSumField.getAttribute("placeholder");
    }

    public String getInternetEmailPlaceholder() {
        waitForElementToBeVisible(internetEmailField);
        return internetEmailField.getAttribute("placeholder");
    }

    public String getCreditScorePlaceholder() {
        waitForElementToBeVisible(creditScoreField);
        return creditScoreField.getAttribute("placeholder");
    }

    public String getCreditSumPlaceholder() {
        waitForElementToBeVisible(creditSumField);
        return creditSumField.getAttribute("placeholder");
    }

    public String getCreditEmailPlaceholder() {
        waitForElementToBeVisible(creditEmailField);
        return creditEmailField.getAttribute("placeholder");
    }

    public String getDebtScorePlaceholder() {
        waitForElementToBeVisible(debtScoreField);
        return debtScoreField.getAttribute("placeholder");
    }

    public String getDebtSumPlaceholder() {
        waitForElementToBeVisible(debtSumField);
        return debtSumField.getAttribute("placeholder");
    }

    public String getDebtEmailPlaceholder() {
        waitForElementToBeVisible(debtEmailField);
        return debtEmailField.getAttribute("placeholder");
    }

    public void fillPhoneNumber(String phone) {
        waitForElementToBeVisible(servicePhoneField);
        servicePhoneField.clear();
        servicePhoneField.sendKeys(phone);
    }

    public void fillSum(String sum) {
        waitForElementToBeVisible(serviceSumField);
        serviceSumField.clear();
        serviceSumField.sendKeys(sum);
    }

    public void clickContinueButton() {
        waitForElementToBeClickable(continueButton);
        continueButton.click();
    }

    public boolean isContinueButtonEnabled() {
        waitForElementToBeVisible(continueButton);
        return continueButton.isEnabled();
    }

    public String getBlockTitle() {
        waitForElementToBeVisible(blockTitle);
        return blockTitle.getText().replace("\n", " ").trim();
    }

    public int getPaymentLogosCount() {
        waitForElementToBeVisible(paymentLogos.get(0));
        return paymentLogos.size();
    }

    public void clickMoreDetailsLink() {
        waitForElementToBeClickable(moreDetailsLink);
        moreDetailsLink.click();
    }
}