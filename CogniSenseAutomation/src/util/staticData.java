package util;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.general.*;

import org.openqa.selenium.WebDriver;
import cucumber.api.Scenario;
public  class staticData {
	
	public static String suitDataSheetName = "SuitData";
	public static String repoLocation3 ="a";
	
	public static WebDriver sessionInstance = null;
	public static ElementUtil elementUtil = new ElementUtil();
	public static String userType = null;
	public static String userNames = " ";
	public static String exitfullscreen ="Exit full screen";
		
	public static String suitToRun = null;
	public static int needFieldIdentifier = 0;
	public static int needFieldIdentifier1 = 1;
	public static int needFieldValue = 1;
	public static int needFieldValue1 = 2;
	public static int needFieldValue2 = 4;
	public static int needFieldValue3 = 5;
	public static int needAdditionalParams1 =6;
	public static int needAdditionalParams2 = 3;

	public static String pomSheetName = "PageObjectModel";
	public static String commonVariablesName = "commonVariables";
	public static String environmentDetailsSheetName = "EnvironmentDetails";
	
	public static String pageHeaderSheetName = "PageHeader";
	public static String querySheetName = "Query";
	
	public static String repoLocation = "./TestData/EnviormentDetails.xls";
	public static String repoLocation1 = "./TestData/WSEnviormentDetails.xls";
	public static String repoLocation2 = "./TestData/WSEnviormentDetails.xlsx";
	public static String repoLocation5 = "\\TestData\\EnviormentDetails.xls";
	public static String webServiceListSheetName ="EnvironmentDetails";
	public static String actualAPPPath = "\\Apps";
	public static String expectedAPPPath =	"\\TestData\\Apps";	
	public static String inPut="\\emea.teo.earth\\shares\\RAN-QA\\QA_Team";
			
	
	public static final String participantReportName = "./Reports/ParticipantPortalSanity.json";
	//public static final String groupReportName = "./Reports/GroupPortalSanity.json";
	//public static final String adminReportName = "./Reports/AdminPortalSanity.json";
	public static final String allImageCheckReportName = "./Reports/AllImageCheckSanity.json";
	//public static final String participantMobileReportName = "./Reports/ParticipantPortalOnMobile.json";
	//public static final String pptThruAdmnReportName = "./Reports/ParticipantPortalThruAdminLoginSanity.json";
	//public static final String ParticipantForGenThree = "./Reports/ParticipantPortalForGenThreeSanity.json";

	public static String testLocation = util.excelDataProvider.getCellValueByFieldName("Test Location", staticData.suitDataSheetName);
	
	public static String enviormentUnderTest = util.excelDataProvider.getCellValueByFieldName("Enviorment Under Test", staticData.suitDataSheetName);
	public static String browserName = util.excelDataProvider.getCellValueByFieldName("Browser Under Test", staticData.suitDataSheetName);
	//public static final String ImageComparedirectory1 = util.excelDataProvider.getEnvironmentDetailsForSuit("Image Compare Directory 1", suitDataSheetName, needFieldIdentifier);
	//public static final String ImageComparedirectory2 = util.excelDataProvider.getEnvironmentDetailsForSuit("Image Compare Directory 2", suitDataSheetName, needFieldIdentifier);

	public static boolean willTakeScreenShot = util.excelDataProvider.getEnvironmentDetailsForSuit("Capture Screenshot", suitDataSheetName, needFieldIdentifier).toLowerCase().contains("yes");
//	public static String expectedPageTitleFromPreviousStep = null;
	public static String previousPageTitle = null;
	public static boolean willKeepDataRepoinSync = false;
//	public static AcclarisLogger acclarisLogger = new AcclarisLogger();
	public static boolean isPopupPresent = false;

    public static String currentrunningScenarioName = null;
    public static Scenario currentRunningScenario = null;
//	public static boolean scheduleContributionForOneTimeFlag = false;
    public static String loginNode = null;
	public static int maximumWaitTimeForReports = 20 ;
	public static boolean willEmbedURL = util.excelDataProvider.getEnvironmentDetailsForSuit("Embed URL in Screenshot", suitDataSheetName, needFieldIdentifier).toLowerCase().contains("yes");
	public static List<String> ListOfApp = new ArrayList<String>();
	public static List<String> ListOfAppSheet = new ArrayList<String>();
	public static List<String> ListOfAbbreviationSheetname = new ArrayList<String>();	
	/******************************************** Below Variables are for Database ******************************************************************/
	public static List<String> dbQueryResultSetAsList =  new ArrayList<String>();
	public static List<String> webQueryResultSetAsList = new ArrayList<String>();
	public static  List<String> rsString = new ArrayList<String>();
	public static int  pageLoadTime = Integer.parseInt(util.excelDataProvider.getEnvironmentDetailsForSuit("Page Load Time", suitDataSheetName, needFieldIdentifier))/1000;
/****************************************************************************************************************************/
	public static List<String> ListOfcolumn1; 
	public static List<String> ListOfcolumn2;
	public static List<String> ListOfcolumn3;
	public static List<String> ListOfcolumn4;
	public static List<String> ListOfcolumn5;
}
	