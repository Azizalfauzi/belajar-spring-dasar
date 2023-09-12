package zuhaprogrammer.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zuhaprogrammer.spring.core.repository.ProductRepository;
import zuhaprogrammer.spring.core.service.ProductService;

public class ComponentTest {
    private ConfigurableApplicationContext configurableApplicationContext;

    @BeforeEach
    void setUp() {
        configurableApplicationContext = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
        configurableApplicationContext.registerShutdownHook();
    }

    @Test
    void testComponent() {
        ProductService productService = configurableApplicationContext.getBean(ProductService.class);
        ProductService productService1 = configurableApplicationContext.getBean("productService", ProductService.class);
        Assertions.assertSame(productService, productService1);
    }

    @Test
    void testConstructorDependencyInjection() {
        ProductService productService = configurableApplicationContext.getBean(ProductService.class);
        ProductRepository productRepository = configurableApplicationContext.getBean(ProductRepository.class);

        Assertions.assertSame(productRepository, productService.getProductRepository());
    }
}
