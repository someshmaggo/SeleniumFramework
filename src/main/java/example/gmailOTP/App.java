package example.gmailOTP;
 

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class App 
{
	public static WebDriver driver;
	
    public static void main( String[] args ) throws Exception
    {
    	

    	
    		
    		
    		ChromeOptions o = new ChromeOptions();
    		o.addArguments("disable-extensions");
    		o.addArguments("--start-maximized");
    		
    		System.setProperty("webdriver.chrome.driver", "C:\\Users\\so.maggo\\workspace\\LMS\\LMS\\drivers/chromedriver.exe");
    		driver=new ChromeDriver(o);
    
    		driver.get("http://www.google.com");
    		
    		Robot robot = new Robot();                          
    		robot.keyPress(KeyEvent.VK_CONTROL); 
    		robot.keyPress(KeyEvent.VK_T); 
    		robot.keyRelease(KeyEvent.VK_CONTROL); 
    		robot.keyRelease(KeyEvent.VK_T);
    		
    		
    		Thread.sleep(3000);

    		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
    		driver.switchTo().window(tabs.get(1));

    		Thread.sleep(3000);

    		//Launch URL in the new tab    		
    		driver.get("http://www.gmail.com");
    		
    		driver.findElement(By.xpath("//a[@class='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")).click();
    		
    		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("somumaggo");
    		
    		driver.findElement(By.xpath("//span[text()='Next']")).click();
    		
    		Thread.sleep(3000);
    		
    		driver.findElement(By.xpath("//input[@aria-label='Enter your password']")).sendKeys("aA@@@@");
    		
    		driver.findElement(By.xpath("//span[text()='Next']")).click();
    		
    		Thread.sleep(10000);

    		driver.findElement(By.xpath("//input[@placeholder='Search mail']")).sendKeys("OTP");

    		Thread.sleep(3000);
    		
    		driver.findElement(By.xpath("//button[@aria-label='Search Mail']")).click();
    		
    		Thread.sleep(3000);
    		
    		driver.findElement(By.xpath("//tr/td/div/div/div[2]/span")).click();
    		//tr[@jsmodel='nXDxbd' and @tabindex='0'][1]
    		
    		
    		Thread.sleep(3000);

    		String otp = driver.findElement(By.xpath("//p[text()='To verify your identity, please"
    				+ " use the following code:']//following-sibling::p")).getText();
    		
    		System.out.println("OTP:" +otp);

    		
    		driver.switchTo().window(tabs.get(0));
    		
    		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(otp);
    		
    		
    		//robot.keyPress(KeyEvent.VK_ENTER);
    		//robot.keyRelease(KeyEvent.VK_ENTER);

    		
    		
}
    
    public static String readOTP() throws Exception {
        //driver.startActivity("com.android.mms", "com.android.mms.ui.ConversationList");
                driver.openNotifications();
                try {
                    String otp = driver.findElementByXPath("//*[contains(@text,'is')]").getText().split("code:")[0];
                    return otp;
                }catch (NoSuchElementException e){
                    throw new java.lang.Exception("Notification not found");}
    }v
    
}

