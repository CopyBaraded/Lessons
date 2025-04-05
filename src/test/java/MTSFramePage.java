import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MTSFramePage {
    private WebDriver driver;

    // Локаторы
    private By iframeLocator = By.xpath("/html/body/div[9]/div/iframe");
    private By inputFieldLocator = By.id("field-id");
    private By submitButtonLocator = By.id("submit-id");

    public MTSFramePage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToFrame() {
        WebElement iframe = driver.findElement(iframeLocator);
        driver.switchTo().frame(iframe);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void enterText(String text) {
        driver.findElement(inputFieldLocator).sendKeys(text);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButtonLocator).click();
    }

}
