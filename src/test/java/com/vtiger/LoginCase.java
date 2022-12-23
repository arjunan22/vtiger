package com.vtiger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginCase {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				FileInputStream fis = new FileInputStream("./src/test/resources/data1.properties");
		Properties p =new Properties();
		p.load(fis);
		
		driver.get(p.getProperty("url"));
		driver.findElement(By.name("user_name")).sendKeys(p.getProperty("user"));
		driver.findElement(By.name("user_password")).sendKeys(p.getProperty("password"));
		driver.findElement(By.id("submitButton")).click();
			
		
				
		Thread.sleep(3000);
		
		driver.close();
		
		
	}

}
