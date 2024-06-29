package com.DataBase.Sorgu.Record;

import com.DataBase.Sorgu.Assignment.Assignment;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name="record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "time_")
    private int time;
    private LocalDate date_;
    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

}
