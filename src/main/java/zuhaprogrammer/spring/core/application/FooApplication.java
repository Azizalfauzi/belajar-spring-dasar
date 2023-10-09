package zuhaprogrammer.spring.core.application;

import lombok.val;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import zuhaprogrammer.spring.core.data.Bar;
import zuhaprogrammer.spring.core.data.Foo;

@SpringBootApplication
public class FooApplication {
    @Bean
    public Foo foo() {
        return new Foo();
    }

//    public static void main(String[] args) {
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(FooApplication.class, args);
//        Foo foo = applicationContext.getBean(Foo.class);
//        System.out.println(foo);
//    }

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(FooApplication.class);

        application.setBannerMode(Banner.Mode.CONSOLE);

        ConfigurableApplicationContext applicationContext = application.run(args);

        applicationContext.getBean(Foo.class);


    }
}
