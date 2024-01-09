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

/*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the order page.
5-) Select "SportsEquipment" from Product dropdown.
6-) Enter "1" as quantity number.
7-) Enter "10" as discount percentage.
8-) Click on the "Calculate" button.
9-) Enter "Inar Academy" as Name.
10-) Enter "1100 Congress Ave" as Street.
11-) Enter "Austin" as City.
12-) Enter "TX" State.
13-) Enter "78701" as Zip Code(number).
14-) Enter "4938220192845" as Card Number.
15-) Enter "09/26" Expire Date(mm/yy format).
16-) Click "Process"" button.
17-) Verify the Card Type error message is displayed.
 */
public class WO_009_OP_04_PAGES extends Hooks_PAGES {

	@Test
	void testOrderPlacementFailureWithoutCalculation() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.clickOnWebOrderLink();
		WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage();
		webOrderLoginPage.login("Inar", "Academy");
		WebOrderHomePage webOrderHomePage = new WebOrderHomePage();
		webOrderHomePage.navigateToOrder();
		OrderPage orderPage = new OrderPage();
		String price = orderPage.calculatePrice("SportsEquipment", "1", "10");
		orderPage.enterCustomerInformation("Inar Academy", "1100 Congress Ave", "Austin", "TX", "78701");
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(2000);
		orderPage.enterCardNumber("4938220192845");
		orderPage.enterExpiryDate("09/26");
		orderPage.clickOnProcessButton();
		// 17-) Verify the Card Type error message is displayed.
		WebElement errorMessage = Driver.getDriver()
			.findElement(By.cssSelector("div[class='d-flex flex-column justify-content-start align-items-start'] em"));
		String str = errorMessage.getText();
		Assertions.assertEquals(str, "Card type cannot be empty");
	}

}
