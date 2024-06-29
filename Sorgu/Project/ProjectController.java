package com.DataBase.Sorgu.Project;

import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("project")
@RestController
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("all")
    public ResponseEntity<List<Project>> getAllProject() {

        try {
            return new ResponseEntity<>(projectRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();

    }

    @Autowired
    private ProjectService projectService;

    @PostMapping("create")
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project createdProject = projectService.createProject(project);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> deleteProject(@RequestBody Project project) {
        projectRepository.delete(project);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("update")
    public ResponseEntity<Project> updateProject(@RequestBody Project project) {
        Project updateProject = projectService.updateProject(project);
        if (updateProject != null) {
            return new ResponseEntity<>(updateProject, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(updateProject, HttpStatus.NOT_FOUND);
        }
    }@PostMapping("creating")
    public ResponseEntity<Project> createProject1(@RequestBody ProjectDto projectDto) {
        Project createProject1 = projectService.createProject1(projectDto);
        return new ResponseEntity<>(createProject1, HttpStatus.CREATED);
    }
    @GetMapping("/projePage")
    public Page<Project> getProject(@RequestParam(defaultValue = "3")int page,
                                    @RequestParam(defaultValue = "5")int size){
        PageRequest pageRequest=PageRequest.of(page,size);

        return projectRepository.findAll(pageRequest);
    }@GetMapping("/users/byName")

    public List<Project> getProjectByName(@RequestParam String name){
        return projectService.getProjectByName(name);
    }
}
