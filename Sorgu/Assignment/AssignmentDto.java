package com.DataBase.Sorgu.Assignment;

import com.DataBase.Sorgu.Project.ProjectDto;
import com.DataBase.Sorgu.User.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AssignmentDto {
    private Integer id;
    private UserDto userName;
    private ProjectDto projectName;

    public static class Builder{
        private int id;
        private ProjectDto projectName;
        private UserDto userName;

        public Builder(int id, ProjectDto projectName, UserDto userName) {
            this.id = id;
            this.projectName = projectName;
            this.userName = userName;
        }
        public Builder id(int id){
            this.id=id;
            return this;
        }
        public Builder projectName(ProjectDto projectName) {
            this.projectName = projectName;
            return this;
        }
        public Builder userName(UserDto userName) {
            this.userName = userName;
            return this;
        }
        public AssignmentDto build(){
            AssignmentDto assignmentDto=new AssignmentDto();
            assignmentDto.setId(id);
            assignmentDto.setProjectName(projectName);
            assignmentDto.setUserName(userName);
            return build();
        }
    }
}

