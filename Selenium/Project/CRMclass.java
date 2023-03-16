
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CRMclass {
WebDriver driver;
    @BeforeMethod
    public void OpenCRM() {
         System.setProperty("webdriver.chrome.driver",CRMData.Exe_chrome_path);

        // Instantiate a ChromeDriver class.
         driver = new ChromeDriver();

        // Maximize the browser
        driver.manage().window().maximize();

        // Launch Website
        driver.get(CRMData.CRM_url);
    }
    @Test(priority = 1)
    public void Verifythewebsitetitle(){

        //wait for 10 sec
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
        String Title = driver.getTitle();
        System.out.println(Title+ "<-this is websitetitle");
        Assert.assertEquals(Title,"SuiteCRM");
        driver.close();

    }
    @Test(priority = 2)
    public void theurlofheaderimage(){
        //wait for 10 sec
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

        //get the url
        String url = driver.findElement(CRMData.imagesrc).getAttribute("src");
        System.out.println("ImageURL"+url);
        driver.close();

    }
    @Test(priority = 3)
    public void getthecopyrighttext(){
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
        String Copyright_Text = driver.findElement(CRMData.copyrightText).getText();
        System.out.println("CopyRightText"+Copyright_Text);
        driver.close();
    }
    @Test(priority = 4)
    public void Loggingintothesite(){
        CRMData.Login_fun(driver);
        //verify homepage
       Boolean home_Title=  driver.findElement(CRMData.homepage).isDisplayed();
       Assert.assertTrue(home_Title);
       driver.close();

    }
    @Test(priority = 5)
    public void getcolorofmenu(){
        CRMData.Login_fun(driver);
        WebElement colorString = driver.findElement(CRMData.color);
        String s = colorString.getCssValue("color");
        String c = Color.fromString(s).asHex() ;
        System.out.println("Hex code for color:" + c);
        driver.close();
    }
    @Test(priority = 6)
    public void menucheck(){
        CRMData.Login_fun(driver);

        boolean present;
        try {
            WebElement wb = driver.findElement(CRMData.Activity_menu);
            Actions mouse = new Actions(driver);
            mouse.moveToElement(wb).perform();
            present = true;
        } catch (NoSuchElementException e) {
            present = false;
        }

        Assert.assertTrue(present);
        driver.close();
    }

    @Test(priority = 7)
    public void Readingadditionalinformation(){
        CRMData.Login_fun(driver);
        //click on sales
        driver.findElement(CRMData.sales).click();
        //wait for 20 sec
        driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);

        //click on leads
        driver.findElement(CRMData.Leads).click();
        //wait for 20 sec
        driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);

         //click on icon
        driver.findElement(CRMData.icon).click();

        //get mobile number from popup
        String mobile= driver.findElement(CRMData.getMobileNumber).getText();
        System.out.println("Mobilenumber from popup" + mobile);
        Assert.assertEquals(mobile,"992345678");
        driver.close();
    }
    @Test(priority = 8)
    public void Traversingtables(){
        CRMData.Login_fun(driver);
        //click on sales
        driver.findElement(CRMData.sales).click();
        //wait for 20 sec
        driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);

        //click on Accounts
        driver.findElement(CRMData.Accounts).click();
        driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);

      String row1Data = driver.findElement(CRMData.Row1).getText();
        System.out.println("Row 1 data ->" + row1Data);

        String  row3Data = driver.findElement(CRMData.Row3).getText();
        System.out.println("Row 3 data ->" + row3Data);

        String row5Data = driver.findElement(CRMData.Row5).getText();
        System.out.println("Row 5 data ->" + row5Data);

        String row7Data = driver.findElement(CRMData.Row7).getText();
        System.out.println("Row 7 data ->" + row7Data);

        String row9Data = driver.findElement(CRMData.Row9).getText();
        System.out.println("Row 9 data ->" + row9Data);
        driver.close();
    }
    @Test(priority = 9)
    public void Traversingtables2(){
        CRMData.Login_fun(driver);
        //click on sales
        driver.findElement(CRMData.sales).click();
        //wait for 20 sec
        driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);

        //click on leads
        driver.findElement(CRMData.Leads).click();
        //wait for 20 sec
        driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);

        List<WebElement> list_name = driver.findElements(CRMData.Names);
        for (var name:list_name
             ) {
            String first_10 =name.getText().toString();
            System.out.println("Names" +first_10);

        }
        List<WebElement> list_admin = driver.findElements(CRMData.admin);
        for (var admin:list_admin
        ) {
            String first_10_admin =admin.getText().toString();
            System.out.println("Admin" +first_10_admin);

        }
        driver.close();

    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

}