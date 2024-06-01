package com.itotdel.money.controller;


import com.itotdel.money.exception.UserExistsException;
import com.itotdel.money.exception.UserNotFoundException;
import com.itotdel.money.model.MessageResponse;
import com.itotdel.money.model.User;
import com.itotdel.money.model.UserBudgetResponse;
import com.itotdel.money.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ExceptionHandler(UserNotFoundException.class)
    ResponseEntity<MessageResponse> handleUserNotFoundException(UserNotFoundException ex) {
        MessageResponse response = new MessageResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserExistsException.class)
    ResponseEntity<MessageResponse> handleUserExistsException(UserExistsException ex) {
        MessageResponse response = new MessageResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/create")
    ResponseEntity<User> createNewUser(@RequestBody User body) {
        return ResponseEntity.ok(userService.createNewUser(body));
    }

    @GetMapping("/budget")
    ResponseEntity<UserBudgetResponse> getUserBudget(@RequestParam String userId) {
        return ResponseEntity.ok(userService.getUserBudget(userId));
    }

    @PostMapping("/budget")
    ResponseEntity<UserBudgetResponse> setUserBudget(@RequestBody User body) {
        return ResponseEntity.ok(userService.setUserBudget(body));
    }
}
