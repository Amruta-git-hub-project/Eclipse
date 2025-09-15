package TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory; 
import org.openqa.selenium.JavascriptExecutor;

import selnium.Demo_BaseClass;
import selnium.Registration_BaseClass;

public class ExcelUtil extends Registration_BaseClass { 
	static Workbook book;
	static Sheet sheet; 
	static JavascriptExecutor js; 
	/*public ArrayList<String> getData() throws IOException 
	{
	ArrayList<String> a =new ArrayList<String>();
	FileInputStream fis=new FileInputStream("D:/Automation/SELENIUM_PROJECT/src/main/java/Utilities/sheetname.xlsx");
	XSSFWorkbook workbook=new XSSFWorkbook(fis);

	int sheetsize=workbook.getNumberOfSheets();
	for(int i=0;i<sheetsize;i++)
	{
	if(workbook.getSheetName(i).equalsIgnoreCase("contactdata"))
	{
	XSSFSheet sheetindex=workbook.getSheetAt(i);
	Iterator<Row> rows=sheetindex.iterator();
	Row firstrow=rows.next();
	Iterator<Cell> ce=firstrow.cellIterator();

	int k=0;
	int col=0;
	while(ce.hasNext())
	{
	Cell value=ce.next();
	if(value.getStringCellValue().equalsIgnoreCase("firstname"))
	{
	col=k; 
	while(rows.hasNext())
	{
	Row r=rows.next();
	Iterator<Cell> rowvalue=r.cellIterator();
	while(rowvalue.hasNext())
	{
	//System.out.println(rowvalue.next().getStringCellValue());
	a.add(rowvalue.next().getStringCellValue());
	}
	}
	}
	k++;
	}
	System.out.println(col);

	}
	} 
	return a;

	
	}*///getdata//
	public static String TESTDATA_SHEET_PATH = "C:/Users/amnaik/eclipse-workspace/selnium/src/main/java/testdata/Registration_Form.xlsx";  
	public static int CurrentRow=1;// 
	public static String sheetsname="Registration.xlsx";
	public static Object[][] getTestData(String sheetname) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException  {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) { 
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetname);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 System.out.println(sheet.getLastRowNum() + "--------" );
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) { 
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				 System.out.println(data[i][k]);
			}
		}
		return data;
	} 
	
	
	// New method to write back transaction id
	
    public static void setCellData(String sheetName, int rowNum, int colNum, String value) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(TESTDATA_SHEET_PATH);
            book = WorkbookFactory.create(fis);
            sheet = book.getSheet(sheetName);

            sheet.getRow(rowNum).createCell(colNum).setCellValue(value);

            fos = new FileOutputStream(TESTDATA_SHEET_PATH);
            book.write(fos);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (book != null) book.close();
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
	public static String Sheet="Registration.xlsx";
	public static String SHEET_PATH = "C:/Users/amnaik/eclipse-workspace/selnium/src/main/java/testdata/Add_Row_ProjectDetails.xlsx";  

	public static Object[][] AddRow(String Sheet) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException  {
		FileInputStream file = null;
		try {
			file = new FileInputStream(SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace(); 
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) { 
			e.printStackTrace();
		}
		sheet = book.getSheet(Sheet); 
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		 System.out.println(sheet.getLastRowNum() + "--------" );
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) { 
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				 System.out.println(data[i][k]);
			}
		}
		return data;
	} 
	
	
	
}
