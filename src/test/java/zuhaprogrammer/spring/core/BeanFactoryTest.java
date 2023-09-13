package zuhaprogrammer.spring.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zuhaprogrammer.spring.core.data.Foo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BeanFactoryTest {

    private ConfigurableApplicationContext configurableApplicationContext;

    @BeforeEach
    void setUp() {
        configurableApplicationContext = new AnnotationConfigApplicationContext(ScanConfiguration.class);
        configurableApplicationContext.registerShutdownHook();
    }

    @Test
    void factoryBeanTest() {
        ObjectProvider<Foo> fooObjectProvider = configurableApplicationContext.getBeanProvider(Foo.class);
        List<Foo> fooList = fooObjectProvider.stream().toList();
        System.out.println(fooList);

        Map<String, Foo> beans = configurableApplicationContext.getBeansOfType(Foo.class);
        System.out.println(beans);
    }
}
