package utils;

import org.openqa.selenium.JavascriptExecutor;

public class BrowserUtils {

	// JavascriptExecutor js = (JavascriptExecutor) driver;
	// js.executeScript("window.scroll(0,1000)");
	public void scrollVertically(int pixelAmount) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
		js.executeScript("window.scroll(0," + pixelAmount + ")");
	}

	public void scrollDown() throws InterruptedException {
		scrollVertically(1000);
	}

	public void scrollUp() throws InterruptedException {
		scrollVertically(-1000);
	}

}
