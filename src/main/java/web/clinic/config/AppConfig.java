package web.clinic.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@Configuration
@PropertySource( {"file:/C:/Users/test/Desktop/db/db.properties",
				"file:/C:/Users/test/Desktop/mail/mail.properties"})
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("web.clinic.dao"),
	    @ComponentScan("web.clinic.service"),
		@ComponentScan("web.clinic.mail")})
public class AppConfig {
	
	@Autowired 
	private Environment env;
	
    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
	
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
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
    public DataSource dataSource() {
    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
    	dataSource.setDriverClassName(env.getRequiredProperty("mysql.driver"));
    	dataSource.setUrl(env.getRequiredProperty("mysql.jdbcUrl"));
    	dataSource.setUsername(env.getRequiredProperty("mysql.username"));
    	dataSource.setPassword(env.getRequiredProperty("mysql.password"));
    	return dataSource;
    }
    
    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
    
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource
          = new ReloadableResourceBundleMessageSource();
         
        messageSource.setBasename("classpath:messages.properties");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }
    
  
    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(env.getRequiredProperty("mail.host"));
        mailSender.setPort(env.getRequiredProperty("mail.port", Integer.class));
         
        mailSender.setUsername(env.getRequiredProperty("mail.username"));
        mailSender.setPassword(env.getRequiredProperty("mail.password"));
         
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", env.getRequiredProperty("mail.protocol"));
        props.put("mail.smtp.auth", env.getRequiredProperty("mail.smtp.auth"));
        props.put("mail.smtp.starttls.enable", env.getRequiredProperty("mail.smtp.starttls.required"));
        props.put("mail.debug", env.getRequiredProperty("mail.smtp.debug"));
         
        return mailSender;
    }
}
