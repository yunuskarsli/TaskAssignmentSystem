package com.DataBase.Sorgu.User;

import com.DataBase.Sorgu.Project.Project;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter

@Entity
@Data
@Table(name = "user_")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name ;
    private String soyad;

    public User(Integer id, String name, String soyad) {
        this.id = id;
        this.name = name;
        this.soyad = soyad;
    }


    public User() {

    }
}
