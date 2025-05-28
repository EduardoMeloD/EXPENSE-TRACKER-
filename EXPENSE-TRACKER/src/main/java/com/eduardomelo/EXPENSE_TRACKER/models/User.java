package com.eduardomelo.EXPENSE_TRACKER.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    
    public static final String TABLE_NAME = "user";
    public interface CreateUser{}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", unique = true)
    private Long id;
    @Column(name="username", unique = true, length = 50, nullable = false)
    @NotEmpty(groups = CreateUser.class)
    @NotNull(groups = CreateUser.class)
    @Size(groups = CreateUser.class, min = 2, max = 50)
    private String username;
    @Column(name="password", unique = true, length = 50, nullable = false)
    @JsonProperty(access = Access.WRITE_ONLY)
    @NotEmpty(groups = CreateUser.class)
    @NotNull(groups = CreateUser.class)
    @Size(groups = CreateUser.class, min = 2, max = 50)
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Costs> costs = new ArrayList<Costs>();


    public User(Long id, String username, String password, List<Costs> costs) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.costs = costs;
    }
    

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Costs> getCosts() {
        return this.costs;
    }

    public void setCosts(List<Costs> costs) {
        this.costs = costs;
    }

}
