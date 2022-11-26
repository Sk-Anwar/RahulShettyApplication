package scripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericLibraries.BaseTest;
import pompages.LoginPage;

@Listeners(Lis.Listeners.class)
public class TestCase3 extends BaseTest {

	@Test(groups = { "ErrorValidation" })
	public void loginErrorValidation() throws InterruptedException {
		LoginPage Load = new LoginPage(driver);
		Load.loginApplication("sk7anwar@gmail.com", "Sk@33642");
		Assert.assertTrue(Load.getError().equalsIgnoreCase("Incorrect email  password."));
	}
}
