package US9;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

public class Senaryo9 extends BaseDriver {

    @Test
    public void test9(){
        driver.get("https://demowebshop.tricentis.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        Actions action = new Actions(driver);

        try {
            action.click(driver.findElement(By.cssSelector(".ico-logout"))).perform();

        } catch (Exception e) {
            System.out.println("Logout ise bu adımı yapma");
        }

        action.click(driver.findElement(By.cssSelector(".ico-login"))).perform();
        action.sendKeys(driver.findElement(By.cssSelector("#Email")), "qahmet@gmail.com");
        action.sendKeys(driver.findElement(By.cssSelector("#Password")), "cyprus1");
        action.click(driver.findElement(By.xpath("//input[@type='submit'][@value='Log in']")));
        action.perform();
        action.click(driver.findElement(By.cssSelector(".account"))).perform();
        action.click(driver.findElement(By.xpath("(//a[text()='Orders'])[1]"))).perform();
        action.click(driver.findElement(By.xpath("(//input[@type='button'])[2]"))).perform();
        action.click(driver.findElement(By.cssSelector("[class='button-2 pdf-order-button']"))).perform();

        WebElement orderText =
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".order-number")));
        String orderNumber = orderText.getText().substring(7);

        // Tab sayısı değişiklik gösterebilir indirilen pdf ye gelene kadar tabları sayın.

        Actions actions = new Actions(driver);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 26; i++) {

            actions.sendKeys(Keys.TAB).perform();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            if (i == 25) {
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_CONTROL);
            }
        }

        Set<String> windowHandles = driver.getWindowHandles();
        String[] handles = windowHandles.toArray(new String[0]);
        driver.switchTo().window(handles[1]);
        String secondTabTitle = driver.getCurrentUrl();
        Assert.assertTrue(secondTabTitle.contains(orderNumber));

        BekleVeKapat();








    }
}
