	package util.general;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import util.staticData;

public class driver {
	
	public static void initializeUrl()
	{
	try {
		if(staticData.sessionInstance.getTitle().contains("Sign In") )
			System.out.println("Logging in to the portal");

	} catch (Exception e) {
		staticData.sessionInstance = util.general.driver.initializeBrowser (ElementUtil.getBrowserType());
	}
	staticData.sessionInstance.get(util.business.enviormentDetails.connURL()[0]);	
    
	}
	public static WebDriver initializeBrowser(String browserType)
	{
		WebDriver wd = null;
		if ("chrome".equalsIgnoreCase(browserType))
		{
			System.setProperty("webdriver.chrome.driver",util.excelDataProvider.getCellValueByFieldName("Chrome Driver Path", staticData.suitDataSheetName));
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("disable-popup-blocking");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			wd = new ChromeDriver(capabilities);
		}
		else if ("firefox".equalsIgnoreCase(browserType))
		{
			FirefoxProfile profile = new FirefoxProfile();
      profile.setAcceptUntrustedCertificates(true);
      wd= new FirefoxDriver();
		}
		else if ("ie".equalsIgnoreCase(browserType))
		{
			System.setProperty("webdriver.ie.driver",util.excelDataProvider.getCellValueByFieldName("IE Driver Path", staticData.suitDataSheetName));

			DesiredCapabilities ieCapabilities = DesiredCapabilities
					.internetExplorer();
			ieCapabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			ieCapabilities.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,false);
            ieCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			ieCapabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING,true);

            ieCapabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.DISMISS);
			ieCapabilities.setCapability("requireWindowFocus", true);
			ieCapabilities.setCapability("enablePersistentHover", false); 
			
			try {
				ieCapabilities.setVersion("11");
				String Version= ieCapabilities.getVersion();
			    System.out.println("IE Version : " + Version);
			} catch (Exception e) {
				// TODO: handle exception
			}
			wd = new InternetExplorerDriver(ieCapabilities);
			

		}
		else if ("Shadow".equalsIgnoreCase(browserType))
		{
			try {
			
				LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log",
						"org.apache.commons.logging.impl.NoOpLog");
				java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit")
						.setLevel(Level.OFF);
				java.util.logging.Logger.getLogger("org.apache.commons.httpclient")
						.setLevel(Level.OFF);

				DesiredCapabilities capabilities = DesiredCapabilities.htmlUnitWithJs(); 
				capabilities.setJavascriptEnabled(true);
				wd = new HtmlUnitDriver(capabilities); 	
      			staticData.sessionInstance = wd;	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		wd.manage().window().maximize();
		return wd;
	}
	
	
}
