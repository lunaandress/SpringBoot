package com.andres.springboot.app.springboot_crud.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(unique = true)
@NotBlank
@Size(min=4 , max=12)
private String username;

@NotBlank
@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)// con esto aho que desaparesca el password
private String password;

@ManyToMany
@JoinTable(
name = "users_roles",
joinColumns = @JoinColumn(name="user_id"),
inverseJoinColumns = @JoinColumn(name="role_id"),
uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id","roles_id"})}
)
private List<Role> roles;


private boolean enable; // ayuda a desactivar disponibe en la base de datos

@PrePersist// metodo que se hace  activa antes del la llamada al original
public void prePersist(){
    enable=true;
}

@Transient // con esto le decimos que no es de la tabla para  que no salte error
private boolean admin;//campo no de la tabla





public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getUsername() {
    return username;
}
public void setUsername(String username) {
    this.username = username;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public List<Role> getRoles() {
    return roles;
}
public void setRoles(List<Role> roles) {
    this.roles = roles;
}
public boolean isAdmin() {
    return admin;
}
public void setAdmin(boolean admin) {
    this.admin = admin;
}
public boolean isEnable() {
    return enable;
}
public void setEnable(boolean enable) {
    this.enable = enable;
}




}
