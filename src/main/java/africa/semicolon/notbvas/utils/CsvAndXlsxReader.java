package africa.semicolon.notbvas.utils;

import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


public class CsvAndXlsxReader {
	
	private final Logger logger = LoggerFactory.getLogger(CsvAndXlsxReader.class);
	
	public void readXlsx() {
		try {
			InputStream GEG217StudentsParticipationStream = new  FileInputStream("C:/Users/USER/Downloads/Participation_list.xlsx");
			Workbook workbook = WorkbookFactory.create(GEG217StudentsParticipationStream);
			Sheet sheet = workbook.getSheetAt(0);
			sheet.forEach((row1) ->{
				String cellValue = row1.getCell(0).getStringCellValue();
				if (cellValue.contains("Abdulmalik") || cellValue.contains("Alayande"))
					System.out.println(cellValue);
			});
			System.out.println();
			workbook.close();
			GEG217StudentsParticipationStream.close();
		} catch (IOException e) {
			logger.info(e.getMessage());
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		CsvAndXlsxReader reader = new CsvAndXlsxReader();
		reader.readXlsx();
	}
}
