package scripts;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibraries.BaseTest;
import genericLibraries.PropertyFileUtility;
import pompages.ConfirmationPage;
import pompages.ProductCateloge;
@Listeners(Lis.Listeners.class)
public class TestCase2 extends BaseTest {
	PropertyFileUtility p = new PropertyFileUtility();

	@Test(dataProvider = "getData")
	public void BuyMultipleProduct(String Email, String pass, String producName) throws InterruptedException {

		ProductCateloge product = LogIN.loginApplication(Email, pass);
		product.getProductList();
		product.addProductToCart(producName);

		ConfirmationPage Confirm = product.goToCartPage();
		Confirm.placeOrder();
		String msg = Confirm.ConfirmationMsg();
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "sk7anwar@gmail.com", "Sk@133642", "IPHONE 13 PRO" },
				{ "sk7anwar@gmail.com", "Sk@133642", "ADIDAS ORIGINAL" } };
	}

}
