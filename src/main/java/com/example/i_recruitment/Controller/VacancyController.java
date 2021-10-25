package com.example.i_recruitment.Controller;

import com.example.i_recruitment.Exception.ResourceNotFoundException;
import com.example.i_recruitment.Model.vacancy;
import com.example.i_recruitment.Repository.vacancyrepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/vacancy")
public class VacancyController {

    @Autowired
    private vacancyrepository vacancyrepo;

    //get all data of the table
    @GetMapping
    public List<vacancy> getAllVacancy(){

        return vacancyrepo.findAll();
    }
    //insert vacancy data
    @PostMapping
    public vacancy createVacancy(@RequestBody vacancy vat){
        return vacancyrepo.save(vat);

    }
    //get data by id
    @GetMapping("{id}")
    public ResponseEntity<vacancy>getVacancyById(@PathVariable long id){
        vacancy vac= vacancyrepo.findById(id).orElseThrow(()-> new  ResourceNotFoundException("vacancy not found" +id));
        return ResponseEntity.ok(vac);
    }
    @PutMapping("{id}")
    public ResponseEntity<vacancy> updateVacancy(@PathVariable long id,@RequestBody vacancy vac){
        vacancy updateVacancy =vacancyrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("vacancy not found" +id));
        updateVacancy.setTitle(vac.getTitle());
        updateVacancy.setJobType(vac.getJobType());
        updateVacancy.setOthersBenefit(vac.getOthersBenefit());
        updateVacancy.setSalMax(vac.getSalMax());
        updateVacancy.setSalMin(vac.getSalMin());
        updateVacancy.setJobLocation(vac.getJobLocation());
        updateVacancy.setExperienceMax(vac.getExperienceMax());
        updateVacancy.setNegotiable(vac.isNegotiable());
        updateVacancy.setRelevantEducation(vac.getRelevantEducation());
        updateVacancy.setVcncyTot(vac.getVcncyTot());
        updateVacancy.setJobNature(vac.getJobNature());
        updateVacancy.setNoExperience(vac.getNoExperience());
        vacancyrepo.save(updateVacancy);
        return ResponseEntity.ok(updateVacancy);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String,Boolean>>deleteVacancy(@PathVariable Long id){
        vacancy vac=vacancyrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("not"+id));
        vacancyrepo.delete(vac);
        Map<String,Boolean>response=new HashMap<>();
        response.put("deleted",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



}
