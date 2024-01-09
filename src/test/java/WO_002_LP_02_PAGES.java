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
3-) Enter invalid username "InvalidUserName" and/or password "InvalidPassword".
4-) Click on the "Login" button
5-) Verify that the appropriate error message is displayed.
 */
public class WO_002_LP_02_PAGES extends Hooks_PAGES {

	@Test
	void testLoginFunctionalityUsingInvalidCredentials() {
		HomePage homePage = new HomePage();
		homePage.clickOnWebOrderLink();
		WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage();
		webOrderLoginPage.login("InvalidUserName", "InvalidPassword");
		WebOrderHomePage webOrderHomePage = new WebOrderHomePage();
		WebElement errorMessage = Driver.getDriver().findElement(By.id("username-error-alert"));
		String errorText = errorMessage.getText();
		Assertions.assertEquals("Invalid username", errorText);
		errorMessage = Driver.getDriver().findElement(By.id("password-error-alert"));
		errorText = errorMessage.getText();
		Assertions.assertEquals("Invalid password", errorText);

	}

}
