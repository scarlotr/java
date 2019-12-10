package erth.lab._lab_boot.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@ComponentScan("erth.lab._lab_boot")
public class AppConfig implements WebMvcConfigurer {
}
