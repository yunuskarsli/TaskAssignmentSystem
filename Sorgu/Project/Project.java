package com.DataBase.Sorgu.Project;

import com.DataBase.Sorgu.User.User;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="project")
public class Project {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "supervisor_id")
    private User supervisor;


}
