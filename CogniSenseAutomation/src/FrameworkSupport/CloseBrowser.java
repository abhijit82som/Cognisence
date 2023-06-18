package FrameworkSupport;


import org.junit.runner.RunWith;

import util.staticData;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./Features"
		,glue={"stepDefinition"}		
		,tags = {"@closeBrowser"}
		)
public class CloseBrowser {
	

}