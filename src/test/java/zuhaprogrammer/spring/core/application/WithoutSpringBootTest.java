package zuhaprogrammer.spring.core.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zuhaprogrammer.spring.core.application.FooApplication;
import zuhaprogrammer.spring.core.data.Foo;

public class WithoutSpringBootTest {
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(FooApplication.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void withoutSpringBootTest() {
        Foo foo = applicationContext.getBean(Foo.class);
    }

}
