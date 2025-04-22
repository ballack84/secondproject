package standarduser;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class fourthsessiondemo {
	
	WebDriver driver = new ChromeDriver();
	String MyWebSite = "https://www.saucedemo.com/v1/";
	String Username = "standard_user";
	String PasswordInput = "secret_sauce";

	@BeforeTest

	public void MySetup() {

		driver.get(MyWebSite);
		driver.manage().window().maximize();

}

	@Test(priority = 1)

	public void Login() {

		// driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(Username);
		// driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(PasswordInput);
		//driver.findElement(By.id("user-name")).sendKeys(Username);
		//driver.findElement(By.id("password")).sendKeys(PasswordInput);
		//driver.findElement(By.id("login-button")).click();
		
		WebElement Usernameelement = driver.findElement(By.id("user-name"));
		WebElement Passwordelement = driver.findElement(By.id("password"));
		WebElement Loginelement = driver.findElement(By.id("login-button"));
		
		Usernameelement.sendKeys(Username);
		Passwordelement.sendKeys(PasswordInput);
		Loginelement.click();
		

	}
	// to add all the items
	
	@Test(priority = 2, enabled=false)

	public void AddToCartItem() {
		
		List<WebElement> AddToCartItem = driver.findElements(By.className("btn_primary"));
		for(int c=0; c<AddToCartItem.size();c++ ) {
			
			AddToCartItem.get(c).click();
		};
		
	}
	// to add some of items
	@Test(priority = 2, enabled=false)
	
	public void AddToCartItemleft() {
		
		List<WebElement> AddToCartItem = driver.findElements(By.className("btn_primary"));
		
		for (int c = 0; c < AddToCartItem.size(); c += 2) {
		    AddToCartItem.get(c).click(); // Adds item at index 0, 2, 4, etc.
		}
		
	}
	
	// to add some of items
	@Test(priority = 2, enabled=false)
	
	public void AddToCartItemleftonly() {
		
		List<WebElement> AddToCartItem = driver.findElements(By.className("btn_primary"));
		
		for (int c = 0; c < AddToCartItem.size(); c=c+2) {
		    AddToCartItem.get(c).click(); // Adds item at index 0, 2, 4, etc.
		}
	}
		// to add some of items
		@Test(priority = 2)
		
		public void AddToCartItemrightonly() {
			
			List<WebElement> AddToCartItem = driver.findElements(By.className("btn_primary"));
			
			for (int c = 1; c < AddToCartItem.size(); c=c+2) {
			    AddToCartItem.get(c).click(); // Adds item at index 0, 2, 4, etc.
			}
		
	}	
	

@AfterTest

public void AfterMyTest() {
	
	//driver.quit();
}

}