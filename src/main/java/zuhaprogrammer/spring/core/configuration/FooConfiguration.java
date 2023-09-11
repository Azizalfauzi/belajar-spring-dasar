package zuhaprogrammer.spring.core.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zuhaprogrammer.spring.core.data.Foo;

@Configuration
public class FooConfiguration {
    @Bean
    public Foo foo() {
        return new Foo();
    }
}
