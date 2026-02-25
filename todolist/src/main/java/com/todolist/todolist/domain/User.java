package com.todolist.todolist.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name= "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "자동 생성되는 고유 ID", example="1")
    private Long id;

    @Column(nullable = false, unique = true)
    @Schema
    private String username;

    @Column(nullable = false)
    @Schema
    private String password;

    @Column(nullable = false)
    @Schema
    private String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Todo> todos;
}
