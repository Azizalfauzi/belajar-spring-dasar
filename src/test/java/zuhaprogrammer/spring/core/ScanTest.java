package zuhaprogrammer.spring.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zuhaprogrammer.spring.core.data.Bar;
import zuhaprogrammer.spring.core.data.Foo;

public class ScanTest {
    private ConfigurableApplicationContext configurableApplicationContext;

    @BeforeEach
    void setUp() {
        configurableApplicationContext = new AnnotationConfigApplicationContext(ScanConfiguration.class);
        configurableApplicationContext.registerShutdownHook();
    }

    @Test
    void testScan() {
        Foo foo = configurableApplicationContext.getBean(Foo.class);
        Bar bar = configurableApplicationContext.getBean(Bar.class);
    }

}
