import Pages.HomePage;
import Pages.WebOrderHomePage;
import Pages.WebOrderLoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.Driver;

/*
//1-) Open the URL
//2-) Click "WebOrder" button on top bar.
//3-) Enter valid username "Inar" and password "Academy".
//4-) Click "Logout" button.
5-) Verify logout successfully.
 */
public class WO_003_LP_03_PAGES extends Hooks_PAGES {

	@Test
	void testTheLogoutFunctionality() {
		HomePage homePage = new HomePage();
		homePage.clickOnWebOrderLink();
		WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage();
		webOrderLoginPage.login("Inar", "Academy");
		WebOrderHomePage webOrderHomePage = new WebOrderHomePage();
		webOrderHomePage.clickOnLogoutButton();
		try {
			WebElement newLoginButton = Driver.getDriver().findElement(By.id("login-button"));
		}
		catch (NoSuchElementException e) {

			assert false
					: ("The user should be successfully logged out and redirected to the login page.But it did not!!");
		}
	}

}
