import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.BrowserType;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.visualgrid.model.DeviceName;
import com.applitools.eyes.visualgrid.model.ScreenOrientation;
import com.applitools.eyes.visualgrid.services.VisualGridRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EyesManager {

    private Eyes eyes;
    private String appName;
    private WebDriver driver;

    public EyesManager(WebDriver driver, String appName) {
        this.driver = driver;
        this.appName = appName;
        eyes = new Eyes(new VisualGridRunner(5));
        eyes.setApiKey(System.getenv("API_KEY"));
        eyes.setConfiguration(getConfig());
    }

    public void setBatchName(String batchName) {
        eyes.setBatch(new BatchInfo(batchName));
    }

    public void validateWindow(String testName, String stepName) {
        eyes.open(driver, appName, testName);
        eyes.setMatchLevel(MatchLevel.STRICT);
        eyes.checkWindow(stepName);
        eyes.close();
    }

    public void validateElement(By locator, String testName, String stepName) {
        eyes.open(driver, appName, testName);
        eyes.setMatchLevel(MatchLevel.STRICT);
        eyes.checkElement(locator, stepName);
        eyes.close();
    }

    private static Configuration getConfig() {
        Configuration vgConfig = new Configuration();
        vgConfig.addBrowser(1200, 700, BrowserType.CHROME);
        vgConfig.addBrowser(1200, 700, BrowserType.FIREFOX);
        vgConfig.addBrowser(1200, 700, BrowserType.EDGE);
        vgConfig.addBrowser(768, 700, BrowserType.CHROME);
        vgConfig.addBrowser(768, 700, BrowserType.FIREFOX);
        vgConfig.addBrowser(768, 700, BrowserType.EDGE);
        vgConfig.addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT);
        return vgConfig;
    }
}

