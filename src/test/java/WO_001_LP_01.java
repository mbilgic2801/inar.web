import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter "Inar" as username and "Academy" password.
4-) Click on the "Login" button.
5-) Verify that the user is successfully logged in.
 */
public class WO_001_LP_01 {

	WebDriver driver = new ChromeDriver();

	@BeforeEach
	void setUp() {
		// 1-) Open the URL.
		driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

		driver.manage().window().maximize();
	}

	@AfterEach
	void tearDown() {
		driver.quit();
	}

	@Test
	void testLoginFunctionalityUsingValidCredentials() throws InterruptedException {

		// 2-) Click "WebOrder" button on top bar.
		WebElement webOrderLink = driver.findElement(By.xpath("//a[@href='/weborder']"));
		webOrderLink.click();

		// 3-) Enter "Inar" as username and "Academy" password.
		WebElement userNameInputField = driver.findElement(By.id("login-username-input"));
		WebElement passwordInputField = driver.findElement(By.id("login-password-input"));
		userNameInputField.sendKeys("Inar");
		passwordInputField.sendKeys("Academy");

		// 4-) Click on the "Login" button.
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		// 5-) Verify that the user is successfully logged in.
		WebElement heading = driver.findElement(By.id("welcome-heading"));
		String headingText = heading.getText();

		Assertions.assertEquals("Welcome, Inar!", headingText);

	}

}
