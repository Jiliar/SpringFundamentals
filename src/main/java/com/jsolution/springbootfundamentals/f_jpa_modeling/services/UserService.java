package com.jsolution.springbootfundamentals.f_jpa_modeling.services;

import com.jsolution.springbootfundamentals.e_logs.TechLogs;
import com.jsolution.springbootfundamentals.f_jpa_modeling.dto.UserDTO;
import com.jsolution.springbootfundamentals.f_jpa_modeling.entities.User;
import com.jsolution.springbootfundamentals.f_jpa_modeling.repository.UserRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserService{

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByEmail(String email) {
        User user = null;
        try {
            user = userRepository.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("User is not found"));
            TechLogs.LOGGER.info(user.toString());
        }catch(Exception e){
            TechLogs.LOGGER.error(e.getLocalizedMessage());
        }
        return user;
    }

    public void getUserListByEmail(String provider){
        try {
            List<User> users = userRepository.findAndSort(provider, Sort.by("id").descending());
            if (users.size() == 0) {
                TechLogs.LOGGER.info("users not found");
            } else {
                users.stream().forEach(user -> TechLogs.LOGGER.info(user.toString()));
            }
        }catch (Exception e){
            TechLogs.LOGGER.error(e.getLocalizedMessage());
        }
    }

    public User getUserByName(String name){
        User user = null;
        try {
            user = userRepository.findByName(name)
                    .orElseThrow(() -> new RuntimeException("User is not found"));
            TechLogs.LOGGER.info(user.toString());
        }catch(Exception e){
            TechLogs.LOGGER.error(e.getLocalizedMessage());
        }
        return user;
    }

    public User getUserByNameAndEmail(String name, String email){
        User user = null;
        try {
            user = userRepository.findByNameAndEmail(name, email)
                    .orElseThrow(() -> new RuntimeException("User is not found"));
            TechLogs.LOGGER.info(user.toString());
        }catch(Exception e){
            TechLogs.LOGGER.error(e.getLocalizedMessage());
        }
        return user;
    }

    public void getUsersByNameLike(String name){
        userRepository.findByNameLike("%"+name+"%").stream()
                .forEach(System.out::println);
    }

    public void getFindByNameOrEmail(String name, String email){
        userRepository.findByNameOrEmail(name, email).stream()
                .forEach(user->TechLogs.LOGGER.info(user.toString()));
    }

    public void getByBirthDayBetween(LocalDate date1, LocalDate date2){
        try {
            List<User> users = userRepository.findByBirthDayBetween(date1, date2);
            if (users.size() == 0) {
                TechLogs.LOGGER.info("users not found");
            } else {
                users.stream().forEach(user -> TechLogs.LOGGER.info(user.toString()));
            }
        }catch (Exception e){
            TechLogs.LOGGER.error(e.getLocalizedMessage());
        }
    }

    public void getByNameLikeOrderByBirthDay(String param){
        try {
            List<User> users = userRepository.findByNameLikeOrderByBirthDay("%"+param+"%");
            if (users.size() == 0) {
                TechLogs.LOGGER.info("users not found");
            } else {
                users.stream().forEach(user -> TechLogs.LOGGER.info(user.toString()));
            }
        }catch (Exception e){
            TechLogs.LOGGER.error(e.getLocalizedMessage());
        }
    }

    public UserDTO getAllByBirthDayAndAndEmail(LocalDate date, String email){
        UserDTO user = null;
        try {
            user = userRepository.findAllByBirthDayAndAndEmail(date, email)
                    .orElseThrow(() -> new RuntimeException("User is not found"));
            TechLogs.LOGGER.info(user.toString());
        }catch(Exception e){
            TechLogs.LOGGER.error(e.getLocalizedMessage());
        }
        return user;
    }

    //Transacciones
    @Transactional
    public void saveTransactional(List<User> users){
        try {
        users.stream()
                .peek(user -> TechLogs.LOGGER.info("Inserted user "+user.toString()))
                .forEach(userRepository::save);
        }catch(Exception e){
            TechLogs.LOGGER.error(e.getLocalizedMessage());
        }
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

}
