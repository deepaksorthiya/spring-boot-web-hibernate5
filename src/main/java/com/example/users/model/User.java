package com.example.users.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.example.roles.model.Role;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class User {

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