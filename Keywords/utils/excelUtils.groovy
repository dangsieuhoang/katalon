package utils

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kms.katalon.core.annotation.Keyword;

import constant.ConstantTest

class excelUtils {
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;

	/**
	 *
	 * @param result
	 * noi dung can in ra file excel
	 * @param RowNum
	 * so hang
	 * @param ColNum
	 * so cot
	 * @param filepath
	 * dia chi file
	 * @throws Exception
	 */
	@Keyword
	public void setCellData(String result, int RowNum, int ColNum, String filepath) throws Exception {
		try {
			FileInputStream fis = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheet("Sheet1");
			Row row = sheet.getRow(RowNum );
			Cell Cell

			// Aqua Background
			CellStyle style = workbook.createCellStyle();
			XSSFFont font = workbook.createFont();
			font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
			font.setColor(IndexedColors.WHITE.getIndex());
			style.setFont(font);
			if(result.equals(ConstantTest.PassTC)) {
				style.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
				style.setFillPattern(FillPatternType.BIG_SPOTS);
				style.setBorderBottom(BorderStyle.THIN);
				style.setBorderLeft(BorderStyle.THIN);
				style.setBorderRight(BorderStyle.THIN);
				style.setBorderTop(BorderStyle.THIN);
			} else if(result.equals(ConstantTest.FailTC)) {
				style.setFillBackgroundColor(IndexedColors.RED.getIndex());
				style.setFillPattern(FillPatternType.BIG_SPOTS);
				style.setBorderBottom(BorderStyle.THIN);
				style.setBorderLeft(BorderStyle.THIN);
				style.setBorderRight(BorderStyle.THIN);
				style.setBorderTop(BorderStyle.THIN);
			} else {
				style.setFillBackgroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
				style.setFillPattern(FillPatternType.BIG_SPOTS);
				style.setBorderBottom(BorderStyle.THIN);
				style.setBorderLeft(BorderStyle.THIN);
				style.setBorderRight(BorderStyle.THIN);
				style.setBorderTop(BorderStyle.THIN);
			}

			if(Cell == null) {
				Cell = row.createCell(ColNum);
				Cell.setCellValue(result);
				Cell.setCellStyle(style);
			} else {
				Cell.setCellValue(result);
				Cell.setCellStyle(style);
			}

			// Open file and write the result
			FileOutputStream fileOut = new FileOutputStream(filepath);
			workbook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw (e);
		}
	}

	@Keyword
	public int findRow(String cellContent, String filepath){
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int rowNum = 0;

		for (Row row : sheet) {
			for (Cell cell : row) {
				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
						println("rowNum   " + row.getRowNum())
						return row.getRowNum();
					}
				}
			}
		}
		return -1;
	}

}