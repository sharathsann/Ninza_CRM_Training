package DDPractice;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReadData {

	public  void main(String[] args) throws EncryptedDocumentException, IOException 
	
	   {
		
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\Excel1.xlsx");
			Workbook wb =WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("mobiles");
			int rowcount = sh.getLastRowNum();
			for(int i=1; i<=rowcount;i++)
			{
				String productCat = sh.getRow(i).getCell(0).getStringCellValue();
				String ProdcutName = sh.getRow(i).getCell(1).getStringCellValue();
				System.out.println(productCat+"======"+ProdcutName);
			}
			
			
			
		}
		
		

	}


