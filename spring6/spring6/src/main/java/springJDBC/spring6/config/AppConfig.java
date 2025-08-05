package springJDBC.spring6.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import springJDBC.spring6.dao.PersonDAO;
import springJDBC.spring6.dao.PersonDAOImpl;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class AppConfig {

    @Value("${db.driverClassName}")
    private String driver;

    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public PersonDAO personDAO() {
        return new PersonDAOImpl(jdbcTemplate());
    }
}
