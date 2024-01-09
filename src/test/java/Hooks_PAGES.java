import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.NoSuchSessionException;
import utils.Driver;

public class Hooks_PAGES {

	@BeforeAll
	public static void setupTestEnvironment() {
		Driver.getDriver();
	}

	@AfterAll
	public static void tearDownTestEnvironment() {
		Driver.closeDriver();
	}

}
