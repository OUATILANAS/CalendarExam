package org.springframework.security.config.annotation.method.configuration;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.security.access.annotation.Jsr250MethodSecurityMetadataSource;

public final class CalendarApplicationTestsContextInitializer {
  public static void registerJsr250MetadataSourceConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.security.config.annotation.method.configuration.Jsr250MetadataSourceConfiguration", Jsr250MetadataSourceConfiguration.class)
        .instanceSupplier(Jsr250MetadataSourceConfiguration::new).customize((bd) -> bd.setRole(2)).register(beanFactory);
  }

  public static void registerJsr250MetadataSourceConfiguration_jsr250MethodSecurityMetadataSource(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("jsr250MethodSecurityMetadataSource", Jsr250MethodSecurityMetadataSource.class).withFactoryMethod(Jsr250MetadataSourceConfiguration.class, "jsr250MethodSecurityMetadataSource")
        .instanceSupplier(() -> beanFactory.getBean(Jsr250MetadataSourceConfiguration.class).jsr250MethodSecurityMetadataSource()).customize((bd) -> bd.setRole(2)).register(beanFactory);
  }
}
