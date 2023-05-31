package com.Goibibo_IPT;


	
	import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

	//abstract class cannot be inherited using object can be extend only
	public class BaseClass2 {

		public static WebDriver driver;

		public static void browserLaunch(String browser) {
			if (browser.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().setup();
				ChromeOptions co = new ChromeOptions();
				co.addArguments("incognito");
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("opera")) {
				WebDriverManager.operadriver().setup();
				driver = new OperaDriver();
			} else {
				System.out.println("invalid browser");
			}

		}

		// implicit wait
		public static void implicitWait(int sec) {
			driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

		}

		// explicit wait
		public static void explicitWait(WebElement element, int sec) {
			WebDriverWait wait = new WebDriverWait(driver, sec);
			wait.until(ExpectedConditions.visibilityOf(element));

		}

//		driver methods
		public static void maximize() {
			driver.manage().window().maximize();

		}

//		navigation methods
		public static void forward() {
			driver.navigate().forward();

		}

		public static void back() {
			driver.navigate().back();

		}

		public static void refresh() {
			driver.navigate().refresh();

		}

		public static void navigateTo(String url) {
			driver.navigate().to(url);

		}

//		driver methods
		public static void getUrl(String url) {
			driver.get(url);
		}

		public static void getCurrentUrl() {
			String currentUrl = driver.getCurrentUrl();
			System.out.println(currentUrl);
		}

		public static String getTitle() {
			String title = driver.getTitle();
			System.out.println(title);
			return title;

		}

		public static void close() {
			driver.close();
		}

		public static void quit() {
			driver.quit();
		}

//		webelement methods:
		public static void click(WebElement element) {
			element.click();

		}

		public static void webElementClear(WebElement element) {
			element.clear();
		}

		public static void inputFeed(WebElement element, String input) {
			element.sendKeys(input);

		}

//		getting otp using scanner class
		public static void getOtp() throws InterruptedException {
			Scanner s = new Scanner(System.in);
			Thread.sleep(3000);
			String otp = s.nextLine();
			s.close();
		}

		public static void isEnable(WebElement element) {
			boolean enabled = element.isEnabled();

		}

		public static void isDisplay(WebElement element) {
			boolean displayed = element.isDisplayed();

		}

		public static void isSelect(WebElement element) {
			boolean selected = element.isSelected();

		}

		public static void getAttributeValue(WebElement element, String value) {
			String attribute = element.getAttribute(value);

		}

//		screenshot method
		public static void screenShot(String fileName) throws IOException {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("C:\\Users\\User\\Desktop\\java\\selenium\\screenshot\\" + fileName + ".png");
			FileHandler.copy(src, dest);
		}

//		dropdown methods
		public static void multiple(WebElement element) {
			Select s = new Select(element);
			boolean multiple = s.isMultiple();

		}

		public static void dropDown(WebElement element, String option, String value) {
			Select s = new Select(element);
			if (option.equalsIgnoreCase("value")) {
				s.selectByValue(value);
			} else if (option.equalsIgnoreCase("text")) {
				s.selectByVisibleText(value);
			} else if (option.equalsIgnoreCase("index")) {
				int index = Integer.parseInt(value);
				s.selectByIndex(index);
			}

		}

		public static void getOption(WebElement element) {
			Select s = new Select(element);
			List<WebElement> options = s.getOptions();
			for (WebElement opt : options) {
				System.out.println(opt.getText());
			}

		}

		public static void getAllOption(WebElement element) {
			Select s = new Select(element);
			List<WebElement> options = s.getAllSelectedOptions();
			for (WebElement allselected : options) {
				System.out.println(allselected.getText());
			}

		}

		public static void getFirstOption(WebElement element) {
			Select s = new Select(element);
			WebElement firstSelected = s.getFirstSelectedOption();
			System.out.println(firstSelected.getText());
		}
//		Frame Handling

		public static void switchToFrame(WebElement element) {
			driver.switchTo().frame(element);

		}

		public static void switchToFrame(String id) {
			driver.switchTo().frame(id);

		}

		public static void switchToFrame(int index) {

			driver.switchTo().frame(index);

		}
//		java script executor methods

		public static void javaScriptScrollElement(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", element);

		}

		public static void javaScriptClick(WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}

		public static void javaScriptSendKeys(String id, String value) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
//			must add ' ' single quotes to execute
			js.executeScript("document.getElementByid('" + id + "').value=('" + value + "');");

		}

//		can perform scroll up,down,right,left using this method by adjusting values in args
		public static void scroll(int x, int y) {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(" + x + "," + y + ");");

		}

//		action methods
		public static void actionClick(WebElement element) {
			Actions ac = new Actions(driver);
			ac.click(element).build().perform();

		}

		public static void mouseHover(WebElement element) {
			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();

		}

		public static void actionRightClick(WebElement element) {
			Actions ac = new Actions(driver);
			ac.contextClick(element).build().perform();
		}

		public static void actionDragAndDrop(WebElement source, WebElement target) {
			Actions ac = new Actions(driver);
			ac.dragAndDrop(source, target).build().perform();

		}

		// alert handling
//		simple alert
		public static void simpleAlert() {
			driver.switchTo().alert().accept();

		}

//		confirm alert
		public static void confirmAlert(String option) {
			if (option.equalsIgnoreCase("accept")) {
				driver.switchTo().alert().accept();
			} else if (option.equalsIgnoreCase("dismiss")) {
				driver.switchTo().alert().dismiss();
			}

		}

//		prompt alert
		public static void promptAlert(String input, String option) {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(input);
			if (option.equalsIgnoreCase("accept")) {
				alert.accept();
			} else if (option.equalsIgnoreCase("dismiss")) {
				alert.dismiss();
			}

		}

//		window handles
		public static void switchWindow(int index) {
			Set<String> windowset = driver.getWindowHandles();
			List<String> windowlist = new LinkedList<String>(windowset);
			String w = windowlist.get(index);
			driver.switchTo().window(w);

		}

	}

