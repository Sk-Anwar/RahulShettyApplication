package genericLibraries;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wait {

	WebDriver driver;

	public wait(WebDriver driver) {
		this.driver = driver;
	}

	public void waitvisibleElement(WebElement findBy)
	{
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	public void waitThread() throws InterruptedException
	{
	Thread.sleep(2000);
	}

}
