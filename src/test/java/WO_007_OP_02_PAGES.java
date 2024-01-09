import Pages.HomePage;
import Pages.OrderPage;
import Pages.WebOrderHomePage;
import Pages.WebOrderLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.Driver;

/*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the order page.
5-) Select "FamilyAlbum" from Product dropdown.
6-) Enter "3" as quantity number.
7-) Enter "17" as discount percentage.
8-) Enter "Inar Academy" as Name.
9-) Enter "1100 Congress Ave" as Street.
10-) Enter "Austin" as City.
11-) Enter "TX" State.
12-) Enter "78701" as Zip Code(number).
13-) Select "Mastercard" as Card Type.
14-) Enter "5162738261027163" as Card Number.
15-) Enter "11/28" Expire Date(mm/yy format).
16-) Click "Process"" button.
17-) Verify the invalid Product Information error message is displayed.
 */
public class WO_007_OP_02_PAGES extends Hooks_PAGES {

	@Test
	void testOrderPlacementFailureWithoutCalculation() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.clickOnWebOrderLink();
		WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage();
		webOrderLoginPage.login("Inar", "Academy");
		WebOrderHomePage webOrderHomePage = new WebOrderHomePage();
		webOrderHomePage.navigateToOrder();
		OrderPage orderPage = new OrderPage();
		// String price = orderPage.calculatePrice("FamilyAlbum", "3", "17");
		orderPage.selectProduct("FamilyAlbum");
		orderPage.enterQuantity("3");
		orderPage.enterDiscount("17");
		orderPage.enterCustomerInformation("Inar Academy", "1100 Congress Ave", "Austin", "TX", "78701");
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(2000);
		orderPage.enterPaymentInformation("Mastercard", "5162738261027163", "11/28");
		orderPage.clickOnProcessButton();

		// 17-)Verify the invalid Product Information error message is displayed.
		Actions actions = new Actions(Driver.getDriver());
		actions.keyDown(Keys.PAGE_UP).release().build().perform();
		WebElement spanText = Driver.getDriver()
			.findElement(By.cssSelector("div[class='product-information-form'] em"));
		String expectedMsg = spanText.getText();
		Assertions.assertEquals(expectedMsg, "Fix errors in Product Information");

	}

}
