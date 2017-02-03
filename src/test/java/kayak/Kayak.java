package kayak;

import org.testng.annotations.Test;
import org.testng.internal.Utils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.Hashtable;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Kayak {
WebDriver driver;

  @Test
  public void kayak() throws InterruptedException {
	  
	//type Tokyo, Japan into search input box 
	driver.findElement(By.xpath("//input[@class='Common-Widgets-TextInput size-l selectTextOnFocus input-flat']")).
	sendKeys("Tokyo, Japan",Keys.ENTER);
		
	//  click on the calendar tab
	driver.findElement(By.xpath("//input[@class='Common-Widgets-TextInput dateInput size-m']")).click();
	
	//driver.findElement(By.cssSelector("")).click();
	driver.findElement(By.xpath("//div[@class='keel-grid weekGrid']/div[@data-val='1486368000000']")).click();
	driver.findElement(By.xpath("//div[@class='keel-grid weekGrid']/div[@data-val='1487923200000']")).click();
	
	//select leisure radio button 
	driver.findElement(By.xpath("//label[@class='r9-radiobuttonset-label']/span"
			+ "[@class='r9-radiobuttonset-circle circle-color-brand hidden']")).click();
	
	//
	driver.findElement(By.xpath("//a[@class='Common-Widgets-DropdownDialog size-l input-flat select dropdownInput hasValue']")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class='Common-Widgets-DropdownDialog-Content Hotels-Frontdoor-RoomsGuestsDialog-Content R9-Overlay open']/div[@class='Common-Widgets-Button Button-Gray-Shadow size-m incrementor']")).click();
  }
  
 
  @BeforeTest
  public void beforeMethod() {
	  ChromeOptions options = new ChromeOptions();
	  Map<String, Object> preferences = new Hashtable<String, Object>();
	  options.setExperimentalOption("prefs", preferences);

	  // disable flash and the PDF viewer
	  preferences.put("plugins.plugins_disabled", new String[] {
	      "Adobe Flash Player",
	      "Chrome PDF Viewer",
	  });
	  System.setProperty("driver.chrome.driver", "/Users/jasonsouryamath/Desktop/Eclipse Project Builds/quickstart/chromedriver.exe");
	  driver =new ChromeDriver(options);
	  driver.get("https://www.kayak.com/");
  }

  @AfterMethod
  public void afterMethod() {
  }

}
