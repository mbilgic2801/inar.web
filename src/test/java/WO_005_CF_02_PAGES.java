import Pages.HomePage;
import Pages.OrderPage;
import Pages.WebOrderHomePage;
import Pages.WebOrderLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

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
public class WO_005_CF_02_PAGES extends Hooks_PAGES {

	@Test
	void testCalculatingFunctionalityInOrderPageWhenEntersInvalidInput() {
		HomePage homePage = new HomePage();
		homePage.clickOnWebOrderLink();
		WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage();
		webOrderLoginPage.login("Inar", "Academy");
		WebOrderHomePage webOrderHomePage = new WebOrderHomePage();
		webOrderHomePage.navigateToOrder();
		OrderPage orderPage = new OrderPage();
		orderPage.selectProduct("ScreenSaver");
		orderPage.enterDiscount("20");
		orderPage.clickOnCalculateButton();

		WebElement spanText = Driver.getDriver().findElement(By.id("quantityValidateError"));
		String str = spanText.getText();
		Assertions.assertEquals(str, "Field 'Quantity' must be greater than zero.");

	}

}
