package hello;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

// To finish our application, we need to create a single Java file.
// By default, Maven compiles sources from src/main/java/Application.java,
// so you need to create that directory structure and then add a file named
// Application.java to contain the following code.

// The first annotation on our Example class is @RestController. This is known as a _stereotype_ annotation.
// It provides hints for people reading the code and for Spring that the class plays a specific role.
// In this case, our class is a web @Controller, so Spring considers it when handling incoming web requests.
@RestController
// The second class-level annotation is @EnableAutoConfiguration. This annotation tells Spring Boot to "guess"
// how you want to configure Sprng, based on the jar dependencies that you have added. Since spring-boot-starter-web 
// added Tomcat and Spring MVC, the auto-configuration assumes that you are developing a web application and sets up
// Spring accordingly.
@EnableAutoConfiguration
@SpringBootApplication
public class Application implements CommandLineRunner {

    Logger logger = LogManager.getLogger("Application");

    @Autowired
    private YAMLConfig myConfig;

    // The @RequestMapping annotation provides "routing" information. It tells Spring that any HTTP request 
    // with the `/` path should be mapped to the `home` method. The @RestController annotation tells Spring 
    // to render the resulting string directly back to the caller.
    @RequestMapping("/")
    String home() {
        logger.info("Hello World!");
        return "Hello World!";
    }

    // The final part of our application is the `main` method.
    // This is a standard method that follows the Java convention for an application entry point.
    // Our main method delegates to Spring Boot's `SpringApplication` class by calling `run`.
    // `SpringApplication` bootstraps our application, starting Spring, which, in turn, starts 
    // the auto-configured Tomcat web server.
    // We need to pass `Example.class` as an argument to the `run` method to tell `SpringApplication` 
    // which is the primary Spring component. The `args` array is also passed through to expose any 
    // command-line arguments.
    public static void main(String[] args) {
        // SpringApplication.run(Application.class, args);
        SpringApplication app = new SpringApplication(Application.class);
        app.run();
    }

    public void run(String... args) throws Exception {
        logger.info("using environment: {}",myConfig.getEnvironment()); 
        logger.info("name: {}", myConfig.getName());
        logger.info("enabled: {}", myConfig.isEnabled());
        logger.info("servers: {}", myConfig.getServers());
    }

}
