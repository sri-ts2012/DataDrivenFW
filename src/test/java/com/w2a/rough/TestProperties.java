package com.w2a.rough;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class TestProperties {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
Properties config=new Properties();
Properties or=new Properties();
FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
config.load(fis);
System.out.println(config.getProperty("browser"));

 fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\or.properties");
config.load(fis);
//driver.findElement(By.cssSelector(or.getProperty(bmlBtn))).click();
System.out.println(config.getProperty("bmlBtn"));
	}

}
