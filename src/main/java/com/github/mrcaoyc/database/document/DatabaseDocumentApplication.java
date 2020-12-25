package com.github.mrcaoyc.database.document;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author caoyongcheng
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class DatabaseDocumentApplication {
    public static void main(String[] args) {
        SpringApplication.run(DatabaseDocumentApplication.class, args);
    }
}
