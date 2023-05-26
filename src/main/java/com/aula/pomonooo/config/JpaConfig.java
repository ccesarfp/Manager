package com.aula.pomonooo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import javax.sql.DataSource;

@Configuration
public class JpaConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource);
        entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManagerFactoryBean.setPackagesToScan("com.aula.pomonooo.JPA"); // Pacote onde estão as classes JPA
        entityManagerFactoryBean.getJpaPropertyMap().put("javax.persistence.provider", "org.hibernate.jpa.HibernatePersistenceProvider");
        entityManagerFactoryBean.getJpaPropertyMap().put("hibernate.hbm2ddl.auto", "create-drop");
        return entityManagerFactoryBean;
    }

}
