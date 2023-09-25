package com.example.users.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import com.example.roles.model.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	@Email(message = "email should be in proper form")
	@NotBlank(message = "email should not be blank")
	private String email;

	@NotBlank(message = "First name should not be blank")
	private String firstName;

	@NotBlank(message = "Last name should not be blank")
	private String lastName;

	@ManyToMany(cascade = CascadeType.ALL, targetEntity = Role.class)
	@JoinTable(name = "USER_ROLE_MAPPING")
	private Set<Role> roles;
}