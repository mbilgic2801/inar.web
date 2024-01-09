import Pages.*;
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
5-) Click "Add More Data" "4" times.
6-) Click "Check All" button.
7-) Verify all orders selected.
 */
public class WO_010_VAO_01_PAGES extends Hooks_PAGES {

	@Test
	void testCheckAllFunctionalityInViewAllOrderPage() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.clickOnWebOrderLink();
		WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage();
		webOrderLoginPage.login("Inar", "Academy");
		WebOrderHomePage webOrderHomePage = new WebOrderHomePage();
		webOrderHomePage.navigateToViewAllOrders();
		ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();
		viewAllOrdersPage.clickOnAddMoreDataButton(4);
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
		js.executeScript("window.scroll(0,400)");
		Thread.sleep(1000);
		Assertions.assertEquals(4, checkedCheckboxCount - 1);
	}

}
