package zuhaprogrammer.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"zuhaprogrammer.spring.core.service", "zuhaprogrammer.spring.core.repository", "zuhaprogrammer.spring.core.configuration"})
public class ComponentConfiguration {
}
