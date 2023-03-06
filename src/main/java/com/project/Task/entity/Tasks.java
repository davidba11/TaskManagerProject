package com.project.Task.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Date;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TASKS")
public class Tasks {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "TASK_NAME", unique = true, length = 25, nullable=false)
    private String taskName;
    
    @Column(name = "TASK_DESCRIPTION", length = 150, nullable=false)
    private String taskDescription;
    
    @Column(name="CREATION_DATE", nullable=false)
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date creationDate;
    
    @Column(name="CULMINATION_DATE")
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date culminationDate;
    
    @Id
    @Column(name = "USER_ID")
    private Integer userId;
    
    @JoinColumn(name = "STAGE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Stages stageId;
    
    @JoinColumn(name = "TASK_STATE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private TasksStates taskStateId;
    
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Users users;
}
