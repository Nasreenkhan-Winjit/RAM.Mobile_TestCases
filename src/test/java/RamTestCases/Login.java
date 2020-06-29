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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class Login extends ExtentReportBuilder {
	public AppiumDriver<MobileElement> driver;
	private static ExtentReports extent;
   
    
	public  ThreadLocal<ExtentTest>  parentTest = new ThreadLocal<ExtentTest>();
   
    public ThreadLocal<ExtentTest>  test = new ThreadLocal<ExtentTest>();
    
    
	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("~\\..\\Result\\loginReport.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("~\\..\\Result\\loginReport.html");
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("AutomationReport-loginReport");
		htmlReporter.config().setDocumentTitle("AutomationReport-loginReport");
		
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
		//cap.setCapability("autoGrantPermission", "true");
		cap.setCapability("appPackage", "com.ram.courier");
		cap.setCapability("appActivity", "com.ram.courier.activities.SplashScreen");
		cap.setCapability("noReset", "true");
		cap.setCapability("fullReset", "false");
		cap.setCapability("app","C:/Users/nasreenk/Desktop/Diawi/RAMMobile_UatDebug-2.9.35.apk" );
		
		 driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		 driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS) ;
	driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
	MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[8]/android.widget.LinearLayout/android.widget.RadioButton");
el1.click();
MobileElement el2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_save_hub_id");
el2.click();
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
	
@Test(description= "To verify home screen",priority= 0)

public void AtTheHub () throws InterruptedException {
	Thread.sleep(2000);
	MobileElement ATTheHub = (MobileElement) driver.findElementById("com.ram.courier:id/ll_at_the_hub");
	ATTheHub.isEnabled();
	 

	 driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();
		
		//// Permission pop up
			 driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
			 driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
			 driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
			 driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
			
}

  @Test(description= "validate Login by entering 12", priority = 1 )
  
  public void LoginInvalidEnter12DigitId() throws InterruptedException {
	  
	  
	  MobileElement clickOnLoginIcon = (MobileElement) driver.findElementById("com.ram.courier:id/ll_login");
	  clickOnLoginIcon.click();
	  
	  MobileElement entertxtInvalidRamEmployeeID = (MobileElement) driver.findElementById("com.ram.courier:id/edt_ram_employee_id");
	  entertxtInvalidRamEmployeeID.sendKeys("730131015708");
	  MobileElement clickOnloginBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_login");
	  clickOnloginBtn.click();
  }  
  
//	  @Test(description= "validate by entering 14 digit ", priority = 2 )
//	  
//	  public void LoginInvalidEnter14DigitId() throws InterruptedException {
//		  
//	  
//	  MobileElement entertxtValidRamEmployeeID = (MobileElement) driver.findElementById("com.ram.courier:id/edt_ram_employee_id");
//	  entertxtValidRamEmployeeID.sendKeys("73013101");
//	  MobileElement clickOnbtnLogin = (MobileElement) driver.findElementById("com.ram.courier:id/btn_login");
//	  clickOnbtnLogin.click();
////	  MobileElement clickOnBtnOK = (MobileElement) driver.findElementById("android:id/button1");
////	  clickOnBtnOK.click();
//	  } 
	  
	  
@Test(description= "validate Login with valid ID", priority = 2 )
	  
	  public void LoginValidDriverID() throws InterruptedException {
		    
	 
	  MobileElement entertxtRamEmployeeID = (MobileElement) driver.findElementById("com.ram.courier:id/edt_ram_employee_id");
	  entertxtRamEmployeeID.sendKeys("7009155154085");
	  MobileElement clickOnBtnLogin = (MobileElement) driver.findElementById("com.ram.courier:id/btn_login");
	  clickOnBtnLogin.click();
	  
}

@Test(description= "validate AddcrewMember with invalid ID", priority = 3)

public void LoginInValidCrewMemberID() throws InterruptedException {
	  
	  MobileElement addCrewMemberBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_crew_members");
	  addCrewMemberBtn.click();
	  MobileElement clickOnLinkDonthaveRamId = (MobileElement) driver.findElementById("com.ram.courier:id/txt_dont_hv_ram_id");
	  clickOnLinkDonthaveRamId.click();
	  MobileElement enterInvalidAddCrewMember = (MobileElement) driver.findElementById("com.ram.courier:id/et_sa_no");
	  enterInvalidAddCrewMember.sendKeys("700915515408");
}
	  
@Test(description= "validate AddcrewMember with valid ID", priority = 4 )

public void LoginValidCrewMemberID() throws InterruptedException {
	  	 
	  MobileElement clickOnSubmitBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_member");
	  clickOnSubmitBtn.click();
	  MobileElement enterValidCrewMember = (MobileElement) driver.findElementById("com.ram.courier:id/et_sa_no");
	  enterValidCrewMember.sendKeys("7301310157081");
	  MobileElement clickOnSubmitBtn1 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_member");
	  clickOnSubmitBtn1.click();
	  
}  
@Test(description= "Proceed without entering id", priority = 5 )

public void InvalidProceedToScan() throws InterruptedException {	

	  MobileElement clickOnProceedToScanBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_to_scan");
	  clickOnProceedToScanBtn.click();
	  MobileElement clickOnProceedBtn2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
	  clickOnProceedBtn2.click();
	  MobileElement clickOnPopOKbtn = (MobileElement) driver.findElementById("android:id/button1");
	  clickOnPopOKbtn.click();
} 
	  
@Test(description= "Validate Dont have scan ID", priority = 6 )

public void ValidProceedToScan() throws InterruptedException {		  
	  
	  MobileElement clickOnLinkDeliverySheetNoManually = (MobileElement) driver.findElementById("com.ram.courier:id/txt_dont_hv_ds");
	  clickOnLinkDeliverySheetNoManually.click();
}	  
	  
@Test(description= "EnterMannually InvalidManifest ID", priority = 7 )

public void InvalidManifestID() throws InterruptedException {		  
	  
	  MobileElement entertxtInvalidDeliverySheetNo = (MobileElement) driver.findElementById("com.ram.courier:id/et_ds_no");
	  entertxtInvalidDeliverySheetNo.sendKeys("DDISA1581682782");
	  MobileElement clickOnSubmitBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_ds_no");
	  clickOnSubmitBtn.click();
	  MobileElement clickOnOKBtn = (MobileElement) driver.findElementById("android:id/button1");
	  clickOnOKBtn.click();
	  
}
@Test(description= "EnterMannually InvalidManifest ID", priority = 8 )

public void ValidManifestID() throws InterruptedException {		  
	    
	  MobileElement entertxtValidDeliverySheetNo = (MobileElement) driver.findElementById("com.ram.courier:id/et_ds_no");
	  entertxtValidDeliverySheetNo.sendKeys("DDISA15816827824");
	  MobileElement clickOnSubmitBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_ds_no");
	  clickOnSubmitBtn.click();
	  MobileElement clickOnProceedBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
	  clickOnProceedBtn.click();
	  MobileElement clickOnProceedBtn1 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
	  clickOnProceedBtn1.click();
}
	  @Test(description= "ConfirmNo.Of parcel Invalid case", priority = 9 )

	  public void InvalidConfirmNoOfParcel() throws InterruptedException {		
	  MobileElement entertxtInvalidTotalParcel = (MobileElement) driver.findElementById("com.ram.courier:id/et_total_parcels");
	  entertxtInvalidTotalParcel.sendKeys("16");
	  MobileElement clickOnProceedBtnforfurthersheet = (MobileElement) driver.findElementById("com.ram.courier:id/proceed_for_further_sheet");
	  clickOnProceedBtnforfurthersheet.click();
	  entertxtInvalidTotalParcel.clear();
	  }
	  
	  @Test(description= "ConfirmNo.Of parcel  valid case", priority = 10 )

	  public void ValidConfirmNoOfParcel() throws InterruptedException {	
	  
	  MobileElement entertxtValidTotalParcel = (MobileElement) driver.findElementById("com.ram.courier:id/et_total_parcels");
	  entertxtValidTotalParcel.sendKeys("18");
	 	  
	  MobileElement clickOnProceedBtnforfurthersheet = (MobileElement) driver.findElementById("com.ram.courier:id/proceed_for_further_sheet");
	  clickOnProceedBtnforfurthersheet.click();
	  }
	  @Test(description= "InValidVehicle No.", priority = 11 )

	  public void InValidVehicleID() throws InterruptedException {	
	  
	  
	  MobileElement entertxtInvalidRegistrationNo = (MobileElement) driver.findElementById("com.ram.courier:id/et_registration_no");
	  entertxtInvalidRegistrationNo.sendKeys("CL08FRG");
	  MobileElement clickOnSubmitBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_veh_no");
	  clickOnSubmitBtn.click();
	  
	  MobileElement clickOnOkBtn = (MobileElement) driver.findElementById("android:id/button1");
	  clickOnOkBtn.click();
	  
	  }
	  @Test(description= "Enter Valid Vehicle No.", priority = 12 )

	  public void ValidVehicleID() throws InterruptedException {	
	  MobileElement entertxtValidRegistrationNo = (MobileElement) driver.findElementById("com.ram.courier:id/et_registration_no");
	  entertxtValidRegistrationNo.sendKeys("CL08FRGP");
	  MobileElement clickOnSubmitBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_veh_no");
	  clickOnSubmitBtn.click();
	  
	  }
	  
	  @Test(description= "Invalid Odo reading", priority = 13 )

	  public void InvalidOdoMeterReading() throws InterruptedException {
		  MobileElement entertxtInvalidOdometerReading = (MobileElement) driver.findElementById("com.ram.courier:id/et_odometer_reading");
		  entertxtInvalidOdometerReading.sendKeys("12");
		  MobileElement clickOnProceedBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_veh_no");
		  clickOnProceedBtn.click();
		  
		  driver.findElementById("android:id/button1").click();
		  
	  }
	  
	  @Test(description= "Valid Odometer reading", priority = 14 )

	  public void ValidOdoMeterReading() throws InterruptedException {  
	 
	  MobileElement entertxtValidOdometerReading = (MobileElement) driver.findElementById("com.ram.courier:id/et_odometer_reading");
	  entertxtValidOdometerReading.sendKeys("123456");
	  MobileElement clickOnProceedVehNo = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_veh_no");
	  clickOnProceedVehNo.click();
	  
	  }
	  
	  @Test(description= "Click on On the road Icon", priority = 15 )

	  public void TapOnOnTheRoad() throws InterruptedException {  
	 
	  MobileElement clickOnOntheRoadBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_on_the_road");
	  clickOnOntheRoadBtn.click();
	  MobileElement clickOnHomeToolBar= (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
	  clickOnHomeToolBar.click();
	 
	 
  }
	
  @AfterClass
  public void End() {
	  
	
  }


}
