package com.DataBase.Sorgu.Assignment;

import com.DataBase.Sorgu.Project.Project;
import com.DataBase.Sorgu.Project.ProjectService;
import com.DataBase.Sorgu.Record.Record;
import com.DataBase.Sorgu.Record.RecordRepository;
import com.DataBase.Sorgu.Record.RecordService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("assignment")
public class AssignmentController {
    @Autowired
    AssignmentRepository assignmentRepository;


    @GetMapping("all")
    public ResponseEntity<List<Assignment>> getAllAssignment() {
        try {
            return new ResponseEntity<>(assignmentRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();

    }

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("create")
    public ResponseEntity<Assignment> createAssignment(@RequestBody Assignment assignment) {
        Assignment createdAssignment = assignmentService.createAssignment(assignment);
        return new ResponseEntity<>(createdAssignment, HttpStatus.CREATED);
    }
    @DeleteMapping("delete")
    public ResponseEntity<Void> deleteAssignment(@RequestBody Assignment assignment){
        assignmentRepository.delete(assignment);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("update")
    public ResponseEntity<Assignment> updateAssignment(@RequestBody Assignment assignment){
        Assignment updateAssignment=assignmentService.updateAssignment(assignment);
        if (updateAssignment!=null){
            return new ResponseEntity<>(updateAssignment,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(updateAssignment,HttpStatus.NOT_FOUND);
        }
    }@PostMapping("create1")
    public ResponseEntity<Assignment> createAssignment1(@RequestBody AssignmentDto assignmentDto){
        Assignment createdAssignment1=assignmentService.createAssignment1(assignmentDto);
        return new ResponseEntity<>(createdAssignment1,HttpStatus.CREATED);
    }@GetMapping("/assignmentPage")
    public Page<Assignment> getAssignment(@RequestParam(defaultValue = "0")int page,
                                          @RequestParam(defaultValue = "10")int size){
        PageRequest pageRequest=PageRequest.of(page, size);
        return assignmentRepository.findAll(pageRequest);
    }
    @GetMapping("/assignment/byID")
    public List<Assignment> getAssignmentId(@RequestParam int id){
        return assignmentService.getAssignmentById(id);
    }
}