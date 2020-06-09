package UserDefinedlibraries; 

import java.io.File;

 

import java.io.FileInputStream; 

import java.io.FileNotFoundException; 

import java.io.FileOutputStream; 

import java.io.IOException; 

 

import org.apache.poi.xssf.usermodel.XSSFCell; 

import org.apache.poi.xssf.usermodel.XSSFRow; 

import org.apache.poi.xssf.usermodel.XSSFSheet; 

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 


public class ExcelReadWrite  { 


	public static File src; 
	public static String exfilepath = "C:\\Users\\NISHANTH\\eclipse-workspace1\\Alpha\\src\\test\\java\\TestData\\ExcelData.xlsx"; 
	public static FileInputStream fileip; 
	public static FileOutputStream fileop; 
	public static XSSFWorkbook workbook;  
	public static XSSFSheet sheet; 
	public static String val1; 
	public static int row;
	public static XSSFCell cell; 
	public static XSSFRow Row; 
	public static String Ridefare,Result,adult; 
	public static String Menu1,Menu2,Menu3;

	public static int readexcel() { 

		try { 
			
			src=new File(exfilepath); 
			fileip = new FileInputStream(src); 
			workbook = new XSSFWorkbook(fileip);  
			sheet = workbook.getSheetAt(0); 
			
			for(int i=1; i<=sheet.getLastRowNum(); i++){ 
				
				if(i==1){ 
					
					Menu1 = (sheet.getRow(i).getCell(0)).getStringCellValue();
					Ridefare = (sheet.getRow(i).getCell(1)).getStringCellValue();
					Menu2 = (sheet.getRow(i).getCell(2)).getStringCellValue();
					Result = (sheet.getRow(i).getCell(3)).getStringCellValue();
					Menu3 = (sheet.getRow(i).getCell(4)).getStringCellValue();
					adult = (sheet.getRow(i).getCell(5)).getStringCellValue();  

                    row=i;                  
                    break;          
				} 		
			}     
			
		}catch (FileNotFoundException e){ 
			
			e.printStackTrace(); 
			
		}catch (IOException e){ 
			
			e.printStackTrace(); 
			
		} 
		return row; 
		
	} 
	
	public static void writeexcel() { 

		try {    
			//Close input stream 
			fileip.close(); 
			
			//Create an object of FileOutputStream class to create write data in excel file 
			fileop =new FileOutputStream(new File(exfilepath)); 
			
			//write data in the excel file 
			workbook.write(fileop); 
			
			//close output stream
			fileop.close();             
			
		} catch (FileNotFoundException e){ 
			
			e.printStackTrace(); 
			
		} catch (IOException e){ 
			
			e.printStackTrace(); 
			
		}
		
	}
	
}