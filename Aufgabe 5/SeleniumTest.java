package ch.ilv.selenium;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SeleniumTest {

	
	
	public static void main(String[] args) throws InterruptedException {
    
	}

	  @Test
	  public void kompetenz() {
		WebDriver driver = null;
		driver.get("http://localhost:7070/products");
	    driver.findElement(By.name("description")).click();
	    driver.findElement(By.name("description")).sendKeys("Apfel");
	    driver.findElement(By.cssSelector("form:nth-child(3) > p > input")).click();
	    driver.findElement(By.name("id")).click();
	    driver.findElement(By.name("id")).sendKeys("1");
	    driver.findElement(By.cssSelector("form:nth-child(9)")).click();
	    driver.findElement(By.cssSelector("form:nth-child(9) > p > input")).click();
	  }
	
	@Test
	public void testGoogle() {
        //System.setProperty("webdriver.ie.driver", "C:/dev/IEDriverServer.exe");
        //InternetExplorerOptions options = new InternetExplorerOptions();
        //WebDriver driver=new InternetExplorerDriver(options);
		
        System.setProperty("webdriver.chrome.driver", "C:/dev/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        WebDriver driver=new ChromeDriver(options);

        //driver.manage().window().maximize();
          driver.get("http://localhost:7070/");
          driver.findElement(By.name("firstname")).click();
          driver.findElement(By.name("firstname")).sendKeys("Anus");
          driver.findElement(By.cssSelector("form:nth-child(3)")).click();
          driver.findElement(By.name("name")).click();
          driver.findElement(By.name("name")).sendKeys("Blasus");
          driver.findElement(By.cssSelector("p:nth-child(9) > input")).click();
          driver.findElement(By.name("customerId")).click();
          driver.findElement(By.name("customerId")).sendKeys("0");
          driver.findElement(By.cssSelector("form:nth-child(9)")).click();
          driver.findElement(By.cssSelector("p:nth-child(4) > input")).click();
        
          
        
        driver.get("http://www.google.ch");
        

		WebElement searchText = driver.findElement(By.name("q"));
		searchText.sendKeys("ilv.ch");
		searchText.submit();
		
		WebElement waitElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("rso")));
		
		
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@id='rso']/div/div/div/a"));

		driver.get(findElements.get(0).getAttribute("href"));
		
		waitElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.className("art-shapes")));
		
		boolean isILVPage = driver.getPageSource().contains("ÜK kurz und bündig");
		
		Assert.assertTrue(isILVPage);
		
		driver.close();
	}
	
	


}