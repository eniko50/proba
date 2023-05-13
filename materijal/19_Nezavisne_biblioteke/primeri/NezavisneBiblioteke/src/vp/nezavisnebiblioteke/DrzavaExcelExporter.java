package vp.nezavisnebiblioteke;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DrzavaExcelExporter {

	public static void main(String[] args) {
		ArrayList<Drzava> drzave = new ArrayList<>();
		drzave.add(new Drzava("sr", "Srbija"));
		drzave.add(new Drzava("fr", "Francuska")); 
		drzave.add(new Drzava("it", "Italija"));
		
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("Drzave");
		
		int brojReda = 0;
		
		Row row = sheet.createRow(brojReda++);
	    
		Cell cell = row.createCell(0);
	    cell.setCellValue("Oznaka");
	    cell = row.createCell(1);
	    cell.setCellValue("Naziv");
	    
	    for (Drzava d: drzave) {
	    	row = sheet.createRow(brojReda++);
	    	cell = row.createCell(0);
	    	cell.setCellValue(d.getOznaka());
	    	cell = row.createCell(1);
	    	cell.setCellValue(d.getNaziv());
	    }
		
		try {
			FileOutputStream fileOut = new FileOutputStream("data/drzave.xlsx");
			wb.write(fileOut);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	   
	}

}
