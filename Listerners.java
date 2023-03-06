package cs.ads.Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import cs.ads.Testplayer.TestBase;

public class Listerners extends TestBase implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test is start" + result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	  logger.info("Test is succeed" + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
	logger.info("Test is failed" + result.getName());
	MultipleScreenShots screenshot = new MultipleScreenShots();
	try {
		screenshot.ScreenShot(result.getName() + System.currentTimeMillis());
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	logger.info("Screen Shot has Been Taken " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test is skipped" + result.getName());
	}


	@Override
	public void onStart(ITestContext context) {
		logger.info("Test is start" + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		
		logger.info("Test is finish" + context.getName());
	}

}
