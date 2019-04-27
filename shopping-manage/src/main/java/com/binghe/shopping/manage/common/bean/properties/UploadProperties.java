package com.binghe.shopping.manage.common.bean.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="upload")
public class UploadProperties {

	private String repositoryPath;
	private String imageBaseUrl;
	public String getRepositoryPath() {
		return repositoryPath;
	}
	public void setRepositoryPath(String repositoryPath) {
		this.repositoryPath = repositoryPath;
	}
	public String getImageBaseUrl() {
		return imageBaseUrl;
	}
	public void setImageBaseUrl(String imageBaseUrl) {
		this.imageBaseUrl = imageBaseUrl;
	}
	
	
}
