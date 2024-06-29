package com.DataBase.Sorgu.Assignment;

import com.DataBase.Sorgu.Project.Project;
import com.DataBase.Sorgu.User.User;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="assignment_")
public class Assignment {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }


}
