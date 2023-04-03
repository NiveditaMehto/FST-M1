package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleKeepApp {
    AndroidDriver driver;

    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.keep");
        options.setAppActivity(".activities.BrowseActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }

    // Test method
    @Test
    public void AddNote() {
        // Perform the calculation
        driver.findElement(AppiumBy.accessibilityId("New text note")).click();
        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title")).sendKeys("Mobile Testing");
        driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text")).sendKeys("APPIUM is a freely distributed open source mobile application UI Testing framework. Appium allows native, hybrid and web application testing and supports automation test on physical devices as well as an emulator or simulator both.");
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();

        String noteIsPresnt=driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title")).getText();



        // Assertion
        Assert.assertEquals(noteIsPresnt, "Mobile Testing");
    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
