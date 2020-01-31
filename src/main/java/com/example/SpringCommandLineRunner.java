package com.example;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;

import com.example.permission.model.Permission;
import com.example.roles.model.Role;
import com.example.users.model.User;
import com.example.users.repo.UserRepository;

@Component
public class SpringCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RequestMappingInfoHandlerMapping qequestMappingInfoHandlerMapping;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void run(String... args) throws Exception {

		System.out.println(entityManager);
		Map<RequestMappingInfo, HandlerMethod> handlersMethod = qequestMappingInfoHandlerMapping.getHandlerMethods();

		handlersMethod.forEach((key, value) -> {
			System.out
					.println(key.getPatternsCondition().getPatterns() + " : " + key.getMethodsCondition().getMethods());
		});

		Set<User> users = new HashSet<>();
		Set<Role> roles = new HashSet<>();
		Set<Permission> permissions = new HashSet<>();

		User user = new User(0, "a3@gmail.com", "a3", "a3", null);
		users.add(user);

		Role adminrRole = new Role(0, "ROLE_ADMIN", "ADMIN ROLE", users, permissions);
		roles.add(adminrRole);

		Permission permission = new Permission(0, "WRITE_USERS", "WRITE USERS IN DB", roles);
		permissions.add(permission);

		user.setRoles(roles);
		permission.setRoles(roles);

		userRepository.save(user);
	}

}