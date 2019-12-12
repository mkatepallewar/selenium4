package com.test.Selenium_4;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTabsandPopups {

	public static void main(String[] args) throws InterruptedException {
		
		
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("First Window:" + driver.getTitle());
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://gmail.com");
		System.out.println("Second Window:" + driver.getTitle());
		
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(1000);

		Set<String> winids=driver.getWindowHandles();
		Iterator<String> iterate=winids.iterator();
		
		
		iterate.next();
		iterate.next();
		String thrid_window=iterate.next();
		driver.switchTo().window(thrid_window);
		System.out.println("Third window : " +driver.getTitle());
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("http://google.com");
		System.out.println("Fourth window : " +driver.getTitle());
//		
		driver.close();
//		
		driver.switchTo().window(thrid_window);
		driver.close();
		driver.quit();
		

	}

}
