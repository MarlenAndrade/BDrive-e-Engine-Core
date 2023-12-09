package com.bdrive.examen.SERVICES;

import com.bdrive.examen.ENTITYS.MODELS.Users;
import com.bdrive.examen.ENTITYS.SERVICES.UsersService;
import com.bdrive.examen.DTO.UserRequest;
import com.bdrive.examen.DTO.UserResponse;
import com.bdrive.examen.UTILS.DataNotExistingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UsersService usersService;
    public UserResponse getByEmail(UserRequest request) throws DataNotExistingException {
        UserResponse response = new UserResponse();
        Users users = usersService.findByEmail(request.getEmail());
        response.setUserId(users.getUserId());
        response.setEmail(users.getEmail());
        response.setUserName(users.getUsername());
        response.setPassword(users.getPassword());
        response.setLastName(users.getLastName());
        response.setFirstName(users.getFirstName());
        response.setMiddleName(users.getMiddleName());
        log.info("¡Successfully founded!");
        return response;
    }

    public UserResponse createNewUser(UserRequest request) throws SQLException {
        UserResponse response = new UserResponse();
        Users users = new Users();
        users.setEmail(request.getEmail());
        users.setPassword(request.getPassword());
        users.setUsername(request.getUserName());
        users.setFirstName(request.getFirstName());
        users.setMiddleName(request.getMiddleName());
        users.setLastName(request.getLastName());
        usersService.save(users);
        response.setUserId(users.getUserId());
        response.setEmail(request.getEmail());
        response.setUserName(request.getUserName());
        response.setPassword(request.getPassword());
        response.setLastName(request.getLastName());
        response.setFirstName(request.getFirstName());
        response.setMiddleName(request.getMiddleName());
        log.info("¡Successfully created!");
        return response;
    }

    public UserResponse updateByUserId (UserRequest request) throws DataNotExistingException {
        UserResponse response = new UserResponse();
        Users users = usersService.findByUserId(request.getUserId());
        if (users != null){
            if(request.getEmail() != null){
                users.setEmail(request.getEmail());
                response.setEmail(users.getEmail());
            }
            if(request.getPassword() != null){
                users.setPassword(request.getPassword());
                response.setPassword(users.getPassword());
            }
            if (request.getUserName() != null){
                users.setUsername(request.getUserName());
                response.setUserName(users.getUsername());
            }
            if (request.getFirstName() != null){
                users.setFirstName(request.getFirstName());
                response.setFirstName(users.getFirstName());
            }
            if (request.getMiddleName() != null){
                users.setMiddleName(request.getMiddleName());
                response.setMiddleName(users.getMiddleName());
            }
            if (request.getLastName() != null){
                users.setLastName(request.getLastName());
                response.setLastName(users.getLastName());
            }
            response.setUserId(users.getUserId());
            usersService.save(users);
            log.info("¡Successfully updated!");
        }
        return response;
    }

    public UserResponse deleteByUserId (UserRequest request) throws DataNotExistingException {
        UserResponse response = new UserResponse();
        Users users = usersService.findByUserId(request.getUserId());
        response.setEmail(users.getEmail());
        response.setUserName(users.getUsername());
        response.setFirstName(users.getFirstName());
        response.setMiddleName(users.getMiddleName());
        response.setLastName(users.getLastName());
        response.setUserId(users.getUserId());
        response.setPassword(users.getPassword());

        usersService.deleteByUserId(request.getUserId());
        log.info("¡Successfully deleted!");
        return response;
    }
}
