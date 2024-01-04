import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
/*
1-) Open the URL
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Click "Logout" button.
5-) Verify logout successfully.
 */

public class WO_003_LP_03 extends Hooks {

	@Test
	void testTheLogoutFunctionality() throws InterruptedException {
		// 2-) Click "WebOrder" button on top bar.
		WebElement webOrderLink = driver.findElement(By.xpath("//a[@href='/weborder']"));
		webOrderLink.click();

		// 3-) Enter "Inar" as username and "Academy" password.
		WebElement userNameInputField = driver.findElement(By.id("login-username-input"));
		WebElement passwordInputField = driver.findElement(By.id("login-password-input"));
		userNameInputField.sendKeys("Inar");
		passwordInputField.sendKeys("Academy");

		// Click on the "Login" button.
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		// 4-) Click on the "Logout" button.
		WebElement logoutButton = driver.findElement(By.id("logout-button"));
		logoutButton.click();

		// 5-) Verify logout successfully.
		try {
			WebElement newLoginButton = driver.findElement(By.id("login-button"));
		}
		catch (NoSuchElementException e) {

			assert false
					: ("The user should be successfully logged out and redirected to the login page.But it did not!!");
		}

	}

}
