package com.stta.Suite1_Flights;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stta.TestSuiteBase.SuiteBase;

public class S1Case5_MultiCitySearchSummary extends SuiteBase{
	
	@Test
	public void run(){
		loadWebBrowser();
		//To navigate to URL.
		driver.get("http://www.cleartrip.com/");
		driver.findElement(By.id("MultiCity")).click();
		
		driver.findElement(By.id("FromTag1")).clear();
	    driver.findElement(By.id("FromTag1")).sendKeys("LAX");
	    
	    waitFor(2000);
	    List<WebElement> originOptions = driver.findElement(By.id("ui-id-4")).findElements(By.tagName("li"));
	    originOptions.get(0).click();
	    
	    driver.findElement(By.id("ToTag1")).clear();
	    driver.findElement(By.id("ToTag1")).sendKeys("SFO");
	    
	    waitFor(2000);
	    List<WebElement> originOptions_ = driver.findElement(By.id("ui-id-5")).findElements(By.tagName("li"));
	    originOptions_.get(0).click();
	    
	    driver.findElement(By.id("DepartDate1")).click();
	    driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[1]/td[6]/a")).click();
	
	    
	    driver.findElement(By.id("FromTag2")).clear();
	    driver.findElement(By.id("FromTag2")).sendKeys("SFO");
	    
	    waitFor(2000);
	    List<WebElement> originOptions1 = driver.findElement(By.id("ui-id-6")).findElements(By.tagName("li"));
	    originOptions1.get(0).click();
	    
	    //
	    driver.findElement(By.id("ToTag2")).clear();
	    driver.findElement(By.id("ToTag2")).sendKeys("Denver");
	    
	    waitFor(2000);
	    List<WebElement> originOptions2 = driver.findElement(By.id("ui-id-7")).findElements(By.tagName("li"));
	    originOptions2.get(0).click();
	    
	    driver.findElement(By.id("DepartDate2")).click();
	    driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[2]/td[4]/a")).click();
	    
	    driver.findElement(By.xpath(".//*[@id='McAddMore']")).click();
	    
	   // driver.findElement(By.xpath(".//*[@id='MultiTrip']/section[3]/div[4]/a/i")).click();
	    
	   // driver.findElement(By.xpath(".//*[@id='McAddMore']")).click();
	    
	    //////////////////////////////////////
	    driver.findElement(By.id("FromTag3")).clear();
	    driver.findElement(By.id("FromTag3")).sendKeys("Denver");
	    
	    waitFor(2000);
	    List<WebElement> originOptions3 = driver.findElement(By.id("ui-id-8")).findElements(By.tagName("li"));
	    originOptions3.get(0).click();
	    
	    //
	    driver.findElement(By.id("ToTag3")).clear();
	    driver.findElement(By.id("ToTag3")).sendKeys("NYC");
	    
	    waitFor(2000);
	    List<WebElement> originOptions4 = driver.findElement(By.id("ui-id-9")).findElements(By.tagName("li"));
	    originOptions4.get(0).click();
	    
	    driver.findElement(By.id("DepartDate3")).click();
	    driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[3]/td[4]/a")).click();
	   
	    driver.findElement(By.id("SearchBtn")).click();

	    Assert.assertTrue(isElementPresent(By.className("searchSummary")));
	    closeWebBrowser();
	}
}
