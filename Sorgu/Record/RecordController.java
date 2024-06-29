package com.DataBase.Sorgu.Record;

import com.DataBase.Sorgu.Assignment.AssignmentDto;
import com.DataBase.Sorgu.Project.Project;
import com.DataBase.Sorgu.Project.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("record")
public class RecordController {
    @Autowired
    RecordRepository recordRepository;
    @GetMapping("all")
    public ResponseEntity<List<Record>> getAllRecord() {
        try {
            return new ResponseEntity<>(recordRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.notFound().build();
    }
    @Autowired
    private RecordService recordService;
    @PostMapping("create")
    public ResponseEntity<Record> createRecord(@RequestBody Record record) {
        Record cratedRecord = recordService.createRecord(record);
        return new ResponseEntity<>(cratedRecord, HttpStatus.CREATED);
    }
    @DeleteMapping("delete")
    public ResponseEntity<Void> deleteRecord(@RequestBody Record record){
        recordRepository.delete(record);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("update")
    public ResponseEntity<Record> updateRecord(@RequestBody Record record){
        Record updateRecord=recordService.updateRecord(record);
        if (updateRecord!=null){
            return new ResponseEntity<>(updateRecord,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(updateRecord, HttpStatus.NOT_FOUND);
        }
    }@PostMapping("create1")
public ResponseEntity<Record> createRecord1(@RequestBody RecordDto recordDto){
    Record createRecord1=recordService.createRecord1(recordDto);
        return new ResponseEntity<>(createRecord1,HttpStatus.CREATED);
    }@GetMapping("/recordPage")
    public Page<Record> getRecord(@RequestParam(defaultValue = "0")int page,
                                  @RequestParam(defaultValue = "10")int size){
        PageRequest pageRequest=PageRequest.of(page,size);
        return recordRepository.findAll(pageRequest);
    }@GetMapping("/record/byAssignmentId")
    public List<Record> getAssignmentById(@RequestParam int id){
        return recordService.getRecordById(id);
    }
}
