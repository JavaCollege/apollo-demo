package io.github.kimmking.apollo2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Description for this class.
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/4/7 04:56
 */

@Configuration
@Import({Config1.class})
public class Config2 {

     @Bean
     public Config3 cc() {
         return new Config3();
     }

}
