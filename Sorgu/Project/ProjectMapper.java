package com.DataBase.Sorgu.Project;

import com.DataBase.Sorgu.User.User;
import com.DataBase.Sorgu.User.UserDto;
import com.DataBase.Sorgu.User.UserMapper;

public class ProjectMapper {
    public static ProjectDto mapToProjectDto(Project project) {
        UserDto userDto= UserMapper.mapToUserDto(project.getSupervisor());

        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setName(project.getName());
        projectDto.setSupervisor(userDto);
        return projectDto;
    }

    public static Project mapToProject(ProjectDto projectDto) {
        Project project = new Project();
        User user=UserMapper.mapToUser(projectDto.getSupervisor());
        project.setId(projectDto.getId());
        project.setName(projectDto.getName());

        project.setSupervisor(user);
        return project;
    }


}
