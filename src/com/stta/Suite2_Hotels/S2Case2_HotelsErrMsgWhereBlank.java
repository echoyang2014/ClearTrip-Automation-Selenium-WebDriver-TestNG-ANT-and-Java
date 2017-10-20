package com.stta.Suite2_Hotels;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stta.TestSuiteBase.SuiteBase;

public class S2Case2_HotelsErrMsgWhereBlank extends SuiteBase{
	@Test
	public void run(){
	loadWebBrowser();
	//To navigate to URL.
	driver.get("http://www.cleartrip.com/");
	waitFor(2000);
	driver.findElement(By.xpath(".//*[@id='Home']/div/aside[1]/nav/ul[1]/li[2]/a[1]")).click();
	waitFor(2000);
	    
    driver.findElement(By.id("SearchHotelsButton")).click();


    String actual = driver.findElement(By.xpath(".//*[@id='homeErrorMessage']")).getText();
    String expected = "Sorry, but we can't continue until you fix everything that's marked in RED";
    
    Assert.assertEquals(actual, expected);
    
    closeWebBrowser();
	}
}
