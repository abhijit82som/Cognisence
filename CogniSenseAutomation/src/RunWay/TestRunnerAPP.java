package RunWay;
import java.io.File;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.runner.RunWith;

import com.beust.jcommander.Parameters;

import util.staticData;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./Features/Common"
		,glue={"stepDefinition"}
		,format = {"pretty",  "json:"+staticData.allImageCheckReportName}
		,tags = {"@scenarioTestApp"}
		
		)
public abstract class TestRunnerAPP {
}