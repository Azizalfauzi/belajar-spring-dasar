package zuhaprogrammer.spring.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import zuhaprogrammer.spring.core.data.Foo;

@Slf4j
@Configuration
public class ScopeConfiguration {
    @Bean
    @Scope("prototype")
    public Foo foo() {
        log.info("Create new Foo");
        return new Foo();
    }
}
