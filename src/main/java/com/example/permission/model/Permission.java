package com.example.permission.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.example.roles.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long permissionId;

	private String permissionName;

	private String permissionDesc;

	@ManyToMany(mappedBy = "permissions", targetEntity = Role.class)
	@JsonIgnore
	private Set<Role> roles;

}
