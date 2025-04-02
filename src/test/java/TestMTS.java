import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

//Необходимо написать автотесты для сайта mts.by - http://mts.by
// Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
//1. Проверить название указанного блока;
//2. Проверить наличие логотипов платёжных систем;
//3. Проверить работу ссылки «Подробнее о сервисе»;
//4. Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер для теста 297777777)

public class TestMTS {
    private WebDriver driver;
    @BeforeEach
    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
    }

    @Test
    public void testTitle() {

        WebElement title = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2"));
        Assertions.assertEquals("Онлайн пополнение\nбез комиссии", title.getText());
    }

    @Test
    public void testPaymentLogo(){
        WebElement paymentSystemsBlock = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]"));
        Assertions.assertNotNull(paymentSystemsBlock);

        WebElement visaLogo = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[1]/img"));
        WebElement visaTwoLogo = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[2]/img"));
        WebElement masterCardLogo = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[3]/img"));
        WebElement masterCardSCLogo = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[4]/img"));
        WebElement belCardLogo = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul/li[5]/img"));

        Assertions.assertNotNull(visaLogo);
        Assertions.assertNotNull(visaTwoLogo);
        Assertions.assertNotNull(masterCardLogo);
        Assertions.assertNotNull(masterCardSCLogo);
        Assertions.assertNotNull(belCardLogo);
    }

    @Test
    public void testMoreInfoLink() {
        WebElement moreInfoLink = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/a"));
        moreInfoLink.click();

        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", driver.getCurrentUrl());

        driver.navigate().back();
    }

    @Test
    public void testContinueButton() {
        WebElement serviceOption = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button"));
        serviceOption.click();
        WebElement svyz = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p"));
        svyz.click();

        WebElement phoneInput = driver.findElement(By.xpath("//*[@id=\"connection-phone\"]"));
        phoneInput.sendKeys("297777777");

        WebElement sum = driver.findElement(By.xpath("//*[@id=\"connection-sum\"]"));
        sum.sendKeys("1");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        continueButton.click();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}