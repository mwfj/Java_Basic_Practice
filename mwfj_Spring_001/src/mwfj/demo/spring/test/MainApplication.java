package mwfj.demo.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class MainApplication {
	
	@Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "成都学院";
            }
        };
    }

	public static void main(String[] args) {
		ApplicationContext context = 
		          new AnnotationConfigApplicationContext(MainApplication.class);
		
		MessagePrinter printer = context.getBean(MessagePrinter.class);
		
		printer.printMessage();
		
		
	
	}

}
