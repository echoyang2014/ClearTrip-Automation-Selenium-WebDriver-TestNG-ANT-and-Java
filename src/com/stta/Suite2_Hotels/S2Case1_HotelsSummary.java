package com.stta.Suite2_Hotels;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stta.TestSuiteBase.SuiteBase;

public class S2Case1_HotelsSummary extends SuiteBase {
	@Test
	public void run(){
	loadWebBrowser();
	//To navigate to URL.
	driver.get("http://www.cleartrip.com/");
	waitFor(2000);
	driver.findElement(By.xpath(".//*[@id='Home']/div/aside[1]/nav/ul[1]/li[2]/a[1]")).click();
	waitFor(2000);
	
	driver.findElement(By.id("Tags")).click();
	driver.findElement(By.id("Tags")).clear();
	driver.findElement(By.id("Tags")).click();
    driver.findElement(By.id("Tags")).sendKeys("M");
    waitFor(2000);
    
    driver.findElement(By.id("Tags")).sendKeys("u");
    driver.findElement(By.id("Tags")).sendKeys("m");
    driver.findElement(By.id("Tags")).sendKeys("b");
    driver.findElement(By.id("Tags")).sendKeys("a");
    driver.findElement(By.id("Tags")).sendKeys("i");
    
    //    driver.findElement(By.name("Tags")).sendKeys(Keys.TAB);
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    //waitFor(2000);
    List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
    originOptions.get(0).click();
    
    waitFor(2000);
    
    driver.findElement(By.id("CheckInDate")).click();
    
    driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[4]/td[3]/a")).click();

    waitFor(2000);
    
    driver.findElement(By.id("CheckOutDate")).click();
    
    driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[5]/td[3]/a")).click();

    Select s = new Select(driver.findElement(By.xpath(".//*[@id='travellersOnhome']")));
    s.selectByValue("4");
    
    driver.findElement(By.id("SearchHotelsButton")).click();
    
    Assert.assertTrue(isElementPresent(By.className("searchSummary")));
    closeWebBrowser();
	}
}

