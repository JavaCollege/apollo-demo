package io.github.kimmking.apollo2;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * Description for this class.
 *
 * @Author : kimmking(kimmking@apache.org)
 * @create 2024/4/6 23:00
 */


@Data
//@Configuration
@ConfigurationProperties(prefix = "p")
//@RefreshScope
public class Config1 {
    String a;
    String b;
    Map<String,String> c;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }
}
