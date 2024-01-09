package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewAllOrdersPage extends BasePage {

	// fs-4 btn btn-primary text-fifth me-3
	@FindBy(css = ".fs-4.btn.btn-primary.text-fifth.me-3")
	private WebElement addMoreDataButton;

	// class="btn btn-success fs-4 text-fifth me-3"
	@FindBy(css = ".btn.btn-success.fs-4.text-fifth.me-3")
	private WebElement checkAllButton;

	// btn btn-primary fs-4 text-fifth
	// By.xpath("//button[contains(@class,'btn btn-primary fs-4 text-fifth')]")
	@FindBy(xpath = "//button[contains(@class,'btn btn-primary fs-4 text-fifth')]")
	private WebElement uncheckAllButton;

	// class="btn btn-danger fs-4 text-white "
	@FindBy(css = ".btn.btn-danger.fs-4.text-white")
	private WebElement deleteButton;

	public ViewAllOrdersPage() {
		super();
	}

	public void clickOnAddMoreDataButton() {
		addMoreDataButton.click();
	}

	public void clickOnAddMoreDataButton(int number) {
		for (int i = 0; i < number; i++) {
			addMoreDataButton.click();
		}
	}

	public void clickCheckAllButton() {
		checkAllButton.click();
	}

	public void clickOnUncheckAllButton() {
		uncheckAllButton.click();
	}

	public void clickOnDeleteButton() {
		deleteButton.click();
	}

}
