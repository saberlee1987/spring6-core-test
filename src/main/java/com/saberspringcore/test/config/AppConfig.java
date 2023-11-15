package com.saberspringcore.test.config;

import com.saberspringcore.test.model.Singer;
import com.saberspringcore.test.model.Song;
import com.saberspringcore.test.services.HelloServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.saberspringcore.test")
public class AppConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    public HelloServices helloServices(){
        System.out.println("helloService bean called ..............");
        return new HelloServices();
    }

    @Bean
    public Song song1(){
        return new Song("Here's to hoping");
    }
    @Bean
    public Song song2(){
        return new Song("Wishing the best for you");
    }
    @Bean
    public List<Song> list(){
        return List.of(
                new Song("Not the end"),
                new Song("Rise Up")
        );
    }

    @Bean(initMethod = "init")
    Singer singerOne(){
        Singer singer = new Singer();
        singer.setName("John Mayer");
        singer.setAge(43);
        return singer;
    }
    @Bean(initMethod = "init")
    Singer singerTwo(){
        Singer singer = new Singer();
        singer.setAge(42);
        return singer;
    }
    @Bean(initMethod = "init")
    Singer singerThree(){
        Singer singer = new Singer();
        singer.setName("John Butler");
        return singer;
    }
}
