package cs.ads.Utility;

import cs.ads.Testplayer.TestBase;


	import java.io.File;
	import java.io.IOException;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.io.FileHandler;
	import org.openqa.selenium.support.PageFactory;

	public class MultipleScreenShots extends TestBase{
		
		public MultipleScreenShots() {
			PageFactory.initElements(driver,this);
		}
		
		public void ScreenShot(String name) throws IOException {
			String path = "E:\\EclipseIDE_Workspace\\Carports_Advisor\\screenshots";
			File destination = new File (path + name + ".png");
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(source, destination);
		}
	}



