package com.acstudent.admin;

import com.acstudent.cache.CacheApplication;
import com.acstudent.common.CommonApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {AdminApplication.class, CommonApplication.class, CacheApplication.class})
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }
}
