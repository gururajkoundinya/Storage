package TestNgProject1.TestNgProject1.objectRepository;

import org.openqa.selenium.By;

public class LocatorRepo 
{
	// landing page
	public By createacc=By.xpath("//a[@id='createacc']");
	public By staysigned=By.xpath("//input[@id='persistent']");
// login page
	public By signInButton = By.id("uh-signin");
	public By emailid=By.id("login-username");
	public By nextbtn1=By.cssSelector("#login-signin");
	public By nextbtn2=By.xpath("//input[@id='login-passwd']/following::button[2]");
	public By passwordfield= By.id("login-passwd");
	public By errormsg = By.className("//p[@class='error-msg']");
	
	public By profilename=By.xpath("//button[@aria-label='Profile']/span[1]");
	

}
