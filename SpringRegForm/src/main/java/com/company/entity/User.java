package com.company.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table( name="users",
        uniqueConstraints={@UniqueConstraint(columnNames={"email"})})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    private boolean active;
    private BigDecimal balance;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name ="user_roles" , joinColumns=@JoinColumn(name="user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> authorities;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "user")
    private Set<Receipt> receipts;

    public User(String email, String password, boolean active, Set<Role> authorities, BigDecimal balance) {
        this.email = email;
        this.password = password;
        this.active = active;
        this.authorities = authorities;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                '}';
    }
}