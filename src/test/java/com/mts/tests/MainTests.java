package com.mts.tests;

import com.mts.pages.HomePage;
import com.mts.pages.PaymentPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class MainTests extends BaseTest {
    private HomePage homePage;

    @BeforeEach
    public void initPage() {
        homePage = new HomePage(driver);
    }

    @Test
    public void testBlockTitle() {
        String title = homePage.getBlockTitle();
        assertTrue(title.contains("Онлайн пополнение") || title.contains("без комиссии"));
    }

    @Test
    public void testPaymentLogos() {
        int logosCount = homePage.getPaymentLogosCount();
        assertTrue(logosCount > 0, "Логотипы не найдены");
    }

    @Test
    public void testMoreDetails() {
        homePage.clickMoreDetailsLink();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean urlChanged = wait.until(ExpectedConditions.urlContains("help"));
        assertTrue(urlChanged, "Переход на страницу help не произошел");
    }

    @Test
    public void testAllTabsPlaceholders() {
        homePage.selectServiceTab();
        assertEquals("Номер телефона", homePage.getServicePhonePlaceholder());
        assertEquals("Сумма", homePage.getServiceSumPlaceholder());
        assertEquals("E-mail для отправки чека", homePage.getServiceEmailPlaceholder());

        homePage.selectInternetTab();
        assertEquals("Номер абонента", homePage.getInternetPhonePlaceholder());
        assertEquals("Сумма", homePage.getInternetSumPlaceholder());
        assertEquals("E-mail для отправки чека", homePage.getInternetEmailPlaceholder());

        homePage.selectCreditTab();
        assertEquals("Номер счета на 44", homePage.getCreditScorePlaceholder());
        assertEquals("Сумма", homePage.getCreditSumPlaceholder());
        assertEquals("E-mail для отправки чека", homePage.getCreditEmailPlaceholder());

        homePage.selectDebtTab();
        assertEquals("Номер счета на 2073", homePage.getDebtScorePlaceholder());
        assertEquals("Сумма", homePage.getDebtSumPlaceholder());
        assertEquals("E-mail для отправки чека", homePage.getDebtEmailPlaceholder());
    }

    @Test
    public void testFormFilling() {
        homePage.selectServiceTab();
        homePage.fillPhoneNumber("297777777");
        homePage.fillSum("10");
        assertTrue(homePage.isContinueButtonEnabled(), "Кнопка не активна");
        homePage.clickContinueButton();
    }

    @Test
    public void testServicePaymentForm() {
        homePage.selectServiceTab();
        homePage.fillPhoneNumber("297777777");
        homePage.fillSum("10.50");
        homePage.clickContinueButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Ждём появления iframe
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("iframe")));

        // Ждём, пока iframe загрузится
        boolean iframeLoaded = false;
        int attempts = 0;

        while (!iframeLoaded && attempts < 10) {
            List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

            if (iframes.size() > 1) {
                String src = iframes.get(1).getAttribute("src");
                if (src != null && !src.equals("about:blank") && src.contains("bepaid")) {
                    driver.switchTo().frame(1);
                    iframeLoaded = true;
                    break;
                }
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            attempts++;
        }

        if (!iframeLoaded) {
            throw new RuntimeException("Iframe с оплатой не загрузился");
        }

        // Ждём загрузки внутри iframe
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pay-description__cost span")));

        PaymentPage paymentPage = new PaymentPage(driver);

        assertTrue(paymentPage.getTotalAmount().contains("10.50"));
        assertTrue(paymentPage.getPayButtonText().contains("10.50"));
        assertTrue(paymentPage.getPhoneNumber().contains("297777777"));

        assertEquals("Номер карты", paymentPage.getCardNumberPlaceholder());
        assertEquals("Срок действия", paymentPage.getCardExpiryPlaceholder());
        assertEquals("CVC", paymentPage.getCardCvcPlaceholder());

        assertTrue(paymentPage.arePaymentIconsDisplayed());
    }
}