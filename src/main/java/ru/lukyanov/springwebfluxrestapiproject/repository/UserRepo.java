package ru.lukyanov.springwebfluxrestapiproject.repository;


import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.lukyanov.springwebfluxrestapiproject.entity.User;

@Repository
@Transactional(readOnly = true)
public interface UserRepo extends ReactiveCrudRepository<User, Long> {

}