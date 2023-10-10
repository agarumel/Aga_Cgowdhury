package com.example.BengalTigerMaven;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class BengalTigerMavenApplication {
	WebDriver driver;

	public static void waitFor(int sec) throws InterruptedException {
		Thread.sleep(1000*sec);


	}


	public static void setup(String url) {
		System.setProperty("webdriver.gecko.driver", "C:/Users/13477/IdeaProjects/MavenProject/.idea/Driver/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.letskodeit.com/practice");


		//driver.close();
	}



}
