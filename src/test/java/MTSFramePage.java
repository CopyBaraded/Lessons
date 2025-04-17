import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class MTSFramePage {
    private final WebDriver driver;

    // Локаторы

    private By sumUpLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/div[1]");
    private By sumDownLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button");
    private By phoneNumCorrectLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]");
    private By numCardInFieldLocator = By.xpath("//*[@id=\"cc-number\"]");
    private By validityPeriodInCardFieldLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/input");
    private By numCardToFieldLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]");
    private By validityPeriodToCardFieldLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div");
    private By cvcFieldLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div");
    private By cardHolderFieldLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div");


    public MTSFramePage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame() {
        WebElement frameElement = driver.findElement(By.className("bepaid-iframe"));
        driver.switchTo().frame(frameElement);
        System.out.println("Текущий URL во фрейме: " + driver.getCurrentUrl());
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


//    public @Nullable String getMtsFramePage() {
//        return driver.getCurrentUrl();
//    }
//
//    public void setMtsFramePage(By mtsFramePage) {
//        this.mtsFramePage = mtsFramePage;
//    }

//    public void enterText(String text) {
//        driver.findElement(inputFieldLocator).sendKeys(text);
//    }
//
//    public void clickSubmitButton() {
//        driver.findElement(submitButtonLocator).click();
//    }

}