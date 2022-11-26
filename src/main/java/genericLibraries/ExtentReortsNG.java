package genericLibraries;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class ExtentReortsNG
{
	public static ExtentReports getReportObject() {
		String path =  "./Reports/index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("WebAutomationReslt");
		reporter.config().setDocumentTitle("TestReslt");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Shaikh Anwar");

		return  extent;
	}

}
