import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the order page.
5-) Select "MyMoney" from Product dropdown.
6-) Enter "8" as quantity number.
7-) Enter "20" as discount percentage.
8-) Click on the "Calculate" button.
9-) Enter "Inar Academy" as Name.
10-) Enter "1100 Congress Ave" as Street.
11-) Enter "Austin" as City.
12-) Enter "TX" State.
13-) Enter "92@#83" as Zip Code.
14-) Select "American Express" as Card Type.
15-) Enter "342738261027163" as Card Number.
16-) Enter "01/28" Expire Date(mm/yy format).
17-) Click "Process"" button.
18-) Verify the invalid Zip Code error message is displayed.
 */
public class WO_008_OP_03 extends Hooks {

	List<String> orderInformation = new ArrayList<>();

	@Test
	void testOrderPlacementWithInvalidZipCode() throws InterruptedException {
		// Name
		orderInformation.add("Inar Academy");
		// Prod name
		orderInformation.add("MyMoney");
		// quantity
		orderInformation.add("8");
		// date
		orderInformation.add(DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDate.now()));
		// Street
		orderInformation.add("1100 Congress Ave.");
		// City
		orderInformation.add("Austin");
		// State
		orderInformation.add("TX");
		// Valid Zip code
		orderInformation.add("92@#83");
		// Valid Card Type
		orderInformation.add("amex");
		// Valid Card Number (Visa starts with: 4, Mastercard starts with: 5, American
		// Express starts with: 34, 37.)
		orderInformation.add("342738261027163");
		// Valid Card Expire Date (format must be mm/yy)
		orderInformation.add("01/28");

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

		// Verify that the user is successfully logged in.
		WebElement heading = driver.findElement(By.id("welcome-heading"));
		String headingText = heading.getText();
		Assertions.assertEquals("Welcome, Inar!", headingText);

		// 4-) Navigate to the order page.
		WebElement orderTabLink = driver.findElement(By.cssSelector("#order-tab > a"));
		orderTabLink.click();

		// 5-) Select "MyMoney" from Product dropdown.
		WebElement productDropdownElement = driver.findElement(By.id("productSelect"));
		Select productDropdown = new Select(productDropdownElement);
		productDropdown.selectByVisibleText(orderInformation.get(1));

		// 6-) Enter "8" as quantity number.
		WebElement quantityInputField = driver.findElement(By.id("quantityInput"));
		quantityInputField.sendKeys(orderInformation.get(2));

		// 7-) Enter "20" as discount percentage.
		WebElement discountInputField = driver.findElement(By.id("discountInput"));
		discountInputField.sendKeys("20");

		// 8-) Click on the "Calculate" button.
		WebElement calculateButton = driver.findElement(By.xpath("//button[text()='Calculate']"));
		calculateButton.click();
		Thread.sleep(2000);

		// 9..13-) Enter customer information
		WebElement nameField = driver.findElement(By.id("name"));
		WebElement streetField = driver.findElement(By.id("street"));
		WebElement cityField = driver.findElement(By.id("city"));
		WebElement stateField = driver.findElement(By.id("state"));
		WebElement zipCodeField = driver.findElement(By.id("zip"));

		nameField.sendKeys(orderInformation.get(0));
		streetField.sendKeys(orderInformation.get(4));
		cityField.sendKeys(orderInformation.get(5));
		stateField.sendKeys(orderInformation.get(6));
		zipCodeField.sendKeys(orderInformation.get(7));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,1000)");

		Thread.sleep(2000);

		// 14,15,16-) Enter payment info
		WebElement visaCheckbox = driver.findElement(By.id("amex"));
		visaCheckbox.click();

		WebElement cardNumberField = driver.findElement(By.id("cardNumber"));
		cardNumberField.sendKeys(orderInformation.get(9));

		WebElement expiryDateField = driver.findElement(By.id("expiryDate"));
		expiryDateField.sendKeys(orderInformation.get(10));

		// 17-) click on "process" button
		WebElement processButton = driver.findElement(By.xpath("//button[text()='Process']"));
		processButton.click();

		// 18-) Verify the invalid Zip Code error message is displayed.
		WebElement messageText = driver.findElement(By.cssSelector("div[role='alert']"));
		String strOfText = messageText.getText();
		assert !strOfText.equals("New order has been successfully added.")
				: ("The order has been listed with an invalid ZIP code");

	}

}
