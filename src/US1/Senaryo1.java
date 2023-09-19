package US1;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class Senaryo1 extends BaseDriver {

    @Test
    public void test1(){
        driver.get("https://demowebshop.tricentis.com/");
        driver.findElement(By.cssSelector(".ico-register")).click();

        Actions action = new Actions(driver);
        action.click(driver.findElement(By.cssSelector("#gender-male")));
        action.sendKeys(driver.findElement(By.cssSelector("#FirstName")), "Ahmet");
        action.sendKeys(driver.findElement(By.cssSelector("#LastName")), "Qa");
        action.sendKeys(driver.findElement(By.cssSelector("#Email")), "qahmet16@gmail.com");
        action.sendKeys(driver.findElement(By.cssSelector("#Password")), "cyprus1");
        action.sendKeys(driver.findElement(By.cssSelector("#ConfirmPassword")), "cyprus1");
        action.click(driver.findElement(By.cssSelector("#register-button")));
        action.perform();

        try {
            String result = driver.findElement(By.cssSelector(".page-body > .result")).getText();
            Assert.assertEquals("Your registration completed", result);
            action.click(driver.findElement(By.cssSelector(".header-links > ul > li + li > a.ico-logout")));
        } catch (Exception e) {
            System.out.println("Üyelik daha önce yapıldığından dolayı bu adımı geçebiliriz.");
        }
        BekleVeKapat();






    }




}
