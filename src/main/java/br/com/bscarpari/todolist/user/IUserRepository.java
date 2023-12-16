package br.com.bscarpari.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * IUserRepository
 * Uma interface é um "contrato" (methods) que deve ser implementado por uma
 * classe.
 */
public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    UserModel findByUsername(String username);
}
