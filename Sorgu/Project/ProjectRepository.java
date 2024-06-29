package com.DataBase.Sorgu.Project;

import com.DataBase.Sorgu.Project.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Integer> {
        Project findById(int id);
        Page<Project> findAll(Pageable pageable);
}
