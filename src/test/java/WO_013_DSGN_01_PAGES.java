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
5-) Click Theme Change Switch and Verify Change
 */
public class WO_013_DSGN_01_PAGES extends Hooks_PAGES {

	@Test
	void testThemeChangeSwitch() throws InterruptedException {
		HomePage homePage = new HomePage();
		homePage.clickOnWebOrderLink();
		WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage();
		webOrderLoginPage.login("Inar", "Academy");
		WebOrderHomePage webOrderHomePage = new WebOrderHomePage();
		// before click theme setting
		WebElement dataTheme = Driver.getDriver().findElement(By.cssSelector("div[data-theme]"));
		String themeNameBeforeClick = dataTheme.getAttribute("data-theme");
		webOrderHomePage.clickOnThemeSwitchButton();
		// after click theme setting
		dataTheme = Driver.getDriver().findElement(By.cssSelector("div[data-theme]"));
		String themeNameAfterClick = dataTheme.getAttribute("data-theme");
		Assertions.assertTrue(((themeNameBeforeClick.equals("dark")) && themeNameAfterClick.equals("light"))
				|| ((themeNameBeforeClick.equals("light")) && themeNameAfterClick.equals("dark")));
		Thread.sleep(2000);
	}

}
