package com.DataBase.Sorgu.Assignment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository extends JpaRepository<Assignment, Integer> {
    Assignment findById(int Id);
    Page<Assignment> findAll(Pageable pageable);

}
