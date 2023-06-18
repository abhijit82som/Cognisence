package stepDefinition;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.By;

import util.staticData;
import util.general.ElementUtil;
import util.general.driver;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

public class Login {
	
	
	@Given("^User navigates to login page\\.$")
	public void user_opens_the_login_page() throws Throwable {
		try {
			if(!staticData.sessionInstance.getTitle().contains("Sign In") )
			{
				if(staticData.sessionInstance != null )
				{
					staticData.sessionInstance.get(util.business.enviormentDetails.connURL()[0]);
				}
				else
					driver.initializeUrl();	
			}
			else
			{
                if(ElementUtil.focusOnElement("xPath", ".//*[@id='dialog']") != null)
                {
                	//ElementUtil.writeMessageToLog("Exception generated from the scenario : " + staticData.currentrunningScenarioName);
                    //ElementUtil.writeMessageToLog(ElementUtil.focusOnElement("xPath", ".//*[@id='dialog']").getText());
                }
				driver.initializeUrl();	
			}
			
		} catch (Exception e) {
			driver.initializeUrl();		
			}
		
	}
	
	@Given("^The User has logged in to portal as \"([^\"]*)\"\\.$")
	public void the_User_has_logged_in_to_portal_as(String userType) throws Throwable {
								try {
									if(staticData.sessionInstance == null || staticData.sessionInstance.getTitle().contains("Qlik Sense login page") )
									{
						
										try {
											if(staticData.sessionInstance.getTitle().contains("Qlik Sense login page"))	
												 driver.initializeUrl();		
						
										} catch (Exception e) {
											 driver.initializeUrl();		
										}	
						
									
										if ( userType.contains("Participant"))
										{
									if(staticData.sessionInstance.getTitle().contains("Qlik Sense login page"))
						    		ElementUtil.focusOnElement("xpath", "//*[@id='details-button']").click();
									ElementUtil.focusOnElement("xpath", "//*[@id='details-button']").click();
									ElementUtil.focusOnElement("xpath", "//*[@id='proceed-link']").click();
									
									util.business.enviormentDetails.pptsignin();
										}
										}else
										{
											if ( userType.contains("Participant"))
											{
												driver.initializeUrl();		
										if(staticData.sessionInstance.getTitle().contains("Qlik Sense login page"))
							    		ElementUtil.focusOnElement("xpath", "//*[@id='details-button']").click();
										ElementUtil.focusOnElement("xpath", "//*[@id='details-button']").click();
										ElementUtil.focusOnElement("xpath", "//*[@id='proceed-link']").click();
										
										util.business.enviormentDetails.pptsignin();
										}
										}
									
						
								} catch (Exception e) {
									try {
										if(staticData.sessionInstance.getTitle().contains("Qlik Sense login page"))	
											 driver.initializeUrl();		
						
									} catch (Exception esd) {
										 driver.initializeUrl();	
										//System.out.println(staticData.sessionInstance.getPageSource());
									}	

								
									if ( userType.contains("Participant"))
									{
										if(staticData.sessionInstance.getTitle().contains("Qlik Sense login page"))
								    		//util.business.enviormentDetails.pptsignin();
											if ( userType.contains("Participant"))
											{
												driver.initializeUrl();
										if(staticData.sessionInstance.getTitle().contains("Qlik Sense login page"))
							    		ElementUtil.focusOnElement("xpath", "//*[@id='details-button']").click();
										ElementUtil.focusOnElement("xpath", "//*[@id='details-button']").click();
										ElementUtil.focusOnElement("xpath", "//*[@id='proceed-link']").click();
										
										util.business.enviormentDetails.pptsignin();
											}
										//	}
									}
						
								}
		
		/*
		 * try { Cookie cookiesList =
		 * staticData.sessionInstance.manage().getCookieNamed("JSESSIONID"); String
		 * cookieValue = cookiesList.toString(); staticData.loginNode =
		 * cookieValue.substring(36, 50); System.out.println("lllllllllllllllllllll"); }
		 * catch (Exception e) { staticData.loginNode = null; }
		 */
		 }
}