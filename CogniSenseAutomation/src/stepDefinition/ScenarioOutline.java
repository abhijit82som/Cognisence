package stepDefinition;

import static java.lang.System.out;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

//import org.apache.commons.collections.MultiHashMap;

import RunWay.ThreadRunnerAll;

//import commonsupport.DelimitedString;



//import commonsupport.DelimitedString;

import bsh.util.Util;
import junit.framework.Assert;
import util.excelDataProvider;
//import util.excelUtility;
import util.staticData;
import util.general.ElementUtil;
//import webservice.common.WSUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ScenarioOutline {
	
	
	@Then("^Create Scenario Outline for \"([^\"]*)\" APP - \"([^\"]*)\" with APPSheets \"([^\"]*)\"\\.$")
	public void create_Scenario_Outline_for_APP_with_APPSheets(String arg1, List<String> arg2, List<String> arg3) throws Throwable {
	 
		System.out.println("as");
		List<String> directory1Files = null;
		List<String> directory2Files = null;
		List<String> directory3Files = null;
		List<String>directory4Files = null;
		
		if (arg1.equalsIgnoreCase("All"))
		{
		directory1Files = excelDataProvider.getAllWebservices(staticData.needFieldIdentifier, staticData.webServiceListSheetName);
		directory2Files = excelDataProvider.getAllWebservices(staticData.needFieldValue, staticData.webServiceListSheetName);
		//directory3Files = arg1;
		//directory4Files = util.excelDataProvider.getCellValueByFieldName("Enviorment Under Test", staticData.suitDataSheetName);
		}
		else if (arg1.equalsIgnoreCase("Selected"))
		{
			directory1Files = excelDataProvider.getSelectedWebservices(staticData.needFieldIdentifier1, staticData.webServiceListSheetName,staticData.needAdditionalParams2);
			directory2Files = excelDataProvider.getSelectedWebservices(staticData.needFieldValue1, staticData.webServiceListSheetName,staticData.needAdditionalParams2);
			directory3Files = excelDataProvider.getSelectedWebservices(staticData.needFieldValue3, staticData.webServiceListSheetName,staticData.needAdditionalParams2);;
			directory4Files = excelDataProvider.getSelectedWebservices(staticData.needFieldValue2, staticData.webServiceListSheetName,staticData.needAdditionalParams2);	
		}else
		{
			directory1Files = arg2;
			directory2Files = arg3;
			//directory3Files = arg1;
			//directory4Files = util.excelDataProvider.getCellValueByFieldName("Enviorment Under Test", staticData.suitDataSheetName);	
		}
		System.out.println("sa");
		String [] allFiles = new String[directory1Files.size()];
	
		for (int i = 0;i< directory1Files.size();i++)
		{
			allFiles[i] = "| " +   directory1Files.get(i) + " | " + directory2Files.get(i) + " | " +directory3Files.get(i) + " | " + directory4Files.get(i) + " | " + "\n";
		}
		Thread.sleep(9000);
		ElementUtil.createScenario("./Features/Common/APP_ExecuteScenario.feature",allFiles,8);
		Thread.sleep(9000);
	}
	
	@Given ("^User executes \"([^\"]*)\" Different APPSheets for Different APP - \"([^\"]*)\", APPSheet - \"([^\"]*)\" with DML \"([^\"]*)\"\\.$")
	public void user_executes_Different_APPSheets_for_Different_APP_APPSheet_with_DML(String Selection, String APPName, String APPSheet, String DML) throws Throwable {
						
		staticData.enviormentUnderTest = util.excelDataProvider.getCellValueByFieldName("Enviorment Under Test", staticData.suitDataSheetName);
		String SwitchInput =APPName+":"+APPSheet;	

		staticData.ListOfApp.add(APPName);
		staticData.ListOfAppSheet.add(APPSheet);
		staticData.ListOfAbbreviationSheetname.add(Selection);
	}
			
	private static List<String> getPropValue(String name) {
		Properties prop = new Properties();
		List<String> values = null;
		InputStream input = null;
		try {

			input = new FileInputStream("config.properties");
			prop.load(input);
			String value = prop.getProperty(name);
			if (null != value) {
				values = Arrays.asList(value.split("~"));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return values;
	}
}

