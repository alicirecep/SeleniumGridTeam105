package utilities;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SeleniumGridDrivers {

     static DesiredCapabilities cap = new DesiredCapabilities();
    static WebDriver driver;


    public static WebDriver remoteDriverChromeOptions(){

        try {
            driver = new RemoteWebDriver(new URL("http://192.168.95.54:4444"),new ChromeOptions());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }


    public static WebDriver remouteDriverFirefoxOptions(){

        try {
            driver = new RemoteWebDriver(new URL("http://192.168.95.54:4444"),new FirefoxOptions());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }


    public static WebDriver remouteDriverEdgeOptions(){

        try {
            driver = new RemoteWebDriver(new URL("http://192.168.95.54:4444"),new EdgeOptions());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        return driver;
    }

    public static WebDriver setUpRemoteChromeDriver(){
        try{
            cap.setPlatform(Platform.WINDOWS);
            cap.setBrowserName("chrome");
            cap.setVersion("109.0.1518.70");
            ChromeOptions options=new ChromeOptions();
            options.merge(cap);
            driver=new RemoteWebDriver(new URL("http://192.168.95.54:4444"),options);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }catch (Exception e){
            System.out.println("Chrome Driver couldn't find "+e.getMessage());
        }
        return driver;
    }

    public static WebDriver setUpRemoteEdgeDriver(){
        try{
            cap.setPlatform(Platform.WINDOWS);
            cap.setBrowserName("edge");
            cap.setVersion("109.0.1518.70");
            EdgeOptions options=new EdgeOptions();
            options.merge(cap);
            driver=new RemoteWebDriver(new URL("http://192.168.95.54:4444"),options);//http://192.168.8.108:4444
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }catch (Exception e){
            System.out.println("Edge Driver couldn't find "+e.getMessage());
        }
        return driver;
    }







}
