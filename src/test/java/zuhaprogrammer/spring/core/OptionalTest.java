package zuhaprogrammer.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zuhaprogrammer.spring.core.data.Foo;
import zuhaprogrammer.spring.core.data.FooBar;

public class OptionalTest {
    private ConfigurableApplicationContext configurableApplicationContext;

    @BeforeEach
    void setUp() {
        configurableApplicationContext = new AnnotationConfigApplicationContext(OptionalConfiguration.class);
        configurableApplicationContext.registerShutdownHook();
    }

    @Test
    void testOptional() {
        Foo foo = configurableApplicationContext.getBean(Foo.class);
        FooBar fooBar = configurableApplicationContext.getBean(FooBar.class);

        Assertions.assertNull(fooBar.getBar());
        Assertions.assertSame(foo, fooBar.getFoo());

    }
}
