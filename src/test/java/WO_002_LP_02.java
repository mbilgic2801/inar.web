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
3-) Enter invalid username "InvalidUserName" and/or password "InvalidPassword".
4-) Click on the "Login" button
5-) Verify that the appropriate error message is displayed.
 */

public class WO_002_LP_02 extends Hooks {

	@Test
	void testLoginFunctionalityUsingInvalidCredentials() {
		// 2-) Click "WebOrder" button on top bar.
		WebElement webOrderLink = driver.findElement(By.xpath("//a[@href='/weborder']"));
		webOrderLink.click();

		// 3-) Enter "Inar" as username and "Academy" password.
		WebElement userNameInputField = driver.findElement(By.id("login-username-input"));
		WebElement passwordInputField = driver.findElement(By.id("login-password-input"));
		userNameInputField.sendKeys("InvalidUserName");
		passwordInputField.sendKeys("InvalidPassword");

		// 4-) Click on the "Login" button.
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		// 5-) Verify that the appropriate error message is displayed.
		WebElement errorMessage = driver.findElement(By.id("username-error-alert"));
		String errorText = errorMessage.getText();
		Assertions.assertEquals("Invalid username", errorText);
		errorMessage = driver.findElement(By.id("password-error-alert"));
		errorText = errorMessage.getText();
		Assertions.assertEquals("Invalid password", errorText);

	}

}
