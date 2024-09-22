package sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConvertIntString {

	public static void main(String[] args) throws Throwable 
	{
		FileInputStream fi = new FileInputStream("D:\\SampleXL.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("emp");
		int rc = ws.getLastRowNum();
		System.out.println("no of rows are::"+rc);
		for (int i=1; i<=rc; i++) 
		{
			if(wb.getSheet("emp").getRow(i).getCell(3).getCellType()==CellType.NUMERIC) 
			{
				int celldata = (int) wb.getSheet("emp").getRow(i).getCell(3).getNumericCellValue();
				String eid = String.valueOf(celldata);
				System.out.println(eid);
				ws.getRow(i).createCell(4).setCellValue("false");
			}
		}
		
		FileOutputStream fo = new FileOutputStream("D:\\Result.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();
	}

}
