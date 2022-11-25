package hooks;

import com.browserstack.local.Local;
import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.driver;
import static constants.web.ApplicationConstants.Application;

public class Hooks_Stepdefs{
    public static Properties prop;
    public Local bsLocal;
    public static final String USERNAME = "naveehans1";
    public static final String AUTOMATE_KEY = "9xERiUTHsZDojpw8QB1E";
    public static final String HUB_URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
    public Hooks_Stepdefs(){

    }

    public Properties getConfigProperty(){
        try {
            prop = new Properties();
            String absolutePath = System.getProperty("user.dir");
            String filePath = absolutePath + Application.PropertiesFilePath;
            FileInputStream fis = new FileInputStream(filePath);
            prop.load(fis);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return prop;
    }

    @Before
    public void initializeBrowser(Scenario scenario) throws Exception {
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        browserstackOptions.put("local", "false");
        browserstackOptions.put("os", "Windows");
        browserstackOptions.put("osVersion", "10");
        browserstackOptions.put("projectName", "Marketing Website v2");
        browserstackOptions.put("buildName", "alpha_0.1.7");
        browserstackOptions.put("sessionName", scenario.getName());
        Configuration.browserCapabilities.setCapability("bstack:options", browserstackOptions);
        Configuration.browserCapabilities.setCapability("browserName", "chrome");
        Configuration.browserCapabilities.setCapability("browserVersion", "latest");
        Configuration.remote = HUB_URL;
        Configuration.timeout = 20000;
        //Configuration.browser = getConfigProperty().getProperty("CHROME");
        launchApplication(getConfigProperty().getProperty("url"));
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor)webdriver().driver().getWebDriver();
        if(scenario.getStatus()== Status.PASSED) {
            js.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"<reason>\"}}");
        }
        else if(scenario.getStatus()== Status.FAILED) {
            js.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"<reason>\"}}");
        }
        closeWindow();
        closeWebDriver();
    }

    public void launchApplication(String appURL){
        open(appURL);
    }
}
