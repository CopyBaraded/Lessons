import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MTSFramePage {
    private final WebDriver driver;

    // Локаторы

//    private By inputFieldLocator = By.linkText("Номер карты");
//    private By submitButtonLocator = By.id("submit-id");
    private By sumUpLocator = By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/div[1]/span");

    public MTSFramePage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame() {
        driver.switchTo().frame(1);
        System.out.println("Текущий URL во фрейме: " + driver.getCurrentUrl());
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
        System.out.println("Вернулись к основному содержимому.");
    }

    public String getSumUp() {
        return driver.findElement(sumUpLocator).getText();
    }


//    public By getMtsFramePage() {
//        return mtsFramePage;
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