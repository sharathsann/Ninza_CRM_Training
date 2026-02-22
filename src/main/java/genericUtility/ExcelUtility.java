package genericUtility;

import java.io.*;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public  String readDatafromExcelFile(String sheetName,int row,int cell)throws EncryptedDocumentException, IOException
	{
		
        FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Excel1.xlsx");
       Workbook wb = WorkbookFactory.create(fis);
      String data= wb.getSheet(sheetName).getRow(row).getCell(cell).toString();
      wb.close();
      return data;
     
      
    

      
	}
}


