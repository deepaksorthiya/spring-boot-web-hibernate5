package com.example.roles.model;

import java.io.Serializable;
import java.util.Set;

import com.example.users.model.AppUser;
import jakarta.persistence.*;

import com.example.permission.model.Permission;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@NamedEntityGraphs(@NamedEntityGraph(name = "graph.Role.permissions", attributeNodes = @NamedAttributeNode("permissions")))
public class Role implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long roleId;

    private String roleName;

    private String roleDesc;

    @ManyToMany(mappedBy = "roles", targetEntity = AppUser.class)
    @JsonIgnore
    private Set<AppUser> appUsers;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = Permission.class)
    @JoinTable(name = "ROLE_PERMISSION_MAPPING")
    private Set<Permission> permissions;

}
