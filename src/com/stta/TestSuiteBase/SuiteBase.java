package com.stta.TestSuiteBase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class SuiteBase {
	
	public static WebDriver driver=null;
	public boolean BrowseralreadyLoaded=false;
	
	public void loadWebBrowser(){
	//	ProfilesIni profile = new ProfilesIni();
	//	FirefoxProfile myProfile = profile.getProfile("SeleniumQA");
		System.setProperty("webdriver.gecko.driver","C:/Users/kusha/workspace/ClearTrip_Automation/JarFiles/geckodriver.exe");
		if(!BrowseralreadyLoaded){		
			driver = new FirefoxDriver(); //myProfile
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			try {
				Runtime.getRuntime().exec("C:\\Users\\kusha\\Desktop\\geo.exe");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BrowseralreadyLoaded=true;
			
		}
	}
	
	public void closeWebBrowser(){
		try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
					e1.printStackTrace();
			}
		driver.close();
	}
	
	public void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
	
	public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
