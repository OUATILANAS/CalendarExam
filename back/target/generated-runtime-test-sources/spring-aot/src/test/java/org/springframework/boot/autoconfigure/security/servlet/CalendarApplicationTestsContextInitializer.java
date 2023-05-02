package org.springframework.boot.autoconfigure.security.servlet;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.filter.ErrorPageSecurityFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.core.ResolvableType;

public final class CalendarApplicationTestsContextInitializer {
  public static void registerErrorPageSecurityFilterConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.security.servlet.ErrorPageSecurityFilterConfiguration", ErrorPageSecurityFilterConfiguration.class)
        .instanceSupplier(ErrorPageSecurityFilterConfiguration::new).register(beanFactory);
  }

  public static void registerErrorPageSecurityFilterConfiguration_errorPageSecurityInterceptor(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("errorPageSecurityInterceptor", ResolvableType.forClassWithGenerics(FilterRegistrationBean.class, ErrorPageSecurityFilter.class)).withFactoryMethod(ErrorPageSecurityFilterConfiguration.class, "errorPageSecurityInterceptor", ApplicationContext.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(ErrorPageSecurityFilterConfiguration.class).errorPageSecurityInterceptor(attributes.get(0)))).register(beanFactory);
  }
}
