package com.bdrive.examen.ENTITYS.REPOSITORY;

import com.bdrive.examen.ENTITYS.MODELS.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,Long> {

    Users findByUsername(String nameUser);

    Users findByEmail(String email);
}
