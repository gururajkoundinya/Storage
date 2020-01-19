package TestNgProject1.TestNgProject1.Tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TestNgProject1.TestNgProject1.utilites.TestDatas;
import TestNgProject1.TestNgProject1.webPages.LoginPage;

public class LoginTest extends LoginPage
{
	@BeforeMethod
	public void setup()
	{
		selectBrowser(TestDatas.browsername1,TestDatas.baseurl);
		Reporter.log("Test completed");
	}

	@Test(description="clicking the iteam form yahoo page")
	public void test1()
	{
		navigatetoLoginPage();
		String p= Invalidlogin(TestDatas.username2,TestDatas.password1);
		Assert.assertTrue(!p.contains("Inbox"),"some thing went worng");
	}

	@Test(description="clicking the iteam form yahoo page")
	public void test2()
	{
		navigatetoLoginPage();
		String p= validlogin(TestDatas.username1,TestDatas.password1);
		Assert.assertTrue(p.contains("Test"),"some thing went worng");
	}

	
	@Test(description="clicking the iteam form yahoo page")
	public void test3()
	{
		navigatetoLoginPage();
		String p= validlogin(TestDatas.username1,TestDatas.password1);
		Assert.assertTrue(p.contains("Test"),"some thing went worng");
	}
	
	@AfterMethod
	public void teardown()
	{
		closebrowser();
	}
}
