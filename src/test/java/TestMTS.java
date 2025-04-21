import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestMTS {
    private WebDriver driver;
    private MTSPage mtsPage;
    private MTSFramePage mtsFramePage;

    @BeforeEach
    public void init() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        mtsPage = new MTSPage(driver);
        mtsFramePage = new MTSFramePage(driver);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement loaddElmnt = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cookie-agree")));
            System.out.println("cookie-agree loadd.");
            if (loaddElmnt.isDisplayed() && loaddElmnt.isEnabled()) {
                loaddElmnt.click();
                System.out.println("cookie-agree clickd.");
            }
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("Кнопка принятия Cookies не найдена или неактивна.");
        }

    }

    @DisplayName("Онлайн пополнение")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void testTitle() {
        Assertions.assertDoesNotThrow(() -> {
            String title = mtsPage.getTitleText();
            Assertions.assertEquals("Онлайн пополнение\nбез комиссии", title);
        });
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
        try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
        System.out.println("bepaid-iframe loadd.");
    } catch (TimeoutException | NoSuchElementException e) {
        System.out.println("bepaid-iframe not loaded");
    }
        mtsFramePage.switchToFrame();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
            System.out.println("bepaid-iframe loadd.");
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("bepaid-iframe not loaded");
        }
        mtsFramePage.switchToFrame();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
            System.out.println("bepaid-iframe loadd.");
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("bepaid-iframe not loaded");
        }
        mtsFramePage.switchToFrame();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
            System.out.println("bepaid-iframe loadd.");
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("bepaid-iframe not loaded");
        }
        mtsFramePage.switchToFrame();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String title = mtsFramePage.getTextValidityPeriodCardField();
        System.out.println("Validity Period Text" + title);
        Assertions.assertEquals("Срок действия", title);

        mtsFramePage.switchToDefaultContent();
    }

    @Issue("123")
    @Test
    public void testFrameFieldCardHolder() {
        mtsPage.enterPhoneNumber("297777777");
        mtsPage.enterSum("1");
        mtsPage.clickContinueButton();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
            System.out.println("bepaid-iframe loadd.");
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("bepaid-iframe not loaded");
        }
        mtsFramePage.switchToFrame();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
            System.out.println("bepaid-iframe loadd.");
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("bepaid-iframe not loaded");
        }
        mtsFramePage.switchToFrame();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
            System.out.println("bepaid-iframe loadd.");
        } catch (TimeoutException | NoSuchElementException e) {
            System.out.println("bepaid-iframe not loaded");
        }
        mtsFramePage.switchToFrame();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        mtsFramePage.enterNumCard("1111111111111111");
        mtsFramePage.enterValidityPeriod("03/2222");//ошибся при вводе, но для теста это не принципиально

        String title = mtsFramePage.getTextSumDown();
        System.out.println("Кнопка оплаты, проверка суммы  " + title);
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