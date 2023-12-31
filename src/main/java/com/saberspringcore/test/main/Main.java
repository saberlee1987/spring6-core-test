package com.saberspringcore.test.main;

import com.saberspringcore.test.config.AppConfig;
import com.saberspringcore.test.model.MessageDigester;
import com.saberspringcore.test.model.Person;
import com.saberspringcore.test.model.Singer;
import com.saberspringcore.test.services.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jndi.TypeMismatchNamingException;
import org.springframework.util.StopWatch;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context=  new ClassPathXmlApplicationContext("springConfig.xml");
//        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");

        NotificationService notificationService =  context.getBean(NotificationService.class);
        notificationService.notify("hello saber");


//        MessageDigester messageDigester = context.getBean(MessageDigester.class);
//        messageDigester.digest("Hello World !!");


//        Singer singer = context.getBean("singerOne", Singer.class);
//        Singer singerOne = getSingerBean("singerOne",context, Singer.class);
//        Singer singerTwo = getSingerBean("singerTwo",context, Singer.class);
//        Singer singerThree = getSingerBean("singerThree",context, Singer.class);
//
//        System.out.println(singerOne);
//        System.out.println(singerTwo);
//        System.out.println(singerThree);

//        HelloServices helloServices = context.getBean(HelloServices.class);
//        String sayHello = helloServices.sayHello("saber", "azizi");
//        String sayBye = helloServices.sayBye("saber", "azizi");
//        System.out.println(sayHello);
//        System.out.println(sayBye);
//
//        System.out.println("========================================");
//        PersonService personService = context.getBean(PersonService.class);
//        System.out.println("response person findAll ===> "+personService.findAll());
//        System.out.println("response save Person ===> "+personService.save(new Person(null, "saber", "azizi", "0079028748", 35)));
//        System.out.println("response save Person ===> "+personService.save(new Person(null, "bruce", "lee", "0094537452", 33)));
//        System.out.println("response person findByNationalCode ===> "+personService.findByNationalCode("0079028748"));
//        System.out.println("response person findByNationalCode ===> "+personService.findByNationalCode("0094537452"));
//        System.out.println("response person findAll ===> "+personService.findAll());

//        CollectionService collectionService = context.getBean(CollectionService.class);
//        collectionService.printCollections();

//        LockOpener abstractLockOpener = context.getBean("abstractLockOpener", LockOpener.class);
//        LockOpener standardLockOpener = context.getBean("standardLockOpener", LockOpener.class);
//
//        displayInfo("abstractLockOpener", abstractLockOpener);
//        displayInfo("standardLockOpener", standardLockOpener);


        context.registerShutdownHook();
    }


    private static void displayInfo(String beanName, LockOpener lockOpener) {
        KeyHelper myKeyOpenerOne = lockOpener.getMyKeyOpener();
        KeyHelper myKeyOpenerTwo = lockOpener.getMyKeyOpener();

        System.out.printf("[ %s ] : keyHelper instance the same ? %s%n", beanName, (myKeyOpenerOne == myKeyOpenerTwo));

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");

        for (int i = 0; i < 100_000; i++) {
            KeyHelper keyHelper = lockOpener.getMyKeyOpener();
            keyHelper.open();
        }
        stopWatch.stop();
        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }

    private static <T> T getSingerBean(String beanName, ApplicationContext context, Class<T> requiredType) {
        try {
            Object bean = context.getBean(beanName);
            if (requiredType != null && !requiredType.isInstance(bean)) {
                throw new TypeMismatchNamingException(beanName, requiredType, bean.getClass());
            }
            return (T) bean;
        } catch (Exception ex) {
            System.out.println("An error occurred in bean configuration: " + ex.getMessage());
            return null;
        }
    }
}
