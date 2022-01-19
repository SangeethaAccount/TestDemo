package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Config.CucumberReport;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;


public class BaseClass extends CucumberReport{
//	public static AppiumDriver driver;
	public static AndroidDriver<WebElement> driver;
	static DesiredCapabilities dc = new DesiredCapabilities();
	
	public static String SignupXpath = "D:\\IEBAutomation\\IEBAutomation\\src\\test\\java\\PageObject\\SignupPage.properties";
	public static String LoginXpath = "D:\\IEBAutomation\\IEBAutomation\\src\\test\\java\\PageObject\\LoginPage.properties";
	public static String PosterXpath = "D:\\IEBAutomation\\IEBAutomation\\src\\test\\java\\PageObject\\Poster.properties";
	
	public static WebElement getElement(String locator,String locatorfile) throws Exception {
		String locatortype, locatorvalue;
		Properties Prop = new Properties();
		File Location = new File(locatorfile);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		locatortype = Prop.getProperty(locator).split(" ")[0];
		locatorvalue = Prop.getProperty(locator).split(" ", 2)[1];

		switch (locatortype) {
		case "id":
			return driver.findElement(By.id(locatorvalue));
		case "xpath":
			return driver.findElement(By.xpath(locatorvalue));
		default:
			return driver.findElement(By.xpath(locatorvalue));
		}
	}

	public static List<WebElement> getElements(String locator,String locatorfile) throws Exception {
		String locatortype, locatorvalue;
		Properties Prop = new Properties();
		File Location = new File(locatorfile);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		locatortype = Prop.getProperty(locator).split(" ")[0];
		locatorvalue = Prop.getProperty(locator).split(" ", 2)[1];

		switch (locatortype) {
		case "id":
			return driver.findElements(By.id(locatorvalue));
		case "name":
			return driver.findElements(By.name(locatorvalue));
		case "classname":
			return driver.findElements(By.className(locatorvalue));
		case "xpath":
			return driver.findElements(By.xpath(locatorvalue));
		default:
			return driver.findElements(By.xpath(locatorvalue));
		}
	}
	public static By getElementBy(String locator,String locatorfile) throws IOException  {
		String locatortype, locatorvalue;
		Properties Prop = new Properties();
		File Location = new File(locatorfile);
		FileReader File = new FileReader(Location);
		Prop.load(File);
		locatortype = Prop.getProperty(locator).split(" ")[0];
		locatorvalue = Prop.getProperty(locator).split(" ", 2)[1];

		switch (locatortype) {
		case "id":
			return By.id(locatorvalue);
		case "name":
			return By.name(locatorvalue);
		case "classname":
			return By.className(locatorvalue);
		case "xpath":
			return By.xpath(locatorvalue);
		default:
			return By.xpath(locatorvalue);
		}
	}
	
	public static void sendKeystoElement(String locator, String locatorfile,String Value) throws Throwable {
		getElement(locator, locatorfile).clear();
		getElement(locator, locatorfile).sendKeys(Value);
	}
	
	public void scrollAndClick(String visibleText) {
		driver.findElementByCssSelector(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))")
		.click();  
	}

	public void scroll(String visibleText) {
		
		WebElement scroll=driver.findElementByCssSelector(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))");
	}
	
	public void switchToFrame(int frame) {
		try {
			driver.switchTo().frame(frame);
			System.out.println("Navigated to frame with id " + frame);
		} catch (NoSuchFrameException e) {
			System.out.println("Unable to locate frame with id " + frame + e.getStackTrace());
		} catch (Exception e) {
			System.out.println("Unable to navigate to frame with id " + frame + e.getStackTrace());
		}
	}
	
	public static void scrolldown(AndroidDriver driver) {
		int X = 674;
		int Y = 1382;
		PointOption pointStart = PointOption.point(X, Y);
		WaitOptions waitOption = WaitOptions.waitOptions(Duration.ofMillis(1000));
		PointOption pointEnd = PointOption.point(X + 30, Y-400);

		new TouchAction(driver).press(pointStart).waitAction(waitOption).moveTo(pointEnd).release()
		.perform();
		}

	public void allowPermissions() throws Throwable {
		getElement("permissions.allow", null).click();
	}

	public void hideCloudDeviceKeyboard() {
		driver.navigate().back();
	}

	public void closeDatePicker() {
		driver.findElement(By.id("button2")).click();
	}

	public void quitDriver() {
		driver.quit();
	}
	
	public void closeDriver() {
		driver.close();
	}
	
	public static void clickElement(String ID,String locatorfile) throws Throwable {
		getElement(ID, locatorfile).click();

	}

	public void waitForElement(String ID,String locatorfile) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.elementToBeClickable(getElement(ID,locatorfile)));
	}

	public void explictwait(String text) {
		Wait wait = new FluentWait(driver).withTimeout(60, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class).ignoring(TimeoutException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(text)));

	}
	public void explicitwaitclickable(AndroidDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 60);

		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static String captureScreenshot() throws IOException {

		File srcFiler = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		byte[] encoded;
		try {
			encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(srcFiler));
			String s = new String(encoded, StandardCharsets.US_ASCII);
			return s;

		} catch (IOException e) {
			e.printStackTrace();

		}
		return LoginXpath;
	}

	public static void scrollby(AndroidDriver driver, String x, String y, String date, String month, String year) {
	int X = Integer.parseInt(x);
	int Y = Integer.parseInt(y);
	int count = 1;
	for (int i = 0; i <= count; i++) 
	{ 
		if (driver.getPageSource().contains(year)) {
	WebElement val = driver.findElement(By.xpath("//*[@text='" + year + "' and @id='text1']"));
	val.click();
	break;
	} else {
		PointOption pointStart = PointOption.point(X, Y);
		WaitOptions waitOption = WaitOptions.waitOptions(Duration.ofMillis(1000));
		PointOption pointEnd = PointOption.point(X + 5, Y + 600);

	new TouchAction(driver).press(pointStart).waitAction(waitOption).moveTo(pointEnd).release()
	.perform();
	}
	count++;
	} switch (month) {
	case "January":
	driver.findElement(By.xpath("//*[@text='" + date + "']")).click();
	break;
	case "february":
	driver.findElement(By.xpath("//*[@id='next']")).click();
	driver.findElement(By.xpath("//*[@text='" + date + "']")).click();
	break;
	case "March":
	for (int j = 0; j < 2; j++) {
	driver.findElement(By.xpath("//*[@id='next']")).click();
	}
	driver.findElement(By.xpath("//*[@text='" + date + "']")).click();
	break;
	case "April":
	for (int j = 0; j < 3; j++) {
	driver.findElement(By.xpath("//*[@id='next']")).click();
	}
	driver.findElement(By.xpath("//*[@text='" + date + "']")).click();
	break;
	case "May":
	for (int j = 0; j < 4; j++) {
	driver.findElement(By.xpath("//*[@id='next']")).click();
	}
	driver.findElement(By.xpath("//*[@text='" + date + "']")).click();
	break;
	case "June":
	for (int j = 0; j < 5; j++) {
	driver.findElement(By.xpath("//*[@id='next']")).click();
	}
	driver.findElement(By.xpath("//*[@text='" + date + "']")).click();
	break;
	case "July":
	for (int j = 0; j < 6; j++) {
	driver.findElement(By.xpath("//*[@id='next']")).click();
	}
	driver.findElement(By.xpath("//*[@text='" + date + "']")).click();
	break;
	case "August":
	for (int j = 0; j < 7; j++) {
	driver.findElement(By.xpath("//*[@id='next']")).click();
	}
	driver.findElement(By.xpath("//*[@text='" + date + "']")).click();
	break;
	case "September":
	for (int j = 0; j < 8; j++) {
	driver.findElement(By.xpath("//*[@id='next']")).click();
	}
	driver.findElement(By.xpath("//*[@text='" + date + "']")).click();
	break;
	case "October":
	for (int j = 0; j < 9; j++) {
	driver.findElement(By.xpath("//*[@id='next']")).click();
	}
	driver.findElement(By.xpath("//*[@text='" + date + "']")).click();
	break;
	case "November":
	for (int j = 0; j < 10; j++) {
	driver.findElement(By.xpath("//*[@id='next']")).click();
	}
	driver.findElement(By.xpath("//*[@text='" + date + "']")).click();
	break;
	case "December":
	for (int j = 0; j < 11; j++) {
	driver.findElement(By.xpath("//*[@id='next']")).click();
	}
	driver.findElement(By.xpath("//*[@text='" + date + "']")).click();
	break;
	}
	driver.findElement(By.xpath("//*[@text='OK']")).click(); 
	}

	public static AndroidDriver<WebElement> setUp() throws MalformedURLException {
		System.out.println("---- Setting Up Local Device ----");
		dc.setCapability("Platform", "Android");
		dc.setCapability(MobileCapabilityType.UDID, "RZ8N92DWFTX");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.freeu");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
		driver  = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("---- Successfully Connected To Local Device ----");
		return driver;  

	}
}

