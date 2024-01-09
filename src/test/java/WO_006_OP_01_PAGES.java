import Pages.HomePage;
import Pages.OrderPage;
import Pages.WebOrderHomePage;
import Pages.WebOrderLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.Driver;

/**
 * 1-) Open the URL. 2-) Click "WebOrder" button on top bar. 3-) Enter valid username
 * "Inar" and password "Academy". 4-) Navigate to the order page. 5-) Select "MyMoney"
 * from Product dropdown. 6-) Enter "8" as quantity number. 7-) Enter "20" as discount
 * percentage. 8-) Click on the "Calculate" button. 9-) Enter "Inar Academy" as Name.
 * 10-)Enter "1100 Congress Ave" as Street. 11-) Enter "Austin" as City. 12-) Enter "TX"
 * State. 13-) Enter "78701" as Zip Code(number). 14-) Select "Visa" as Card Type. 15-)
 * Enter "4938281746192845" as Card Number. 16-) Enter "11/28" Expire Date(mm/yy format).
 * 17-) Click "Process"" button. 18-) Verify the confirmation message is displayed. 19-)
 * Navigate to view all orders page. 20-) Verify the order is successfully placed.
 */

public class WO_006_OP_01_PAGES extends Hooks_PAGES {

	@Test
	void testSuccessfulOrderPlacement() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.clickOnWebOrderLink();
		WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage();
		webOrderLoginPage.login("Inar", "Academy");
		WebOrderHomePage webOrderHomePage = new WebOrderHomePage();
		webOrderHomePage.navigateToOrder();
		OrderPage orderPage = new OrderPage();
		String price = orderPage.calculatePrice("MyMoney", "8", "20");
		orderPage.enterCustomerInformation("Inar Academy", "1100 Congress Ave", "Austin", "TX", "78701");
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(2000);
		orderPage.enterPaymentInformation("Visa", "4938281746192845", "11/28");
		orderPage.clickOnProcessButton();
		// 18-) verify confirmation message
		WebElement confirmationElement = Driver.getDriver().findElement(By.cssSelector("div[role='alert']"));
		String message = confirmationElement.getText();
		String expectedMsg = "New order has been successfully added.";
		Assertions.assertEquals(expectedMsg, message, "Confirmation Message is wrong!");

	}

}
