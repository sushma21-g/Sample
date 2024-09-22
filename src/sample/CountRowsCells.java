package sample;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CountRowsCells {

	public static void main(String[] args) throws Throwable
	{
		FileInputStream fi = new FileInputStream("D:\\SampleXL.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("emp");
		int rc = ws.getLastRowNum();
		XSSFRow row = ws.getRow(0);
		int cc = row.getLastCellNum();
		System.out.println("no of row are::"+rc+"   "+"no of cells are::"+cc);
		fi.close();
		wb.close();
	}

}
