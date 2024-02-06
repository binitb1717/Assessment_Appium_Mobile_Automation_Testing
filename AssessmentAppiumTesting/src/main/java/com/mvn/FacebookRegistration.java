package com.mvn;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class FacebookRegistration {

	AndroidDriver driver;
	@BeforeTest
	public void test() throws Exception {
		UiAutomator2Options ut =new UiAutomator2Options();
		ut.setDeviceName("Binit");
		ut.setApp("C:\\BinitAppium\\facebook_lite_v321.0.0.13.113.apk");
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), ut);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(2000);
	
		
	}
	
	@Test
	public void registration() throws InterruptedException, IOException {
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.MultiAutoCompleteTextView[1]")).sendKeys("dodojain756@gmail.com");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.widget.MultiAutoCompleteTextView[2]")).sendKeys("Kalpu123");
		Thread.sleep(2000);
		
//		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup/android.view.ViewGroup[1]")).click();
//		Thread.sleep(2000);
		
		File fi=((RemoteWebDriver)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(fi, new File("C:\\Users\\Admin\\Screenshot\\Fbregistration sucessful.png"));
		
	}
	@AfterTest
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		
	}
	
}
