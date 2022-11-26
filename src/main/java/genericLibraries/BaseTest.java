package genericLibraries;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pompages.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public LoginPage LogIN;

	public WebDriver intializeDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}

	@BeforeMethod(alwaysRun = true)
	public LoginPage lounchApplication() {
		driver = intializeDriver();
		LogIN = new LoginPage(driver);
		LogIN.Goto();
		return LogIN;
	}

	@AfterMethod(alwaysRun = true)
	public void Close() {
		driver.quit();
	}

}
