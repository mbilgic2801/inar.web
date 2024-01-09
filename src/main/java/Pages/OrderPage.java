package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OrderPage extends BasePage {

	// Product Information
	@FindBy(id = "productSelect")
	private WebElement productDropdownElement;

	@FindBy(id = "quantityInput")
	private WebElement quantityInputField;

	@FindBy(id = "discountInput")
	private WebElement discountInputField;

	@FindBy(id = "totalInput")
	private WebElement totalPriceField;

	@FindBy(xpath = "//button[text()='Calculate']")
	private WebElement calculateButton;

	// Customer Information
	@FindBy(id = "name")
	private WebElement nameField;

	@FindBy(id = "street")
	private WebElement streetField;

	@FindBy(id = "city")
	private WebElement cityField;

	@FindBy(id = "state")
	private WebElement stateField;

	@FindBy(id = "zip")
	private WebElement zipCodeField;

	// Payment Information
	@FindBy(id = "visa")
	private WebElement visaCheckbox;

	@FindBy(id = "mastercard")
	private WebElement masterCardCheckbox;

	@FindBy(id = "amex")
	private WebElement americanExpressCheckbox;

	// card number
	@FindBy(id = "cardNumber")
	private WebElement cardNumberField;

	@FindBy(id = "expiryDate")
	private WebElement expiryDateField;

	@FindBy(xpath = "//button[text()='Process']")
	private WebElement processButton;

	public void enterPaymentInformation(String paymentMethod, String cardNumber, String expiryDate) {
		selectPaymentMethod(paymentMethod);
		enterCardNumber(cardNumber);
		enterExpiryDate(expiryDate);
	}

	public OrderPage() {
		super();
	}

	public void selectProduct(String productName) {
		Select productDropDown = new Select(productDropdownElement);
		productDropDown.selectByVisibleText(productName);
	}

	public void enterQuantity(String quantity) {
		quantityInputField.clear();
		quantityInputField.sendKeys(quantity);
	}

	public void enterDiscount(String discount) {
		discountInputField.clear();
		discountInputField.sendKeys(discount);
	}

	public void clickOnCalculateButton() {
		calculateButton.click();
	}

	public String calculatePrice(String productName, String quantity, String discount) {
		selectProduct(productName);
		enterQuantity(quantity);
		enterDiscount(discount);
		clickOnCalculateButton();
		WebElement totalPriceElement = totalPriceField;

		return totalPriceElement.getAttribute("value");
	}

	public void enterName(String name) {
		nameField.clear();
		nameField.sendKeys(name);
	}

	public void enterStreet(String street) {
		streetField.clear();
		streetField.sendKeys(street);
	}

	public void enterCity(String city) {
		cityField.clear();
		cityField.sendKeys(city);
	}

	public void enterState(String state) {
		WebElement stateElement = stateField;
		stateField.clear();
		stateField.sendKeys(state);
	}

	public void enterZipCode(String zipCode) {
		zipCodeField.clear();
		zipCodeField.sendKeys(zipCode);
	}

	public void enterCustomerInformation(String name, String street, String city, String state, String zipCode) {
		enterName(name);
		enterStreet(street);
		enterCity(city);
		enterState(state);
		enterZipCode(zipCode);
	}

	public void selectPaymentMethod(String paymentMethod) {
		switch (paymentMethod.toLowerCase()) {
			case "visa":
				clickCheckBox(visaCheckbox);
				break;
			case "mastercard":
				clickCheckBox(masterCardCheckbox);
				break;
			case "american express":
				clickCheckBox(americanExpressCheckbox);
				break;
			default:
				System.out.println("Payment method doesn't exist");
				break;
		}
	}

	private void clickCheckBox(WebElement checkbox) {

		if (!checkbox.isSelected()) {
			checkbox.click();
		}
	}

	public void enterCardNumber(String cardNumber) {
		cardNumberField.clear();
		cardNumberField.sendKeys(cardNumber);
	}

	public void enterExpiryDate(String expiryDate) {
		expiryDateField.clear();
		expiryDateField.sendKeys(expiryDate);
	}

	public void clickOnProcessButton() {
		processButton.click();
	}

}
