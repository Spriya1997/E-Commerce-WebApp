package com.shop.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.shop.model.Supplier;

@Configuration
@ComponentScan({"com.shop.*"})
@EnableTransactionManagement
public class DatabaseConfiguration {

	@Autowired
	 @Bean(name ="dataSource")
	public DataSource dataSource() {

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:tcp://localhost/~/test");
        ds.setUsername("sa");
        ds.setPassword("");
        return ds;
    }
	
	private Properties getHibernateProperties() {
        Properties prop = new Properties();
        prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        prop.put("hibernate.hbm2ddl.auto", "update");
        return prop;
    }
	
	@Autowired
    @Bean(name="sessionFactory")
	 public SessionFactory sessionFactory(DataSource dataSource) {
	        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
	        builder.addProperties(getHibernateProperties());
	        builder.addAnnotatedClass(Supplier.class);
	        System.out.println("session object created");
	        return builder.buildSessionFactory();
	    }
	 @Bean
	 public HibernateTransactionManager txManager(SessionFactory sessionFactory) {
	        return new HibernateTransactionManager(sessionFactory);
	    }
	 
}
