package locatorSession;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstLocators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// navigation

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/MyChrome/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// our url https://rahulshettyacademy.com/locatorspractice//

		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice//");
		driver.navigate().to("https://www.google.com/");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().back();
		// first locator is find the element by id
		driver.findElement(By.id("inputUsername")).sendKeys("mahmoud");
		// second locator is find element by the name
		// To determine whether these locator is unique or not i will use selectorhup as
		// a plugin
		driver.findElement(By.name("inputPassword")).sendKeys("1234");
		// third locator is find element by class name

		driver.findElement(By.className("submit")).click();
		// before running i will check whether submit is unique or not
		// now i will get the text of error * Incorrect username or password
		// i will use cssSelector to get the element by the name of its class
		String errorMessage = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(errorMessage);
		// to get the value of error message we need to use
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(number of
		// seconds));
		// now we will use the locator of findelement by link text
		driver.findElement(By.linkText("Forgot your password?")).click();
		// find the locator by xpath checking whether the locator is unique or not for
		// these element using console we can use also selectorhup
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("mahmoud");
		// findt the element by cssSelector checking the locator for the element is
		// unique or not
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("mahoud@gmail.com");
		// using the xpath locator and the indexing to get the element
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		// using the cssSelector locator and nth:child to get element
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("hatem@gmail.com");
		// we observeing that when we use cssSelector :nth-child() it also dealing with
		// hidden element

		// using xpath to traverse from parent to child and also using indexing to
		// selecting specified child from the siblings

		// we will move from the (form) to (input) to (index) of the input that we need
		// to select
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("111111");

		// we can also use cssSelector to traverse from parent to child to index
		driver.findElement(By.cssSelector("form input:nth-child(4)")).clear();
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("111111");
		// using cssSelector by class name
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		// now i will need to go back to login form
		// i will use regular expression and cssSelector to complete all the names of
		// classes of these specified element
		driver.findElement(By.cssSelector("button[class*='go-to-']")).click();
		// after returning back to logging form i will use the method getPassword to
		// enter the password
		Thread.sleep(2000);

		String password = getPassword(driver);
		driver.findElement(By.id("inputUsername")).sendKeys("mahmoud");
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		// i will regular expression in xpath to locate the signin button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

	}

	public static String getPassword(WebDriver driver) throws InterruptedException {
		// I will use split method to cut specified word from whole statement and enter
		// it as a password to be able to login
		// This is the whole statement Please use temporary password
		// 'rahulshettyacademy' to Login.
		// And this is the specified word rahulshettyacademy that i need to cut
		driver.get("https://rahulshettyacademy.com/locatorspractice//");

		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		// Now i will get the message first and store it in String
		String fullMessage = driver.findElement(By.cssSelector("p[class='infoMsg']")).getText();
		driver.findElement(By.cssSelector("button[class*='go-to-']")).click();
		String partialMessage = fullMessage.split("'")[1];
		String password = partialMessage.split(" ' t")[0];
		System.out.println(password);
		return password;

	}

}
