package scripts;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibraries.BaseTest;
import genericLibraries.PropertyFileUtility;
import pompages.ConfirmationPage;
import pompages.ProductCateloge;
@Listeners(Lis.Listeners.class)
public class TestCase1 extends BaseTest {
	PropertyFileUtility p = new PropertyFileUtility();

	@Test
	public void BuyOneProduct() throws InterruptedException, IOException
	{
		ProductCateloge product = LogIN.loginApplication(p.getData("email"), p.getData("pass"));
		product.getProductList();
		product.addProductToCart(p.getData("producName"));

		ConfirmationPage Confirm = product.goToCartPage();
		Confirm.placeOrder();
		String msg = Confirm.ConfirmationMsg();
		Assert.assertTrue(msg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}

}
