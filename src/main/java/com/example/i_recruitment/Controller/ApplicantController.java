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
        updateApplicant.setFirstNameBng(apc.getFirstNameBng());

        updateApplicant.setMiddleName(apc.getMiddleName());
        updateApplicant.setMiddleNameBng(apc.getMiddleNameBng());

        updateApplicant.setLastname(apc.getLastname());
        updateApplicant.setLastNameBng(apc.getLastNameBng());

        updateApplicant.setNickName(apc.getNickName());
        updateApplicant.setNickNameBng(apc.getNickNameBng());

        updateApplicant.setFatherName(apc.getFatherName());
        updateApplicant.setFatherNameBng(apc.getFatherNameBng());

        updateApplicant.setMotherName(apc.getMotherName());
        updateApplicant.setMotherNameBng(apc.getMotherNameBng());

        updateApplicant.setSpouseName(apc.getSpouseName());
        updateApplicant.setSpouseNameBng(apc.getSpouseNameBng());

        updateApplicant.setCareerSummary(apc.getCareerSummary());

        updateApplicant.setTitle(apc.getTitle());
        updateApplicant.setTitleBng(apc.getTitleBng());

        updateApplicant.setNationalIdentityNumber(apc.getNationalIdentityNumber());

        updateApplicant.setExperienceYear(apc.getExperienceYear());

        updateApplicant.setObjective(apc.getObjective());

        updateApplicant.setTinNumber(apc.getTinNumber());

        updateApplicant.setPresentAddress(apc.getPresentAddress());
        updateApplicant.setPermanentAddress(apc.getPermanentAddress());

        updateApplicant.setSalCurr(apc.getSalCurr());
        updateApplicant.setSalExpected(apc.getSalExpected());

       updateApplicant.setDob(apc.getDob());
       updateApplicant.setLastLoginDate(apc.getLastLoginDate());

       updateApplicant.setCv(apc.getCv());
       updateApplicant.setPic(apc.getPic());

       updateApplicant.setCvFileTitle(apc.getCvFileTitle());
       updateApplicant.setCreateDate(apc.getCreateDate());

       updateApplicant.setUpdateDateTime(apc.getUpdateDateTime());

        applicantrepo.save(updateApplicant);
        return ResponseEntity.ok(updateApplicant);
    }

    //get data by id
    @GetMapping("{id}")
    public ResponseEntity<applicant> getApplicantById(@PathVariable long id){
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
