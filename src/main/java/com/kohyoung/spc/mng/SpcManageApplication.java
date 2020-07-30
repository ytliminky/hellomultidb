package com.kohyoung.spc.mng;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(MybatisConfiguration.class)
public class SpcManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpcManageApplication.class, args);
    }

}
