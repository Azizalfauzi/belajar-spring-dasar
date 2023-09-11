package zuhaprogrammer.spring.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import zuhaprogrammer.spring.core.configuration.BarConfiguration;
import zuhaprogrammer.spring.core.configuration.FooConfiguration;

@Configuration
@Import({
        FooConfiguration.class,
        BarConfiguration.class
})
public class MainConfiguration {

}
