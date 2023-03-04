package StepDefinition;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import Utitlities.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SDLinkTest extends BaseClass{
	
	@Before
	public void setup1()
	{
		readConfig = new ReadConfig();
		
		//initialise logger
		log = LogManager.getLogger("SDLinkTest");

		//System.out.println("Setup-Sanity method executed..");

		String browser = readConfig.getBrowser();
		
		//launch browser
		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}

	
		//log.fatal("Setup1 executed...");


	}
	@Given("user launch browser and goto url")
	public void user_launch_browser_and_goto_url() {
	    
	
		
			//loginPg= new LoginPage(driver);
			//addNewCustPg = new AddNewCustomerPage(driver);
			//SearchCustPg = new SearchCustomerPage(driver);

			//log.info("chrome browser launched");
			driver.get("https://the-internet.herokuapp.com/");
			
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			
		}
	    
	

	@Then("verify the title of Webpage")
	public void verify_the_title_of_webpage() {
		String actualTitle=driver.getTitle();

		if(actualTitle.equals("The Internet"))
		{
			log.warn("Test passed:home :Page title matched.");

			Assert.assertTrue(true);//pass
		}
		else
		{
			Assert.assertTrue(false);//fail
			log.warn("Test Failed: Home- page title not matched.");


		}

	}

	@When("User click on A\\/B testing link")
	public void user_click_on_a_b_testing_link() {
	   WebElement ln=driver.findElement(By.xpath("//a[@href='/abtest']")); 
	   ln.click();
	}

	@SuppressWarnings("unlikely-arg-type")
	@Then("user redirect to new page and verify title of page")
	public void user_redirect_to_new_page_and_verify_title_of_page() {
	    WebElement poweredby =driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
	    if (poweredby.equals("Elemental Selenium")) {
	    	log.warn("Test passed:link :Page title matched.");

			Assert.assertTrue(true);//pass
	    }else {
	    	log.warn("Test passed:link :Page is not title matched.");

			Assert.assertTrue(false);//fail
	    	
	    }
	}
	@When("User click on add or remove element link")
	public void user_click_on_add_or_remove_element_link() {
	    WebElement AR=driver.findElement(By.xpath(null));
	    JavascriptExecutor jse=(JavascriptExecutor)driver;
	    jse.executeScript("arguments[0].click();",AR);
	    
	}

	@Then("User click on Add Element button")
	public void user_click_on_add_element_button() {
		WebElement ad=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
	    ad.click();
	}

	@Then("User Again click on add element button")
	public void user_again_click_on_add_element_button() {
      WebElement add= driver.findElement(By.xpath("//"));
	}

	@Then("User Again click on Delete  button")
	public void user_again_click_on_delete_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

		@After
		public void teardown(Scenario sc)
		{
			System.out.println("Tear Down method executed..");
			if(sc.isFailed()==true)
			{
				//Convert web driver object to TakeScreenshot
	
				String fileWithPath = "G:\\cucumbercode studio\\CucumberFramework-master\\CucumberFramework\\Screenshot\\failedScreenshot.png";
				TakesScreenshot scrShot =((TakesScreenshot)driver);
	
				//Call getScreenshotAs method to create image file
				File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	
				//Move image file to new destination
				File DestFile=new File(fileWithPath);
	
				//Copy file at destination
	
				try {
					FileUtils.copyFile(SrcFile, DestFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	
//			driver.quit();
//		}
	//
//		/*@After
//		public void teardown2()
//		{
//			System.out.println("Tear Down method executed..");
//			driver.quit();
//		}*/
	//
//		/*@BeforeStep
//		public void beforeStepMethodDemo()
//		{
//			System.out.println("This is before step....");
//		}
	//
	//
//		@AfterStep
//		public void afterStepMethodDemo()
//		{
//			System.out.println("This is after step....");
//		}*/
	//
	//
	}



}
