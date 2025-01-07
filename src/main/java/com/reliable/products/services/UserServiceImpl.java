package com.reliable.products.services;

import com.reliable.products.entities.User;
import com.reliable.products.exceptions.UserNotFoundException;
import com.reliable.products.repositories.AddressRepository;
import com.reliable.products.repositories.UserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserServices{

    @Autowired
    private UserRepositories userRepositories;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public User findById(Long id) {
        return userRepositories.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Invalid user: " + id));
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepositories.findAll(pageable);
    }

    @Transactional
    @Override
    public User create(User user) {
        addressRepository.save(user.getAddress());
        return userRepositories.save(user);
    }

    @Override
    public User Update(User user, Long id) {
        User existingUser = userRepositories
                .findById(id)
                .orElseThrow(() -> new UserNotFoundException("Invalid user: " + id));
        existingUser.setName(user.getName());
        existingUser.setAddress(user.getAddress());
        return userRepositories.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepositories.deleteById(id);
    }
}
