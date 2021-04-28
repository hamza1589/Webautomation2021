package com.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static String sauceUserName = "";
    public static String sauceKey = "";
    public static String browserStackUserName = "";
    public static String browserStackKey = "";
    //http:// + username + : + key + specific url for cloud
    public static String SAUCE_URL = "http://" + sauceUserName + ":" + sauceKey + "@ondemand.saucelabs.com:";
    public static String BROWSERSTACK_URL = "http://" + browserStackUserName + ";" + browserStackKey + "@hub";

    @Parameters({"platform", "url", "browser", "cloud", "browserVersion", "envName"})
    @BeforeMethod
    public static WebDriver setUpDriver(String platform, String url, String browser, boolean cloud, String browserVersion, String envName) throws MalformedURLException {
        if (cloud) {
            driver = getCloudDriver(browser, browserVersion, platform, envName);
        } else {
            driver = getLocalDriver(browser, platform);
        }
        driver.get(url);
        return driver;
    }
        public static WebDriver getLocalDriver (String browser, String platform){
            if (platform.equalsIgnoreCase("mac") && browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "../generic/src/main/resources/chromedriver");
                driver = new ChromeDriver();

            } else if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "../generic/src/main/resources/chromedriver.exe");
                driver = new ChromeDriver();

            } else if (platform.equalsIgnoreCase("mac") && browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "../generic/src/main/resources/geckodriver");
                driver = new FirefoxDriver();

            } else if (platform.equalsIgnoreCase("windows") && browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "../generic/src/main/resources/geckodriver.exe");
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            return driver;
        }
        public static WebDriver getCloudDriver (String browser, String browserVersion, String platform, String envName) throws MalformedURLException {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("name", "Cloud Execution");
            desiredCapabilities.setCapability("broserName", "browser");
            desiredCapabilities.setCapability("browser_version", "browserVersion");
            desiredCapabilities.setCapability("os", "platform");
            desiredCapabilities.setCapability("os_version", "Mojave");
            desiredCapabilities.setCapability("resolution", "1600x1200");
            if (envName.equalsIgnoreCase("saucelabs")) {
                driver = new RemoteWebDriver(new URL(SAUCE_URL), desiredCapabilities);
            } else if (envName.equalsIgnoreCase("browserstack")) {
                driver = new RemoteWebDriver(new URL(BROWSERSTACK_URL), desiredCapabilities);
            }
            return driver;
        }

        public void setupUrl (String url){
            driver.get(url);

        }


        public static void sleepFor ( int second){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void closeDriver () {

            driver.close();
        }
    }

