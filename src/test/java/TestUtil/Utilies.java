
package TestUtil;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Utilies {

	public static AndroidDriver<WebElement> androidDriver;
	static DesiredCapabilities dc = new DesiredCapabilities();
	
	public static AndroidDriver<WebElement> setUp() throws MalformedURLException {
		System.out.println("---- Setting Up Local Device ----");
		dc.setCapability("Platform", "Android");
		dc.setCapability(MobileCapabilityType.UDID, "RZ8N92DWFTX");
		dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.freeu");
		dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".MainActivity");
		dc.setCapability(MobileCapabilityType.NO_RESET, true);
		androidDriver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
		androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("---- Successfully Connected To Local Device ----");
		return androidDriver;  

	}  
}
