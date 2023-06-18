package util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;//abhijit
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {

	public static String dir = System.getProperty("user.dir");
	public static List<String> listname1;
	//public static List<String> listname2;
	
		public static Map<String, List<String>> getCellValueByFieldName ( String keyCellValue1 ,String sheetName1 ) 
		{
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		Map<String, String> map1 = new HashMap<String, String>();
		
		String cellValueStr1 = null;
		String cellValueStr12 = null;
		String keyCellValue =keyCellValue1;
		String sheetName=sheetName1;
	    String repoLocation =dir+ staticData.repoLocation;
	    try
			{
	    	   listname1 = new ArrayList<String>();
	    	    FileInputStream fileInputStream = new FileInputStream(repoLocation);			
				XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
				System.out.println("@@@@@@@@@@@@@@@@@@");
				XSSFSheet worksheet = workbook.getSheet(sheetName);
				System.out.println("##################");
				FormulaEvaluator objFormulaEvaluator = new XSSFFormulaEvaluator(workbook);
				DataFormatter objDefaultFormat = new DataFormatter();
			    int rowNum = worksheet.getLastRowNum() + 1;
				//int colNum = worksheet.getRow(10).getLastCellNum();
				int colNum = worksheet.getRow(rowNum-2).getLastCellNum();
				int count =0;
				for (int i = 0 ; i < rowNum ; i++) {
				XSSFRow row = worksheet.getRow(i);
				XSSFCell cell = row.getCell(0); 
				try{
			    if(keyCellValue.equals( cell.toString().trim() ) && count==0)
			       {    
			    count++;
			    if(count ==1)
			            {
			    for (int i1 = i+1 ; i1 < rowNum ; i1++){   	
			    XSSFRow row2 = worksheet.getRow(i1);
			    XSSFCell cell1 = row.getCell(0);    
			    if((keyCellValue.equals( cell1.toString().trim() )&& count==1))
			            	 { 
			    count++;
			    for (int j = 0 ; j < colNum ; j++) {
			    	int loopCount = 0;
			    XSSFCell cell11 = null;
			    cell11 = row2.getCell(j);		  
			    objFormulaEvaluator.evaluate(cell11);
			    cellValueStr1 = objDefaultFormat.formatCellValue(cell11);
			    if(cellValueStr1.equals("")){
			    	break;
			    }else{	
			    cellValueStr1 = j+"_"+cellValueStr1;
			    List<String> listname = new ArrayList<String>();			    
			    listname1.add(cellValueStr1);
			    for (int i11 = i1+1 ; i11 < rowNum; i11++) {
			    	XSSFRow row3 = worksheet.getRow(i11);
			    	XSSFCell cell3 = row3.getCell(0);
			    if((keyCellValue.equals( cell3.toString().trim() ))) 
			          {
			    break;
			                }else{
			         for (int j1 = j ; j1 <= j ; j1++) { 
			        	XSSFCell cell12 = null;
						cell12 = row3.getCell(j1);
						objFormulaEvaluator.evaluate(cell12);
						cellValueStr12 = objDefaultFormat.formatCellValue(cell12);					                  
						listname.add(cellValueStr12);
			                			 }		                	
			            map.put(cellValueStr1,listname);			                	    	 
			                		 }
			   				    }			   			    			                	
			    fileInputStream.close(); 			 
			                	}
			            	 }
			                }else{
			                	break;
			                }
			            	}			    
			                }else{
			                	break;
			                }
			                }
				}catch(Exception e){
			//System.out.println("#################################");
				}
			            }
				
	        	 fileInputStream.close();
				}
			catch(Exception e){
				
			}
	    System.out.println( listname1);	
	    return map;
		}
		
	    public static void getCellValueByResponseFieldName ( String keyCellValue1 ,String sheetName1,String type) 
		{
	    staticData.ListOfcolumn1 = new ArrayList<String>();
	    staticData.ListOfcolumn2 = new ArrayList<String>();
	    staticData.ListOfcolumn3 = new ArrayList<String>();
	    staticData.ListOfcolumn4 = new ArrayList<String>();
	    staticData.ListOfcolumn5 = new ArrayList<String>();
		String cellValueStr1 = null;
		String cellValueStr12 = null;
		String keyCellValue2 =keyCellValue1;
		String[] keyCellValue = keyCellValue1.split("/");
		String sheetName=sheetName1;
	    String repoLocation =dir+ staticData.repoLocation;
	   
	    try
			{

	    	    FileInputStream fileInputStream = new FileInputStream(repoLocation);
	    	    HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
	    	    HSSFSheet worksheet = workbook.getSheet(sheetName);
				FormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
				DataFormatter objDefaultFormat = new DataFormatter();
			    int rowNum = worksheet.getLastRowNum() + 1;
				int colNum = worksheet.getRow(1).getLastCellNum();
				int count =0;
				for (int i = 0 ; i < rowNum ; i++) {
					HSSFRow row = worksheet.getRow(i);
					HSSFCell cell = row.getCell(0);   
			    try
			    {
			    if((keyCellValue[0].equals( cell.toString().trim() ))||keyCellValue[1].equals( cell.toString().trim() ))
			                {
			    	System.out.println(cell.toString().trim());
			    	//if (cell.toString().trim().equalsIgnoreCase("Select KPI"))
			    	 //{
			    		if (type.equalsIgnoreCase("Selected"))
			    		{
			    		if(row.getCell(4).toString().trim().equalsIgnoreCase("Yes"))
			    		 { 
			    		 staticData.ListOfcolumn1.add(row.getCell(1).toString().trim());
			    		 staticData.ListOfcolumn2.add(row.getCell(2).toString().trim());
			    		 staticData.ListOfcolumn3.add(row.getCell(3).toString().trim());
			    		 staticData.ListOfcolumn5.add(row.getCell(5).toString().trim());
			    		 }
			    	 }else if (type.equalsIgnoreCase("All"))
			    	 { 
			    		 staticData.ListOfcolumn1.add(row.getCell(1).toString().trim());
			    		 staticData.ListOfcolumn2.add(row.getCell(2).toString().trim());
			    		 staticData.ListOfcolumn3.add(row.getCell(3).toString().trim());
			    		 staticData.ListOfcolumn5.add(row.getCell(5).toString().trim());
			    	 }
			               // }
			                }
			    }catch(Exception e)
			    {
		e.getStackTrace();
			    }
			            }
	       fileInputStream.close();
				}
			catch(Exception e)
			{	 
				e.printStackTrace();
			}		
     	}
	    }
