package com.project.Task.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Collection;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ROLES")
public class Roles {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "NAME", unique = true, length = 25, nullable=false)
    private String name;
    
    @Column(name = "DESCRIPTION", length = 150, nullable=false)
    private String description;
    
    @JoinTable(name = "ROLES_BY_USERS", joinColumns = {
        @JoinColumn(name = "ROL_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "USER_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Users> usersCollection;

    public Roles(String name) {
        this.name = name;
    }
    
}
