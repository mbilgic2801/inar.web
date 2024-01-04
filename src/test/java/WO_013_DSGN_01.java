import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
/*
1-) Open the URL.
2-) Click "WebOrder" button on top bar.
3-) Enter "Inar" as username and "Academy" password.
4-) Click on the "Login" button.
5-) Click Theme Change Switch and Verify Change
 */
public class WO_013_DSGN_01 extends Hooks{

    @Test
    void testThemeChangeSwitch() throws InterruptedException {
        // 2-) Click "WebOrder" button on top bar.
        WebElement webOrderLink = driver.findElement(By.xpath("//a[@href='/weborder']"));
        webOrderLink.click();

        // 3-) Enter "Inar" as username and "Academy" password.
        WebElement userNameInputField = driver.findElement(By.id("login-username-input"));
        WebElement passwordInputField = driver.findElement(By.id("login-password-input"));
        userNameInputField.sendKeys("Inar");
        passwordInputField.sendKeys("Academy");

        // 4-) Click on the "Login" button.
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        Thread.sleep(5000);
        // 5-) Click Theme Change Switch and Verify Change
        WebElement switchButton = driver.findElement(By.xpath("//div[@class='react-switch-bg']"));
        WebElement dataTheme = driver.findElement(By.cssSelector("div[data-theme]"));
        String themeNameBeforeClick = dataTheme.getAttribute("data-theme");
        Thread.sleep(2000);
        switchButton.click();
        dataTheme = driver.findElement(By.cssSelector("div[data-theme]"));
        String themeNameAfterClick = dataTheme.getAttribute("data-theme");
        Assertions.assertTrue(((themeNameBeforeClick.equals("dark"))&&themeNameAfterClick.equals("light"))||((themeNameBeforeClick.equals("light"))&&themeNameAfterClick.equals("dark")));
        Thread.sleep(2000);

    }

}
