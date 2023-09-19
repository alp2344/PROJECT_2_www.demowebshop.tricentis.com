package US5;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Senaryo5 extends BaseDriver {


    @Test
    public void test2(){
        driver.get("https://demowebshop.tricentis.com/");

        Actions action = new Actions(driver);

        String[] emailArray = {"", "qahmet1@gmail.com", "", "ozgur6@gmail.com"};
        String[] passwordArray = {"", "", "cyprus1", "Ankara02"};

        try {
            action.click(driver.findElement(By.cssSelector(".ico-logout"))).perform();
        } catch (Exception e) {
            System.out.println("Login değil ise bu adımı yapma");
        }

        for (int i = 0; i < emailArray.length; i++) {
            action.click(driver.findElement(By.cssSelector(".ico-login"))).perform();
            action.sendKeys(driver.findElement(By.cssSelector("#Email")), emailArray[i]);
            action.sendKeys(driver.findElement(By.cssSelector("#Password")), passwordArray[i]);
            action.click(driver.findElement(By.xpath("//input[@type='submit'][@value='Log in']")));
            action.perform();
            String result = driver.findElement(By.cssSelector(".validation-summary-errors > span")).getText();
            Assert.assertEquals("Login was unsuccessful. Please correct the errors and try again.", result);
        }

        BekleVeKapat();





    }
}
