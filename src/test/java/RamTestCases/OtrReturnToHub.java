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

public class OtrReturnToHub {
	public AppiumDriver<MobileElement> driver;
	private static ExtentReports extent;


	public  ThreadLocal<ExtentTest>  parentTest = new ThreadLocal<ExtentTest>();

	public ThreadLocal<ExtentTest>  test = new ThreadLocal<ExtentTest>();


	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance("~\\..\\Result\\DeliveryC1Report.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("~\\..\\Result\\ReturntoHUBReport.html");
		extent.attachReporter(htmlReporter);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("AutomationReport-ReturntoHUBReport");
		htmlReporter.config().setDocumentTitle("AutomationReport-ReturntoHUBReport");

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
		//			 cap.setCapability("noReset", "true");
		//			cap.setCapability("fullReset", "false");


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



	@Test(description= "To verify Proceed Button",priority= 0)

	public void ReturntoHubProceedBtn () throws InterruptedException {


		// At the Hub

		MobileElement ATTheHub = (MobileElement) driver.findElementById("com.ram.courier:id/ll_at_the_hub");
		ATTheHub.isEnabled();


		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]").click();

		//// Permission
		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();

		//login
		MobileElement login = (MobileElement) driver.findElementById("com.ram.courier:id/ll_login");
		login.click();

		MobileElement entertxtRamEmployeeId = (MobileElement) driver.findElementById("com.ram.courier:id/edt_ram_employee_id");
		entertxtRamEmployeeId.sendKeys("7301310157081");
		MobileElement clickOnLoginBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_login");
		clickOnLoginBtn.click();

		MobileElement clickOnaddCrewMemberbtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_add_crew_members");
		clickOnaddCrewMemberbtn.click();
		MobileElement clickOnLinkDonthaveRamId = (MobileElement) driver.findElementById("com.ram.courier:id/txt_dont_hv_ram_id");
		clickOnLinkDonthaveRamId.click();
		MobileElement entertxtAddCrewMember = (MobileElement) driver.findElementById("com.ram.courier:id/et_sa_no");
		entertxtAddCrewMember.sendKeys("7009155154085");
		MobileElement submitBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_member");
		submitBtn.click();

		MobileElement proceedToScanBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_to_scan");
		proceedToScanBtn.click();


		MobileElement clickOnLinkdeliverySheetNoManuaaly = (MobileElement) driver.findElementById("com.ram.courier:id/txt_dont_hv_ds");
		clickOnLinkdeliverySheetNoManuaaly.click();


		MobileElement entertxtdeliverysheetNomanually = (MobileElement) driver.findElementById("com.ram.courier:id/et_ds_no");
		entertxtdeliverysheetNomanually.sendKeys("DDISA15822179704");
		
		MobileElement clickOnSubmitBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_ds_no");
		clickOnSubmitBtn.click();
		MobileElement clickOnProceedBtn1 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		clickOnProceedBtn1.click();
		MobileElement clickOnProceedBtn2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed");
		clickOnProceedBtn2.click();

		MobileElement entertxtTotalParcel = (MobileElement) driver.findElementById("com.ram.courier:id/et_total_parcels");
		entertxtTotalParcel.sendKeys("6");

		MobileElement clickOnProceedBtnforfurthersheet = (MobileElement) driver.findElementById("com.ram.courier:id/proceed_for_further_sheet");
		clickOnProceedBtnforfurthersheet.click();

		MobileElement entertxtVehicleRegistrationNo = (MobileElement) driver.findElementById("com.ram.courier:id/et_registration_no");
		entertxtVehicleRegistrationNo.sendKeys("CL08FRGP");
		MobileElement clickOnbtnSubmit = (MobileElement) driver.findElementById("com.ram.courier:id/btn_submit_veh_no");
		clickOnbtnSubmit.click();

		MobileElement entertxtOdometerReading = (MobileElement) driver.findElementById("com.ram.courier:id/et_odometer_reading");
		entertxtOdometerReading.sendKeys("123456");
		MobileElement clickOnbtnProceedVehNo = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_veh_no");
		clickOnbtnProceedVehNo.click();

		MobileElement clickOnOnTheRoadBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_on_the_road");
		clickOnOnTheRoadBtn.click();
		MobileElement clickOnHoeToolbarIcon = (MobileElement) driver.findElementById("com.ram.courier:id/btn_home_toolbar");
		clickOnHoeToolbarIcon.click();


		MobileElement clickOnOnTheRoadBtn1 = (MobileElement) driver.findElementById("com.ram.courier:id/ll_on_the_road");
		clickOnOnTheRoadBtn1.click();
		MobileElement clickOnReturnToHubIcon = (MobileElement) driver.findElementById("com.ram.courier:id/ll_return_hub");
		clickOnReturnToHubIcon.click();
		MobileElement selectReasonforOpenDeliveries = (MobileElement) driver.findElementById("com.ram.courier:id/tv_select_reason");
		selectReasonforOpenDeliveries.click();
		MobileElement clickOnProceedbtnRTH = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_");
		clickOnProceedbtnRTH.click();
		MobileElement clickOnOKBtn = (MobileElement) driver.findElementById("android:id/button1");
		clickOnOKBtn.click();

	}

	@Test(description= "To verify and select Reason for Open Deliveries ",priority= 1)

	public void ReturntoHubSelectReasonforOpenDeliveries () throws InterruptedException {


		MobileElement clickOnOpenDeliveriesSummary_SelectReason = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout");
		clickOnOpenDeliveriesSummary_SelectReason.click();
		MobileElement selectOpenDeliveriesSummary_SelectReason = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]");
		selectOpenDeliveriesSummary_SelectReason.click();

	}


	@Test(description= "To verify and select Reason for Open Deliveries ",priority= 2)

	public void ReturntoHubSelectReasonforOpenCollection () throws InterruptedException {


		MobileElement clickOnOpenCollectionDropDown = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout");
		clickOnOpenCollectionDropDown.click();
		MobileElement selectReasonforOpenCollection = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[6]");
		selectReasonforOpenCollection.click();
		MobileElement clickOnProceedBtn = (MobileElement) driver.findElementById("com.ram.courier:id/btn_proceed_");
		clickOnProceedBtn.click();

	}

	@Test(description= "To verify and select Reason for Open Deliveries ",priority= 3)

	public void ReturntoHubSelectReasonforNextCollectionEnterINvalidPodNO () throws InterruptedException {

		//second reco

		MobileElement clickOnbtnLogout1 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_logout");
		clickOnbtnLogout1.click();
		MobileElement clickOnbtnOK = (MobileElement) driver.findElementById("android:id/button2");
		clickOnbtnOK.click();
	}
	
	@Test(description= "To verify and select Reason for Open Deliveries ",priority= 4)

	public void ReturntoHubSelectReasonforNextCollectionEnterValidPodNO () throws InterruptedException {
		MobileElement clickOnbtnLogout2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_logout");
		clickOnbtnLogout2.click();
		MobileElement entertxtPODBagNo = (MobileElement) driver.findElementById("com.ram.courier:id/et_pod_bag_no");
		entertxtPODBagNo.sendKeys("POD12345678");

	}

	@Test(description= "To verify and select Reason for Open Deliveries ",priority= 5)

	public void ReturntoHubScanInvalidWaybillNo () throws InterruptedException {

		driver.findElementById("com.ram.courier:id/btn_scan_waybill").click();
		driver.findElementById("android:id/button1").click();


	}

	@Test(description= "To verify and select Reason for Open Deliveries ",priority= 6)

	public void ReturntoHubScanValidWaybillNo () throws InterruptedException {

		driver.findElementById("com.ram.courier:id/btn_scan_waybill").click();


		MobileElement clickOnBtnLogout1 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_logout");
		clickOnBtnLogout1.click();
		MobileElement clickOnBtnOK = (MobileElement) driver.findElementById("android:id/button2");
		clickOnBtnOK.click();
		MobileElement clickOnBtnLogout2 = (MobileElement) driver.findElementById("com.ram.courier:id/btn_logout");
		clickOnBtnLogout2.click();
		MobileElement clickOnBtnOK1 = (MobileElement) driver.findElementById("android:id/button1");
		clickOnBtnOK1.click();


	}

}






