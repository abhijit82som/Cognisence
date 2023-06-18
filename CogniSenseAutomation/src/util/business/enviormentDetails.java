package util.business;

import junit.framework.Assert;
import gherkin.lexer.Id;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.staticData;
import util.general.ElementUtil;

public class enviormentDetails {

	public static String[] connURL()
	{
		String urlList = util.excelDataProvider.getCellValueByFieldName("URL", staticData.suitDataSheetName);
		String sepUrl[]=urlList.split("~");
	    return sepUrl;
	}
	public static String redirectUrl(String url )
	{
		String urlList = new String();
		String mainurl="jdbc:oracle:thin:@";
		String dbUrl = util.excelDataProvider.getEnvironmentDetailsForSuit ( url , staticData.needFieldValue);
		String portalURL = util.excelDataProvider.getEnvironmentDetailsForSuit ( url , staticData.needFieldIdentifier);
		return portalURL + "~" + dbUrl;
	}






	public static void pptsignin()	throws Exception
	{
    	    util.general.ElementUtil.hibernate(Thread.currentThread());  
    	    String username = util.excelDataProvider.getCellValueByFieldName("UserName",staticData.suitDataSheetName);
			String password = util.excelDataProvider.getCellValueByFieldName("Password",staticData.suitDataSheetName);
			
			staticData.sessionInstance.findElement(By.name("username")).sendKeys(username);
			staticData.sessionInstance.findElement(By.name("pwd")).sendKeys( password );
			staticData.sessionInstance.findElement(By.id("loginbtn")).click();
			util.general.ElementUtil.hibernate  ( Thread.currentThread());
						
	}
	
}
