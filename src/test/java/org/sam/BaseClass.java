package org.sam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.extractor.XSSFExportToXml;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;




public class BaseClass {
	
	
	public static  WebDriver driver; 
		
	
	
	
	
	public static void lanunchBrowser()  {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		
	}
	public static void windowMaximize() {
		driver.manage().window().maximize();
	}
	public static void launchUrl(String url) {
		driver.get(url);
	}
	public static void pageTitle() {
		String title = driver.getTitle();
		System.out.println("title");
	}
	public static void pageUrl() {
		String Url = driver.getCurrentUrl();
		System.out.println("Url");
		
	}
	public static void passText(String txt, WebElement ele) {
		ele.sendKeys(txt);
		
	}
	public static void closeEntireBrowser() {
		driver.quit();
		
	}
	public static void clickBtn (WebElement ele) {
		ele.click();
		
	}
	public static void screenShot(String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("location+ imgName.png");
		FileUtils.copyFile(image, f);
	}
	
	public static Actions a;
	public static void moveThecursor(WebElement targetWebElement) {
		a = new Actions (driver);
		a.moveToElement(targetWebElement).perform();
	}
	public static void dragDrop (WebElement dragWebElement,WebElement dropWebElement ){
		a = new Actions (driver);
		a.dragAndDrop(dragWebElement, dropWebElement).perform();
	}
	 public static JavascriptExecutor js;
	 
	 public static void scrollThepage (WebElement tarWebele) {
		js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView(true)", tarWebele);
	}
	 public static void scroll(WebElement element) {
		 js = (JavascriptExecutor)driver;
		 js.executeScript("argument[0].scrollIntoView(false)", element);
		
	}
	 public static void excelRead (String sheetName, int rowNum, int cellNum) throws FileNotFoundException {
		File f = new File("excollection.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook();
		Sheet mySheet = wb.getSheet("Data");
		Row r = mySheet.getRow(rowNum);
		 Cell c = r.getCell(cellNum);
		 int cellType = c.getCellType();
		  String value = " " ;
		  if (cellType==1) {
			String Value2 = c.getStringCellValue();
		}
		  else if (DateUtil.isCellDateFormatted(c)){
			  Date dd = c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat(value);
			String valuel = s.format(dd);
		}
		  else {
			double d = c.getNumericCellValue();
			Long l = (long) d;
			String valueOf = String.valueOf(1);
			}
	 }
 
	 public static void createNewExcelFile(int rowNum,int cellNum,String writeData) throws IOException {
		 File f = new File("Excel location.xlxs");
		 FileInputStream fis = new FileInputStream(f);
		 Workbook wb = new XSSFWorkbook(fis);
		 Sheet newSheet = wb.createSheet("Datas");
		Row newRow = newSheet.createRow(rowNum);
		Cell newCell = newRow.createCell(cellNum);
		newCell.setCellValue(writeData);
	    FileOutputStream fos = new FileOutputStream(f);
	    wb.write(fos);
	    
	}
	 public static void creatRow(int creRow,int creCell,String newData) throws IOException {
		 File f = new File("Excel file.xlxs");
		 FileInputStream fis = new FileInputStream(f);
		 Workbook wb = new XSSFWorkbook(fis);
		 Sheet s = wb.getSheet("Datas");
		Row r = s.createRow(creRow);
		Cell c = r.getCell(creCell);
		c.setCellValue(newData);
	    FileOutputStream fos = new FileOutputStream(f);
	    wb.write(fos);
	 
	 }
	 public static void updateDataToparticularCell(int getTheRow,int getThecell,String exisitingdata,String writerNewData) throws IOException {
		 File f = new File("Excel location.xlxs");
		 FileInputStream fis = new FileInputStream(f);
		 Workbook wb = new XSSFWorkbook(fis);
		 Sheet s = wb.getSheet("Datas");
		 Row r = s.getRow(getTheRow);
		Cell c = r.getCell(getThecell);
			String str = c.getStringCellValue();
			if (str.equals(exisitingdata)) {
				c.setCellValue(writerNewData);
				
			}
			FileOutputStream fos = new FileOutputStream(f);
		    wb.write(fos);
			
			}
		  
		
	  }
