package com.DataBase.Sorgu.Project;

import com.DataBase.Sorgu.User.User;
import com.DataBase.Sorgu.User.UserDto;
import com.DataBase.Sorgu.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public Project find(Integer id){
        return projectRepository.findById(id).get();
    }
    @Autowired
    private UserService userService;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }


        public Project createProject1(ProjectDto projectDto){
            Project project=new Project();
            User supervisor= userService.find(projectDto.getSupervisor().getId());
            project.setName(projectDto.getName());
            project.setSupervisor(supervisor);
            return projectRepository.save(project);
        }
        private List<Project> projectList;
    public List<Project> getProjectByName(String name){
        return projectList.stream()
                .filter(project -> project.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
    }
