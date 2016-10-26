package com.mogo.spider.funny;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.LoggerFactory;

public class FunnyMM extends Spider{

	public static org.slf4j.Logger LOG = LoggerFactory.getLogger(FunnyMM.class);
	
	private static final String domain = "http://funny.com.mm";
	
	public FunnyMM(WebDriver webDriver) {
		super(webDriver);
	}
	
	
	@Override
	public void execute(){
		
		webDriver.get(domain);
		
		final String itemPattern = ".//*[@id='left']/div/div";
		final String titlePattern = "div[2]/h2/a";
		final String youTubePattern = "div/a/div";
		final String descriptionPattern = "div[2]/div[1]";
		
		List<WebElement> elements = webDriver.findElements(By.xpath(itemPattern));
		String imageUrl = null;
		String title = null;
		String description = null;
		int count = 0;
		for (WebElement element : elements){
			count ++;
			try {
				imageUrl = element.findElement(By.xpath("div/a/img")).getAttribute("src");
				title = element.findElement(By.xpath(titlePattern)).getText();
				description = element.findElement(By.xpath(descriptionPattern)).getText();
				
				LOG.info(String.valueOf(count)+"\t" + imageUrl + "\t" + title + "\t" + description);
				System.out.println(String.valueOf(count)+"\t" + imageUrl + "\t" + title + "\t" + description);
				
				
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		WebDriver webDriver = new FirefoxDriver();
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FunnyMM funnyMM = new FunnyMM(webDriver);
		funnyMM.execute();
		funnyMM.onFinish();
		
		
	}
	

}
