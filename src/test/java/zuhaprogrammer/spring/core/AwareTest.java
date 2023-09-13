package zuhaprogrammer.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import zuhaprogrammer.spring.core.service.AuthService;

public class AwareTest {
    @Configuration
    @Import({
            AuthService.class
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
    void testAware() {
        AuthService authService = configurableApplicationContext.getBean(AuthService.class);
        Assertions.assertEquals("zuhaprogrammer.spring.core.service.AuthService", authService.getBeanName());
        Assertions.assertNotNull(authService.getApplicationContext());
        Assertions.assertSame(configurableApplicationContext, authService.getApplicationContext());
    }
}
