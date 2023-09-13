package zuhaprogrammer.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import zuhaprogrammer.spring.core.data.Car;
import zuhaprogrammer.spring.core.processor.IdGenaratorBeanPostProcessor;
import zuhaprogrammer.spring.core.processor.PrefixIdGenaratorBeanPostProcessor;

public class OrderedTest {
    @Configuration
    @Import({
            Car.class,
            IdGenaratorBeanPostProcessor.class,
            PrefixIdGenaratorBeanPostProcessor.class
    })
    public static class TestConfiguration {

    }

    private ConfigurableApplicationContext configurableApplicationContext;

    @BeforeEach
    void setUp() {
        configurableApplicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        configurableApplicationContext.registerShutdownHook();
    }

    @Test
    void testOrder() {
        Car car = configurableApplicationContext.getBean(Car.class);

        Assertions.assertNotNull(car.getId());
        Assertions.assertTrue(car.getId().startsWith("Az-"));
    }
}
