package com.example.demo.controllers;

import com.example.demo.services.CalendarService;
import com.example.demo.services.EnseignantService;
import com.example.demo.services.EtudiantService;
import com.example.demo.services.ExamService;
import com.example.demo.services.FiliereService;
import com.example.demo.services.ModuleService;
import com.example.demo.services.PasserExamService;
import com.example.demo.services.PersonneService;
import com.example.demo.services.ResponsableService;
import com.example.demo.services.RoleService;
import com.example.demo.services.SalleService;
import com.example.demo.services.SemesterService;
import com.example.demo.services.SurveillantService;
import com.example.demo.services.TypeSalleService;
import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class CalendarApplicationTestsContextInitializer {
  public static void registerCalendarController(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("calendarController", CalendarController.class)
        .instanceSupplier((instanceContext) -> {
          CalendarController bean = new CalendarController();
          instanceContext.field("calendarService", CalendarService.class)
              .invoke(beanFactory, (attributes) -> bean.calendarService = attributes.get(0));
                  return bean;
                }).register(beanFactory);
          }

          public static void registerEnseignantController(DefaultListableBeanFactory beanFactory) {
            BeanDefinitionRegistrar.of("enseignantController", EnseignantController.class)
                .instanceSupplier((instanceContext) -> {
                  EnseignantController bean = new EnseignantController();
                  instanceContext.field("enseignantService", EnseignantService.class)
                      .invoke(beanFactory, (attributes) -> bean.enseignantService = attributes.get(0));
                          return bean;
                        }).register(beanFactory);
                  }

                  public static void registerEtudiantController(
                      DefaultListableBeanFactory beanFactory) {
                    BeanDefinitionRegistrar.of("etudiantController", EtudiantController.class)
                        .instanceSupplier((instanceContext) -> {
                          EtudiantController bean = new EtudiantController();
                          instanceContext.field("etudiantService", EtudiantService.class)
                              .invoke(beanFactory, (attributes) -> bean.etudiantService = attributes.get(0));
                                  return bean;
                                }).register(beanFactory);
                          }

                          public static void registerExamController(
                              DefaultListableBeanFactory beanFactory) {
                            BeanDefinitionRegistrar.of("examController", ExamController.class)
                                .instanceSupplier((instanceContext) -> {
                                  ExamController bean = new ExamController();
                                  instanceContext.field("examService", ExamService.class)
                                      .invoke(beanFactory, (attributes) -> bean.examService = attributes.get(0));
                                          return bean;
                                        }).register(beanFactory);
                                  }

                                  public static void registerFiliereController(
                                      DefaultListableBeanFactory beanFactory) {
                                    BeanDefinitionRegistrar.of("filiereController", FiliereController.class)
                                        .instanceSupplier((instanceContext) -> {
                                          FiliereController bean = new FiliereController();
                                          instanceContext.field("filiereService", FiliereService.class)
                                              .invoke(beanFactory, (attributes) -> bean.filiereService = attributes.get(0));
                                                  return bean;
                                                }).register(beanFactory);
                                          }

                                          public static void registerModuleController(
                                              DefaultListableBeanFactory beanFactory) {
                                            BeanDefinitionRegistrar.of("moduleController", ModuleController.class)
                                                .instanceSupplier((instanceContext) -> {
                                                  ModuleController bean = new ModuleController();
                                                  instanceContext.field("moduleService", ModuleService.class)
                                                      .invoke(beanFactory, (attributes) -> bean.moduleService = attributes.get(0));
                                                          return bean;
                                                        }).register(beanFactory);
                                                  }

                                                  public static void registerPasserExamController(
                                                      DefaultListableBeanFactory beanFactory) {
                                                    BeanDefinitionRegistrar.of("passerExamController", PasserExamController.class)
                                                        .instanceSupplier((instanceContext) -> {
                                                          PasserExamController bean = new PasserExamController();
                                                          instanceContext.field("passerExamService", PasserExamService.class)
                                                              .invoke(beanFactory, (attributes) -> bean.passerExamService = attributes.get(0));
                                                                  return bean;
                                                                }).register(beanFactory);
                                                          }

                                                          public static void registerPersonneController(
                                                              DefaultListableBeanFactory beanFactory) {
                                                            BeanDefinitionRegistrar.of("personneController", PersonneController.class)
                                                                .instanceSupplier((instanceContext) -> {
                                                                  PersonneController bean = new PersonneController();
                                                                  instanceContext.field("userService", PersonneService.class)
                                                                      .invoke(beanFactory, (attributes) -> {
                                                                        Field userServiceField = ReflectionUtils.findField(PersonneController.class, "userService", PersonneService.class);
                                                                        ReflectionUtils.makeAccessible(userServiceField);
                                                                        ReflectionUtils.setField(userServiceField, bean, attributes.get(0));
                                                                      });
                                                                          return bean;
                                                                        }).register(beanFactory);
                                                                  }

                                                                  public static void registerResponsableController(
                                                                      DefaultListableBeanFactory beanFactory) {
                                                                    BeanDefinitionRegistrar.of("responsableController", ResponsableController.class)
                                                                        .instanceSupplier((instanceContext) -> {
                                                                          ResponsableController bean = new ResponsableController();
                                                                          instanceContext.field("responsableService", ResponsableService.class)
                                                                              .invoke(beanFactory, (attributes) -> bean.responsableService = attributes.get(0));
                                                                                  return bean;
                                                                                }).register(beanFactory);
                                                                          }

                                                                          public static void registerRoleController(
                                                                              DefaultListableBeanFactory beanFactory) {
                                                                            BeanDefinitionRegistrar.of("roleController", RoleController.class)
                                                                                .instanceSupplier((instanceContext) -> {
                                                                                  RoleController bean = new RoleController();
                                                                                  instanceContext.field("roleService", RoleService.class)
                                                                                      .invoke(beanFactory, (attributes) -> {
                                                                                        Field roleServiceField = ReflectionUtils.findField(RoleController.class, "roleService", RoleService.class);
                                                                                        ReflectionUtils.makeAccessible(roleServiceField);
                                                                                        ReflectionUtils.setField(roleServiceField, bean, attributes.get(0));
                                                                                      });
                                                                                          return bean;
                                                                                        }).register(beanFactory);
                                                                                  }

                                                                                  public static void registerSalleController(
                                                                                      DefaultListableBeanFactory beanFactory) {
                                                                                    BeanDefinitionRegistrar.of("salleController", SalleController.class)
                                                                                        .instanceSupplier((instanceContext) -> {
                                                                                          SalleController bean = new SalleController();
                                                                                          instanceContext.field("salleService", SalleService.class)
                                                                                              .invoke(beanFactory, (attributes) -> bean.salleService = attributes.get(0));
                                                                                                  return bean;
                                                                                                }).register(beanFactory);
                                                                                          }

                                                                                          public static void registerSemestreController(
                                                                                              DefaultListableBeanFactory beanFactory) {
                                                                                            BeanDefinitionRegistrar.of("semestreController", SemestreController.class)
                                                                                                .instanceSupplier((instanceContext) -> {
                                                                                                  SemestreController bean = new SemestreController();
                                                                                                  instanceContext.field("semesterService", SemesterService.class)
                                                                                                      .invoke(beanFactory, (attributes) -> bean.semesterService = attributes.get(0));
                                                                                                          return bean;
                                                                                                        }).register(beanFactory);
                                                                                                  }

                                                                                                  public static void registerSurveillantController(
                                                                                                      DefaultListableBeanFactory beanFactory) {
                                                                                                    BeanDefinitionRegistrar.of("surveillantController", SurveillantController.class)
                                                                                                        .instanceSupplier((instanceContext) -> {
                                                                                                          SurveillantController bean = new SurveillantController();
                                                                                                          instanceContext.field("surveillantService", SurveillantService.class)
                                                                                                              .invoke(beanFactory, (attributes) -> bean.surveillantService = attributes.get(0));
                                                                                                                  return bean;
                                                                                                                }).register(beanFactory);
                                                                                                          }

                                                                                                          public static void registerTypeSalleController(
                                                                                                              DefaultListableBeanFactory beanFactory) {
                                                                                                            BeanDefinitionRegistrar.of("typeSalleController", TypeSalleController.class)
                                                                                                                .instanceSupplier((instanceContext) -> {
                                                                                                                  TypeSalleController bean = new TypeSalleController();
                                                                                                                  instanceContext.field("typeSalleService", TypeSalleService.class)
                                                                                                                      .invoke(beanFactory, (attributes) -> bean.typeSalleService = attributes.get(0));
                                                                                                                          return bean;
                                                                                                                        }).register(beanFactory);
                                                                                                                  }
                                                                                                                }
