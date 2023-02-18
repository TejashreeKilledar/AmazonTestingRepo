package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static String path=".//dataFiles//Book1.xlsx";
	public static void captureScreenShot(WebDriver driver,String fileName) throws IOException 
	{
		
			Date d=new Date();
			String date = d.toString().replace(":", ";").replace(" ;", "-") ;
			TakesScreenshot t=(TakesScreenshot)driver;
			File src=t.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src,new File("./Screenshot/"+fileName+ ""+ date));
				
				
	}
	public static String getExcelCellDataValue(String sheetName,int rownum,int colnum) throws IOException
	{
		FileInputStream f1=new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(f1);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
		
	//	XSSFRow row=sheet.getRow(rownum);
		XSSFRow row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		XSSFCell cell=row.getCell(colnum);
		
/*	for(int i=1;i<=rowCount;i++)
		{
			Row rows=sheet.getRow(i);
			for(int j=0;j<cellcount;j++)
			{
				Cell cell1=rows.getCell(j);
				String value=cell.getStringCellValue();
				
				switch(cell1.getCellType())
				{
				
				case STRING: System.out.print(cell.getStringCellValue());
				break;
				case NUMERIC: System.out.print((long)cell.getNumericCellValue());
				break;
				case FORMULA: System.out.print(cell.getDateCellValue());
				break;
				case BOOLEAN: System.out.println(cell.getBooleanCellValue());
				}
			}
		}*/
		
		DataFormatter formatter=new DataFormatter();
		String data;
		try
		{
			data=formatter.formatCellValue(cell);
		}
		catch(Exception e)
		{
			System.out.println("Catch block");
			data="";
		
		}
		workbook.close();
		f1.close();
	
		return data;
		//row=sheet.g
		
		
	}
}
