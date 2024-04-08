package io.github.kimmking.apollo1;

import com.ctrip.framework.apollo.mockserver.ApolloTestingServer;
import io.github.kimmking.apollo2.Config1;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.context.properties.ConfigurationPropertiesRebinder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootTest
class Apollo1ApplicationTests {

    static ApolloTestingServer apolloTestingServer = new ApolloTestingServer();

    @BeforeAll
    @SneakyThrows
    static void init() {
        System.out.println(" ====================================== ");
        System.out.println(" ====================================== ");
        System.out.println(" =============     ZK2182    ========== ");
        System.out.println(" ====================================== ");
        System.out.println(" ====================================== ");
        apolloTestingServer.start();
    }

    @Autowired Demo demo;
    @Autowired Config1 conf;

    @Test
    void contextLoads() {
        System.out.println("hahaha.....");
        apolloTestingServer.close();
    }

    @Test
    void test01(@Autowired ApplicationContext context) {
        // Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println("  ====>>> demo.getA() = " +demo.getA());
        System.out.println("  ====>>>        conf = " +conf);
    }

    @AfterAll
    @SneakyThrows
    static void destory() {
        apolloTestingServer.close();
    }

}
