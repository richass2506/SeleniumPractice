package org.example;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);


        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--main orangehrm-login-button\"]")).click();
        driver.findElement(By.xpath("(//span[@class=\"oxd-text oxd-text--span oxd-main-menu-item--name\"])[2]")).click();
        WebElement list = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]"));
        WebElement list2 = driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[3]"));
        list.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].innerText = 'Full-Time Contract';", list);
        list2.click();
        js.executeScript("arguments[0].innerText='HR Manager';", list2);

        driver.findElement(By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]")).click();

        driver.findElement(By.xpath("(//i[@class=\"oxd-icon bi-pencil-fill\"])[1]")).click();

        driver.findElement(By.xpath("(//input[@class=\"oxd-input oxd-input--active\" and @placeholder=\"yyyy-dd-mm\"])[2]")).sendKeys("1991-03-03");

        driver.findElement(By.xpath("(//span[@class=\"oxd-radio-input oxd-radio-input--active --label-right oxd-radio-input\"])[1]")).click();
        WebElement marriedStatus= driver.findElement(By.xpath("(//div[@class=\"oxd-select-text-input\"])[2]"));
        marriedStatus.click();
        js.executeScript("arguments[0].innerText='Other';", marriedStatus);
        String mainwindow= driver.getWindowHandle();
        System.out.println(mainwindow);
        driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
      // WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='navbar-brand nav-logo' and img[@alt='OrangeHRM Logo']]")));
         System.out.println("new page opened");

         for(String windowhandle: driver.getWindowHandles())
         {
             if(!mainwindow.equals(windowhandle))
             {
                 driver.switchTo().window(windowhandle);
              WebElement newbutton= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"Form_submitForm_action_request\"]")));
              newbutton.click();
              driver.close();
             }
         }
         driver.switchTo().window(mainwindow);
         WebElement checkbox= driver.findElement(By.xpath("//i[@class=\"oxd-icon bi-check oxd-checkbox-input-icon\"]"));
        checkbox.click();
        js.executeScript("window.scrollTo(0,-1000);");
        driver.navigate().back();
        /*TakesScreenshot shot= (TakesScreenshot)driver;
        File srcFile= shot.getScreenshotAs(OutputType.FILE);
        File destFile= new File("C:/Users/siddh/IdeaProjects/SeleniumPractice");
        FileUtils.copyFile(srcFile,destFile);
        System.out.println("saved shot");*/
        Actions action= new Actions(driver);
        action.contextClick().build().perform();




    }}


