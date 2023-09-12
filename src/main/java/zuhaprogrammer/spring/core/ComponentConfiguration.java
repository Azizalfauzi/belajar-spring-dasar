package zuhaprogrammer.spring.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import zuhaprogrammer.spring.core.data.MultiFoo;

@Configuration
@ComponentScan(basePackages = {"zuhaprogrammer.spring.core.service", "zuhaprogrammer.spring.core.repository", "zuhaprogrammer.spring.core.configuration"})
@Import(MultiFoo.class)
public class ComponentConfiguration {
}
