package ExamProjectNC.server.config;

import javax.sql.DataSource;

import ExamProjectNC.server.dao.*;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("ExamProjectNC")
@EnableTransactionManagement
public class JPAConfig{
    @Bean
    public JpaTransactionManager jpaTransMan(){
        JpaTransactionManager jtManager = new JpaTransactionManager(
                getEntityManagerFactoryBean().getObject());
        return jtManager;
    }
    @Bean
    public LocalContainerEntityManagerFactoryBean getEntityManagerFactoryBean() {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(getDataSource());
        lcemfb.setPersistenceUnitName("ProjectPersistenceUnit");
        LoadTimeWeaver loadTimeWeaver = new InstrumentationLoadTimeWeaver();
        lcemfb.setLoadTimeWeaver(loadTimeWeaver);
        return lcemfb;
    }
    @Bean
    public DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/examprojectdb");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty123");
        return dataSource;
    }

  /*  @Bean
    public UserDAO userDAO(){
        return new UserDAO();
    }
    */
    @Bean
    public ExamDAO examDAO(){
        return new ExamDAO();
    }
    @Bean
    public ExaminedDAO examinedDAO(){
        return new ExaminedDAO();
    }
    @Bean
    public GroupDAO groupDAO(){
        return new GroupDAO();
    }
}