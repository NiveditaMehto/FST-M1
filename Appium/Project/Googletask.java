package activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


public class Googletask {
    AndroidDriver driver;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.tasks");
        options.setAppActivity(".ui.TaskListsActivity");
        options.noReset();

        // Server Address
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
    }
    @Test
    public void AddNote() throws InterruptedException {
        // click on add task
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Get FST m1 certification");
        //click on save button
        Thread.sleep(5000);
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        //second task
        Thread.sleep(5000);
        // click on add task
        driver.findElement(AppiumBy.accessibilityId("Create new task")).click();
        Thread.sleep(5000);
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")).sendKeys("Get FST m2 certification");
        //click on save button
        Thread.sleep(5000);
        driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done")).click();

        Thread.sleep(5000);

        String taskIsPresnt=driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/task_name")).getText();

System.out.println(taskIsPresnt);
        Thread.sleep(5000);
        // Assertion
        Assert.assertTrue(taskIsPresnt.equals("Get FST m1 certification"));

    }


    // Tear down method
    @AfterClass
    public void tearDown() {
        // Close the app
        driver.quit();
    }
}
