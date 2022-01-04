package resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class base {
	
	public Properties prop;
	public WebDriver driver;

	public Properties initializeSQLServer() throws IOException, SQLException {
	    prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Fendy\\DatabaseTesting\\src\\main\\java\\resource\\data.properties");
		prop.load(fis);		
		
		return prop;
		}
	
	public WebDriver initializerDriver() throws IOException, SQLException {
		// Create declare data.properties
		prop = initializeSQLServer();
		


		// Create logic algorithm to keep webdriver not hardcode
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Works\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Works\\firefoxdriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Works\\iexdriver.exe");
			driver = new InternetExplorerDriver();
		}

		// give time implicit to wait 10 seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}
}
	
