package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.WDListener;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class ApplicationManager {

    static  String browser = System.getProperty("browser", "chrome");

    public final static Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    private static  WebDriver driver;
    public static WebDriver getDriver(){
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        logger.info("Start testing " + LocalDate.now() +":" +  LocalTime.now());
       // driver = new ChromeDriver();

       //ChromeOptions chromeOptions = new ChromeOptions();
       // hromeOptions.addArguments("--headless");

        switch (browser.toLowerCase()){
            case "firefox":
                driver = new FirefoxDriver();
                logger.info("Start testing in browser FireFox");
                break;
            case "edge":
                driver = new EdgeDriver();
                logger.info("Start testing in browser Edge");
                break;
            case "chrome":
                //driver = new ChromeDriver(chromeOptions);
                driver = new ChromeDriver();
                logger.info("Start testing in browser Chrome");
                break;
            default:
                driver = new ChromeDriver();
                logger.info("Start testing in browser Chrome");
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        WebDriverListener webDriverListener = new WDListener();
        driver = new EventFiringDecorator<>(webDriverListener).decorate(driver);
        //driver.manage().timeouts().implicitlyWait(10);

    }

    @AfterMethod (enabled = true, alwaysRun = true)
    public void tearDown(){
        logger.info("Stop testing " + LocalDate.now() +":" +  LocalTime.now());
        if (driver != null)
            driver.quit();
    }



}
