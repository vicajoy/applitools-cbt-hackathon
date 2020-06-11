import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.BufferedWriter;
import java.io.FileWriter;


public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;
    protected static EyesManager eyesManager;
    public String viewport;
    public String deviceName;
    public String browserName;

    SoftAssertions softAssert = new SoftAssertions();

    @Parameters({"browser", "device"})
    @BeforeClass(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser, @Optional("laptop") String device) {
        switch (browser) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
                setViewportSize(device);
                browserName = "Chrome";
            }
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                driver = new FirefoxDriver();
                setViewportSize(device);
                browserName = "Firefox";
            }
            default -> {
                System.out.println("Do not know how to start " + browser + ", starting chrome.");
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                driver = new ChromeDriver();
                setViewportSize(device);
                browserName = "Chrome";
            }
        }
        eyesManager = new EyesManager(driver, "Applifashion");
        eyesManager.setBatchName("UFG Hackathon");
    }

    private void setViewportSize(String device) {
        switch (device) {
            case "laptop" -> {
                jsExecutorForViewport(1200, 700);
                viewport = "1200 x 700";
                deviceName = "Laptop";
            }
            case "tablet" -> {
                jsExecutorForViewport(768, 700);
                viewport = "768 x 700";
                deviceName = "Tablet";
            }
            case "mobile" -> {
                jsExecutorForViewport(500, 700);
                viewport = "500 x 700";
                deviceName = "Mobile";
            }
        }
    }

    private void jsExecutorForViewport(int width, int height) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String windowSize = js.executeScript("return (window.outerWidth - window.innerWidth + " + width + ") + " +
                "',' + (window.outerHeight - window.innerHeight + " + height + "); ").toString();
        int _width = Integer.parseInt(windowSize.split(",")[0]);
        int _height = Integer.parseInt(windowSize.split(",")[1]);
        driver.manage().window().setSize(new Dimension(_width, _height));
    }

    public void goHomeV1() {
        driver.get("https://demo.applitools.com/gridHackathonV1.html");
        homePage = new HomePage(driver);
    }

    public void goHomeV2() {
        driver.get("https://demo.applitools.com/gridHackathonV2.html");
        homePage = new HomePage(driver);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    public boolean reporterV1(int task, String testName, String domId, boolean result) {
        var content = "Task: " + task + ", Test Name: " + testName + ", DOM Id: " + domId + ", Browser: " + browserName
                + ", Viewport: " + viewport + ", Device: " + deviceName + ", Status: " + (result ? "Pass" : "Fail");
        try (var writer = new BufferedWriter(new FileWriter("Traditional-V1-TestResults.txt", true))) {

            System.out.println(content);
            writer.write(content);
            writer.newLine();
        } catch (Exception e) {
            System.out.println("Error occurred while writing to report file.");
            e.printStackTrace();
        }
        return result;
    }

    public boolean reporterV2(int task, String testName, String domId, boolean result) {
        var content = "Task: " + task + ", Test Name: " + testName + ", DOM Id: " + domId + ", Browser: " + browserName
                + ", Viewport: " + viewport + ", Device: " + deviceName + ", Status: " + (result ? "Pass" : "Fail");
        try (var writer = new BufferedWriter(new FileWriter("Traditional-V2-TestResults.txt", true))) {

            System.out.println(content);
            writer.write(content);
            writer.newLine();
        } catch (Exception e) {
            System.out.println("Error occurred while writing to report file.");
            e.printStackTrace();
        }
        return result;
    }

}
