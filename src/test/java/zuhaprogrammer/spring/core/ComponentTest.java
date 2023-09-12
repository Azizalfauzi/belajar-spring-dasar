package zuhaprogrammer.spring.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import zuhaprogrammer.spring.core.data.Foo;
import zuhaprogrammer.spring.core.data.MultiFoo;
import zuhaprogrammer.spring.core.repository.CategoryRepository;
import zuhaprogrammer.spring.core.repository.CustomerRepository;
import zuhaprogrammer.spring.core.repository.ProductRepository;
import zuhaprogrammer.spring.core.service.CategoryService;
import zuhaprogrammer.spring.core.service.CustomerService;
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

    @Test
    void testSetterDependencyInjecttion() {
        CategoryService categoryService = configurableApplicationContext.getBean(CategoryService.class);
        CategoryRepository categoryRepository = configurableApplicationContext.getBean(CategoryRepository.class);

        Assertions.assertSame(categoryRepository, categoryService.getCategoryRepository());
    }

    @Test
    void testFieldDependecyInjection() {
        CustomerService customerService = configurableApplicationContext.getBean(CustomerService.class);
        CustomerRepository normalCustomerRepository = configurableApplicationContext.getBean("normalCustomerRepository", CustomerRepository.class);
        CustomerRepository premiumCustomerRepository = configurableApplicationContext.getBean("premiumCustomerRepository", CustomerRepository.class);
        Assertions.assertSame(normalCustomerRepository, customerService.getNormalCustomerRepository());
        Assertions.assertSame(premiumCustomerRepository, customerService.getPremiumCustomerRepository());
    }

    @Test
    void testObjectProvider() {
        MultiFoo multiFoo = configurableApplicationContext.getBean(MultiFoo.class);
        Assertions.assertEquals(3, multiFoo.getFoo().size());
    }
}
