package zuhaprogrammer.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import zuhaprogrammer.spring.core.data.Foo;

public class BeNameConfiguration {
    @Primary
    @Bean(name = "fooFirst")
    public Foo foo1() {
        return new Foo();
    }

    @Bean(name = "fooSecond")
    public Foo foo2() {
        return new Foo();
    }
}
