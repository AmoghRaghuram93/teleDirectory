package com.thoughtclan.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@EnableJpaRepositories(basePackages = "com.thoughtclan.entites")
@EnableTransactionManagement
@ComponentScan(basePackages = "com.thoughtclan")
public class TeleConfiguration {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/directory2?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("19tfios94");
		return dataSource;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory(@Qualifier("dataSource") DataSource dataSource) {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);

		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setPackagesToScan("com.thoughtclan");
		factory.setDataSource(dataSource);
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	/**
	 * Returns an instance of Spring's JPA transaction manager. By default spring
	 * data looks for a transaction manager bean name "transactionManager"; but can
	 * be modified through an attribute of {@link EnableJpaRepositories} annotation.
	 * 
	 * @return
	 */
	@Bean
	public PlatformTransactionManager transactionManager(
			@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(entityManagerFactory);
		return txManager;
	}

}