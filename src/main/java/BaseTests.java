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

    /**
     * Opens browser with the given viewport size
     * @param browser      String - browser name: chrome or firefox
     * @param device       String - device name: laptop, tablet or mobile
     */
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

    /**
     * Sets the viewport size based on the device type
     * @param device       String - device name: laptop, tablet or mobile
     */
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

    /**
     * JS Executor to set the window size based on the width and height of the viewport
     * @param width       int - width of the viewport
     * @param height      int - height of the viewport
     */
    private void jsExecutorForViewport(int width, int height) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String windowSize = js.executeScript("return (window.outerWidth - window.innerWidth + " + width + ") + " +
                "',' + (window.outerHeight - window.innerHeight + " + height + "); ").toString();
        int _width = Integer.parseInt(windowSize.split(",")[0]);
        int _height = Integer.parseInt(windowSize.split(",")[1]);
        driver.manage().window().setSize(new Dimension(_width, _height));
    }

    /** Goes to the home page of Version 1 */
    public void goHomeV1() {
        driver.get("https://demo.applitools.com/gridHackathonV1.html");
        homePage = new HomePage(driver);
    }

    /** Goes to the home page of Version 2 */
    public void goHomeV2() {
        driver.get("https://demo.applitools.com/gridHackathonV2.html");
        homePage = new HomePage(driver);
    }

    /** Quits the browser */
    @AfterClass(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    /**
     * Prints Version 1 test results in the following format:
     * Example: Task: 1, Test Name: Search field is displayed, DOM Id: DIV__customsear__41, Browser: Chrome, Viewport: 1200 x 700, Device: Laptop, Status: Pass
     * @param task        int - task number, values: 1, 2 or 3
     * @param testName    String - e.g. Search field is displayed
     * @param domId       String - DOM ID of the element
     * @param result      boolean - result of comparing the expected and the actual values
     * @return			  boolean - comparison result so that it can be used for assertions in the test code
     */
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

    /**
     * Prints Version 2 test results in the following format:
     * Example: Task: 1, Test Name: Search field is displayed, DOM Id: DIV__customsear__41, Browser: Chrome, Viewport: 1200 x 700, Device: Laptop, Status: Pass
     * @param task        int - task number, values: 1, 2 or 3
     * @param testName    String - e.g. Search field is displayed
     * @param domId       String - DOM ID of the element
     * @param result      boolean - result of comparing the expected and the actual values
     * @return			  boolean - comparison result so that it can be used for assertions in the test code
     */
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
