package com.example.i_recruitment.Controller;

import com.example.i_recruitment.Exception.ResourceNotFoundException;
import com.example.i_recruitment.Model.applicant;
import com.example.i_recruitment.Model.vacancy;
import com.example.i_recruitment.Repository.applicantrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/applicant")
public class ApplicantController {

    @Autowired
    private applicantrepository applicantrepo;

    @GetMapping
    public List<applicant> getallVacancy(){
        return applicantrepo.findAll();
    }

    @PostMapping
    public applicant createApplicant(@RequestBody applicant apc){
        return applicantrepo.save(apc);
    }

    @PutMapping("{id}")
    public ResponseEntity<applicant> updateApplicant(@PathVariable long id,@RequestBody applicant apc) {
        applicant updateApplicant = applicantrepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("applicant not found" + id));
        updateApplicant.setFirstName(apc.getFirstName());
        applicantrepo.save(updateApplicant);
        return ResponseEntity.ok(updateApplicant);
    }

    //get data by id
    @GetMapping("{id}")
    public ResponseEntity<applicant> getallVacancy(@PathVariable long id){
        applicant apc= applicantrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("applicant not found" +id));
        return ResponseEntity.ok(apc);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Map<String,Boolean>>deleteApplicant(@PathVariable Long id){
        applicant apc=applicantrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("not"+id));
        applicantrepo.delete(apc);
        Map<String,Boolean>response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



}
