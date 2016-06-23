

package cn.partytime.collector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("cn.partytime")
@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		//SpringApplication.run(Application.class, args);
		SpringApplication app = new SpringApplication(Application.class);
		app.setWebEnvironment(false);
		app.run(args);

	}

}
