package io.github.kimmking.apollo1;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Description for this class.
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/4/6 22:58
 */

@Data
@Configuration
public class Demo {

    @Value("${p.a}")
    String a;

}
