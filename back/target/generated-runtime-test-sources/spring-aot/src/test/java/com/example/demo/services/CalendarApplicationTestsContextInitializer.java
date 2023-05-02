package com.example.demo.services;

import com.example.demo.config.WebSecurityConfig;
import com.example.demo.iservice.IPermissionService;
import com.example.demo.iservice.IRoleService;
import com.example.demo.repositories.CalendarRepository;
import com.example.demo.repositories.EnseignantRepository;
import com.example.demo.repositories.EtudiantRepository;
import com.example.demo.repositories.ExamRepository;
import com.example.demo.repositories.FiliereRepository;
import com.example.demo.repositories.ModuleRepository;
import com.example.demo.repositories.PasserExamRepository;
import com.example.demo.repositories.PermissionRepository;
import com.example.demo.repositories.PersonneRepository;
import com.example.demo.repositories.ResponsableRepository;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.SalleRepository;
import com.example.demo.repositories.SemesterRepository;
import com.example.demo.repositories.SurveillantRepository;
import com.example.demo.repositories.TypeSalleRepository;
import java.lang.reflect.Field;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.util.ReflectionUtils;

public final class CalendarApplicationTestsContextInitializer {
  public static void registerCalendarService(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("calendarService", CalendarService.class)
        .instanceSupplier((instanceContext) -> {
          CalendarService bean = new CalendarService();
          instanceContext.field("calendarRepository", CalendarRepository.class)
              .invoke(beanFactory, (attributes) -> {
                Field calendarRepositoryField = ReflectionUtils.findField(CalendarService.class, "calendarRepository", CalendarRepository.class);
                ReflectionUtils.makeAccessible(calendarRepositoryField);
                ReflectionUtils.setField(calendarRepositoryField, bean, attributes.get(0));
              });
                  return bean;
                }).register(beanFactory);
          }

          public static void registerEtudiantService(DefaultListableBeanFactory beanFactory) {
            BeanDefinitionRegistrar.of("etudiantService", EtudiantService.class)
                .instanceSupplier((instanceContext) -> {
                  EtudiantService bean = new EtudiantService();
                  instanceContext.field("etudiantRepository", EtudiantRepository.class)
                      .invoke(beanFactory, (attributes) -> {
                        Field etudiantRepositoryField = ReflectionUtils.findField(EtudiantService.class, "etudiantRepository", EtudiantRepository.class);
                        ReflectionUtils.makeAccessible(etudiantRepositoryField);
                        ReflectionUtils.setField(etudiantRepositoryField, bean, attributes.get(0));
                      });
                          return bean;
                        }).register(beanFactory);
                  }

                  public static void registerExamService(DefaultListableBeanFactory beanFactory) {
                    BeanDefinitionRegistrar.of("examService", ExamService.class)
                        .instanceSupplier((instanceContext) -> {
                          ExamService bean = new ExamService();
                          instanceContext.field("examRepository", ExamRepository.class)
                              .invoke(beanFactory, (attributes) -> {
                                Field examRepositoryField = ReflectionUtils.findField(ExamService.class, "examRepository", ExamRepository.class);
                                ReflectionUtils.makeAccessible(examRepositoryField);
                                ReflectionUtils.setField(examRepositoryField, bean, attributes.get(0));
                              });
                                  return bean;
                                }).register(beanFactory);
                          }

                          public static void registerModuleService(
                              DefaultListableBeanFactory beanFactory) {
                            BeanDefinitionRegistrar.of("moduleService", ModuleService.class)
                                .instanceSupplier((instanceContext) -> {
                                  ModuleService bean = new ModuleService();
                                  instanceContext.field("moduleRepository", ModuleRepository.class)
                                      .invoke(beanFactory, (attributes) -> {
                                        Field moduleRepositoryField = ReflectionUtils.findField(ModuleService.class, "moduleRepository", ModuleRepository.class);
                                        ReflectionUtils.makeAccessible(moduleRepositoryField);
                                        ReflectionUtils.setField(moduleRepositoryField, bean, attributes.get(0));
                                      });
                                          return bean;
                                        }).register(beanFactory);
                                  }

                                  public static void registerPasserExamService(
                                      DefaultListableBeanFactory beanFactory) {
                                    BeanDefinitionRegistrar.of("passerExamService", PasserExamService.class)
                                        .instanceSupplier((instanceContext) -> {
                                          PasserExamService bean = new PasserExamService();
                                          instanceContext.field("passerExamRepository", PasserExamRepository.class)
                                              .invoke(beanFactory, (attributes) -> {
                                                Field passerExamRepositoryField = ReflectionUtils.findField(PasserExamService.class, "passerExamRepository", PasserExamRepository.class);
                                                ReflectionUtils.makeAccessible(passerExamRepositoryField);
                                                ReflectionUtils.setField(passerExamRepositoryField, bean, attributes.get(0));
                                              });
                                                  return bean;
                                                }).register(beanFactory);
                                          }

                                          public static void registerPermissionService(
                                              DefaultListableBeanFactory beanFactory) {
                                            BeanDefinitionRegistrar.of("permissionService", PermissionService.class)
                                                .instanceSupplier((instanceContext) -> {
                                                  PermissionService bean = new PermissionService();
                                                  instanceContext.field("permissionDao", PermissionRepository.class)
                                                      .invoke(beanFactory, (attributes) -> {
                                                        Field permissionDaoField = ReflectionUtils.findField(PermissionService.class, "permissionDao", PermissionRepository.class);
                                                        ReflectionUtils.makeAccessible(permissionDaoField);
                                                        ReflectionUtils.setField(permissionDaoField, bean, attributes.get(0));
                                                      });
                                                          return bean;
                                                        }).register(beanFactory);
                                                  }

                                                  public static void registerPersonneService(
                                                      DefaultListableBeanFactory beanFactory) {
                                                    BeanDefinitionRegistrar.of("personneService", PersonneService.class)
                                                        .instanceSupplier((instanceContext) -> {
                                                          PersonneService bean = new PersonneService();
                                                          instanceContext.field("userDao", PersonneRepository.class)
                                                              .invoke(beanFactory, (attributes) -> {
                                                                Field userDaoField = ReflectionUtils.findField(PersonneService.class, "userDao", PersonneRepository.class);
                                                                ReflectionUtils.makeAccessible(userDaoField);
                                                                ReflectionUtils.setField(userDaoField, bean, attributes.get(0));
                                                              });
                                                                  instanceContext.field("roleService", IRoleService.class)
                                                                      .invoke(beanFactory, (attributes) -> {
                                                                        Field roleServiceField = ReflectionUtils.findField(PersonneService.class, "roleService", IRoleService.class);
                                                                        ReflectionUtils.makeAccessible(roleServiceField);
                                                                        ReflectionUtils.setField(roleServiceField, bean, attributes.get(0));
                                                                      });
                                                                          return bean;
                                                                        }).register(beanFactory);
                                                                  }

                                                                  public static void registerRoleService(
                                                                      DefaultListableBeanFactory beanFactory) {
                                                                    BeanDefinitionRegistrar.of("roleService", RoleService.class)
                                                                        .instanceSupplier((instanceContext) -> {
                                                                          RoleService bean = new RoleService();
                                                                          instanceContext.field("roleDao", RoleRepository.class)
                                                                              .invoke(beanFactory, (attributes) -> {
                                                                                Field roleDaoField = ReflectionUtils.findField(RoleService.class, "roleDao", RoleRepository.class);
                                                                                ReflectionUtils.makeAccessible(roleDaoField);
                                                                                ReflectionUtils.setField(roleDaoField, bean, attributes.get(0));
                                                                              });
                                                                                  instanceContext.field("permissionService", IPermissionService.class)
                                                                                      .invoke(beanFactory, (attributes) -> {
                                                                                        Field permissionServiceField = ReflectionUtils.findField(RoleService.class, "permissionService", IPermissionService.class);
                                                                                        ReflectionUtils.makeAccessible(permissionServiceField);
                                                                                        ReflectionUtils.setField(permissionServiceField, bean, attributes.get(0));
                                                                                      });
                                                                                          return bean;
                                                                                        }).register(beanFactory);
                                                                                  }

                                                                                  public static void registerWebSecurityConfig_enseignantService(
                                                                                      DefaultListableBeanFactory beanFactory) {
                                                                                    BeanDefinitionRegistrar.of("enseignantService", EnseignantService.class).withFactoryMethod(WebSecurityConfig.class, "enseignantService")
                                                                                        .instanceSupplier((instanceContext) -> {
                                                                                          EnseignantService bean = beanFactory.getBean(WebSecurityConfig.class).enseignantService();
                                                                                          instanceContext.field("enseignantRepository", EnseignantRepository.class)
                                                                                              .invoke(beanFactory, (attributes) -> {
                                                                                                Field enseignantRepositoryField = ReflectionUtils.findField(EnseignantService.class, "enseignantRepository", EnseignantRepository.class);
                                                                                                ReflectionUtils.makeAccessible(enseignantRepositoryField);
                                                                                                ReflectionUtils.setField(enseignantRepositoryField, bean, attributes.get(0));
                                                                                              });
                                                                                                  return bean;
                                                                                                }).register(beanFactory);
                                                                                          }

                                                                                          public static void registerWebSecurityConfig_filiereService(
                                                                                              DefaultListableBeanFactory beanFactory) {
                                                                                            BeanDefinitionRegistrar.of("filiereService", FiliereService.class).withFactoryMethod(WebSecurityConfig.class, "filiereService")
                                                                                                .instanceSupplier((instanceContext) -> {
                                                                                                  FiliereService bean = beanFactory.getBean(WebSecurityConfig.class).filiereService();
                                                                                                  instanceContext.field("filiereRepository", FiliereRepository.class)
                                                                                                      .invoke(beanFactory, (attributes) -> {
                                                                                                        Field filiereRepositoryField = ReflectionUtils.findField(FiliereService.class, "filiereRepository", FiliereRepository.class);
                                                                                                        ReflectionUtils.makeAccessible(filiereRepositoryField);
                                                                                                        ReflectionUtils.setField(filiereRepositoryField, bean, attributes.get(0));
                                                                                                      });
                                                                                                          return bean;
                                                                                                        }).register(beanFactory);
                                                                                                  }

                                                                                                  public static void registerWebSecurityConfig_responsableService(
                                                                                                      DefaultListableBeanFactory beanFactory) {
                                                                                                    BeanDefinitionRegistrar.of("responsableService", ResponsableService.class).withFactoryMethod(WebSecurityConfig.class, "responsableService")
                                                                                                        .instanceSupplier((instanceContext) -> {
                                                                                                          ResponsableService bean = beanFactory.getBean(WebSecurityConfig.class).responsableService();
                                                                                                          instanceContext.field("responsableRepository", ResponsableRepository.class)
                                                                                                              .invoke(beanFactory, (attributes) -> {
                                                                                                                Field responsableRepositoryField = ReflectionUtils.findField(ResponsableService.class, "responsableRepository", ResponsableRepository.class);
                                                                                                                ReflectionUtils.makeAccessible(responsableRepositoryField);
                                                                                                                ReflectionUtils.setField(responsableRepositoryField, bean, attributes.get(0));
                                                                                                              });
                                                                                                                  return bean;
                                                                                                                }).register(beanFactory);
                                                                                                          }

                                                                                                          public static void registerWebSecurityConfig_salleService(
                                                                                                              DefaultListableBeanFactory beanFactory) {
                                                                                                            BeanDefinitionRegistrar.of("salleService", SalleService.class).withFactoryMethod(WebSecurityConfig.class, "salleService")
                                                                                                                .instanceSupplier((instanceContext) -> {
                                                                                                                  SalleService bean = beanFactory.getBean(WebSecurityConfig.class).salleService();
                                                                                                                  instanceContext.field("salleRepository", SalleRepository.class)
                                                                                                                      .invoke(beanFactory, (attributes) -> {
                                                                                                                        Field salleRepositoryField = ReflectionUtils.findField(SalleService.class, "salleRepository", SalleRepository.class);
                                                                                                                        ReflectionUtils.makeAccessible(salleRepositoryField);
                                                                                                                        ReflectionUtils.setField(salleRepositoryField, bean, attributes.get(0));
                                                                                                                      });
                                                                                                                          return bean;
                                                                                                                        }).register(beanFactory);
                                                                                                                  }

                                                                                                                  public static void registerWebSecurityConfig_semesterService(
                                                                                                                      DefaultListableBeanFactory beanFactory) {
                                                                                                                    BeanDefinitionRegistrar.of("semesterService", SemesterService.class).withFactoryMethod(WebSecurityConfig.class, "semesterService")
                                                                                                                        .instanceSupplier((instanceContext) -> {
                                                                                                                          SemesterService bean = beanFactory.getBean(WebSecurityConfig.class).semesterService();
                                                                                                                          instanceContext.field("semesterRepository", SemesterRepository.class)
                                                                                                                              .invoke(beanFactory, (attributes) -> {
                                                                                                                                Field semesterRepositoryField = ReflectionUtils.findField(SemesterService.class, "semesterRepository", SemesterRepository.class);
                                                                                                                                ReflectionUtils.makeAccessible(semesterRepositoryField);
                                                                                                                                ReflectionUtils.setField(semesterRepositoryField, bean, attributes.get(0));
                                                                                                                              });
                                                                                                                                  return bean;
                                                                                                                                }).register(beanFactory);
                                                                                                                          }

                                                                                                                          public static void registerWebSecurityConfig_surveillantService(
                                                                                                                              DefaultListableBeanFactory beanFactory) {
                                                                                                                            BeanDefinitionRegistrar.of("surveillantService", SurveillantService.class).withFactoryMethod(WebSecurityConfig.class, "surveillantService")
                                                                                                                                .instanceSupplier((instanceContext) -> {
                                                                                                                                  SurveillantService bean = beanFactory.getBean(WebSecurityConfig.class).surveillantService();
                                                                                                                                  instanceContext.field("surveillantRepository", SurveillantRepository.class)
                                                                                                                                      .invoke(beanFactory, (attributes) -> {
                                                                                                                                        Field surveillantRepositoryField = ReflectionUtils.findField(SurveillantService.class, "surveillantRepository", SurveillantRepository.class);
                                                                                                                                        ReflectionUtils.makeAccessible(surveillantRepositoryField);
                                                                                                                                        ReflectionUtils.setField(surveillantRepositoryField, bean, attributes.get(0));
                                                                                                                                      });
                                                                                                                                          return bean;
                                                                                                                                        }).register(beanFactory);
                                                                                                                                  }

                                                                                                                                  public static void registerWebSecurityConfig_typeSalleService(
                                                                                                                                      DefaultListableBeanFactory beanFactory) {
                                                                                                                                    BeanDefinitionRegistrar.of("typeSalleService", TypeSalleService.class).withFactoryMethod(WebSecurityConfig.class, "typeSalleService")
                                                                                                                                        .instanceSupplier((instanceContext) -> {
                                                                                                                                          TypeSalleService bean = beanFactory.getBean(WebSecurityConfig.class).typeSalleService();
                                                                                                                                          instanceContext.field("typeSalleRepository", TypeSalleRepository.class)
                                                                                                                                              .invoke(beanFactory, (attributes) -> {
                                                                                                                                                Field typeSalleRepositoryField = ReflectionUtils.findField(TypeSalleService.class, "typeSalleRepository", TypeSalleRepository.class);
                                                                                                                                                ReflectionUtils.makeAccessible(typeSalleRepositoryField);
                                                                                                                                                ReflectionUtils.setField(typeSalleRepositoryField, bean, attributes.get(0));
                                                                                                                                              });
                                                                                                                                                  return bean;
                                                                                                                                                }).register(beanFactory);
                                                                                                                                          }
                                                                                                                                        }
