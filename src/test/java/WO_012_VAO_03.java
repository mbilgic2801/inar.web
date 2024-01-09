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
5-) Click "Add More Data" "8" times.
6-) Click 1st, 3rd and 5th orders checkbox's.
7-) Click "Delete All" button.
8-) Verify the orders are deleted.
 */
public class WO_012_VAO_03 extends Hooks {

	@Test
	void testDeleteFunctionalityInViewAllOrderPage() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

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

		// 5-) Click "Add More Data" "8" times.
		WebElement addMoreItemButton = driver.findElement(By.cssSelector(".fs-4.btn.btn-primary.text-fifth.me-3"));
		for (int i = 0; i < 8; i++) {
			addMoreItemButton.click();
		}
		Thread.sleep(2000);

		// 6-) Click 1st, 3rd and 5th orders checkbox's.
		List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
		// List<WebElement> Rows =
		// driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[12]/span[1]"));
		List<WebElement> tableRows = driver.findElements(By.cssSelector("tbody > tr"));
		List<WebElement> columnValuesInFirstRow = tableRows.get(1).findElements(By.xpath("td"));
		List<WebElement> columnValuesInThirdRow = tableRows.get(3).findElements(By.xpath("td"));
		List<WebElement> columnValuesInFifthRow = tableRows.get(5).findElements(By.xpath("td"));

		for (int i = 0; i < checkboxes.size(); i++) {
			if (i == 1 || i == 3 || i == 5) {
				checkboxes.get(i).click();
				js.executeScript("window.scroll(0,400)");
				Thread.sleep(700);
				// System.out.println(Rows.get(i));
			}
		}
		Thread.sleep(1000);

		// 7-) Click "Delete All" button.
		WebElement deleteButton = driver.findElement(By.cssSelector(".btn.btn-danger.fs-4.text-white"));
		deleteButton.click();

		Thread.sleep(3000);
		// 8-) Verify the orders are deleted.
		boolean isDeleted = rowDeleted(columnValuesInFirstRow) || rowDeleted(columnValuesInThirdRow)
				|| rowDeleted(columnValuesInFifthRow);
		Assertions.assertTrue(isDeleted);

	}

	private boolean rowDeleted(List<WebElement> columnValuesInFirstRow) {
		List<WebElement> tableRows = driver.findElements(By.cssSelector("tbody > tr"));
		for (int i = 0; i < tableRows.size(); i++) {
			if (columnValuesInFirstRow.equals(tableRows.get(i).findElements(By.xpath("td"))))
				return false;
		}
		return true;
	}

}
