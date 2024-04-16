package org.openlib.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestBaseClass {

    public final static int TIMEOUT = 10;
    public static String authorNameWeb;
    public static String authorNameApi;
    private static TestBaseClass helperClass;
    private static WebDriver driver;

    private TestBaseClass() {

        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        //setting chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("incognito");
        options.addArguments("disable-application-cache");
        options.addArguments("disk-cache-size=0");
        options.addArguments("--privileged");
        options.addArguments("--disable-gpu");
        options.addArguments("--start-maximized"); // open Browser in maximized mode
        options.addArguments("--disable-infobars"); // disabling infobars
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--whitelisted-ips='127.0.0.1'");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--chrome-frame");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-ipc-flooding-protection");
        options.addArguments("--disable-backgrounding-occluded-window");
        options.addArguments("--disable-breakpad");
        options.addArguments("--password-store=basic");
        options.addArguments("--hide-scrollbars");
        options.addArguments("--devtools");
        options.addArguments("--ipc=host");

        options.addArguments("--disable-web-security");
        options.addArguments("--allow-insecure-localhost");
        options.addArguments("--ignore-urlfetcher-cert-requests");
        options.merge(options);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
        driver.manage().window().maximize();

    }


    public static void openPage(String url) {
        driver.get(url);
    }


    public static WebDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {

        if (helperClass == null) {

            helperClass = new TestBaseClass();
        }
    }

    public static void tearDown() {

        if (driver != null) {
            driver.close();
            driver.quit();
        }

        helperClass = null;
    }
}
