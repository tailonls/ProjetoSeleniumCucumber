package runners;

import static core.DriverFactory.killDriver;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import core.BaseTest;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", glue = "steps", tags = {
		"@aluguel" }, plugin = "pretty", monochrome = true, snippets = SnippetType.CAMELCASE, dryRun = false, strict = false)
public class Alugar extends BaseTest {

	@BeforeClass
	public static void resetar() {

		killDriver();
	}
}