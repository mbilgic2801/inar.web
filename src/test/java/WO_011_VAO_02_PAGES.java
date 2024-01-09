import Pages.HomePage;
import Pages.ViewAllOrdersPage;
import Pages.WebOrderHomePage;
import Pages.WebOrderLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.Driver;

import java.util.List;

/*
1-) Open the URL
2-) Click "WebOrder" button on top bar.
3-) Enter valid username "Inar" and password "Academy".
4-) Navigate to the view all order page.
5-) Click "Add More Data" "6" times.
6-) Click "Check All" button.
7-) Verify all orders selected.
8-) Click "Uncheck All" button.
9-) Verify all orders are unselected.
 */
public class WO_011_VAO_02_PAGES extends Hooks_PAGES {

	@Test
	void testUncheckAllFunctionalityInViewAllOrderPage() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.clickOnWebOrderLink();
		WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage();
		webOrderLoginPage.login("Inar", "Academy");
		WebOrderHomePage webOrderHomePage = new WebOrderHomePage();
		webOrderHomePage.navigateToViewAllOrders();
		ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();
		viewAllOrdersPage.clickOnAddMoreDataButton(6);
		viewAllOrdersPage.clickCheckAllButton();
		// 7-) Verify all orders selected.
		List<WebElement> checkboxes = Driver.getDriver().findElements(By.cssSelector("input[type='checkbox']"));
		int checkedCheckboxCount = 0;
		for (WebElement checkbox : checkboxes) {
			if (checkbox.isSelected()) {
				System.out.println(checkbox.getText());
				checkedCheckboxCount++;
			}
		}

		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("window.scroll(0,300)");
		Thread.sleep(1000);
		Assertions.assertEquals(6, checkedCheckboxCount - 1);

		// 8-) Click "Uncheck All" button.
		viewAllOrdersPage.clickOnUncheckAllButton();

		// 9-) Verify all orders are unselected.
		checkedCheckboxCount = 0;
		for (WebElement checkbox : checkboxes) {
			if (checkbox.isSelected()) {
				System.out.println(checkbox.getText());
				checkedCheckboxCount++;
			}
		}

		Assertions.assertEquals(0, checkedCheckboxCount - 1);

	}

}
