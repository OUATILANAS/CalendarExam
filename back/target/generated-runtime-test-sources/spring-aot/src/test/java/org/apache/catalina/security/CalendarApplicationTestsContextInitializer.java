package org.apache.catalina.security;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class CalendarApplicationTestsContextInitializer {
  public static void registerSecurityConfig(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.apache.catalina.security.SecurityConfig", SecurityConfig.class)
        .instanceSupplier(SecurityConfig::new).register(beanFactory);
  }
}
