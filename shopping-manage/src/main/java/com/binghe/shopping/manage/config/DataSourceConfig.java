package com.binghe.shopping.manage.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;
import com.binghe.shopping.manage.common.bean.properties.DataSourceProperties;

/**
 * 配置数据源
 * @author dongsw
 *
 */
@Configuration
@MapperScan(basePackages = "com.binghe.shopping.manage.dao", sqlSessionTemplateRef  = "sqlSessionTemplate")// 扫描dao接口所在的包
public class DataSourceConfig {
	
	@Autowired
	private DataSourceProperties dataSourceProperties;
	
    @Bean(name="dataSource")
    public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
		dataSource.setUrl(dataSourceProperties.getUrl());
		dataSource.setUsername(dataSourceProperties.getUsername());
		dataSource.setPassword(dataSourceProperties.getPassword());
		return dataSource;
    }
    
    @Bean(name="sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
	    sessionFactory.setDataSource(dataSource);
	    //配置实体类默认路径
	    sessionFactory.setTypeAliasesPackage("com.binghe.shopping.manage.pojo");// 实体对应包路径
	    sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
				.getResources("classpath:mapper/*.xml"));
	    // 开启驼峰命名转换
	    sessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
	    return sessionFactory.getObject();
	}
	
	@Bean(name="transactionManager")
    public DataSourceTransactionManager txManager(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
	
	@Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(@Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
