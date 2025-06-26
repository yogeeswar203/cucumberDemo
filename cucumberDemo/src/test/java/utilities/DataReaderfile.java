package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReaderfile {
	
	public static HashMap<String, String> storeValues = new HashMap<String, String>();
	
	public static List<HashMap<String, String>> data(String filepath, String sheetName) throws IOException{
		
		List<HashMap<String, String>> mydata = new ArrayList<>();
		
		FileInputStream file = new FileInputStream(filepath);
		
		try (XSSFWorkbook workbook = new XSSFWorkbook(file)) {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			int total_rows = sheet.getLastRowNum();
			XSSFRow headerRow = sheet.getRow(0);
			
			for(int i=1; i<=total_rows; i++) {
				XSSFRow current_row = sheet.getRow(i);
				HashMap<String, String> currentHash = new HashMap<String, String>();
				
				for(int j=0; j<current_row.getLastCellNum(); j++) {
					XSSFCell currentCell = current_row.getCell(j);
					currentHash.put(headerRow.getCell(j).toString(), currentCell.toString());
				}
				mydata.add(currentHash);
			}
		}
		file.close();
		return mydata;
		
	}

}
