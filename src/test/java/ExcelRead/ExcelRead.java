package ExcelRead;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelRead {
	public static String readData(int row, int col, String sheetname) throws Throwable {

		String path = System.getProperty("user.dir") + "\\ExcelData\\IEBData.xlsx";
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		Workbook W = WorkbookFactory.create(fis);
		Sheet S = W.getSheet(sheetname);
		Row r = S.getRow(row);
		Cell s = r.getCell(col);
		String data = s.toString();
		return data;
	}
}

