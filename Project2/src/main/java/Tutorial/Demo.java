package Tutorial;



import org.junit.Before;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Demo {
  private static Page page;
private Browser browser;
@Test(priority =1)
@BeforeMethod
	public void setup() {
		Playwright playwright=	Playwright.create();
		 browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		   BrowserContext brContext=browser.newContext();
		      page=brContext.newPage(); 
		     
	}
		  @Test(priority=2)  
	public void Validatetheloginfuctonality() {
		page.navigate("https://www.facebook.com/reg//");
	     page.type("//input[@name='firstname']]", "Shital");
	     page.type("////input[@name='lastname']']", "Hase");
	     page.type("//input[@name='reg_email__']", "shitalhase@gmail.com");
	     page.type("//input[@name='reg_passwd__']", "shital@12");
	     page.locator("//button[@name='websubmit']").click();
		
		     } 
	@Test(priority=-1)
		public void Validatehomepagetitle () {
	String title=page.title();
	if(title.equals("facebook"))
	{
		System.out.println("test case is pass");
	}
		else
		{
			System.out.println("test case is fail");
		}
		}
	
		
		@Test(priority=3)
	@AfterMethod
public void tear()  {
	page.close();
	
}
}
	
	

