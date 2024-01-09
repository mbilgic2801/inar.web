import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.NoSuchSessionException;
import utils.Driver;

public class Hooks_PAGES {

	@BeforeAll
	public static void setupTestEnvironment() throws InterruptedException {
		Thread.sleep(2000);
		Driver.getDriver();
	}

	@AfterAll
	public static void tearDownTestEnvironment() throws InterruptedException {
		if (Driver.getDriver() != null) {

			Driver.getDriver().quit();
			Thread.sleep(2000);

		}
	}

}
