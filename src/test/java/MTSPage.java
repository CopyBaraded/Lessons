import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MTSPage {
    private WebDriver driver;

    // Локаторы
    private By titleLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2");
    private By paymentSystemsBlockLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]");
    private By visaLogo = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img");
    private By visaTwoLogo = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[2]/img");
    private By masterCardLogo = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]/img");
    private By masterCardSCLogo = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]/img");
    private By belCardLogo = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]/img");
    private By moreInfoLinkLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a");
    private By continueButtonLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button");
    private By phoneInputLocator = By.xpath("//*[@id=\"connection-phone\"]");
    private By sumInputLocator = By.xpath("//*[@id=\"connection-sum\"]");
    private By serviceOptionLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p");

    public MTSPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы взаимодействия
    public String getTitleText() {
        return driver.findElement(titleLocator).getText();
    }

    public WebElement getPaymentSystemsBlock() {
        return driver.findElement(paymentSystemsBlockLocator);
    }

    public WebElement getVisaLogo(){
        return  driver.findElement(visaLogo);
    }

    public WebElement getVisaTwoLogo(){
        return  driver.findElement(visaTwoLogo);
    }

    public WebElement getMasterCardLogo(){
        return  driver.findElement(masterCardLogo);
    }

    public WebElement getMasterCardSCLogo(){
        return  driver.findElement(masterCardSCLogo);
    }

    public WebElement getBelCardLogo(){
        return  driver.findElement(belCardLogo);
    }

    public void clickMoreInfoLink() {
        System.out.println("Попытка нажать на ссылку 'More Info'.");
        driver.findElement(moreInfoLinkLocator).click();
        System.out.println("Ссылка 'More Info' успешно нажата.");

    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void clickContinueButton() {
        driver.findElement(continueButtonLocator).click();
    }

    public void enterPhoneNumber(String phone) {
        driver.findElement(phoneInputLocator).sendKeys(phone);
    }

    public void enterSum(String sum) {
        driver.findElement(sumInputLocator).sendKeys(sum);
    }

    public void selectServiceOption() {
        driver.findElement(serviceOptionLocator).click();
    }
}