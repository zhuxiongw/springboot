package com.vivebest.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
/**
 * mybatis的配置类
 * 向spring容器中注入SqlSessionFactory、SqlSessionTemplate
 * @author clear
 *
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.vivebest.mapper")
public class MyBatisConfig implements TransactionManagementConfigurer {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private Environment env;

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean() {
		try {
			SqlSessionFactoryBean session = new SqlSessionFactoryBean();
			session.setDataSource(dataSource);
			session.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));
			session.setMapperLocations(
					new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapperLocations")));

			return session.getObject();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Bean(name = "sqlSessionTemplate")
	public SqlSessionTemplate openSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
