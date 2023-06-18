package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
//We will consider flag == 1 => Value ,flag == 0 => Identifier
public class excelDataProvider {

    public static boolean writeCellAgainstKey ( String key,String value ) 
    {
    try
    {
                    FileInputStream fileInputStream = new FileInputStream( staticData.repoLocation );

                    HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
                    HSSFSheet worksheet = workbook.getSheet( staticData.enviormentUnderTest );
                    FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
                    DataFormatter objDefaultFormat = new DataFormatter();
                    int rowNum = worksheet.getLastRowNum() + 1;
                    int colNum = worksheet.getRow(0).getLastCellNum();                   
                    int rowToUpdate = 0;
                    int colToUpdate = 0;

                    for (int i = 0 ; i < rowNum ; i++) {
                                      HSSFRow row = worksheet.getRow(i);
                for (int j = 0 ; j < colNum ; j++) 
                {
                    HSSFCell cell = row.getCell(j);                     
                    if(key.equals( cell.toString().trim() ))
                    {
                                    rowToUpdate = i;
                                    colToUpdate = j+1;
                    }
                }
                       }
    try {
                                    HSSFRow rowUnderUpdate = worksheet.getRow( rowToUpdate );
                        HSSFCell cellToUppdate = rowUnderUpdate.getCell( colToUpdate );
                        cellToUppdate.setCellValue( value );
            FileOutputStream fileOut = new FileOutputStream( new File( staticData.repoLocation  ));
            workbook.write(fileOut);
            fileOut.close();
           // workbook.close();
            return true;
                    } catch (Exception e) {
                                    e.printStackTrace();
                                    return false;
                    } 
                    }
    catch(Exception e)
    {
                      return false;
    }
}

	public static List<String> getAllRunnableEnviroments (  ) 
	{
		try
		{
			List<String> enviromentDetails = new LinkedList<String>();
			FileInputStream fileInputStream = new FileInputStream( staticData.repoLocation );

			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet worksheet = workbook.getSheet( staticData.environmentDetailsSheetName );
			FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
			DataFormatter objDefaultFormat = new DataFormatter();
		    int rowNum = worksheet.getLastRowNum() + 1;
			int colNum = worksheet.getRow(0).getLastCellNum();
			 for (int i = 0 ; i < rowNum ; i++) {
				  HSSFRow row = worksheet.getRow(i);
				  HSSFCell cell = row.getCell(staticData.needAdditionalParams1);
				  
				  if(cell.toString().trim().equalsIgnoreCase("yes"))
				  {
					  enviromentDetails.add(row.getCell(0).toString().trim());  
				  }
			   }
        	 fileInputStream.close();
			  return enviromentDetails;
			}
		catch(Exception e)
		{
			  return null;
		}

	}
//webservice
	public static List<String> getAllWebservices ( int columnValue, String Sheetname ) 
	{
		try
		{
			List<String> enviromentDetails = new LinkedList<String>();
			FileInputStream fileInputStream = new FileInputStream( staticData.repoLocation1 );

			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet worksheet = workbook.getSheet( Sheetname );
			FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
			DataFormatter objDefaultFormat = new DataFormatter();
		    int rowNum = worksheet.getLastRowNum() + 1;
			int colNum = worksheet.getRow(0).getLastCellNum();
			 for (int i = 1 ; i < rowNum ; i++) {
				  HSSFRow row = worksheet.getRow(i);
				  HSSFCell cell = row.getCell(columnValue);
				  enviromentDetails.add(cell.toString().trim());  
				  
				 /* if(cell.toString().trim().equalsIgnoreCase("yes"))
				  {
					  enviromentDetails.add(row.getCell(0).toString().trim());  
				  }*/
			   }
        	 fileInputStream.close();
			  return enviromentDetails;
			}
		catch(Exception e)
		{
			  return null;
		}

	}
	
	public static List<String> getSelectedWebservices ( int columnValue, String Sheetname, int flag ) 
	{
		try
		{
			List<String> enviromentDetails = new LinkedList<String>();
			FileInputStream fileInputStream = new FileInputStream( staticData.repoLocation );

			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet worksheet = workbook.getSheet( Sheetname );
			FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
			DataFormatter objDefaultFormat = new DataFormatter();
		    int rowNum = worksheet.getLastRowNum() + 1;
			int colNum = worksheet.getRow(0).getLastCellNum();
			for (int i = 2 ; i < rowNum ; i++) {
				  HSSFRow row = worksheet.getRow(i);
				  HSSFCell cell1 = row.getCell(flag);
				  if(cell1.toString().equalsIgnoreCase("Yes"))
				  {
				  HSSFCell cell = row.getCell(columnValue);
				  enviromentDetails.add(cell.toString().trim()); 
				  }
				  
				 /* if(cell.toString().trim().equalsIgnoreCase("yes"))
				  {
					  enviromentDetails.add(row.getCell(0).toString().trim());  
				  }*/
			   }
        	 fileInputStream.close();
			  return enviromentDetails;
			}
		catch(Exception e)
		{
			  return null;
		}

	}

	public static String getCellValueByFieldName ( String keyCellValue ,String sheetName ) 
	{
		try
		{
			String a = staticData.repoLocation3;
			FileInputStream fileInputStream = new FileInputStream( staticData.repoLocation );

			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet worksheet = workbook.getSheet( sheetName );
			FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
			DataFormatter objDefaultFormat = new DataFormatter();
		    int rowNum = worksheet.getLastRowNum() + 1;
			int colNum = worksheet.getRow(0).getLastCellNum();
			 
			 for (int i = 0 ; i < rowNum ; i++) {
				  HSSFRow row = worksheet.getRow(i);
		            for (int j = 0 ; j < colNum ; j++) {
		                HSSFCell cell = row.getCell(j);
		                
		                if(keyCellValue.equals( cell.toString().trim() ))
		                {
		                	 HSSFRow row1 = worksheet.getRow(1);
		                	 HSSFCell cell1 = null;
		                	  cell1 = row.getCell(j+1);
		                	 objFormulaEvaluator.evaluate(cell1);
		                	 String cellValueStr1 = objDefaultFormat.formatCellValue(cell1);
		                	 fileInputStream.close();
		 	                return cellValueStr1.trim();
		                }
		            }
			   }
        	 fileInputStream.close();
			  return null;
			}
		catch(Exception e)
		{
			 
			e.printStackTrace();
			System.out.print(e);
			 return null;
		}

	}
	public static String getEnvironmentDetailsForSuit ( String cellValue ,int flag ) 
	{
	try
	{
		FileInputStream fileInputStream = new FileInputStream( staticData.repoLocation );

		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet worksheet = workbook.getSheet(staticData.environmentDetailsSheetName);
		FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
		DataFormatter objDefaultFormat = new DataFormatter();
	    int rowNum = worksheet.getLastRowNum() + 1;
		int colNum = worksheet.getRow(0).getLastCellNum();

		 for (int i = 0 ; i < rowNum ; i++) {
			  HSSFRow row = worksheet.getRow(i);
	            for (int j = 0 ; j < colNum ; j++) {
	                HSSFCell cell = row.getCell(j);
	                if(cellValue.equals( cell.toString().trim() ))
	                {
	                	 HSSFRow row1 = worksheet.getRow(1);
	                	 HSSFCell cell1 = null;
	                	 if(flag==0)
	                	  cell1 = row.getCell(j+1);
	                	 if(flag==1)
		                	  cell1 = row.getCell(j+2);
	                	 if(flag==2)
		                	  cell1 = row.getCell(j+3);
	                	 objFormulaEvaluator.evaluate(cell1);
	                	 String cellValueStr1 = objDefaultFormat.formatCellValue(cell1);
	                	 fileInputStream.close();
	 	                return cellValueStr1.trim();
	                }
	            }
		   }
    	 fileInputStream.close();
		  return null;
		}
	catch(Exception e)
	{
		  return null;
	}
 }                                             
	public static String getEnvironmentDetailsForSuit ( String cellValue,String sheetName  ,int flag ) 
	{
	try
	{
		FileInputStream fileInputStream = new FileInputStream(staticData.repoLocation);

		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet worksheet = workbook.getSheet( sheetName );
		FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
		DataFormatter objDefaultFormat = new DataFormatter();
	    int rowNum = worksheet.getLastRowNum() + 1;
		int colNum = worksheet.getRow(0).getLastCellNum();

		 for (int i = 0 ; i < rowNum ; i++) {
			  HSSFRow row = worksheet.getRow(i);
	            for (int j = 0 ; j < colNum ; j++) {
	                HSSFCell cell = row.getCell(j);
	                if(cellValue.equals( cell.toString().trim() ))
	                {
	                	 HSSFRow row1 = worksheet.getRow(1);
	                	 HSSFCell cell1 = null;
	                	 if(flag==0)
		                	  cell1 = row.getCell(j+1);
		                	 if(flag==1)
			                	  cell1 = row.getCell(j+2);
		                	 if(flag==2)
			                	  cell1 = row.getCell(j+3);
	                	 objFormulaEvaluator.evaluate(cell1);
	                	 String cellValueStr1 = objDefaultFormat.formatCellValue(cell1);
	                	 fileInputStream.close();
	 	                return cellValueStr1.trim();
	                }
	            }
		   }
    	 fileInputStream.close();
		  return null;
		}
	catch(Exception e)
	{
		 e.printStackTrace();
		  return null;
	}
 }//abhijit  
	public static boolean updateCell ( String cellValue,String sheetName  ,int flag ,String valueToUpdate ) 
	{
	try
	{
		FileInputStream fileInputStream = new FileInputStream( staticData.repoLocation );

		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet worksheet = workbook.getSheet(sheetName);
		FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
		DataFormatter objDefaultFormat = new DataFormatter();
	    int rowNum = worksheet.getLastRowNum() + 1;
		int colNum = worksheet.getRow(0).getLastCellNum();

		 for (int i = 0 ; i < rowNum ; i++) {
			  HSSFRow row = worksheet.getRow(i);
	            for (int j = 0 ; j < colNum ; j++) {
	                HSSFCell cell = row.getCell(j);
	                if(cellValue.equals( cell.toString().trim() ))
	                {
	                	 HSSFRow row1 = worksheet.getRow(1);
	                	 HSSFCell cell1 = null;
	                	 
	                	 if(flag==0)
	                	    row.getCell(j+1).setCellValue(valueToUpdate);
	                	 if(flag==1)
		                	  row.getCell(j+2).setCellValue(valueToUpdate);
	                	 if(flag==2)
		                	 row.getCell(j+3).setCellValue(valueToUpdate);
	                	 objFormulaEvaluator.evaluate(cell1);
	                	 String cellValueStr1 = objDefaultFormat.formatCellValue(cell1);
	                	 fileInputStream.close();
	 	                return true;
	                }
	            }
		   }
    	 fileInputStream.close();
		  return false;
		}
	catch(Exception e)
	{
		  return false;
	}
 }
	public static String getSpecificCellValue ( int columnValue, String app,String Sheetname ) 
	{
		try
		{
			String enviromentDetails = "";
			FileInputStream fileInputStream = new FileInputStream( staticData.repoLocation );

			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet worksheet = workbook.getSheet( Sheetname );
			FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
			DataFormatter objDefaultFormat = new DataFormatter();
		    int rowNum = worksheet.getLastRowNum() + 1;
			//int colNum = worksheet.getRow(0).getLastCellNum();
			for (int i = 0 ; i < rowNum ; i++) {
				  HSSFRow row = worksheet.getRow(i);
		   // int rowNum = rowValue;
			int colNum = columnValue;
			//HSSFRow row = worksheet.getRow(rowNum);
			HSSFCell cellApp = row.getCell(1);
			HSSFCell cellIsRun = row.getCell(3);
			if (cellApp.toString().equalsIgnoreCase(app)&& cellIsRun.toString().equalsIgnoreCase("Yes"))
			{
				HSSFCell cell = row.getCell(colNum);
				enviromentDetails = cell.toString().trim();
			  }
			}
			 fileInputStream.close();
			 return enviromentDetails;
			}
		catch(Exception e)
		{
			  return null;
		}

	}
}