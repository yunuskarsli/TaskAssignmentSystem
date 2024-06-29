package com.DataBase.Sorgu.Assignment;

import com.DataBase.Sorgu.Project.Project;
import com.DataBase.Sorgu.Project.ProjectDto;
import com.DataBase.Sorgu.Project.ProjectMapper;
import com.DataBase.Sorgu.User.User;
import com.DataBase.Sorgu.User.UserDto;
import com.DataBase.Sorgu.User.UserMapper;
import org.springframework.stereotype.Component;

@Component
public class AssignmentMapper {
    public AssignmentDto mapToAssignmentDto(Assignment assignment){
        UserDto userDto= UserMapper.mapToUserDto(assignment.getUser());
        ProjectDto projectDto= ProjectMapper.mapToProjectDto(assignment.getProject());

        AssignmentDto assignmentDto=new AssignmentDto();
        assignmentDto.setId(assignment.getId());
        assignmentDto.setUserName(userDto);
        assignmentDto.setProjectName(projectDto);
            return assignmentDto;
        }
    public Assignment mapToAssignment(AssignmentDto assignmentDto){
        Assignment assignment=new Assignment();
        User user=UserMapper.mapToUser(assignmentDto.getUserName());
        Project project=ProjectMapper.mapToProject(assignmentDto.getProjectName());
        assignment.setId(assignmentDto.getId());

//        projectDto.setName(assignmentDto.getProjectName().getName());
//        assignmentDto.setProjectName(projectDto);
//
//        userDto.setName(assignmentDto.getUserName().getName());
//        assignmentDto.setUserName(userDto);



        return assignment;
    }
    }


