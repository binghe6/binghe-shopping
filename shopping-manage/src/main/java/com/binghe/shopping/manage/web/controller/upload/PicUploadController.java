package com.binghe.shopping.manage.web.controller.upload;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.binghe.shopping.common.bean.resp.PicUploadResp;
import com.binghe.shopping.common.util.DateUtil;
import com.binghe.shopping.manage.common.bean.properties.UploadProperties;

/**
 * 图片上传
 */
@RestController
@Slf4j
@RequestMapping("/pic")
public class PicUploadController {

	@Autowired
	private UploadProperties uploadProperties;
	
	// 允许上传的格式
	private static final String[] IMAGE_TYPE = new String[] { ".bmp", ".jpg", ".jpeg", ".gif", ".png" };

	/**
	 * 图片上传（PS:上传图片的组件需要返回的格式为text/plain）
	 * @param uploadFile
	 * @return
	 * @throws Exception
	 */
	@PostMapping(value = "/upload", produces=MediaType.TEXT_PLAIN_VALUE)
	public String upload(@RequestParam("uploadFile") MultipartFile uploadFile) throws Exception {
		// 校验图片格式
		boolean isLegal = false;
		for (String type : IMAGE_TYPE) {
			if (StringUtils.endsWithIgnoreCase(uploadFile.getOriginalFilename(), type)) {
				isLegal = true;
				break;
			}
		}

		// 封装Result对象，并且将文件的byte数组放置到result对象中
		PicUploadResp fileUploadResult = PicUploadResp.of();

		if (!isLegal) {
			// 非图片后缀，状态不合法
			log.info("file suffix not pic, filename:{}", uploadFile.getOriginalFilename());
			fileUploadResult.setError(1);
			return JSON.toJSONString(fileUploadResult);
		}

		// 文件新路径
		String filePath = getFilePath(uploadFile.getOriginalFilename());

		// 生成图片的绝对引用地址
		String picUrl = StringUtils.replace(StringUtils.substringAfter(filePath, uploadProperties.getRepositoryPath()), "\\", "/");
		fileUploadResult.setUrl(uploadProperties.getImageBaseUrl() + picUrl);

		File newFile = new File(filePath);

		// 写文件到磁盘
		uploadFile.transferTo(newFile);

		// 校验图片是否合法
		isLegal = false;
		try {
			BufferedImage image = ImageIO.read(newFile);
			if (image != null) {
				fileUploadResult.setWidth(image.getWidth() + "");
				fileUploadResult.setHeight(image.getHeight() + "");
				isLegal = true;
			}
		} catch (IOException e) {
			log.error("read uploadPic error, filename:{}", uploadFile.getOriginalFilename(), e);
		}

		// 状态
		fileUploadResult.setError(isLegal ? 0 : 1);

		if (!isLegal) {
			log.info("file is not pic, filename:{}", uploadFile.getOriginalFilename());
			// 不合法，将磁盘上的文件删除
			newFile.delete();
		}
		String result = JSON.toJSONString(fileUploadResult);
		log.info("upload pic handle complete, filename:{}, result:{}", uploadFile.getOriginalFilename(), result);
		return result;
	}

	/**
	 * 根据原文件名创建文件在本地的存储路径和文件名
	 * @param sourceFileName
	 * @return
	 */
	private String getFilePath(String sourceFileName) {
		String baseFolder = uploadProperties.getRepositoryPath() + File.separator + "images";
		Date now = new Date();
		// 生成的目录格式：yyyy/MM/dd
		String fileFolder = baseFolder + File.separator + DateUtil.formateDate(now, "yyyy") + File.separator + DateUtil.formateDate(now, "MM") + File.separator
				+ DateUtil.formateDate(now, "dd");
		File file = new File(fileFolder);
		if (!file.isDirectory()) {
			// 如果目录不存在，则创建目录
			file.mkdirs();
		}
		// 生成新的文件名
		String fileName = DateUtil.formateDate(now, "yyyyMMddhhmmssSSSS") + RandomUtils.nextInt(100, 9999) + "." + StringUtils.substringAfterLast(sourceFileName, ".");
		return fileFolder + File.separator + fileName;
	}
}
