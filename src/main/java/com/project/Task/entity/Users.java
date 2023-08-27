package com.project.Task.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USERS")
public class Users implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Integer id;
    
    @Column(name="USERNAME",unique = true, length = 15, nullable=false)
    private String username;
    
    @Column(name="PASSWORD",unique = true, length = 60, nullable=false)
    private String password;
    
    @Column(name="IDENTIFICATION_NUMBER",unique = true, length = 7, nullable=false)
    private Integer identification_number;
    
    @Column(name="FIRST_NAME", length = 25, nullable=false)
    private String first_name;
    
    @Column(name="LAST_NAME", length = 25, nullable=false)
    private String last_name;
    
    @Column(name="PHONE_NUMBER")
    private String phone_number;
    
    @Column(name="EMAIL", length = 40, nullable=false)
    private String email;
    
    @Column(name="DATE_OF_BIRTH", nullable=false)
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date date_of_birth;
    
    @Column(name="STATUS", length = 25, nullable=false)
    private String status;
    
    @ManyToMany(mappedBy = "usersCollection")
    private Collection<Roles> rolesCollection;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users")
    private Tasks tasks;
    
}
