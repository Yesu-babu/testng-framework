package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadXLData {
	
	@DataProvider(name="bvtdata")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
		String excelSheetName=m.getName();
		File f=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fis=new FileInputStream(f);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);
		//to get rows
		int Trows=sheetName.getLastRowNum();
		System.out.println(Trows);
		Row rowcells=sheetName.getRow(0);
		
	//to get columns
		int Tcols=rowcells.getLastCellNum();
		System.out.println(Tcols);
		DataFormatter format=new DataFormatter();
		String testdata[][]= new String[Trows][Tcols];
		for(int i=1; i<=Trows;i++)
		{
			for(int j=0;j<Tcols;j++)
			{
				testdata[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testdata[i-1][j]);
			}
		}
		
return testdata;

}
}
