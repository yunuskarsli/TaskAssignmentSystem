package com.DataBase.Sorgu.Record;

import com.DataBase.Sorgu.Assignment.AssignmentDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RecordDto {
    private int id;
    private int time;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_;
    private AssignmentDto assignmentDto;

    public static class Builder{


        private int id;
        private int time;
        private LocalDate date_;
        private AssignmentDto assignmentId;

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder time(int time) {
            this.time = time;
            return this;
        }
        public Builder date_(LocalDate date_){
            this.date_=date_;
            return this;
        }
        public Builder assignmentId(AssignmentDto assignmentId){
            this.assignmentId=assignmentId;
            return this;
        }
            public Builder(int id, int time, LocalDate date_, AssignmentDto assignmentId) {
            this.id = id;
            this.time = time;
            this.date_ = date_;
            this.assignmentId = assignmentId;
        }
        public RecordDto build(){
            RecordDto recordDto=new RecordDto();
            recordDto.setId(id);
            recordDto.setTime(time);
            recordDto.setDate_(date_);
            recordDto.setAssignmentDto(assignmentId);
            return recordDto;
        }
    }

}
