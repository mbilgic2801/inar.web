package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

	private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

	private Driver() {
		throw new UnsupportedOperationException("Cannot instantiate utility class");
	}

	public static WebDriver getDriver() throws InterruptedException {
		if (DRIVER_THREAD_LOCAL.get() == null) {
			WebDriver driver;
			String browserType = "Chrome";
			driver = switch (browserType.toLowerCase()) {
				case "firefox" -> new FirefoxDriver();
				case "edge" -> new EdgeDriver();
				default -> new ChromeDriver();
			};
			driver.manage().window().maximize();
			driver.get("https://InarAcademy:Fk160621.@test.inar-academy.com");
			Thread.sleep(1000);
			if (browserType.equalsIgnoreCase("firefox")) {
				driver.navigate().refresh();
				Thread.sleep(1000);
			}
			DRIVER_THREAD_LOCAL.set(driver);
		}
		return DRIVER_THREAD_LOCAL.get();
	}

}
