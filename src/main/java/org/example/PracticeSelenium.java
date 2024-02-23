package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class PracticeSelenium {

    public static void main(String args[])
    {
        System.out.printf("Hello and welcome!");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.globalsqa.com/demo-site/frames-and-windows/#iFrame");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement frame= driver.findElement(By.xpath("//iframe[@name=\"globalSqa\"]"));
        driver.switchTo().frame(frame);
        WebElement list = driver.findElement(By.xpath("//span[@id=\"current_filter\"]"));
        list.click();
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].innerText='SOFTWARE TESTING'",list );



        }
    }

