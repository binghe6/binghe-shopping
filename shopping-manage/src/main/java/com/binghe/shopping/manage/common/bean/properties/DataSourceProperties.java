package com.binghe.shopping.manage.common.bean.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 数据库连接的参数
 * @author dongsw
 *
 */
@Component
@ConfigurationProperties("db")
public class DataSourceProperties {
	
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	public String getDriverClassName() {
		return driverClassName;
	}
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
