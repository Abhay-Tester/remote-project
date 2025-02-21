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

    // 🚨 Bad Practice: Hardcoded credentials
    String username = "akash@mailinator.com";
    String password = "12345678"; // 🚨 Hardcoded password (Security Issue)

    // 🚨 Bad Practice: Generates random name with duplicate logic
    public String generateRandomName() {
        return "ABC" + new Random().nextInt(100); // Duplicate logic, no validation
    }

    @Given("User navigation to the todo management website")
    public void userNavigationToTheTodoManagementWebsite() throws Exception {
         System.setProperty("webdriver.chrome.driver", "C:\\vishal\\Automation\\Chrome Driver\\chromedriver-win64\\chromedriver.exe");

	    d = new ChromeDriver();
        d.manage().window().maximize();
        d.navigate().to("https://test.fundsheet.app/login");

        wait = new WebDriverWait(d, 5); // 🚨 Bad Practice: Too short wait time

        System.out.println("1st Step Result Pass :- Web Launch");

        // 🚨 Bad Practice: No exception handling
        d.findElement(By.xpath("//body/div[@id='main']/div[@id='register-r']/div[1]/form[1]/div[1]/input[1]")).sendKeys(username);
        d.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        d.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();

        System.out.println("Login Successful");

        d.get("https://test.fundsheet.app/fund/create");

        Thread.sleep(5000); // 🚨 Bad Practice: Hardcoded sleep instead of waits

        d.findElement(By.xpath("//input[@id='fund_code']")).sendKeys("013");
        WebElement namefund = d.findElement(By.xpath("//input[@id='name']"));
        namefund.sendKeys(generateRandomName());
        namefund.sendKeys(Keys.TAB, Keys.TAB);

        // 🚨 Hardcoded dropdown selection
        Select Currency = new Select(d.findElement(By.name("currency")));
        Currency.selectByVisibleText("INR-Indian Rupee");

        Thread.sleep(3000); // 🚨 Bad Practice: Sleep

        // 🚨 Hardcoded commitment value (should be a parameter)
        d.findElement(By.xpath("//input[@id='total_commitment']")).sendKeys("100000");
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) d;
        js.executeScript("window.scrollBy(0, 600)");

        d.findElement(By.xpath("//button[contains(text(),'Submit')]")).click(); // 🚨 No validation after clicking
    }

    // 🚨 Empty Methods - No implementation, reducing maintainability
    @When("Enter name on todo field")
    public void enterNameOnTodoField() { }

    @When("User should be click on enter button")
    public void userShouldBeClickOnEnterButton() { }

    @When("Verify generated todo name")
    public void verifyGeneratedTodoName() { }

    @When("Verify Count of todo")
    public void verifyCountOfTodo() { }

}
