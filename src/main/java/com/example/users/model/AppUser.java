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

	@Email(message = "{appuser.email.not.valid}")
	@NotBlank(message = "{appuser.email.not.empty}")
	private String email;

	@NotBlank(message = "{appuser.fname.not.empty}")
	private String firstName;

	@NotBlank(message = "{appuser.lname.not.empty}")
	private String lastName;

	@ManyToMany(cascade = CascadeType.ALL, targetEntity = Role.class)
	@JoinTable(name = "USER_ROLE_MAPPING")
	private Set<Role> roles;
}