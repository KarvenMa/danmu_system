

package cn.partytime.collector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws Exception {
		//SpringApplication.run(Application.class, args);
		SpringApplication app = new SpringApplication(Application.class);
		app.setWebEnvironment(false);
		app.run(args);

	}

}
