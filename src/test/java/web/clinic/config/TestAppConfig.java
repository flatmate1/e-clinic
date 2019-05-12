package web.clinic.config;


import static web.clinic.config.DockerDatabase.mysql;


import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("file:/C:/Users/test/Desktop/db/db.test.properties")
@EnableTransactionManagement
@ComponentScan("web.clinic.dao")
@Profile("test")
public class TestAppConfig {
	
	@Autowired 
	private Environment env;
	
    @Bean
    public HibernateTransactionManager getTransactionManager() throws Exception {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
	
    @Bean
    public LocalSessionFactoryBean sessionFactory() throws Exception {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] {
            "web.clinic.model"
        });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }
    
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
        properties.put("javax.persistence.validation.mode", env.getRequiredProperty("javax.persistence.validation.mode"));
        
        return properties;
    }
	
    @Bean
    public DataSource dataSource() throws Exception {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(mysql.getJdbcUrl());
        dataSource.setUsername(mysql.getUsername());
        dataSource.setPassword(mysql.getPassword());
        dataSource.setDriverClassName(mysql.getDriverClassName());
    	return dataSource;
    }
}
    