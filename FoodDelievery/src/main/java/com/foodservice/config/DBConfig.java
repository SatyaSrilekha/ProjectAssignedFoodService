package com.foodservice.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.foodservice.entity.Category;
import com.foodservice.entity.Item;
import com.foodservice.entity.Orders;
import com.foodservice.entity.Payments;
import com.foodservice.entity.Register;
import com.foodservice.entity.Supplier;
import com.foodservice.entity.UserDetail;


@Configuration
@EnableTransactionManagement
@ComponentScan("com.foodservice")
public class DBConfig 
{
	//DataSource bean creation
	@Bean(name="dataSource")
	public DataSource getMySQLDataSource()
	{
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/foodservice");
		dataSource.setUsername("root");
		dataSource.setPassword("JunnuBannu@22");
		System.out.println("========= Data Source Bean Created ============");
		return dataSource;
	}
	
	//SessionFactory bean
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory() {
		Properties hibernateProp=new Properties();
		hibernateProp.put("hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		
		LocalSessionFactoryBuilder factoryBuilder=new LocalSessionFactoryBuilder(getMySQLDataSource());
		factoryBuilder.addProperties(hibernateProp);
		
		factoryBuilder.addAnnotatedClass(UserDetail.class);
		factoryBuilder.addAnnotatedClass(Payments.class);		
		factoryBuilder.addAnnotatedClass(Orders.class);
		factoryBuilder.addAnnotatedClass(Register.class);
		factoryBuilder.addAnnotatedClass(Item.class);
		factoryBuilder.addAnnotatedClass(Supplier.class);
		factoryBuilder.addAnnotatedClass(Category.class);
		
		
		SessionFactory sessionFactory=factoryBuilder.buildSessionFactory();
		System.out.println("========= Session Factory Bean Created ============");
		return sessionFactory;
	}
	
	//Hibernate Transaction
	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransaction(SessionFactory sessionFactory) {
		System.out.println("========= Hibernate Transaction Bean Created ============");
		return new HibernateTransactionManager(sessionFactory);
	}
}