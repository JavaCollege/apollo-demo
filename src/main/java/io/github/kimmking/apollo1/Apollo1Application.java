package io.github.kimmking.apollo1;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import io.github.kimmking.apollo2.Config1;
import io.github.kimmking.apollo2.Config2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.properties.ConfigurationPropertiesRebinder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication
@EnableApolloConfig
@Import({Config2.class}) //OK
//@ConfigurationPropertiesScan({"io.github.kimmking.apollo1","io.github.kimmking.apollo2"}) //OK
//@EnableConfigurationProperties(Config1.class) //OK
public class Apollo1Application {

    @Bean
    ApolloChangedListener listener(){
        return new ApolloChangedListener();
    }

    @Autowired Demo demo;
    @Autowired Config1 conf;

    public static void main(String[] args) {
        SpringApplication.run(Apollo1Application.class, args);
    }


    @GetMapping("/cf")
    public String cf() {
        System.out.println(demo.getA());
        System.out.println(conf);
        return demo.getA() + ",\n" + conf+ ",\n" + System.identityHashCode(conf);
    }

    @Bean
    ApplicationRunner applicationRunner(@Autowired ApplicationContext context) {
       return x -> {
           System.out.println(demo.getA());
           System.out.println(conf);

           ConfigurationPropertiesRebinder rebinder = context.getBean(ConfigurationPropertiesRebinder.class);
           System.out.println(rebinder);

       } ;
    }

}
