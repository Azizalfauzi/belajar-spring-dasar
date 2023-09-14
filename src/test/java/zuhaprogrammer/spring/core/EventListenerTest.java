package zuhaprogrammer.spring.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import zuhaprogrammer.spring.core.listener.LoginAgainSuccessListener;
import zuhaprogrammer.spring.core.listener.LoginSuccessListener;
import zuhaprogrammer.spring.core.service.UserService;

public class EventListenerTest {

    @Configuration
    @Import({
            UserService.class,
            LoginSuccessListener.class,
            LoginAgainSuccessListener.class
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
    void testEvent() {
        UserService userService = configurableApplicationContext.getBean(UserService.class);
        userService.login("aziz", "aziz");
        userService.login("Aziz", "hello");
        userService.login("Aziz", "Salah");
    }
}
