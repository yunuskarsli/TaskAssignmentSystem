package com.DataBase.Sorgu.Assignment;

import com.DataBase.Sorgu.Project.Project;
import com.DataBase.Sorgu.Project.ProjectService;

import com.DataBase.Sorgu.User.User;
import com.DataBase.Sorgu.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignmentService {
    @Autowired
    private AssignmentRepository assignmentRepository;



    public Assignment createAssignment(Assignment assignment){
        return assignmentRepository.save(assignment);
    }
    public Assignment updateAssignment(Assignment assignment){
        return assignmentRepository.save(assignment);
    }
    @Autowired
    UserService userService;
    @Autowired
    ProjectService projectService;

    public Assignment find(Integer id){
        return assignmentRepository.findById(id).get();
    }

    public Assignment createAssignment1(AssignmentDto assignmentDto) {
        Assignment assignment=new Assignment();
        User user= userService.find(assignmentDto.getUserName().getId());
        Project project=projectService.find(assignmentDto.getProjectName().getId());
        assignment.setUser(user);
        assignment.setProject(project);
        return assignmentRepository.save(assignment);

    }private List<Assignment> assignmentsList;
    public List<Assignment> getAssignmentById(int id){
        return assignmentsList.stream()
                .filter(assignment -> assignment.getId()==id)
                .collect(Collectors.toList());
    }

}
