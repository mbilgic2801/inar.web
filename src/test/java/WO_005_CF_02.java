import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the order page.
5-) Select "ScreenSaver" from Product dropdown.
6-) Leave blank the quantity box.
7-) Enter "20" as discount percentage.
8-) Click on the "Calculate" button.
9-) Verify the invalid Quantity error message is displayed.
 */
public class WO_005_CF_02 extends Hooks {

	@Test
	void testCalculatingFunctionalityInOrderPageWhenEntersInvalidInput() throws InterruptedException {
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

		// 4-) Navigate to the order page.
		WebElement orderTabLink = driver.findElement(By.cssSelector("#order-tab > a"));
		orderTabLink.click();

		// 5-)Select "ScreenSaver" from Product dropdown.
		WebElement productDropdownElement = driver.findElement(By.id("productSelect"));
		Select productDropdown = new Select(productDropdownElement);
		productDropdown.selectByVisibleText("ScreenSaver");

		// 6-) Leave blank the quantity box.

		// 7-)Enter "20" as discount percentage.
		WebElement discountInputField = driver.findElement(By.id("discountInput"));
		discountInputField.sendKeys("20");

		// 8-)Click on the "Calculate" button.
		WebElement calculateButton = driver.findElement(By.xpath("//button[text()='Calculate']"));
		calculateButton.click();
		Thread.sleep(2000);

		// 9-) Verify the invalid Quantity error message is displayed.
		WebElement spanText = driver.findElement(By.id("quantityValidateError"));
		String str = spanText.getText();
		Assertions.assertEquals(str, "Field 'Quantity' must be greater than zero.");

	}

}
