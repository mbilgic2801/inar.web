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

import java.time.Duration;
/*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the order page.
5-) Select "HomeDecor" from Product dropdown.
6-) Enter "5" as quantity number.
7-) Enter "15" as discount percentage.
8-) Click on the "Calculate" button.
9-) Verify that the total amount is successfully displayed.
 */

public class WO_004_CF_01 extends Hooks {

	@Test
	void testTheFunctionalityOfCalculating() throws InterruptedException {
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

		// 5-)Select "HomeDecor" from Product dropdown.
		WebElement productDropdownElement = driver.findElement(By.id("productSelect"));
		Select productDropdown = new Select(productDropdownElement);
		productDropdown.selectByVisibleText("HomeDecor");

		// 6-)Enter "5" as quantity number.
		WebElement quantityInputField = driver.findElement(By.id("quantityInput"));
		quantityInputField.sendKeys("5");

		// 7-)Enter "15" as discount percentage.
		WebElement discountInputField = driver.findElement(By.id("discountInput"));
		discountInputField.sendKeys("15");

		// 8-)Click on the "Calculate" button.
		WebElement calculateButton = driver.findElement(By.xpath("//button[text()='Calculate']"));
		calculateButton.click();
		Thread.sleep(2000);

		// 9-)Verify that the total amount is successfully displayed.
		WebElement totalAmount = driver.findElement(By.xpath("//input[@id='totalInput']"));
		String readOnlyValue = totalAmount.getAttribute("value");
		Assertions.assertEquals(readOnlyValue, "638");

	}

}
