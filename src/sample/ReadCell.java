package sample;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadCell {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fi = new FileInputStream("D:\\SampleXL.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("emp");
		int rc = ws.getLastRowNum();
		System.out.println("No.of Rows are"+rc);
		String fname = ws.getRow(8).getCell(0).getStringCellValue();
		String mname = ws.getRow(3).getCell(1).getStringCellValue();
		String lname = ws.getRow(13).getCell(2).getStringCellValue();
		int eid = (int) ws.getRow(5).getCell(3).getNumericCellValue();
		System.out.println(fname+"     "+ mname+"     "+lname +"    "+eid );
		fi.close();
		wb.close();	

	}

}
