package com.example.users.rest;

import com.example.constants.KeyConstants;
import com.example.users.model.AppUser;
import com.example.users.repo.UserRepository;
import com.example.users.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(KeyConstants.API_PREFIX + "/users")
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;

    private final EntityManager entityManager;

    public UserController(UserService userService, UserRepository userRepository, EntityManager entityManager) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.entityManager = entityManager;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppUser> save(@RequestBody @Valid AppUser appUser) {
        return new ResponseEntity<>(userService.save(appUser), HttpStatus.CREATED);
    }

    @GetMapping(value = "{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppUser> getUser(@PathVariable long userId) {
        return new ResponseEntity<>(userService.findById(userId).get(), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<AppUser>> findAll(@NotNull final Pageable pageable) {
        System.out.println(entityManager);
        Map<String, Object> properties = entityManager.getProperties();
        System.out.println(properties);
        return new ResponseEntity<>(userRepository.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "new", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<AppUser>> getAllUserWithRolesNotPermissions(@NotNull final Pageable pageable) {
        long count = userRepository.getAllCountUserWithRolesAndPermissions();
        System.out.println(count);
        return new ResponseEntity<>(userRepository.findAllBy(pageable), HttpStatus.OK);
    }
}
