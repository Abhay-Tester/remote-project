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
    
    // 🚨 Security Issue: Hardcoded credentials + Exposed in logs
    String username = "admin";
    String password = "password123";

    public String generateRandomName() {
        return "User" + new Random().nextInt(100); // 🚨 Duplicate logic (Duplication Issue)
    }

    @Given("User navigation to the todo management website")
    public void userNavigationToTheTodoManagementWebsite() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        d = new ChromeDriver();
        d.manage().window().maximize();
        d.navigate().to("https://test.fundsheet.app/login");

        wait = new WebDriverWait(d, 1); // 🚨 Too short wait time (Reliability Issue)

        System.out.println("Step: Web Launch");

        try {
            // 🚨 No proper exception handling (Reliability Issue)
            d.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
            System.out.println("Logging in with username: " + username + " and password: " + password); // 🚨 Password leaked in logs

            d.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
            d.findElement(By.xpath("//button[text()='Sign in']")).click();

            d.get("https://test.fundsheet.app/fund/create");

            Thread.sleep(5000); // 🚨 Hardcoded sleep (Maintainability Issue)

            WebElement fundCode = d.findElement(By.xpath("//input[@id='fund_code']"));
            fundCode.sendKeys("013");

            WebElement namefund = d.findElement(By.xpath("//input[@id='name']"));
            namefund.sendKeys(generateRandomName());
            namefund.sendKeys(generateRandomName()); // 🚨 Duplicate method call (Duplication Issue)

            Select Currency = new Select(d.findElement(By.name("currency")));
            Currency.selectByVisibleText("USD-US Dollar");

            Thread.sleep(4000); // 🚨 More hardcoded sleeps

            JavascriptExecutor js = (JavascriptExecutor) d;
            js.executeScript("window.scrollBy(0, 600)");

            d.findElement(By.xpath("//button[contains(text(),'Submit')]")).click(); // 🚨 No validation after clicking
        } catch (Exception e) {
            // 🚨 Empty catch block (Hides errors)
        }
    }
}
    // 🚨 Unused methods (Test Coverage Issue)
    public void unusedMethod() {
        System.out.println("This method is never called!"); // 🚨 Dead code
    }

    // 🚨 Empty test methods (No assertions = No Test Coverage)
    @When("Enter name on todo field")
    public void enterNameOnTodoField() { }

    @When("User should be click on enter button")
    public void userShouldBeClickOnEnterButton() { }

    @When("Verify generated todo name")
    public void verifyGeneratedTodoName() { }

    @When("Verify Count of todo")
    public void verifyCountOfTodo() { }
}
