package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import com.w2a.utilities.ExcelReader;



public class TestBase {
	
	/*initilise webdriver
	properties
	
logs
extent reportsdb,excel,mail*/
	
	public static WebDriver driver;
public static	Properties config=new Properties();
public static	Properties or=new Properties();
public static FileInputStream fis;
public static Logger log=Logger.getLogger(TestBase.class.getName());//classname.class.getname

public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata2.xlsx");
public static WebDriverWait wait;
//BasicConfigurator.configure();

//PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\log4j.properties");
//PropertyConfigurator.configure("./src/log4j.properties");
//PropertyConfigurator.configure("F:\\bindu network\\Wspaces2\\Workspace_NewProjects\\DataDrivenFw\\log4j.properties");
/*@AfterSuite
public void tearDown(){
	if(driver!=null){
		driver.quit();
}
	log.info("execution completed");
}
	*/
@BeforeSuite
public void setUp() {
	// initialize everything
	//As of log4j version 0.8.5, at class initialization time class, the file log4j.properties will be searched from the search path used to load classes. If the file can be found, then it will be fed to the configure(java.net.URL) method.
	PropertyConfigurator.configure("F:\\bindu network\\Wspaces2\\Workspace_NewProjects\\DataDrivenFw\\log4j.properties");
	if (driver == null) {

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			config.load(fis);
			log.info("config file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\or.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			or.load(fis);
			log.info("or file loaded");
		} catch (IOException e) {
			// ToODO Auto-generated catch block
			e.printStackTrace();
		}
		String browserName = config.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("chrome launched");
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.get(config.getProperty("testsiteurl"));
		log.info("Navigated to "+config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
				TimeUnit.SECONDS);
	wait=new WebDriverWait(driver,5);
	}
}


public boolean isElementPresent(By by){
	try{
		driver.findElement(by);
		return true;
	}catch(NoSuchElementException e)
	{
		return false;
	}
	
}




}
	



