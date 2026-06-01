import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CheckSheets {
    public static void main(String[] args) throws Exception {
        String filePath = "C:\\MyWorkspace\\Selenium\\OrangeHRM-Automation\\src\\test\\resources\\DataRepository\\DataRepository.xlsx";
        File file = new File(filePath);
        
        System.out.println("Excel file path: " + filePath);
        System.out.println("File exists: " + file.exists());
        System.out.println("File size: " + file.length() + " bytes\n");
        
        try (FileInputStream fis = new FileInputStream(file);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            
            int sheetCount = workbook.getNumberOfSheets();
            System.out.println("Total sheets in workbook: " + sheetCount + "\n");
            
            for (int i = 0; i < sheetCount; i++) {
                String sheetName = workbook.getSheetName(i);
                System.out.println((i+1) + ". Sheet name: '" + sheetName + "'");
            }
        } catch (Exception e) {
            System.err.println("Error reading Excel file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
