package com.bdrive.examen.ENTITYS.SERVICES;

import com.bdrive.examen.ENTITYS.MODELS.Users;
import com.bdrive.examen.ENTITYS.REPOSITORY.UsersRepository;
import com.bdrive.examen.UTILS.DataNotExistingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;
    public Users save (Users user){
        log.info("Sending to save into 'USER'...");
        return usersRepository.save(user);
    }

    public Users findByUsername(String username) throws DataNotExistingException {
        return usersRepository.findByUsername(username);
    }

    public Users findByUserId(Long userId) throws DataNotExistingException {
        log.info("Searching by 'user_id': " + userId);
        Optional<Users> users =  usersRepository.findById(userId);
        return users.orElse(null);
    }

    public void deleteByUserId(Long userId) throws DataNotExistingException {
        log.info("User: " + userId + " will be deleted...");
        usersRepository.deleteById(userId);
    }

    public Users findByEmail(String email) throws DataNotExistingException {
        log.info("Searching by email: " + email);
        return usersRepository.findByEmail(email);
    }
}
