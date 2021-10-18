package com.example.i_recruitment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.i_recruitment.Model.vacancy;
@Repository
public interface vacancyrepository extends JpaRepository<vacancy,Long> {

}
