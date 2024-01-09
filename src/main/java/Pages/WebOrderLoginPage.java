package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebOrderLoginPage extends BasePage {

	@FindBy(id = "login-username-input")
	private WebElement userNameInputField;

	@FindBy(id = "login-password-input")
	private WebElement passwordInputField;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	public WebOrderLoginPage() {
		super();
	}

	public void enterUserName(String userName) {
		userNameInputField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordInputField.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void login(String username, String password) {
		enterUserName(username);
		enterPassword(password);
		clickLoginButton();
	}

}
