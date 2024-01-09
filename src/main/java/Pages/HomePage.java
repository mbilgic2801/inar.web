package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	// Locator
	@FindBy(linkText = "Weborder")
	private WebElement webOrderLink;

	@FindBy(linkText = "Webautomation")
	private WebElement webAutomationLink;

	@FindBy(linkText = "Target Market")
	private WebElement targetMarketLink;

	@FindBy(linkText = "Booking")
	private WebElement bookingLink;

	@FindBy(linkText = "Handling Certifications")
	private WebElement handlingCertificationLink;

	@FindBy(linkText = "File Uploading")
	private WebElement fileUpLoadingLink;

	@FindBy(css = "h1.display-1.text-fifth")
	private WebElement exploreInarTestingWorldTitleText;

	// Constructors
	public HomePage() throws InterruptedException {
		super();
	}

	// Page Actions with Java Methods
	public void clickOnWebOrderLink() {
		webOrderLink.click();
	}

	public void clickOnWebAutomationLink() {
		webAutomationLink.click();
	}

	public void clickOnTargetMarketLink() {
		targetMarketLink.click();
	}

	public void clickOnBookingLink() {
		bookingLink.click();
	}

	public void clickOnHandlingCertificationLink() {
		handlingCertificationLink.click();
	}

	public void clickOnFileUpLoadingLink() {
		fileUpLoadingLink.click();
	}

	public String getWelcomeText() {
		return exploreInarTestingWorldTitleText.getText();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

}
