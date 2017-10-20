package com.stta.Suite1_Flights;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.stta.TestSuiteBase.SuiteBase;

public class S1Case4_RoundTripErrorMsg extends SuiteBase {

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
    
    //driver.findElement(By.id("ToTag")).clear();
    //driver.findElement(By.id("ToTag")).sendKeys("Delhi");
   // waitFor(2000);
   // List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
    //destinationOptions.get(0).click();
    driver.findElement(By.id("DepartDate")).click();
    driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[3]/td[4]/a")).click();
    
    Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='Adults']")));
    dropdown.selectByIndex(5);
    
    try{
        // Waits for 20 seconds
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Wait until expected condition size of the dropdown increases and becomes more than 1
        wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver)  
            {
                Select select = new Select(driver.findElement(By.xpath(".//*[@id='Childrens']")));
                return select.getOptions().size()>1;
            }
        });

        //To select the first option
        Select select = new Select(driver.findElement(By.xpath(".//*[@id='Childrens']")));
        select.selectByIndex(3);
    }catch(Throwable e){
        System.out.println("Error found: "+e.getMessage());
    }
    /*WebElement mySelectElm = driver.findElement(By.xpath(".//*[@id='Childrens']"));
    Select myselect = new Select(mySelectElm);
    myselect.selectByIndex(5);
    */
    //Select dropdown1 = new Select(driver.findElement(By.xpath(".//*[@id='Childrens']")));
    //dropdown1.getAllSelectedOptions();
    

    Select dropdown2 = new Select(driver.findElement(By.xpath(".//*[@id='Infants']")));
    dropdown2.selectByIndex(1);

    driver.findElement(By.xpath(".//*[@id='MoreOptionsLink']")).click();
    
    Select dropdown3 = new Select(driver.findElement(By.xpath(".//*[@id='Class']")));
    dropdown3.selectByValue("First");

    
    driver.findElement(By.id("SearchBtn")).click();

    waitFor(5000);
    
    String actual = driver.findElement(By.xpath(".//*[@id='homeErrorMessage']")).getText();
    String expected = "Sorry, but we can't continue until you fix everything that's marked in RED";
    
    Assert.assertEquals(actual, expected);
    
    closeWebBrowser();
	}
}
