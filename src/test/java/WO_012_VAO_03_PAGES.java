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
5-) Click "Add More Data" "8" times.
6-) Click 1st, 3rd and 5th orders checkbox's.
7-) Click "Delete All" button.
8-) Verify the orders are deleted.
 */
public class WO_012_VAO_03_PAGES extends Hooks_PAGES {

	@Test
	void testDeleteFunctionalityInViewAllOrderPage() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		HomePage homePage = new HomePage();
		homePage.clickOnWebOrderLink();
		WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage();
		webOrderLoginPage.login("Inar", "Academy");
		WebOrderHomePage webOrderHomePage = new WebOrderHomePage();
		webOrderHomePage.navigateToViewAllOrders();
		ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();
		viewAllOrdersPage.clickOnAddMoreDataButton(8);
		// 6-) Click 1st, 3rd and 5th orders checkbox's.
		List<WebElement> checkboxes = Driver.getDriver().findElements(By.cssSelector("input[type='checkbox']"));
		// List<WebElement> Rows =
		// driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[12]/span[1]"));
		List<WebElement> tableRows = Driver.getDriver().findElements(By.cssSelector("tbody > tr"));
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
		WebElement deleteButton = Driver.getDriver().findElement(By.cssSelector(".btn.btn-danger.fs-4.text-white"));
		deleteButton.click();

		Thread.sleep(3000);
		// 8-) Verify the orders are deleted.
		boolean isDeleted = rowDeleted(columnValuesInFirstRow) || rowDeleted(columnValuesInThirdRow)
				|| rowDeleted(columnValuesInFifthRow);
		Assertions.assertTrue(isDeleted);

	}

	private boolean rowDeleted(List<WebElement> columnValuesInFirstRow) throws InterruptedException {
		List<WebElement> tableRows = Driver.getDriver().findElements(By.cssSelector("tbody > tr"));
		for (int i = 0; i < tableRows.size(); i++) {
			if (columnValuesInFirstRow.equals(tableRows.get(i).findElements(By.xpath("td"))))
				return false;
		}
		return true;
	}

}
