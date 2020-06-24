package RamTestCases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import RamTestCases.ExtentReportBuilder.ExtentManager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class OtrDeliveryC3 {
	public AppiumDriver<MobileElement> driver;
	private static ExtentReports extent;


	public  ThreadLocal<ExtentTest>  parentTest = new ThreadLocal<ExtentTest>();

	public ThreadLocal<ExtentTest>  test = new ThreadLocal<ExtentTest>();


	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("~\\..\\Result\\DeliveryClass3Report.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("~\\..\\Result\\DeliveryClass3Report.html");
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("AutomationReport-DeliveryClass3Report");
		htmlReporter.config().setDocumentTitle("AutomationReport-DeliveryClass3Report");

	}

	@BeforeClass
	public void beforeClass() throws MalformedURLException, InterruptedException  {

		ExtentTest parent = extent.createTest(getClass().getName());
	    parentTest.set(parent);
	    
	  			DesiredCapabilities cap = new DesiredCapabilities();
			
			// Device configuration
			
			cap.setCapability("automationName", "Appium");
			cap.setCapability("platformName", "Android");	
			cap.setCapability("platformVersion", "9");
			cap.setCapability("deviceName", "Vivo");
			cap.setCapability("udid", "8SSCCMUCKV7SIVRG");  
			cap.setCapability("autoGrantPermission", "true");
			cap.setCapability("appPackage", "com.ram.courier");
			 cap.setCapability("appActivity", "com.ram.courier.activities.SplashScreen");
			 cap.setCapability("noReset", "true");
			cap.setCapability("fullReset", "false");
//			cap.setCapability("app","C:/Users/nasreenk/Desktop/Diawi/RAMMobile_UatDebug-2.9.23-2.apk" );
		
			 driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
			 driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
//		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
//		MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.LinearLayout/android.widget.RadioButton");
	//el1.click();
	//MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_save_hub_id");
	//el2.click();
			// Hub NLS xpath
//			
//				MobileElement NLS = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[11]/android.widget.LinearLayout/android.widget.RadioButton");
//				NLS.click();
//				MobileElement done = (MobileElement) driver.findElementById("com.ram.courier:id/btn_save_hub_id");
//				done.click();
			
	}

	@BeforeMethod
	public synchronized void beforeMethod(Method method) {
		ExtentTest child = parentTest.get().createNode(method.getName());
		test.set(child);
	}

	@AfterMethod
	public synchronized void afterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE)
			test.get().fail(result.getThrowable());
		else if (result.getStatus() == ITestResult.SKIP)
			test.get().skip(result.getThrowable());
		else
			test.get().pass("Test passed");

		extent.flush();
	}

@Test(description= "Deliver with rule No 1 and 2 Invalid case",priority= 2)

public void DeliveryWithRuleNO1N2(){
	
	MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
	el1.click();
	MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_deliveries");
	el2.click();
	MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
	el3.sendKeys("EMER01-40005432.001");
	MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.TextView");
	el4.click();
	MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
	el5.click();
	MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_No_zero");
	el6.click();
	el6.click();
	MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_No_two");
	el7.click();
	MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_no");
	el8.click();
	MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/et_otp");
	el9.sendKeys("9093");
	MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
	el10.click();
	
	MobileElement el15 = (MobileElement) driver.findElementById("android:id/button1");
	el15.click();
	MobileElement el16 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_No_eight");
	el16.click();
	MobileElement el17 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_no");
	el17.click();
	MobileElement el18 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
	el18.click();
	MobileElement el19 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
	el19.sendKeys("Autorcver");
	MobileElement el20 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
	el20.click();
}


@Test(description= "perform non delivery and deliver that parcel",priority= 4)

public void DeliverywithUsingdrivingLicencestep2() throws InterruptedException {

	MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
	el1.sendKeys("HBZB01-20054324.001");
	MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
	el2.click();
	MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
	el3.click();
	MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_yes_zero");
	el4.click();
	MobileElement el5 = (MobileElement) driver.findElementById("com.ram.courier:id/rb_No_one");
	el5.click();
	MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_no");
	el6.click();
	MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/et_otp");
	el7.sendKeys("1675");
	MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
	el8.click();
	MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
	el9.sendKeys("recvrID");
	MobileElement el10 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
	el10.click();
	
	
}

@Test(description= "perform non delivery and deliver that parcel",priority= 4)

public void DeliverywithRule16() throws InterruptedException {



MobileElement el1 = (MobileElement) driver.findElementById("com.ram.courier:id/et_waybill_no");
el1.sendKeys("RAMS02-20054321.001");
MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_parcel");
el2.click();
MobileElement el3 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_delivery");
el3.click();
MobileElement el4 = (MobileElement) driver.findElementById("com.ram.courier:id/et_otp_16");
el4.click();
MobileElement el6 = (MobileElement) driver.findElementById("com.ram.courier:id/et_otp_16");
el6.sendKeys("1234564");
MobileElement el7 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_scan_proceed");
el7.click();
MobileElement el8 = (MobileElement) driver.findElementById("com.ram.courier:id/et_receiver_name");
el8.sendKeys("AutoRcv");
MobileElement el9 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
el9.click();




}		
	
 
}
