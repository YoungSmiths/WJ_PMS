package com.wj.pms.dao;

import com.wj.pms.common.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by YoungSmith on 2018/7/22.
 */
public interface UserDao extends CrudRepository<User, Long> {
    @Query("SELECT u from User u where u.name = :name")
    List<User> findUser(@Param("name") String name);

    @Query("SELECT u from User u where u.role = :role")
    List<User> findUsersByUserType(@Param("role") String role);

    @Query("select u from User u where (u.role ='admin' or u.role ='super') and u.state='success'")
    List<User> getSuperAndAdminUsers();

    @Query("SELECT u from User u where u.mail = :mail")
    List<User> getUserByEmail(@Param("mail") String mail);
}
