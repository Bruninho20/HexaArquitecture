package br.com.vwco.onedigitalplatform.nomedoservico.common.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

/**
 * Classe H2Configuration
 * 
 * @author <a href="icaro.figueiredo@atos.net">Icaro Caetano</a>
 *
 */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "h2EntityManagerFactory",
//        transactionManagerRef = "h2TransactionManager"//,
//        basePackages = { "br.com.vwco.onedigitalplatform.nomedoservico.infrastructure.adapter" }
//)
public class H2Configuration {
    @Bean(name = "h2DataSource")
    @ConfigurationProperties(prefix = "spring.h2.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "h2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    h2EntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("h2DataSource") DataSource dataSource) {
        Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");
        return builder
                .dataSource(dataSource)
                .packages("br.com.vwco.onedigitalplatform.conectividade.domain.model")
                .persistenceUnit("h2PU")
                .properties(properties)
                .build();
    }

    @Bean(name = "h2TransactionManager")
    public PlatformTransactionManager h2TransactionManager(@Qualifier("h2EntityManagerFactory") EntityManagerFactory h2EntityManagerFactory) {
        return new JpaTransactionManager(h2EntityManagerFactory);
    }
}
