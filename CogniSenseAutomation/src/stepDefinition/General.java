package stepDefinition;
import gherkin.lexer.El;
import hudson.util.IOUtils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Stream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.dbunit.Assertion;
//import org.dbunit.dataset.AbstractDataSetTest;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.Columns;
import org.dbunit.dataset.DataSetUtils;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
//import org.dbunit.testutil.TestUtils;
import org.dbunit.dataset.excel.XlsDataSet;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.isA;
import org.dbunit.dataset.*;
import junit.framework.Assert;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
//import org.testng.PendingException;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.asserts.Assertion;

import com.google.common.net.InetAddresses.TeredoInfo;

import bad.robot.excel.matchers.WorkbookMatcher;
import ch.qos.logback.core.boolex.Matcher;
import util.excelDataProvider;
import util.excelReader;
//import test.AcclarisJenkinsReportPlugin;
import util.staticData;
import util.general.ElementUtil;
import util.general.driver;
import cucumber.api.PendingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SuppressWarnings("unused")
public class General {
    @Before
    public void beforeScenario(Scenario scenario  ) {
          //Feature f 
         staticData.currentrunningScenarioName = scenario.getName();
         staticData.currentRunningScenario = scenario;
         staticData.currentRunningScenario.getClass();
         System.out.println("aaaa");
                }

    @After(order=0)
    public void afterScenario(Scenario scenario) {
          Field f;
          try {
               f = scenario.getClass().getDeclaredField("reporter");
               f.setAccessible(true);

          } catch (NoSuchFieldException | SecurityException e) {
                  }
    }
    @After(order=1)
    public void afterScenarioFinish()
    {
    	 try {
    	ElementUtil.writeMessageToLog("-------------------------------------------------------------------------------------------End of Scenario-------------------------------------------------------------------------------------------");
    	String expectedPageTitle =util.excelDataProvider.getEnvironmentDetailsForSuit("search page",staticData.
    			  commonVariablesName,staticData.needFieldIdentifier);
    	ElementUtil.focusOnPage(expectedPageTitle);
    	String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit("close",staticData.pomSheetName,staticData.needFieldIdentifier);
    	String   identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit("close",staticData.pomSheetName,staticData.needFieldValue);
    	ElementUtil.focusOnElement(identifierType, identifierValue).click();
    	 } catch (Exception e) {
         }
    	
    }	
    
    
    @When("^The User Clicks on \"([^\"]*)\" option\\.$")
     public void the_User_Clicks_on_option(String buttonName) throws Throwable {
    	  try {
    		 // Given ("The User has logged in to portal as Participant.");
   String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(buttonName,staticData.pomSheetName,staticData.needFieldIdentifier);
   String   identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(buttonName,staticData.pomSheetName,staticData.needFieldValue);    
   if(ElementUtil.focusOnElement(identifierType, identifierValue) != null)
   {
	   	   ElementUtil.focusOnElement(identifierType, identifierValue).click();
	   
   }else {
	  // staticData.sessionInstance.findElement(By.xpath("//div[@class='qv-details-wrap']")).click();
	  System.out.println(staticData.sessionInstance.getTitle());
	 // ElementUtil.focusOnElement(identifierType, identifierValue).click();
	  staticData.sessionInstance.findElement(By.xpath("//div[@class='qv-details-wrap']")).click();
	  //throw new PendingException(" The button :" + buttonName + "  with id : " + identifierValue + " is not present in :" + staticData.sessionInstance.getTitle() + " Page");
	  ElementUtil.focusOnPage(staticData.sessionInstance.getTitle());
   }
    	  }catch (Exception e) {
    		  staticData.elementUtil.screenShot_err(staticData.sessionInstance,"portal.jpg", ElementUtil.geturl());
    		  ElementUtil.focusOnPage(staticData.sessionInstance.getTitle());
    		  throw new Exception("The user not able to click on "+buttonName+ " button as "+ buttonName+" button is not present in : "+ staticData.sessionInstance.getTitle() + " Page or Page element got changed. ");
	    }
   }

    @When("^The User Right Clicks on \"([^\"]*)\" option\\.$")
    public void the_User_Right_Clicks_on_option(String linkName) throws Throwable {

    	 String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(linkName,staticData.pomSheetName,staticData.needFieldIdentifier);
    	 String  identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(linkName,staticData.pomSheetName,staticData.needFieldValue);    
    	 try {
 			if (identifierType.equalsIgnoreCase("ID"))
 				ElementUtil.rightClick(By.id(identifierValue));
 			if (identifierType.equalsIgnoreCase("Name"))
 				ElementUtil.rightClick(By.name(identifierValue));
 			if (identifierType.equalsIgnoreCase("className"))
 				ElementUtil.rightClick(By.className(identifierValue));
 			if (identifierType.equalsIgnoreCase("cssSelector"))
 				ElementUtil.rightClick(By.cssSelector(identifierValue));
 			if (identifierType.equalsIgnoreCase("linkText"))
 				ElementUtil.rightClick(By.linkText(identifierValue));
 			if (identifierType.equalsIgnoreCase("partialLinkText"))
 				ElementUtil.rightClick(By.partialLinkText(identifierValue));
 			if (identifierType.equalsIgnoreCase("tagName"))
 				ElementUtil.rightClick(By.tagName(identifierValue));
 			if (identifierType.equalsIgnoreCase("xpath"))
 				ElementUtil.rightClick(By.xpath(identifierValue));
    } catch (Exception e) {
    	staticData.elementUtil.screenShot_err(staticData.sessionInstance,"portal.jpg", ElementUtil.geturl());
    	ElementUtil.focusOnPage(staticData.sessionInstance.getTitle());
       	throw new Exception("The user not able to click on "+linkName+ " button as "+ linkName+" button is not present in : "+ staticData.sessionInstance.getTitle() + " Page or Page element got changed. ");	
    } 	 
           
    }
    
    
    @Then("^The User Clicks on \"([^\"]*)\" link of \"([^\"]*)\" section\\.$")
    public void the_User_Clicks_on_link_of_section(String linkName, String section) throws Throwable {
    
    	try {
    String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(linkName,staticData.pomSheetName,staticData.needFieldIdentifier);
    String  identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(linkName,staticData.pomSheetName,staticData.needFieldValue);         
    	 if(ElementUtil.focusOnElement(identifierType, identifierValue) != null)
    	   
    	 {
    		   ElementUtil.focusOnElement(identifierType, identifierValue).click();
    		   
    	   }else {
    		   
    		  // throw new PendingException(" The link :" + linkName + "  with id : " + identifierValue + " is not present in :" + section);
    		  
    		   ElementUtil.focusOnPage(staticData.sessionInstance.getTitle()); 
    	   }
    	    	  }catch (Exception e) {
    	    		  
    	    		  staticData.elementUtil.screenShot_err(staticData.sessionInstance,"portal.jpg", ElementUtil.geturl());
    	    		  ElementUtil.focusOnPage(staticData.sessionInstance.getTitle());
    	    		  throw new Exception(" The user not able to click on " +linkName+ " link as "+ linkName +" link is not present in : "+ section + " section or Page element got changed.");
    		        
    	    	  }
    	   }
    
    @Then("^The User Clicks on \"([^\"]*)\" image link from \"([^\"]*)\" section\\.$")
    public void the_User_Clicks_on_image_link_from_section(String linkName, String section) throws Throwable {
    	
    	 String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(linkName,staticData.pomSheetName,staticData.needFieldIdentifier);
    	 String  identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(linkName,staticData.pomSheetName,staticData.needFieldValue);    
    	 try {
 			if (identifierType.equalsIgnoreCase("ID"))
 				ElementUtil.clickImagelink(By.id(identifierValue));
 			if (identifierType.equalsIgnoreCase("Name"))
 				ElementUtil.clickImagelink(By.name(identifierValue));
 			if (identifierType.equalsIgnoreCase("className"))
 				ElementUtil.clickImagelink(By.className(identifierValue));
 			if (identifierType.equalsIgnoreCase("cssSelector"))
 				ElementUtil.clickImagelink(By.cssSelector(identifierValue));
 			if (identifierType.equalsIgnoreCase("linkText"))
 				ElementUtil.clickImagelink(By.linkText(identifierValue));
 			if (identifierType.equalsIgnoreCase("partialLinkText"))
 				ElementUtil.clickImagelink(By.partialLinkText(identifierValue));
 			if (identifierType.equalsIgnoreCase("tagName"))
 				ElementUtil.clickImagelink(By.tagName(identifierValue));
 			if (identifierType.equalsIgnoreCase("xpath"))
 				ElementUtil.clickImagelink(By.xpath(identifierValue));
    } catch (Exception e) {
    	
    	staticData.elementUtil.screenShot_err(staticData.sessionInstance,"portal.jpg", ElementUtil.geturl());
    	ElementUtil.focusOnPage(staticData.sessionInstance.getTitle());
    	throw new Exception(" The user not able to click on " +linkName+ " link as "+ linkName +" link is not present in : "+ section + " section or Page element got changed.");
	} 	 
           
    }
    
	@Given("^The User waits till the page gets loaded\\.$")
	public void the_user_waits_till_the_page_gets_loaded() throws Throwable {
	    util.general.ElementUtil.hibernate(Thread.currentThread());
	    util.general.ElementUtil.hibernate(Thread.currentThread());
	    util.general.ElementUtil.hibernate(Thread.currentThread());
	}
	
	@Then("^The User waits more extra time to page gets loaded\\.$")
	public void the_User_waits_more_extra_time_to_page_gets_loaded() throws Throwable {
		util.general.ElementUtil.hibernate(Thread.currentThread());
	    util.general.ElementUtil.hibernate(Thread.currentThread());
	    util.general.ElementUtil.hibernate(Thread.currentThread());
		util.general.ElementUtil.hibernate(Thread.currentThread());
	    util.general.ElementUtil.hibernate(Thread.currentThread());
	    util.general.ElementUtil.hibernate(Thread.currentThread());
		util.general.ElementUtil.hibernate(Thread.currentThread());
	    util.general.ElementUtil.hibernate(Thread.currentThread());
	    util.general.ElementUtil.hibernate(Thread.currentThread());
	}
	@Then("^The User enters \"([^\"]*)\" in \"([^\"]*)\" field\\.$")
	public void the_User_enters_in_field(String searchItem, String searchBox) throws Throwable {
   
	 try {
    	 String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(searchBox,staticData.pomSheetName,staticData.needFieldIdentifier);
    	 String  identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(searchBox,staticData.pomSheetName,staticData.needFieldValue);         
    	    if(ElementUtil.focusOnElement(identifierType, identifierValue) != null)
    	    	 {
    	    		ElementUtil.focusOnElement(identifierType, identifierValue).sendKeys(searchItem);
    	    		   
    	    	  }else {
    	    		//  throw new PendingException(" The field :" + searchBox + "  with id : " + identifierValue + " is not present in :");
    	    		  ElementUtil.focusOnPage(staticData.sessionInstance.getTitle()); 
    	    	  }
    	    	   }catch (Exception e) {
    	    		   staticData.elementUtil.screenShot_err(staticData.sessionInstance,"portal.jpg", ElementUtil.geturl());
    	    		   ElementUtil.focusOnPage(staticData.sessionInstance.getTitle());
    	    		   throw new Exception(" The user not able to enter on " +searchBox+ " field as "+searchBox+" is not present in "+staticData.sessionInstance.getTitle()+" Page or Page element got changed." );
    	    		    }
    	    	   }
	
	@Then("^User expects the text for \"([^\"]*)\"\\.$")
	public void user_expects_the_text_for(String expectedText) throws Throwable {

	String identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(expectedText,staticData.pomSheetName,staticData.needFieldIdentifier);
	String identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(expectedText,staticData.pomSheetName,staticData.needFieldValue);
	         try {
	        	String fullText = ElementUtil.focusOnElement(identifierType, identifierValue).getText().trim();
	            System.out.println("fullText : " + fullText);
	            if (fullText.contains(","))
	            		 {		
	            String[] arrOfStr = fullText.split("\n");
	        	fullText = "";
	            for (int i=0;i<arrOfStr.length;i++)
	            {
	            	
	            	fullText = fullText + arrOfStr[i].trim() ;
	            }
	            		 }
	            	
	            if(expectedText.equalsIgnoreCase(fullText)) {
	              ElementUtil.writeMessageToLog(" The user was expected the text of " + expectedText +  " and it shows " + fullText + " is present in " + staticData.sessionInstance.getTitle() + " Page");
	            }else
	            {
	          Assert.assertEquals("The user was expected the text of " + expectedText +  " but it shows " + fullText,fullText,true);
	            }
	        } catch (Exception e) {
	        	ElementUtil.focusOnPage(staticData.sessionInstance.getTitle());
	        	throw new PendingException(expectedText + " text is not Generated.");
	        }
	}
	
	@Then("^User expects the text \"([^\"]*)\" from \"([^\"]*)\"\\.$")
	public void user_expects_the_text_from(String expectedText, String pageElement) throws Throwable {
	  
		String identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(pageElement,staticData.pomSheetName,staticData.needFieldIdentifier);
		String identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(pageElement,staticData.pomSheetName,staticData.needFieldValue);
		         try {
		        	String fullText = ElementUtil.focusOnElement(identifierType, identifierValue).getText().trim();
		            System.out.println("fullText : " + fullText);
		   
		            if (fullText.contains(","))
		            		 {		
		            String[] arrOfStr = fullText.split("\n");
		        	fullText = "";
		            for (int i=0;i<arrOfStr.length;i++)
		            {
		            	
		            	fullText = fullText + arrOfStr[i].trim() ;
		            }
		            		 }
		            	
		            if(expectedText.equalsIgnoreCase(fullText)) {
		              ElementUtil.writeMessageToLog(" The user was expected the text of " + expectedText +  " and it shows " + fullText + " is present in " + staticData.sessionInstance.getTitle() + " Page");
		            }else
		            {
		          Assert.assertEquals("The user was expected the text of " + expectedText +  " but it shows " + fullText,fullText,true);
		            }
		        } catch (Exception e) {
		        	ElementUtil.focusOnPage(staticData.sessionInstance.getTitle());
		        	throw new PendingException(expectedText + " text is not Generated.");
		        }
	
	}
	
	
	
	@Then("^User verifies the \"([^\"]*)\" exists in the \"([^\"]*)\" page\\.$")
	public void user_verifies_the_exists_in_the_page(String expectedPageElement, String page) throws Throwable {

		String identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(expectedPageElement,staticData.pomSheetName,staticData.needFieldIdentifier);
		String identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(expectedPageElement,staticData.pomSheetName,staticData.needFieldValue);
		WebElement webElement=null;       
		      try {
		         webElement = ElementUtil.focusOnElement(identifierType, identifierValue);
		        if(webElement==null) {
		           	 throw new Exception("The user was expecting the element "+ expectedPageElement+ " but it shows " + webElement+" is not present in "+ page + " Page or Page element got changed.");           
		          }else
		           {
		        ElementUtil.writeMessageToLog(" The user was expecting the element " + expectedPageElement +  " and it shows " + expectedPageElement + " in " + page + " Page");
		           }
		        } catch (Exception e) {
		    ElementUtil.focusOnPage(staticData.sessionInstance.getTitle());   	
		    throw new Exception("The user was expecting the element "+ expectedPageElement+ " but it shows " + webElement +" is not present in "+ page + " Page or Page element got changed.");
		        }
	
	}
	
	@Then("^User verifies the \"([^\"]*)\" does not exists in the \"([^\"]*)\" page\\.$")
	public void user_verifies_the_does_not_exists_in_the_page(String expectedPageElement, String page) throws Throwable {
		String identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(expectedPageElement,staticData.pomSheetName,staticData.needFieldIdentifier);
		String identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(expectedPageElement,staticData.pomSheetName,staticData.needFieldValue);
		WebElement webElement=null;       
		      try {
		         webElement = ElementUtil.focusOnElement(identifierType, identifierValue);
		        if(webElement==null) {
		        	  ElementUtil.writeMessageToLog(" The user is not expecting the element " + expectedPageElement +  " and it does not show " + expectedPageElement + " in " + page + " Page");     	            
		          }else
		           {
		        ElementUtil.focusOnPage(staticData.sessionInstance.getTitle());
		        throw new Exception("The user is not expecting the element "+ expectedPageElement+ " but it shows " + webElement+" is present in "+ page + " Page");
		           }
		        } catch (Exception e) {
		      	
		  //  throw new Exception("The user was expecting the element "+ expectedPageElement+ " but it shows " + webElement +" is not present in "+ page + " Page or Page element got changed."); 
	}
	}
	
	@Then("^The User does Scroll down to \"([^\"]*)\" element\\.$")
	public void the_User_does_Scroll_down_to_element(String elementToScroll) throws Throwable {
	   
		String identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(elementToScroll,staticData.pomSheetName,staticData.needFieldIdentifier);
		String identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(elementToScroll,staticData.pomSheetName,staticData.needFieldValue);
		WebElement webElement=null;       
		      try {
		         webElement = ElementUtil.focusOnElement(identifierType, identifierValue);
		        if(webElement!=null) {
		        	JavascriptExecutor js = (JavascriptExecutor) staticData.sessionInstance;
		        	 js.executeScript("arguments[0].scrollIntoView();", webElement);
		        }else {
		        	 throw new Exception("Expected element not found");
		        }
		      }catch (Exception e) {
		    	  
		      }
	}
	
	@Then("^The user will be redirected to \"([^\"]*)\" page\\.$")
	public void the_user_will_be_redirected_to_page(String pageTitle) throws Throwable {
	
		try {
		util.general.ElementUtil.hibernate(staticData.sessionInstance);
		String expectedPageTitle = util.excelDataProvider.getEnvironmentDetailsForSuit(pageTitle,staticData.commonVariablesName,staticData.needFieldIdentifier);
		String actualPageTitle = util.general.ElementUtil.popupNavigator();
		    System.out.println("-------------" + staticData.sessionInstance.getPageSource() + actualPageTitle);
		Assert.assertEquals("The user was expected to reach to " + expectedPageTitle +  " but reached to " + actualPageTitle,actualPageTitle.contains(expectedPageTitle),true);
			//staticData.elementUtil.screenShot_err(staticData.sessionInstance,"portal.jpg", ElementUtil.geturl());
		 }catch (Exception e) {
			 staticData.elementUtil.screenShot_err(staticData.sessionInstance,"portal.jpg", ElementUtil.geturl());	
			 ElementUtil.focusOnPage(staticData.sessionInstance.getTitle());
		        }
			
	}	

	
	  @Given("^Close The Child Browser Object of \"([^\"]*)\"\\.$") public void
	  close_The_Child_Browser_Object_of(String pageTitle) throws Throwable { try {
	  String expectedPageTitle =
	  util.excelDataProvider.getEnvironmentDetailsForSuit(pageTitle,staticData.
	  commonVariablesName,staticData.needFieldIdentifier);
	  ElementUtil.focusOnPage(expectedPageTitle);
	  System.out.println(staticData.sessionInstance.getWindowHandle()); } catch
	  (Exception e) { 
		  throw new PendingException(pageTitle + " Not able to close the Child Browser properly"); 
		  }
	  
	  }
	 
	@Then("^The User verifies All the \"([^\"]*)\" values from differents dropdown list for \"([^\"]*)\" app and \"([^\"]*)\" sheet\\.$")
	public void the_User_verifies_All_the_values_from_differents_dropdown_list_for_app_and_sheet(String Section, String app, String page) throws Throwable {
		List<String> actualAppSheetName = null;
		List<String> actualAppName = null;
		String actualAbbreviationSheetname = null;
		String status = "Pass";
		//List<String> codition = null;
		actualAppSheetName = excelDataProvider.getSelectedWebservices(staticData.needFieldValue1, staticData.webServiceListSheetName,staticData.needAdditionalParams2); 
		actualAppName = excelDataProvider.getSelectedWebservices(staticData.needFieldValue, staticData.webServiceListSheetName,staticData.needAdditionalParams2); 
		try {
		for (int i=0;i<actualAppSheetName.size();i++)
	{
		if (actualAppSheetName.get(i).equalsIgnoreCase(page)&& actualAppName.get(i).equalsIgnoreCase(app))
				{
		String a = actualAppSheetName.get(i);
		String b = actualAppName.get(i);
		actualAbbreviationSheetname = excelDataProvider.getSpecificCellValue(staticData.needFieldValue3,app,staticData.webServiceListSheetName);
		excelReader.getCellValueByResponseFieldName(Section,actualAbbreviationSheetname,"All");
		for (int j=0;j<staticData.ListOfcolumn2.size();j++)
		{
			if(staticData.ListOfcolumn2.get(j).equalsIgnoreCase("<="))
			{
				 String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
				 String identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldValue); 
				 String	identifierType1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
				 String identifierValue1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldValue); 
				 ElementUtil.focusOnElement(identifierType, identifierValue).click();
				 int count = ElementUtil.countOfElement(identifierType1, identifierValue1);
				 if(Integer.parseInt(staticData.ListOfcolumn3.get(j))<=count)
				 {
					 ElementUtil.writeMessageToLog("<font color=green>PASS: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be less than or equal to " + count + " and it is same as expeccted " + staticData.ListOfcolumn1.get(j)+".</font>");	
					}else {
						status = "Fail";
					 ElementUtil.writeMessageToLog("<font color=red>FAIL: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be less than or equal to " + count + " but it is not same as expeccted " + staticData.ListOfcolumn1.get(j)+".</font>");		
					   	}
			}else if  (staticData.ListOfcolumn2.get(j).equalsIgnoreCase(">="))
			{
				 String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
				 String identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldValue); 
				 String	identifierType1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
				 String identifierValue1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldValue); 
				 ElementUtil.focusOnElement(identifierType, identifierValue).click();
				 int count = ElementUtil.countOfElement(identifierType1, identifierValue1);
				 if(Integer.parseInt(staticData.ListOfcolumn3.get(j))>=count)
				 {
					ElementUtil.writeMessageToLog("<font color=green>PASS: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be greater than or equal to " + count + " and it is same as expeccted " + staticData.ListOfcolumn1.get(j)+".</font>");	
					}else {
						status = "Fail";
					ElementUtil.writeMessageToLog("<font color=red>FAIL: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be greater than or equal to " + count + " but it is not same as expeccted " + staticData.ListOfcolumn1.get(j)+".</font>");		
					   	}
			}else if  (staticData.ListOfcolumn2.get(j).equalsIgnoreCase(">"))
			{
					 String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
					 String  identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldValue); 
					 String	identifierType1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
					 String  identifierValue1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldValue); 
					 ElementUtil.focusOnElement(identifierType, identifierValue).click();
					 int count = ElementUtil.countOfElement(identifierType1, identifierValue1);
					 if(Integer.parseInt(staticData.ListOfcolumn3.get(j))>count)
					 {
					ElementUtil.writeMessageToLog("<font color=green>PASS: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be greater than to " + count + " and it is same as expeccted " + staticData.ListOfcolumn1.get(j) + ".</font>");	
						}else {
							status = "Fail";
					ElementUtil.writeMessageToLog("<font color=red>FAIL: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be greater than to " + count + " but it is not same as expeccted " + staticData.ListOfcolumn1.get(j) + ".</font>");		
						   	}
			}else if  (staticData.ListOfcolumn2.get(j).equalsIgnoreCase("<"))
			{
				 String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
				 String  identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldValue); 
				 String	identifierType1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
				 String  identifierValue1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldValue); 
				 ElementUtil.focusOnElement(identifierType, identifierValue).click();
				 int count = ElementUtil.countOfElement(identifierType1, identifierValue1);
				 if(Integer.parseInt(staticData.ListOfcolumn3.get(j))<count)
				 {
				 ElementUtil.writeMessageToLog("<font color=green>PASS: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be less than to " + count + " and it is same as expeccted " + staticData.ListOfcolumn1.get(j) + ".</font>");	
					}else {
						status = "Fail";
				ElementUtil.writeMessageToLog("<font color=red>FAIL: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be less than to " + count + " but it is not same as expeccted " + staticData.ListOfcolumn1.get(j) + ".</font>");		
					   	}
				
			}else if  (staticData.ListOfcolumn2.get(j).equalsIgnoreCase("="))
			{
					 String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
					 String identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldValue); 
					 String	identifierType1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
					 String identifierValue1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldValue); 
					 ElementUtil.focusOnElement(identifierType, identifierValue).click();
					 ElementUtil.hibernate(ElementUtil.focusOnElement(identifierType1, identifierValue1));
					 int count = ElementUtil.countOfElement(identifierType1, identifierValue1);
					 
					 if(Integer.parseInt(staticData.ListOfcolumn3.get(j))==count)
					 {
				 ElementUtil.writeMessageToLog("<font color=green>PASS: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be equal to " + count + " and it is same as expeccted " + staticData.ListOfcolumn1.get(j) + ".</font>");	
						}else {
							status = "Fail";
				 ElementUtil.writeMessageToLog("<font color=red>FAIL: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be equal to " + count + " but it is not same as expeccted " + staticData.ListOfcolumn1.get(j) + ".</font>");		
						   	}
				
			}
				
		}
				}
					}
	}
		catch(Exception e)
		{
			//e.printStackTrace();
			ElementUtil.focusOnPage(staticData.sessionInstance.getTitle());
			throw new PendingException("Passing parameter from feature file may not same with excel or any new name has been introduced under section.");
		}
		if (status.equalsIgnoreCase("Fail"))
		{
			ElementUtil.focusOnPage(staticData.sessionInstance.getTitle());
			throw new Exception("All the " +Section+ " are not verified Pass.");		
		}
	}
	

     @Then("^The User verifies Selected \"([^\"]*)\" values from differents dropdown list for \"([^\"]*)\" app and \"([^\"]*)\" sheet\\.$")
     public void the_User_verifies_Selected_values_from_differents_dropdown_list_for_app_and_sheet(String Section, String app, String page) throws Throwable {
    	List<String> actualAppSheetName = null;
 		List<String> actualAppName = null;
 		String actualAbbreviationSheetname = null;
 		String status = "Pass";
 		//List<String> codition = null;
 		actualAppSheetName = excelDataProvider.getSelectedWebservices(staticData.needFieldValue1, staticData.webServiceListSheetName,staticData.needAdditionalParams2); 
 		actualAppName = excelDataProvider.getSelectedWebservices(staticData.needFieldValue, staticData.webServiceListSheetName,staticData.needAdditionalParams2); 
 		try {
 		for (int i=0;i<actualAppSheetName.size();i++)
 	{
 		if (actualAppSheetName.get(i).equalsIgnoreCase(page)&& actualAppName.get(i).equalsIgnoreCase(app))
 				{
 		String a = actualAppSheetName.get(i);
 		String b = actualAppName.get(i);
 		String c ="";
 		actualAbbreviationSheetname = excelDataProvider.getSpecificCellValue(staticData.needFieldValue3,app,staticData.webServiceListSheetName);
 		excelReader.getCellValueByResponseFieldName(Section,actualAbbreviationSheetname,"Selected");
 		for (int j=0;j<staticData.ListOfcolumn2.size();j++)
 		{
 			if(staticData.ListOfcolumn2.get(j).equalsIgnoreCase("<="))
 			{
 				 String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
 				 String identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldValue); 
 				 String	identifierType1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
 				 String identifierValue1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldValue); 
 				 ElementUtil.focusOnElement(identifierType, identifierValue).click();
 				 int count = ElementUtil.countOfElement(identifierType1, identifierValue1);
 				 if(Integer.parseInt(staticData.ListOfcolumn3.get(j))<= count)
 				 {
 					 ElementUtil.writeMessageToLog("<font color=green>PASS: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be less than or equal to " + count + " and it is same as expeccted " + staticData.ListOfcolumn1.get(j)+".</font>");	
 					}else {
 						status = "Fail";
 					 ElementUtil.writeMessageToLog("<font color=red>FAIL: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be less than or equal to " + count + " but it is not same as expeccted " + staticData.ListOfcolumn1.get(j)+".</font>");		
 					 staticData.elementUtil.screenShot_err(staticData.sessionInstance,"portal.jpg", ElementUtil.geturl());   
 					}
 			}else if  (staticData.ListOfcolumn2.get(j).equalsIgnoreCase(">="))
 			{
 				 String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
 				 String identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldValue); 
 				 String	identifierType1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
 				 String identifierValue1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldValue); 
 				 ElementUtil.focusOnElement(identifierType, identifierValue).click();
 				 int count = ElementUtil.countOfElement(identifierType1, identifierValue1);
 				 if(Integer.parseInt(staticData.ListOfcolumn3.get(j)) >= count)
 				 {
 					ElementUtil.writeMessageToLog("<font color=green>PASS: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be greater than or equal to " + count + " and it is same as expeccted " + staticData.ListOfcolumn1.get(j)+".</font>");	
 					}else {
 						status = "Fail";
 					ElementUtil.writeMessageToLog("<font color=red>FAIL: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be greater than or equal to " + count + " but it is not same as expeccted " + staticData.ListOfcolumn1.get(j)+".</font>");		
 					   	}
 			}else if  (staticData.ListOfcolumn2.get(j).equalsIgnoreCase(">"))
 			{
 					 String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
 					 String  identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldValue); 
 					 String	identifierType1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
 					 String  identifierValue1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldValue); 
 					 ElementUtil.focusOnElement(identifierType, identifierValue).click();
 					 int count = ElementUtil.countOfElement(identifierType1, identifierValue1);
 					 if(Integer.parseInt(staticData.ListOfcolumn3.get(j))>count)
 					 {
 					ElementUtil.writeMessageToLog("<font color=green>PASS: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be greater than to " + count + " and it is same as expeccted " + staticData.ListOfcolumn1.get(j) + ".</font>");	
 						}else {
 							status = "Fail";
 					ElementUtil.writeMessageToLog("<font color=red>FAIL: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be greater than to " + count + " but it is not same as expeccted " + staticData.ListOfcolumn1.get(j) + ".</font>");		
 						   	}
 			}else if  (staticData.ListOfcolumn2.get(j).equalsIgnoreCase("<"))
 			{
 				 String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
 				 String  identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldValue); 
 				 String	identifierType1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
 				 String  identifierValue1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldValue); 
 				 ElementUtil.focusOnElement(identifierType, identifierValue).click();
 				 int count = ElementUtil.countOfElement(identifierType1, identifierValue1);
 				 if(Integer.parseInt(staticData.ListOfcolumn3.get(j))<count)
 				 {
 				 ElementUtil.writeMessageToLog("<font color=green>PASS: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be less than to " + count + " and it is same as expeccted " + staticData.ListOfcolumn1.get(j) + ".</font>");	
 					}else {
 						status = "Fail";
 				ElementUtil.writeMessageToLog("<font color=red>FAIL: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be less than to " + count + " but it is not same as expeccted " + staticData.ListOfcolumn1.get(j) + ".</font>");		
 				staticData.elementUtil.screenShot_err(staticData.sessionInstance,"portal.jpg", ElementUtil.geturl());   	
 					}
 				
 			}else if  (staticData.ListOfcolumn2.get(j).equalsIgnoreCase("="))
 			{
 					 String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
 					 String identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldValue); 
 					 String	identifierType1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
 					 String identifierValue1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldValue); 
 					 ElementUtil.focusOnElement(identifierType, identifierValue).click();
 					 int count = ElementUtil.countOfElement(identifierType1, identifierValue1);
 					 if(Integer.parseInt(staticData.ListOfcolumn3.get(j))==count)
 					 {
 				 ElementUtil.writeMessageToLog("<font color=green>PASS: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be equal to " + count + " and it is same as expeccted " + staticData.ListOfcolumn1.get(j) + ".</font>");	
 						}else {
 							status = "Fail";
 				 ElementUtil.writeMessageToLog("<font color=red>FAIL: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be equal to " + count + " but it is not same as expeccted " + staticData.ListOfcolumn1.get(j) + ".</font>");		
 				 staticData.elementUtil.screenShot_err(staticData.sessionInstance,"portal.jpg", ElementUtil.geturl());   
 						}
 				
 			}else if  (staticData.ListOfcolumn2.get(j).equalsIgnoreCase("IN"))
 			{
				 String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
				 String identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn1.get(j),staticData.pomSheetName,staticData.needFieldValue); 
				 String	identifierType1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldIdentifier);
				 String identifierValue1 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.ListOfcolumn5.get(j),staticData.pomSheetName,staticData.needFieldValue); 
				 String isidentifierType2 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.exitfullscreen,staticData.pomSheetName,staticData.needFieldIdentifier);  
	    		 String identifierValue2 = util.excelDataProvider.getEnvironmentDetailsForSuit(staticData.exitfullscreen,staticData.pomSheetName,staticData.needFieldValue);
	    		 Thread.sleep(15000);
	    		 try {
	    			 //ElementUtil.mouseHoverToElement(By.xpath(identifierValue));
	    			 ElementUtil.focusOnElement(identifierType, identifierValue).click();
	    		 }catch(Exception e)
	    		 {
	    			 // Store the current window handle
	    		      String mainWindow = staticData.sessionInstance.getWindowHandle();
	    		      String currentWindow = "";
	    		      for(String winHandle : staticData.sessionInstance.getWindowHandles()){
	    		    	 
	    		    	  staticData.sessionInstance.switchTo().window(winHandle);
	    		    	  currentWindow = winHandle;
	    		    	 	   }
	    		 ElementUtil.focusOnElement(identifierType, identifierValue).click();
	    		// staticData.sessionInstance.switchTo().window(currentWindow).close();
	    		 //staticData.sessionInstance.switchTo().window(mainWindow).close();
	    		 }
	    		// ElementUtil.focusOnElement("xpath", "//input[@class='lui-search__input ng-valid ng-valid-maxlength ng-touched ng-dirty ng-empty']").sendKeys(staticData.ListOfcolumn5.get(j));
	    		 Thread.sleep(1000);
                    try{ 	    		 
	    	   staticData.sessionInstance.findElement(By.xpath("(//span[@class='lui-icon  lui-icon--search  lui-search__search-icon'])[2]")).click();;
  			   staticData.sessionInstance.findElement(By.xpath("(//input[@class='lui-search__input ng-pristine ng-valid ng-empty ng-valid-maxlength ng-touched'])[2]")).click();
  			   staticData.sessionInstance.findElement(By.xpath("(//input[@class='lui-search__input ng-pristine ng-valid ng-empty ng-valid-maxlength ng-touched'])[2]")).sendKeys(staticData.ListOfcolumn5.get(j));
                    }catch(Exception e)
                    {
                    	System.out.println();
                    }
							
	    		   		 
	    		 Thread.sleep(1000);
				 String expectedText = ElementUtil.getext(identifierType1, identifierValue1);
				 
				 if(staticData.ListOfcolumn3.get(j).equalsIgnoreCase(expectedText))
				 {
			 ElementUtil.writeMessageToLog("<font color=green>PASS: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be equal to " + expectedText + " and it is same as expeccted " + staticData.ListOfcolumn1.get(j) + ".</font>");	
			// ElementUtil.focusOnElement(identifierType, identifierValue).click();	
			 if(ElementUtil.focusOnElement(isidentifierType2, identifierValue2) != null)
		    	{
	    		 try { 
	    			
				 ElementUtil.focusOnElement(isidentifierType2, identifierValue2).click();
	    		 }catch(Exception e)
	    		 {
	    			 ElementUtil.clickImagelink(By.xpath(identifierValue2));
	    		 }
	    	   }else {
	    		  
	    		   ElementUtil.focusOnElement(identifierType, identifierValue).click();
	    	   }
				 }else {
						status = "Fail";
						
			 ElementUtil.writeMessageToLog("<font color=red>FAIL: The user expects the value " + staticData.ListOfcolumn3.get(j) +  " which should be equal to " + expectedText + " but it is not same as expeccted " + staticData.ListOfcolumn1.get(j) + ".</font>");		
			// staticData.elementUtil.screenShot_err(staticData.sessionInstance,"portal.jpg", ElementUtil.geturl());   
			 ElementUtil.focusOnElement(identifierType, identifierValue).click();		
					}
			
		}
 				
 		}
 				}
 					}
 	}
 		catch(Exception e)
 		{
 			//e.printStackTrace();
 			ElementUtil.focusOnPage(staticData.sessionInstance.getTitle());
 			throw new PendingException("Passing parameter from feature file may not same with excel or any new name has been introduced under section.");
 		}
 		if (status.equalsIgnoreCase("Fail"))
 		{
 			ElementUtil.focusOnPage(staticData.sessionInstance.getTitle());
 			throw new Exception("All the " +Section+ " are not verified Pass.");		
 		}
      
     }
	@When("^The User may click on \"([^\"]*)\" button\\.$")
	public void the_User_may_click_on_button(String buttonName) throws Throwable {
		try {
			   String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(buttonName,staticData.pomSheetName,staticData.needFieldIdentifier);
			   String   identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(buttonName,staticData.pomSheetName,staticData.needFieldValue);    
			   if(ElementUtil.focusOnElement(identifierType, identifierValue) != null)
			   {
				   ElementUtil.focusOnElement(identifierType, identifierValue).click();
			   }
			    	  }catch (Exception e) {
			    		 
				    }
	}		
	@Then("^The User may click on \"([^\"]*)\" link of \"([^\"]*)\" section\\.$")
	public void the_User_may_click_on_link_of_section(String linkName, String section) throws Throwable {

		try {
		    String	identifierType = util.excelDataProvider.getEnvironmentDetailsForSuit(linkName,staticData.pomSheetName,staticData.needFieldIdentifier);
		    String  identifierValue = util.excelDataProvider.getEnvironmentDetailsForSuit(linkName,staticData.pomSheetName,staticData.needFieldValue);         
		    	 if(ElementUtil.focusOnElement(identifierType, identifierValue) != null)
		    	   
		    	 {
		    		  ElementUtil.focusOnElement(identifierType, identifierValue).click();
		         }
		    	 }catch (Exception e) {
		    		           
		    		    }
		    	   }
	@Given("^Close The Parent Browser Object\\.$")
	public void close_The_Parent_Browser_Object() throws Throwable {
		
		ElementUtil.focusOnParentPage(staticData.sessionInstance.getTitle());
	    
	}
	@Given("^Close The child Browser Object\\.$")
	public void close_The_child_Browser_Object() throws Throwable {
		
		ElementUtil.focusOnChildPage(staticData.sessionInstance.getTitle());
	    
	}
	@When("^The User Clicks on \"([^\"]*)\" button\\.$")
	public void the_User_Clicks_on_button(String arg1) throws Throwable {
		 System.out.println("aaaa");
	}
	
	@Then("^The User renames the downloaded excel file as \"([^\"]*)\" and copy the file in \"([^\"]*)\" folder\\.$")
	public void the_User_renames_the_downloaded_excel_file_as_and_copy_the_file_in_folder(String renameFile, String folder) throws Throwable {	
	
		  // Store the current window handle
	      String mainWindow = staticData.sessionInstance.getWindowHandle();
	      // open a new tab
	      JavascriptExecutor js = (JavascriptExecutor)staticData.sessionInstance;
	      js.executeScript("window.open()");
	      // switch to new tab
	      // Switch to new window opened
	      for(String winHandle : staticData.sessionInstance.getWindowHandles()){
	    	  staticData.sessionInstance.switchTo().window(winHandle);
	      }
	      // navigate to chrome downloads
	      staticData.sessionInstance.get("chrome://downloads");
	      Thread.sleep(3000);
	      JavascriptExecutor js1 = (JavascriptExecutor)staticData.sessionInstance;
	      // wait until the file is downloaded
	      Long percentage = (long) 0;
	      while ( percentage!= 0) {
	          try {
	              percentage = (Long) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('#progress').value");
	              //System.out.println(percentage);
	          }catch (Exception e) {
	            // Nothing to do just wait
	        }
	          Thread.sleep(1000);
	      }
	      // get the latest downloaded file name
	      String fileName = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");
	      // get the latest downloaded file url
	      String sourceURL = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').href");
	      // file downloaded location
	      String donwloadedAt = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div.is-active.focus-row-active #file-icon-wrapper img').src");
	     // String fileId = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-id').value");
	      js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').click()");
	      System.out.println("Download deatils");
	      System.out.println("File Name :-" + fileName);
	      System.out.println("Donwloaded path :- " + donwloadedAt);
	      System.out.println("Downloaded from url :- " + sourceURL);
	      // print the details
	      System.out.println(fileName);
	      System.out.println(sourceURL);
	      // close the downloads tab2
		  	File myFile = new File("chrome://downloads",fileName);
			myFile.delete();
	js1.executeScript("document.querySelector(\"body > downloads-manager\").shadowRoot.querySelector(\"#frb0\").shadowRoot.querySelector(\"#remove\").click()");
		  staticData.sessionInstance.close();
	      // switch back to main window
	      staticData.sessionInstance.switchTo().window(mainWindow);
	      	 
	      String dir = System.getProperty("user.dir");      
		  Path source = Paths.get("C:/Users/supp_admin/Downloads/"+fileName);

	      Path newDir = Paths.get(dir+staticData.actualAPPPath+"//"+folder);

	      //create the target directories, if directory exits, no effect
	      Files.createDirectories(newDir);

	      Files.move(source, newDir.resolve(renameFile+".xlsx"),
	                  StandardCopyOption.REPLACE_EXISTING);
	     
	  	//File myFile = new File(donwloadedAt,fileName);
		//myFile.delete();
		System.out.println(sourceURL);
		
	}

	@Then("^User compares the two excel file between expected \"([^\"]*)\" file and actual \"([^\"]*)\" file for the \"([^\"]*)\" App\\.$")
	public void user_compares_the_two_excel_file_between_expected_file_and_actual_file_for_the_App(String expectedfile, String actualfile, String app) throws Throwable {
		try {
		String dir = System.getProperty("user.dir");
		String q =dir+staticData.actualAPPPath+"\\"+app+"\\"+actualfile+".xlsx";
		FileInputStream template = new FileInputStream(dir+staticData.actualAPPPath+"\\"+app+"\\"+actualfile+".xlsx");
		//Workbook actual = new HSSFWorkbook(template);
		XSSFWorkbook actual = new XSSFWorkbook(template);
		InputStream template1 = new FileInputStream (dir+staticData.expectedAPPPath+"\\"+app+"\\"+expectedfile+".xlsx");
		//Workbook expected = new HSSFWorkbook(template1);
		Workbook expected = new XSSFWorkbook(template1);
		assertThat(actual, WorkbookMatcher.sameWorkbook(expected));
		 }catch (Exception e) {
        	//ElementUtil.focusOnPage(staticData.sessionInstance.getTitle());
        	//e.getStackTrace();
		 throw new Exception("Excel is not readable.");
        }
}
	@Then("^Verify the columns of \"([^\"]*)\" files from \"([^\"]*)\" sheet\\.$")
	public void verify_the_columns_of_files_from_sheet(String key, String sheet) throws Throwable {
		String status = "Pass";
		List<String> rowCell = new ArrayList<String>();
		String dir = System.getProperty("user.dir");
		//String q =dir+staticData.repoLocation5;
	    FileInputStream fileInputStream = new FileInputStream( staticData.repoLocation );
	    HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
        HSSFSheet worksheet = workbook.getSheet( sheet );
        FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
        DataFormatter objDefaultFormat = new DataFormatter();
	    int rowNum = worksheet.getLastRowNum() + 1;
	    int colNum = worksheet.getRow(0).getFirstCellNum(); 
	    String cellValueStr=null;
	    String cellValueStr1=null;
	    for (int loop =0;loop<rowNum;loop++)
	    {
	    	HSSFRow row = worksheet.getRow(rowNum-loop);
	        HSSFCell cell0 = row.getCell(0);
	        if(key.equalsIgnoreCase(objDefaultFormat.formatCellValue(cell0)))
	        {
	            HSSFCell cell = row.getCell(3);
	            HSSFCell cell1 = row.getCell(5);
	            objFormulaEvaluator.evaluate(cell);
	            cellValueStr = objDefaultFormat.formatCellValue(cell);
	            objFormulaEvaluator.evaluate(cell1);
	            cellValueStr1 = objDefaultFormat.formatCellValue(cell1);
	        }
	    }

        String[] expectedResult = null;
        
		expectedResult = cellValueStr1.split(",");
        try (Stream<Path> stream = Files.walk(Paths.get(cellValueStr))) {
        	Object[] a = stream.filter(Files::isRegularFile).toArray();
        	System.out.println(a[0].toString().lastIndexOf("\\"));
        	int index= a[0].toString().lastIndexOf("\\");
        	System.out.println(a[0].toString().substring(index+1, a[0].toString().length()));
        	System.out.println(a[1].toString());  
               for (int i =0; i<a.length;i++)    
               {
            	  if (a[i].toString().substring(index+1, a[i].toString().length()).endsWith(".csv"))  
            	  {
            	   String headers;
                   String line;
                    try (BufferedReader br = new BufferedReader(new FileReader(a[i].toString()))) {
                        headers = br.readLine();
                        String[] actualResult = null;
                        actualResult = headers.split(",");
                        String Status = "";
                        for (int j=0;j<expectedResult.length;j++)
                        {
                        	for (int k=0;k<actualResult.length;k++)
                        	{
                        		Status = "FAIL";
                        		if(expectedResult[j].trim().contentEquals(actualResult[k].trim()))
                        		{
                        			System.out.println(actualResult[k]);
                        			Status = "PASS";
                        			ElementUtil.writeMessageToLog("<font color=green>PASS: Match the expected result with actual result for the value of "+ expectedResult[j]+" of "+ a[i].toString().substring(index+1, a[i].toString().length())+ "Sheet."+".</font>");
                        		break;
                        		}
                        	}
                        	if (Status.equalsIgnoreCase("Fail"))
                        	{
     String rowColumn= ("FAIL: Does not match the expected result with actual result for the value of " + expectedResult[j]+" of "+ a[i].toString().substring(index+1, a[i].toString().length())+ "Sheet.");
  	 rowCell.add(rowColumn);
  	System.out.println("aaaaaaaaaaaaaa");
                        	}
  	        		 
                        }
                        System.out.println(headers) ;    
               }
               } 	       
       if (!rowCell.isEmpty())
       {
    	   for (int l=0; l<rowCell.size();l++)
			{
				ElementUtil.writeMessageToLog("<font color=red>" +rowCell.get(l)+ ".</font>");
			}  
    	   throw new Exception("All the values are not verified Pass.");
       }
               }
               }
        System.out.println("aaaaa");
       
	    		
	}
	
	@Then("^User compares only those rows present in the expected \"([^\"]*)\" file with actual \"([^\"]*)\" file for the \"([^\"]*)\" App\\.$")
	public void user_compares_only_those_rows_present_in_the_expected_file_with_actual_file_for_the_App(String expectedFile, String actualFile, String app) throws Throwable {
		
		String status="Yes";
		List<String> rowCell = new ArrayList<String>();
		String dir = System.getProperty("user.dir");
		String q =dir+staticData.actualAPPPath+"\\"+app+"\\"+actualFile+".xlsx";
		FileInputStream template = new FileInputStream(dir+staticData.actualAPPPath+"\\"+app+"\\"+actualFile+".xlsx");
		XSSFWorkbook actual = new XSSFWorkbook(template);
		XSSFSheet shActual = actual.getSheetAt(0);
		FormulaEvaluator objFormulaEvaluator = new XSSFFormulaEvaluator(actual);
		DataFormatter objDefaultFormat = new DataFormatter();
	    int rowNumActual = shActual.getLastRowNum();
		//int colNumActual = shActual.getRow(rowNumActual).;
	    String s = dir+staticData.expectedAPPPath+"\\"+app+"\\"+expectedFile+".xlsx";
		InputStream template1 = new FileInputStream (dir+staticData.expectedAPPPath+"\\"+app+"\\"+expectedFile+".xlsx");
		XSSFWorkbook expected = new XSSFWorkbook(template1);
		XSSFSheet shExpected = expected.getSheetAt(0);
		FormulaEvaluator objFormulaEvaluator1 = new XSSFFormulaEvaluator(expected);
		DataFormatter objDefaultFormat1 = new DataFormatter();
	    int rowExpected = shExpected.getLastRowNum();
		int colExpected = shExpected.getRow(rowExpected).getLastCellNum();
	    for( int i = 0;i<= rowExpected;i++)
	    {
	        for (int j = 0;j<= colExpected;j++)
	        {
	        	XSSFRow row1 = shExpected.getRow(i);
	        	XSSFCell cell1 = row1.getCell(j);
	        	String cellValueStr1 = objDefaultFormat.formatCellValue(cell1);
	        	
	        	XSSFRow row2 = shActual.getRow(i);
	        	XSSFCell cell2 = row2.getCell(j);
	        	String cellValueStr2 = objDefaultFormat.formatCellValue(cell2);
	        	
	        	System.out.println("");
	        	if(cellValueStr1.equalsIgnoreCase(cellValueStr2))
	        	 {
	        		System.out.println("");
	        	 }else 
	        	 {
	        		 status = "Fail";
	        		 String rowColumn= "Row: "+i+" Column: "+j+ "  Actual Value:  "+cellValueStr2 +" , "+"Expected Value:  "+cellValueStr1;
	        		 rowCell.add(rowColumn);
	        	 }
	           	
	        }
	    }
	    
	    if (status.equalsIgnoreCase("Fail"))
 		{
 		for (int k=0; k<rowCell.size();k++)
 			{
 				ElementUtil.writeMessageToLog("<font color=red>FAIL: For "+ rowCell.get(k)+ ".</font>");
 			}
 			
 			throw new Exception("All the values are not verified Pass.");		
 		}    
		
		
	    }
	
	
	}


	







 
    
 
    