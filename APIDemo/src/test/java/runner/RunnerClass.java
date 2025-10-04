package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features/GetProduct.feature","src/test/java/features/DeleteProduct.feature",
                     "src/test/java/features/InsertProduct.feature","src/test/java/features/UpdateProduct.feature"},
        glue ="stepdefination",
        dryRun = true,
        plugin = {"pretty", "html:target/cucumber-report.html"},
        monochrome = false
)
public class RunnerClass {
}
