package com.DataBase.Sorgu.Record;

import com.DataBase.Sorgu.Assignment.Assignment;
import com.DataBase.Sorgu.Assignment.AssignmentDto;
import com.DataBase.Sorgu.Assignment.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordService {
    @Autowired
     RecordRepository recordRepository;

    @Autowired
    AssignmentService assignmentService;

    public Record createRecord(Record record) {
        return recordRepository.save(record);
    }

    public Record updateRecord(Record record) {
        return recordRepository.save(record);
    }


    public List<Record> recordList;
    public List<Record> getRecordById(int id){
        return recordList.stream()
                .filter(record -> record.getId()==id)
                .collect(Collectors.toList());
    }

    public Record createRecord1(RecordDto recordDto) {
        Record record = new Record();
        Assignment assignment = assignmentService.find(recordDto.getAssignmentDto().getId());
        record.setDate_(recordDto.getDate_());
        record.setTime(recordDto.getTime());
        record.setAssignment(assignment);

//        //recordDto.getAssignment().setUserName(recordDto.getAssignment().getUserName().getId());
//        recordDto.setAssignment(recordDto.getAssignment().getProjectName().getId());
//       recordDto.setAssignment(recordDto.getAssignment().getUserName().getId());
//        //recordDto.getAssignment().setProjectName(recordDto.getAssignment().getProjectName());
        return recordRepository.save(record);

    }

//    public Record createRecord1(RecordDto recordDto) {
////        AssignmentDto assignmentDto = new AssignmentDto();
//        Record record = new Record();
//        recordDto.setDate_(record.getDate_());
//        recordDto.setTime(record.getTime_());
//        recordDto.getAssignment().setUserName(recordDto.getAssignment().getUserName());
//        // recordDto.setProjectName(recordDto.getAssignment().getProjectName());
//        recordDto.getAssignment().setProjectName(recordDto.getAssignment().getProjectName());
//        return recordRepository.save(record);

    }

