package com.monetware.ringspider.commons.service.inter;

import com.monetware.ringspider.commons.util.JsonResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;


/**
 * @author
 * 文件相关Service
 */

public interface FileService {

	/**
	 * 单张图片上传
	 * @param file
	 * @param subFilePath
	 * @param newFileName
	 * @return
	 */
	 boolean saveSingleFile(MultipartFile file, String subFilePath, String newFileName);

	/**
	 * 保存单个文件
	 * @param file
	 * @return
	 */
	 boolean saveFile(File file);
	/**
	 * 多张图片上传
	 * @param files
	 * @param subFilePath
	 * @return
	 */
	 String[]  saveComplexFile(MultipartFile[] files, String subFilePath);

	/**
	 * 导出文本形式的文件
	 * @param titleMap
	 * @param exportResponseList
	 * @param exportFileName
	 * @param exportFileSeparator
	 * @return
	 */
	JsonResult exportTextFile(LinkedHashMap<String, Object> titleMap, List<LinkedHashMap<String, String>> exportResponseList,
							  String exportFileName, String exportFileSeparator);

	/**
	 * 导出2007的excel
	 * @param titleMap
	 * @param valueList
	 * @param exportFileName
	 * @return
	 */
	JsonResult exportExcel2007File(LinkedHashMap<String, Object> titleMap, List<LinkedHashMap<String, String>> valueList,
								   String exportFileName, String surveyCode);



	/**
	 * 保存资源文件
	 * @param file
	 * @param surveyId
	 * @param newFileName
	 * @return
	 */
	boolean saveResourceFile(MultipartFile file, String surveyId, String newFileName);

	/**
	 * 导出资源文件-2007Excel版
	 * @param servletResponse
	 * @param exportResponseList
	 * @param exportFileName
	 * @return
	 */
	boolean exportResponseForExcel2007(HttpServletResponse servletResponse, List<LinkedHashMap<String, String>> exportResponseList,
									   String exportFileName);


}
