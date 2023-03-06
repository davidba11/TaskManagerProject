package com.project.Task.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Collection;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TASKS_STATES")
public class TasksStates {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;
    
    @Column(name = "NAME", unique = true, length = 25, nullable=false)
    private String name;
    
    @Column(name = "DESCRIPTION", length = 150, nullable=false)
    private String description;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taskStateId")
    private Collection<Tasks> tasksCollection;
}
