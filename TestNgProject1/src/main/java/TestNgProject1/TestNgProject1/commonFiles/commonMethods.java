package TestNgProject1.TestNgProject1.commonFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonMethods extends BaseTest
{
	Actions act =null;
	
	public void explictwait_elementToBeClickable(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public void explictwait_elementToBevisible(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));		
	}
	
	public void explictwait_pageTitle(String title)
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.titleContains(title));
	}
	
	public void typeData(By locator, String data)
	{
		explictwait_elementToBeClickable(locator);
		driver.findElement(locator).sendKeys(data);
	}
	
	public void clickElement(By locator)
	{
		explictwait_elementToBeClickable(locator);
		driver.findElement(locator).click();
	}
	
	public void clearElement(By locator)
	{
		explictwait_elementToBeClickable(locator);
		driver.findElement(locator).clear();
	}
	
	public void submitElement(By locator)
	{
		explictwait_elementToBeClickable(locator);
		driver.findElement(locator).submit();
	}
	
	public String getTextElement(By locator)
	{
		explictwait_elementToBevisible(locator);
		return driver.findElement(locator).getText();
	}
	
	public void passEnterKey(By locator)
	{
		act = new Actions(driver);
		act.sendKeys(driver.findElement(locator),Keys.ENTER).perform();
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public String getPageUrl()
	{
		return driver.getCurrentUrl();
	}

	public void mousemove(By locator)
	{
		act = new Actions(driver);
		act.moveToElement(driver.findElement(locator)).perform();
	}
	
	public void doubleClick(By locator)
	{
		act = new Actions(driver);
		act.doubleClick(driver.findElement(locator)).perform();
	}
	
}
