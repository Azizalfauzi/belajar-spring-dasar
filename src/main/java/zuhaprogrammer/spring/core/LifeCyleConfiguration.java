package zuhaprogrammer.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zuhaprogrammer.spring.core.data.Connection;
import zuhaprogrammer.spring.core.data.Server;

@Configuration
public class LifeCyleConfiguration {
    @Bean
    public Connection connection() {
        return new Connection();
    }

    //    @Bean(initMethod = "start", destroyMethod = "stop")
    @Bean
    public Server server() {
        return new Server();
    }
}
