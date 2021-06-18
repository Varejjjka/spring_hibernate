package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Рейчел", "Грин", "rgreen@friends.com");
      user1.setCar(new Car("Kia", 1111));
      userService.add(user1);

      User user2 = new User("Моника", "Геллер", "mgeller@friends.com");
      user2.setCar(new Car("Smart", 2222));
      userService.add(user2);

      User user3 = new User("Чендлер", "Бинг", "chbing@friends.com");
      user3.setCar(new Car("Ford", 3333));
      userService.add(user3);

      User user4 = new User("Джо", "Триббиани", "dtribbiani@friends.com");
      user4.setCar(new Car("Tesla", 4444));
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      List<User> user = userService.getUser("Smart", 2222);
      System.out.println(user);

      context.close();
   }
}
