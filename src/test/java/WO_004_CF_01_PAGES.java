import Pages.HomePage;
import Pages.OrderPage;
import Pages.WebOrderHomePage;
import Pages.WebOrderLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
public class WO_004_CF_01_PAGES extends Hooks_PAGES {

	@Test
	void testTheFunctionalityOfCalculating() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.clickOnWebOrderLink();
		WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage();
		webOrderLoginPage.login("Inar", "Academy");
		WebOrderHomePage webOrderHomePage = new WebOrderHomePage();
		webOrderHomePage.navigateToOrder();
		OrderPage orderPage = new OrderPage();
		String price = orderPage.calculatePrice("HomeDecor", "5", "15");
		Assertions.assertEquals(price, "638");

	}

}
