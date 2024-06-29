package com.DataBase.Sorgu.Project;

import com.DataBase.Sorgu.Record.RecordDto;
import com.DataBase.Sorgu.User.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectDto {
    private int id;
    private String name;
    private UserDto supervisor;

    public static class Builder {
        private int id;
        private String name;
        private UserDto supervisor;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder supervisor(UserDto supervisor) {
            this.supervisor = supervisor;
            return this;
        }

        public Builder(int id, String name, UserDto supervisor) {
            this.id = id;
            this.name = name;
            this.supervisor = supervisor;
        }
        public ProjectDto build(){
            ProjectDto projectDto=new ProjectDto();
            projectDto.setId(id);
            projectDto.setName(name);
            projectDto.setSupervisor(supervisor);
            return projectDto;
        }
    }
}

