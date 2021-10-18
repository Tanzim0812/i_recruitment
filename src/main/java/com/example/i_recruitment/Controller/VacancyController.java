package com.example.i_recruitment.Controller;

import com.example.i_recruitment.Exception.ResourceNotFoundException;
import com.example.i_recruitment.Model.vacancy;
import com.example.i_recruitment.Repository.vacancyrepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        updateVacancy.setJobLocation(vac.getJobLocation());
        updateVacancy.setExperienceMax(vac.getExperienceMax());
        vacancyrepo.save(updateVacancy);
        return ResponseEntity.ok(updateVacancy);
    }

    @DeleteMapping("{id}")
    public String deleteVacancy(@PathVariable long id){
        vacancy vac=vacancyrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("not"+id));
        vacancyrepo.delete(vac);
        return "deleted";
    }



}
