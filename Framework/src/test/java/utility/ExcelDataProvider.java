package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;

	public ExcelDataProvider() {

		File src = new File("./TestData/Data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to Read Excel File" + e.getMessage());
		}

	}

	public String getStringData(int Sheetindex, int rowvalue, int colvalue) {
		return wb.getSheetAt(Sheetindex).getRow(rowvalue).getCell(colvalue).getStringCellValue();

	}

	public String getStringData(String Sheetname, int rowvalue, int colvalue) {
		return wb.getSheet(Sheetname).getRow(rowvalue).getCell(colvalue).getStringCellValue();

	}

	public double getNumericData(String Sheetname, int rowvalue, int colvalue) {
		return wb.getSheet(Sheetname).getRow(rowvalue).getCell(colvalue).getNumericCellValue();

	}

	public void getNumericData() {

	}
}
