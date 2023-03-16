import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CRMData {
    WebDriver driver;

    static String Exe_chrome_path= "C:\\Users\\003RX2744\\chromedriver_win32\\Chromedriver.exe";
    static String CRM_url ="http://alchemy.hguy.co/crm";
    static  String  username ="admin";
    static  String  password ="pa$$w0rd";
    static By uid = By.xpath("//*[@id='user_name']");

    static By pass = By.xpath("//*[@id='username_password']");
    static By loginbutton = By.xpath("//*[@id='bigbutton']");
    static By imagesrc = By.xpath("//div[1]/img");
    static By copyrightText = By.xpath("//*[contains(text(), '© Supercharged by SuiteCRM')]");
static By homepage=By.xpath("/html/body");
static By color=By.xpath("//*[@id='ajaxHeader']/nav/div/div[1]");
static  By Activity_menu =By.xpath("//ul/li[5]/span[2]");

static By Leads=By.xpath("/html/body/div[2]/nav/div/div[2]/ul/li[2]/span[2]/ul/li[5]/a");
static By sales=By.xpath("//*[@id='grouptab_0']");
static By Accounts=By.xpath("//*[@id='moduleTab_9_Accounts']");
static By icon=By.xpath("//*[@id='adspan_1bf01e91-1f26-5249-ed14-63294367a7e5']/span");
static By getMobileNumber =By.xpath("//*[@id='ui-id-5']/span");
static By Row1=By.xpath("//div[3]/table/tbody/tr[1]");
    static By Row3 =By.xpath("//div[3]/table/tbody/tr[3]");
    static By Row5 =By.xpath("//div[3]/table/tbody/tr[5]");
    static By Row7=By.xpath("//div[3]/table/tbody/tr[7]");
    static By Row9=By.xpath("//div[3]/table/tbody/tr[9]");
    static By Names=By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table/tbody/tr/td[3]/b/a");
    static By admin=By.xpath("//*[@id=\"MassUpdate\"]/div[3]/table/tbody/tr/td[8]/a");






    //login function

    public static void Login_fun(WebDriver driver){
//wait for 10 sec
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
        //enter username
        driver.findElement(CRMData.uid).sendKeys(CRMData.username);
        //wait for 10 sec
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);
        //enter password
        driver.findElement(pass).sendKeys(password);
        //wait for 10 sec
        driver.manage().timeouts().implicitlyWait(10 , TimeUnit.SECONDS);

        //click on Login button
        driver.findElement(CRMData.loginbutton).click();
        //wait for 10 sec
        driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);


   }




}
