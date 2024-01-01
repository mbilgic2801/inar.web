import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
//import org.openga.selenium.webElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webOrderChromeDriverTest {

	WebDriver driver;

	@BeforeEach
	void setUpTestEnvironment() {
		driver = new ChromeDriver();
	}

	@Test
	void testSeleniumWebDriver() throws InterruptedException {
		driver.get("https://www.google.com/");
		String currentUrl = driver.getCurrentUrl();
		Assertions.assertEquals("https://www.google.com/", currentUrl);

	}

	@AfterEach
	void tearDownTestEnvironment() throws InterruptedException {
		driver.quit();
	}

}
