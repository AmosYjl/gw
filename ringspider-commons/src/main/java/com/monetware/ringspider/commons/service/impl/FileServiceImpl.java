package com.monetware.ringspider.commons.service.impl;


import com.monetware.ringspider.commons.annotation.LogDesc;
import com.monetware.ringspider.commons.service.inter.FileService;
import com.monetware.ringspider.commons.util.JsonResult;
import com.monetware.ringspider.commons.util.UUIDUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;


/**
 * @author yangjl
 */

@Service
public class FileServiceImpl implements FileService
{
	@Value("${uploaded.dir}")
	private String uploadedDir;


	/**
	 * 单个上传
	 * @param file
	 * @param subFilePath
	 * @param newFileName
	 * @return
	 */
	@Override
	public boolean saveSingleFile(MultipartFile file, String subFilePath, String newFileName) {
		String filePathStr = uploadedDir + "/" + subFilePath;
		File filePath = new File(filePathStr);
		if (!filePath.exists()) {
			filePath.mkdirs();
		}

		String orignalFileName = file.getOriginalFilename().trim();
		File destFile = null;
		if (newFileName != null) {
			destFile = new File(filePathStr + "/" + newFileName);
		} else {
			destFile = new File(filePathStr + "/" + orignalFileName);
		}

		try {

			file.transferTo(destFile);


			return true;
		} catch (IOException e) {

			return false;
		}
	}

	/**
	 * 保存单个文件
	 * @param file
	 * @return
	 */
	@Override
	@LogDesc(commonDesc = "保存单个文件")
	public boolean saveFile(File file) {
		try {
			FileUtils.write(file,null,"utf-8",true);
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	/**
	 * 多个文件上传
	 * @param files
	 * @param subFilePath
	 * @return
	 */
	@Override
	@LogDesc(commonDesc = "多个文件上传")
	public String[]  saveComplexFile(MultipartFile[] files, String subFilePath){
		String[] successFiles = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			if(saveSingleFile(files[i], subFilePath,null)){
				successFiles[i] = files[i].getOriginalFilename();
			}
		}
		return successFiles;
	}

	@SuppressWarnings("deprecation")
	@Override
	public JsonResult exportTextFile(LinkedHashMap<String, Object> titleMap,
									 List<LinkedHashMap<String, String>> exportList, String exportFileName, String exportFileSeparator) {
		if (exportList.size() == 0) {
			return new JsonResult(false, "没有可供导出的内容");
		}

		// 标题
		StringBuffer text = new StringBuffer();
		for (Map.Entry<String, Object> entry : titleMap.entrySet()) {
			String title = entry.getKey().toString();
			title = title.replace("\n", "");
			title = title.replace(" ", "");
			text.append(title).append(exportFileSeparator);
		}
		text.append("\n");

		// 内容
		for (LinkedHashMap<String, String> exportMap : exportList) {
			for (Map.Entry<String, String> entry : exportMap.entrySet()) {
				Object value = entry.getValue();
				String content = (value == null ? "" : value.toString());
				content = content.replace("null", "");
				content = content.replace("\n", "");
				text.append(content).append(exportFileSeparator);
			}
			text.append("\n");
		}

		String fileDir =uploadedDir;
		File destFile = new File(fileDir + "/" + UUIDUtil.getTimestampUUID() + ".txt");
		try {
			OutputStream os = new FileOutputStream(destFile);
			IOUtils.write(text.toString(), os);
			os.flush();
			os.close();

			HashMap<String, Object> returnData = new HashMap<String, Object>();
			returnData.put("newFileName", exportFileName);
			returnData.put("fileName", destFile.getName());
			return new JsonResult(true, returnData);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(false, "无法生成文件");
		}
	}


	@SuppressWarnings("deprecation")
	@Override
	public JsonResult exportExcel2007File(LinkedHashMap<String, Object> titleMap, List<LinkedHashMap<String, String>> valueList,
										  String exportFileName,String surveyCode) {
		if (valueList.size() == 0) {
			return new JsonResult(false, "没有可供导出的内容");
		}

		int valueQuantity = valueList.size();
		int sheetSize = 1000000;
		int sheetIndex = 0;
		int rowIndex = 0;
		SXSSFWorkbook xssf_w_book = new SXSSFWorkbook(100);
		SXSSFSheet xssf_w_sheet = null;
		Row xssf_w_row = null;// 创建一行
		Cell xssf_w_cell = null;// 创建每个单元格

		CellStyle head_cellStyle = xssf_w_book.createCellStyle();// 创建一个单元格样式
		Font head_font = xssf_w_book.createFont();
		head_font.setFontName("宋体");// 设置头部字体为宋体
		head_font.setBoldweight(Font.BOLDWEIGHT_BOLD); // 粗体
		head_font.setFontHeightInPoints((short) 12);
		head_cellStyle.setFont(head_font);// 单元格样式使用字体
		head_cellStyle.setWrapText(true);
		head_cellStyle.setBorderBottom(XSSFCellStyle.BORDER_THIN);
		head_cellStyle.setBorderLeft(XSSFCellStyle.BORDER_THIN);
		head_cellStyle.setBorderRight(XSSFCellStyle.BORDER_THIN);
		head_cellStyle.setBorderTop(XSSFCellStyle.BORDER_THIN);
		DataFormat head_format = xssf_w_book.createDataFormat();
		head_cellStyle.setDataFormat(head_format.getFormat("@"));

		CellStyle cellStyle_CN = xssf_w_book.createCellStyle();// 创建数据单元格样式(数据库数据样式)
		cellStyle_CN.setBorderBottom(XSSFCellStyle.BORDER_NONE);
		cellStyle_CN.setBorderLeft(XSSFCellStyle.BORDER_NONE);
		cellStyle_CN.setBorderRight(XSSFCellStyle.BORDER_NONE);
		cellStyle_CN.setBorderTop(XSSFCellStyle.BORDER_NONE);

		/**
		 * 写入EXCEL
		 */
		for (int index = 0; index < valueQuantity; index++) {
			if (index % sheetSize == 0) {
				xssf_w_sheet = (SXSSFSheet) xssf_w_book.createSheet(exportFileName + "_" + sheetIndex);
				xssf_w_sheet.createFreezePane(0, 1, 0, 1); // 冻结窗口
				rowIndex = 0;

				// 获取标题
				int i = 0; // 行数
				int titleRows = 0; // 标题占据的行数
				xssf_w_row = xssf_w_sheet.createRow(0 + titleRows);// 第一行写入标题行
				xssf_w_row.setHeight((short) (2 * 256));
				for (Map.Entry<String, Object> entry : titleMap.entrySet()) {
					Object key = entry.getValue(); // 标题
					xssf_w_cell = xssf_w_row.createCell(i);
					xssf_w_cell.setCellType(XSSFCell.CELL_TYPE_STRING);
					XSSFRichTextString xssfString = new XSSFRichTextString(key.toString());
					xssf_w_cell.setCellValue(xssfString);
					xssf_w_cell.setCellStyle(head_cellStyle);
					xssf_w_sheet.trackAllColumnsForAutoSizing();
					xssf_w_sheet.autoSizeColumn((short) i);
					titleRows++;
					i++;
				}
				sheetIndex++;
			}

			// 获取内容
			LinkedHashMap<String, String> responseMap = valueList.get(index);
			int z = 0; // 列数
			rowIndex++; // 数据从第二行开始
			xssf_w_row = xssf_w_sheet.createRow(rowIndex);
			xssf_w_row.setHeight((short) (1.5 * 256));
			for (Map.Entry<String, String> entry : responseMap.entrySet()) {
				Object value = entry.getValue(); // 数据
				String content = (value == null ? "" : value.toString());
				content = content.replace("null", "");
				content = content.replace("\n", "");
				xssf_w_cell = xssf_w_row.createCell((short) z);
				XSSFRichTextString xssfString = new XSSFRichTextString(String.valueOf(content));
				xssf_w_cell.setCellStyle(cellStyle_CN);
				xssf_w_cell.setCellValue(xssfString);
				z++;
			}
			//responseMap.clear();
		}

		String fileDir = uploadedDir;
		String name = null;
		if (StringUtils.isBlank(exportFileName)){
			name = UUIDUtil.getTimestampUUID() + ".xlsx";
		}else{
			name = exportFileName + ".xlsx";
		}

		String path = fileDir + "/survey-file/export-data/" + surveyCode;
		File file = new File(path);
		if (!file.exists()){
			file.mkdirs();
		}
		File destFile = new File(path + "/" + name);
		//文件写入到磁盘
		this.saveFile(destFile);
		try {
			OutputStream os = new FileOutputStream(destFile);
			xssf_w_book.write(os);
			os.flush();
			os.close();
			xssf_w_book.dispose();
			xssf_w_book.close();

			HashMap<String, Object> returnData = new HashMap<String, Object>();
			returnData.put("newFileName", name);
			returnData.put("fileName", name);
			returnData.put("file", destFile);
			//存入数据库的下载路径
			returnData.put("filePath", "uploaded/survey-file/export-data/" + surveyCode + "/" + name);
			returnData.put("fileSize", new File(uploadedDir + "/survey-file/export-data/" + surveyCode + "/" + name).length());
			return new JsonResult(true, returnData);
		} catch (Exception e) {
			e.printStackTrace();
			return new JsonResult(false, "无法生成文件");
		}
	}

	@SuppressWarnings({ "deprecation", "rawtypes" })
	@Override
	public boolean exportResponseForExcel2007(HttpServletResponse servletResponse,
											  List<LinkedHashMap<String, String>> exportResponseList, String exportFileName) {
		servletResponse.reset();
		servletResponse.setHeader("Charset", "UTF-8");
		servletResponse.setHeader("Content-Type", "application/force-download");
		servletResponse.setHeader("Content-Type", "application/vnd.ms-excel");
		try {
			servletResponse.setHeader("Content-disposition",
					"attachment; filename=" + URLEncoder.encode(exportFileName, "utf8") + ".xls");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		servletResponse.setContentType("application/msexcel");

		HSSFWorkbook xssf_w_book = new HSSFWorkbook();
		HSSFSheet xssf_w_sheet = xssf_w_book.createSheet("答卷导出");
		HSSFRow xssf_w_row = null;// 创建一行
		HSSFCell xssf_w_cell = null;// 创建每个单元格
		xssf_w_sheet.createFreezePane(0, 1, 0, 1); // 冻结窗口
		HSSFCellStyle head_cellStyle = xssf_w_book.createCellStyle();// 创建一个单元格样式
		HSSFFont head_font = xssf_w_book.createFont();
		head_font.setFontName("宋体");// 设置头部字体为宋体
		head_font.setBoldweight(Font.BOLDWEIGHT_BOLD); // 粗体
		head_font.setFontHeightInPoints((short) 12);
		head_cellStyle.setFont(head_font);// 单元格样式使用字体
		// head_cellStyle.setVerticalAlignment(org.apache.poi.ss.usermodel.VerticalAlignment.CENTER);
		// head_cellStyle.setAlignment(HorizontalAlignment.LEFT);
		head_cellStyle.setWrapText(true);
		head_cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		head_cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		head_cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
		head_cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);

		// 获取标题
		LinkedHashMap<String, String> responseTitleHashMap = new LinkedHashMap<String, String>();
		if (exportResponseList != null && exportResponseList.size() > 0) {
			responseTitleHashMap = exportResponseList.get(0);
		}
		int i = 0; // 行数
		int titleRows = 0; // 标题占据的行数
		xssf_w_row = xssf_w_sheet.createRow(0 + titleRows);// 第一行写入标题行
		xssf_w_row.setHeight((short) (2 * 256));

		for (Map.Entry entry : responseTitleHashMap.entrySet()) {
			Object key = entry.getKey(); // 标题
			xssf_w_cell = xssf_w_row.createCell((short) i);
			HSSFDataFormat head_format = xssf_w_book.createDataFormat();
			head_cellStyle.setDataFormat(head_format.getFormat("@"));
			xssf_w_cell.setCellType(HSSFCell.CELL_TYPE_STRING);
			HSSFRichTextString xssfString = new HSSFRichTextString(key.toString());
			xssf_w_cell.setCellValue(xssfString);
			xssf_w_cell.setCellStyle(head_cellStyle);
			xssf_w_sheet.autoSizeColumn((short) i);
			titleRows++;
			i++;
		}

		HSSFCellStyle cellStyle_CN = xssf_w_book.createCellStyle();// 创建数据单元格样式(数据库数据样式)

		cellStyle_CN.setBorderBottom(HSSFCellStyle.BORDER_NONE);
		cellStyle_CN.setBorderLeft(HSSFCellStyle.BORDER_NONE);
		cellStyle_CN.setBorderRight(HSSFCellStyle.BORDER_NONE);
		cellStyle_CN.setBorderTop(HSSFCellStyle.BORDER_NONE);

		// 获取内容
		int j = 0; // 行数
		for (LinkedHashMap<String, String> responseMap : exportResponseList) {
			int z = 0; // 列数
			j++; // 数据从第二行开始
			xssf_w_row = xssf_w_sheet.createRow(j);
			xssf_w_row.setHeight((short) (1.5 * 256));
			for (Map.Entry entry : responseMap.entrySet()) {
				Object value = entry.getValue(); // 数据
				String content = (value == null ? "" : value.toString());
				content = content.replace("null", "");
				content = content.replace("\n", "");
				xssf_w_cell = xssf_w_row.createCell((short) z);
				HSSFRichTextString xssfString = new HSSFRichTextString(String.valueOf(content));
				xssf_w_cell.setCellStyle(cellStyle_CN);
				xssf_w_cell.setCellValue(xssfString);

				z++;
			}
		}
		try {
			OutputStream os = servletResponse.getOutputStream();
			xssf_w_book.write(os);
			os.flush();
			os.close();
			xssf_w_book.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	@LogDesc(commonDesc = "保存资源文件")
	public boolean saveResourceFile(MultipartFile file, String surveyId, String newFileName) {
		return this.saveSingleFile(file, "apk", newFileName);
	}


}
