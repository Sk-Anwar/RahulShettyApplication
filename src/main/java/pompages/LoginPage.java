package pompages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends genericLibraries.wait {
	WebDriver driver;

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement passwordEle;

	@FindBy(id = "login")
	WebElement submit;

	@FindBy(xpath = "//div[contains(text(), 'Incorrect email or password.')]")
	WebElement error;

	@FindBy(xpath = "(//button[@class='btn btn-custom'])[2]")
	WebElement OrderBtn;

	@FindBy(css = ("tr td:nth-child(3)"))
	List<WebElement> products;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ProductCateloge loginApplication(String name, String Password) {
		userEmail.sendKeys(name);
		passwordEle.sendKeys(Password);
		submit.click();
		ProductCateloge product = new ProductCateloge(driver);
		return product;
	}

	public void Goto() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String getError() {
		waitvisibleElement(error);
		return error.getText();
	}

	public void goToOrderPage(String productName) throws InterruptedException {
		OrderBtn.click();
		for (WebElement product : products) {
			boolean eqaual = product.getText().equalsIgnoreCase(productName);
			Assert.assertTrue(eqaual);
		}
	}
}
