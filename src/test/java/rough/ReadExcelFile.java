package rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// specify the file location
		File src = new File("C:\\eclipse-workspace-201906\\automationtesting\\src\\test\\resources\\exceldata\\TestData.xlsx");
		
		//load the file
		
		FileInputStream fis = new FileInputStream(src);
		
		//load workbook from the excel file
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		//loading the sheet 1 ( "0" is index of first sheet)
		XSSFSheet sheet = wb.getSheetAt(0);
		
		String data=sheet.getRow(1).getCell(1).getStringCellValue();
		
		System.out.println(data);
		
		wb.close();

	}

}
