package com.mts.tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class MainTests extends BaseTest {

    @Test
    public void testBlockTitle() {
        // Ищем заголовок внутри блока с оплатой (по классу pay__wrapper)
        String titleText = driver.findElement(By.cssSelector(".pay__wrapper h2")).getText();
        titleText = titleText.replace("\n", " ").trim();
        System.out.println("Заголовок: '" + titleText + "'");

        assertTrue(titleText.contains("Онлайн пополнение") ||
                titleText.contains("без комиссии"));
    }

    @Test
    public void testPaymentLogos() {
        int logosCount = driver.findElements(
                By.xpath("//img[contains(@src, '/pay/')]")
        ).size();

        assertTrue(logosCount > 0, "Логотипы не найдены");
        System.out.println("Найдено логотипов: " + logosCount);
    }

    @Test
    public void testMoreDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("a[href*='poryadok-oplaty']")
        )).click();

        boolean urlChanged = wait.until(ExpectedConditions.urlContains("help"));
        assertTrue(urlChanged, "Переход на страницу help не произошел");
        System.out.println("Переход выполнен: " + driver.getCurrentUrl());
    }

    @Test
    public void testFormFilling() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("connection-phone")))
                .sendKeys("297777777");

        driver.findElement(By.id("connection-sum")).sendKeys("10");

        WebElement continueButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Продолжить']"))
        );

        assertTrue(continueButton.isEnabled(), "Кнопка не активна");
        continueButton.click();

        System.out.println("Форма отправлена");
    }
}