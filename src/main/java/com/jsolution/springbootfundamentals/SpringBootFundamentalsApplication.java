package com.jsolution.springbootfundamentals;

import com.jsolution.springbootfundamentals.a_introduction.components.ComponentDependency;
import com.jsolution.springbootfundamentals.b_owndependency.beans.interfaces.MyBean;
import com.jsolution.springbootfundamentals.b_owndependency.beans.interfaces.MyBeanWithDependency;
import com.jsolution.springbootfundamentals.c_port_path.interfaces.MyBeanWithProperties;
import com.jsolution.springbootfundamentals.d_pojos_with_properties.pojos.UserPojo;
import com.jsolution.springbootfundamentals.e_logs.TechLogs;
import com.jsolution.springbootfundamentals.f_jpa_modeling.dto.UserDTO;
import com.jsolution.springbootfundamentals.f_jpa_modeling.entities.User;
import com.jsolution.springbootfundamentals.f_jpa_modeling.repository.UserRepository;
import com.jsolution.springbootfundamentals.f_jpa_modeling.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringBootFundamentalsApplication implements CommandLineRunner {


    @Autowired
    @Qualifier("spanishComponentImplement")
    private ComponentDependency componentDependency;

    @Autowired
    private MyBean myBean;

    @Autowired
    private MyBeanWithDependency myBeanWithDependency;

    @Autowired
    private MyBeanWithProperties myBeanWithProperties;

    @Autowired
    private UserPojo userPojo;

    @Autowired
    private UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(SpringBootFundamentalsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        UserService userService = new UserService(userRepository);
        //jpaIntroduction();
        jpaMethods(userService);
        jpaTransactional(userService);

    }

    private void saveUsersInDataBase(){
        User user1 = new User("Jiliar", "jiliar.silgado@gmail.com", LocalDate.of(1990, 01,14));
        User user2 = new User("Maria", "maria.puerta.sala@hotmail.com", LocalDate.of(1985, 12,11));
        User user3 = new User("Duban", "dubansilgado@gmail.com", LocalDate.of(1984, 1,6));
        User user4 = new User("Jhon", "jhon@hotmail.com", LocalDate.of(1984, 3,4));
        User user5 = new User("Ariel", "arielito@gmail.com", LocalDate.of(1983, 4,3));
        User user6 = new User("Lisley", "lisley1000@hotmail.com", LocalDate.of(1995, 5,4));
        User user7 = new User("Manuel", "manuel@gmail.com", LocalDate.of(1998, 6,5));
        List<User> list = Arrays.asList(user1, user2, user3, user4, user5, user6, user7);
        list.forEach(userRepository::save);
    }

    private List<User> saveWithErrorTransactional(){
        User test1 = new User("test1", "jasc_fast@gmail.com", LocalDate.of(1990, 01,14));
        User test2 = new User("test2", "maria.puerta.sala1@hotmail.com", LocalDate.of(1985, 12,11));
        User test3 = new User("test3", "dubansilgado2@gmail.com", LocalDate.of(1984, 1,6));
        User test4 = new User("test4", "jhon3@hotmail.com", LocalDate.of(1984, 3,4));
        User test5 = new User("test5", "maria.puerta.sala1@hotmail.com", LocalDate.of(1983, 4,3));
        User test6 = new User("test6", "lisley10003@hotmail.com", LocalDate.of(1995, 5,4));
        User test7 = new User("test7", "manuel1@gmail.com", LocalDate.of(1998, 6,5));
        List<User> list = Arrays.asList(test1, test2, test3, test4, test5, test6, test7);
        return list;
    }

    private void jpaIntroduction(){
        componentDependency.great();
        myBean.print();
        myBeanWithDependency.printWithDependencyImplement();
        String result = myBeanWithProperties.function();
        System.out.println(result);
        System.out.println(userPojo.toString());

        //Logs
        double res = 0;
        TechLogs.LOGGER.info("Evaluating Apache Commons");
        try{
            int number1 = 1;
            TechLogs.LOGGER.debug("First number "+number1);
            int number2 = 0;
            TechLogs.LOGGER.debug("Second number "+number2);
            res = 1/0;
        }catch(ArithmeticException e){
            TechLogs.LOGGER.error("¡It's an Error "+e.getMessage()+"!");
        }
    }

    private void jpaMethods(UserService userService){
        saveUsersInDataBase();
        User user = userService.getUserByEmail("jiliar.silgado@gmail.com");
        System.out.println(user.toString());
        System.out.println(":::Listing Data:::");
        userService.getUserListByEmail("hotmail");
        System.out.println(":::Get User by Name:::");
        System.out.println( userService.getUserByName("Duban"));
        System.out.println(":::Get User by Name and Email:::");
        System.out.println(userService.getUserByNameAndEmail("Jiliar", "jiliar.silgado@gmail.com"));
        System.out.println(":::Get User LIKE Name :::");
        userService.getUsersByNameLike("J");
        System.out.println(":::Get User by Name OR Email:::");
        userService.getFindByNameOrEmail("Jiliar", "maria.puerta.sala@hotmail.com");
        userService.getByBirthDayBetween(LocalDate.of(1983,01,01),
                LocalDate.of(1990,12,31));
        userService.getByNameLikeOrderByBirthDay("J");
        System.out.println(":::Using named Parameters:::");
        UserDTO userDto = userService.getAllByBirthDayAndAndEmail(LocalDate.of(1990,01,14),
                "jiliar.silgado@gmail.com");
        System.out.println(userDto);
    }

    private void jpaTransactional(UserService userService){
        try {
            var list = saveWithErrorTransactional();
            userService.saveTransactional(list);
            userService.getAllUsers().forEach(System.out::println);
        }catch (Exception e){
            TechLogs.LOGGER.error("Error Transaccional "+e.getLocalizedMessage());
        }
    }
}
