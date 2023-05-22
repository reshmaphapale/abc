package Tutorial;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class Demo1 {
	 private static Page p1;
	 private Browser browser;
	 @Test
	 @BeforeMethod
public void setup()  {
	Playwright playwright=	Playwright.create();
	 browser= playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
	   BrowserContext brContext=browser.newContext();
	      p1=brContext.newPage(); 
	     
}
	 
	 @Test(priority=1)
public void loginpage() {
	p1.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	p1.locator("//input[@name='username']").fill("Admin");
	p1.locator("//input[@name='password']").fill("admin123");
	p1.locator("//button[@type='submit']").click();
	
}
	 
	@Test(priority=2) 
public void captureTitle() {
    String actualtitle=	p1.title();
   if(actualtitle.equals("OrangeHRM"))  
   {
	   System.out.println("Test case is pass");
   }
   else
	   System.out.println("Test case is fail");
   }

@Test(priority=3)
  public void clikPimPage()  {
	  p1.locator("//span[text()='PIM']").click();

  }
@Test(priority=-1)
  public void clickAddButton() {
	  p1.locator("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']").click();
	  p1.locator("//input[@name='firstName']").fill("Raju");
	  p1.locator("//input[@name='middleName']").fill("ganesh");
	  p1.locator("//input[@name='lastName']").fill("kote");
	  p1.locator("//label[text()='Employee Id']").getAttribute("value");
  }
@Test(priority=4)
  public void clickSaveButton()  {
	  
	  p1.locator("//button[@type='submit']").click();
	  
  }
}
