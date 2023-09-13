package zuhaprogrammer.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zuhaprogrammer.spring.core.service.MerchantService;
import zuhaprogrammer.spring.core.service.MerchantServiceImpl;

public class InheritanceTest {

    private ConfigurableApplicationContext configurableApplicationContext;

    @BeforeEach
    void setUp() {
        configurableApplicationContext = new AnnotationConfigApplicationContext(InheritanceConfiguration.class);
        configurableApplicationContext.registerShutdownHook();
    }

    @Test
    void testInheritance() {
        MerchantService merchantService = configurableApplicationContext.getBean(MerchantService.class);
        MerchantServiceImpl merchantServiceImpl = configurableApplicationContext.getBean(MerchantServiceImpl.class);

        Assertions.assertSame(merchantService, merchantServiceImpl);

    }
}
