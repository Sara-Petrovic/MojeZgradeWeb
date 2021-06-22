/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import rs.fon.silab.njt.mojezgradeweb.storage.HibernateUtility;

/**
 *
 * @author Sara
 */
@Configuration
//@ComponentScan(basePackages = {})
@EnableTransactionManagement
public class RootAppConfig {
//
//    @Autowired
//    private Environment environment;
//
//    @Bean
//    public DataSource dataSource() {
////        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//////        dataSource.setUrl("jdbc:mysql://localhost:3306/njt-2021");
//////        dataSource.setUsername("admin");
//////        dataSource.setPassword("admin");
//////        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
////
////        dataSource.setUrl(environment.getProperty("url"));
////        dataSource.setUsername(environment.getProperty("user"));
////        dataSource.setPassword(environment.getProperty("password"));
////        //dataSource.setDriverClassName(environment.getProperty("driver"));
////        return dataSource;
//
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/moje_zgrade");
//        dataSource.setUsername("root");
//        dataSource.setPassword("");
//
//        return dataSource;
//    }
//
//    @Bean
//    public JdbcTemplate jdbcTemplate(javax.sql.DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//
////    @Bean
////    public LocalSessionFactoryBean sessionFactory() {
////        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
////        sessionFactory.setDataSource(dataSource());
////        sessionFactory.setPackagesToScan(
////          {"com.baeldung.hibernate.bootstrap.model" });
////        sessionFactory.setHibernateProperties(hibernateProperties());
////
////        return sessionFactory;
////    }
//    
//    @Bean
//    public PlatformTransactionManager transactionManager(DataSource dataSource) {
////        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
////        dataSourceTransactionManager.setDataSource(dataSource);
////        return dataSourceTransactionManager;
//        HibernateTransactionManager transactionManager
//                = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(HibernateUtility.getSessionFactory().get);
//        return transactionManager;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//        emf.setDataSource(dataSource);
//        emf.setPackagesToScan(new String[]{"rs.fon.silab.njt.mojezgradeweb.domain"});
//        JpaVendorAdapter hibernate = new HibernateJpaVendorAdapter();
//        emf.setJpaVendorAdapter(hibernate);
//        return emf;
//    }
    
     @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("rs.fon.silab.njt.mojezgradeweb.domain");
//        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/moje_zgrade");
        dataSource.setUsername("root");
        dataSource.setPassword("");

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager
          = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

//    private final Properties hibernateProperties() {
//        Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty(
//          "hibernate.hbm2ddl.auto", "create-drop");
//        hibernateProperties.setProperty(
//          "hibernate.dialect", "org.hibernate.dialect.H2Dialect");
//
//        return hibernateProperties;
//    }
    
}
