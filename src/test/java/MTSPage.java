import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MTSPage {
    private static WebDriver driver;

    // Локаторы
    private final By titleLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2");
    private final By paymentSystemsBlockLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]");
    private final By visaLogo = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img");
    private final By visaTwoLogo = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[2]/img");
    private final By masterCardLogo = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]/img");
    private final By masterCardSCLogo = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]/img");
    private final By belCardLogo = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]/img");
    private final By moreInfoLinkLocator = By.xpath("//a[contains(text(), 'Подробнее о сервисе')]");
    private final By continueButtonLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button");
    private final By phoneInputLocator = By.xpath("//*[@id=\"connection-phone\"]");
    private final By sumInputLocator = By.xpath("//*[@id=\"connection-sum\"]");
    private final By serviceOptionLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p");
    private final By communicationServicesLocator = By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]");

    public MTSPage(WebDriver driver) {
        MTSPage.driver = driver;
    }

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
        System.out.println("Попытка нажать на ссылку 'More Info'.");//логирую каждый шаг т.к. тест падал
        WebElement moreInfoLink = driver.findElement(moreInfoLinkLocator);
        System.out.println("Нашли!!");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"body > a.webim-button-corner.webim_button\").style.display='none';");
        Actions actions = new Actions(driver)
                .moveToElement(moreInfoLink)
                .click();
        actions.perform();
        System.out.println(driver.getCurrentUrl());
        System.out.println("Ссылка 'More Info' успешно нажата.");//по другому не работал, мешает ИИ-помощница
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

    public void selectComServ() {
        driver.findElement(communicationServicesLocator).click();
    }
}