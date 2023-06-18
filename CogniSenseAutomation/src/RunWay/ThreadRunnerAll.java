package RunWay;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import net.masterthought.cucumber.ReportBuilder;
import oracle.net.jdbc.TNSAddress.Description;

import org.apache.bcel.generic.NEW;
import org.apache.commons.io.FileUtils;
import org.junit.internal.runners.InitializationError;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;

import cucumber.deps.difflib.DiffRow.Tag;
import cucumber.runtime.ClassFinder;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.RuntimeOptionsFactory;
import cucumber.runtime.io.MultiLoader;
import cucumber.runtime.io.ResourceLoader;
import cucumber.runtime.io.ResourceLoaderClassFinder;
import cucumber.runtime.junit.FeatureRunner;
import cucumber.runtime.junit.JUnitReporter;
import cucumber.runtime.model.CucumberFeature;
import cucumber.runtime.model.CucumberTagStatement;
//import com.acclaris.annotations.SomeAnnotation;
//import com.acclaris.impl.AnnotationAppliedOnClass;
import util.staticData;
import util.business.ReportParser;
import util.business.postMan;
import util.general.ElementUtil;
import util.*;
import cucumber.runtime.Runtime;

public class ThreadRunnerAll {

	private static Runtime runtime ;
	private static JUnitReporter jUnitReporter;
    public static void main(String s[]) {
		
		List<String> jsonReportFiles = new ArrayList<String>();
		int userType = Integer.parseInt(
				util.excelDataProvider.getCellValueByFieldName("User Type to Run", staticData.suitDataSheetName));
		staticData.enviormentUnderTest = util.excelDataProvider.getCellValueByFieldName("Enviorment Under Test",
				staticData.suitDataSheetName);
		String platform = staticData.enviormentUnderTest;
		staticData.suitToRun = util.excelDataProvider.getCellValueByFieldName("Suit To Run",
				staticData.suitDataSheetName);

		try {
			if (!s[0].isEmpty()) {
				staticData.enviormentUnderTest = s[0];
				platform = staticData.enviormentUnderTest;
				testRunner(jsonReportFiles, userType, platform);
			}
		} catch (Exception e) {
			if (platform.equalsIgnoreCase("All")) {
				List<String> enviormentList = excelDataProvider.getAllRunnableEnviroments();
				for (String currentenviormentList : enviormentList) {
					staticData.enviormentUnderTest = currentenviormentList;
					testRunner(jsonReportFiles, userType, staticData.enviormentUnderTest);
				}
			} else {
				testRunner(jsonReportFiles, userType, staticData.enviormentUnderTest);
			}
		}

	}

	private static void backUpReports(List<String> jsonReportFiles, String platform) {
		for (String BackupjsonReportFiles : jsonReportFiles) {
			try {
				String oldFileName = System.getProperty("user.dir") + "/Reports/"
						+ BackupjsonReportFiles.toString().substring(BackupjsonReportFiles.toString().lastIndexOf("/"));
				File newFile = new File(System.getProperty("user.dir") + "/Reports/" + "Backup/"
						+ ElementUtil.getUniqueFileName(BackupjsonReportFiles.toString()
								.substring(BackupjsonReportFiles.toString().lastIndexOf("/")), platform));
				File oldFile = null;
				String newFileName = newFile.toString();
				newFileName = newFileName.replace("]", "");
				oldFileName = oldFileName.replace("]", "");
				newFile = new File(newFileName);
				oldFile = new File(oldFileName);
				FileUtils.copyFile(oldFile, newFile);
				System.out.println("Backed Up Report at : " + newFileName);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void runTestCase(Class testCase) {
		try {
			ElementUtil.closeBrowser();
		} catch (Exception e) {

		}

		ElementUtil.deleteAllTempFiles();
		Result result = JUnitCore.runClasses(testCase);
		//Result result1 = JUnitCore.
		for (Failure failure : result.getFailures()) {
			System.out.println("---------------------------------------------------------");
			System.out.println("------------             ALERT         ------------------");
			System.out.println("-------  Failure Running Test Class : " + testCase.toString() + "------------------");
			System.out.println("---------------------------------------------------------");
			System.out.println(failure.toString());
			System.out.println(failure.toString());
		}
		try {
			ElementUtil.closeBrowser();
		} catch (Exception e) {
		}

	}

	public static void testRunner(List<String> jsonReportFiles, int userType, String platform) {
		ReportBuilder reportBuilder1;

		if (userType == 1) {
			String pptUser = "Cogni Sense";
			String allUser = "<html><br />Participant Username : " + pptUser + "</html>";
			staticData.userNames = allUser;
			FrameworkSupport.SomeAnnotation annotation = FrameworkSupport.AnnotationAppliedOnClass.class
					.getAnnotation(FrameworkSupport.SomeAnnotation.class);
			annotation.getClass();
		 	staticData.userType = "Cogni Sense"; 
						
			runTestCase(RunWay.TestRunnerRegression.class);
			jsonReportFiles.add(staticData.participantReportName );
		}
		
		if (userType == 2) {
			staticData.userType = "Cogni Sense";
			runTestCase(APPCreateScenario.class);
	        runTestCase(TestRunnerAPP.class);
			ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();	
			String tag1 ="@";
			String tag2 ="";
			for (int i=0; i<staticData.ListOfAbbreviationSheetname.size();i++)
			{
				String tag = staticData.ListOfAbbreviationSheetname.get(i);
				tag2 = tag1+tag+","+tag2;
			}
		String tag3 ="@Login,"+tag2.substring(0, tag2.length()-1)+",@Logoff";
			try {
				try {
					//cucumber.api.cli.Main.main(	
					cucumber.api.cli.Main.run(
						     new String[]{
						    "classpath:","./Features/Testcase", 
						   // "-name", "Verify the PM KPIs Analytics App exists in a Application",
						    //"-t","@BVT1,@BVT",
						    "-t",tag3,
						    "-g","stepDefinition",
						    "-p","json:"+staticData.participantReportName, 
						    "-m"
						     },contextClassLoader 
						  	);
				} catch (Throwable e) {
					e.printStackTrace();
				}
		   } catch (Exception e) {
			   System.out.println(e);
		   } 
			try {
				ElementUtil.closeBrowser();
			} catch (Exception e) {
			}
    		String pptUser = staticData.userNames + util.excelDataProvider.getCellValueByFieldName("UserName",staticData.suitDataSheetName);
			jsonReportFiles.add(  staticData.participantReportName );
			String allUser = "<html><br />APP Username : "+"WS"+"<br />"+"Participant Username : "+pptUser+"</html>";
		}
		
		if (userType == 3) {
			
			String pptUser = "Cogni Sense";
			String allUser = "<html><br />Participant Username : " + pptUser + "</html>";
			staticData.userNames = allUser;
			FrameworkSupport.SomeAnnotation annotation = FrameworkSupport.AnnotationAppliedOnClass.class
					.getAnnotation(FrameworkSupport.SomeAnnotation.class);
			annotation.getClass();
		 // staticData.userType = "PPT_On_Browser : " + ElementUtil.getBrowserType();
			staticData.
			userType = "Cogni Sense"; 
			runTestCase(RunWay.TestRunnerSanity.class);
			jsonReportFiles.add(staticData.participantReportName );
					}
            if (userType == 4) {
			
			String pptUser = "Cogni Sense";
			System.out.println("aaaaaaaaaaaaaaaaa");
			String allUser = "<html><br />Participant Username : " + pptUser + "</html>";
			staticData.userNames = allUser;
			FrameworkSupport.SomeAnnotation annotation = FrameworkSupport.AnnotationAppliedOnClass.class
					.getAnnotation(FrameworkSupport.SomeAnnotation.class);
			annotation.getClass();
		 // staticData.userType = "PPT_On_Browser : " + ElementUtil.getBrowserType();
			staticData.userType = "Cogni Sense"; 
			runTestCase(RunWay.TestRunnerParticipant.class);
			jsonReportFiles.add(staticData.participantReportName );
					}
		try {

			File reportOutputDirectory = new File("./Reports/" + staticData.enviormentUnderTest + "/TestReports_"
					+ util.general.ElementUtil.getDate("yyyy-MM-dd"));
			System.out.println("staticData.userNames : " + staticData.userNames);
			System.out.println("Report Output Directory : " + reportOutputDirectory);
			reportBuilder1 = new ReportBuilder(jsonReportFiles, reportOutputDirectory, "123",
					platform + " : " + util.general.ElementUtil.getDate("yyyy-MM-dd") + " URL : "
							+ util.business.enviormentDetails.connURL()[0] + staticData.userNames,
					"cucumber-jvm", false, true, true, true, false, "s", false);
			reportBuilder1.generateReports();
			if (util.excelDataProvider
					.getCellValueByFieldName("Will send logs via e-Mail", staticData.suitDataSheetName)
					.equalsIgnoreCase("Yes"))
			postMan.sendMail(reportOutputDirectory.toString(), staticData.enviormentUnderTest, staticData.userType);
			backUpReports(jsonReportFiles, platform);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
			}

