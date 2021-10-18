package com.example.i_recruitment.Repository;

import com.example.i_recruitment.Model.applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface applicantrepository extends JpaRepository<applicant, Long> {

}
