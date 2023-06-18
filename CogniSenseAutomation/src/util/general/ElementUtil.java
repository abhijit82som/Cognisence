package util.general;

//import java.awt.Point;
import static java.lang.System.out;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.imageio.ImageIO;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import util.portalData;
import util.staticData;

//import com.ibm.icu.text.DateFormatSymbols;

public class ElementUtil {

	public static void writeMessageToLog(String message) {
		try {
			Field f = staticData.currentRunningScenario.getClass()
					.getDeclaredField("reporter");
			f.setAccessible(true);

			staticData.currentRunningScenario.write(message);
			staticData.currentRunningScenario.write("<br>");
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getUniqueFileName(String fileName, String moduleName) {
		String extnExculdedFileName = "";
		String fileExtn = "";
		String reportsFolder = util.excelDataProvider.getCellValueByFieldName(
				"Snap Shot Store Path", staticData.suitDataSheetName).trim()
				+ "_" + geturl();//abhijit1

		File theDir = new File(reportsFolder);

		// if the directory does not exist, create it
		if (!theDir.exists()) {
			out.println("creating directory in unique file name: "
					+ reportsFolder);
			boolean result = false;

			try {
				theDir.mkdir();
				result = true;
			} catch (SecurityException se) {
				out.println(" Directory not created for Reports in element Util");
			}
			if (result) {
				// DIR created
			}
		} else {
			// Report folder exists to keep reports
		}
		try {
			fileExtn = fileName.substring(fileName.lastIndexOf(".") + 1);

			extnExculdedFileName = fileName.substring(0,
					fileName.lastIndexOf("."));
			// Adding Module
			extnExculdedFileName += "_" + moduleName;

			// Calculating Time
			long currentTimeAsLong = System.currentTimeMillis();
			// Adding Time
			extnExculdedFileName = extnExculdedFileName.concat("_")
					.concat(Long.toString(currentTimeAsLong))
					.concat("." + fileExtn);

		} catch (ArrayIndexOutOfBoundsException e) {
			extnExculdedFileName = fileName;
			e.printStackTrace();
		}
		return extnExculdedFileName;
	}

	public static float compareSingleImage(String file1, String file2) {
		int pixelsThatMatched = 0;
		int pixelsThatDidNotMatched = 0;

		int currentPixelValueOfImage1 = 0;
		int currentPixelValueOfImage2 = 0;

		long percentageOfSimilarity = 0;

		try {
			File imageFile1 = new File(file1);
			BufferedImage image1 = ImageIO.read(imageFile1);
			int widthOfImage1 = image1.getWidth(null);
			int heightOfImage1 = image1.getHeight(null);
			int[][] pixelValuesOfImage1 = new int[widthOfImage1][heightOfImage1];
			
			File imageFile2 = new File(file2);
			BufferedImage image2 = ImageIO.read(imageFile2);
			int widthOfImage2 = image2.getWidth(null);
			int heightOfImage2 = image2.getHeight(null);
			int[][] pixelValuesOfImage2 = new int[widthOfImage2][heightOfImage2];

			boolean widthOfBothImagesAreSame = (widthOfImage1 == widthOfImage2) ? true
					: false;
			boolean heightOfBothImagesAreSame = (heightOfImage1 == heightOfImage2) ? true
					: false;

			if (!(widthOfBothImagesAreSame && heightOfBothImagesAreSame))
				return 0;

			for (int width = 0; width < widthOfImage1; width++) {
				for (int height = 0; height < heightOfImage1; height++) {
					currentPixelValueOfImage1 = image1.getRGB(width, height);
					currentPixelValueOfImage2 = image2.getRGB(width, height);

					if (currentPixelValueOfImage1 == currentPixelValueOfImage2)
						pixelsThatMatched = pixelsThatMatched + 1;
					else
						 pixelsThatDidNotMatched++;

						 if (width >= 30 && width <= 40 )
							  {
							 if (height >= 1200 && height <= 1300 ) 
								 pixelsThatDidNotMatched++;
							 }
				}
			}
			long totalPixels =  heightOfImage1 * widthOfImage1;
			percentageOfSimilarity = 100*pixelsThatMatched/totalPixels;
			return percentageOfSimilarity ;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public static File[] getAllFileNames(String directoryPath) {
		File folder = new File(directoryPath);
		File[] listOfFiles = folder.listFiles();
		Arrays.sort(listOfFiles,
				LastModifiedFileComparator.LASTMODIFIED_COMPARATOR);
		return listOfFiles;
	}
    public static String screenShot_err(WebDriver wd, String moduleName,String pageName)
            throws IOException {
     if(staticData.willTakeScreenShot)
     {
     String browserName = util.excelDataProvider.getCellValueByFieldName("Browser Under Test", staticData.suitDataSheetName);
     String platform = geturl();
     String reportsFolder=util.excelDataProvider.getCellValueByFieldName("Snap Shot Store Path",staticData.suitDataSheetName).trim()+"_"+geturl();
     File theDir = new File(reportsFolder);

       if (!theDir.exists()) {
         System.out.println("creating directory: " + reportsFolder);
         boolean result = false;

         try{
             theDir.mkdir();
             result = true;
          } catch(SecurityException se){
            System.out.println(" Directory not created for Screenshot in element Util");
          }        
          if(result) {    
          }
       }
       else
       {
              //Report folder exists to keep snaps
       }
     String filePath = theDir + File.separator+"Snap_"+geturl()+"_"+getDate("yyyy-MM-dd")+File.separator;
     filePath = filePath.concat(browserName);
     filePath = filePath.concat(File.separator);
     filePath = filePath.concat(platform);
     filePath = filePath.concat("_");
     filePath = filePath.concat((getDate("yyyy-MM-dd")));
     File screenshotDirectory = new File(filePath);
     if (!screenshotDirectory.exists()) {
         System.out.println("creating directory: " + screenshotDirectory);
         boolean result = false;

         try{
            screenshotDirectory.mkdir();
             result = true;
          } catch(SecurityException se){
            System.out.println(" Directory not created for Screenshot in element Util");
          }        
          if(result) {    
          }
       }
       else
       {
           }

     BufferedImage sourceImage = null;
     try {
            sourceImage = ImageIO
                         .read(((TakesScreenshot) staticData.sessionInstance)
                                       .getScreenshotAs(OutputType.FILE));
     } catch (IOException e1) {
            e1.printStackTrace();
     }

     File scrFile = ((TakesScreenshot) wd).getScreenshotAs(OutputType.FILE);
     String fileName = filePath + "/screenshot_err.jpeg";
     String uniqueFileName = getUniqueFileName(fileName, moduleName);
//   File fileImage = new File(uniqueFileName);
     FileUtils.copyFile(scrFile, new File(uniqueFileName));
     /*********************************************************************************/
     if (!ElementUtil.getBrowserType().toLowerCase().contains("ie"))
     {      
     
     String baseURL = staticData.sessionInstance.getCurrentUrl();
				/*
				 * Graphics2D g2d = (Graphics2D) sourceImage.getGraphics(); AlphaComposite
				 * alphaChannel = AlphaComposite.getInstance( AlphaComposite.SRC_OVER, 1.0f);
				 * g2d.setComposite(alphaChannel); g2d.setColor(Color.BLUE); g2d.setFont(new
				 * Font("Arial", Font.BOLD, 15)); FontMetrics fontMetrics =
				 * g2d.getFontMetrics(); Rectangle2D rect = fontMetrics.getStringBounds(baseURL,
				 * g2d); int centerX = 1; int centerY = 20;
				 */

				/*
				 * if (staticData.willEmbedURL) g2d.drawString(baseURL, centerX, centerY);
				 */
     File file1 = null;
     try {
            file1 = new File(uniqueFileName);
           // ImageIO.write(sourceImage, "jpg", file1);
     } catch (Exception e) {
            e.printStackTrace();
     }
    // g2d.dispose();
     ElementUtil.writeMessageToLog("<a href=\""+file1.getAbsolutePath()+"\""+"target="+"\""+"_blank"+"\""+">"+"Screenshot"+"</a>");
     }
     /*********************************************************************************/

     return uniqueFileName;
}
     return null;
}      

//8
	public static String getDate(String format) {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateNow = formatter.format(currentDate.getTime());
		return dateNow;
	}
//9
	public static void scrollToElement(By by) {
		Locatable element = (Locatable) staticData.sessionInstance
				.findElement(by);
		Point p = element.getCoordinates().inViewPort();
		JavascriptExecutor js = (JavascriptExecutor) staticData.sessionInstance;
		js.executeScript("window.scrollTo(" + p.getX() + "," + p.getY() + ");");
	}

	//10
	public static void mouseHoverToElement(By by) {
		WebElement element =  staticData.sessionInstance
				.findElement(by);
		Actions action = new Actions(staticData.sessionInstance);
		action.moveToElement(element).moveToElement(staticData.sessionInstance.findElement(By.id("newclmbtnid"))).click().build().perform();
		// new Actions(staticData.sessionInstance).moveToElement(element).perform();
	}
//11
	
	public static void clickImagelink(By by) {
		try {
		WebElement element =  staticData.sessionInstance.findElement(by);
		String tooltipText = element.getAttribute("title"); 
		//WebElement element = staticData.sessionInstance.findElement(By.xpath("//img[@class='item-thumb-img img-no-drag ng-scope']"));
		Actions action = new Actions(staticData.sessionInstance);
		action.moveToElement(element).click().build().perform();
		//action.moveToElement(element).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rightClick(By by) {
		try {
		WebElement element =  staticData.sessionInstance.findElement(by);
		//WebElement element = staticData.sessionInstance.findElement(By.xpath("//div[@x-dir-text='Event Table']//..//..//..//..//..//..//a[@title='More']"));
		Actions action = new Actions(staticData.sessionInstance);
		//action.moveToElement(element).click().build().perform();
		action.contextClick(element).perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean hibernate(WebDriver sessionInstance) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver sessionInstance) {

				return ((JavascriptExecutor) sessionInstance).executeScript(
						"return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(sessionInstance,
				Integer.parseInt(util.excelDataProvider
						.getCellValueByFieldName("Page Load Time",
								staticData.suitDataSheetName)));
		wait.until(pageLoadCondition);
		return false;
	}
//12
	public static void hibernate(Thread t) {
		try {
			Thread.sleep(Integer.parseInt(util.excelDataProvider
					.getCellValueByFieldName("Page Load Time",
							staticData.suitDataSheetName)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//13
	public static boolean hibernate(By by) {
		try {
			WebDriverWait wait = new WebDriverWait(staticData.sessionInstance,
					30);
			WebElement element = wait.until(ExpectedConditions
					.elementToBeClickable(by));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean hibernate(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(staticData.sessionInstance,
					30);
			WebElement anotherElement = wait.until(ExpectedConditions
					.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			// e.printStackTrace();
			return false;
		}
	}

	public static boolean isElementPresentBy(By by, WebDriver sessionInstance) {
		try {
			sessionInstance.findElement(by);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
//16
	public static boolean isElementPresentByid(String elementID) {
		try {
			staticData.sessionInstance.findElement(By.id(elementID));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
//17
	public static boolean isElementPresentByLinkText(String linkText) {
		try {
			staticData.sessionInstance.findElement(By.linkText(linkText));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
//18
	public static boolean isElementPresentByName(String fieldName) {
		try {
			staticData.sessionInstance.findElement(By.name(fieldName));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
//19
	public static boolean isElementPresentByPartialLinkText(String localID) {
		try {
			staticData.sessionInstance.findElement(By.partialLinkText(localID
					.trim()));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
//-----------------------------------------Abhijit Som----------------------------------------------------
	public static String popupNavigator() {

		Set<String> winIDs = staticData.sessionInstance.getWindowHandles();
		Iterator<String> it = winIDs.iterator();
		String mainwindowID = null; // main window ID
		String popupwindowID = null;
		winIDs = staticData.sessionInstance.getWindowHandles();
		it = winIDs.iterator();

		while (it.hasNext()) {
			mainwindowID = it.next(); // main window ID
			popupwindowID = it.next(); // pop-up window ID
		}
		try {
			staticData.sessionInstance.switchTo().window(popupwindowID);
			util.general.ElementUtil.hibernate(staticData.sessionInstance);
            Thread.sleep(5000);
			return staticData.sessionInstance.getTitle();

		} catch (Exception e) {
			return null;
		}

	}
  //-----------------------------------------Abhijit Som----------------------------------------------------
	public static void focusOnPage(String pageName) {
			
		Set<String> winIDs = staticData.sessionInstance.getWindowHandles();
		Iterator<String> it = winIDs.iterator();
		String mainwindowID = null; // main window ID
		String popupwindowID = null;
		winIDs = staticData.sessionInstance.getWindowHandles();
		it = winIDs.iterator();

		while (it.hasNext()) {
			mainwindowID = it.next(); // main window ID
			popupwindowID = it.next(); // pop-up window ID
		}
		try {
			staticData.sessionInstance.switchTo().window(popupwindowID).close();
			staticData.sessionInstance.switchTo().window(mainwindowID);
	        } catch (Exception e) {
				e.getStackTrace();
			}
	}
		public static void focusOnParentPage(String pageName) {
			
			Set<String> winIDs = staticData.sessionInstance.getWindowHandles();
			Iterator<String> it = winIDs.iterator();
			String mainwindowID = null; // main window ID
			String popupwindowID = null;
			winIDs = staticData.sessionInstance.getWindowHandles();
			it = winIDs.iterator();
			try {
			while (it.hasNext()) {
				mainwindowID = it.next(); // main window ID
				popupwindowID = it.next();	
				staticData.sessionInstance.switchTo().window(popupwindowID).close();
				staticData.sessionInstance.switchTo().window(mainwindowID).close();
			      }
		
				
				  } catch (Exception e) {
					  staticData.sessionInstance.switchTo().window(mainwindowID).close();
					//  e.getStackTrace();
				}	
	}
		
		public static void focusOnChildPage(String pageName) {
			
			Set<String> winIDs = staticData.sessionInstance.getWindowHandles();
			Iterator<String> it = winIDs.iterator();
			String mainwindowID = null; // main window ID
			String popupwindowID = null;
			winIDs = staticData.sessionInstance.getWindowHandles();
			it = winIDs.iterator();
			try {
			while (it.hasNext()) {
				mainwindowID = it.next(); // main window ID
				popupwindowID = it.next()	;
				if (popupwindowID!= "null")
				{
				staticData.sessionInstance.switchTo().window(popupwindowID).close();
				staticData.sessionInstance.switchTo().window(mainwindowID).close();
				}
				}
			staticData.sessionInstance.switchTo().window(mainwindowID);
			
			  } catch (Exception e) {
				  staticData.sessionInstance.switchTo().window(mainwindowID).close();
				  staticData.sessionInstance = null;
			}	
}

	public static String trimmedTitle(String title) {
		title = title.substring(title.indexOf(" | ") + 3, title.length());
		out.println("title : " + title);
		return title;
	}


	public static boolean switchToWindow( String pageName )
    {
          
          Set<String> winIDs = staticData.sessionInstance.getWindowHandles();
          Iterator<String> it = winIDs.iterator();
          String mainwindowID = null; // main window ID
          String popupwindowID = null;
          winIDs = staticData.sessionInstance.getWindowHandles();
          it = winIDs.iterator();

          while (it.hasNext()) {
               mainwindowID = it.next(); // main window ID
               popupwindowID = it.next(); // pop-up window ID
          }
          staticData.sessionInstance.manage().window().maximize();
          staticData.sessionInstance.switchTo().window(popupwindowID);    
          staticData.sessionInstance.manage().window().maximize();
          util.general.ElementUtil.hibernate( staticData.sessionInstance );
             boolean pagettl = pageName.contains( ElementUtil.trimmedTitle(staticData.sessionInstance.getTitle()));
             System.out.println("current page title : " + staticData.sessionInstance.getTitle());
             System.out.println("pageName : " +pageName);
           if( pagettl )
               {
                   staticData.isPopupPresent = true;
                        return pagettl;
               }
               else
               {               //ElementUtil.writeMessageToLog("Page Status : "+ isPageOK());
                   if (!pageName.equalsIgnoreCase("BLANK")) {
                       staticData.sessionInstance.switchTo().window(popupwindowID).close();
                       staticData.sessionInstance.switchTo().window(mainwindowID);
                       

                                                                }
                   pagettl = true;
                   staticData.isPopupPresent = true;
                   return pagettl;
               }
          }
	public static boolean TESTswitchToWindow( String pageName )
    {
      try{
        	Thread.sleep(5000);
        }catch(Exception e){
        	
        }
     Set<String> winHandleBefore = staticData.sessionInstance.getWindowHandles();
     Set<String> windowId = staticData.sessionInstance.getWindowHandles();
     Iterator<String> itererator = windowId.iterator();
     
     String mainWinID = itererator.next();
     String newAdwinID = itererator.next();
     staticData.sessionInstance.switchTo().window(newAdwinID);
      
      System.out.println(staticData.sessionInstance.switchTo().activeElement().getText());
      System.out.println(staticData.sessionInstance.manage().window().getSize());
		System.out.println("secessionIn ************************************************" +staticData.sessionInstance.getTitle());
		System.out.println(staticData.sessionInstance.switchTo().defaultContent().getWindowHandles().size());
		System.out.println("secessionIn ************************************************" +staticData.sessionInstance.getTitle());

		return true;
          }                                          

		public static boolean isPageOK() {
		try {
			WebElement element = staticData.sessionInstance.findElement(By
					.tagName("html"));
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet();
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() != 200) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
//28
	public static boolean switchToWindowForClosing(String pageName) {
		ElementUtil.hibernate(Thread.currentThread());

		Set<String> winIDs = staticData.sessionInstance.getWindowHandles();
		Iterator<String> it = winIDs.iterator();
		String mainwindowID = null; // main window ID
		String popupwindowID = null;
		winIDs = staticData.sessionInstance.getWindowHandles();
		it = winIDs.iterator();

		while (it.hasNext()) {
			mainwindowID = it.next(); // main window ID
			popupwindowID = it.next(); // pop-up window ID
		}

		staticData.sessionInstance.switchTo().window(popupwindowID);
		util.general.ElementUtil.hibernate(staticData.sessionInstance);

		if (staticData.sessionInstance.getTitle().contains(pageName)) {
			staticData.sessionInstance.switchTo().window(popupwindowID);
			staticData.sessionInstance.switchTo().window(popupwindowID).close();
			staticData.sessionInstance.switchTo().window(mainwindowID);
			return true;
		} else
			return false;
	}

	public static boolean isPopUpPresent() {
		try {
			ElementUtil.hibernate(Thread.currentThread());

			Set<String> winIDs = staticData.sessionInstance.getWindowHandles();
			Iterator<String> it = winIDs.iterator();
			String mainwindowID = null; // main window ID
			String popupwindowID = null;
			winIDs = staticData.sessionInstance.getWindowHandles();
			it = winIDs.iterator();

			while (it.hasNext()) {
				mainwindowID = it.next(); // main window ID
				popupwindowID = it.next(); // pop-up window ID
			}

			return true;

		} catch (Exception e) {
			return false;
		}
	}
//30
	/*
	 * public static boolean popupNavigatorForClosingWindow(String pageName) {
	 * String mainwindowID = null; // main window ID String popupwindowID = null;
	 * boolean gotActualPopup = false; staticData.isPopupPresent = false; try {
	 * ElementUtil.hibernate(Thread.currentThread());
	 * 
	 * Set<String> winIDs = staticData.sessionInstance.getWindowHandles();
	 * Iterator<String> it = winIDs.iterator();
	 * 
	 * winIDs = staticData.sessionInstance.getWindowHandles(); it =
	 * winIDs.iterator();
	 * 
	 * while (it.hasNext()) { mainwindowID = it.next(); // main window ID
	 * popupwindowID = it.next(); // pop-up window ID }
	 * 
	 * staticData.sessionInstance.switchTo().window(popupwindowID);
	 * util.general.ElementUtil.hibernate(staticData.sessionInstance);
	 * staticData.elementUtil.screenShot_err(staticData.sessionInstance,
	 * "portal.jpg", ElementUtil.geturl());
	 * 
	 * if (staticData.sessionInstance.getCurrentUrl().endsWith(".pdf")) try {
	 * validatePageError(); readPdf(staticData.sessionInstance.getCurrentUrl());
	 * 
	 * } catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * if (staticData.sessionInstance.getTitle().contains(pageName)) {
	 * out.println(" Switching to popup for closing ");
	 * staticData.sessionInstance.switchTo().window(popupwindowID);
	 * staticData.sessionInstance.switchTo().window(popupwindowID) .close();
	 * out.println(" closed the popup ");
	 * 
	 * staticData.sessionInstance.switchTo().window(mainwindowID); gotActualPopup =
	 * true; } else { staticData.sessionInstance.switchTo().window(popupwindowID);
	 * staticData.sessionInstance.switchTo().window(popupwindowID) .close();
	 * staticData.sessionInstance.switchTo().window(mainwindowID); gotActualPopup =
	 * false;
	 * 
	 * } return gotActualPopup; } catch (Exception e) { // e.printStackTrace();
	 * String identifierType = null; String identifierValue = null; try {
	 * identifierType = util.excelDataProvider
	 * .getEnvironmentDetailsForSuit(pageName, staticData.pomSheetName,
	 * staticData.needFieldIdentifier); identifierValue = util.excelDataProvider
	 * .getEnvironmentDetailsForSuit(pageName, staticData.pomSheetName,
	 * staticData.needFieldValue); out.println("identifierType : " +
	 * identifierType); out.println("identifierValue : " + identifierValue); } catch
	 * (Exception edf) { // This is a false try-catch block provided intentionally .
	 * // When the code tries to find an link which may not present for // this user
	 * in the excel ,a exception gets generated due to // unavailability of the link
	 * in Excel. } try { ElementUtil.focusOnElement(identifierType, identifierValue)
	 * .click();
	 * 
	 * } catch (NullPointerException e2) {
	 * staticData.sessionInstance.switchTo().window(popupwindowID);
	 * staticData.sessionInstance.switchTo().window(popupwindowID) .close();
	 * staticData.sessionInstance.switchTo().window(mainwindowID); gotActualPopup =
	 * false;
	 * 
	 * } return true; } }
	 */
//31
	public static void validatePageError() {
		boolean errorInTitle = staticData.sessionInstance.getTitle().contains(
				"Error")
				|| staticData.sessionInstance.getTitle().contains(
						"Page Not Available")
				|| staticData.sessionInstance.getTitle().contains("Sign In")
				|| staticData.sessionInstance.getTitle().contains(
						"Session Expired")
				|| staticData.sessionInstance.getTitle().contains(
						"Can not process Your Request")
				|| staticData.sessionInstance.getTitle().contains("404");
		boolean errorInPage = staticData.sessionInstance.getPageSource()
				.contains("Error")
				|| staticData.sessionInstance.getPageSource().contains(
						"Page Not Available")
				|| staticData.sessionInstance.getPageSource().contains(
						"Sign In")
				|| staticData.sessionInstance.getPageSource().contains(
						"Session Expired")
				|| staticData.sessionInstance.getPageSource().contains(
						"Can not process Your Request")
				|| staticData.sessionInstance.getPageSource().contains("404");

		if (errorInTitle || errorInPage)
			ElementUtil.writeMessageToLog("WARNING : "
					+ staticData.sessionInstance.getCurrentUrl()
					+ "Having issues : **********   NOT FOUND ***********");
	}
//32
	public static String getBrowserType() {
		return util.excelDataProvider.getCellValueByFieldName(
				"Browser Under Test", staticData.suitDataSheetName);
	}
//33
	public static String geturl() {
		return staticData.enviormentUnderTest;
	}
//34
	public static String getPlatform() {
		return geturl();

	}
//35
	public static WebElement focusOnElement(String identifierType,
			String identifierValue) {
		WebElement webElement = null;

		identifierType = identifierType.trim();
		identifierValue = identifierValue.trim();

		try {
			if (identifierType.equalsIgnoreCase("ID"))
				webElement = staticData.sessionInstance.findElement(By
						.id(identifierValue));
			if (identifierType.equalsIgnoreCase("Name"))
				webElement = staticData.sessionInstance.findElement(By
						.name(identifierValue));
			if (identifierType.equalsIgnoreCase("className"))
				webElement = staticData.sessionInstance.findElement(By
						.className(identifierValue));
			if (identifierType.equalsIgnoreCase("cssSelector"))
				webElement = staticData.sessionInstance.findElement(By
						.cssSelector(identifierValue));
			if (identifierType.equalsIgnoreCase("linkText"))
				webElement = staticData.sessionInstance.findElement(By
						.linkText(identifierValue));
			if (identifierType.equalsIgnoreCase("partialLinkText"))
				webElement = staticData.sessionInstance.findElement(By
						.partialLinkText(identifierValue));
			if (identifierType.equalsIgnoreCase("tagName"))
				webElement = staticData.sessionInstance.findElement(By
						.tagName(identifierValue));
			if (identifierType.equalsIgnoreCase("xpath"))
				webElement = staticData.sessionInstance.findElement(By
						.xpath(identifierValue));
			return webElement;

		} catch (Exception e) {
			return null;
		}

	}
//36
	public static WebElement operateOnElement(String expectedValue,
			String desiredSection) {
		String identifierType = null;
		String identifierValue = null;

		try {
			identifierType = util.excelDataProvider
					.getEnvironmentDetailsForSuit(desiredSection,
							staticData.pomSheetName,
							staticData.needFieldIdentifier);
			identifierValue = util.excelDataProvider
					.getEnvironmentDetailsForSuit(desiredSection,
							staticData.pomSheetName, staticData.needFieldValue);
		} catch (Exception e) {
			// This is a false try-catch block provided intentionally .
			// When the code tries to find an link which may not present for
			// this user in the excel ,a exception gets generated due to
			// unavailability of the link in Excel.
		}
		return focusOnElement(identifierType, identifierValue);
	}
//37
	public static void deleteAllTempFiles() {
		try {
			File tempFile = File.createTempFile("MyTempFile", ".tmp");
			File tempDirectory = tempFile.getParentFile();
			File[] allTempFiles = tempDirectory.listFiles();
			for (File f : allTempFiles)
				try {
					f.delete();
				} catch (Exception e) {
					// TODO: handle exception
				}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
//38
	public static void closeBrowser() {
		try {
			try {
				try {
					focusOnElement("id", "signoff").click();
				} catch (Exception e) {
					JavascriptExecutor js = (JavascriptExecutor) staticData.sessionInstance;
					js.executeScript("return document.getElementById('signoff').click()");
				}
				if (staticData.sessionInstance.getTitle().equals("Web Survey")) {
					staticData.sessionInstance.findElement(
							By.xpath("//input[@value='Cancel']")).click();

					ElementUtil
							.writeMessageToLog(" PASS     : Web Survey page appeared for this user after Logging out from Portal. Check Manual");
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
			Set<String> winIDs = staticData.sessionInstance.getWindowHandles();
			for (Iterator iterator = winIDs.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				try {
					staticData.sessionInstance.switchTo().window(string)
							.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
/**/			staticData.sessionInstance = null;
		} catch (Exception e) {

		}

	}
//39
	public static boolean verifyimageActive(WebElement imgElement) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			out.println("response.getStatusLine().getStatusCode("
					+ response.getStatusLine().getStatusCode());
			if (response.getStatusLine().getStatusCode() != 200) {
				// / ElementUtil.writeMessageToLog("Image Doesnot Exists");
				return false;
			} else
				return true;
			// return false;
		} catch (Exception e) {
			return false;
		}
	}
//40
		public static void scrollToElement(WebElement wEle) {
		Locatable element = (Locatable) wEle;
		Point p = element.getCoordinates().inViewPort();
		JavascriptExecutor js = (JavascriptExecutor) staticData.sessionInstance;
		js.executeScript("window.scrollTo(" + p.getX() + "," + p.getY() + ");");
	}
//44
	public static String[] getFutureDate(String choice) {
		String tomorrow[] = { "", "", "" };
		String dateString = getDate("yyyy-MM-dd");
		DateTimeFormatter parser = ISODateTimeFormat.date();
		DateTime date = parser.parseDateTime(dateString);
		String nextDay = parser.print(date.plusDays(1));
		String nextDayString = nextDay.toString();
		tomorrow = nextDayString.split("-");
		tomorrow[1] = getMonth(Integer.parseInt(tomorrow[1])).substring(0, 3);
		return tomorrow;
	}
//45
	public static String getMonth(int month) {
		return new DateFormatSymbols().getMonths()[month - 1];
	}
//46
	public static boolean clickOnLastBreadcrumb() {
		try {
			staticData.sessionInstance.findElement(
					By.xpath(".//*[@id='menubarAbbrv'][last()]")).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	//47
	public static boolean createScenario( String file1,String[] data ,int toRemove )
	{
		try {
			File tmp = File.createTempFile("tmp", "");
		    BufferedReader br = new BufferedReader(new FileReader(file1));
		    BufferedWriter bw = new BufferedWriter(new FileWriter(tmp));
		    for (int i = 0; i < toRemove-1; i++)
		        bw.write(String.format("%s%n", br.readLine()));
		    for (int i = 0; i < data.length; i++)
		    	bw.write(data[i]);
		    br.close();
		    bw.close();
		    File oldFile = new File(file1);
		    if (oldFile.delete())
		        tmp.renameTo(oldFile);
			return true;
 
		} catch (Exception e) {
			return false;
		}
	}
	//48
	public static boolean createScenarioOutline( String file1 ,String data,int lineNumber)
	{
		try {
			 PrintWriter writer = new PrintWriter(new FileWriter(new File(file1))); 

			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public static int countOfElement(String identifierType,
			String identifierValue) {
		int elementCount = 0;
		List<WebElement> webElement = null;
		identifierType = identifierType.trim();
		identifierValue = identifierValue.trim();
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			if (identifierType.equalsIgnoreCase("ID"))
			{
				webElement = staticData.sessionInstance.findElements(By
						.id(identifierValue));
				elementCount = webElement.size();
			}	
			if (identifierType.equalsIgnoreCase("Name"))
			{
				webElement = staticData.sessionInstance.findElements(By
						.name(identifierValue));
				elementCount = elementCount = webElement.size();
			}
			if (identifierType.equalsIgnoreCase("className"))
			{
				webElement = staticData.sessionInstance.findElements(By
						.className(identifierValue));
				elementCount = elementCount = webElement.size();
			}
			if (identifierType.equalsIgnoreCase("cssSelector"))
			{
				webElement = staticData.sessionInstance.findElements(By
						.cssSelector(identifierValue));
				elementCount = elementCount = webElement.size();
			}
			if (identifierType.equalsIgnoreCase("linkText"))
			{
				webElement = staticData.sessionInstance.findElements(By
						.linkText(identifierValue));
				elementCount = elementCount = webElement.size();
			}
			if (identifierType.equalsIgnoreCase("partialLinkText"))
			{
				webElement = staticData.sessionInstance.findElements(By
						.partialLinkText(identifierValue));
				elementCount = elementCount = webElement.size();
			}
			if (identifierType.equalsIgnoreCase("tagName"))
			{
				webElement = staticData.sessionInstance.findElements(By
						.tagName(identifierValue));
				elementCount = elementCount = webElement.size();
			}
			if (identifierType.equalsIgnoreCase("xpath"))
			{
				webElement = staticData.sessionInstance.findElements(By
						.xpath(identifierValue));
				elementCount = elementCount = webElement.size();
			}
			return elementCount;

		} catch (Exception e) {
			return 0;
		}
	}

		public static String getext(String identifierType,
				String identifierValue) {
			String elementtext = "";
			WebElement webElement = null;
			identifierType = identifierType.trim();
			identifierValue = identifierValue.trim();
	        try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
				if (identifierType.equalsIgnoreCase("ID"))
				{
					webElement = staticData.sessionInstance.findElement(By
							.id(identifierValue));
					elementtext = webElement.getText();
				}	
				if (identifierType.equalsIgnoreCase("Name"))
				{
					webElement = staticData.sessionInstance.findElement(By
							.name(identifierValue));
					 elementtext = webElement.getText();
				}
				if (identifierType.equalsIgnoreCase("className"))
				{
					webElement = staticData.sessionInstance.findElement(By
							.className(identifierValue));
					elementtext = webElement.getText();
				}
				if (identifierType.equalsIgnoreCase("cssSelector"))
				{
					webElement = staticData.sessionInstance.findElement(By
							.cssSelector(identifierValue));
					elementtext = webElement.getText();
				}
				if (identifierType.equalsIgnoreCase("linkText"))
				{
					webElement = staticData.sessionInstance.findElement(By
							.linkText(identifierValue));
					elementtext = webElement.getText();
				}
				if (identifierType.equalsIgnoreCase("partialLinkText"))
				{
					webElement = staticData.sessionInstance.findElement(By
							.partialLinkText(identifierValue));
					elementtext  = webElement.getText();
				}
				if (identifierType.equalsIgnoreCase("tagName"))
				{
					webElement = staticData.sessionInstance.findElement(By
							.tagName(identifierValue));
					elementtext  = webElement.getText();
				}
				if (identifierType.equalsIgnoreCase("xpath"))
				{
					webElement = staticData.sessionInstance.findElement(By
							.xpath(identifierValue));
					elementtext = webElement.getText();
				}
				return elementtext;

			} catch (Exception e) {
				return null;
			}	
		
	}
}
