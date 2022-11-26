package pompages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class ProductCateloge extends genericLibraries.wait {

	WebDriver driver;
	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(xpath ="(//button[@class='btn btn-custom'])[3]")
	WebElement CardBtn;

	By prod = By.cssSelector("b");
	By addToCart = By.cssSelector("[class='btn w-10 rounded']");
	By button1 = By.xpath("(//button[@class='btn btn-custom'])[3]");

	public ProductCateloge(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}

	public void getProductList() {
		products.stream().map(product -> product.findElement(By.cssSelector("b")).getText());

		}

	public void addProductToCart(String productName) throws InterruptedException {
		for (WebElement product : products) {
			boolean w = product.findElement(prod).getText().equals(productName);
			if (w)
			product.findElement(addToCart).click();
			}
		}
	public  ConfirmationPage goToCartPage() throws InterruptedException {
		waitThread();
		CardBtn.click();
		ConfirmationPage Confirm = new ConfirmationPage(driver);
		return Confirm;
	}

}