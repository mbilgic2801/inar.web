package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebOrderHomePage extends BasePage {

	@FindBy(linkText = "View all orders")
	private WebElement viewAllOrdersLink;

	@FindBy(linkText = "View all products")
	private WebElement viewAllProductsLink;

	@FindBy(linkText = "Order")
	private WebElement orderLink;

	@FindBy(id = "logout-button")
	private WebElement logoutButton;

	@FindBy(xpath = "//div[@class='react-switch-bg']")
	private WebElement themeSwitchButton;

	public WebOrderHomePage() throws InterruptedException {
		super();
	}

	public void navigateToViewAllOrders() {
		viewAllOrdersLink.click();
	}

	public void navigateToViewAllProducts() {
		viewAllProductsLink.click();
	}

	public void navigateToOrder() {
		orderLink.click();

	}

	public void clickOnLogoutButton() {
		logoutButton.click();
	}

	public void clickOnThemeSwitchButton() {
		themeSwitchButton.click();
	}

}
