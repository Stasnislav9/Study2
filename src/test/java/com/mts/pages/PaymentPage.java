package com.mts.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class PaymentPage extends BasePage {

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    // Сумма на странице
    @FindBy(css = ".pay-description__cost span")
    private WebElement totalAmount;

    // Кнопка оплаты
    @FindBy(css = "button.colored span")
    private WebElement payButton;

    // Номер телефона
    @FindBy(css = ".pay-description__text span")
    private WebElement descriptionText;

    // Поле "Номер карты" (ищем по ID)
    @FindBy(id = "cc-number")
    private WebElement cardNumberField;

    // НАДПИСЬ "Номер карты" — ищем label по тексту
    private By cardNumberLabel = By.xpath("//label[text()='Номер карты']");

    // Поле "Срок действия"
    @FindBy(css = "input[placeholder='MM / YY']")
    private WebElement cardExpiryField;

    // Надпись "Срок действия"
    private By cardExpiryLabel = By.xpath("//label[text()='Срок действия']");

    // Поле "CVC"
    @FindBy(css = "input[name='verification_value']")
    private WebElement cardCvcField;

    // Надпись "CVC"
    private By cardCvcLabel = By.xpath("//label[text()='CVC']");

    // Иконки платёжных систем
    @FindBy(css = ".cards-brands img")
    private List<WebElement> paymentIcons;

    public String getTotalAmount() {
        wait.until(ExpectedConditions.visibilityOf(totalAmount));
        return totalAmount.getText();
    }

    public String getPayButtonText() {
        wait.until(ExpectedConditions.visibilityOf(payButton));
        return payButton.getText();
    }

    public String getPhoneNumber() {
        wait.until(ExpectedConditions.visibilityOf(descriptionText));
        String fullText = descriptionText.getText();
        if (fullText.contains("Номер:")) {
            return fullText.substring(fullText.indexOf("Номер:") + 6).trim();
        }
        return "";
    }

    public String getCardNumberPlaceholder() {
        // Берём текст из label по XPath
        WebElement label = wait.until(ExpectedConditions.presenceOfElementLocated(cardNumberLabel));
        return label.getText();
    }

    public String getCardExpiryPlaceholder() {
        WebElement label = wait.until(ExpectedConditions.presenceOfElementLocated(cardExpiryLabel));
        return label.getText();
    }

    public String getCardCvcPlaceholder() {
        WebElement label = wait.until(ExpectedConditions.presenceOfElementLocated(cardCvcLabel));
        return label.getText();
    }

    public boolean arePaymentIconsDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(paymentIcons));
        return paymentIcons.size() >= 3;
    }
}