package cn.partytime;

import lombok.extern.slf4j.Slf4j;
<<<<<<< HEAD
import org.springframework.boot.autoconfigure.SpringBootApplication;
=======
<<<<<<< HEAD
import org.springframework.boot.autoconfigure.SpringBootApplication;
=======
>>>>>>> origin/master
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
>>>>>>> master
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by liuwei on 16/6/22.
 */


@ComponentScan("cn.partytime")
@SpringBootApplication
@Slf4j
<<<<<<< HEAD
public class Application {

=======
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
>>>>>>> master
}
