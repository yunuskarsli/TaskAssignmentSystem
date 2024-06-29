package com.DataBase.Sorgu.Record;

import com.DataBase.Sorgu.Assignment.Assignment;
import com.DataBase.Sorgu.Assignment.AssignmentDto;
import com.DataBase.Sorgu.Assignment.AssignmentMapper;
import com.DataBase.Sorgu.Assignment.AssignmentService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
public class RecordMapper {
    @Autowired
    private AssignmentMapper assignmentMapper;

    //biri paramaetre olarak record alacak recordDto döndürecek
    //recordDto alacak record döndürecek
    @Autowired
    AssignmentService assignmentService;
    public Record mapToRecord(RecordDto recordDto) {
        Record record=new Record();
        record.setDate_(recordDto.getDate_());
        record.setTime(recordDto.getTime());

        Assignment assignment=assignmentMapper.mapToAssignment(recordDto.getAssignmentDto());
        record.setAssignment(assignment);

        return record;


    }public RecordDto mapToRecordDto(Record record){
        RecordDto recordDto=new RecordDto();
        recordDto.setDate_(record.getDate_());
        recordDto.setTime(record.getTime());

        AssignmentDto assignmentDto=assignmentMapper.mapToAssignmentDto(record.getAssignment());
        recordDto.setAssignmentDto(assignmentDto);
        return recordDto;
    }
}
