package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver; //Singleton web driver
    static {   // public static driverBaslat() // bunun şartı extens olması ve basta yer alması
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    public static void BekleVeKapat(){
        MyFunc.bekle(3);
        driver.quit();

    }
}
