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
1-) Open the URL
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the view all order page.
5-) Click "Add More Data" "4" times.
6-) Click "Check All" button.
7-) Verify all orders selected.
 */
public class WO_010_VAO_01 extends Hooks {

	List<String> orderInformation = new ArrayList<>();

	@Test
	void testCheckAllFunctionalityInViewAllOrderPage() throws InterruptedException {
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

		// 4-) Navigate to the view all order page.
		WebElement orderTabLink = driver.findElement(By.cssSelector("#view-orders-tab > a"));
		orderTabLink.click();

		// 5-) Click "Add More Data" "4" times.
		WebElement addMoreItemButton = driver.findElement(By.cssSelector(".fs-4.btn.btn-primary.text-fifth.me-3"));
		for (int i = 0; i < 4; i++) {
			addMoreItemButton.click();
			Thread.sleep(1000);
		}
		// 6-) Click "Check All" button.
		WebElement checkAllButton = driver
			.findElement(By.xpath("//button[@class='btn btn-success fs-4 text-fifth me-3']"));
		checkAllButton.click();
		Thread.sleep(1000);

		// 7-) Verify all orders selected.
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		int checkedCheckboxCount = 0;
		for (WebElement checkbox : checkboxes) {
			if (checkbox.isSelected()) {
				System.out.println(checkbox.getText());
				checkedCheckboxCount++;
			}
		}

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scroll(0,400)");
		Thread.sleep(1000);
		Assertions.assertEquals(4, checkedCheckboxCount - 1);

	}

}
