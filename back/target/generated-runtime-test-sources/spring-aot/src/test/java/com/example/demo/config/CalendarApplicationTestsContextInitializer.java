package com.example.demo.config;

import com.example.demo.services.PersonneService;
import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.accept.ContentNegotiationStrategy;

public final class CalendarApplicationTestsContextInitializer {
  public static void registerWebSecurityConfig(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("webSecurityConfig", WebSecurityConfig.class)
        .instanceSupplier((instanceContext) -> {
          WebSecurityConfig bean = new WebSecurityConfig();
          instanceContext.method("setApplicationContext", ApplicationContext.class)
              .invoke(beanFactory, (attributes) -> bean.setApplicationContext(attributes.get(0)));
          instanceContext.method("setTrustResolver", AuthenticationTrustResolver.class)
              .resolve(beanFactory, false).ifResolved((attributes) -> bean.setTrustResolver(attributes.get(0)));
          instanceContext.method("setObjectPostProcessor", ObjectPostProcessor.class)
              .invoke(beanFactory, (attributes) -> bean.setObjectPostProcessor(attributes.get(0)));
          instanceContext.method("setAuthenticationConfiguration", AuthenticationConfiguration.class)
              .invoke(beanFactory, (attributes) -> bean.setAuthenticationConfiguration(attributes.get(0)));
          instanceContext.method("setContentNegotationStrategy", ContentNegotiationStrategy.class)
              .resolve(beanFactory, false).ifResolved((attributes) -> bean.setContentNegotationStrategy(attributes.get(0)));
          instanceContext.field("userService", PersonneService.class)
              .invoke(beanFactory, (attributes) -> {
                Field userServiceField = ReflectionUtils.findField(WebSecurityConfig.class, "userService", PersonneService.class);
                ReflectionUtils.makeAccessible(userServiceField);
                ReflectionUtils.setField(userServiceField, bean, attributes.get(0));
              });
                  instanceContext.field("bCryptPasswordEncoder", PasswordEncoder.class)
                      .invoke(beanFactory, (attributes) -> {
                        Field bCryptPasswordEncoderField = ReflectionUtils.findField(WebSecurityConfig.class, "bCryptPasswordEncoder", PasswordEncoder.class);
                        ReflectionUtils.makeAccessible(bCryptPasswordEncoderField);
                        ReflectionUtils.setField(bCryptPasswordEncoderField, bean, attributes.get(0));
                      });
                          return bean;
                        }).register(beanFactory);
                  }
                }
