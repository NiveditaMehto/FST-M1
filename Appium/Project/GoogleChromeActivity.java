package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.AfterClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class GoogleChromeActivity {
    AndroidDriver driver;
    WebDriverWait wait;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the page in Chrome
        driver.get("https://www.training-support.net/selenium");
    }

    // Test method
    @Test
    public void chromeTest() throws InterruptedException {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";

        // Wait for page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.TextView")));

        // Scroll using UiScrollable
        WebElement get = driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"To-Do List\")"));
        Thread.sleep(5000);
        // Get click elements after scroll
        get.click();

        Thread.sleep(8000);
        //add task
        driver.findElement(AppiumBy.id( "taskInput")).sendKeys("First Task3444");


        //get add task
        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button")).click();

        Thread.sleep(4000);
//add task
        driver.findElement(AppiumBy.id( "taskInput")).sendKeys("second Task5677");


        //get add task
        driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[1]/android.widget.Button")).click();

//list
        List<WebElement> tasklist =driver.findElements(AppiumBy.id(  "tasksList"));
        System.out.println("totaltasks " + tasklist.size());

        //clear list

        driver.findElement(AppiumBy.xpath(  "\t\n" +
                "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[3]/android.widget.TextView[2]")).click();
        // Assertions

        //click on each task
        driver.findElement(AppiumBy.xpath( "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.TextView")).click();
driver.findElement(AppiumBy.xpath(
        "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View[3]/android.widget.TextView")).click();

        Assert.assertEquals(tasklist.size(), 0);
    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
