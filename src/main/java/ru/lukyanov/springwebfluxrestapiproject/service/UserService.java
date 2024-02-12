package ru.lukyanov.springwebfluxrestapiproject.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.lukyanov.springwebfluxrestapiproject.entity.User;
import ru.lukyanov.springwebfluxrestapiproject.repository.UserRepo;


@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepo repo;

    public Mono<User> findById(Long id) {

        return repo.findById(id);

    }

    public Flux<User> findAll() {
        Flux<User> users = repo.findAll();
        return users;
    }

    public Mono<User> save(User user) {
        return repo.save(user);
    }

    public void delete(User user) {
        Mono<Void> deletedUser = repo.delete(user);
    }

    public Mono<Void> deleteById(Long id) {
        return repo.deleteById(id);
    }

}