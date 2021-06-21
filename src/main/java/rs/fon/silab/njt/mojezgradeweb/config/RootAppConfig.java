/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.fon.silab.njt.mojezgradeweb.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Sara
 */
@Configuration
//@ComponentScan(basePackages = {})
//@EnableTransactionManagement
public class RootAppConfig {

    @Autowired
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:mysql://localhost:3306/njt-2021");
//        dataSource.setUsername("admin");
//        dataSource.setPassword("admin");
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSource.setUrl(environment.getProperty("url"));
        dataSource.setUsername(environment.getProperty("user"));
        dataSource.setPassword(environment.getProperty("password"));
        //dataSource.setDriverClassName(environment.getProperty("driver"));
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(javax.sql.DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//        emf.setDataSource(dataSource);
//        emf.setPackagesToScan(new String[]{"rs.fon.silab.njt.mojezgradeweb.domain"});
//        JpaVendorAdapter hibernate = new HibernateJpaVendorAdapter();
//        emf.setJpaVendorAdapter(hibernate);
//        return emf;
    return null;
    }
}
