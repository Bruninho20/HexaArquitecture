package br.com.fiap.products.cliente.common.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;

/**
 * Classe PostgreSQLConfiguration
 * 
 * @author Bruno Henrique Ferraz da Silva
 *
 */
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        entityManagerFactoryRef = "postgreSQLEntityManagerFactory",
//        transactionManagerRef = "postgreSQLTransactionManager"//,
//        //basePackages = { "br.com.vwco.onedigitalplatform.nomedoservico.infrastructure.adapter" }
//)
public class PostgreSQLConfiguration {

	@Primary
    @Bean(name = "postgreSQLDataSource")
    @ConfigurationProperties(prefix = "spring.postgresql.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "postgreSQLEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    postgreSQLEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("postgreSQLDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("br.com.vwco.onedigitalplatform.conectividade.domain.model")
                .persistenceUnit("postgreSQLPU")
                .build();
    }

    @Primary
    @Bean(name = "postgreSQLTransactionManager")
    public PlatformTransactionManager postgreSQLTransactionManager(@Qualifier("postgreSQLEntityManagerFactory") EntityManagerFactory postgreSQLEntityManagerFactory) {
        return new JpaTransactionManager(postgreSQLEntityManagerFactory);
    }
}
