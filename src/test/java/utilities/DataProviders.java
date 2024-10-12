package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = ".\\testData\\mycartLoginData.xlsx";// taking excel file from testData
		ExcelUtility excelUtil = new ExcelUtility(path);// creating an object for XLUtility

		int totalrows = excelUtil.getRowCount("Sheet1");
		int totalcols = excelUtil.getCellCount("Sheet1", 1);

		String loginDataArray[][] = new String[totalrows][totalcols];// created for two dimension array which can store the data user name and password

		for (int i = 1; i <= totalrows; i++) // 1 //read the data from excel storing in two dimensional array
		{
			for (int j = 0; j < totalcols; j++) // 0 i is rows j is column
			{
				loginDataArray[i - 1][j] = excelUtil.getCellData("Sheet1", i, j); // 1,0
			}
		}
		return loginDataArray;// returning two dimension array

	}
}