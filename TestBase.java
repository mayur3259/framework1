package cs.ads.Testplayer;

import java.time.Duration;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v108.dom.model.Rect;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Garages_section.Garages;
import cs.ads.pagelayer.Boat_Carports;
import cs.ads.pagelayer.Boxed_Eave;
import cs.ads.pagelayer.BuyNow;
import cs.ads.pagelayer.Carports;
import cs.ads.pagelayer.ClearSpan_MetalBuildings;
import cs.ads.pagelayer.Commercial_section;
import cs.ads.pagelayer.Homepage;
import cs.ads.pagelayer.Recreational_MetalBuildings;
import cs.ads.pagelayer.Regular_Roof;
import cs.ads.pagelayer.Vertical_metalCarports;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {
	public static WebDriver driver;
	public Homepage home;
	public static SoftAssert soft;
	public Logger logger;
    public BuyNow buy;
    public Carports carport;
    public Vertical_metalCarports vertical;
    public Boxed_Eave box ;
    public Regular_Roof regular;
    public Boat_Carports boat;
    public Garages garage;
    public Commercial_section commercial;
    public ClearSpan_MetalBuildings clear_span;
    static ExtentTest test;
    static ExtentReports report;
    public Recreational_MetalBuildings recreational;
	@BeforeTest
	public void s() {
		logger = Logger.getLogger("ActiTime Automation Framework");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("Testing Frame work Has Been Start");
	}

	@AfterTest
	public void end() {
		logger.info("Testing Has Been Done");
	}


	@BeforeMethod
	public void start() {
		String browser = "chrome";
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			// driver=new IEDriver();
		}
		else {
			System.out.println("provide correct inputs");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://www.carportsadvisor.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//-----objects-----
		home=new Homepage();
		soft =new SoftAssert();
		buy=new BuyNow();
	    carport=new Carports();
	    vertical=new Vertical_metalCarports();
	    box=new Boxed_Eave();
	    regular = new Regular_Roof();
	    boat=new Boat_Carports();
	    garage=new Garages();
	    commercial=new Commercial_section();
	    clear_span=new ClearSpan_MetalBuildings();
	    recreational = new Recreational_MetalBuildings();
	}

	@AfterMethod
	public void ends() {
		driver.quit();
}	
}
