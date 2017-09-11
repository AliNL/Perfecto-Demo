import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


public class Demo {

    @Test
    public void Test() {


        DesiredCapabilities capabilities = new DesiredCapabilities();

//        capabilities.setCapability("browserName", "");
//        capabilities.setCapability("version", "");
//        capabilities.setCapability("platform", "ANY");
//        capabilities.setCapability("model", "iPhone-4S");
//        capabilities.setCapability("deviceName", "2B98406ED9EFFD2625A073CABD265802311200A9");
        capabilities.setCapability("windTunnelPersona", "Georgia");


        String host = "your host";
        capabilities.setCapability("user", "your email");
        capabilities.setCapability("password", "your password");


        // create driver
        RemoteWebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL("http://" + host + "/nexperience/perfectomobile/wd/hub"),
                    capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }


//         implicit wait set to 30 due to slowness and timeout issues
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


//         fetch page
        driver.get("https://thoughtworks.com/");


        String title = driver.findElement(By.tagName("h1")).getText();


//         Clean up
        driver.close();
        driver.quit();

        assertEquals("ALWAYS INVENTING, ALWAYS DELIVERING ", title);
    }

}
