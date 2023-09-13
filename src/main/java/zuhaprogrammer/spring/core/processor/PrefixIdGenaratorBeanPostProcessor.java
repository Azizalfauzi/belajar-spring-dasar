package zuhaprogrammer.spring.core.processor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import zuhaprogrammer.spring.core.aware.IdAware;

import java.util.UUID;

@Slf4j
public class PrefixIdGenaratorBeanPostProcessor implements BeanPostProcessor, Ordered {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        log.info("Prefix Id Generator processor for {}", beanName);
        if (bean instanceof IdAware) {
            log.info("Prefix set id generator processor for bean {}", beanName);
            IdAware idAware = (IdAware) bean;
            idAware.setId("Az-" + idAware.getId());
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return 2;
    }
}