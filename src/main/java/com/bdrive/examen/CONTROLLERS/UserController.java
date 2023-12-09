package com.bdrive.examen.CONTROLLERS;

import com.bdrive.examen.DTO.UserRequest;
import com.bdrive.examen.DTO.UserResponse;
import com.bdrive.examen.SERVICES.UserService;
import com.bdrive.examen.UTILS.DataNotExistingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService usersService;

    @GetMapping(value = "/get-user-by-email")
    public UserResponse getUserByEmail(@RequestBody UserRequest request){
        log.info("Get user by email start --->>>");
        UserResponse response = new UserResponse();
        try {
            response = usersService.getByEmail(request);
            return response;
        } catch (DataNotExistingException e){
            log.info("Data not found for email:" + request.getEmail() + e);
            return response;
        } finally {
            log.info("<<<---- Get user by email end");
        }

    }

    @PostMapping(value = "/create-new-user")
    public UserResponse createNewUser(@RequestBody UserRequest request){
        log.info("Create new user start --->>>");
        UserResponse response = new UserResponse();
        try {
            response = usersService.createNewUser(request);
            return response;
        } catch (SQLException e){
            log.info("An error occurred while trying to connect to database:" + e);
            return response;
        } finally {
            log.info("<<<--- Create new user end");
        }
    }

    @PutMapping(value = "/update-user")
    public UserResponse updateUser(@RequestBody UserRequest request){
        log.info("Update user start --->>>");
        UserResponse response = new UserResponse();
        try {
            response = usersService.updateByUserId(request);
            return response;
        } catch (DataNotExistingException e){
            log.info("Data not found for email:" + request.getEmail() + e);
            return response;
        } finally {
            log.info("<<<--- Update user end");
        }
    }

    @DeleteMapping(value = "/delete-user")
    public UserResponse deleteUser(@RequestBody UserRequest request){
        log.info("Delete user start --->>>");
        UserResponse response = new UserResponse();
        try {
            response = usersService.deleteByUserId(request);
            return response;
        } catch (DataNotExistingException e){
            log.info("Data not found for email:" + request.getEmail() + e);
            return response;
        } finally {
            log.info("<<<--- Delete user end");
        }
    }
}
