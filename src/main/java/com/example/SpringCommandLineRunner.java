package com.example;

import com.example.permission.model.Permission;
import com.example.permission.repo.PermissionRepository;
import com.example.roles.model.Role;
import com.example.roles.repo.RoleRepository;
import com.example.users.model.User;
import com.example.users.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Component
public class SpringCommandLineRunner implements CommandLineRunner {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PermissionRepository permissionRepository;

    private final RequestMappingInfoHandlerMapping qequestMappingInfoHandlerMapping;

    @PersistenceContext
    private EntityManager entityManager;

    public SpringCommandLineRunner(UserRepository userRepository, RoleRepository roleRepository, PermissionRepository permissionRepository, RequestMappingInfoHandlerMapping qequestMappingInfoHandlerMapping) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.qequestMappingInfoHandlerMapping = qequestMappingInfoHandlerMapping;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(entityManager);
        Map<RequestMappingInfo, HandlerMethod> handlersMethod = qequestMappingInfoHandlerMapping.getHandlerMethods();

        handlersMethod.forEach((key, value) -> System.out
                .println(key.getPatternsCondition().getPatterns() + " : " + key.getMethodsCondition().getMethods()));

        Permission permission = new Permission(1, "permission", "permission desc", null);
        Set<Permission> permissions = new HashSet<>();
        permissions.add(permission);
        Role role = new Role(1, "role", "role desc", null, permissions);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        permission.setRoles(roles);

        Role saveRole = roleRepository.save(role);

        List<User> userList = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 97);
            User user = new User(0, c + "@gmail.com", c + "", c + "", null);
            userList.add(user);
        }
        List<User> saveUserList = userRepository.saveAll(userList);
        for (User u : saveUserList) {
            u.setRoles(roles);
            userRepository.save(u);
        }
    }

}
