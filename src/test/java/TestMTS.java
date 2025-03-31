import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestMTS {

    @Test
    public void init() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
    }
}
