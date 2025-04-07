import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestMTS {
    private WebDriver driver;
    private MTSPage mtsPage;
    private  MTSFramePage mtsFramePage;

    @BeforeEach
    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.mts.by/");
        mtsPage = new MTSPage(driver);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement cookieAcceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cookie-agree\"]")));
            cookieAcceptButton.click();
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Кнопка принятия Cookies не найдена или неактивна.");
        }

    }

    @Test
    public void testTitle() {
        String title = mtsPage.getTitleText();
        Assertions.assertEquals("Онлайн пополнение\nбез комиссии", title);
    }

    @Test
    public void testPaymentLogo() {
        Assertions.assertNotNull(mtsPage.getPaymentSystemsBlock(), "Блок платежных систем не найден.");
        Assertions.assertNotNull(mtsPage.getVisaLogo(), "Visa");
        Assertions.assertNotNull(mtsPage.getVisaTwoLogo(), "Verified By Visa");
        Assertions.assertNotNull(mtsPage.getMasterCardLogo(), "MasterCaard");
        Assertions.assertNotNull(mtsPage.getMasterCardSCLogo(), "MasterCard Secure Code");
        Assertions.assertNotNull(mtsPage.getBelCardLogo(), "BelCardLogo");
    }

    @Test
    public void testMoreInfoLink() {
        mtsPage.clickMoreInfoLink();
        Assertions.assertEquals("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/", mtsPage.getCurrentUrl());

    }



    @Test
    public void testContinueButton() {
        mtsPage.clickContinueButton();
        mtsPage.selectServiceOption();
        mtsPage.enterPhoneNumber("297777777");
        mtsPage.enterSum("1");
        mtsPage.clickContinueButton();
    }

    @Test
    public void testFrameFieldInteraction() {
        mtsFramePage.switchToFrame();


        mtsFramePage.enterText("Тестовые данные");
        mtsFramePage.clickSubmitButton();


        // Добавить сюда свои проверки

        // Возвращение к основному содержимому
        mtsFramePage.switchToDefaultContent();
    }


    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}