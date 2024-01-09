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
14-) Select "American Express" as Card Type.
15-) Enter "9938220192845" as Card Number.
16-) Enter "09/26" Expire Date(mm/yy format).
17-) Click "Process"" button.
18-) Verify the Card NUMBER error message is displayed.
 */
public class WO_014_OP_05_PAGES extends Hooks_PAGES {

	@Test
	void testOrderPlacementWithoutCardType() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.clickOnWebOrderLink();
		WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage();
		webOrderLoginPage.login("Inar", "Academy");
		WebOrderHomePage webOrderHomePage = new WebOrderHomePage();
		webOrderHomePage.navigateToOrder();
		OrderPage orderPage = new OrderPage();
		String calculate = orderPage.calculatePrice("SportsEquipment", "1", "10");
		orderPage.enterCustomerInformation("Inar Academy", "1100 Congress Ave", "Austin", "TX", "78701");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("window.scroll(0,1000)");
		Thread.sleep(2000);
		orderPage.enterPaymentInformation("American Express", "9938220192845", "09/26");
		orderPage.clickOnProcessButton();
		// 18-) Verify the Card NUMBER error message is displayed.
		WebElement errorMessage = Driver.getDriver()
			.findElement(By.xpath("//em[normalize-space()='Card number is not valid']"));
		String str = errorMessage.getText();
		Assertions.assertEquals(str, "Card number is not valid");

	}

}
