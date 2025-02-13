package steps;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class loginsteps1 {

    WebDriver d;
    public WebDriverWait wait;

    public String generateRandomName() {
        String characters = "ABCDE";
        StringBuilder name = new StringBuilder();
        Random random = new Random();

        int length = random.nextInt(3) + 3; // Random length (1 to 3)
        for (int i = 0; i < length; i++) {
            name.append(characters.charAt(random.nextInt(characters.length())));
        }
        return name.toString();
    }

    
    String randomName = generateRandomName();

    
    
    @Given("User navigation to the todo management website")
    public void userNavigationToTheTodoManagementWebsite() throws Exception {
        // System.setProperty("webdriver.chrome.driver", "C:\\vishal\\Automation\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");
             System.setProperty("webdriver.chrome.driver", System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver-linux64/chromedriver.exe");
chromedriver.exe");

	    d = new ChromeDriver();
        d.manage().window().maximize();
        d.navigate().to("https://test.fundsheet.app/login");
    	wait = new WebDriverWait(d, 10);
        System.out.println("1st Step Result Pass :- Web Launch");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='main']/div[@id='register-r']/div[1]/form[1]/div[1]/input[1]"))).sendKeys("akash@mailinator.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']"))).sendKeys("12345678");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Sign in')]"))).click();
        System.out.println("Login Successful"); 
        
        
        d.get("https://test.fundsheet.app/fund/create");
        
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='fund_code']"))).sendKeys("013");
    	WebElement namefund    = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
    	namefund.sendKeys("Remortfund");
    	namefund.sendKeys(Keys.TAB, Keys.TAB);

    	
    	//	//Currency
    	Select Currency = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("currency"))));
    	Currency.selectByVisibleText("INR-Indian Rupee");
    	  Thread.sleep(3000);
//    	  //Comitted price
    	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='total_commitment']"))).sendKeys("100000");
           Thread.sleep(3000);
       	JavascriptExecutor js = (JavascriptExecutor) d;
      js.executeScript("window.scrollBy(0, 600)");

      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Submit')]"))).click();
     
        
        

    }
    

      
    
    


    
    
@When("Enter name on todo field")
    public void enterNameOnTodoField() {
	
   
    }



    @When("User should be click on enter button")
    public void userShouldBeClickOnEnterButton() {    	
    }
    
    @When("Verify generated todo name")
    public void verifyGeneratedTodoName() {    	
       }
        

    @When("Verify Count of todo")
    public void verifyCountOfTodo() {    		
    	}

    
     
    
    
    
}
