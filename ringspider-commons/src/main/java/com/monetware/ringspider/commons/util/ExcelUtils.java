package com.monetware.ringspider.commons.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author yangjl
 */
public class ExcelUtils {
    @SuppressWarnings("deprecation")
    public static String getCellValue(Cell cell, boolean ignoreType) {
	String cellValue = null;
	if (cell == null) {
	    return null;
	}

	if (ignoreType) {
	    cell.setCellType(Cell.CELL_TYPE_STRING);
	    cellValue = String.valueOf(cell.getStringCellValue());
	} else {
	    DecimalFormat df = new DecimalFormat("#");
	    int cellType = cell.getCellType();
	    switch (cellType) {
	    case Cell.CELL_TYPE_NUMERIC:
		if (HSSFDateUtil.isCellDateFormatted(cell)) {
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    cellValue = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
		} else {
		    cellValue = df.format(cell.getNumericCellValue());
		}
		break;
	    case Cell.CELL_TYPE_STRING:
		cellValue = String.valueOf(cell.getStringCellValue());
		break;
	    case Cell.CELL_TYPE_FORMULA:
		cellValue = String.valueOf(cell.getCellFormula());
		break;
	    case Cell.CELL_TYPE_BLANK:
		cellValue = null;
		break;
	    case Cell.CELL_TYPE_BOOLEAN:
		cellValue = String.valueOf(cell.getBooleanCellValue());
		break;
	    case Cell.CELL_TYPE_ERROR:
		cellValue = String.valueOf(cell.getErrorCellValue());
		break;
	    }
	}

	if (cellValue != null && cellValue.trim().length() <= 0) {
	    cellValue = null;
	}
	return cellValue != null ? cellValue.trim() : cellValue;
    }

	/**
	 * HashMap
	 */
	public static void exportExcel(List<HashMap> datas, String fileName, String[] columns, String[] columnTexts, String sheetName, HttpServletResponse response)throws Exception{
		String fileExcelName = new SimpleDateFormat("yyyyMMddhh").format(new Date()).toString() + fileName;
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(sheetName);
		HSSFRow row = sheet.createRow((int) 0);//创建第一行
		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		Boolean isHasTitle=false;
		for (int i=0;i<datas.size();i++){
			HSSFRow rowBatch = sheet.createRow((int) i + 1);
			HashMap nowData=datas.get(i);
			int k=0;
			for (Object key : nowData.keySet()) {
				if(!isHasTitle){
					for(int columnTextLength=0;columnTextLength<columnTexts.length;columnTextLength++){
						row.createCell(columnTextLength).setCellValue(columnTexts[columnTextLength]);
					}
					isHasTitle=true;
				}
				for(int columnLength=0;columnLength<columns.length;columnLength++){
					rowBatch.createCell(columnLength).setCellValue(nowData.get(columns[columnLength]) == null ? "" : nowData.get(columns[columnLength]).toString());
				}
				k++;
			}
		}
		if(datas.size()==0){
			for(int columnTextLength=0;columnTextLength<columnTexts.length;columnTextLength++){
				row.createCell(columnTextLength).setCellValue(columnTexts[columnTextLength]);
			}
		}
		// 弹出保存框方式
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			workbook.write(os);

		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		// 设置response参数，可以打开下载页面
		response.reset();
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1") + ".xls");

		ServletOutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			byte[] buff = new byte[2048];
			int bytesRead;
			// Simple read/write loop.
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (bis != null){
				bis.close();
			}

			if (bos != null){
				bos.close();
			}
		}
	}
}
