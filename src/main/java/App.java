import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import pp.config.AppConfig;
import pp.model.User;
import pp.service.UserService;
import pp.service.UserServiceImpl;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        userService.save(new User("Jack", 1));
    }
}
