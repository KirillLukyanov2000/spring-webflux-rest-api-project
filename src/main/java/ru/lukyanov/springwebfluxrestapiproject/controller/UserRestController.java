package ru.lukyanov.springwebfluxrestapiproject.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.lukyanov.springwebfluxrestapiproject.entity.User;
import ru.lukyanov.springwebfluxrestapiproject.service.UserService;

@Slf4j
@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<User> getUser(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> create(@ModelAttribute User user) {
        return userService.save(user);
    }

    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> update(@PathVariable Long id, @RequestBody User user) {
        if (id.equals(user.getId())) {
            return userService.save(user);
        } else {
            log.error("incorrect id = {}", id);
            return Mono.error(new IllegalStateException("incorrect id"));
        }
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteById(@PathVariable long id) {
        return userService.deleteById(id);
    }

}