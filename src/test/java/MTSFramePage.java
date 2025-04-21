import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MTSFramePage {
    private final WebDriver driver;

    // Локаторы

    private By sumUpLocator = By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > div > div.pay-description__actions > div.pay-description__cost");//html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/div[1]
    private By sumDownLocator = By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > app-card-page > div > div.card-page__card > button");

    private By phoneNumCorrectLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]");
    private By numCardInFieldLocator = By.xpath("//*[@id=\"cc-number\"]");
    private By validityPeriodInCardFieldLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/input");
    private By numCardToFieldLocator = By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c891095944-0 > div:nth-child(1) > app-input > div > div > div.content.ng-tns-c2312288139-1");
    private By validityPeriodToCardFieldLocator = By.cssSelector("body > app-root > div > div > div > app-payment-container > section > div > app-card-page > div > div.card-page__card > app-card-input > form > div.card.ng-tns-c891095944-0 > div:nth-child(2) > div.expires-input.ng-tns-c891095944-0.ng-star-inserted > app-input > div > div > div.content.ng-tns-c2312288139-4 > label");
    private By cvcFieldLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div");
    private By cardHolderFieldLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div");


    public MTSFramePage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame() {

        WebElement frameElement = driver.findElement(By.className("bepaid-iframe"));
        driver.switchTo().frame(frameElement);
        System.out.println("Текущий URL во фрейме: " + driver.getCurrentUrl());

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("card-page__container")));
            System.out.println(".card-page__container loadd.");
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println(".card-page__container not loaded");
        }
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
        System.out.println("Вернулись к основному содержимому.");
    }

    public String getTextSumUp() {
        return driver.findElement(sumUpLocator).getText();
    }

    public String getPhoneNumCorrect() {
        return driver.findElement(phoneNumCorrectLocator).getText();
    }

    public String getTextNumCard() {
        return driver.findElement(numCardToFieldLocator).getText();
    }

    public String getTextValidityPeriodCardField () {
        return driver.findElement(validityPeriodToCardFieldLocator).getText();
    }

    public String getTextCardHolderField () {
        return driver.findElement(cardHolderFieldLocator).getText();
    }

    public String getTextCVCField () {
        return driver.findElement(cvcFieldLocator).getText();
    }

    public String getTextSumDown() {
        return driver.findElement(sumDownLocator).getText();
    }

    public void enterNumCard(String num) {
        driver.findElement(numCardInFieldLocator).sendKeys(num);
    }

    public void enterValidityPeriod(String date) {
        driver.findElement(validityPeriodInCardFieldLocator).sendKeys(date);
    }
}