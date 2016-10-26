package com.mogo.spider.funny;

import org.openqa.selenium.WebDriver;

public abstract class Spider {
		
	protected WebDriver webDriver = null;
	
	public Spider(WebDriver webDriver){
		this.webDriver = webDriver;
	}
	
	public void onFinish(){
		webDriver.close();
	}
	
	public abstract void execute();
	
}
