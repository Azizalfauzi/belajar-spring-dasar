package zuhaprogrammer.spring.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zuhaprogrammer.spring.core.data.Bar;

@Configuration
public class BarConfiguration {
    @Bean
    public Bar bar() {
        return new Bar();
    }
}
