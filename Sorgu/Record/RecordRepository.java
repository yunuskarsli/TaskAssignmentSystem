package com.DataBase.Sorgu.Record;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record , Integer> {
    Record findById(int Id);
}
