package com.example.i_recruitment.Controller;

import com.example.i_recruitment.Model.applicant;
import com.example.i_recruitment.Model.vacancy;
import com.example.i_recruitment.Repository.applicantrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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






}
