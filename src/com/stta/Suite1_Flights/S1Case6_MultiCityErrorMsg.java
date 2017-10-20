package com.stta.Suite1_Flights;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stta.TestSuiteBase.SuiteBase;

public class S1Case6_MultiCityErrorMsg extends SuiteBase{
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
	
	    driver.findElement(By.id("SearchBtn")).click();

	    waitFor(5000);
	    
	    String actual = driver.findElement(By.xpath(".//*[@id='homeErrorMessage']")).getText();
	    String expected = "Sorry, but we can't continue until you fix everything that's marked in RED";
	    
	    Assert.assertEquals(actual, expected);
	    
	    closeWebBrowser();
	}
}
