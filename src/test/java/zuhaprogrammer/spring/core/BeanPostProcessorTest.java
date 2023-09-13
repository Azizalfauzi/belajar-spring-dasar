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

public class BeanPostProcessorTest {
    @Configuration
    @Import({
            Car.class,
            IdGenaratorBeanPostProcessor.class
    })
    public static class TestConfiguration {

    }

    private ConfigurableApplicationContext configurableApplicationContext;

    @BeforeEach
    void setup() {
        configurableApplicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        configurableApplicationContext.registerShutdownHook();
    }

    @Test
    void testCar() {
        Car car = configurableApplicationContext.getBean(Car.class);

        System.out.println(car.getId());
        Assertions.assertNotNull(car.getId());
    }
}
