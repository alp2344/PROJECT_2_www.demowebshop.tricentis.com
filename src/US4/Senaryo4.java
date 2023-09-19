package US4;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Senaryo4 extends BaseDriver {

    @Test
    public void test4(){

        driver.get("https://demowebshop.tricentis.com/");

        Actions action = new Actions(driver);
        action.click(driver.findElement(By.cssSelector(".ico-login"))).perform();
        action.sendKeys(driver.findElement(By.cssSelector("#Email")), "qahmet1@gmail.com");
        action.sendKeys(driver.findElement(By.cssSelector("#Password")), "cyprus1");
        action.click(driver.findElement(By.xpath("//input[@type='submit'][@value='Log in']")));
        action.perform();

        String result = driver.findElement(By.xpath("(//div[@class='header-links']//a)[1]")).getText();
        Assert.assertEquals("qahmet1@gmail.com", result);

        BekleVeKapat();





    }




}
