package genericLibraries;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class PropertyFileUtility {

	public String getData(String key) throws IOException
	{
		FileInputStream fis = new FileInputStream("./src/test/resources/comData.properties");
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
}
