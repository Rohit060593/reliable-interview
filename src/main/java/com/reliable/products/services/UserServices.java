package com.reliable.products.services;

import com.reliable.products.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserServices {

    User findById(Long id);
    Page<User> findAll(Pageable pageable);
    User create(User user);
    User Update(User user, Long id);
    void deleteUser(Long id);

}
