import Pages.HomePage;
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
3-) Enter "Inar" as username and "Academy" password.
4-) Click on the "Login" button.
5-) Verify that the user is successfully logged in.
 */
public class WO_001_LP_01_PAGES extends Hooks_PAGES {

	@Test
	void testLoginFunctionalityUsingValidCredentials() {
		HomePage homePage = new HomePage();
		homePage.clickOnWebOrderLink();
		WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage();
		webOrderLoginPage.login("Inar", "Academy");
		WebOrderHomePage webOrderHomePage = new WebOrderHomePage();
		WebElement heading = Driver.getDriver().findElement(By.id("welcome-heading"));
		String headingText = heading.getText();
		Assertions.assertEquals("Welcome, Inar!", headingText);
	}

}
