package zuhaprogrammer.spring.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import zuhaprogrammer.spring.core.service.MerchantServiceImpl;

@Configuration
@Import(MerchantServiceImpl.class)
public class InheritanceConfiguration {
}
