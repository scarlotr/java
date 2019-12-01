package erth.lab;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"erth.lab"})
public class TaskConfig {
    @Bean
    public SessionFactory sessionFactory(){
        SessionFactory factory = new org.hibernate.cfg.Configuration()
                                    .configure("/hibernate.cfg.xml")
                                    .buildSessionFactory();
        return factory;
    }
}
