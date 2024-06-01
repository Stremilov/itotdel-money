package com.itotdel.money.service;


import com.itotdel.money.exception.UserExistsException;
import com.itotdel.money.exception.UserNotFoundException;
import com.itotdel.money.model.User;
import com.itotdel.money.model.UserBudgetResponse;
import com.itotdel.money.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public UserBudgetResponse getUserBudget(String userId) {
        User user = repository.findById(userId).orElseThrow(UserNotFoundException::new);
        return new UserBudgetResponse(user.getBudget());
    }

    public UserBudgetResponse setUserBudget(User requestBody) {
        repository.findById(requestBody.getId()).orElseThrow(UserNotFoundException::new);
        User user = repository.save(requestBody);
        return new UserBudgetResponse(user.getBudget());
    }

    public User createNewUser(User requestBody) {
        if (repository.findById(requestBody.getId()).isPresent()) {
            throw new UserExistsException();
        }
        return repository.save(requestBody);
    }
}
