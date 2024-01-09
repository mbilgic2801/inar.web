package Pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.time.Duration;

public abstract class BasePage {

	WebDriver driver = Driver.getDriver();

	public BasePage() throws InterruptedException {
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

}
