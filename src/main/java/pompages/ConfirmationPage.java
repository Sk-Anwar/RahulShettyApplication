package pompages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

	public ConfirmationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".totalRow button")
	WebElement checkout;

	@FindBy(css = "input[placeholder='Select Country']")
	WebElement textField;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement Click;

	@FindBy(xpath = "//a[contains(text(),'Place Order')]")
	WebElement order;

	@FindBy(css = ".hero-primary")
	WebElement confirmationMessage;

	public void placeOrder() throws InterruptedException {
		checkout.click();
		textField.sendKeys("India");
		Click.click();
		order.click();
	}

	public String ConfirmationMsg() {
		return confirmationMessage.getText();
	}
}
