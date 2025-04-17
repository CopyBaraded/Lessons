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
        mtsFramePage = new MTSFramePage(driver);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement cookieAcceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")));
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
        mtsPage.enterPhoneNumber("297777777");
        mtsPage.enterSum("1");
        mtsPage.clickContinueButton();
    }


    @Test
    public void testFrameFieldSumUp() {
        mtsPage.enterPhoneNumber("297777777");
        mtsPage.enterSum("1");
        mtsPage.clickContinueButton();
        mtsFramePage.switchToFrame();

        String title = mtsFramePage.getTextSumUp();
        System.out.println("найдена сумма" + title);
        Assertions.assertEquals("1.00 BYN", title);

        mtsFramePage.switchToDefaultContent();
    }

    @Test
    public void testFrameFieldNumPhone() {
        mtsPage.enterPhoneNumber("297777777");
        mtsPage.enterSum("1");
        mtsPage.clickContinueButton();
        mtsFramePage.switchToFrame();

        String title = mtsFramePage.getPhoneNumCorrect();
        System.out.println("найден телефон" + title);
        Assertions.assertEquals("Оплата: Услуги связи Номер:375297777777", title);

        mtsFramePage.switchToDefaultContent();
    }

    @Test
    public void testFrameFieldNumCard() {
        mtsPage.enterPhoneNumber("297777777");
        mtsPage.enterSum("1");
        mtsPage.clickContinueButton();
        mtsFramePage.switchToFrame();

//        Дежурная проверка во фрейме ли я
//        Assertions.assertNotNull(mtsPage.getPaymentSystemsBlock(), "Блок платежных систем не найден.");

        String title = mtsFramePage.getTextNumCard();
        System.out.println("num card text" + title);
        Assertions.assertEquals("Номер карты", title);

        mtsFramePage.switchToDefaultContent();
    }

    @Test
    public void testFrameFieldValidityPeriod() {
        mtsPage.enterPhoneNumber("297777777");
        mtsPage.enterSum("1");
        mtsPage.clickContinueButton();
        mtsFramePage.switchToFrame();

        String title = mtsFramePage.getTextValidityPeriodCardField();
        System.out.println("Validity Period Text" + title);
        Assertions.assertEquals("Срок действия", title);

        mtsFramePage.switchToDefaultContent();
    }

    @Test
    public void testFrameFieldCardHolder() {
        mtsPage.enterPhoneNumber("297777777");
        mtsPage.enterSum("1");
        mtsPage.clickContinueButton();
        mtsFramePage.switchToFrame();

        String title = mtsFramePage.getTextCardHolderField();
        System.out.println("Card Holder" + title);
        Assertions.assertEquals("Имя держателя (как на карте)", title);

        mtsFramePage.switchToDefaultContent();
    }

    @Test
    public void testFrameFieldCVC() {
        mtsPage.enterPhoneNumber("297777777");
        mtsPage.enterSum("1");
        mtsPage.clickContinueButton();
        mtsFramePage.switchToFrame();

        String title = mtsFramePage.getTextCVCField();
        System.out.println("CVC" + title);
        Assertions.assertEquals("CVC", title);

        mtsFramePage.switchToDefaultContent();
    }

    @Test
    public void testFrameFieldSumDown() {
        mtsPage.enterPhoneNumber("297777777");
        mtsPage.enterSum("1");
        mtsPage.clickContinueButton();
        mtsFramePage.switchToFrame();
        mtsFramePage.enterNumCard("1111111111111111");
        mtsFramePage.enterValidityPeriod("03/2222");//ошибся при вводе, но для теста это не принципиально

        String title = mtsFramePage.getTextSumDown();
        System.out.println("CVC" + title);
        Assertions.assertEquals("Оплатить 1.00 BYN", title);

        mtsFramePage.switchToDefaultContent();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}