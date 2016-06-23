package cn.partytime;

import lombok.extern.slf4j.Slf4j;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import org.springframework.boot.autoconfigure.SpringBootApplication;
=======
>>>>>>> pr/7
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
<<<<<<< HEAD
=======
>>>>>>> master
>>>>>>> pr/7
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by liuwei on 16/6/22.
 */


@ComponentScan("cn.partytime")
@SpringBootApplication
@Slf4j
<<<<<<< HEAD
=======
<<<<<<< HEAD
public class Application {

=======
>>>>>>> pr/7
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
<<<<<<< HEAD
=======
>>>>>>> master
>>>>>>> pr/7
}
