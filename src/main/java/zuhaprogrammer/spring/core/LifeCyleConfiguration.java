package zuhaprogrammer.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zuhaprogrammer.spring.core.data.Connection;

@Configuration
public class LifeCyleConfiguration {
    @Bean
    public Connection connection() {
        return new Connection();
    }
}
