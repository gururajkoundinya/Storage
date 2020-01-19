package TestNgProject1.TestNgProject1.webPages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import TestNgProject1.TestNgProject1.commonFiles.commonMethods;
import TestNgProject1.TestNgProject1.objectRepository.LocatorRepo;

public class LoginPage extends commonMethods
{
	LocatorRepo repo =null;
	public LoginPage()
	{
		repo= PageFactory.initElements(driver, LocatorRepo.class);
	}
	
	
	public void navigatetoLoginPage()
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		explictwait_elementToBeClickable(repo.signInButton);
		clickElement(repo.signInButton);
	}
	
	public String Invalidlogin(String email, String password)
	{
		typeData(repo.emailid, email);
		submitElement(repo.nextbtn1);
		typeData(repo.passwordfield,password);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		submitElement(repo.nextbtn2);
		String page=getPageTitle();
		System.out.println("page title " + page);
		return page;
	}
	
	public String validlogin(String email, String password)
	{
		typeData(repo.emailid, email);
		submitElement(repo.nextbtn1);
		typeData(repo.passwordfield,password);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//submitElement(repo.nextbtn2);
		
		mousemove(repo.nextbtn2);
		doubleClick(repo.nextbtn2);
				
		explictwait_elementToBeClickable(repo.profilename);
		String page=getTextElement(repo.profilename);
		System.out.println("page title " + page);
		return page;
	}
}
