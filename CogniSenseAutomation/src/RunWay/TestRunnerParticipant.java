package RunWay;
import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import com.beust.jcommander.Parameters;

import util.staticData;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)

@CucumberOptions(
		
		features = "./Features/Testcase"
		,tags = {"@Login,@Test,@Logoff"}
		,format = {"pretty",  "json:"+staticData.participantReportName}
		,glue={"stepDefinition"}
			
		)
public abstract class TestRunnerParticipant {
	
	}