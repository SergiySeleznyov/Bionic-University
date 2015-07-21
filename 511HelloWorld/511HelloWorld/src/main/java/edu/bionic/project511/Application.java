package edu.bionic.project511;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    private GreetingService greetingService;
    private int greetingCount;

    public void start() {
        for (int i = 0; i < greetingCount; i++) {
            greetingService.sendGreeting();
        }
    }

    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void setGreetingCount(int greetingCount) {
        this.greetingCount = greetingCount;
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
        Application application = context.getBean(Application.class);
        application.start();

    }

}
