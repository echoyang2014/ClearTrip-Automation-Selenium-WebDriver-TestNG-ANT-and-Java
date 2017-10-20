package com.stta.Suite1_Flights;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stta.TestSuiteBase.SuiteBase;

public class S1Case3_RoundTripSearchSummary extends SuiteBase{
	
	@Test
	public void run(){
		loadWebBrowser();
		//To navigate to URL.
		driver.get("http://www.cleartrip.com/");
		driver.findElement(By.id("RoundTrip")).click();
		driver.findElement(By.id("FromTag")).clear();
	    driver.findElement(By.id("FromTag")).sendKeys("Bangalore");
	    
	    waitFor(2000);
	    List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
	    originOptions.get(0).click();
	    
	    driver.findElement(By.id("ToTag")).clear();
	    driver.findElement(By.id("ToTag")).sendKeys("Delhi");
	    waitFor(2000);
	    List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
	    destinationOptions.get(0).click();
	    
	    driver.findElement(By.id("DepartDate")).click();
	    driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[3]/td[4]/a")).click();
	    
	    driver.findElement(By.id("ReturnDate")).click();
	    driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[5]/td[5]/a")).click();
	
	    Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='Adults']")));
	    dropdown.selectByIndex(5);
	    
	    Select dropdown1 = new Select(driver.findElement(By.xpath(".//*[@id='Childrens']")));
	    dropdown1.selectByIndex(3);

	    Select dropdown2 = new Select(driver.findElement(By.xpath(".//*[@id='Infants']")));
	    dropdown2.selectByIndex(1);

	    driver.findElement(By.xpath(".//*[@id='MoreOptionsLink']")).click();
	    
	    Select dropdown3 = new Select(driver.findElement(By.xpath(".//*[@id='Class']")));
	    dropdown3.selectByValue("First");

	    driver.findElement(By.id("SearchBtn")).click();

	    Assert.assertTrue(isElementPresent(By.className("searchSummary")));
	    closeWebBrowser();   
	}
}
