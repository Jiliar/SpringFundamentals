package com.jsolution.springbootfundamentals.f_jpa_modeling.repository;

import com.jsolution.springbootfundamentals.f_jpa_modeling.dto.UserDTO;
import com.jsolution.springbootfundamentals.f_jpa_modeling.entities.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    //JPQL Methods
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByEmail(String email);

    @Query("SELECT u from User u WHERE u.email LIKE %?1%")
    List<User> findAndSort(String name, Sort sort);

    //Query Methods
    Optional<User> findByName(String name);
    Optional<User> findByNameAndEmail(String name, String email);
    List<User> findByNameLike(String name);
    List<User> findByNameOrEmail(String name, String email);
    List<User> findByBirthDayBetween(LocalDate date1, LocalDate date2);
    List<User> findByNameLikeOrderByBirthDay(String param);
    List<User> findAll();

    //DTO
    @Query("SELECT new com.jsolution.springbootfundamentals.f_jpa_modeling.dto.UserDTO(u.id, u.name, u.birthDay) " +
            "FROM User u WHERE u.email = :paramEmail AND u.birthDay = :paramBirtDay")
    Optional<UserDTO> findAllByBirthDayAndAndEmail(@Param("paramBirtDay") LocalDate date,
                                                  @Param("paramEmail") String email);




}
