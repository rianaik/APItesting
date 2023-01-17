package com.webUItesting.test;

import java.io.File;
import java.io.FileOutputStream;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.webUItesting.pages.*;;


public class setup {
    WebDriver driver;

    loginPage objLoginpage;

    public WebDriverWait wait;
    String username = "standard_user";
    String password = "secret_sauce";

    @BeforeTest
    public void Setup() {

        String OS = System.getProperty("os.name").toLowerCase();
        ChromeOptions options = new ChromeOptions();

        if (OS.contains("mac")) {
            options.setBinary("/usr/local/bin/chromium");
        }

        options.addArguments("headless");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("disable-infobars");
        options.addArguments("--window-size=1400,600");
        options.addArguments("chrome.switches", "--disable-extensions", "--disable-gpu", "--no-sandbox");
        driver = new ChromeDriver(options);

        System.out.println("------------------------------------");
        System.out.println("######Chrome browser testing######");
        System.out.println("------------------------------------");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://saucedemo.com");
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));

        
    }

    @Test(priority = 1)
    public void TestLoginPage() { // calling loginPage
        
        System.out.println("Login test started");
        objLoginpage = new loginPage(driver);
        objLoginpage.UsernameAndPassword(username, password);
        System.out.println("Login test ended");
    }

   /*@Test(dependsOnMethods = { "TestLoginPage" })
    public void TestCampaingSelect() {
        System.out.println("Test 2 started");
        objCampaignSelect = new campaignSelect(driver);
        objCampaignSelect.selectCampaign();
        System.out.println("Test 2 ended");
    }

    @Test(dependsOnMethods = { "TestCampaingSelect" })
    public void TestStep4() throws InterruptedException {
        System.out.println("Test 3 started");
        objStep4 = new step4page(driver);
        objStep4.step4Fill();
        System.out.println("Test 3 ended");
    }

    @Test(dependsOnMethods = { "TestStep4" })
    public void TestPopUp() throws InterruptedException {
        System.out.println("Test 4 started");
        objPopup = new exportPopup(driver);
        objPopup.popUpTagExport();
        System.out.println("Test 4 ended");
    }

    @Test(dependsOnMethods = { "TestPopUp" })
    public void TestservedUrl() throws InterruptedException {
        System.out.println("Test 5 started");
        objServedUrl = new servedUrl(driver);
        objServedUrl.navigateToUrl();
        System.out.println("Test 5 ended");
    }
 */ 
    @AfterTest
    public void quiteDriver() {
        driver.quit();
    }
    File theDir = new File("./target/screenshots/84/");
   
    // It will execute after every test execution
    @AfterMethod
    public void screenshot(ITestResult result) {
        if(ITestResult.FAILURE==result.getStatus()){
        try {
            if (!theDir.exists()) {
                theDir.mkdirs();
            }

            Reporter.setCurrentTestResult(result);
            File source = new File("./target/screenshots/84/" + result.getName() + ".png");

            try {
                FileOutputStream screenshotStream = new FileOutputStream(source);
                screenshotStream.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
                screenshotStream.close();

                Reporter.log("Screenshot taken", true);
                Reporter.log(" <a href='./../screenshots/84/" + result.getName() + ".png" + "'> <img src='./../screenshots/84/"
                        + result.getName() + ".png"
                        + "' height='800' width='1200'/> </a> ");
            } finally {
            }
        } catch (Exception e) {
            Reporter.log("Exception while taking screenshot " + e.getMessage(), true);
        }
    }
    }
}
